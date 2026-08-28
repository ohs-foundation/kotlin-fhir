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

/** The lifecycle status of an artifact. */
public enum class PublicationStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Draft("draft", "http://hl7.org/fhir/publication-status", "Draft"),
  Active("active", "http://hl7.org/fhir/publication-status", "Active"),
  Retired("retired", "http://hl7.org/fhir/publication-status", "Retired"),
  Unknown("unknown", "http://hl7.org/fhir/publication-status", "Unknown");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): PublicationStatus =
      fromCodeOrNull(code)
        ?: throw IllegalArgumentException("Unknown code $code for enum PublicationStatus")

    public fun fromCodeOrNull(code: String?): PublicationStatus? =
      when (code) {
        "draft" -> Draft
        "active" -> Active
        "retired" -> Retired
        "unknown" -> Unknown
        else -> null
      }
  }
}
