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

package dev.ohs.fhir.model.test

data class FhirResourceJsonExample(val fileName: String, val json: String)

fun loadR4Examples(): Sequence<FhirResourceJsonExample> =
  loadExamplesFromFileSystem(
    packageSubdirectory = "hl7.fhir.r4.examples/package/",
    ::filterFileName,
  )

fun loadR4BExamples(): Sequence<FhirResourceJsonExample> =
  loadExamplesFromFileSystem(
    packageSubdirectory = "hl7.fhir.r4b.examples/package/",
    ::filterFileName,
  )

fun loadR5Examples(): Sequence<FhirResourceJsonExample> =
  loadExamplesFromFileSystem(
    packageSubdirectory = "hl7.fhir.r5.examples/package/",
    ::filterFileName,
  )

expect fun loadExamplesFromFileSystem(
  packageSubdirectory: String,
  fileNameFilter: (String) -> Boolean,
): Sequence<FhirResourceJsonExample>

private fun filterFileName(name: String): Boolean {
  return name.endsWith(".json") &&
    !name.startsWith('.') // filter out `.index.json` file
    &&
    name != "package.json"
}
