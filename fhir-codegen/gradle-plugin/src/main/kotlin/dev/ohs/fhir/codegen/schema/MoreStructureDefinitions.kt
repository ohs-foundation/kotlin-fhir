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

package dev.ohs.fhir.codegen.schema

val StructureDefinition.rootElements
  get() =
    snapshot?.element?.filter { it.id.matches("$name\\.[A-Za-z0-9]+(\\[x])?".toRegex()) }
      ?: emptyList()

val StructureDefinition.backboneElements
  get() = snapshot?.element?.getBackboneElementsMap() ?: emptyMap()

fun List<Element>?.getBackboneElementsMap(): Map<Element, List<Element>> =
  this?.let { elements ->
    elements
      .filter { it.isBackboneElement() }
      .associateWith { backboneElement ->
        elements.filter {
          it.path.matches("${backboneElement.path}\\.[A-Za-z0-9]+(\\[x])?".toRegex())
        }
      }
  } ?: emptyMap()

/** Concrete complex types and resources should be serializable with a custom serializer. */
val StructureDefinition.serializableWithCustomSerializer
  get() =
    !abstract &&
      (kind == StructureDefinition.Kind.RESOURCE || kind == StructureDefinition.Kind.COMPLEX_TYPE)

/**
 * Element, primitive types, and classes serializable with a custom serializer should have a primary
 * constructor.
 */
val StructureDefinition.hasPrimaryConstructor
  get() =
    name == "Element" ||
      kind == StructureDefinition.Kind.PRIMITIVE_TYPE ||
      serializableWithCustomSerializer

/**
 * Specifies type names for specific elements. In the FHIR specification the positiveInt and
 * unsignedInt types have the `value` field with the FHIRPath type
 * "http://hl7.org/fhirpath/System.String". Kotlin's [Int] is used in the generated code.
 */
val elementIdToTypeNameMap =
  mapOf("positiveInt.value" to Int::class, "unsignedInt.value" to Int::class)
