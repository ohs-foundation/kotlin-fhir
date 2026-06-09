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
import kotlinx.serialization.serializer

/** A map from the test case name to the reason why the test case is skipped in R4. */
private val skippedR4TestCaseNameToReasonMap =
  mapOf(
    "Bundle-terminologies.json" to "Hanging",
    "CodeSystem-v2-0003.json" to "Hanging",
    "Bundle-valueset-expansions.json" to "Hanging",
    "Bundle-resources.json" to "Java heap space",
    "Bundle-dataelements.json" to "Java heap space",
    "CodeSystem-v3-ManagedParticipationStatus.json" to "Java heap space",
    "ValueSet-v3-hl7PublishingSubSection.json" to "Instant with trailing 0s",
    "Observation-decimal.json" to "Scientific notation",
    "ActivityDefinition-administer-zika-virus-exposure-assessment.json" to "Invalid resources",
    "ImplementationGuide-fhir.json" to "Invalid resources",
    "Questionnaire-qs1.json" to "Invalid resources",
    "ig-r4.json" to "Invalid resources",
  )

/** A map from the test case name to the reason why the test case is skipped in R4B. */
private val skippedR4BTestCaseNameToReasonMap =
  mapOf(
    "Bundle-resources.json" to "Java heap space",
    "Observation-decimal.json" to "Scientific notation",
    "Bundle-valuesets.json" to "Invalid resources",
    "CodeSystem-catalogType.json" to "Invalid resources",
    "ValueSet-catalogType.json" to "Invalid resources",
    "ActivityDefinition-administer-zika-virus-exposure-assessment.json" to "Invalid resources",
  )

/** A map from the test case name to the reason why the test case is skipped in R5. */
private val skippedR5CaseNameToReasonMap =
  mapOf(
    "Bundle-searchParams.json" to "Hanging",
    "Bundle-resources.json" to "Java heap space",
    "ArtifactAssessment-example-certainty-rating.json" to "Trailing 0 in milliseconds",
    "Citation-citation-example-research-doi.json" to "Trailing 0 in milliseconds",
    "Observation-decimal.json" to "Scientific notation",
    "ChargeItemDefinition-ebm.json" to
      "Unknown code 'text/CQL' for enum ExpressionLanguage; codes are case-sensitive",
  )

private val plainJson = Json { prettyPrint = true }

/**
 * Round-trips through the *concrete-type* serializer rather than the polymorphic [Resource] path.
 *
 * The polymorphic decode picks the runtime class (e.g. `Patient`); we then re-encode using that
 * class's standalone serializer (e.g. `PatientSerializer`, descriptor with `resourceType` at slot
 * 0) instead of `ResourcePolymorphicSerializer`. This validates that the standalone descriptor
 *    produces wire output identical to the polymorphic path for every example.
 */
@OptIn(InternalSerializationApi::class)
@Suppress("UNCHECKED_CAST")
private fun directRoundTrip(json: String): String {
  val klass = plainJson.decodeFromString<dev.ohs.fhir.model.r4.Resource>(json)::class
  val serializer = klass.serializer() as KSerializer<dev.ohs.fhir.model.r4.Resource>
  val decoded = plainJson.decodeFromString(serializer, json)
  return plainJson.encodeToString(serializer, decoded)
}

@OptIn(InternalSerializationApi::class)
@Suppress("UNCHECKED_CAST")
private fun directRoundTripR4B(json: String): String {
  val klass = plainJson.decodeFromString<dev.ohs.fhir.model.r4b.Resource>(json)::class
  val serializer = klass.serializer() as KSerializer<dev.ohs.fhir.model.r4b.Resource>
  val decoded = plainJson.decodeFromString(serializer, json)
  return plainJson.encodeToString(serializer, decoded)
}

@OptIn(InternalSerializationApi::class)
@Suppress("UNCHECKED_CAST")
private fun directRoundTripR5(json: String): String {
  val klass = plainJson.decodeFromString<dev.ohs.fhir.model.r5.Resource>(json)::class
  val serializer = klass.serializer() as KSerializer<dev.ohs.fhir.model.r5.Resource>
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
              assertEqualsIgnoringZeros(json, testSuite.roundTripFunction(json))
            }
          }
        }
      }
  })

private data class SerializationRoundTripTestSuite(
  val fhirVersion: String,
  val exampleLoader: () -> Sequence<FhirResourceJsonExample>,
  val skippedTestCaseToReasonMap: Map<String, String>,
  val roundTripFunction: (String) -> String,
)

private fun assertEqualsIgnoringZeros(exampleJson: String, reserializedString: String) {
  val expected =
    exampleJson
      .removeZeroMilliseconds()
      .replace("+00:00", "Z") // Unify UTC offset representation for Z
  val actual = reserializedString.removeZeroMilliseconds()
  val expectedJson = plainJson.parseToJsonElement(expected)
  val actualJson = plainJson.parseToJsonElement(actual)
  assertJsonEquals(expectedJson, actualJson)
}

private fun assertJsonEquals(
  expected: kotlinx.serialization.json.JsonElement,
  actual: kotlinx.serialization.json.JsonElement,
) {
  when {
    expected is kotlinx.serialization.json.JsonObject &&
      actual is kotlinx.serialization.json.JsonObject -> {
      assertEquals(expected.keys, actual.keys, "JSON object keys do not match")
      for (key in expected.keys) {
        assertJsonEquals(expected[key]!!, actual[key]!!)
      }
    }
    expected is kotlinx.serialization.json.JsonArray &&
      actual is kotlinx.serialization.json.JsonArray -> {
      assertEquals(expected.size, actual.size, "JSON array sizes do not match")
      for (i in expected.indices) {
        assertJsonEquals(expected[i], actual[i])
      }
    }
    expected is kotlinx.serialization.json.JsonPrimitive &&
      actual is kotlinx.serialization.json.JsonPrimitive -> {
      if (expected.isString != actual.isString) {
        assertEquals(expected.content, actual.content, "JSON primitive string-ness does not match")
      } else if (!expected.isString) {
        val expectedDouble = expected.content.toDoubleOrNull()
        val actualDouble = actual.content.toDoubleOrNull()
        if (expectedDouble != null && actualDouble != null) {
          assertEquals(
            expectedDouble,
            actualDouble,
            "JSON numeric values do not match: ${expected.content} vs ${actual.content}",
          )
        } else {
          assertEquals(expected.content, actual.content)
        }
      } else {
        assertEquals(expected.content, actual.content)
      }
    }
    else -> {
      assertEquals(expected, actual)
    }
  }
}

private val zeroMillisecondsPlusRegex = "\\.000\\+".toRegex()
private val zeroMillisecondsMinusRegex = "\\.000-".toRegex()
private val zeroMillisecondsZRegex = "\\.000Z".toRegex()
private val longZeroMillisecondsZRegex = "\\.0000000".toRegex()

private fun String.removeZeroMilliseconds(): String =
  replace(zeroMillisecondsPlusRegex, "+")
    .replace(zeroMillisecondsMinusRegex, "-")
    .replace(zeroMillisecondsZRegex, "Z")
    .replace(longZeroMillisecondsZRegex, "")
