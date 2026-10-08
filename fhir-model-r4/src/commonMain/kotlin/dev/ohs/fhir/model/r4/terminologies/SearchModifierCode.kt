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

/** A supported modifier for a search parameter. */
public enum class SearchModifierCode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Missing("missing", "http://hl7.org/fhir/search-modifier-code", "Missing"),
  Exact("exact", "http://hl7.org/fhir/search-modifier-code", "Exact"),
  Contains("contains", "http://hl7.org/fhir/search-modifier-code", "Contains"),
  Not("not", "http://hl7.org/fhir/search-modifier-code", "Not"),
  Text("text", "http://hl7.org/fhir/search-modifier-code", "Text"),
  In("in", "http://hl7.org/fhir/search-modifier-code", "In"),
  Not_In("not-in", "http://hl7.org/fhir/search-modifier-code", "Not In"),
  Below("below", "http://hl7.org/fhir/search-modifier-code", "Below"),
  Above("above", "http://hl7.org/fhir/search-modifier-code", "Above"),
  Type("type", "http://hl7.org/fhir/search-modifier-code", "Type"),
  Identifier("identifier", "http://hl7.org/fhir/search-modifier-code", "Identifier"),
  OfType("ofType", "http://hl7.org/fhir/search-modifier-code", "Of Type");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SearchModifierCode =
      when (code) {
        "missing" -> Missing
        "exact" -> Exact
        "contains" -> Contains
        "not" -> Not
        "text" -> Text
        "in" -> In
        "not-in" -> Not_In
        "below" -> Below
        "above" -> Above
        "type" -> Type
        "identifier" -> Identifier
        "ofType" -> OfType
        else -> throw IllegalArgumentException("Unknown code $code for enum SearchModifierCode")
      }
  }
}
