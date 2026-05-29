import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

val basePackage: String by project
val mavenGroupId: String by project
val mavenArtifactId: String by project
val androidNamespace: String by project

plugins {
    // kotlin.multiplatform must be applied before the Android KMP library plugin and KSP,
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotest)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.maven.publish)
    id("fhir-codegen")
    `maven-publish`
}

// Run `./gradlew r4` to generate FHIR models for R4 in `fhir-model/build/generated/r4`
val codegenTaskR4 = fhirCodegenExtension.newTask("r4") {
    description = "Generate FHIR models for R4"
    this.corePackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4.core/package").listFiles()
    )
    this.expansionPackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4.expansions/package").listFiles()
    )
    this.packageName.set("$basePackage.r4")
}

// Run `./gradlew r4b` to generate FHIR models for R4B in `fhir-model/build/generated/r4b`
val codegenTaskR4B = fhirCodegenExtension.newTask("r4b") {
    description = "Generate FHIR models for R4B"
    this.corePackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4b.core/package").listFiles()
    )
    this.expansionPackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4b.expansions/package").listFiles()
    )
    this.packageName.set("$basePackage.r4b")
}

// Run `./gradlew r5` to generate FHIR models for R5 in `fhir-model/build/generated/r5`
val codegenTaskR5 = fhirCodegenExtension.newTask("r5") {
    description = "Generate FHIR models for R5"
    this.corePackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r5.core/package").listFiles()
    )
    this.expansionPackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r5.expansions/package").listFiles()
    )
    this.packageName.set("$basePackage.r5")
}

// Run `./gradlew codegen` to generate all FHIR models in the main source set
val codegen = tasks.register<Sync>("codegen") {
    description = "Generate FHIR models for R4, R4B and R5, and sync all versions into the main source set."
    from(codegenTaskR4, codegenTaskR4B, codegenTaskR5)
    into(project.layout.projectDirectory.dir("src/commonMain/kotlin"))
    finalizedBy(":spotlessApply")
}

kotlin {
    jvmToolchain(21)

    jvm()
    @OptIn(ExperimentalWasmDsl::class) wasmJs {
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
    @OptIn(ExperimentalWasmDsl::class) wasmWasi {
        nodejs()
        binaries.library()
    }
    js {
        browser()
        binaries.library()
    }
    android {
        namespace = androidNamespace
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withHostTestBuilder {}.configure {}

        compilerOptions {
            // Test dependencies (kotest) ship JVM 11 bytecode with inline functions,
            // which cannot be inlined into JVM 1.8 output. Build for JVM 11.
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
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
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            // Explicitly define the source directory `src/commonMain/kotlin` in order to ignore
            // `build/generated` which would generate "redeclaration" error after the `codegen` sync
            // task above.
            kotlin.setSrcDirs(listOf(file("src/commonMain/kotlin")))
            dependencies {
                api(libs.bignum)
                api(libs.kotlinx.datetime)
                implementation(libs.kotlinx.serialization.json)
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
        val androidHostTest by getting {
            dependencies {
                implementation(libs.kotest.runner.junit5)
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(libs.kotest.runner.junit5)
            }
        }
        val jsMain by getting
        val jsTest by getting
    }
}

// Configure all JVM-based test tasks (jvmTest and the Android host test) so they
// can access third_party fixtures and run Kotest specs via the JUnit Platform.
tasks.withType<Test>().configureEach {
    systemProperty("projectRootDir", project.rootDir.absolutePath)
    maxHeapSize = "4g"
    useJUnitPlatform()
}

version = "1.0.0-beta06"
mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
    coordinates(mavenGroupId, mavenArtifactId, version.toString())
    pom {
        name = "Kotlin FHIR"
        description = "A Kotlin Multiplatform library for FHIR data model"
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
                name = "Open Heath Stack Foundation"
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
