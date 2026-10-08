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

/**
 * Why an entry is in the result set - whether it's included as a match or because of an _include
 * requirement, or to convey information or warning information about the search process.
 */
public enum class SearchEntryMode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Match("match", "http://hl7.org/fhir/search-entry-mode", "Match"),
  Include("include", "http://hl7.org/fhir/search-entry-mode", "Include"),
  Outcome("outcome", "http://hl7.org/fhir/search-entry-mode", "Outcome");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SearchEntryMode =
      when (code) {
        "match" -> Match
        "include" -> Include
        "outcome" -> Outcome
        else -> throw IllegalArgumentException("Unknown code $code for enum SearchEntryMode")
      }
  }
}
