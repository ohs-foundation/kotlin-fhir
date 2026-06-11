/*
 * Copyright 2025-2026 Open Health Stack Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ohs.fhir.gradle

import com.android.build.gradle.LibraryExtension
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

/**
 * Shared build convention for fhir-model-r4, fhir-model-r4b, and fhir-model-r5 modules.
 *
 * Configures Kotlin Multiplatform targets, Android library, common dependencies, and Maven Central
 * publishing. Version-specific values (artifact ID, Android namespace, POM name, iOS framework
 * name) are derived from the Gradle module name (e.g. "fhir-model-r4" → "R4").
 */
class FhirModelConventionsPlugin : Plugin<Project> {
  @OptIn(ExperimentalWasmDsl::class)
  override fun apply(project: Project) =
    with(project) {
      val androidEnabled =
        providers.gradleProperty("fhir.android.enabled").orNull?.toBoolean() != false

      // Apply plugins
      if (androidEnabled) pluginManager.apply("com.android.library")
      pluginManager.apply("com.google.devtools.ksp")
      pluginManager.apply("org.jetbrains.kotlin.multiplatform")
      pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")
      pluginManager.apply("com.vanniktech.maven.publish")
      pluginManager.apply("maven-publish")

      // Derive FHIR version label from module name: "fhir-model-r4" → "R4"
      val fhirVersionSuffix = name.substringAfter("fhir-model-")
      val fhirVersionLabel = fhirVersionSuffix.uppercase()

      // Access version catalog
      val libs = extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
      val compileSdk = libs.findVersion("android-compileSdk").get().toString().toInt()
      val minSdk = libs.findVersion("android-minSdk").get().toString().toInt()

      val mavenGroupId = property("mavenGroupId") as String
      val mavenVersion = property("mavenVersion") as String

      // ── Kotlin Multiplatform ──────────────────────────────────────────────
      extensions.configure<KotlinMultiplatformExtension> {
        jvmToolchain(21)

        jvm()
        wasmJs {
          browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig { config ->
              config.devServer =
                (config.devServer ?: KotlinWebpackConfig.DevServer()).apply {
                  static =
                    (static ?: mutableListOf()).apply {
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
        if (androidEnabled) {
          androidTarget { compilerOptions { jvmTarget.set(JvmTarget.JVM_1_8) } }
        }
        iosSimulatorArm64()
        iosArm64()
        iosX64 { binaries { framework { baseName = "KotlinFhir$fhirVersionLabel" } } }

        val commonMain = sourceSets.getByName("commonMain")
        // Explicitly set source dirs to avoid "redeclaration" errors with build/generated
        commonMain.kotlin.setSrcDirs(listOf(project.file("src/commonMain/kotlin")))
        commonMain.dependencies {
          api(libs.findLibrary("bignum").get())
          api(libs.findLibrary("kotlinx-datetime").get())
          implementation(libs.findLibrary("kotlinx-serialization-json").get())
        }
      }

      // ── Android ───────────────────────────────────────────────────────────
      if (androidEnabled) {
        extensions.configure<LibraryExtension> {
          namespace = "dev.ohs.fhir.model.$fhirVersionSuffix"
          this.compileSdk = compileSdk
          defaultConfig { this.minSdk = minSdk }
        }
      }

      // ── Maven Central Publishing ──────────────────────────────────────────
      extensions.configure<MavenPublishBaseExtension> {
        publishToMavenCentral()
        signAllPublications()
        coordinates(mavenGroupId, project.name, mavenVersion)
        pom { pom ->
          pom.name.set("Kotlin FHIR $fhirVersionLabel")
          pom.description.set(
            "A Kotlin Multiplatform library for the FHIR $fhirVersionLabel data model"
          )
          pom.inceptionYear.set("2025")
          pom.url.set("https://github.com/ohs-foundation/kotlin-fhir")
          pom.licenses { licenses ->
            licenses.license { license ->
              license.name.set("The Apache License, Version 2.0")
              license.url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
              license.distribution.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
          }
          pom.developers { developers ->
            developers.developer { developer ->
              developer.id.set("ohs-foundation")
              developer.name.set("Open Health Stack Foundation")
              developer.url.set("https://ohs.dev/")
            }
          }
          pom.scm { scm ->
            scm.url.set("https://github.com/ohs-foundation/kotlin-fhir/")
            scm.connection.set("scm:git:git://github.com/ohs-foundation/kotlin-fhir.git")
            scm.developerConnection.set(
              "scm:git:ssh://git@github.com/ohs-foundation/kotlin-fhir.git"
            )
          }
        }
      }

      // Avoid implicit task dependency failures when spotless/codegen and compilation run together
      tasks.configureEach { task ->
        val name = task.name
        if (
          (name.contains("compile", ignoreCase = true) && name.contains("Kotlin")) ||
            name.contains("sourcesJar", ignoreCase = true)
        ) {
          task.dependsOn("codegen")
        }
      }
    }
}
