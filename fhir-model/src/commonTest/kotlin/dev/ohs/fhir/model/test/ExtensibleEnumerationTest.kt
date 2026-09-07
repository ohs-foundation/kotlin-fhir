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

import dev.ohs.fhir.model.r4.Element as R4Element
import dev.ohs.fhir.model.r4.Expression.ExpressionLanguage as R4ExpressionLanguage
import dev.ohs.fhir.model.r4.ExtensibleEnumeration as R4ExtensibleEnumeration
import dev.ohs.fhir.model.r4b.Element as R4bElement
import dev.ohs.fhir.model.r4b.Expression.ExpressionLanguage as R4bExpressionLanguage
import dev.ohs.fhir.model.r4b.ExtensibleEnumeration as R4bExtensibleEnumeration
import dev.ohs.fhir.model.r5.Element as R5Element
import dev.ohs.fhir.model.r5.Expression.ExpressionLanguage as R5ExpressionLanguage
import dev.ohs.fhir.model.r5.ExtensibleEnumeration as R5ExtensibleEnumeration
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull

class ExtensibleEnumerationTest :
  FunSpec({
    context("R4") {
      test("of(code, element) with predefined code creates Predefined") {
        val enumeration = R4ExtensibleEnumeration.of<R4ExpressionLanguage>("text/fhirpath", null)
        assertIs<R4ExtensibleEnumeration.Predefined<R4ExpressionLanguage>>(enumeration)
        assertEquals(R4ExpressionLanguage.Text_Fhirpath, enumeration.value)
        assertEquals("text/fhirpath", enumeration.code)
      }

      test("of(code, element) with custom code creates Custom") {
        val enumeration =
          R4ExtensibleEnumeration.of<R4ExpressionLanguage>("application/x-custom-syntax", null)
        assertIs<R4ExtensibleEnumeration.Custom>(enumeration)
        assertEquals("application/x-custom-syntax", enumeration.code)
      }

      test("of(code, element) with extension-only element creates Custom") {
        val enumeration =
          R4ExtensibleEnumeration.of<R4ExpressionLanguage>(null, R4Element(id = "ext-id"))
        assertIs<R4ExtensibleEnumeration.Custom>(enumeration)
        assertEquals("", enumeration.code)
        assertEquals("ext-id", enumeration.id)
      }

      test("of(code, element) with null code and null element returns null") {
        assertNull(R4ExtensibleEnumeration.of<R4ExpressionLanguage>(null, null))
      }
    }

    context("R4B") {
      test("of(code, element) with predefined code creates Predefined") {
        val enumeration = R4bExtensibleEnumeration.of<R4bExpressionLanguage>("text/fhirpath", null)
        assertIs<R4bExtensibleEnumeration.Predefined<R4bExpressionLanguage>>(enumeration)
        assertEquals(R4bExpressionLanguage.Text_Fhirpath, enumeration.value)
        assertEquals("text/fhirpath", enumeration.code)
      }

      test("of(code, element) with custom code creates Custom") {
        val enumeration =
          R4bExtensibleEnumeration.of<R4bExpressionLanguage>("application/x-custom-syntax", null)
        assertIs<R4bExtensibleEnumeration.Custom>(enumeration)
        assertEquals("application/x-custom-syntax", enumeration.code)
      }

      test("of(code, element) with extension-only element creates Custom") {
        val enumeration =
          R4bExtensibleEnumeration.of<R4bExpressionLanguage>(null, R4bElement(id = "ext-id"))
        assertIs<R4bExtensibleEnumeration.Custom>(enumeration)
        assertEquals("", enumeration.code)
        assertEquals("ext-id", enumeration.id)
      }

      test("of(code, element) with null code and null element returns null") {
        assertNull(R4bExtensibleEnumeration.of<R4bExpressionLanguage>(null, null))
      }
    }

    context("R5") {
      test("of(code, element) with predefined code creates Predefined") {
        val enumeration = R5ExtensibleEnumeration.of<R5ExpressionLanguage>("text/fhirpath", null)
        assertIs<R5ExtensibleEnumeration.Predefined<R5ExpressionLanguage>>(enumeration)
        assertEquals(R5ExpressionLanguage.Text_Fhirpath, enumeration.value)
        assertEquals("text/fhirpath", enumeration.code)
      }

      test("of(code, element) with custom code creates Custom") {
        val enumeration =
          R5ExtensibleEnumeration.of<R5ExpressionLanguage>("application/x-custom-syntax", null)
        assertIs<R5ExtensibleEnumeration.Custom>(enumeration)
        assertEquals("application/x-custom-syntax", enumeration.code)
      }

      test("of(code, element) with extension-only element creates Custom") {
        val enumeration =
          R5ExtensibleEnumeration.of<R5ExpressionLanguage>(null, R5Element(id = "ext-id"))
        assertIs<R5ExtensibleEnumeration.Custom>(enumeration)
        assertEquals("", enumeration.code)
        assertEquals("ext-id", enumeration.id)
      }

      test("of(code, element) with null code and null element returns null") {
        assertNull(R5ExtensibleEnumeration.of<R5ExpressionLanguage>(null, null))
      }
    }
  })
