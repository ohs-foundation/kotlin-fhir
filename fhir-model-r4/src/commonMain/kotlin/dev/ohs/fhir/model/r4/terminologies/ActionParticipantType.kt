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

/** The type of participant for the action. */
public enum class ActionParticipantType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Patient("patient", "http://hl7.org/fhir/action-participant-type", "Patient"),
  Practitioner("practitioner", "http://hl7.org/fhir/action-participant-type", "Practitioner"),
  Related_Person("related-person", "http://hl7.org/fhir/action-participant-type", "Related Person"),
  Device("device", "http://hl7.org/fhir/action-participant-type", "Device");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ActionParticipantType =
      when (code) {
        "patient" -> Patient
        "practitioner" -> Practitioner
        "related-person" -> Related_Person
        "device" -> Device
        else -> throw IllegalArgumentException("Unknown code $code for enum ActionParticipantType")
      }
  }
}
