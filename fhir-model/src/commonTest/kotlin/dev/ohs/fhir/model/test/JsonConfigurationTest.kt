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

@file:Suppress("RedundantJson")

package dev.ohs.fhir.model.test

import dev.ohs.fhir.model.r4.Patient as R4Patient
import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4b.Patient as R4bPatient
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r5.Patient as R5Patient
import dev.ohs.fhir.model.r5.Resource as R5Resource
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Tests that custom `Json { ... }` configurations (e.g. `prettyPrint`, `isLenient`,
 * `ignoreUnknownKeys`) produce the correct serialized JSON format across all supported FHIR
 * versions.
 */
class JsonConfigurationTest :
  FunSpec({
    val compactJson = Json { prettyPrint = false }
    val encodeDefaultsOffJson = Json { encodeDefaults = false }
    val encodeDefaultsOnJson = Json { encodeDefaults = true }
    val explicitNullsOffJson = Json { explicitNulls = false }
    val explicitNullsOnJson = Json { explicitNulls = true }
    val useAltNamesOffJson = Json { useAlternativeNames = false }
    val useAltNamesOnJson = Json { useAlternativeNames = true }
    val customDiscriminatorJson = Json {
      prettyPrint = false
      classDiscriminator = "kind"
    }
    val ignoreUnknownKeysJson = Json { ignoreUnknownKeys = true }
    val lenientJson = Json { isLenient = true }

    fun <TResource : Any> jsonConfigurationTestSuite(
      fhirVersion: String,
      createPatient: (String) -> TResource,
      resourceSerializer: KSerializer<TResource>,
    ) {
      context("$fhirVersion Json Configuration") {
        // --- Documented Supported Options ---
        test("prettyPrint=false produces compact JSON with resourceType first") {
          val json = compactJson.encodeToString(resourceSerializer, createPatient("patient-01"))
          assertEquals("""{"resourceType":"Patient","id":"patient-01"}""", json)
        }

        test("ignoreUnknownKeys=true allows decoding unknown fields") {
          val withExtra =
            """
            {
              "resourceType": "Patient",
              "id": "patient-01",
              "_some_brand_new_field_we_do_not_know_about": {"x": 1}
            }
            """
              .trimIndent()
          val decoded = ignoreUnknownKeysJson.decodeFromString(resourceSerializer, withExtra)
          assertEquals(createPatient("patient-01"), decoded)
        }

        test("default Json (ignoreUnknownKeys=false) rejects unknown fields") {
          val withExtra =
            """
            {
              "resourceType": "Patient",
              "id": "patient-01",
              "_some_brand_new_field_we_do_not_know_about": {"x": 1}
            }
            """
              .trimIndent()
          assertFailsWith<SerializationException> {
            testJson.decodeFromString(resourceSerializer, withExtra)
          }
        }

        test("isLenient=true accepts unquoted string values") {
          val lenient =
            """
            {
              "resourceType": "Patient",
              "id": patient-01
            }
            """
              .trimIndent()
          val decoded = lenientJson.decodeFromString(resourceSerializer, lenient)
          assertEquals(createPatient("patient-01"), decoded)
        }

        test("default Json (isLenient=false) rejects unquoted string values") {
          val unquoted =
            """
            {
              "resourceType": "Patient",
              "id": patient-01
            }
            """
              .trimIndent()
          assertFailsWith<SerializationException> {
            testJson.decodeFromString(resourceSerializer, unquoted)
          }
        }

        // --- Documented Options with No Effect (handled directly by generated serializers) ---
        test("encodeDefaults option has no effect on wire shape") {
          val patient = createPatient("patient-01")
          val withDefault = encodeDefaultsOffJson.encodeToString(resourceSerializer, patient)
          val withDefaultsOn = encodeDefaultsOnJson.encodeToString(resourceSerializer, patient)
          assertEquals(withDefault, withDefaultsOn)
        }

        test("explicitNulls option has no effect on wire shape") {
          val patient = createPatient("patient-01")
          val withNullsOn = explicitNullsOnJson.encodeToString(resourceSerializer, patient)
          val withNullsOff = explicitNullsOffJson.encodeToString(resourceSerializer, patient)
          assertEquals(withNullsOn, withNullsOff)
        }

        test("useAlternativeNames option has no effect on wire shape") {
          val patient = createPatient("patient-01")
          val withAltNamesOn = useAltNamesOnJson.encodeToString(resourceSerializer, patient)
          val withAltNamesOff = useAltNamesOffJson.encodeToString(resourceSerializer, patient)
          assertEquals(withAltNamesOn, withAltNamesOff)
        }

        test("custom classDiscriminator is overridden by descriptor discriminator") {
          val json =
            customDiscriminatorJson.encodeToString(
              resourceSerializer,
              createPatient("patient-01"),
            )
          assertTrue(json.contains(""""resourceType":"Patient""""))
          assertFalse(json.contains(""""kind":"Patient""""))
        }
      }
    }

    jsonConfigurationTestSuite("R4", { R4Patient(id = it) }, serializer<R4Resource>())
    jsonConfigurationTestSuite("R4B", { R4bPatient(id = it) }, serializer<R4bResource>())
    jsonConfigurationTestSuite("R5", { R5Patient(id = it) }, serializer<R5Resource>())
  })
