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

class FhirDateTimeTest :
  FunSpec({
    fun roundTrip(fromString: (String?) -> Any?, value: String) =
      assertEquals(value, fromString(value).toString())

    fun reject(fromString: (String?) -> Any?, value: String) =
      assertFailsWith<IllegalStateException> { fromString(value) }

    fun fhirDateTimeTestSuite(fhirVersion: String, fromString: (String?) -> Any?) {
      context("$fhirVersion FhirDateTime") {
        test("deserializing and serializing year produces same string") {
          roundTrip(fromString, "2025")
        }

        test("deserializing and serializing year and month produces same string") {
          roundTrip(fromString, "2025-09")
        }

        test("deserializing and serializing date produces same string") {
          roundTrip(fromString, "2025-09-11")
        }

        test("deserializing and serializing date-time produces same string") {
          roundTrip(fromString, "2025-09-11T20:20:00Z")
        }

        test("deserializing and serializing date-time with milliseconds produces same string") {
          roundTrip(fromString, "2025-09-11T20:20:00.001Z")
        }

        test("deserializing date-time without timezone throws IllegalStateException") {
          reject(fromString, "2025-09-11T20:20:00")
        }

        test(
          "deserializing date-time with milliseconds without timezone throws IllegalStateException"
        ) {
          reject(fromString, "2025-09-11T20:20:00.001")
        }
      }
    }

    fhirDateTimeTestSuite("R4", dev.ohs.fhir.model.r4.FhirDateTime::fromString)
    fhirDateTimeTestSuite("R4B", dev.ohs.fhir.model.r4b.FhirDateTime::fromString)
    fhirDateTimeTestSuite("R5", dev.ohs.fhir.model.r5.FhirDateTime::fromString)
  })
