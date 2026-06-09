pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "kotlin-fhir"
includeBuild("build-logic")
includeBuild("fhir-codegen")
include(":fhir-model")
include(":fhir-model-r4")
include(":fhir-model-r4b")
include(":fhir-model-r5")
