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

import dev.ohs.fhir.model.r4.FhirDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class FhirDateTest {
  @Test
  fun deserializingAndSerializingYear_shouldProduceSameString() =
    deserializeAndSerializeDateTime("2025")

  @Test
  fun deserializingAndSerializingYearAndMonth_shouldProduceSameString() =
    deserializeAndSerializeDateTime("2025-09")

  @Test
  fun deserializingAndSerializingDate_shouldProduceSameString() =
    deserializeAndSerializeDateTime("2025-09-11")

  @Test
  fun deserializingInvalidString_shouldThrow() {
    assertFailsWith<IllegalStateException> { FhirDate.fromString("not-a-date") }
    assertFailsWith<IllegalStateException> { FhirDate.fromString("") }
  }

  private fun deserializeAndSerializeDateTime(string: String) {
    assertEquals(string, FhirDate.Companion.fromString(string).toString())
  }
}
