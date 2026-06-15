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
    // before updating it to a range (e.g. 2025-2026). However, generated code do not have the
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