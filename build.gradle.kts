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

    // Generated files start with no copyright header. When Spotless runs, it tries to parse a year
    // from the (empty) header of these files to preserve it, causing warning spam. To avoid this,
    // we resolve the year at build time and pass it statically to Spotless for generated files.
    val currentYear = java.time.LocalDate.now().year.toString()
    val licenseHeaderTemplate = file("license-header.txt").readText()
    val generatedLicenseHeader = licenseHeaderTemplate.replace("\$YEAR", currentYear)

    kotlin {
        target("**/*.kt")
        targetExclude("**/fhir-model-r*/**/*.kt")
        ktfmt().googleStyle()
        licenseHeaderFile(
            "license-header.txt",
        )
    }
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