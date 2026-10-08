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

/** Codes identifying the lifecycle stage of a request. */
public enum class RequestStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Draft("draft", "http://hl7.org/fhir/request-status", "Draft"),
  Active("active", "http://hl7.org/fhir/request-status", "Active"),
  On_Hold("on-hold", "http://hl7.org/fhir/request-status", "On Hold"),
  Revoked("revoked", "http://hl7.org/fhir/request-status", "Revoked"),
  Completed("completed", "http://hl7.org/fhir/request-status", "Completed"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/request-status", "Entered in Error"),
  Unknown("unknown", "http://hl7.org/fhir/request-status", "Unknown");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): RequestStatus =
      when (code) {
        "draft" -> Draft
        "active" -> Active
        "on-hold" -> On_Hold
        "revoked" -> Revoked
        "completed" -> Completed
        "entered-in-error" -> Entered_In_Error
        "unknown" -> Unknown
        else -> throw IllegalArgumentException("Unknown code $code for enum RequestStatus")
      }
  }
}
