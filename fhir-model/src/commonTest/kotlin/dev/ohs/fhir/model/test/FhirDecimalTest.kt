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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertFails

class FhirDecimalTest :
  FunSpec({
    fun roundTrip(fromString: (String) -> Any, value: String) =
      assertEquals(value, fromString(value).toString())

    fun reject(fromString: (String) -> Any, value: String) = assertFails { fromString(value) }

    fun fhirDecimalTestSuite(
      fhirVersion: String,
      fromString: (String) -> Any,
      fromBigDecimal: (BigDecimal) -> Any,
      asBigDecimal: (Any) -> BigDecimal,
    ) {
      context("$fhirVersion FhirDecimal") {
        // --- Lexical round-trip: fromString preserves the exact wire form verbatim. ---
        test("plain integer round-trips") { roundTrip(fromString, "100") }
        test("zero round-trips") { roundTrip(fromString, "0") }
        test("negative round-trips") { roundTrip(fromString, "-3.14") }
        test("trailing zeros are preserved") { roundTrip(fromString, "1.00") }
        test("single trailing zero is preserved") { roundTrip(fromString, "1.0") }
        test("leading fraction zeros are preserved") { roundTrip(fromString, "0.0100") }
        test("lowercase scientific round-trips") { roundTrip(fromString, "1.5e-3") }
        test("uppercase scientific round-trips") { roundTrip(fromString, "1E-22") }
        test("large negative scientific round-trips") {
          roundTrip(fromString, "-1.000000000000000000E+245")
        }
        test("large integer round-trips") { roundTrip(fromString, "1234567890123456789") }

        // --- Unparseable input is rejected by the underlying BigDecimal parse. ---
        test("rejects non-numeric") { reject(fromString, "abc") }
        test("rejects two decimal points") { reject(fromString, "1.2.3") }
        test("rejects comma separator") { reject(fromString, "1,5") }
        test("rejects hex notation") { reject(fromString, "0x10") }

        // --- fromBigDecimal uses the plain-string form as the wire representation. ---
        test("fromBigDecimal formats wire as plain string") {
          assertEquals("100", fromBigDecimal(BigDecimal.fromInt(100)).toString())
        }

        test("asBigDecimal returns numerical BigDecimal from parsed string") {
          assertEquals(BigDecimal.parseString("12.5"), asBigDecimal(fromString("12.5")))
        }
      }
    }

    fhirDecimalTestSuite(
      fhirVersion = "R4",
      fromString = dev.ohs.fhir.model.r4.FhirDecimal::fromString,
      fromBigDecimal = dev.ohs.fhir.model.r4.FhirDecimal::fromBigDecimal,
      asBigDecimal = { (it as dev.ohs.fhir.model.r4.FhirDecimal).asBigDecimal() },
    )
    fhirDecimalTestSuite(
      fhirVersion = "R4B",
      fromString = dev.ohs.fhir.model.r4b.FhirDecimal::fromString,
      fromBigDecimal = dev.ohs.fhir.model.r4b.FhirDecimal::fromBigDecimal,
      asBigDecimal = { (it as dev.ohs.fhir.model.r4b.FhirDecimal).asBigDecimal() },
    )
    fhirDecimalTestSuite(
      fhirVersion = "R5",
      fromString = dev.ohs.fhir.model.r5.FhirDecimal::fromString,
      fromBigDecimal = dev.ohs.fhir.model.r5.FhirDecimal::fromBigDecimal,
      asBigDecimal = { (it as dev.ohs.fhir.model.r5.FhirDecimal).asBigDecimal() },
    )
  })
