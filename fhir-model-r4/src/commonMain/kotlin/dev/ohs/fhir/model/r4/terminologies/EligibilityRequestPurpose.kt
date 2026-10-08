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

/** A code specifying the types of information being requested. */
public enum class EligibilityRequestPurpose(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Auth_Requirements(
    "auth-requirements",
    "http://hl7.org/fhir/eligibilityrequest-purpose",
    "Coverage auth-requirements",
  ),
  Benefits("benefits", "http://hl7.org/fhir/eligibilityrequest-purpose", "Coverage benefits"),
  Discovery("discovery", "http://hl7.org/fhir/eligibilityrequest-purpose", "Coverage Discovery"),
  Validation("validation", "http://hl7.org/fhir/eligibilityrequest-purpose", "Coverage Validation");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): EligibilityRequestPurpose =
      when (code) {
        "auth-requirements" -> Auth_Requirements
        "benefits" -> Benefits
        "discovery" -> Discovery
        "validation" -> Validation
        else ->
          throw IllegalArgumentException("Unknown code $code for enum EligibilityRequestPurpose")
      }
  }
}
