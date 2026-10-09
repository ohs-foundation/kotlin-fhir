#!/usr/bin/env python3
"""Analyze fhir-model multiplatform binary sizes and produce a JSON/Markdown report.

Usage:
    python3 scripts/binary-size-report.py [--output binary-size.json] [--commit-sha SHA]

Scans fhir-model-r4, fhir-model-r4b, fhir-model-r5 artifacts and emits a JSON
file with build/toolchain metadata plus:
  - JVM JAR (.class) counts and sizes (per-category and totals)
  - Android D8 (debug) and R8 (shrunk release) DEX counts and sizes (when Android SDK is present)
  - Web Kotlin/JS (.js) and Kotlin/Wasm (.wasm) sizes (when built, e.g. on R4)
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
MODULE_PACKAGES = {
    "fhir-model-r4": "dev.ohs.fhir.model.r4",
    "fhir-model-r4b": "dev.ohs.fhir.model.r4b",
    "fhir-model-r5": "dev.ohs.fhir.model.r5",
}


# ---------------------------------------------------------------------------
# Category classifier
# ---------------------------------------------------------------------------

def classify(filename: str) -> str:
    """Classify a .class file into a human-readable category."""
    base = filename.rsplit("/", 1)[-1] if "/" in filename else filename

    # Serializer-related
    if "Serializer" in base:
        if "PolymorphicSerializer" in base:
            return "Serializers (Polymorphic)"
        if "$Companion" in base:
            return "Serializers (Companion)"
        return "Serializers"

    # Search params
    if "SearchParams" in base or "/search/" in filename:
        return "SearchParams"

    # Builder
    if "$Builder" in base:
        return "Builders"

    # DefaultImpls (usually choice type interface bridges)
    if "$DefaultImpls" in base:
        return "Choice Types ($DefaultImpls)"

    # Companion on non-serializer classes
    if "$Companion" in base:
        return "Companions"

    # Remaining nested classes — heuristic for choice type subclasses
    # Choice type subclasses are nested inside a sealed interface that is
    # itself nested inside a model class, e.g. Patient$Deceased$Boolean.class
    # We detect them by depth of $ nesting >= 2 and not matching other cats.
    dollar_depth = base.count("$")
    if dollar_depth >= 2:
        return "Choice Type Subclasses"

    # Top-level or single-nested classes (models, backbones, enums, etc.)
    return "Models & Other"


# ---------------------------------------------------------------------------
# Android (D8 / R8) & Web (JS / Wasm) toolchain helpers
# ---------------------------------------------------------------------------

def _find_android_tools() -> tuple[str | None, str | None]:
    """Locate d8.jar (contains both D8 and R8) and android.jar from installed SDK."""
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


def _find_gradle_classpath_jars() -> list[str]:
    """Resolve runtime dependency JARs from Gradle cache for R8 whole-program analysis."""
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
            m
            for m in glob.glob(os.path.join(cache_dir, pattern), recursive=True)
            if not m.endswith("-sources.jar") and not m.endswith("-javadoc.jar")
        ]
        if matches:
            jars.append(sorted(matches)[-1])
    return jars


def _parse_dex_zip(zip_path: str) -> dict:
    """Extract total compressed/uncompressed bytes and DEX header counts from a DEX zip."""
    classes = methods = fields = compressed = uncompressed = 0
    with zipfile.ZipFile(zip_path, "r") as zf:
        for info in zf.infolist():
            if not info.filename.endswith(".dex"):
                continue
            compressed += info.compress_size
            uncompressed += info.file_size
            data = zf.read(info.filename)
            fields += struct.unpack_from("<I", data, 0x50)[0]
            methods += struct.unpack_from("<I", data, 0x58)[0]
            classes += struct.unpack_from("<I", data, 0x60)[0]
    return {
        "total_classes": classes,
        "total_methods": methods,
        "total_fields": fields,
        "total_compressed_bytes": compressed,
        "total_uncompressed_bytes": uncompressed,
    }


def analyze_android_dex(
    jar_path: str,
    module_pkg: str,
    d8_jar: str,
    android_jar: str,
    cp_jars: list[str],
) -> dict:
    """Run D8 (debug DEX) and R8 (shrunk release DEX) against a built JVM JAR."""
    result: dict = {}
    with tempfile.TemporaryDirectory() as tmpdir:
        d8_zip = os.path.join(tmpdir, "d8.zip")
        subprocess.run(
            [
                "java",
                "-Xmx3g",
                "-cp",
                d8_jar,
                "com.android.tools.r8.D8",
                "--release",
                "--min-api",
                "26",
                "--output",
                d8_zip,
                jar_path,
            ],
            check=True,
            capture_output=True,
        )
        result["d8"] = _parse_dex_zip(d8_zip)

        rules_path = os.path.join(tmpdir, "r8.pro")
        Path(rules_path).write_text(
            f"-dontwarn **\n"
            f"-keep class {module_pkg}.Bundle {{ public *; }}\n"
            f"-keep class {module_pkg}.serializers.BundleSerializer {{ *; }}\n",
            encoding="utf-8",
        )
        r8_zip = os.path.join(tmpdir, "r8.zip")
        r8_cmd = [
            "java",
            "-Xmx3g",
            "-cp",
            d8_jar,
            "com.android.tools.r8.R8",
            "--release",
            "--min-api",
            "26",
            "--output",
            r8_zip,
            "--pg-conf",
            rules_path,
            "--lib",
            android_jar,
        ]
        for cp_jar in cp_jars:
            r8_cmd.extend(["--classpath", cp_jar])
        r8_cmd.append(jar_path)
        subprocess.run(r8_cmd, check=True, capture_output=True)
        result["r8"] = _parse_dex_zip(r8_zip)
    return result


def analyze_web_artifacts(mod_dir: str, mod_name: str) -> dict:
    """Measure compiled Kotlin/JS (.js) and Kotlin/Wasm (.wasm) artifacts when present."""
    web: dict = {}
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
    for key, artifact_path in candidates.items():
        if os.path.isfile(artifact_path):
            raw_bytes = Path(artifact_path).read_bytes()
            web[key] = {
                "total_compressed_bytes": len(gzip.compress(raw_bytes, compresslevel=6)),
                "total_uncompressed_bytes": len(raw_bytes),
            }
    return web


# ---------------------------------------------------------------------------
# Metadata & JAR analysis
# ---------------------------------------------------------------------------

def _run_cmd(cmd: list[str], cwd: str) -> str | None:
    try:
        res = subprocess.run(
            cmd,
            cwd=cwd,
            capture_output=True,
            text=True,
            check=True,
            timeout=5,
        )
        out = (res.stdout or res.stderr).strip()
        return out if out else None
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
    repo = os.environ.get("GITHUB_REPOSITORY", "ohs-foundation/kotlin-fhir")
    server_url = os.environ.get("GITHUB_SERVER_URL", "https://github.com")
    run_id = os.environ.get("GITHUB_RUN_ID")

    meta: dict = {
        "timestamp_utc": datetime.now(timezone.utc).strftime("%Y-%m-%dT%H:%M:%SZ"),
    }
    if sha:
        meta["commit_sha"] = sha
    if repo:
        meta["repository"] = repo
    if server_url:
        meta["server_url"] = server_url
    if run_id:
        meta["workflow_run_id"] = run_id

    # Parse Kotlin & kotlinx-serialization versions from gradle/libs.versions.toml
    toml_path = os.path.join(root, "gradle", "libs.versions.toml")
    if os.path.isfile(toml_path):
        toml_text = Path(toml_path).read_text(encoding="utf-8")
        for key, field in [
            ("kotlin", "kotlin_version"),
            ("kotlinx-serialization", "kotlinx_serialization_version"),
        ]:
            m = re.search(rf'^{re.escape(key)}\s*=\s*"([^"]+)"', toml_text, re.M)
            if m:
                meta[field] = m.group(1)

    # Parse Gradle version from gradle-wrapper.properties
    wrapper_path = os.path.join(root, "gradle", "wrapper", "gradle-wrapper.properties")
    if os.path.isfile(wrapper_path):
        wrapper_text = Path(wrapper_path).read_text(encoding="utf-8")
        m = re.search(r"gradle-([0-9.]+)-bin\.zip", wrapper_text)
        if m:
            meta["gradle_version"] = m.group(1)

    # Java version
    java_ver = _run_cmd(["java", "-version"], cwd=root)
    if java_ver:
        meta["java_version"] = java_ver.splitlines()[0]

    return meta


def analyze_jar(jar_path: str) -> dict:
    """Return per-category and total size info for a single JAR."""
    categories: dict[str, dict] = {}
    total_classes = 0
    total_uncompressed = 0
    total_compressed = 0

    with zipfile.ZipFile(jar_path, "r") as zf:
        for info in zf.infolist():
            if not info.filename.endswith(".class"):
                continue
            cat = classify(info.filename)
            if cat not in categories:
                categories[cat] = {
                    "class_count": 0,
                    "uncompressed_bytes": 0,
                    "compressed_bytes": 0,
                }
            categories[cat]["class_count"] += 1
            categories[cat]["uncompressed_bytes"] += info.file_size
            categories[cat]["compressed_bytes"] += info.compress_size
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


def build_report(
    root: str,
    commit_sha: str | None = None,
    skip_android: bool = False,
) -> dict:
    """Build a full multiplatform size report across all fhir-model modules."""
    modules = ["fhir-model-r4", "fhir-model-r4b", "fhir-model-r5"]
    report: dict = {
        METADATA_KEY: collect_metadata(root, commit_sha=commit_sha),
    }

    d8_jar, android_jar = (None, None) if skip_android else _find_android_tools()
    cp_jars = _find_gradle_classpath_jars() if d8_jar else []
    if not skip_android and not d8_jar:
        print("ℹ️  Android SDK build-tools not found; skipping D8/R8 DEX metrics.", file=sys.stderr)

    for mod in modules:
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

        web = analyze_web_artifacts(mod_dir, mod)
        if web:
            entry["web"] = web

        report[mod] = entry
    return report


# ---------------------------------------------------------------------------
# Markdown comparison
# ---------------------------------------------------------------------------

def fmt_bytes(b: int) -> str:
    """Format bytes as human-readable string."""
    if abs(b) >= 1_048_576:
        return f"{b / 1_048_576:.2f} MB"
    if abs(b) >= 1_024:
        return f"{b / 1_024:.1f} KB"
    return f"{b} B"


def fmt_delta(current: int, baseline: int) -> str:
    """Format a delta with sign and percentage, e.g. '-2.24 MB, -13.9%'."""
    delta = current - baseline
    if baseline == 0:
        pct = "new"
    else:
        pct = f"{delta / baseline * 100:+.1f}%"
    sign = "+" if delta > 0 else ""
    return f"{sign}{fmt_bytes(delta)}, {pct}"


def _short_name(mod: str) -> str:
    """Return a short display name for a module, e.g. 'R4'."""
    return mod.replace("fhir-model-", "").upper()


def _module_keys(*reports: dict) -> list[str]:
    """Return sorted module keys across one or more reports, excluding metadata."""
    keys: set[str] = set()
    for r in reports:
        keys.update(k for k in r.keys() if k != METADATA_KEY)
    return sorted(keys)


def _fmt_commit_link(meta: dict | None) -> str | None:
    """Format a commit SHA as a markdown link if available."""
    if not isinstance(meta, dict):
        return None
    sha = meta.get("commit_sha")
    if not sha:
        return None
    short = sha[:7]
    server = meta.get("server_url", "https://github.com").rstrip("/")
    repo = meta.get("repository", "ohs-foundation/kotlin-fhir")
    return f"[`{short}`]({server}/{repo}/commit/{sha})"


def _fmt_classes_cell(cur_cls: int, base_cls: int) -> str:
    """Format a class count comparison cell as 'before -> after (delta, %)' when changed."""
    if cur_cls == base_cls:
        return f"{cur_cls:,}"
    delta = cur_cls - base_cls
    if base_cls != 0:
        return f"{base_cls:,} → {cur_cls:,} ({delta:+,d}, {delta / base_cls * 100:+.1f}%)"
    return f"{base_cls:,} → {cur_cls:,} ({delta:+,d})"


def _fmt_bytes_cell(cur_bytes: int, base_bytes: int) -> str:
    """Format a byte size comparison cell as 'before -> after (delta, %)' when changed."""
    if cur_bytes == base_bytes:
        return fmt_bytes(cur_bytes)
    return f"{fmt_bytes(base_bytes)} → {fmt_bytes(cur_bytes)} ({fmt_delta(cur_bytes, base_bytes)})"


def _render_android_section(
    current: dict,
    baseline: dict | None,
    all_mods: list[str],
) -> list[str]:
    """Render Android D8 (debug) and R8 (release) DEX size tables leniently."""
    mods_with_android = [m for m in all_mods if "android" in (current.get(m) or {})]
    if not mods_with_android:
        return []

    has_baseline_android = baseline is not None and any(
        "android" in (baseline.get(m) or {}) for m in mods_with_android
    )

    lines: list[str] = ["### 🤖 Android (`classes.dex`)\n"]
    if baseline is not None and not has_baseline_android:
        lines.append("*No Android baseline in `main` yet — showing current sizes.*\n")

    lines.append("| Module | Variant | Methods | Compressed | Uncompressed |")
    lines.append("| :--- | :--- | ---: | ---: | ---: |")

    for mod in mods_with_android:
        name = _short_name(mod)
        cur_and = (current.get(mod) or {}).get("android") or {}
        base_and = ((baseline or {}).get(mod) or {}).get("android") or {}

        for variant_key, variant_label in [
            ("d8", "Debug (`D8`)"),
            ("r8", "Release (`R8`)"),
        ]:
            cur_v = cur_and.get(variant_key)
            if not cur_v:
                continue
            base_v = base_and.get(variant_key) if has_baseline_android else None

            if base_v is None:
                m_cell = (
                    f"{cur_v['total_methods']:,} *(new)*"
                    if has_baseline_android
                    else f"{cur_v['total_methods']:,}"
                )
                c_cell = (
                    f"{fmt_bytes(cur_v['total_compressed_bytes'])} *(new)*"
                    if has_baseline_android
                    else fmt_bytes(cur_v["total_compressed_bytes"])
                )
                u_cell = (
                    f"{fmt_bytes(cur_v['total_uncompressed_bytes'])} *(new)*"
                    if has_baseline_android
                    else fmt_bytes(cur_v["total_uncompressed_bytes"])
                )
            else:
                m_cell = _fmt_classes_cell(cur_v["total_methods"], base_v["total_methods"])
                c_cell = _fmt_bytes_cell(
                    cur_v["total_compressed_bytes"],
                    base_v["total_compressed_bytes"],
                )
                u_cell = _fmt_bytes_cell(
                    cur_v["total_uncompressed_bytes"],
                    base_v["total_uncompressed_bytes"],
                )

            lines.append(f"| {name} | {variant_label} | {m_cell} | {c_cell} | {u_cell} |")

    lines.append("")
    return lines


def _render_web_section(
    current: dict,
    baseline: dict | None,
    all_mods: list[str],
) -> list[str]:
    """Render Web (Kotlin/JS and Kotlin/Wasm) artifact size table leniently."""
    mods_with_web = [m for m in all_mods if "web" in (current.get(m) or {})]
    if not mods_with_web:
        return []

    has_baseline_web = baseline is not None and any(
        "web" in (baseline.get(m) or {}) for m in mods_with_web
    )

    lines: list[str] = ["### 🌐 Web (`R4` canary)\n"]
    if baseline is not None and not has_baseline_web:
        lines.append("*No Web baseline in `main` yet — showing current sizes.*\n")

    lines.append("| Module | Target | Gzipped | Uncompressed |")
    lines.append("| :--- | :--- | ---: | ---: |")

    for mod in mods_with_web:
        name = _short_name(mod)
        cur_web = (current.get(mod) or {}).get("web") or {}
        base_web = ((baseline or {}).get(mod) or {}).get("web") or {}

        for target_key, target_label in [
            ("js", "Kotlin/JS (`.js`)"),
            ("wasm", "Kotlin/Wasm (`.wasm`)"),
        ]:
            cur_t = cur_web.get(target_key)
            if not cur_t:
                continue
            base_t = base_web.get(target_key) if has_baseline_web else None

            if base_t is None:
                c_cell = (
                    f"{fmt_bytes(cur_t['total_compressed_bytes'])} *(new)*"
                    if has_baseline_web
                    else fmt_bytes(cur_t["total_compressed_bytes"])
                )
                u_cell = (
                    f"{fmt_bytes(cur_t['total_uncompressed_bytes'])} *(new)*"
                    if has_baseline_web
                    else fmt_bytes(cur_t["total_uncompressed_bytes"])
                )
            else:
                c_cell = _fmt_bytes_cell(
                    cur_t["total_compressed_bytes"],
                    base_t["total_compressed_bytes"],
                )
                u_cell = _fmt_bytes_cell(
                    cur_t["total_uncompressed_bytes"],
                    base_t["total_uncompressed_bytes"],
                )

            lines.append(f"| {name} | {target_label} | {c_cell} | {u_cell} |")

    lines.append("")
    return lines


def compare_markdown(current: dict, baseline: dict) -> str:
    """Generate a concise markdown comparison across all modules and platforms."""
    lines: list[str] = []
    lines.append("## 📦 Binary Size Report\n")

    cur_link = _fmt_commit_link(current.get(METADATA_KEY))
    base_link = _fmt_commit_link(baseline.get(METADATA_KEY))
    if cur_link and base_link:
        lines.append(f"Comparing {cur_link} against baseline {base_link} (`main`)\n")
    elif cur_link:
        lines.append(f"Comparing {cur_link} against cached `main` baseline\n")

    lines.append("### ☕ JVM (`-jvm.jar`)\n")

    all_mods = _module_keys(current, baseline)

    # --- First pass: compute totals ---
    sum_cur_cls = sum_base_cls = 0
    sum_cur_comp = sum_base_comp = 0
    sum_cur_unc = sum_base_unc = 0
    rows: list[tuple] = []  # (name, cur, base)

    for mod in all_mods:
        cur = current.get(mod)
        base = baseline.get(mod)
        name = _short_name(mod)
        rows.append((name, cur, base))

        if cur is not None:
            sum_cur_cls += cur["total_classes"]
            sum_cur_comp += cur["total_compressed_bytes"]
            sum_cur_unc += cur["total_uncompressed_bytes"]
        if base is not None:
            sum_base_cls += base["total_classes"]
            sum_base_comp += base["total_compressed_bytes"]
            sum_base_unc += base["total_uncompressed_bytes"]

    # --- Second pass: emit table ---
    lines.append("| Module | Classes | Compressed | Uncompressed |")
    lines.append("| :--- | ---: | ---: | ---: |")

    for name, cur, base in rows:
        if cur is None:
            lines.append(f"| {name} | *removed* | *removed* | *removed* |")
            continue
        if base is None:
            lines.append(
                f"| {name} | {cur['total_classes']:,} *(new)* "
                f"| {fmt_bytes(cur['total_compressed_bytes'])} *(new)* "
                f"| {fmt_bytes(cur['total_uncompressed_bytes'])} *(new)* |"
            )
            continue

        cc, bc = cur["total_classes"], base["total_classes"]
        c_comp, b_comp = cur["total_compressed_bytes"], base["total_compressed_bytes"]
        c_unc, b_unc = cur["total_uncompressed_bytes"], base["total_uncompressed_bytes"]

        lines.append(
            f"| {name} "
            f"| {_fmt_classes_cell(cc, bc)} "
            f"| {_fmt_bytes_cell(c_comp, b_comp)} "
            f"| {_fmt_bytes_cell(c_unc, b_unc)} |"
        )

    # Combined total row
    delta_comp = sum_cur_comp - sum_base_comp
    if delta_comp < 0:
        indicator = "🟢"
    elif delta_comp == 0:
        indicator = "⚪"
    else:
        indicator = "🔴"

    lines.append(
        f"| **{indicator} Total** "
        f"| **{_fmt_classes_cell(sum_cur_cls, sum_base_cls)}** "
        f"| **{_fmt_bytes_cell(sum_cur_comp, sum_base_comp)}** "
        f"| **{_fmt_bytes_cell(sum_cur_unc, sum_base_unc)}** |"
    )
    lines.append("")

    # --- Per-category breakdown (collapsed, only if anything changed) ---
    any_change = (sum_cur_comp != sum_base_comp or sum_cur_unc != sum_base_unc
                  or sum_cur_cls != sum_base_cls)
    if any_change:
        lines.append("<details><summary>Per-category breakdown</summary>\n")

        for mod in all_mods:
            cur = current.get(mod)
            base = baseline.get(mod)
            if cur is None or base is None:
                continue

            name = _short_name(mod)
            c_comp = cur["total_compressed_bytes"]
            b_comp = base["total_compressed_bytes"]
            c_unc = cur["total_uncompressed_bytes"]
            b_unc = base["total_uncompressed_bytes"]
            mod_cls = cur["total_classes"]
            if c_comp == b_comp and c_unc == b_unc and mod_cls == base["total_classes"]:
                lines.append(f"**{name}**: no change\n")
                continue

            lines.append(f"**{name}**\n")
            lines.append("| Category | Classes | Compressed | Uncompressed |")
            lines.append("| :--- | ---: | ---: | ---: |")

            all_cats = sorted(
                set(
                    list(cur.get("categories", {}).keys())
                    + list(base.get("categories", {}).keys())
                )
            )
            zero = {"class_count": 0, "uncompressed_bytes": 0, "compressed_bytes": 0}
            for cat in all_cats:
                cc = cur.get("categories", {}).get(cat, zero)
                bc = base.get("categories", {}).get(cat, zero)
                c_cls, b_cls = cc["class_count"], bc["class_count"]
                c_cb, b_cb = cc["compressed_bytes"], bc["compressed_bytes"]
                c_ub, b_ub = cc["uncompressed_bytes"], bc["uncompressed_bytes"]

                lines.append(
                    f"| {cat} "
                    f"| {_fmt_classes_cell(c_cls, b_cls)} "
                    f"| {_fmt_bytes_cell(c_cb, b_cb)} "
                    f"| {_fmt_bytes_cell(c_ub, b_ub)} |"
                )
            lines.append("")

        lines.append("</details>\n")

    lines.extend(_render_android_section(current, baseline, all_mods))
    lines.extend(_render_web_section(current, baseline, all_mods))

    return "\n".join(lines)


def standalone_markdown(current: dict) -> str:
    """Generate a standalone markdown report (no baseline comparison)."""
    lines: list[str] = []
    lines.append("## 📦 Binary Size Report\n")
    cur_link = _fmt_commit_link(current.get(METADATA_KEY))
    if cur_link:
        lines.append(f"Commit: {cur_link} (*no baseline from `main` yet — showing absolute sizes*)\n")
    else:
        lines.append("*No baseline from `main` yet — showing absolute sizes.*\n")

    lines.append("### ☕ JVM (`-jvm.jar`)\n")

    all_mods = _module_keys(current)

    # First pass: compute totals
    sum_cls = sum_comp = sum_unc = 0
    for mod in all_mods:
        cur = current[mod]
        sum_cls += cur["total_classes"]
        sum_comp += cur["total_compressed_bytes"]
        sum_unc += cur["total_uncompressed_bytes"]

    # Summary table
    lines.append("| Module | Classes | Compressed | Uncompressed |")
    lines.append("| :--- | ---: | ---: | ---: |")

    for mod in all_mods:
        cur = current[mod]
        name = _short_name(mod)
        cls = cur["total_classes"]
        comp = cur["total_compressed_bytes"]
        unc = cur["total_uncompressed_bytes"]
        lines.append(
            f"| {name} "
            f"| {cls} "
            f"| {fmt_bytes(comp)} "
            f"| {fmt_bytes(unc)} |"
        )

    lines.append(
        f"| **Total** | **{sum_cls}** | **{fmt_bytes(sum_comp)}** | **{fmt_bytes(sum_unc)}** |"
    )
    lines.append("")

    # Category breakdown (collapsed)
    lines.append("<details><summary>Per-category breakdown</summary>\n")
    for mod in all_mods:
        cur = current[mod]
        name = _short_name(mod)
        cats = cur.get("categories", {})
        if not cats:
            continue
        lines.append(f"**{name}**\n")
        lines.append("| Category | Classes | Compressed | Uncompressed |")
        lines.append("| :--- | ---: | ---: | ---: |")
        for cat in sorted(cats.keys()):
            cc = cats[cat]
            lines.append(
                f"| {cat} "
                f"| {cc['class_count']} "
                f"| {fmt_bytes(cc['compressed_bytes'])} "
                f"| {fmt_bytes(cc['uncompressed_bytes'])} |"
            )
        lines.append("")

    lines.append("</details>\n")

    lines.extend(_render_android_section(current, None, all_mods))
    lines.extend(_render_web_section(current, None, all_mods))

    return "\n".join(lines)


# ---------------------------------------------------------------------------
# CLI
# ---------------------------------------------------------------------------

def main():
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

    # Write JSON
    output_path = Path(args.output)
    output_path.parent.mkdir(parents=True, exist_ok=True)
    with open(output_path, "w") as f:
        json.dump(report, f, indent=2)
    print(f"✅ JSON report written to {output_path}", file=sys.stderr)

    # Generate markdown
    if args.compare and os.path.isfile(args.compare):
        with open(args.compare) as f:
            baseline = json.load(f)
        md = compare_markdown(report, baseline)
    else:
        if args.compare:
            print(
                f"⚠️  Baseline not found at {args.compare}, generating standalone report",
                file=sys.stderr,
            )
        md = standalone_markdown(report)

    # Output markdown
    if args.markdown_output:
        md_path = Path(args.markdown_output)
        md_path.parent.mkdir(parents=True, exist_ok=True)
        with open(md_path, "w") as f:
            f.write(md)
        print(f"✅ Markdown report written to {md_path}", file=sys.stderr)
    else:
        print(md)


if __name__ == "__main__":
    main()
