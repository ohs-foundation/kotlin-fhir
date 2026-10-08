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

/** Is the Participant required to attend the appointment. */
public enum class ParticipantRequired(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Required("required", "http://hl7.org/fhir/participantrequired", "Required"),
  Optional("optional", "http://hl7.org/fhir/participantrequired", "Optional"),
  Information_Only(
    "information-only",
    "http://hl7.org/fhir/participantrequired",
    "Information Only",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ParticipantRequired =
      when (code) {
        "required" -> Required
        "optional" -> Optional
        "information-only" -> Information_Only
        else -> throw IllegalArgumentException("Unknown code $code for enum ParticipantRequired")
      }
  }
}
