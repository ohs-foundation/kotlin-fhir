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

class FhirDateTest :
  FunSpec({
    fun roundTrip(fromString: (String) -> String, value: String) =
      assertEquals(value, fromString(value))

    fun fhirDateTestSuite(fhirVersion: String, fromString: (String) -> String) {
      context("$fhirVersion FhirDate") {
        test("deserializing and serializing year produces same string") {
          roundTrip(fromString, "2025")
        }
        test("deserializing and serializing year and month produces same string") {
          roundTrip(fromString, "2025-09")
        }
        test("deserializing and serializing date produces same string") {
          roundTrip(fromString, "2025-09-11")
        }
      }
    }

    fhirDateTestSuite("R4") { dev.ohs.fhir.model.r4.FhirDate.fromString(it).toString() }
    fhirDateTestSuite("R4B") { dev.ohs.fhir.model.r4b.FhirDate.fromString(it).toString() }
    fhirDateTestSuite("R5") { dev.ohs.fhir.model.r5.FhirDate.fromString(it).toString() }
  })
