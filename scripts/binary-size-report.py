#!/usr/bin/env python3
"""Analyze fhir-model multiplatform binary sizes and produce a JSON/Markdown report.

Usage:
    python3 scripts/binary-size-report.py [--output binary-size.json] [--commit-sha SHA]

Scans fhir-model-r4, fhir-model-r4b, fhir-model-r5 artifacts and emits a JSON
file with build/toolchain metadata plus:
  - JVM JAR (.class) counts and sizes (per-category and totals)
  - Android D8 (debug) and R8 (shrunk release) DEX counts and sizes (when Android SDK is present)
  - Kotlin/JS (.js) and Kotlin/Wasm (.wasm) sizes (when built)
The optional --compare flag takes a baseline JSON and prints a lenient markdown diff table.
"""

from __future__ import annotations

import argparse
from datetime import datetime, timezone
import glob
import gzip
import json
import os
import re
import struct
import subprocess
import sys
import tempfile
import zipfile
from pathlib import Path

METADATA_KEY = "metadata"
MODULES = ("fhir-model-r4", "fhir-model-r4b", "fhir-model-r5")
MODULE_PACKAGES = {
    mod: f"dev.ohs.fhir.model.{mod.removeprefix('fhir-model-')}" for mod in MODULES
}

ANDROID_MIN_API = "26"
DEX_FIELD_IDS_OFFSET = 0x50
DEX_METHOD_IDS_OFFSET = 0x58
DEX_CLASS_DEFS_OFFSET = 0x60


# ---------------------------------------------------------------------------
# JVM .class classification & JAR analysis
# ---------------------------------------------------------------------------

def classify_class_entry(filename: str) -> str:
    """Classify a .class file path inside a JAR into a human-readable category."""
    base = filename.rsplit("/", 1)[-1] if "/" in filename else filename

    if "Serializer" in base:
        if "PolymorphicSerializer" in base:
            return "Serializers (Polymorphic)"
        if "$Companion" in base:
            return "Serializers (Companion)"
        return "Serializers"

    if "SearchParams" in base or "/search/" in filename:
        return "SearchParams"

    if "$Builder" in base:
        return "Builders"

    if "$DefaultImpls" in base:
        return "Choice Types ($DefaultImpls)"

    if "$Companion" in base:
        return "Companions"

    # Choice type subclasses are nested inside a sealed interface inside a model
    # class (e.g. Patient$Deceased$Boolean.class), giving $ depth >= 2.
    if base.count("$") >= 2:
        return "Choice Type Subclasses"

    return "Models & Other"


def analyze_jar(jar_path: str) -> dict:
    """Return per-category and total size metrics for a single JVM JAR."""
    categories: dict[str, dict] = {}
    total_classes = total_uncompressed = total_compressed = 0

    with zipfile.ZipFile(jar_path, "r") as zf:
        for info in zf.infolist():
            if not info.filename.endswith(".class"):
                continue
            cat = classify_class_entry(info.filename)
            bucket = categories.setdefault(
                cat,
                {"class_count": 0, "uncompressed_bytes": 0, "compressed_bytes": 0},
            )
            bucket["class_count"] += 1
            bucket["uncompressed_bytes"] += info.file_size
            bucket["compressed_bytes"] += info.compress_size
            total_classes += 1
            total_uncompressed += info.file_size
            total_compressed += info.compress_size

    return {
        "jar_compressed_bytes": os.path.getsize(jar_path),
        "total_classes": total_classes,
        "total_uncompressed_bytes": total_uncompressed,
        "total_compressed_bytes": total_compressed,
        "categories": dict(sorted(categories.items())),
    }


# ---------------------------------------------------------------------------
# Android (D8 / R8) & JS / Wasm analyzers
# ---------------------------------------------------------------------------

def _find_android_sdk_jars() -> tuple[str | None, str | None]:
    """Locate d8.jar (contains D8 and R8) and android.jar from the Android SDK."""
    sdk_candidates = [
        os.environ.get("ANDROID_HOME"),
        os.environ.get("ANDROID_SDK_ROOT"),
        os.path.expanduser("~/Library/Android/sdk"),
        "/usr/local/lib/android/sdk",
        os.path.expanduser("~/Android/Sdk"),
    ]
    for sdk in sdk_candidates:
        if not sdk or not os.path.isdir(sdk):
            continue
        d8_jars = sorted(glob.glob(os.path.join(sdk, "build-tools", "*", "lib", "d8.jar")))
        android_jars = sorted(glob.glob(os.path.join(sdk, "platforms", "android-*", "android.jar")))
        if d8_jars and android_jars:
            return d8_jars[-1], android_jars[-1]
    return None, None


def _find_r8_classpath_jars() -> list[str]:
    """Resolve runtime dependency JARs from Gradle cache for R8 class-hierarchy analysis."""
    gradle_home = os.environ.get("GRADLE_USER_HOME") or os.path.expanduser("~/.gradle")
    cache_dir = os.path.join(gradle_home, "caches", "modules-2", "files-2.1")
    if not os.path.isdir(cache_dir):
        return []

    patterns = [
        "org.jetbrains.kotlin/kotlin-stdlib/**/kotlin-stdlib-*.jar",
        "org.jetbrains.kotlinx/kotlinx-serialization-core-jvm/**/kotlinx-serialization-core-jvm-*.jar",
        "org.jetbrains.kotlinx/kotlinx-serialization-json-jvm/**/kotlinx-serialization-json-jvm-*.jar",
        "org.jetbrains.kotlinx/kotlinx-datetime-jvm/**/kotlinx-datetime-jvm-*.jar",
        "com.ionspin.kotlin/bignum-jvm/**/bignum-jvm-*.jar",
    ]
    jars: list[str] = []
    for pattern in patterns:
        matches = [
            path
            for path in glob.glob(os.path.join(cache_dir, pattern), recursive=True)
            if not path.endswith(("-sources.jar", "-javadoc.jar"))
        ]
        if matches:
            jars.append(sorted(matches)[-1])
    return jars


def _parse_dex_zip(zip_path: str) -> dict:
    """Sum compressed/uncompressed bytes and DEX header counts across all .dex entries."""
    classes = methods = fields = compressed = uncompressed = 0
    with zipfile.ZipFile(zip_path, "r") as zf:
        for info in zf.infolist():
            if not info.filename.endswith(".dex"):
                continue
            compressed += info.compress_size
            uncompressed += info.file_size
            data = zf.read(info.filename)
            fields += struct.unpack_from("<I", data, DEX_FIELD_IDS_OFFSET)[0]
            methods += struct.unpack_from("<I", data, DEX_METHOD_IDS_OFFSET)[0]
            classes += struct.unpack_from("<I", data, DEX_CLASS_DEFS_OFFSET)[0]
    return {
        "total_classes": classes,
        "total_methods": methods,
        "total_fields": fields,
        "total_compressed_bytes": compressed,
        "total_uncompressed_bytes": uncompressed,
    }


def _run_d8(jar_path: str, d8_jar: str, out_zip: str) -> dict:
    """Compile a JVM JAR to unshrunk release DEX via D8 and return parsed metrics."""
    subprocess.run(
        [
            "java",
            "-Xmx3g",
            "-cp",
            d8_jar,
            "com.android.tools.r8.D8",
            "--release",
            "--min-api",
            ANDROID_MIN_API,
            "--output",
            out_zip,
            jar_path,
        ],
        check=True,
        capture_output=True,
    )
    return _parse_dex_zip(out_zip)


def _run_r8(
    jar_path: str,
    module_pkg: str,
    d8_jar: str,
    android_jar: str,
    cp_jars: list[str],
    tmpdir: str,
) -> dict:
    """Shrink and optimize a JVM JAR to release DEX via R8 and return parsed metrics."""
    rules_path = os.path.join(tmpdir, "r8.pro")
    Path(rules_path).write_text(
        f"-dontwarn **\n"
        f"-keep class {module_pkg}.Bundle {{ public *; }}\n"
        f"-keep class {module_pkg}.serializers.BundleSerializer {{ *; }}\n",
        encoding="utf-8",
    )
    out_zip = os.path.join(tmpdir, "r8.zip")
    cmd = [
        "java",
        "-Xmx3g",
        "-cp",
        d8_jar,
        "com.android.tools.r8.R8",
        "--release",
        "--min-api",
        ANDROID_MIN_API,
        "--output",
        out_zip,
        "--pg-conf",
        rules_path,
        "--lib",
        android_jar,
    ]
    for cp_jar in cp_jars:
        cmd.extend(["--classpath", cp_jar])
    cmd.append(jar_path)
    subprocess.run(cmd, check=True, capture_output=True)
    return _parse_dex_zip(out_zip)


def analyze_android_dex(
    jar_path: str,
    module_pkg: str,
    d8_jar: str,
    android_jar: str,
    cp_jars: list[str],
) -> dict:
    """Measure D8 (debug) and R8 (release) DEX metrics for a single module JAR."""
    with tempfile.TemporaryDirectory() as tmpdir:
        return {
            "d8": _run_d8(jar_path, d8_jar, os.path.join(tmpdir, "d8.zip")),
            "r8": _run_r8(jar_path, module_pkg, d8_jar, android_jar, cp_jars, tmpdir),
        }


def analyze_web_artifacts(mod_dir: str, mod_name: str) -> dict:
    """Measure compiled Kotlin/JS (.js) and Kotlin/Wasm (.wasm) artifacts when present."""
    candidates = {
        "js": os.path.join(
            mod_dir,
            "build",
            "compileSync",
            "js",
            "main",
            "developmentLibrary",
            "kotlin",
            f"kotlin-fhir-{mod_name}.js",
        ),
        "wasm": os.path.join(
            mod_dir,
            "build",
            "compileSync",
            "wasmWasi",
            "main",
            "developmentLibrary",
            "kotlin",
            f"kotlin-fhir-{mod_name}.wasm",
        ),
    }
    web: dict = {}
    for target, artifact_path in candidates.items():
        if os.path.isfile(artifact_path):
            raw_bytes = Path(artifact_path).read_bytes()
            web[target] = {
                "total_compressed_bytes": len(gzip.compress(raw_bytes, compresslevel=6)),
                "total_uncompressed_bytes": len(raw_bytes),
            }
    return web


# ---------------------------------------------------------------------------
# Metadata & report builder
# ---------------------------------------------------------------------------

def _run_cmd(cmd: list[str], cwd: str) -> str | None:
    try:
        res = subprocess.run(cmd, cwd=cwd, capture_output=True, text=True, check=True, timeout=5)
        out = (res.stdout or res.stderr).strip()
        return out or None
    except Exception:
        return None


def collect_metadata(root: str, commit_sha: str | None = None) -> dict:
    """Collect git and toolchain metadata for reproducibility."""
    sha = (
        commit_sha
        or os.environ.get("COMMIT_SHA")
        or os.environ.get("GITHUB_SHA")
        or _run_cmd(["git", "rev-parse", "HEAD"], cwd=root)
    )
    meta: dict = {
        "timestamp_utc": datetime.now(timezone.utc).strftime("%Y-%m-%dT%H:%M:%SZ"),
    }
    if sha:
        meta["commit_sha"] = sha
    if repo := os.environ.get("GITHUB_REPOSITORY", "ohs-foundation/kotlin-fhir"):
        meta["repository"] = repo
    if server_url := os.environ.get("GITHUB_SERVER_URL", "https://github.com"):
        meta["server_url"] = server_url
    if run_id := os.environ.get("GITHUB_RUN_ID"):
        meta["workflow_run_id"] = run_id

    toml_path = os.path.join(root, "gradle", "libs.versions.toml")
    if os.path.isfile(toml_path):
        toml_text = Path(toml_path).read_text(encoding="utf-8")
        for key, field in [
            ("kotlin", "kotlin_version"),
            ("kotlinx-serialization", "kotlinx_serialization_version"),
        ]:
            if m := re.search(rf'^{re.escape(key)}\s*=\s*"([^"]+)"', toml_text, re.M):
                meta[field] = m.group(1)

    wrapper_path = os.path.join(root, "gradle", "wrapper", "gradle-wrapper.properties")
    if os.path.isfile(wrapper_path):
        wrapper_text = Path(wrapper_path).read_text(encoding="utf-8")
        if m := re.search(r"gradle-([0-9.]+)-bin\.zip", wrapper_text):
            meta["gradle_version"] = m.group(1)

    if java_ver := _run_cmd(["java", "-version"], cwd=root):
        meta["java_version"] = java_ver.splitlines()[0]

    return meta


def build_report(
    root: str,
    commit_sha: str | None = None,
    skip_android: bool = False,
) -> dict:
    """Build a multiplatform size report across all fhir-model modules."""
    report: dict = {
        METADATA_KEY: collect_metadata(root, commit_sha=commit_sha),
    }

    d8_jar, android_jar = (None, None) if skip_android else _find_android_sdk_jars()
    cp_jars = _find_r8_classpath_jars() if d8_jar else []
    if not skip_android and not d8_jar:
        print("ℹ️  Android SDK build-tools not found; skipping D8/R8 DEX metrics.", file=sys.stderr)

    for mod in MODULES:
        mod_dir = os.path.join(root, mod)
        jar = os.path.join(mod_dir, "build", "libs", f"{mod}-jvm.jar")
        if not os.path.isfile(jar):
            print(f"⚠️  JAR not found, skipping: {jar}", file=sys.stderr)
            continue

        entry = analyze_jar(jar)
        if d8_jar and android_jar:
            try:
                entry["android"] = analyze_android_dex(
                    jar_path=jar,
                    module_pkg=MODULE_PACKAGES[mod],
                    d8_jar=d8_jar,
                    android_jar=android_jar,
                    cp_jars=cp_jars,
                )
            except Exception as exc:
                print(f"⚠️  Android D8/R8 analysis failed for {mod}: {exc}", file=sys.stderr)

        if web := analyze_web_artifacts(mod_dir, mod):
            entry["web"] = web

        report[mod] = entry
    return report


# ---------------------------------------------------------------------------
# Markdown formatting & unified table renderer
# ---------------------------------------------------------------------------

def fmt_bytes(b: int) -> str:
    """Format byte count as a human-readable string (MB / KB / B)."""
    if abs(b) >= 1_048_576:
        return f"{b / 1_048_576:.2f} MB"
    if abs(b) >= 1_024:
        return f"{b / 1_024:.1f} KB"
    return f"{b} B"


def fmt_delta(current: int, baseline: int) -> str:
    """Format a byte delta with sign and percentage, e.g. '-2.24 MB, -13.9%'."""
    delta = current - baseline
    pct = "new" if baseline == 0 else f"{delta / baseline * 100:+.1f}%"
    sign = "+" if delta > 0 else ""
    return f"{sign}{fmt_bytes(delta)}, {pct}"


def _short_name(mod: str) -> str:
    return mod.removeprefix("fhir-model-").upper()


def _module_keys(*reports: dict) -> list[str]:
    keys: set[str] = set()
    for r in reports:
        keys.update(k for k in r.keys() if k != METADATA_KEY)
    return sorted(keys)


def _fmt_commit_link(meta: dict | None) -> str | None:
    if not isinstance(meta, dict) or not (sha := meta.get("commit_sha")):
        return None
    server = meta.get("server_url", "https://github.com").rstrip("/")
    repo = meta.get("repository", "ohs-foundation/kotlin-fhir")
    return f"[`{sha[:7]}`]({server}/{repo}/commit/{sha})"


def _fmt_count_cell(cur: int, base: int | None, is_new: bool = False) -> str:
    if base is None:
        return f"{cur:,} *(new)*" if is_new else f"{cur:,}"
    if cur == base:
        return f"{cur:,} (+0, 0.0%)"
    delta = cur - base
    if base != 0:
        return f"{base:,} → {cur:,} ({delta:+,d}, {delta / base * 100:+.1f}%)"
    return f"{base:,} → {cur:,} ({delta:+,d})"


def _fmt_bytes_cell(cur: int, base: int | None, is_new: bool = False) -> str:
    if base is None:
        return f"{fmt_bytes(cur)} *(new)*" if is_new else fmt_bytes(cur)
    if cur == base:
        return f"{fmt_bytes(cur)} (+0 B, 0.0%)"
    return f"{fmt_bytes(base)} → {fmt_bytes(cur)} ({fmt_delta(cur, base)})"


def _status_indicator(cur_bytes: int, base_bytes: int) -> str:
    delta = cur_bytes - base_bytes
    if delta < 0:
        return "🟢"
    if delta == 0:
        return "⚪"
    return "🔴"


def _render_size_table(
    rows: list[tuple[str, dict | None, dict | None]],
    first_col: str,
    comp_col: tuple[str, str],
    uncomp_col: tuple[str, str],
    count_col: tuple[str, str] | None = None,
    has_baseline: bool = False,
    include_total: bool = True,
) -> list[str]:
    """Render a markdown metric table with optional count column and summary Total row."""
    if not rows:
        return []

    comp_header, comp_key = comp_col
    uncomp_header, uncomp_key = uncomp_col
    count_header, count_key = count_col if count_col else ("", "")

    headers = [first_col] + ([count_header] if count_col else []) + [comp_header, uncomp_header]
    aligns = [":---"] + ["---:"] * (len(headers) - 1)
    lines = [
        f"| {' | '.join(headers)} |",
        f"| {' | '.join(aligns)} |",
    ]

    sum_cur_cnt = sum_base_cnt = 0
    sum_cur_comp = sum_base_comp = 0
    sum_cur_unc = sum_base_unc = 0

    for label, cur, base in rows:
        if cur is None:
            removed_cols = ["*removed*"] * (len(headers) - 1)
            lines.append(f"| {label} | {' | '.join(removed_cols)} |")
            if base is not None:
                if count_col:
                    sum_base_cnt += base[count_key]
                sum_base_comp += base[comp_key]
                sum_base_unc += base[uncomp_key]
            continue

        is_new = has_baseline and base is None
        cur_comp = cur[comp_key]
        cur_unc = cur[uncomp_key]
        sum_cur_comp += cur_comp
        sum_cur_unc += cur_unc

        cells = [label]
        if count_col:
            cur_cnt = cur[count_key]
            base_cnt = base[count_key] if base is not None else None
            sum_cur_cnt += cur_cnt
            if base_cnt is not None:
                sum_base_cnt += base_cnt
            cells.append(_fmt_count_cell(cur_cnt, base_cnt, is_new=is_new))

        base_comp = base[comp_key] if base is not None else None
        base_unc = base[uncomp_key] if base is not None else None
        if base_comp is not None:
            sum_base_comp += base_comp
        if base_unc is not None:
            sum_base_unc += base_unc

        cells.append(_fmt_bytes_cell(cur_comp, base_comp, is_new=is_new))
        cells.append(_fmt_bytes_cell(cur_unc, base_unc, is_new=is_new))
        lines.append(f"| {' | '.join(cells)} |")

    if include_total:
        can_diff_total = has_baseline and all(
            base is not None for _, cur, base in rows if cur is not None
        )
        total_label = (
            f"**{_status_indicator(sum_cur_comp, sum_base_comp)} Total**"
            if can_diff_total
            else "**Total**"
        )
        total_cells = [total_label]
        if count_col:
            cnt_txt = _fmt_count_cell(sum_cur_cnt, sum_base_cnt if can_diff_total else None)
            total_cells.append(f"**{cnt_txt}**")
        comp_txt = _fmt_bytes_cell(sum_cur_comp, sum_base_comp if can_diff_total else None)
        unc_txt = _fmt_bytes_cell(sum_cur_unc, sum_base_unc if can_diff_total else None)
        total_cells.extend([f"**{comp_txt}**", f"**{unc_txt}**"])
        lines.append(f"| {' | '.join(total_cells)} |")

    lines.append("")
    return lines


def _extract_target_totals(
    report: dict | None,
    mods: list[str],
    section_key: str | None,
    sub_key: str | None,
) -> tuple[int, int] | None:
    """Sum compressed and uncompressed bytes for a platform across all modules, if present."""
    if report is None:
        return None
    comp = uncomp = 0
    found = 0
    for mod in mods:
        entry = report.get(mod) or {}
        target = entry if section_key is None else (entry.get(section_key) or {}).get(sub_key)
        if not target:
            continue
        comp += target["total_compressed_bytes"]
        uncomp += target["total_uncompressed_bytes"]
        found += 1
    if found == 0 or found < len(mods):
        return None
    return comp, uncomp


def _render_headline_table(
    current: dict,
    baseline: dict | None,
    all_mods: list[str],
) -> list[str]:
    """Render a compact headline summary table across all measured platforms."""
    targets = [
        ("JVM (`-jvm.jar`)", None, None),
        ("Android Debug (`D8`)", "android", "d8"),
        ("Android Release (`R8`)", "android", "r8"),
        ("Kotlin/JS (`.js`)", "web", "js"),
        ("Kotlin/Wasm (`.wasm`)", "web", "wasm"),
    ]
    lines = [
        "| Platform | Compressed | Uncompressed |",
        "| :--- | ---: | ---: |",
    ]
    has_baseline = baseline is not None

    for label, section_key, sub_key in targets:
        present_mods = [
            m
            for m in all_mods
            if (
                (current.get(m) or {})
                if section_key is None
                else ((current.get(m) or {}).get(section_key) or {}).get(sub_key)
            )
        ]
        if not present_mods:
            continue

        cur_totals = _extract_target_totals(current, present_mods, section_key, sub_key)
        if cur_totals is None:
            continue
        cur_c, cur_u = cur_totals

        base_totals = _extract_target_totals(baseline, present_mods, section_key, sub_key)
        if base_totals is not None:
            base_c, base_u = base_totals
            ind = _status_indicator(cur_c, base_c)
            p_cell = f"{ind} {label}"
            c_cell = _fmt_bytes_cell(cur_c, base_c)
            u_cell = _fmt_bytes_cell(cur_u, base_u)
        else:
            is_new = has_baseline
            p_cell = label
            c_cell = _fmt_bytes_cell(cur_c, None, is_new=is_new)
            u_cell = _fmt_bytes_cell(cur_u, None, is_new=is_new)

        lines.append(f"| {p_cell} | {c_cell} | {u_cell} |")

    lines.append("")
    return lines


def _render_jvm_section(
    current: dict,
    baseline: dict | None,
    all_mods: list[str],
) -> list[str]:
    """Render collapsible JVM module summary and per-category breakdown tables."""
    has_baseline = baseline is not None
    lines = ["<details><summary>☕ JVM (<code>-jvm.jar</code>)</summary>\n"]

    mod_rows = [
        (_short_name(mod), current.get(mod), (baseline or {}).get(mod))
        for mod in all_mods
    ]
    lines.extend(
        _render_size_table(
            rows=mod_rows,
            first_col="Module",
            count_col=("Classes", "total_classes"),
            comp_col=("Compressed", "total_compressed_bytes"),
            uncomp_col=("Uncompressed", "total_uncompressed_bytes"),
            has_baseline=has_baseline,
        )
    )

    zero_cat = {"class_count": 0, "uncompressed_bytes": 0, "compressed_bytes": 0}
    for mod in all_mods:
        cur = current.get(mod)
        base = (baseline or {}).get(mod)
        if cur is None or (has_baseline and base is None):
            continue

        name = _short_name(mod)
        if has_baseline and base is not None:
            unchanged = all(
                cur[k] == base[k]
                for k in ("total_classes", "total_compressed_bytes", "total_uncompressed_bytes")
            )
            if unchanged:
                continue

        all_cats = sorted(
            set(cur.get("categories", {}).keys())
            | (set(base.get("categories", {}).keys()) if base else set())
        )
        if not all_cats:
            continue

        cat_rows = [
            (
                cat,
                cur.get("categories", {}).get(cat, zero_cat),
                base.get("categories", {}).get(cat, zero_cat) if base else None,
            )
            for cat in all_cats
        ]
        lines.append(f"**{name} by category**\n")
        lines.extend(
            _render_size_table(
                rows=cat_rows,
                first_col="Category",
                count_col=("Classes", "class_count"),
                comp_col=("Compressed", "compressed_bytes"),
                uncomp_col=("Uncompressed", "uncompressed_bytes"),
                has_baseline=has_baseline,
                include_total=False,
            )
        )

    lines.append("</details>\n")
    return lines


def _render_subtable_section(
    current: dict,
    baseline: dict | None,
    all_mods: list[str],
    section_key: str,
    summary_label: str,
    subtables: list[tuple[str, str, tuple[str, str] | None, str]],
) -> list[str]:
    """Render a collapsible multi-variant platform section (Android D8/R8 or JS/Wasm)."""
    mods = [m for m in all_mods if section_key in (current.get(m) or {})]
    if not mods:
        return []

    has_sec_baseline = baseline is not None and any(
        section_key in (baseline.get(m) or {}) for m in mods
    )

    lines = [f"<details><summary>{summary_label}</summary>\n"]

    for sub_key, heading, count_col, comp_label in subtables:
        rows = [
            (
                _short_name(mod),
                ((current.get(mod) or {}).get(section_key) or {}).get(sub_key),
                (
                    (((baseline or {}).get(mod) or {}).get(section_key) or {}).get(sub_key)
                    if has_sec_baseline
                    else None
                ),
            )
            for mod in mods
            if ((current.get(mod) or {}).get(section_key) or {}).get(sub_key)
        ]
        if rows:
            lines.append(f"**{heading}**\n")
            lines.extend(
                _render_size_table(
                    rows=rows,
                    first_col="Module",
                    count_col=count_col,
                    comp_col=(comp_label, "total_compressed_bytes"),
                    uncomp_col=("Uncompressed", "total_uncompressed_bytes"),
                    has_baseline=has_sec_baseline,
                )
            )

    lines.append("</details>\n")
    return lines


def _render_android_section(
    current: dict,
    baseline: dict | None,
    all_mods: list[str],
) -> list[str]:
    """Render collapsible Android Debug (D8) and Release (R8) DEX tables."""
    return _render_subtable_section(
        current=current,
        baseline=baseline,
        all_mods=all_mods,
        section_key="android",
        summary_label="🤖 Android (<code>classes.dex</code>)",
        subtables=[
            ("d8", "Debug (`D8`)", ("Methods", "total_methods"), "Compressed"),
            ("r8", "Release (`R8`)", ("Methods", "total_methods"), "Compressed"),
        ],
    )


def _render_web_section(
    current: dict,
    baseline: dict | None,
    all_mods: list[str],
) -> list[str]:
    """Render collapsible Kotlin/JS and Kotlin/Wasm tables."""
    return _render_subtable_section(
        current=current,
        baseline=baseline,
        all_mods=all_mods,
        section_key="web",
        summary_label="🌐 JS / Wasm",
        subtables=[
            ("js", "Kotlin/JS (`.js`)", None, "Gzipped"),
            ("wasm", "Kotlin/Wasm (`.wasm`)", None, "Gzipped"),
        ],
    )


def render_markdown(current: dict, baseline: dict | None = None) -> str:
    """Render the multiplatform Markdown binary size report with headline summary."""
    lines = ["## 📦 Binary Size Report\n"]
    cur_link = _fmt_commit_link(current.get(METADATA_KEY))

    if baseline is not None:
        base_link = _fmt_commit_link(baseline.get(METADATA_KEY))
        if cur_link and base_link:
            lines.append(f"Comparing {cur_link} against baseline {base_link} (`main`)\n")
        elif cur_link:
            lines.append(f"Comparing {cur_link} against cached `main` baseline\n")
        all_mods = _module_keys(current, baseline)
    else:
        if cur_link:
            lines.append(
                f"Commit: {cur_link} (*no baseline from `main` yet — showing absolute sizes*)\n"
            )
        else:
            lines.append("*No baseline from `main` yet — showing absolute sizes.*\n")
        all_mods = _module_keys(current)

    lines.extend(_render_headline_table(current, baseline, all_mods))
    lines.extend(_render_jvm_section(current, baseline, all_mods))
    lines.extend(_render_android_section(current, baseline, all_mods))
    lines.extend(_render_web_section(current, baseline, all_mods))
    return "\n".join(lines)


def compare_markdown(current: dict, baseline: dict) -> str:
    """Generate a Markdown diff report comparing current against baseline."""
    return render_markdown(current, baseline)


def standalone_markdown(current: dict) -> str:
    """Generate a standalone Markdown report without baseline diffs."""
    return render_markdown(current, None)


# ---------------------------------------------------------------------------
# CLI
# ---------------------------------------------------------------------------

def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--root",
        default=os.environ.get("GITHUB_WORKSPACE", "."),
        help="Project root directory (default: GITHUB_WORKSPACE or cwd)",
    )
    parser.add_argument(
        "--output",
        default="binary-size.json",
        help="Path to write the JSON report (default: binary-size.json)",
    )
    parser.add_argument(
        "--compare",
        default=None,
        help="Path to a baseline JSON to compare against",
    )
    parser.add_argument(
        "--markdown-output",
        default=None,
        help="Path to write the markdown report (default: stdout)",
    )
    parser.add_argument(
        "--commit-sha",
        default=None,
        help="Commit SHA being analyzed (default: COMMIT_SHA, GITHUB_SHA, or git rev-parse HEAD)",
    )
    parser.add_argument(
        "--skip-android",
        action="store_true",
        help="Skip Android D8/R8 DEX size analysis",
    )
    args = parser.parse_args()

    report = build_report(
        args.root,
        commit_sha=args.commit_sha,
        skip_android=args.skip_android,
    )

    output_path = Path(args.output)
    output_path.parent.mkdir(parents=True, exist_ok=True)
    output_path.write_text(json.dumps(report, indent=2), encoding="utf-8")
    print(f"✅ JSON report written to {output_path}", file=sys.stderr)

    if args.compare and os.path.isfile(args.compare):
        baseline = json.loads(Path(args.compare).read_text(encoding="utf-8"))
        md = render_markdown(report, baseline)
    else:
        if args.compare:
            print(
                f"⚠️  Baseline not found at {args.compare}, generating standalone report",
                file=sys.stderr,
            )
        md = render_markdown(report)

    if args.markdown_output:
        md_path = Path(args.markdown_output)
        md_path.parent.mkdir(parents=True, exist_ok=True)
        md_path.write_text(md, encoding="utf-8")
        print(f"✅ Markdown report written to {md_path}", file=sys.stderr)
    else:
        print(md)


if __name__ == "__main__":
    main()
