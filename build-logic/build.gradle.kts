plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    // Plugin implementation JARs — these allow the convention plugin to apply
    // and configure these Gradle plugins on consumer projects.
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.serialization.plugin)
    implementation(libs.ksp.gradle.plugin)
    implementation(libs.maven.publish.plugin)
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
}

configure<GradlePluginDevelopmentExtension> {
    plugins {
        create("fhirModelConventions") {
            id = "fhir-model-conventions"
            implementationClass = "dev.ohs.fhir.build.FhirModelConventionsPlugin"
        }
    }
}
