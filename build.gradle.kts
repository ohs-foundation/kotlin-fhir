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
        ktfmt().googleStyle()
        licenseHeaderFile(
            "license-header.txt",
        )
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
tasks.named("spotlessFlexmark") {
    dependsOn(":fhir-model-r4:codegen", ":fhir-model-r4b:codegen", ":fhir-model-r5:codegen")
}