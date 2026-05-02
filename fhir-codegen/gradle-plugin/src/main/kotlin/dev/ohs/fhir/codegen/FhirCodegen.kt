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

package com.google.fhir.codegen

import com.google.fhir.codegen.schema.SearchParameterDefinition
import com.google.fhir.codegen.schema.StructureDefinition
import com.google.fhir.codegen.schema.serializableWithCustomSerializer
import com.google.fhir.codegen.schema.valueset.ValueSet
import com.squareup.kotlinpoet.FileSpec

/**
 * Generates [FileSpec]s for a given FHIR StructureDefinition.
 *
 * This function produces three files:
 * 1. A data model file (e.g., `Patient.kt`) containing the primary data class and any nested
 *    classes for BackboneElements.
 * 2. A surrogate file (e.g., `PatientSurrogates.kt`) in the `surrogates` package with "flattened"
 *    surrogate classes for the primary class and its nested classes for BackboneElements.
 * 3. A serializer file (e.g., `PatientSerializers.kt`) in the `serializers` package with
 *    "flattened" custom serializers for the primary class and its nested classes for
 *    BackboneElements.
 *
 * For example, the following files are generated for the FHIR `Patient` resource:
 * - `Patient.kt` containing the `Patient` data class with its nested classes for BackboneElements.
 * - `PatientSurrogates.kt` in the `surrogates` package containing surrogate classes like
 *   `PatientSurrogate`, `PatientContactSurrogate`, etc.
 * - `PatientSerializers.kt` in the `serializers` package containing custom serializers like
 *   `PatientSerializer`, `PatientContactSerializer`, etc.
 */
class FhirCodegen(
  packageName: String,
  valueSetMap: Map<String, ValueSet>,
  baseClassesSet: HashSet<String>,
  searchParamsByResource: Map<String, List<SearchParameterDefinition>> = emptyMap(),
) {

  private val codegenContext =
    CodegenContext(
      packageName = packageName,
      valueSetMap = valueSetMap,
      baseClassNameSet = baseClassesSet,
      searchParamsByResource = searchParamsByResource,
    )

  private val modelFileSpecGenerator = ModelFileSpecGenerator(codegenContext)
  private val surrogateFileSpecGenerator = SurrogateFileSpecGenerator(codegenContext)
  private val serializerFileSpecGenerator = SerializerFileSpecGenerator(codegenContext)
  private val enumFileSpecGenerator = EnumFileSpecGenerator(codegenContext)

  fun generateFileSpecs(structureDefinition: StructureDefinition): List<FileSpec> {
    val fileSpecs = mutableListOf(modelFileSpecGenerator.generate(structureDefinition))
    if (structureDefinition.serializableWithCustomSerializer) {
      // TODO: Handle cases where the class does not need the surrogate class and the
      //  custom serializer since it does not have any primitive fields.
      fileSpecs += surrogateFileSpecGenerator.generate(structureDefinition)
      fileSpecs += serializerFileSpecGenerator.generate(structureDefinition)
    }
    fileSpecs += enumFileSpecGenerator.generate(structureDefinition)
    return fileSpecs
  }
}
