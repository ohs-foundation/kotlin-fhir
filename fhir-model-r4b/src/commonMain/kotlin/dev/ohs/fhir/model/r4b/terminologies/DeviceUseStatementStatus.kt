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

/** A coded concept indicating the current status of the Device Usage. */
public enum class DeviceUseStatementStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Active("active", "http://hl7.org/fhir/device-statement-status", "Active"),
  Completed("completed", "http://hl7.org/fhir/device-statement-status", "Completed"),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/device-statement-status",
    "Entered in Error",
  ),
  Intended("intended", "http://hl7.org/fhir/device-statement-status", "Intended"),
  Stopped("stopped", "http://hl7.org/fhir/device-statement-status", "Stopped"),
  On_Hold("on-hold", "http://hl7.org/fhir/device-statement-status", "On Hold");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DeviceUseStatementStatus =
      when (code) {
        "active" -> Active
        "completed" -> Completed
        "entered-in-error" -> Entered_In_Error
        "intended" -> Intended
        "stopped" -> Stopped
        "on-hold" -> On_Hold
        else ->
          throw IllegalArgumentException("Unknown code $code for enum DeviceUseStatementStatus")
      }
  }
}
