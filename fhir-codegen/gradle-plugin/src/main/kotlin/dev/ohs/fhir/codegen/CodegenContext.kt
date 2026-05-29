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

package dev.ohs.fhir.codegen

import com.squareup.kotlinpoet.ClassName
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/** Shared context object containing contextual information needed for code generation. */
data class CodegenContext(
  val packageName: String,
  val valueSetMap: Map<String, ValueSet>,
  val baseClassNameSet: HashSet<String>,
  val typeGraph: TypeGraphAnalyzer,
  val primitiveValueIsNonNull: Map<String, Boolean>,
) {
  fun getModelClassName(structureDefinition: StructureDefinition) =
    ClassName(packageName, structureDefinition.name.capitalized())

  fun isBaseClass(structureDefinition: StructureDefinition) =
    baseClassNameSet.contains(structureDefinition.name.capitalized())
}
