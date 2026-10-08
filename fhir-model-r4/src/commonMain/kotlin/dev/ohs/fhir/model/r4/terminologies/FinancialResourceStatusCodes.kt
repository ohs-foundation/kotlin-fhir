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

/** This value set includes Status codes. */
public enum class FinancialResourceStatusCodes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Active("active", "http://hl7.org/fhir/fm-status", "Active"),
  Cancelled("cancelled", "http://hl7.org/fhir/fm-status", "Cancelled"),
  Draft("draft", "http://hl7.org/fhir/fm-status", "Draft"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/fm-status", "Entered in Error");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): FinancialResourceStatusCodes =
      when (code) {
        "active" -> Active
        "cancelled" -> Cancelled
        "draft" -> Draft
        "entered-in-error" -> Entered_In_Error
        else ->
          throw IllegalArgumentException("Unknown code $code for enum FinancialResourceStatusCodes")
      }
  }
}
