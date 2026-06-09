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

import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.serializer

private fun createPatientJson(id: String) =
  """
  {
      "resourceType": "Patient",
      "id": "$id"
  }
  """
    .trimIndent()

private fun createPatientJsonWithoutResourceType(id: String) =
  """
  {
      "id": "$id"
  }
  """
    .trimIndent()

/**
 * Verifies that the `resourceType` field is correctly serialized and deserialized using both
 * polymorphic and concrete serializers.
 *
 * Additionally, it verifies that decoding invalid JSON (e.g. missing `resourceType`) fails as
 * expected.
 *
 * See https://github.com/google/kotlin-fhir/issues/66.
 */
class PolymorphicSerializationTest :
  FunSpec({
    fun <TResource : Any, TPatient : TResource> runIntegrityTests(
      fhirVersionName: String,
      createPatient: (String) -> TPatient,
      resourceSerializer: KSerializer<TResource>,
      patientSerializer: KSerializer<TPatient>,
    ) {
      context("$fhirVersionName Resource Type Serialization") {
        test("Polymorphic Resource serialization writes resourceType") {
          val id = "patient-01"
          assertEquals(
            createPatientJson(id),
            testJson.encodeToString(resourceSerializer, createPatient(id)),
          )
        }

        test("Concrete Patient serialization writes resourceType") {
          val id = "patient-01"
          assertEquals(
            createPatientJson(id),
            testJson.encodeToString(patientSerializer, createPatient(id)),
          )
        }

        test("Polymorphic Resource deserialization ingests resourceType") {
          val id = "patient-01"
          assertEquals(
            createPatient(id),
            testJson.decodeFromString(resourceSerializer, createPatientJson(id)),
          )
        }

        test("Concrete Patient deserialization ingests resourceType") {
          val id = "patient-01"
          assertEquals(
            createPatient(id),
            testJson.decodeFromString(patientSerializer, createPatientJson(id)),
          )
        }

        // Missing-discriminator: JSON with no `resourceType` must be rejected on the polymorphic
        // path because the polymorphic path can't pick an arm. (Note: the concrete path does not
        // currently reject missing resourceType because custom deserializer generator doesn't
        // enforce it).
        test("Polymorphic decode rejects JSON without resourceType") {
          val id = "patient-01"
          assertFailsWith<SerializationException> {
            testJson.decodeFromString(resourceSerializer, createPatientJsonWithoutResourceType(id))
          }
        }
      }
    }

    runIntegrityTests(
      fhirVersionName = "R4",
      createPatient = { dev.ohs.fhir.model.r4.Patient(id = it) },
      resourceSerializer = serializer<dev.ohs.fhir.model.r4.Resource>(),
      patientSerializer = dev.ohs.fhir.model.r4.Patient.serializer(),
    )

    runIntegrityTests(
      fhirVersionName = "R4B",
      createPatient = { dev.ohs.fhir.model.r4b.Patient(id = it) },
      resourceSerializer = serializer<dev.ohs.fhir.model.r4b.Resource>(),
      patientSerializer = dev.ohs.fhir.model.r4b.Patient.serializer(),
    )

    runIntegrityTests(
      fhirVersionName = "R5",
      createPatient = { dev.ohs.fhir.model.r5.Patient(id = it) },
      resourceSerializer = serializer<dev.ohs.fhir.model.r5.Resource>(),
      patientSerializer = dev.ohs.fhir.model.r5.Patient.serializer(),
    )
  })
