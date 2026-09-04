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

package dev.ohs.fhir.codegen.searchparam

import dev.ohs.fhir.codegen.FhirPathExpressionResolver
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.Type
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class SearchParamWhereFilterTest {

  @Test
  fun parsing_whereFilterOnPrimitiveField_shouldReturnWhereFilter() {
    val pattern = parse("Device.identifier.where(value='123')")

    val filter = assertIs<SearchParamPattern.WhereFilter>(pattern)
    assertEquals("value", filter.field)
    assertEquals("123", filter.value)
  }

  @Test
  fun parsing_whereFilterWithPostPath_shouldReturnWhereFilterWithPostPath() {
    val pattern = parse("Device.identifier.where(value='123').system")

    val filter = assertIs<SearchParamPattern.WhereFilter>(pattern)
    assertEquals("system", filter.postPath?.segments?.single()?.propertyName)
  }

  @Test
  fun parsing_whereFilterOnComplexField_shouldReturnUnsupported() {
    // Identifier.type is a CodeableConcept; the emitted comparison needs a primitive `.value`.
    assertEquals(SearchParamPattern.Unsupported, parse("Device.identifier.where(type='SNO')"))
  }

  @Test
  fun parsing_whereFilterOnUnknownField_shouldReturnUnsupported() {
    assertEquals(SearchParamPattern.Unsupported, parse("Device.identifier.where(nonexistent='x')"))
  }

  private fun parse(expression: String): SearchParamPattern =
    parseSearchParamExpression(expression, "Device", resolver)

  private val resolver =
    FhirPathExpressionResolver(
      mapOf(
        "Device" to listOf(element("Device.identifier", "Identifier", max = "*")),
        "Identifier" to
          listOf(
            element("Identifier.type", "CodeableConcept"),
            element("Identifier.system", "uri"),
            element("Identifier.value", "string"),
          ),
      )
    )

  private fun element(path: String, vararg typeCodes: String, max: String = "1"): Element =
    Element(
      id = path,
      path = path,
      definition = "",
      min = 0,
      max = max,
      isModifier = false,
      type = typeCodes.map { Type(it) },
    )
}
