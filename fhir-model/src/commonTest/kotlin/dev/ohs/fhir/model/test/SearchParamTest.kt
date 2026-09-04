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

import dev.ohs.fhir.model.r4.ActivityDefinition as R4ActivityDefinition
import dev.ohs.fhir.model.r4.Observation as R4Observation
import dev.ohs.fhir.model.r4.Patient as R4Patient
import dev.ohs.fhir.model.r4.search.ActivityDefinitionSearchParams as R4ActivityDefinitionSearchParams
import dev.ohs.fhir.model.r4.search.ObservationSearchParams as R4ObservationSearchParams
import dev.ohs.fhir.model.r4.search.PatientSearchParams as R4PatientSearchParams
import dev.ohs.fhir.model.r4b.ActivityDefinition as R4bActivityDefinition
import dev.ohs.fhir.model.r4b.Observation as R4bObservation
import dev.ohs.fhir.model.r4b.Patient as R4bPatient
import dev.ohs.fhir.model.r4b.search.ActivityDefinitionSearchParams as R4bActivityDefinitionSearchParams
import dev.ohs.fhir.model.r4b.search.ObservationSearchParams as R4bObservationSearchParams
import dev.ohs.fhir.model.r4b.search.PatientSearchParams as R4bPatientSearchParams
import dev.ohs.fhir.model.r5.ActivityDefinition as R5ActivityDefinition
import dev.ohs.fhir.model.r5.Device as R5Device
import dev.ohs.fhir.model.r5.Observation as R5Observation
import dev.ohs.fhir.model.r5.Patient as R5Patient
import dev.ohs.fhir.model.r5.search.ActivityDefinitionSearchParams as R5ActivityDefinitionSearchParams
import dev.ohs.fhir.model.r5.search.DeviceSearchParams as R5DeviceSearchParams
import dev.ohs.fhir.model.r5.search.ObservationSearchParams as R5ObservationSearchParams
import dev.ohs.fhir.model.r5.search.PatientSearchParams as R5PatientSearchParams
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.serialization.KSerializer

class SearchParamTest :
  FunSpec({
    val observationWithQuantityJson =
      """
      {
        "resourceType": "Observation",
        "status": "final",
        "code": {
          "text": "Weight"
        },
        "valueQuantity": {
          "unit": "kg"
        }
      }
      """
        .trimIndent()

    val observationWithNullValueJson =
      """
      {
        "resourceType": "Observation",
        "status": "final",
        "code": {
          "text": "Finding"
        }
      }
      """
        .trimIndent()

    val activityDefinitionWithUseContextJson =
      """
      {
        "resourceType": "ActivityDefinition",
        "status": "draft",
        "useContext": [
          {
            "code": {
              "code": "focus"
            },
            "valueCodeableConcept": {
              "text": "Cardiology"
            }
          },
          {
            "code": {
              "code": "age"
            },
            "valueQuantity": {
              "unit": "years"
            }
          }
        ]
      }
      """
        .trimIndent()

    val patientWithDeceasedDateTimeJson =
      """
      {
        "resourceType": "Patient",
        "deceasedDateTime": "2026-08-11T12:00:00Z"
      }
      """
        .trimIndent()

    val observationWithDateTimeJson =
      """
      {
        "resourceType": "Observation",
        "status": "final",
        "code": {
          "text": "Onset"
        },
        "valueDateTime": "2026-08-12T09:30:00Z"
      }
      """
        .trimIndent()

    val observationWithPeriodJson =
      """
      {
        "resourceType": "Observation",
        "status": "final",
        "code": {
          "text": "Onset"
        },
        "valuePeriod": {
          "start": "2026-08-01"
        }
      }
      """
        .trimIndent()

    val activityDefinitionWithRangeAndQuantityJson =
      """
      {
        "resourceType": "ActivityDefinition",
        "status": "draft",
        "useContext": [
          {
            "code": {
              "code": "age"
            },
            "valueRange": {
              "low": {
                "unit": "months"
              }
            }
          },
          {
            "code": {
              "code": "age"
            },
            "valueQuantity": {
              "unit": "years"
            }
          }
        ]
      }
      """
        .trimIndent()

    val deviceWithSerialNumberJson =
      """
      {
        "resourceType": "Device",
        "serialNumber": "SN-123",
        "identifier": [
          {
            "type": {
              "coding": [
                {
                  "code": "SNO"
                }
              ]
            },
            "value": "SN-456"
          }
        ]
      }
      """
        .trimIndent()

    fun <TObservation : Any, TActivity : Any, TPatient : Any> searchParamTestSuite(
      fhirVersion: String,
      observationSerializer: KSerializer<TObservation>,
      activitySerializer: KSerializer<TActivity>,
      patientSerializer: KSerializer<TPatient>,
      extractValueQuantity: (TObservation) -> List<*>,
      extractValueConcept: (TObservation) -> List<*>,
      extractValueDate: (TObservation) -> List<*>,
      extractContext: (TActivity) -> List<*>,
      extractContextQuantity: (TActivity) -> List<*>,
      extractDeathDate: (TPatient) -> List<*>,
    ) {
      context("$fhirVersion Search Parameters") {
        // (Observation.value as Quantity)
        test("extracting choice with matching type returns extracted value") {
          val observation =
            testJson.decodeFromString(observationSerializer, observationWithQuantityJson)
          assertEquals(1, extractValueQuantity(observation).size)
        }

        // (Observation.value as CodeableConcept)
        test("extracting choice with mismatched type returns empty list") {
          val observation =
            testJson.decodeFromString(observationSerializer, observationWithQuantityJson)
          assertTrue(extractValueConcept(observation).isEmpty())
        }

        test("extracting choice with null value returns empty list") {
          val observation =
            testJson.decodeFromString(observationSerializer, observationWithNullValueJson)
          assertTrue(extractValueQuantity(observation).isEmpty())
          assertTrue(extractValueConcept(observation).isEmpty())
        }

        // (ActivityDefinition.useContext.value as Quantity)
        test("extracting choice from list filters matching elements") {
          val activity =
            testJson.decodeFromString(
              activitySerializer,
              activityDefinitionWithUseContextJson,
            )
          assertEquals(1, extractContext(activity).size)
          assertEquals(1, extractContextQuantity(activity).size)
        }

        // (Patient.deceased as dateTime)
        test("extracting choice from scalar returns value") {
          val patient =
            testJson.decodeFromString(patientSerializer, patientWithDeceasedDateTimeJson)
          assertEquals(1, extractDeathDate(patient).size)
        }

        // Observation.value as dateTime | Observation.value as Period
        test("extracting union with first branch type returns extracted value") {
          val observation =
            testJson.decodeFromString(observationSerializer, observationWithDateTimeJson)
          assertEquals(
            listOf("DateTime"),
            extractValueDate(observation).map { it!!::class.simpleName },
          )
        }

        test("extracting union with second branch type returns extracted value") {
          val observation =
            testJson.decodeFromString(observationSerializer, observationWithPeriodJson)
          assertEquals(
            listOf("Period"),
            extractValueDate(observation).map { it!!::class.simpleName },
          )
        }

        // (ActivityDefinition.useContext.value as Quantity) | (... as Range). Results follow the
        // branch order in the expression: all Quantity values first, then all Range values.
        test("extracting union with values in both branches concatenates in expression order") {
          val activity =
            testJson.decodeFromString(
              activitySerializer,
              activityDefinitionWithRangeAndQuantityJson,
            )
          assertEquals(
            listOf("Quantity", "Range"),
            extractContextQuantity(activity).map { it!!::class.simpleName },
          )
        }
      }
    }

    searchParamTestSuite(
      fhirVersion = "R4",
      observationSerializer = R4Observation.serializer(),
      activitySerializer = R4ActivityDefinition.serializer(),
      patientSerializer = R4Patient.serializer(),
      extractValueQuantity = { R4ObservationSearchParams.valueQuantity.extractFrom(it) },
      extractValueConcept = { R4ObservationSearchParams.valueConcept.extractFrom(it) },
      extractValueDate = { R4ObservationSearchParams.valueDate.extractFrom(it) },
      extractContext = { R4ActivityDefinitionSearchParams.context.extractFrom(it) },
      extractContextQuantity = {
        R4ActivityDefinitionSearchParams.contextQuantity.extractFrom(it)
      },
      extractDeathDate = { R4PatientSearchParams.deathDate.extractFrom(it) },
    )
    searchParamTestSuite(
      fhirVersion = "R4B",
      observationSerializer = R4bObservation.serializer(),
      activitySerializer = R4bActivityDefinition.serializer(),
      patientSerializer = R4bPatient.serializer(),
      extractValueQuantity = { R4bObservationSearchParams.valueQuantity.extractFrom(it) },
      extractValueConcept = { R4bObservationSearchParams.valueConcept.extractFrom(it) },
      extractValueDate = { R4bObservationSearchParams.valueDate.extractFrom(it) },
      extractContext = { R4bActivityDefinitionSearchParams.context.extractFrom(it) },
      extractContextQuantity = {
        R4bActivityDefinitionSearchParams.contextQuantity.extractFrom(it)
      },
      extractDeathDate = { R4bPatientSearchParams.deathDate.extractFrom(it) },
    )
    searchParamTestSuite(
      fhirVersion = "R5",
      observationSerializer = R5Observation.serializer(),
      activitySerializer = R5ActivityDefinition.serializer(),
      patientSerializer = R5Patient.serializer(),
      extractValueQuantity = { R5ObservationSearchParams.valueQuantity.extractFrom(it) },
      extractValueConcept = { R5ObservationSearchParams.valueConcept.extractFrom(it) },
      extractValueDate = { R5ObservationSearchParams.valueDate.extractFrom(it) },
      extractContext = { R5ActivityDefinitionSearchParams.context.extractFrom(it) },
      extractContextQuantity = {
        R5ActivityDefinitionSearchParams.contextQuantity.extractFrom(it)
      },
      extractDeathDate = { R5PatientSearchParams.deathDate.extractFrom(it) },
    )

    context("R5 Search Parameters") {
      // serial-number is `Device.serialNumber | Device.identifier.where(type='SNO')`. The second
      // branch is not supported and is skipped, so only the serialNumber value is extracted. See
      // "Partially extracted unions" in docs/search-parameter-patterns.md.
      test("extracting partially supported union returns only supported branch values") {
        val device = testJson.decodeFromString(R5Device.serializer(), deviceWithSerialNumberJson)
        assertEquals(
          listOf("SN-123"),
          R5DeviceSearchParams.serialNumber.extractFrom(device).map { it.value },
        )
      }
    }
  })
