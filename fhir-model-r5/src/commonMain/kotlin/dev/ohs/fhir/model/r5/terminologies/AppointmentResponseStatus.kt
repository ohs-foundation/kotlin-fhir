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

/** The Participation status for a participant in response to a request for an appointment. */
public enum class AppointmentResponseStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Accepted("accepted", "http://hl7.org/fhir/participationstatus", "Accepted"),
  Declined("declined", "http://hl7.org/fhir/participationstatus", "Declined"),
  Tentative("tentative", "http://hl7.org/fhir/participationstatus", "Tentative"),
  Needs_Action("needs-action", "http://hl7.org/fhir/participationstatus", "Needs Action"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/appointmentstatus", "Entered in error");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AppointmentResponseStatus =
      when (code) {
        "accepted" -> Accepted
        "declined" -> Declined
        "tentative" -> Tentative
        "needs-action" -> Needs_Action
        "entered-in-error" -> Entered_In_Error
        else ->
          throw IllegalArgumentException("Unknown code $code for enum AppointmentResponseStatus")
      }
  }
}
