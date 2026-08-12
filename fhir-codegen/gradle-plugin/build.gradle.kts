plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
    `java-gradle-plugin`
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    api(libs.bignum)
    api(libs.kotlinx.datetime)
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlin.poet)
    testImplementation(libs.kotlin.test)
}

tasks.test {
    useJUnitPlatform()
}

configure<GradlePluginDevelopmentExtension> {
    plugins {
        create("fhirCodegenPlugin") {
            id = "fhir-codegen"
            implementationClass = "dev.ohs.fhir.codegen.FhirCodegenPlugin"
        }
    }
}
