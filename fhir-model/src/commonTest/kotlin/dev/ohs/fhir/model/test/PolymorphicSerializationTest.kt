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

import dev.ohs.fhir.model.r4.Patient as R4Patient
import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4b.Patient as R4bPatient
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r5.Patient as R5Patient
import dev.ohs.fhir.model.r5.Resource as R5Resource
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
    fun <TResource : Any, TPatient : TResource> polymorphicSerializationTestSuite(
      fhirVersion: String,
      createPatient: (String) -> TPatient,
      resourceSerializer: KSerializer<TResource>,
      patientSerializer: KSerializer<TPatient>,
    ) {
      context("$fhirVersion Resource Type Serialization") {
        val id = "patient-01"

        test("Polymorphic Resource serialization writes resourceType") {
          assertEquals(
            createPatientJson(id),
            testJson.encodeToString(resourceSerializer, createPatient(id)),
          )
        }

        test("Concrete Patient serialization writes resourceType") {
          assertEquals(
            createPatientJson(id),
            testJson.encodeToString(patientSerializer, createPatient(id)),
          )
        }

        test("Polymorphic Resource deserialization ingests resourceType") {
          assertEquals(
            createPatient(id),
            testJson.decodeFromString(resourceSerializer, createPatientJson(id)),
          )
        }

        test("Concrete Patient deserialization ingests resourceType") {
          assertEquals(
            createPatient(id),
            testJson.decodeFromString(patientSerializer, createPatientJson(id)),
          )
        }

        test("Polymorphic decode rejects JSON without resourceType") {
          assertFailsWith<SerializationException> {
            testJson.decodeFromString(
              resourceSerializer,
              createPatientJsonWithoutResourceType(id),
            )
          }
        }
      }
    }

    polymorphicSerializationTestSuite(
      fhirVersion = "R4",
      createPatient = { R4Patient(id = it) },
      resourceSerializer = serializer<R4Resource>(),
      patientSerializer = R4Patient.serializer(),
    )
    polymorphicSerializationTestSuite(
      fhirVersion = "R4B",
      createPatient = { R4bPatient(id = it) },
      resourceSerializer = serializer<R4bResource>(),
      patientSerializer = R4bPatient.serializer(),
    )
    polymorphicSerializationTestSuite(
      fhirVersion = "R5",
      createPatient = { R5Patient(id = it) },
      resourceSerializer = serializer<R5Resource>(),
      patientSerializer = R5Patient.serializer(),
    )
  })
