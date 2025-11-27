import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotest)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.maven.publish)
    id("fhir-codegen")
    `maven-publish`
}

group = "com.google.fhir"
version = "1.0.0-beta02"

// Run `./gradlew r4` to generate FHIR models for R4 in `fhir-model/build/generated/r4`
val codegenTaskR4 = fhirCodegenExtension.newTask("r4") {
    description = "Generate FHIR models for R4"
    this.corePackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4.core/package").listFiles()
    )
    this.expansionPackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4.expansions/package").listFiles()
    )
    this.packageName.set("com.google.fhir.model.r4")
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
    this.packageName.set("com.google.fhir.model.r4b")
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
    this.packageName.set("com.google.fhir.model.r5")
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
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
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
            }
        }
        val androidMain by getting
        val androidUnitTest by getting {
            dependsOn(commonTest)
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

android {
    namespace = "com.google.fhir"
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

// publishing prep
val localRepo: Directory = project.layout.buildDirectory.get().dir("repo")
publishing {
    repositories {
        maven {
            url = localRepo.asFile.toURI()
        }
    }
    publications {
        withType<MavenPublication> {
            pom {
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }
        }
    }
}
val deleteRepoTask = tasks.register<Delete>("deleteLocalRepo") {
    description =
        "Deletes the local repository to get rid of stale artifacts before local publishing"
    this.delete(localRepo)
}
tasks.named("publishAllPublicationsToMavenRepository").configure {
    dependsOn(deleteRepoTask)
}
tasks.register("zipRepo", Zip::class) {
    description = "Create a zip of the maven repository"
    this.destinationDirectory.set(project.layout.buildDirectory.dir("repoZip"))
    archiveBaseName.set("kotlin-fhir")

    // Hint to gradle that the repo files are produced by the publish task. This establishes a
    // dependency from the zipRepo task to the publish task.
    this.from(tasks.named("publish").map { _ ->
        localRepo
    })
}
