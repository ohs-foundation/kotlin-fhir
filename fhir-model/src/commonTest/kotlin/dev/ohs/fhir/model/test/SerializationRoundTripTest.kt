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

package dev.ohs.fhir.model.test

import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r5.Resource as R5Resource
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.Enabled
import kotlin.test.assertEquals
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.serializer

/** A map from the test case name to the reason why the test case is skipped in R4. */
private val skippedR4TestCaseNameToReasonMap =
  mapOf(
    "ImplementationGuide-fhir.json" to "Invalid resources",
    "Questionnaire-qs1.json" to "Invalid resources",
    "ig-r4.json" to "Invalid resources",
  )

/** A map from the test case name to the reason why the test case is skipped in R4B. */
private val skippedR4BTestCaseNameToReasonMap =
  mapOf(
    "Bundle-valuesets.json" to "Invalid resources",
    "CodeSystem-catalogType.json" to "Invalid resources",
    "ValueSet-catalogType.json" to "Invalid resources",
  )

/** A map from the test case name to the reason why the test case is skipped in R5. */
private val skippedR5CaseNameToReasonMap = emptyMap<String, String>()

private val plainJson = Json { prettyPrint = true }

/**
 * Round-trips through the *concrete-type* serializer rather than the polymorphic
 * [dev.ohs.fhir.model.r4.Resource] path.
 *
 * The polymorphic decode picks the runtime class (e.g. `Patient`); we then re-encode using that
 * class's standalone serializer (e.g. `PatientSerializer`, descriptor with `resourceType` at slot
 * 0) instead of `ResourcePolymorphicSerializer`. This validates that the standalone descriptor
 *    produces wire output identical to the polymorphic path for every example.
 */
@OptIn(InternalSerializationApi::class)
@Suppress("UNCHECKED_CAST")
private fun directRoundTrip(json: String): String {
  val klass = plainJson.decodeFromString<R4Resource>(json)::class
  val serializer = klass.serializer() as KSerializer<R4Resource>
  val decoded = plainJson.decodeFromString(serializer, json)
  return plainJson.encodeToString(serializer, decoded)
}

@OptIn(InternalSerializationApi::class)
@Suppress("UNCHECKED_CAST")
private fun directRoundTripR4B(json: String): String {
  val klass = plainJson.decodeFromString<R4bResource>(json)::class
  val serializer = klass.serializer() as KSerializer<R4bResource>
  val decoded = plainJson.decodeFromString(serializer, json)
  return plainJson.encodeToString(serializer, decoded)
}

@OptIn(InternalSerializationApi::class)
@Suppress("UNCHECKED_CAST")
private fun directRoundTripR5(json: String): String {
  val klass = plainJson.decodeFromString<R5Resource>(json)::class
  val serializer = klass.serializer() as KSerializer<R5Resource>
  val decoded = plainJson.decodeFromString(serializer, json)
  return plainJson.encodeToString(serializer, decoded)
}

/**
 * This test verifies the generated code can be used to deserialize published FHIR examples and
 * serialize them back to the original JSON.
 */
class SerializationRoundTripTest :
  FunSpec({
    listOf(
        SerializationRoundTripTestSuite("R4", ::loadR4Examples, skippedR4TestCaseNameToReasonMap) {
          testJson.encodeToString<R4Resource>(testJson.decodeFromString<R4Resource>(it))
        },
        SerializationRoundTripTestSuite(
          "R4B",
          ::loadR4BExamples,
          skippedR4BTestCaseNameToReasonMap,
        ) {
          testJson.encodeToString<R4bResource>(testJson.decodeFromString<R4bResource>(it))
        },
        SerializationRoundTripTestSuite("R5", ::loadR5Examples, skippedR5CaseNameToReasonMap) {
          testJson.encodeToString<R5Resource>(testJson.decodeFromString<R5Resource>(it))
        },
        SerializationRoundTripTestSuite(
          "R4 (direct concrete-type serializer)",
          ::loadR4Examples,
          skippedR4TestCaseNameToReasonMap,
        ) {
          directRoundTrip(it)
        },
        SerializationRoundTripTestSuite(
          "R4B (direct concrete-type serializer)",
          ::loadR4BExamples,
          skippedR4BTestCaseNameToReasonMap,
        ) {
          directRoundTripR4B(it)
        },
        SerializationRoundTripTestSuite(
          "R5 (direct concrete-type serializer)",
          ::loadR5Examples,
          skippedR5CaseNameToReasonMap,
        ) {
          directRoundTripR5(it)
        },
      )
      .forEach { testSuite ->
        context(
          "${testSuite.fhirVersion} JSON should be the same after deserialization and serialization"
        ) {
          testSuite.exampleLoader().forEach { (fileName, json) ->
            test(fileName).config(
              enabledOrReasonIf = {
                testSuite.skippedTestCaseToReasonMap[fileName]?.let { Enabled.disabled(it) }
                  ?: Enabled.enabled
              }
            ) {
              assertSemanticEquivalence(json, testSuite.roundTripFunction(json))
            }
          }
        }
      }

    context("removeTrailingZerosInFractionalSeconds") {
      test("entirely zero fractional seconds are stripped") {
        assertEquals(
          "2026-06-16T09:40:48Z",
          "2026-06-16T09:40:48.000Z".removeTrailingZerosInFractionalSeconds(),
        )
        assertEquals(
          "2026-06-16T09:40:48+01:00",
          "2026-06-16T09:40:48.000+01:00".removeTrailingZerosInFractionalSeconds(),
        )
        assertEquals(
          "2026-06-16T09:40:48-05:00",
          "2026-06-16T09:40:48.000-05:00".removeTrailingZerosInFractionalSeconds(),
        )
      }

      test("trailing zeros in fractional seconds are trimmed") {
        assertEquals(
          "2026-06-16T09:40:48.12Z",
          "2026-06-16T09:40:48.1200Z".removeTrailingZerosInFractionalSeconds(),
        )
        assertEquals(
          "2026-06-16T09:40:48.12+01:00",
          "2026-06-16T09:40:48.1200+01:00".removeTrailingZerosInFractionalSeconds(),
        )
        assertEquals(
          "2026-06-16T09:40:48.12-05:00",
          "2026-06-16T09:40:48.1200-05:00".removeTrailingZerosInFractionalSeconds(),
        )
      }

      test("decimal numbers are not modified") {
        assertEquals(
          "0.0000000000000000000001",
          "0.0000000000000000000001".removeTrailingZerosInFractionalSeconds(),
        )
        assertEquals("1.0000000", "1.0000000".removeTrailingZerosInFractionalSeconds())
      }
    }
  })

private data class SerializationRoundTripTestSuite(
  val fhirVersion: String,
  val exampleLoader: () -> Sequence<FhirResourceJsonExample>,
  val skippedTestCaseToReasonMap: Map<String, String>,
  val roundTripFunction: (String) -> String,
)

private fun assertSemanticEquivalence(exampleJson: String, reserializedString: String) {
  val expectedJson = plainJson.parseToJsonElement(exampleJson)
  val actualJson = plainJson.parseToJsonElement(reserializedString)
  assertSemanticEquivalence(expectedJson, actualJson)
}

private fun assertSemanticEquivalence(expected: JsonElement, actual: JsonElement) {
  when (expected) {
    is JsonObject if actual is JsonObject -> {
      assertEquals(expected.keys, actual.keys, "JSON object keys do not match")
      for (key in expected.keys) {
        assertSemanticEquivalence(expected[key]!!, actual[key]!!)
      }
    }

    is JsonArray if actual is JsonArray -> {
      assertEquals(expected.size, actual.size, "JSON array sizes do not match")
      for (i in expected.indices) {
        assertSemanticEquivalence(expected[i], actual[i])
      }
    }

    is JsonPrimitive if actual is JsonPrimitive -> {
      assertEquals(normalizeDateTime(expected.content), normalizeDateTime(actual.content))
    }

    else -> {
      assertEquals(expected, actual)
    }
  }
}

private fun normalizeDateTime(content: String): String =
  content
    .removeTrailingZerosInFractionalSeconds()
    .replace("+00:00", "Z") // Unify UTC offset representation for Z

// Matches trailing zeros in fractional seconds, e.g. ".1200Z" -> ".12Z" (preserves the non-zero
// digits before the trailing zeros)
private val trailingZerosInFractionalSeconds = "(\\.\\d*?[1-9])0+(?=[Z+\\-])".toRegex()

// Matches fractional seconds that are entirely zeros, e.g. ".000Z" -> "Z"
private val zeroFractionalSeconds = "\\.0+(?=[Z+\\-])".toRegex()

private fun String.removeTrailingZerosInFractionalSeconds(): String =
  replace(trailingZerosInFractionalSeconds, "$1").replace(zeroFractionalSeconds, "")
