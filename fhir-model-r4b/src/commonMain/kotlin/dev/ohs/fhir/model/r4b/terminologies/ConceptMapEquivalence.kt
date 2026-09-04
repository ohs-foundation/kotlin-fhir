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

/** The degree of equivalence between concepts. */
public enum class ConceptMapEquivalence(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Relatedto("relatedto", "http://hl7.org/fhir/concept-map-equivalence", "Related To"),
  Equivalent("equivalent", "http://hl7.org/fhir/concept-map-equivalence", "Equivalent"),
  Equal("equal", "http://hl7.org/fhir/concept-map-equivalence", "Equal"),
  Wider("wider", "http://hl7.org/fhir/concept-map-equivalence", "Wider"),
  Subsumes("subsumes", "http://hl7.org/fhir/concept-map-equivalence", "Subsumes"),
  Narrower("narrower", "http://hl7.org/fhir/concept-map-equivalence", "Narrower"),
  Specializes("specializes", "http://hl7.org/fhir/concept-map-equivalence", "Specializes"),
  Inexact("inexact", "http://hl7.org/fhir/concept-map-equivalence", "Inexact"),
  Unmatched("unmatched", "http://hl7.org/fhir/concept-map-equivalence", "Unmatched"),
  Disjoint("disjoint", "http://hl7.org/fhir/concept-map-equivalence", "Disjoint");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ConceptMapEquivalence =
      when (code) {
        "relatedto" -> Relatedto
        "equivalent" -> Equivalent
        "equal" -> Equal
        "wider" -> Wider
        "subsumes" -> Subsumes
        "narrower" -> Narrower
        "specializes" -> Specializes
        "inexact" -> Inexact
        "unmatched" -> Unmatched
        "disjoint" -> Disjoint
        else -> throw IllegalArgumentException("Unknown code $code for enum ConceptMapEquivalence")
      }
  }
}
