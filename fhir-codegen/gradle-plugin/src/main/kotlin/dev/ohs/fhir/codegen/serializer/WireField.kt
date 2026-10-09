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

package dev.ohs.fhir.codegen.serializer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.TypeName
import dev.ohs.fhir.codegen.CodegenContext
import dev.ohs.fhir.codegen.PropertyMapper
import dev.ohs.fhir.codegen.primitives.FhirPathType
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getElementName

/**
 * A single wire-level field — one slot in the streaming encode/decode descriptor.
 *
 * Mapping from FHIR elements to wire fields:
 * - Primitive → `(value, _field)` pair of `WireField`s.
 * - Choice type (`foo[x]`) → per-expansion pairs (`fooBoolean` + `_fooBoolean`, `fooDateTime` +
 *   `_fooDateTime`, …) expanded directly into the flat wire shape. Encode dispatches via
 *   `emitChoiceTypeExpansionEncoding`; decode reads expansion locals and synthesizes the sealed
 *   value via the companion `from(…)` factory in `emitModelConstruction`.
 * - Complex / list → single `WireField`.
 *
 * For resource types, `resourceType` is handled separately as descriptor[0] — NOT included here.
 */
internal data class WireField(
  val name: String,
  /** Wire-shaped Kotlin type of the slot (e.g. `String?` for a `dateTime`). */
  val typeName: TypeName,
  /** Owning parent element. */
  val element: Element,
  /** Is this the `_field` element (carries id/extension for a primitive). */
  val isElementField: Boolean = false,
  val defaultValue: String? = "null",
  /**
   * FHIR primitive type code (e.g. `boolean`, `dateTime`) when this slot is a primitive value or
   * its `_field` companion; null for complex, backbone and list-of-complex slots.
   */
  val fhirTypeCode: String? = null,
) {
  /** Whether the slot holds a list (repeating element). */
  val isList: Boolean
    get() = typeName is ParameterizedTypeName
}

/**
 * Wire fields matching the FLAT FHIR JSON wire shape exactly — every top-level key that appears on
 * the wire is a separate entry. Choice types expand to per-expansion pairs (`deceasedBoolean`,
 * `_deceasedBoolean`, `deceasedDateTime`, …). Encode writes these slots directly via
 * `emitChoiceTypeExpansionEncoding`; decode reads them into locals and synthesizes the sealed value
 * via the companion `from(…)` factory.
 */
internal fun CodegenContext.buildJsonWireFields(
  modelClassName: ClassName,
  elements: List<Element>,
): List<WireField> {
  val propertyMapper =
    PropertyMapper(PropertyMapper.MappingContext.WIRE, modelClassName, valueSetMap)
  return elements.flatMap { element ->
    propertyMapper.mapToProperties(element).map { info ->
      val valueName = info.name.removePrefix("_")
      val fhirTypeCode =
        element.type
          ?.firstOrNull { type ->
            FhirPathType.containsFhirTypeCode(type.code) &&
              (element.type.size == 1 ||
                valueName == "${element.getElementName()}${type.code.capitalized()}")
          }
          ?.code
      WireField(
        name = info.name,
        typeName = info.typeName,
        element = element,
        isElementField = info.name.startsWith("_"),
        defaultValue = info.defaultValue,
        fhirTypeCode = fhirTypeCode,
      )
    }
  }
}
