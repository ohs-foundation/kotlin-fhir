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

package dev.ohs.fhir.model.r5.terminologies

import dev.ohs.fhir.model.r5.FhirEnum
import kotlin.String

/** The days of the week. */
public enum class DaysOfWeek(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Mon("mon", "http://hl7.org/fhir/days-of-week", "Monday"),
  Tue("tue", "http://hl7.org/fhir/days-of-week", "Tuesday"),
  Wed("wed", "http://hl7.org/fhir/days-of-week", "Wednesday"),
  Thu("thu", "http://hl7.org/fhir/days-of-week", "Thursday"),
  Fri("fri", "http://hl7.org/fhir/days-of-week", "Friday"),
  Sat("sat", "http://hl7.org/fhir/days-of-week", "Saturday"),
  Sun("sun", "http://hl7.org/fhir/days-of-week", "Sunday");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DaysOfWeek =
      when (code) {
        "mon" -> Mon
        "tue" -> Tue
        "wed" -> Wed
        "thu" -> Thu
        "fri" -> Fri
        "sat" -> Sat
        "sun" -> Sun
        else -> throw IllegalArgumentException("Unknown code $code for enum DaysOfWeek")
      }
  }
}
