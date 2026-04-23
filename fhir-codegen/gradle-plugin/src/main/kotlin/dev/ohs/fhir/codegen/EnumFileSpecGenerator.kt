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

import com.squareup.kotlinpoet.FileSpec
import dev.ohs.fhir.codegen.schema.*
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/** Generates [FileSpec]s for Kotlin enum classes based on a provided map of [ValueSet]s. */
class EnumFileSpecGenerator(val codegenContext: CodegenContext) {

  /**
   * Generates a list of [FileSpec]s for enum classes from the elements within a
   * [StructureDefinition]. The enum classes are created inside the terminologies' subpackage of the
   * core model's package.
   *
   * E.g. `dev.ohs.fhir.model.r4.terminologies`
   */
  fun generate(structureDefinition: StructureDefinition): List<FileSpec> =
    structureDefinition.snapshot
      ?.element
      ?.asSequence()
      ?.filter {
        it.getBindingValueSetUrl() != null &&
          codegenContext.valueSetMap.containsKey(it.getBindingValueSetUrl())
      }
      ?.filterNot { !it.isCommonBinding }
      ?.mapNotNull { element ->
        val valueSet = codegenContext.valueSetMap.getValue(element.getBindingValueSetUrl()!!)
        val valueSetName = valueSet.name.normalizeEnumName()
        val enumTypeSpec = EnumTypeSpecGenerator.generate(valueSetName, valueSet)
        enumTypeSpec?.let {
          FileSpec.builder(
              packageName = "${codegenContext.packageName}.terminologies",
              fileName = valueSetName,
            )
            .addType(it)
            .build()
        }
      }
      ?.toList() ?: emptyList()
}
