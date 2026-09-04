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

import dev.ohs.fhir.model.r4.Enumeration as R4Enumeration
import dev.ohs.fhir.model.r4.FhirEnum as R4FhirEnum
import dev.ohs.fhir.model.r4.terminologies.AdministrativeGender as R4Gender
import dev.ohs.fhir.model.r4b.Enumeration as R4bEnumeration
import dev.ohs.fhir.model.r4b.FhirEnum as R4bFhirEnum
import dev.ohs.fhir.model.r4b.terminologies.AdministrativeGender as R4bGender
import dev.ohs.fhir.model.r5.Enumeration as R5Enumeration
import dev.ohs.fhir.model.r5.FhirEnum as R5FhirEnum
import dev.ohs.fhir.model.r5.terminologies.AdministrativeGender as R5Gender
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertIs

class FhirEnumTest :
  FunSpec({
    test("R4 generated enum implements FhirEnum and provides code, system, display") {
      val gender: R4FhirEnum = R4Gender.Male
      assertEquals("male", gender.code)
      assertEquals("http://hl7.org/fhir/administrative-gender", gender.system)
      assertEquals("Male", gender.display)
      assertEquals("male", gender.toString())

      val enumeration = R4Enumeration.of(R4Gender.Female, null)
      assertIs<R4Enumeration<R4Gender>>(enumeration)
      assertEquals("female", enumeration.value?.code)
    }

    test("R4B generated enum implements FhirEnum and provides code, system, display") {
      val gender: R4bFhirEnum = R4bGender.Female
      assertEquals("female", gender.code)
      assertEquals("http://hl7.org/fhir/administrative-gender", gender.system)
      assertEquals("Female", gender.display)
      assertEquals("female", gender.toString())

      val enumeration = R4bEnumeration.of(R4bGender.Female, null)
      assertIs<R4bEnumeration<R4bGender>>(enumeration)
      assertEquals("female", enumeration.value?.code)
    }

    test("R5 generated enum implements FhirEnum and provides code, system, display") {
      val gender: R5FhirEnum = R5Gender.Other
      assertEquals("other", gender.code)
      assertEquals("http://hl7.org/fhir/administrative-gender", gender.system)
      assertEquals("Other", gender.display)
      assertEquals("other", gender.toString())

      val enumeration = R5Enumeration.of(R5Gender.Other, null)
      assertIs<R5Enumeration<R5Gender>>(enumeration)
      assertEquals("other", enumeration.value?.code)
    }
  })
