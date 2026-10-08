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

/** Codes that reflect the current state of a goal and whether the goal is still being targeted. */
public enum class GoalLifecycleStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Proposed("proposed", "http://hl7.org/fhir/goal-status", "Proposed"),
  Planned("planned", "http://hl7.org/fhir/goal-status", "Planned"),
  Accepted("accepted", "http://hl7.org/fhir/goal-status", "Accepted"),
  Active("active", "http://hl7.org/fhir/goal-status", "Active"),
  On_Hold("on-hold", "http://hl7.org/fhir/goal-status", "On Hold"),
  Completed("completed", "http://hl7.org/fhir/goal-status", "Completed"),
  Cancelled("cancelled", "http://hl7.org/fhir/goal-status", "Cancelled"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/goal-status", "Entered in Error"),
  Rejected("rejected", "http://hl7.org/fhir/goal-status", "Rejected");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): GoalLifecycleStatus =
      when (code) {
        "proposed" -> Proposed
        "planned" -> Planned
        "accepted" -> Accepted
        "active" -> Active
        "on-hold" -> On_Hold
        "completed" -> Completed
        "cancelled" -> Cancelled
        "entered-in-error" -> Entered_In_Error
        "rejected" -> Rejected
        else -> throw IllegalArgumentException("Unknown code $code for enum GoalLifecycleStatus")
      }
  }
}
