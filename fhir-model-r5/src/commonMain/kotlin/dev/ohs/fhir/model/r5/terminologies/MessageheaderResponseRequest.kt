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

/**
 * HL7-defined table of codes which identify conditions under which acknowledgments are required to
 * be returned in response to a message.
 */
public enum class MessageheaderResponseRequest(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Always("always", "http://hl7.org/fhir/messageheader-response-request", "Always"),
  On_Error(
    "on-error",
    "http://hl7.org/fhir/messageheader-response-request",
    "Error/reject conditions only",
  ),
  Never("never", "http://hl7.org/fhir/messageheader-response-request", "Never"),
  On_Success(
    "on-success",
    "http://hl7.org/fhir/messageheader-response-request",
    "Successful completion only",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): MessageheaderResponseRequest =
      when (code) {
        "always" -> Always
        "on-error" -> On_Error
        "never" -> Never
        "on-success" -> On_Success
        else ->
          throw IllegalArgumentException("Unknown code $code for enum MessageheaderResponseRequest")
      }
  }
}
