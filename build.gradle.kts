plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.maven.publish) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.spotless)
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    ratchetFrom = "origin/main"

    kotlin {
        target("**/*.kt")
        targetExclude("**/fhir-model-r*/**/*.kt")
        ktfmt().googleStyle()
        licenseHeaderFile(
            "license-header.txt",
        )
    }

    // Due to the ratchetFrom setting, Spotless always tries to parse the existing copyright year
    // before updating it to a range (e.g. 2025-2026). However, generated files do not have the
    // copyright header initially. To avoid warnings, a statically resolved year is used.
    val currentYear = java.time.LocalDate.now().year.toString()
    val licenseHeaderTemplate = file("license-header.txt").readText()
    val generatedLicenseHeader = licenseHeaderTemplate.replace("\$YEAR", currentYear)
    format("generatedKotlin", com.diffplug.gradle.spotless.KotlinExtension::class.java) {
        target("fhir-model-r4/src/**/*.kt", "fhir-model-r4b/src/**/*.kt", "fhir-model-r5/src/**/*.kt")
        ktfmt().googleStyle()
        licenseHeader(generatedLicenseHeader)
    }

    flexmark {
        target("**/*.md")
        flexmark()
    }
}

// Make sure codegen is run before formatting
tasks.named("spotlessKotlin") {
    dependsOn(":fhir-model-r4:codegen", ":fhir-model-r4b:codegen", ":fhir-model-r5:codegen")
}
tasks.named("spotlessGeneratedKotlin") {
    dependsOn(":fhir-model-r4:codegen", ":fhir-model-r4b:codegen", ":fhir-model-r5:codegen")
}
tasks.named("spotlessFlexmark") {
    dependsOn(":fhir-model-r4:codegen", ":fhir-model-r4b:codegen", ":fhir-model-r5:codegen")
}

// ---------------------------------------------------------------------------
// verifyCodegen – regenerate all FHIR models and assert the committed sources
// are byte-for-byte identical with the codegen output.
// Runs codegen (which includes Sync + spotlessApply) then uses `git diff` to
// detect any drift.  A non-empty diff means the committed generated code is
// out of date with respect to the current codegen and will cause a CI failure.
// ---------------------------------------------------------------------------
tasks.register("verifyCodegen") {
    description = "Verify committed generated code matches the codegen output."
    group = "verification"
    dependsOn(":fhir-model-r4:codegen", ":fhir-model-r4b:codegen", ":fhir-model-r5:codegen")

    // Run after the codegen + spotlessApply pipeline has finished
    mustRunAfter("spotlessApply")

    // Capture the root directory as a plain File (serializable) so the doLast
    // closure does not reference any Gradle-model objects, keeping the task
    // compatible with the Gradle configuration cache.
    val rootDir = project.rootDir

    doLast {
        val generatedDirs = listOf(
            "fhir-model-r4/src/commonMain/kotlin",
            "fhir-model-r4b/src/commonMain/kotlin",
            "fhir-model-r5/src/commonMain/kotlin",
        )

        // Check for uncommitted changes in the generated directories
        val diffProcess = ProcessBuilder(
            listOf("git", "diff", "--exit-code", "--") + generatedDirs
        ).directory(rootDir).redirectErrorStream(true).start()

        val diffOutput = diffProcess.inputStream.bufferedReader().readText()
        val diffExitCode = diffProcess.waitFor()

        if (diffExitCode != 0) {
            throw GradleException(
                buildString {
                    appendLine("Codegen verification FAILED – the committed generated sources differ from the codegen output.")
                    appendLine()
                    appendLine("Changed files:")
                    appendLine(diffOutput)
                    appendLine()
                    appendLine("Run `./gradlew :fhir-model-r4:codegen :fhir-model-r4b:codegen :fhir-model-r5:codegen` locally and commit the result.")
                }
            )
        }

        // Also check for untracked files that codegen may have added
        val untrackedProcess = ProcessBuilder(
            listOf("git", "ls-files", "--others", "--exclude-standard", "--") + generatedDirs
        ).directory(rootDir).redirectErrorStream(true).start()

        val untrackedFiles = untrackedProcess.inputStream.bufferedReader().readText().trim()
        untrackedProcess.waitFor()

        if (untrackedFiles.isNotEmpty()) {
            throw GradleException(
                buildString {
                    appendLine("Codegen verification FAILED – codegen produced new files not present in the repository.")
                    appendLine()
                    appendLine("Untracked files:")
                    appendLine(untrackedFiles)
                    appendLine()
                    appendLine("Run `./gradlew :fhir-model-r4:codegen :fhir-model-r4b:codegen :fhir-model-r5:codegen` locally and commit the result.")
                }
            )
        }

        logger.lifecycle("✅ Codegen verification passed – all generated sources are up to date.")
    }
}