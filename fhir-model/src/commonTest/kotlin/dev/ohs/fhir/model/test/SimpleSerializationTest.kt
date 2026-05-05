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

import dev.ohs.fhir.model.r4.FhirR4Json
import dev.ohs.fhir.model.r4b.FhirR4bJson
import dev.ohs.fhir.model.r5.FhirR5Json
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

private val expectedPatientJson =
  """
  {
      "resourceType": "Patient",
      "id": "patient-01"
  }
  """
    .trimIndent()

/** See https://github.com/google/kotlin-fhir/issues/66. */
class SimpleSerializationTest :
  FunSpec({
    // Polymorphic path: `FhirR{N}Json.encodeToString(Resource)` upcasts to `Resource` and goes
    // through `ResourcePolymorphicSerializer` — kotlinx-json injects the discriminator.
    test("Serialized resource in R4 should have resourceType property") {
      val patient = dev.ohs.fhir.model.r4.Patient(id = "patient-01")
      FhirR4Json().encodeToString(patient).shouldBe(expectedPatientJson)
    }

    test("Serialized resource in R4B should have resourceType property") {
      val patient = dev.ohs.fhir.model.r4b.Patient(id = "patient-01")
      FhirR4bJson().encodeToString(patient).shouldBe(expectedPatientJson)
    }

    test("Serialized resource in R5 should have resourceType property") {
      val patient = dev.ohs.fhir.model.r5.Patient(id = "patient-01")
      FhirR5Json().encodeToString(patient).shouldBe(expectedPatientJson)
    }

    // Standalone path: `Patient.serializer()` resolves to `PatientSerializer` (the variant whose
    // descriptor has `resourceType` at slot 0). The serializer writes the discriminator itself —
    // no kotlinx-json polymorphic plumbing involved.
    val standaloneJson = Json { prettyPrint = true }

    test("Standalone Patient serializer in R4 writes resourceType first") {
      val patient = dev.ohs.fhir.model.r4.Patient(id = "patient-01")
      standaloneJson
        .encodeToString(dev.ohs.fhir.model.r4.Patient.serializer(), patient)
        .shouldBe(expectedPatientJson)
    }

    test("Standalone Patient serializer in R4B writes resourceType first") {
      val patient = dev.ohs.fhir.model.r4b.Patient(id = "patient-01")
      standaloneJson
        .encodeToString(dev.ohs.fhir.model.r4b.Patient.serializer(), patient)
        .shouldBe(expectedPatientJson)
    }

    test("Standalone Patient serializer in R5 writes resourceType first") {
      val patient = dev.ohs.fhir.model.r5.Patient(id = "patient-01")
      standaloneJson
        .encodeToString(dev.ohs.fhir.model.r5.Patient.serializer(), patient)
        .shouldBe(expectedPatientJson)
    }

    // Cross-path equivalence: decoding the same JSON via the polymorphic Resource path and via
    // the standalone Patient serializer must yield equal instances. This guards the
    // `resourceType`-at-slot-0 descriptor on the standalone path against silently diverging from
    // what the polymorphic dispatcher produces.
    test("R4 polymorphic Resource decode equals direct Patient decode") {
      val viaResource = FhirR4Json().decodeFromString(expectedPatientJson)
      val viaPatient =
        standaloneJson.decodeFromString(
          dev.ohs.fhir.model.r4.Patient.serializer(),
          expectedPatientJson,
        )
      viaResource.shouldBe(viaPatient)
    }

    test("R4B polymorphic Resource decode equals direct Patient decode") {
      val viaResource = FhirR4bJson().decodeFromString(expectedPatientJson)
      val viaPatient =
        standaloneJson.decodeFromString(
          dev.ohs.fhir.model.r4b.Patient.serializer(),
          expectedPatientJson,
        )
      viaResource.shouldBe(viaPatient)
    }

    test("R5 polymorphic Resource decode equals direct Patient decode") {
      val viaResource = FhirR5Json().decodeFromString(expectedPatientJson)
      val viaPatient =
        standaloneJson.decodeFromString(
          dev.ohs.fhir.model.r5.Patient.serializer(),
          expectedPatientJson,
        )
      viaResource.shouldBe(viaPatient)
    }

    // Round-trip via the standalone path: encode -> decode -> equal to source instance.
    test("Standalone Patient serializer round-trips in R4") {
      val patient = dev.ohs.fhir.model.r4.Patient(id = "patient-01")
      val encoded =
        standaloneJson.encodeToString(dev.ohs.fhir.model.r4.Patient.serializer(), patient)
      val decoded =
        standaloneJson.decodeFromString(dev.ohs.fhir.model.r4.Patient.serializer(), encoded)
      decoded.shouldBe(patient)
    }

    test("Standalone Patient serializer round-trips in R4B") {
      val patient = dev.ohs.fhir.model.r4b.Patient(id = "patient-01")
      val encoded =
        standaloneJson.encodeToString(dev.ohs.fhir.model.r4b.Patient.serializer(), patient)
      val decoded =
        standaloneJson.decodeFromString(dev.ohs.fhir.model.r4b.Patient.serializer(), encoded)
      decoded.shouldBe(patient)
    }

    test("Standalone Patient serializer round-trips in R5") {
      val patient = dev.ohs.fhir.model.r5.Patient(id = "patient-01")
      val encoded =
        standaloneJson.encodeToString(dev.ohs.fhir.model.r5.Patient.serializer(), patient)
      val decoded =
        standaloneJson.decodeFromString(dev.ohs.fhir.model.r5.Patient.serializer(), encoded)
      decoded.shouldBe(patient)
    }

    // Missing-discriminator: JSON with no `resourceType` must be rejected on both paths. The
    // polymorphic path can't pick an arm; the standalone path's descriptor has `resourceType` at
    // slot 0, so accepting JSON without it would mean the slot is silently optional — decoding
    // arbitrary objects into typed FHIR resources.
    val missingResourceType =
      """
      {
          "id": "patient-01"
      }
      """
        .trimIndent()

    test("R4 polymorphic decode rejects JSON without resourceType") {
      shouldThrow<SerializationException> {
        standaloneJson.decodeFromString<dev.ohs.fhir.model.r4.Resource>(missingResourceType)
      }
    }

    test("R4B polymorphic decode rejects JSON without resourceType") {
      shouldThrow<SerializationException> {
        standaloneJson.decodeFromString<dev.ohs.fhir.model.r4b.Resource>(missingResourceType)
      }
    }

    test("R5 polymorphic decode rejects JSON without resourceType") {
      shouldThrow<SerializationException> {
        standaloneJson.decodeFromString<dev.ohs.fhir.model.r5.Resource>(missingResourceType)
      }
    }

  })
