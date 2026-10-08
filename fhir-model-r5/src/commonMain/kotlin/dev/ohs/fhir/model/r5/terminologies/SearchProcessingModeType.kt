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

/**
 * How a search parameter relates to the set of elements returned by evaluating its expression
 * query.
 */
public enum class SearchProcessingModeType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Normal("normal", "http://hl7.org/fhir/search-processingmode", "Normal"),
  Phonetic("phonetic", "http://hl7.org/fhir/search-processingmode", "Phonetic"),
  Other("other", "http://hl7.org/fhir/search-processingmode", "Other");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SearchProcessingModeType =
      when (code) {
        "normal" -> Normal
        "phonetic" -> Phonetic
        "other" -> Other
        else ->
          throw IllegalArgumentException("Unknown code $code for enum SearchProcessingModeType")
      }
  }
}
