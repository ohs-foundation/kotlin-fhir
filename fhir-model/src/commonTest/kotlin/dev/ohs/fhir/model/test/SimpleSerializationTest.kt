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

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

private val expectedPatientJson =
  """
  {
      "resourceType": "Patient",
      "id": "patient-01"
  }
  """
    .trimIndent()

private val missingResourceType =
  """
  {
      "id": "patient-01"
  }
  """
    .trimIndent()

/** See https://github.com/google/kotlin-fhir/issues/66. */
class SimpleSerializationTest :
  FunSpec({
    val standaloneJson = Json { prettyPrint = true }

    fun <TResource : Any, TPatient : TResource> runIntegrityTests(
      name: String,
      patientFactory: (String) -> TPatient,
      resourceSerializer: KSerializer<TResource>,
      patientSerializer: KSerializer<TPatient>,
    ) {
      context("$name Serialization Integrity") {
        // Polymorphic path: `json.encodeToString<Resource>(resource)` upcasts to `Resource` and
        // goes
        // through `ResourcePolymorphicSerializer` — kotlinx-json injects the discriminator.
        test("Serialized resource should have resourceType property") {
          val patient = patientFactory("patient-01")
          testJson.encodeToString(resourceSerializer, patient).shouldBe(expectedPatientJson)
        }

        // Standalone path: `Patient.serializer()` resolves to `PatientSerializer` (the variant
        // whose
        // descriptor has `resourceType` at slot 0). The serializer writes the discriminator itself
        // —
        // no kotlinx-json polymorphic plumbing involved.
        test("Standalone Patient serializer writes resourceType first") {
          val patient = patientFactory("patient-01")
          standaloneJson.encodeToString(patientSerializer, patient).shouldBe(expectedPatientJson)
        }

        // Cross-path equivalence: decoding the same JSON via the polymorphic Resource path and via
        // the standalone Patient serializer must yield equal instances. This guards the
        // `resourceType`-at-slot-0 descriptor on the standalone path against silently diverging
        // from
        // what the polymorphic dispatcher produces.
        test("Polymorphic Resource decode equals direct Patient decode") {
          val viaResource = testJson.decodeFromString(resourceSerializer, expectedPatientJson)
          val viaPatient = standaloneJson.decodeFromString(patientSerializer, expectedPatientJson)
          viaResource.shouldBe(viaPatient)
        }

        // Round-trip via the standalone path: encode -> decode -> equal to source instance.
        test("Standalone Patient serializer round-trips") {
          val patient = patientFactory("patient-01")
          val encoded = standaloneJson.encodeToString(patientSerializer, patient)
          val decoded = standaloneJson.decodeFromString(patientSerializer, encoded)
          decoded.shouldBe(patient)
        }

        // Missing-discriminator: JSON with no `resourceType` must be rejected on both paths. The
        // polymorphic path can't pick an arm; the standalone path's descriptor has `resourceType`
        // at
        // slot 0, so accepting JSON without it would mean the slot is silently optional — decoding
        // arbitrary objects into typed FHIR resources.
        test("Polymorphic decode rejects JSON without resourceType") {
          shouldThrow<SerializationException> {
            standaloneJson.decodeFromString(resourceSerializer, missingResourceType)
          }
        }
      }
    }

    runIntegrityTests(
      name = "R4",
      patientFactory = { dev.ohs.fhir.model.r4.Patient(id = it) },
      resourceSerializer = serializer<dev.ohs.fhir.model.r4.Resource>(),
      patientSerializer = dev.ohs.fhir.model.r4.Patient.serializer(),
    )

    runIntegrityTests(
      name = "R4B",
      patientFactory = { dev.ohs.fhir.model.r4b.Patient(id = it) },
      resourceSerializer = serializer<dev.ohs.fhir.model.r4b.Resource>(),
      patientSerializer = dev.ohs.fhir.model.r4b.Patient.serializer(),
    )

    runIntegrityTests(
      name = "R5",
      patientFactory = { dev.ohs.fhir.model.r5.Patient(id = it) },
      resourceSerializer = serializer<dev.ohs.fhir.model.r5.Resource>(),
      patientSerializer = dev.ohs.fhir.model.r5.Patient.serializer(),
    )
  })
