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

/** The type of relationship to the related artifact. */
public enum class RelatedArtifactType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Documentation("documentation", "http://hl7.org/fhir/related-artifact-type", "Documentation"),
  Justification("justification", "http://hl7.org/fhir/related-artifact-type", "Justification"),
  Citation("citation", "http://hl7.org/fhir/related-artifact-type", "Citation"),
  Predecessor("predecessor", "http://hl7.org/fhir/related-artifact-type", "Predecessor"),
  Successor("successor", "http://hl7.org/fhir/related-artifact-type", "Successor"),
  Derived_From("derived-from", "http://hl7.org/fhir/related-artifact-type", "Derived From"),
  Depends_On("depends-on", "http://hl7.org/fhir/related-artifact-type", "Depends On"),
  Composed_Of("composed-of", "http://hl7.org/fhir/related-artifact-type", "Composed Of");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): RelatedArtifactType =
      when (code) {
        "documentation" -> Documentation
        "justification" -> Justification
        "citation" -> Citation
        "predecessor" -> Predecessor
        "successor" -> Successor
        "derived-from" -> Derived_From
        "depends-on" -> Depends_On
        "composed-of" -> Composed_Of
        else -> throw IllegalArgumentException("Unknown code $code for enum RelatedArtifactType")
      }
  }
}
