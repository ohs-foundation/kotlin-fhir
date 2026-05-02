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

import dev.ohs.fhir.model.r4.Boolean as FhirBoolean
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.PatientSearchParam
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.datetime.LocalDate

class SearchParamAllUsageTest :
  FunSpec({
    test("ALL is required when the param name is data, not a Kotlin identifier") {
      val patient =
        Patient(
          active = FhirBoolean(`value` = true),
          birthDate = Date(`value` = FhirDate.Date(LocalDate(1990, 1, 1))),
        )

      // The param name is a String, pretend it came from a URL query, a config file, an RPC
      // payload, anywhere external. You can't write `patient.<incomingParamName>` in Kotlin.
      val incomingParamName: String = "birthdate"

      // Without ALL, you'd have to hand-roll the mapping:
      //
      //   when (incomingParamName) {
      //       "active" -> listOfNotNull(patient.active)
      //       "birthdate" -> listOfNotNull(patient.birthDate)
      //       "gender" -> listOfNotNull(patient.gender)
      //       // ... dozens more, kept in sync by hand every time the FHIR spec adds a search
      //       // param ...
      //   }
      //
      // ALL is that mapping, generated and always current.
      val sp = PatientSearchParam.ALL.first { it.paramName == incomingParamName }
      sp.extract(patient).single() shouldBe patient.birthDate
    }
  })
