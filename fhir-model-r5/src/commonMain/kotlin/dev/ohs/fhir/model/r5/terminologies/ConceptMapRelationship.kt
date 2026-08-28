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

/** The relationship between concepts. */
public enum class ConceptMapRelationship(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Related_To("related-to", "http://hl7.org/fhir/concept-map-relationship", "Related To"),
  Equivalent("equivalent", "http://hl7.org/fhir/concept-map-relationship", "Equivalent"),
  Source_Is_Narrower_Than_Target(
    "source-is-narrower-than-target",
    "http://hl7.org/fhir/concept-map-relationship",
    "Source Is Narrower Than Target",
  ),
  Source_Is_Broader_Than_Target(
    "source-is-broader-than-target",
    "http://hl7.org/fhir/concept-map-relationship",
    "Source Is Broader Than Target",
  ),
  Not_Related_To(
    "not-related-to",
    "http://hl7.org/fhir/concept-map-relationship",
    "Not Related To",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ConceptMapRelationship =
      fromCodeOrNull(code)
        ?: throw IllegalArgumentException("Unknown code $code for enum ConceptMapRelationship")

    public fun fromCodeOrNull(code: String?): ConceptMapRelationship? =
      when (code) {
        "related-to" -> Related_To
        "equivalent" -> Equivalent
        "source-is-narrower-than-target" -> Source_Is_Narrower_Than_Target
        "source-is-broader-than-target" -> Source_Is_Broader_Than_Target
        "not-related-to" -> Not_Related_To
        else -> null
      }
  }
}
