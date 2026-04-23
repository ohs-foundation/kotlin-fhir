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

import dev.ohs.fhir.model.r4.FhirDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class FhirDateTimeTest {
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
  fun deserializingAndSerializingDateTime_shouldProduceSameString() =
    deserializeAndSerializeDateTime("2025-09-11T20:20:00Z")

  @Test
  fun deserializingAndSerializingDateTimeWithMilliseconds_shouldProduceSameString() =
    deserializeAndSerializeDateTime("2025-09-11T20:20:00.001Z")

  @Test
  fun deserializingDateTimeWithoutTimezone_shouldThrowError() {
    assertFailsWith<IllegalStateException> { FhirDateTime.fromString("2025-09-11T20:20:00") }
  }

  @Test
  fun deserializingDateTimeWithMillisecondsWithoutTimezone_shouldThrowError() {
    assertFailsWith<IllegalStateException> { FhirDateTime.fromString("2025-09-11T20:20:00.001") }
  }

  private fun deserializeAndSerializeDateTime(string: String) {
    assertEquals(string, FhirDateTime.Companion.fromString(string).toString())
  }
}
