#!/usr/bin/env python3
"""Analyze fhir-model JVM JAR binary sizes and produce a JSON report.

Usage:
    python3 scripts/binary-size-report.py [--output binary-size.json] [--commit-sha SHA]

Scans fhir-model-r4, fhir-model-r4b, fhir-model-r5 JVM JARs and emits a JSON
file with build/toolchain metadata plus total and per-category .class file
counts and sizes (uncompressed and compressed). The optional --compare flag
takes a baseline JSON and prints a markdown diff table to stdout.
"""

from __future__ import annotations

import argparse
from datetime import datetime, timezone
import json
import os
import re
import subprocess
import sys
import zipfile
from pathlib import Path

METADATA_KEY = "metadata"


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


def build_report(root: str, commit_sha: str | None = None) -> dict:
    """Build a full report for all fhir-model modules."""
    modules = ["fhir-model-r4", "fhir-model-r4b", "fhir-model-r5"]
    report: dict = {
        METADATA_KEY: collect_metadata(root, commit_sha=commit_sha),
    }
    for mod in modules:
        jar = os.path.join(root, mod, "build", "libs", f"{mod}-jvm.jar")
        if os.path.isfile(jar):
            report[mod] = analyze_jar(jar)
        else:
            print(f"⚠️  JAR not found, skipping: {jar}", file=sys.stderr)
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


def compare_markdown(current: dict, baseline: dict) -> str:
    """Generate a concise markdown comparison across all modules."""
    lines: list[str] = []
    lines.append("## 📦 JVM Binary Size Report\n")

    cur_link = _fmt_commit_link(current.get(METADATA_KEY))
    base_link = _fmt_commit_link(baseline.get(METADATA_KEY))
    if cur_link and base_link:
        lines.append(f"Comparing {cur_link} against baseline {base_link} (`main`)\n")
    elif cur_link:
        lines.append(f"Comparing {cur_link} against cached `main` baseline\n")

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

    return "\n".join(lines)


def standalone_markdown(current: dict) -> str:
    """Generate a standalone markdown report (no baseline comparison)."""
    lines: list[str] = []
    lines.append("## 📦 JVM Binary Size Report\n")
    cur_link = _fmt_commit_link(current.get(METADATA_KEY))
    if cur_link:
        lines.append(f"Commit: {cur_link} (*no baseline from `main` yet — showing absolute sizes*)\n")
    else:
        lines.append("*No baseline from `main` yet — showing absolute sizes.*\n")

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
    args = parser.parse_args()

    report = build_report(args.root, commit_sha=args.commit_sha)

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
