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

/** The status of a guidance response. */
public enum class GuidanceResponseStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Success("success", "http://hl7.org/fhir/guidance-response-status", "Success"),
  Data_Requested(
    "data-requested",
    "http://hl7.org/fhir/guidance-response-status",
    "Data Requested",
  ),
  Data_Required("data-required", "http://hl7.org/fhir/guidance-response-status", "Data Required"),
  In_Progress("in-progress", "http://hl7.org/fhir/guidance-response-status", "In Progress"),
  Failure("failure", "http://hl7.org/fhir/guidance-response-status", "Failure"),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/guidance-response-status",
    "Entered In Error",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): GuidanceResponseStatus =
      when (code) {
        "success" -> Success
        "data-requested" -> Data_Requested
        "data-required" -> Data_Required
        "in-progress" -> In_Progress
        "failure" -> Failure
        "entered-in-error" -> Entered_In_Error
        else -> throw IllegalArgumentException("Unknown code $code for enum GuidanceResponseStatus")
      }
  }
}
