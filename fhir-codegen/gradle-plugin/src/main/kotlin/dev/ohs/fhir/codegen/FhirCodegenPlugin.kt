/*
 * Copyright 2025-2026 Google LLC
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

package dev.ohs.fhir.codegen

import javax.inject.Inject
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register

class FhirCodegenPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    project.extensions.create("fhirCodegenExtension", FhirCodegenExtension::class)
  }
}

abstract class FhirCodegenExtension @Inject constructor(private val project: Project) {
  fun newTask(version: String, configure: Action<FhirCodegenTask>): TaskProvider<FhirCodegenTask> {
    return project.tasks.register<FhirCodegenTask>(version) {
      // e.g. FHIR models for R4 will be in the `fhir-model/build/generated/r4` subdirectory
      outputDirectory.set(project.layout.buildDirectory.dir("generated/$version"))
      configure.execute(this)
    }
  }
}
