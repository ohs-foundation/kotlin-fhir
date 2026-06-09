import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

val mavenGroupId: String by project
val mavenVersion: String by project

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotest)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.maven.publish)
    `maven-publish`
}

kotlin {
    jvmToolchain(21)

    jvm()
    wasmJs {
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
    }
    wasmWasi {
        nodejs()
        binaries.library()
    }
    js {
        browser()
        binaries.library()
    }
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
    iosSimulatorArm64()
    iosArm64()
    iosX64 {
        binaries {
            framework {
                baseName = "KotlinFhir" // Set the name of your framework

                // EXPORT DEPENDENCIES FOR OBJC INTEROP
                // If you are using other Kotlin modules as dependencies, you may need
                // to export them to make them visible to Objective-C/Swift:
                // export(project(":another-module"))

                // (OPTIONAL) EMBED BITCODE FOR RELEASE BUILDS (usually for iOS)
                // embedBitcode("release") // This usually goes in a separate release config
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":fhir-model-r4"))
                api(project(":fhir-model-r4b"))
                api(project(":fhir-model-r5"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotest.assertions.json)
                implementation(libs.kotest.framework.engine)
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.serialization.protobuf)
            }
        }
        val androidMain by getting
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.kotest.runner.junit5)
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(libs.kotest.runner.junit5)
                implementation(kotlin("reflect"))
                implementation(libs.kotlinx.serialization.json)
            }
        }
        val jsMain by getting
        val jsTest by getting
    }
}

android {
    namespace = "dev.ohs.fhir"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    testOptions {
        unitTests.all { test ->
            // Allow tests to access third_party
            test.systemProperty("projectRootDir", project.rootDir.absolutePath)
            test.maxHeapSize = "4g"
            test.useJUnitPlatform()
        }
    }
}

tasks.named<Test>("jvmTest") {
    // Allow tests to access third_party
    systemProperty("projectRootDir", project.rootDir.absolutePath)
    maxHeapSize = "4g"
    useJUnitPlatform()
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
    coordinates(mavenGroupId, "fhir-model", mavenVersion)
    pom {
        name = "Kotlin FHIR"
        description = "A Kotlin Multiplatform library for FHIR data models (R4, R4B, and R5)"
        inceptionYear = "2025"
        url = "https://github.com/ohs-foundation/kotlin-fhir"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "ohs-foundation"
                name = "Open Health Stack Foundation"
                url = "https://ohs.dev/"
            }
        }
        scm {
            url = "https://github.com/ohs-foundation/kotlin-fhir/"
            connection = "scm:git:git://github.com/ohs-foundation/kotlin-fhir.git"
            developerConnection = "scm:git:ssh://git@github.com/ohs-foundation/kotlin-fhir.git"
        }
    }
}
