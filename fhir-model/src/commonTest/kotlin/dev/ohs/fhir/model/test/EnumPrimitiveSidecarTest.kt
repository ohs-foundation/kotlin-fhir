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
import dev.ohs.fhir.model.r4b.Patient as R4bPatient
import dev.ohs.fhir.model.r5.Patient as R5Patient
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.serializer

/**
 * FHIR primitives may appear on the wire as a `_field` sidecar only (e.g. a
 * [data-absent-reason](https://hl7.org/fhir/extension-data-absent-reason.html) extension with no
 * value). These tests cover enum-bound (`Enumeration`) primitives, both scalar and repeated, which
 * previously dropped the sidecar (scalar) or crashed (repeated).
 */
class EnumPrimitiveSidecarTest :
  FunSpec({
    val json = Json

    val extensionOnlyGenderJson =
      """{"resourceType":"Patient","id":"p1","_gender":{"extension":[{"url":"http://hl7.org/fhir/StructureDefinition/data-absent-reason","valueCode":"unknown"}]}}"""

    fun <TPatient : Any> runScalarTests(
      fhirVersionName: String,
      patientSerializer: KSerializer<TPatient>,
      genderOf: (TPatient) -> Any?,
    ) {
      test("$fhirVersionName extension-only enum primitive survives a decode/encode round trip") {
        val patient = json.decodeFromString(patientSerializer, extensionOnlyGenderJson)
        assertNotNull(genderOf(patient), "sidecar-only gender should not decode to null")
        val reEncoded = json.encodeToString(patientSerializer, patient)
        assertEquals(
          json.parseToJsonElement(extensionOnlyGenderJson),
          json.parseToJsonElement(reEncoded),
        )
      }
    }

    runScalarTests("R4", serializer<R4Patient>()) { it.gender }
    runScalarTests("R4B", serializer<R4bPatient>()) { it.gender }
    runScalarTests("R5", serializer<R5Patient>()) { it.gender }

    test("R4 enum list with a sidecar-only entry survives a decode/encode round trip") {
      val allergyJson =
        """{"resourceType":"AllergyIntolerance","id":"a1","patient":{"reference":"Patient/p1"},"category":["food",null],"_category":[null,{"extension":[{"url":"http://hl7.org/fhir/StructureDefinition/data-absent-reason","valueCode":"unknown"}]}]}"""
      val allergy = json.decodeFromString(serializer<R4AllergyIntolerance>(), allergyJson)
      assertEquals(2, allergy.category.size)
      assertNotNull(allergy.category[0].value)
      assertNull(allergy.category[1].value)
      assertEquals(1, allergy.category[1].extension.size)
      val reEncoded: JsonElement =
        json.parseToJsonElement(json.encodeToString(serializer<R4AllergyIntolerance>(), allergy))
      assertEquals(json.parseToJsonElement(allergyJson), reEncoded)
    }
  })
