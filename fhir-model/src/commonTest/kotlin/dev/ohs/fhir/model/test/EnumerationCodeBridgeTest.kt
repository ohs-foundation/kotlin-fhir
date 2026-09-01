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

package dev.ohs.fhir.model.test

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.String as FhirString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class EnumerationCodeBridgeTest {

  private val extension =
    Extension(
      url = "http://example.org/note",
      value = Extension.Value.String(FhirString(value = "hi")),
    )

  @Test
  fun toCode_preservesValueIdAndExtension() {
    val enumeration =
      Enumeration(
        id = "e1",
        extension = listOf(extension),
        value = Expression.ExpressionLanguage.Text_Cql,
      )
    val code = enumeration.toCode()
    assertEquals("text/cql", code.value)
    assertEquals("e1", code.id)
    assertEquals(listOf(extension), code.extension)
  }

  @Test
  fun fromCode_parsesValueAndPreservesIdAndExtension() {
    val code = Code(id = "e1", extension = listOf(extension), value = "text/fhirpath")
    val enumeration = Enumeration.fromCode(code, Expression.ExpressionLanguage::fromCode)
    assertEquals(Expression.ExpressionLanguage.Text_Fhirpath, enumeration.value)
    assertEquals("e1", enumeration.id)
    assertEquals(listOf(extension), enumeration.extension)
  }

  @Test
  fun fromCode_extensionOnlyCode_keepsSidecarWithNullValue() {
    val code = Code(extension = listOf(extension), value = null)
    val enumeration = Enumeration.fromCode(code, Expression.ExpressionLanguage::fromCode)
    assertNull(enumeration.value)
    assertEquals(listOf(extension), enumeration.extension)
  }

  @Test
  fun roundTrip_enumerationToCodeAndBack_isIdentity() {
    val original =
      Enumeration(
        id = "rt",
        extension = listOf(extension),
        value = Expression.ExpressionLanguage.Text_Cql,
      )
    val roundTripped =
      Enumeration.fromCode(original.toCode(), Expression.ExpressionLanguage::fromCode)
    assertEquals(original, roundTripped)
  }
}
