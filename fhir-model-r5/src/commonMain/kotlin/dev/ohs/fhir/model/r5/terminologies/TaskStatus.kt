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

/** The current status of the task. */
public enum class TaskStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Draft("draft", "http://hl7.org/fhir/task-status", "Draft"),
  Requested("requested", "http://hl7.org/fhir/task-status", "Requested"),
  Received("received", "http://hl7.org/fhir/task-status", "Received"),
  Accepted("accepted", "http://hl7.org/fhir/task-status", "Accepted"),
  Rejected("rejected", "http://hl7.org/fhir/task-status", "Rejected"),
  Ready("ready", "http://hl7.org/fhir/task-status", "Ready"),
  Cancelled("cancelled", "http://hl7.org/fhir/task-status", "Cancelled"),
  In_Progress("in-progress", "http://hl7.org/fhir/task-status", "In Progress"),
  On_Hold("on-hold", "http://hl7.org/fhir/task-status", "On Hold"),
  Failed("failed", "http://hl7.org/fhir/task-status", "Failed"),
  Completed("completed", "http://hl7.org/fhir/task-status", "Completed"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/task-status", "Entered in Error");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): TaskStatus =
      when (code) {
        "draft" -> Draft
        "requested" -> Requested
        "received" -> Received
        "accepted" -> Accepted
        "rejected" -> Rejected
        "ready" -> Ready
        "cancelled" -> Cancelled
        "in-progress" -> In_Progress
        "on-hold" -> On_Hold
        "failed" -> Failed
        "completed" -> Completed
        "entered-in-error" -> Entered_In_Error
        else -> throw IllegalArgumentException("Unknown code $code for enum TaskStatus")
      }
  }
}
