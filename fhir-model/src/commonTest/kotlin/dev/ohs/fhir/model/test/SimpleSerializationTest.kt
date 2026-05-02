/*
 * Copyright 2025-2026 Google LLC
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
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/** See https://github.com/google/kotlin-fhir/issues/66. */
class SimpleSerializationTest :
  FunSpec({
    test("Serialized resource in R4 should have resourceType property") {
      val patient = dev.ohs.fhir.model.r4.Patient(id = "patient-01")
      val serializedPatient = FhirR4Json().encodeToString(patient)
      serializedPatient.shouldBe(
        """
        {
            "resourceType": "Patient",
            "id": "patient-01"
        }
        """
          .trimIndent()
      )
    }

    test("Serialized resource in R4B should have resourceType property") {
      val patient = dev.ohs.fhir.model.r4b.Patient(id = "patient-01")
      val serializedPatient = FhirR4bJson().encodeToString(patient)
      serializedPatient.shouldBe(
        """
        {
            "resourceType": "Patient",
            "id": "patient-01"
        }
        """
          .trimIndent()
      )
    }

    test("Serialized resource in R5 should have resourceType property") {
      val patient = dev.ohs.fhir.model.r5.Patient(id = "patient-01")
      val serializedPatient = FhirR5Json().encodeToString(patient)
      serializedPatient.shouldBe(
        """
        {
            "resourceType": "Patient",
            "id": "patient-01"
        }
        """
          .trimIndent()
      )
    }
  })
