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

/** The type of trigger. */
public enum class TriggerType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Named_Event("named-event", "http://hl7.org/fhir/trigger-type", "Named Event"),
  Periodic("periodic", "http://hl7.org/fhir/trigger-type", "Periodic"),
  Data_Changed("data-changed", "http://hl7.org/fhir/trigger-type", "Data Changed"),
  Data_Added("data-added", "http://hl7.org/fhir/trigger-type", "Data Added"),
  Data_Modified("data-modified", "http://hl7.org/fhir/trigger-type", "Data Updated"),
  Data_Removed("data-removed", "http://hl7.org/fhir/trigger-type", "Data Removed"),
  Data_Accessed("data-accessed", "http://hl7.org/fhir/trigger-type", "Data Accessed"),
  Data_Access_Ended("data-access-ended", "http://hl7.org/fhir/trigger-type", "Data Access Ended");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): TriggerType =
      when (code) {
        "named-event" -> Named_Event
        "periodic" -> Periodic
        "data-changed" -> Data_Changed
        "data-added" -> Data_Added
        "data-modified" -> Data_Modified
        "data-removed" -> Data_Removed
        "data-accessed" -> Data_Accessed
        "data-access-ended" -> Data_Access_Ended
        else -> throw IllegalArgumentException("Unknown code $code for enum TriggerType")
      }
  }
}
