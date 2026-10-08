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

/** Indicates whether the account is available to be used. */
public enum class AccountStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Active("active", "http://hl7.org/fhir/account-status", "Active"),
  Inactive("inactive", "http://hl7.org/fhir/account-status", "Inactive"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/account-status", "Entered in error"),
  On_Hold("on-hold", "http://hl7.org/fhir/account-status", "On Hold"),
  Unknown("unknown", "http://hl7.org/fhir/account-status", "Unknown");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AccountStatus =
      when (code) {
        "active" -> Active
        "inactive" -> Inactive
        "entered-in-error" -> Entered_In_Error
        "on-hold" -> On_Hold
        "unknown" -> Unknown
        else -> throw IllegalArgumentException("Unknown code $code for enum AccountStatus")
      }
  }
}
