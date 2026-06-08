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

import dev.ohs.fhir.model.r4.BodyStructure
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4.String as R4String
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.protobuf.ProtoBuf

/**
 * Tests the custom serializer descriptor indexing (json doesn't use this, so we test with protobuf)
 */
@OptIn(ExperimentalSerializationApi::class)
class IndexOrderingTest :
  FunSpec({
    val proto = ProtoBuf {}

    // A resource whose required (non-nullable) field lives at the highest wire-field slot, so any
    // index drift between the two descriptors is observable as a missing `patient` after decode.
    fun bodyStructureWithPatient() =
      BodyStructure(
        id = "bs-1",
        patient = Reference(reference = R4String.of("Patient/example", null)),
      )

    fun simplePatient() = Patient(id = "patient-01")

    test("standalone JSON round-trip preserves required fields") {
      val encoded = testJson.encodeToString(bodyStructureWithPatient())
      val decoded = testJson.decodeFromString(encoded) as BodyStructure
      decoded.patient.reference?.value.shouldBe("Patient/example")
    }

    test("standalone ProtoBuf round-trip preserves required fields") {
      val original = bodyStructureWithPatient()
      val bytes = proto.encodeToByteArray(BodyStructure.serializer(), original)
      val decoded = proto.decodeFromByteArray(BodyStructure.serializer(), bytes)
      decoded.patient.reference?.value.shouldBe("Patient/example")
    }

    test("polymorphic JSON round-trip preserves required fields") {
      val original = bodyStructureWithPatient()
      val encoded = testJson.encodeToString<R4Resource>(original)
      val decoded = testJson.decodeFromString<R4Resource>(encoded) as BodyStructure
      decoded.patient.reference?.value.shouldBe("Patient/example")
    }

    test("polymorphic ProtoBuf round-trip preserves required fields") {
      val original = bodyStructureWithPatient()
      val bytes = proto.encodeToByteArray(R4Resource.serializer(), original)
      val decoded = proto.decodeFromByteArray(R4Resource.serializer(), bytes) as BodyStructure
      decoded.patient.reference?.value.shouldBe("Patient/example")
    }

    test("standalone path: Patient round-trips through ProtoBuf") {
      val original = simplePatient()
      val bytes = proto.encodeToByteArray(Patient.serializer(), original)
      val decoded = proto.decodeFromByteArray(Patient.serializer(), bytes)
      decoded.id.shouldBe(original.id)
    }
  })
