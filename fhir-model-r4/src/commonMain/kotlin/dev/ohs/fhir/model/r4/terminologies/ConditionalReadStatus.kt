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

/** A code that indicates how the server supports conditional read. */
public enum class ConditionalReadStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Not_Supported("not-supported", "http://hl7.org/fhir/conditional-read-status", "Not Supported"),
  Modified_Since(
    "modified-since",
    "http://hl7.org/fhir/conditional-read-status",
    "If-Modified-Since",
  ),
  Not_Match("not-match", "http://hl7.org/fhir/conditional-read-status", "If-None-Match"),
  Full_Support("full-support", "http://hl7.org/fhir/conditional-read-status", "Full Support");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ConditionalReadStatus =
      when (code) {
        "not-supported" -> Not_Supported
        "modified-since" -> Modified_Since
        "not-match" -> Not_Match
        "full-support" -> Full_Support
        else -> throw IllegalArgumentException("Unknown code $code for enum ConditionalReadStatus")
      }
  }
}
