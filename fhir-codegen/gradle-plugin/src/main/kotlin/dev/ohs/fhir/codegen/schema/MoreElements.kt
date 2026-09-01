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

import com.squareup.kotlinpoet.ClassName
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

internal fun Element.getElementName() = path.substringAfterLast('.').removeSuffix("[x]")

internal fun Element.getPathSimpleNames(): List<String> =
  path.replace("[x]", "").split(".").map { it.capitalized() }

/**
 * Determines if an [Element] is a BackboneElement.
 *
 * In the FHIR resource ElementDefinition, there are a number of fields (e.g. `slicing`, `base`,
 * `type`) of type Element. However, for the purpose of code generation, they should be treated as
 * BackboneElements and nested classes should be generated for them.
 *
 * They are the only known instances of elements of type Element in StructureDefinitions. Therefore,
 * for simplicity, this function treats all elements of type Element as BackboneElements.
 */
internal fun Element.isBackboneElement(): Boolean {
  val typeCode = type?.singleOrNull()?.code
  return typeCode == "BackboneElement" || typeCode == "Element"
}

const val ELEMENT_IS_COMMON_BINDING_EXTENSION_URL =
  "http://hl7.org/fhir/StructureDefinition/elementdefinition-isCommonBinding"

val Element.isCommonBinding
  get() = getBindingExtension(ELEMENT_IS_COMMON_BINDING_EXTENSION_URL)?.valueBoolean == true

/**
 * Retrieves an [Extension] in `binding` with the provided url if one exists. Otherwise, returns
 * `null`
 */
private fun Element.getBindingExtension(url: String): Extension? {
  if (binding == null || binding.extension.isNullOrEmpty()) return null
  return binding.extension.find { it.url == url }
}

/**
 * Retrieves the [dev.ohs.fhir.codegen.schema.valueset.ValueSet.url] from the [Element]. Extracts
 * the URI part from the set url excluding the FHIR versions E.g.
 * http://hl7.org/fhir/ValueSet/task-status|4.3.0, will return
 * "http://hl7.org/fhir/ValueSet/task-status"
 */
internal fun Element.getBindingValueSetUrl() = this.binding?.valueSet?.substringBeforeLast("|")

/**
 * Determines if the element's bound value set has an enum vocabulary worth generating — i.e. a
 * `code` element bound to a known value set, regardless of binding strength. Used to decide whether
 * the enum *class* is emitted (as a typed catalog of the known codes).
 *
 * The requirements are:
 * - The element's type is `code`.
 * - The element has an extension with the URL:
 *   `http://hl7.org/fhir/StructureDefinition/elementdefinition-bindingName`.
 * - The element's base path does **not** start with `"Resource."` or `"CanonicalResource."`.
 * - The element's name is not blank
 */
internal fun Element.typeHasEnumVocabulary(valueSetMap: Map<String, ValueSet>): Boolean {
  return valueSetMap.containsKey(getBindingValueSetUrl()) &&
    base?.path?.startsWith("Resource.") != true &&
    base?.path?.startsWith("CanonicalResource.") != true &&
    this.type?.count { it.code.equals("code", ignoreCase = true) } == 1
}

/**
 * Determines if the element itself should be typed as `Enumeration<Enum>`.
 *
 * This requires [typeHasEnumVocabulary] and additionally that the binding strength is `required`.
 * Weaker bindings (`extensible`, `preferred`, `example`) permit codes outside the value set, so a
 * closed enum cannot represent legal instances (e.g. `Expression.language`, bound extensibly,
 * carries `text/cql-identifier` throughout the WHO SMART Guidelines content); such elements are
 * typed as the open `Code` instead, with the enum still generated as a vocabulary of known codes
 * (bridged via `Enumeration.toCode()`/`fromCode`).
 */
internal fun Element.typeIsEnumeratedCode(valueSetMap: Map<String, ValueSet>): Boolean {
  return typeHasEnumVocabulary(valueSetMap) && binding?.strength == "required"
}

/**
 * Returns the Kotlin type name for the `contentReference` in the [Element], if present. Otherwise,
 * returns `null`.
 *
 * The `contentReference` element specifies an element in the definition whose type should be used
 * for the current [Element]. This should always be a BackboneElement which should be a nested
 * class.
 *
 * See documentation in
 * [R4](https://hl7.org/fhir/R4/elementdefinition-definitions.html#ElementDefinition.contentReference).
 */
internal fun Element.getContentReferenceType(packageName: String): ClassName? {
  if (type == null && contentReference != null) {
    // The nested class name for the BackboneElement is recreated from the path of the
    // content reference. For example, the element "CapabilityStatement.rest.searchParam" has
    // the `contentReference` "#CapabilityStatement.rest.resource.searchParam" and the
    // [ClassName] for this type is "CapabilityStatement.Rest.Resource.SearchParam".
    return ClassName(
      packageName,
      contentReference.removePrefix("#").split('.').map { it.capitalized() },
    )
  }
  return null
}
