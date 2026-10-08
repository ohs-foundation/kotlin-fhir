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

package dev.ohs.fhir.model.r4b.terminologies

import dev.ohs.fhir.model.r4b.FhirEnum
import kotlin.String

/** A code that identifies the status of the family history record. */
public enum class FamilyHistoryStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Partial("partial", "http://hl7.org/fhir/history-status", "Partial"),
  Completed("completed", "http://hl7.org/fhir/history-status", "Completed"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/history-status", "Entered in Error"),
  Health_Unknown("health-unknown", "http://hl7.org/fhir/history-status", "Health Unknown");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): FamilyHistoryStatus =
      when (code) {
        "partial" -> Partial
        "completed" -> Completed
        "entered-in-error" -> Entered_In_Error
        "health-unknown" -> Health_Unknown
        else -> throw IllegalArgumentException("Unknown code $code for enum FamilyHistoryStatus")
      }
  }
}
