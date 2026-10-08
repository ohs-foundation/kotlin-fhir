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

/** MedicationDispense Status Codes */
public enum class MedicationDispenseStatusCodes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Preparation(
    "preparation",
    "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
    "Preparation",
  ),
  In_Progress(
    "in-progress",
    "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
    "In Progress",
  ),
  Cancelled(
    "cancelled",
    "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
    "Cancelled",
  ),
  On_Hold("on-hold", "http://terminology.hl7.org/CodeSystem/medicationdispense-status", "On Hold"),
  Completed(
    "completed",
    "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
    "Completed",
  ),
  Entered_In_Error(
    "entered-in-error",
    "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
    "Entered in Error",
  ),
  Stopped("stopped", "http://terminology.hl7.org/CodeSystem/medicationdispense-status", "Stopped"),
  Declined(
    "declined",
    "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
    "Declined",
  ),
  Unknown("unknown", "http://terminology.hl7.org/CodeSystem/medicationdispense-status", "Unknown");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): MedicationDispenseStatusCodes =
      when (code) {
        "preparation" -> Preparation
        "in-progress" -> In_Progress
        "cancelled" -> Cancelled
        "on-hold" -> On_Hold
        "completed" -> Completed
        "entered-in-error" -> Entered_In_Error
        "stopped" -> Stopped
        "declined" -> Declined
        "unknown" -> Unknown
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum MedicationDispenseStatusCodes"
          )
      }
  }
}
