/*
 * Copyright 2026 Open Health Stack Foundation
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

import dev.ohs.fhir.codegen.schema.valueset.Contains
import dev.ohs.fhir.codegen.schema.valueset.Expansion
import dev.ohs.fhir.codegen.schema.valueset.ValueSet
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.serialization.json.Json

class MoreElementsTest {

  private val valueSetUrl = "http://hl7.org/fhir/ValueSet/expression-language"

  private val valueSetMap =
    mapOf(
      valueSetUrl to
        ValueSet(
          id = "expression-language",
          url = valueSetUrl,
          name = "ExpressionLanguage",
          expansion =
            Expansion(
              contains =
                listOf(
                  Contains(system = "http://hl7.org/fhir/expression-language", code = "text/cql")
                )
            ),
        )
    )

  private fun element(
    binding: Binding? = Binding(strength = "required", valueSet = "$valueSetUrl|4.0.1"),
    basePath: String = "Expression.language",
    typeCode: String = "code",
  ) =
    Element(
      id = "Expression.language",
      path = "Expression.language",
      definition = "The media type of the language for the expression.",
      min = 1,
      max = "1",
      base = Base(path = basePath, min = 1, max = "1"),
      isModifier = false,
      type = listOf(Type(code = typeCode)),
      binding = binding,
    )

  @Test
  fun typeIsEnumeratedCode_requiredBinding_generatesEnum() {
    assertTrue(element().typeIsEnumeratedCode(valueSetMap))
  }

  @Test
  fun typeIsEnumeratedCode_extensibleBinding_staysOpenCode() {
    // Extensible bindings permit codes outside the value set (e.g. Expression.language
    // carrying text/cql-identifier), so the element must not be typed as a closed enum. See #123.
    val element =
      element(binding = Binding(strength = "extensible", valueSet = "$valueSetUrl|4.0.1"))
    assertFalse(element.typeIsEnumeratedCode(valueSetMap))
  }

  @Test
  fun typeHasEnumVocabulary_extensibleBinding_stillEmitsEnum() {
    // The enum class is still generated as a vocabulary of known codes even when the element
    // itself is typed as open Code (bridged via Enumeration.toCode()/fromCode).
    val element =
      element(binding = Binding(strength = "extensible", valueSet = "$valueSetUrl|4.0.1"))
    assertTrue(element.typeHasEnumVocabulary(valueSetMap))
  }

  @Test
  fun typeIsEnumeratedCode_preferredBinding_staysOpenCode() {
    val element =
      element(binding = Binding(strength = "preferred", valueSet = "$valueSetUrl|4.0.1"))
    assertFalse(element.typeIsEnumeratedCode(valueSetMap))
  }

  @Test
  fun typeIsEnumeratedCode_missingStrength_staysOpenCode() {
    val element = element(binding = Binding(valueSet = "$valueSetUrl|4.0.1"))
    assertFalse(element.typeIsEnumeratedCode(valueSetMap))
  }

  @Test
  fun typeIsEnumeratedCode_valueSetNotInMap_staysOpenCode() {
    val element =
      element(
        binding =
          Binding(strength = "required", valueSet = "http://example.org/ValueSet/other|4.0.1")
      )
    assertFalse(element.typeIsEnumeratedCode(valueSetMap))
  }

  @Test
  fun typeIsEnumeratedCode_resourceBasePath_staysOpenCode() {
    assertFalse(element(basePath = "Resource.language").typeIsEnumeratedCode(valueSetMap))
  }

  @Test
  fun typeIsEnumeratedCode_nonCodeType_staysOpenCode() {
    assertFalse(element(typeCode = "string").typeIsEnumeratedCode(valueSetMap))
  }

  @Test
  fun binding_deserialization_readsStrength() {
    // Guards the schema field itself: binding.strength was previously dropped at ingestion,
    // which made every bound code element read as enum-eligible regardless of strength.
    val binding =
      Json { ignoreUnknownKeys = true }
        .decodeFromString(
          Binding.serializer(),
          """{"strength": "extensible", "valueSet": "$valueSetUrl|4.0.1"}""",
        )
    assertEquals("extensible", binding.strength)
  }
}
