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

/** A code that indicates how the server supports conditional delete. */
public enum class ConditionalDeleteStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Not_Supported("not-supported", "http://hl7.org/fhir/conditional-delete-status", "Not Supported"),
  Single("single", "http://hl7.org/fhir/conditional-delete-status", "Single Deletes Supported"),
  Multiple(
    "multiple",
    "http://hl7.org/fhir/conditional-delete-status",
    "Multiple Deletes Supported",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ConditionalDeleteStatus =
      when (code) {
        "not-supported" -> Not_Supported
        "single" -> Single
        "multiple" -> Multiple
        else ->
          throw IllegalArgumentException("Unknown code $code for enum ConditionalDeleteStatus")
      }
  }
}
