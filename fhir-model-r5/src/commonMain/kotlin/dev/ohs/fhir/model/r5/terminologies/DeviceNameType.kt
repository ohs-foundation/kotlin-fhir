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

/** The type of name the device is referred by. */
public enum class DeviceNameType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Registered_Name("registered-name", "http://hl7.org/fhir/device-nametype", "Registered name"),
  User_Friendly_Name(
    "user-friendly-name",
    "http://hl7.org/fhir/device-nametype",
    "User Friendly name",
  ),
  Patient_Reported_Name(
    "patient-reported-name",
    "http://hl7.org/fhir/device-nametype",
    "Patient Reported name",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DeviceNameType =
      when (code) {
        "registered-name" -> Registered_Name
        "user-friendly-name" -> User_Friendly_Name
        "patient-reported-name" -> Patient_Reported_Name
        else -> throw IllegalArgumentException("Unknown code $code for enum DeviceNameType")
      }
  }
}
