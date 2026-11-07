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

import dev.ohs.fhir.model.r4.AllergyIntolerance as R4AllergyIntolerance
import dev.ohs.fhir.model.r4.Patient as R4Patient
import dev.ohs.fhir.model.r4b.AllergyIntolerance as R4bAllergyIntolerance
import dev.ohs.fhir.model.r4b.Patient as R4bPatient
import dev.ohs.fhir.model.r5.AllergyIntolerance as R5AllergyIntolerance
import dev.ohs.fhir.model.r5.Patient as R5Patient
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * FHIR primitives may appear on the wire as a `_field` element only (e.g. a
 * [data-absent-reason](https://hl7.org/fhir/extension-data-absent-reason.html) extension with no
 * value). These tests cover enum-bound (`Enumeration`) primitives, both scalar and repeated, which
 * previously dropped the extension (scalar) or crashed (repeated).
 */
class EnumerationSerializationTest :
  FunSpec({
    val json = Json

    val patientWithExtensionOnlyGenderJson =
      """
      {
        "resourceType": "Patient",
        "id": "p1",
        "_gender": {
          "extension": [
            {
              "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
              "valueCode": "unknown"
            }
          ]
        }
      }
      """
        .trimIndent()

    val allergyIntoleranceWithExtensionOnlyCategoryJson =
      """
      {
        "resourceType": "AllergyIntolerance",
        "id": "a1",
        "patient": {
          "reference": "Patient/p1"
        },
        "category": [
          "food",
          null
        ],
        "_category": [
          null,
          {
            "extension": [
              {
                "url": "http://hl7.org/fhir/StructureDefinition/data-absent-reason",
                "valueCode": "unknown"
              }
            ]
          }
        ]
      }
      """
        .trimIndent()

    fun <T : Any> assertRoundTrip(serializer: KSerializer<T>, jsonString: String) =
      assertEquals(
        json.parseToJsonElement(jsonString),
        json.parseToJsonElement(
          json.encodeToString(serializer, json.decodeFromString(serializer, jsonString))
        ),
      )

    fun <TPatient : Any, TAllergyIntolerance : Any> enumerationSerializationTestSuite(
      fhirVersion: String,
      patientSerializer: KSerializer<TPatient>,
      allergySerializer: KSerializer<TAllergyIntolerance>,
    ) {
      context("$fhirVersion Enumeration Serialization") {
        test("extension-only enum primitive survives a decode/encode round trip") {
          assertRoundTrip(patientSerializer, patientWithExtensionOnlyGenderJson)
        }

        test("enum list with an extension-only entry survives a decode/encode round trip") {
          assertRoundTrip(allergySerializer, allergyIntoleranceWithExtensionOnlyCategoryJson)
        }
      }
    }

    enumerationSerializationTestSuite(
      "R4",
      serializer<R4Patient>(),
      serializer<R4AllergyIntolerance>(),
    )
    enumerationSerializationTestSuite(
      "R4B",
      serializer<R4bPatient>(),
      serializer<R4bAllergyIntolerance>(),
    )
    enumerationSerializationTestSuite(
      "R5",
      serializer<R5Patient>(),
      serializer<R5AllergyIntolerance>(),
    )
  })
