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

/** Indicates the state of the consent. */
public enum class ConsentState(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Draft("draft", "http://hl7.org/fhir/consent-state-codes", "Pending"),
  Proposed("proposed", "http://hl7.org/fhir/consent-state-codes", "Proposed"),
  Active("active", "http://hl7.org/fhir/consent-state-codes", "Active"),
  Rejected("rejected", "http://hl7.org/fhir/consent-state-codes", "Rejected"),
  Inactive("inactive", "http://hl7.org/fhir/consent-state-codes", "Inactive"),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/consent-state-codes",
    "Entered in Error",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ConsentState =
      when (code) {
        "draft" -> Draft
        "proposed" -> Proposed
        "active" -> Active
        "rejected" -> Rejected
        "inactive" -> Inactive
        "entered-in-error" -> Entered_In_Error
        else -> throw IllegalArgumentException("Unknown code $code for enum ConsentState")
      }
  }
}
