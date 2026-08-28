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

import dev.ohs.fhir.model.r4.Expression as R4Expression
import dev.ohs.fhir.model.r4.Expression.ExpressionLanguage as R4ExpressionLanguage
import dev.ohs.fhir.model.r4.ExtensibleEnumeration as R4ExtensibleEnumeration
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4b.Expression as R4bExpression
import dev.ohs.fhir.model.r4b.Expression.ExpressionLanguage as R4bExpressionLanguage
import dev.ohs.fhir.model.r4b.ExtensibleEnumeration as R4bExtensibleEnumeration
import dev.ohs.fhir.model.r5.Expression as R5Expression
import dev.ohs.fhir.model.r5.Expression.ExpressionLanguage as R5ExpressionLanguage
import dev.ohs.fhir.model.r5.ExtensibleEnumeration as R5ExtensibleEnumeration
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlinx.serialization.json.Json

class ExtensibleEnumerationTest :
  FunSpec({
    val json = Json { prettyPrint = true }

    test("R4 Expression with standard ExtensibleEnumeration.Known round-trips correctly") {
      val expr =
        R4Expression(
          expression = R4String(value = "Patient.gender = 'male'"),
          language = R4ExtensibleEnumeration.Known(R4ExpressionLanguage.Text_Fhirpath),
        )

      val encoded = json.encodeToString(R4Expression.serializer(), expr)
      val decoded = json.decodeFromString(R4Expression.serializer(), encoded)

      assertEquals(expr, decoded)
      val lang = decoded.language
      assertIs<R4ExtensibleEnumeration.Known<R4ExpressionLanguage>>(lang)
      assertEquals(R4ExpressionLanguage.Text_Fhirpath, lang.value)
      assertEquals("text/fhirpath", lang.rawCode)
      assertEquals("text/fhirpath", lang.toString())
    }

    test("R4 Expression with custom ExtensibleEnumeration.Custom round-trips correctly") {
      val customCode = "text/cql-identifier"
      val expr =
        R4Expression(
          expression = R4String(value = "PatientGender"),
          language = R4ExtensibleEnumeration.Custom(customCode),
        )

      val encoded = json.encodeToString(R4Expression.serializer(), expr)
      val decoded = json.decodeFromString(R4Expression.serializer(), encoded)

      assertEquals(expr, decoded)
      val lang = decoded.language
      assertIs<R4ExtensibleEnumeration.Custom>(lang)
      assertEquals(customCode, lang.rawCode)
      assertEquals(customCode, lang.toString())
    }

    test("R4 Expression with extension-only ExtensibleEnumeration round-trips correctly") {
      val jsonString =
        """
        {
          "expression": "SomeExpression",
          "_language": {
            "id": "ext-id",
            "extension": [
              {
                "url": "http://example.org/ext",
                "valueString": "extra"
              }
            ]
          }
        }
        """
          .trimIndent()

      val decoded = json.decodeFromString(R4Expression.serializer(), jsonString)
      val lang = decoded.language
      assertIs<R4ExtensibleEnumeration.Custom>(lang)
      assertEquals("ext-id", lang.id)
      assertEquals(1, lang.extension.size)

      val element = lang.toElement()
      assertEquals("ext-id", element?.id)
      assertEquals(1, element?.extension?.size)
    }

    test("R4B Expression supports ExtensibleEnumeration.Known and ExtensibleEnumeration.Custom") {
      val knownExpr =
        R4bExpression(language = R4bExtensibleEnumeration.Known(R4bExpressionLanguage.Text_Cql))
      val knownDecoded =
        json.decodeFromString(
          R4bExpression.serializer(),
          json.encodeToString(R4bExpression.serializer(), knownExpr),
        )
      val knownLang = knownDecoded.language
      assertIs<R4bExtensibleEnumeration.Known<R4bExpressionLanguage>>(knownLang)
      assertEquals(R4bExpressionLanguage.Text_Cql, knownLang.value)

      val customExpr =
        R4bExpression(language = R4bExtensibleEnumeration.Custom("application/x-custom"))
      val customDecoded =
        json.decodeFromString(
          R4bExpression.serializer(),
          json.encodeToString(R4bExpression.serializer(), customExpr),
        )
      val customLang = customDecoded.language
      assertIs<R4bExtensibleEnumeration.Custom>(customLang)
      assertEquals("application/x-custom", customLang.rawCode)
    }

    test("R5 Expression supports ExtensibleEnumeration.Known and ExtensibleEnumeration.Custom") {
      val knownExpr =
        R5Expression(language = R5ExtensibleEnumeration.Known(R5ExpressionLanguage.Text_Cql))
      val knownDecoded =
        json.decodeFromString(
          R5Expression.serializer(),
          json.encodeToString(R5Expression.serializer(), knownExpr),
        )
      val knownLang = knownDecoded.language
      assertIs<R5ExtensibleEnumeration.Known<R5ExpressionLanguage>>(knownLang)
      assertEquals(R5ExpressionLanguage.Text_Cql, knownLang.value)

      val customExpr = R5Expression(language = R5ExtensibleEnumeration.Custom("text/CQL"))
      val customDecoded =
        json.decodeFromString(
          R5Expression.serializer(),
          json.encodeToString(R5Expression.serializer(), customExpr),
        )
      val customLang = customDecoded.language
      assertIs<R5ExtensibleEnumeration.Custom>(customLang)
      assertEquals("text/CQL", customLang.rawCode)
    }

    test("ExtensibleEnumeration.of companion factory helper methods") {
      val known = R4ExtensibleEnumeration.of(R4ExpressionLanguage.Text_Cql)
      assertIs<R4ExtensibleEnumeration.Known<R4ExpressionLanguage>>(known)
      assertEquals(R4ExpressionLanguage.Text_Cql, known.value)

      val custom = R4ExtensibleEnumeration.of("custom/lang")
      assertIs<R4ExtensibleEnumeration.Custom>(custom)
      assertEquals("custom/lang", custom.rawCode)

      val parsedKnown =
        R4ExtensibleEnumeration.of("text/cql", null, R4ExpressionLanguage::fromCodeOrNull)
      assertIs<R4ExtensibleEnumeration.Known<R4ExpressionLanguage>>(parsedKnown)

      val parsedCustom =
        R4ExtensibleEnumeration.of<R4ExpressionLanguage>(
          "unrecognized",
          null,
          R4ExpressionLanguage::fromCodeOrNull,
        )
      assertIs<R4ExtensibleEnumeration.Custom>(parsedCustom)

      val parsedNull =
        R4ExtensibleEnumeration.of<R4ExpressionLanguage>(
          null,
          null,
          R4ExpressionLanguage::fromCodeOrNull,
        )
      assertNull(parsedNull)
    }
  })
