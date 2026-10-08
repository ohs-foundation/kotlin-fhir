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

package dev.ohs.fhir.model.r4.terminologies

import dev.ohs.fhir.model.r4.FhirEnum
import kotlin.String

/** Codes that reflect the current state of a care plan activity within its overall life cycle. */
public enum class CarePlanActivityStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Not_Started("not-started", "http://hl7.org/fhir/care-plan-activity-status", "Not Started"),
  Scheduled("scheduled", "http://hl7.org/fhir/care-plan-activity-status", "Scheduled"),
  In_Progress("in-progress", "http://hl7.org/fhir/care-plan-activity-status", "In Progress"),
  On_Hold("on-hold", "http://hl7.org/fhir/care-plan-activity-status", "On Hold"),
  Completed("completed", "http://hl7.org/fhir/care-plan-activity-status", "Completed"),
  Cancelled("cancelled", "http://hl7.org/fhir/care-plan-activity-status", "Cancelled"),
  Stopped("stopped", "http://hl7.org/fhir/care-plan-activity-status", "Stopped"),
  Unknown("unknown", "http://hl7.org/fhir/care-plan-activity-status", "Unknown"),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/care-plan-activity-status",
    "Entered in Error",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): CarePlanActivityStatus =
      when (code) {
        "not-started" -> Not_Started
        "scheduled" -> Scheduled
        "in-progress" -> In_Progress
        "on-hold" -> On_Hold
        "completed" -> Completed
        "cancelled" -> Cancelled
        "stopped" -> Stopped
        "unknown" -> Unknown
        "entered-in-error" -> Entered_In_Error
        else -> throw IllegalArgumentException("Unknown code $code for enum CarePlanActivityStatus")
      }
  }
}
