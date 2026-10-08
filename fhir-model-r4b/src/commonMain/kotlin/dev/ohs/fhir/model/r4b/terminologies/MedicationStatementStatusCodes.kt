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

/** MedicationStatement Status Codes */
public enum class MedicationStatementStatusCodes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Active("active", "http://hl7.org/fhir/CodeSystem/medication-statement-status", "Active"),
  Completed("completed", "http://hl7.org/fhir/CodeSystem/medication-statement-status", "Completed"),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/CodeSystem/medication-statement-status",
    "Entered in Error",
  ),
  Intended("intended", "http://hl7.org/fhir/CodeSystem/medication-statement-status", "Intended"),
  Stopped("stopped", "http://hl7.org/fhir/CodeSystem/medication-statement-status", "Stopped"),
  On_Hold("on-hold", "http://hl7.org/fhir/CodeSystem/medication-statement-status", "On Hold"),
  Unknown("unknown", "http://hl7.org/fhir/CodeSystem/medication-statement-status", "Unknown"),
  Not_Taken("not-taken", "http://hl7.org/fhir/CodeSystem/medication-statement-status", "Not Taken");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): MedicationStatementStatusCodes =
      when (code) {
        "active" -> Active
        "completed" -> Completed
        "entered-in-error" -> Entered_In_Error
        "intended" -> Intended
        "stopped" -> Stopped
        "on-hold" -> On_Hold
        "unknown" -> Unknown
        "not-taken" -> Not_Taken
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum MedicationStatementStatusCodes"
          )
      }
  }
}
