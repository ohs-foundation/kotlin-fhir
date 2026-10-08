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

/** Current state of the encounter. */
public enum class EncounterStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Planned("planned", "http://hl7.org/fhir/encounter-status", "Planned"),
  In_Progress("in-progress", "http://hl7.org/fhir/encounter-status", "In Progress"),
  On_Hold("on-hold", "http://hl7.org/fhir/encounter-status", "On Hold"),
  Discharged("discharged", "http://hl7.org/fhir/encounter-status", "Discharged"),
  Completed("completed", "http://hl7.org/fhir/encounter-status", "Completed"),
  Cancelled("cancelled", "http://hl7.org/fhir/encounter-status", "Cancelled"),
  Discontinued("discontinued", "http://hl7.org/fhir/encounter-status", "Discontinued"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/encounter-status", "Entered in Error"),
  Unknown("unknown", "http://hl7.org/fhir/encounter-status", "Unknown");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): EncounterStatus =
      when (code) {
        "planned" -> Planned
        "in-progress" -> In_Progress
        "on-hold" -> On_Hold
        "discharged" -> Discharged
        "completed" -> Completed
        "cancelled" -> Cancelled
        "discontinued" -> Discontinued
        "entered-in-error" -> Entered_In_Error
        "unknown" -> Unknown
        else -> throw IllegalArgumentException("Unknown code $code for enum EncounterStatus")
      }
  }
}
