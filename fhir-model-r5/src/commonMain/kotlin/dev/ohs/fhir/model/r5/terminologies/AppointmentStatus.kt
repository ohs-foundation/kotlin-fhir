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

/** The free/busy status of an appointment. */
public enum class AppointmentStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Proposed("proposed", "http://hl7.org/fhir/appointmentstatus", "Proposed"),
  Pending("pending", "http://hl7.org/fhir/appointmentstatus", "Pending"),
  Booked("booked", "http://hl7.org/fhir/appointmentstatus", "Booked"),
  Arrived("arrived", "http://hl7.org/fhir/appointmentstatus", "Arrived"),
  Fulfilled("fulfilled", "http://hl7.org/fhir/appointmentstatus", "Fulfilled"),
  Cancelled("cancelled", "http://hl7.org/fhir/appointmentstatus", "Cancelled"),
  Noshow("noshow", "http://hl7.org/fhir/appointmentstatus", "No Show"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/appointmentstatus", "Entered in error"),
  Checked_In("checked-in", "http://hl7.org/fhir/appointmentstatus", "Checked In"),
  Waitlist("waitlist", "http://hl7.org/fhir/appointmentstatus", "Waitlisted");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AppointmentStatus =
      when (code) {
        "proposed" -> Proposed
        "pending" -> Pending
        "booked" -> Booked
        "arrived" -> Arrived
        "fulfilled" -> Fulfilled
        "cancelled" -> Cancelled
        "noshow" -> Noshow
        "entered-in-error" -> Entered_In_Error
        "checked-in" -> Checked_In
        "waitlist" -> Waitlist
        else -> throw IllegalArgumentException("Unknown code $code for enum AppointmentStatus")
      }
  }
}
