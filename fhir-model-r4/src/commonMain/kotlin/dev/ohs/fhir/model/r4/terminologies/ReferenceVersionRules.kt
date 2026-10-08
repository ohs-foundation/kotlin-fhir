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

/**
 * Whether a reference needs to be version specific or version independent, or whether either can be
 * used.
 */
public enum class ReferenceVersionRules(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Either("either", "http://hl7.org/fhir/reference-version-rules", "Either Specific or independent"),
  Independent("independent", "http://hl7.org/fhir/reference-version-rules", "Version independent"),
  Specific("specific", "http://hl7.org/fhir/reference-version-rules", "Version Specific");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ReferenceVersionRules =
      when (code) {
        "either" -> Either
        "independent" -> Independent
        "specific" -> Specific
        else -> throw IllegalArgumentException("Unknown code $code for enum ReferenceVersionRules")
      }
  }
}
