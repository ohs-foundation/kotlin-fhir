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

/** How an entity was used in an activity. */
public enum class ProvenanceEntityRole(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Derivation("derivation", "http://hl7.org/fhir/provenance-entity-role", "Derivation"),
  Revision("revision", "http://hl7.org/fhir/provenance-entity-role", "Revision"),
  Quotation("quotation", "http://hl7.org/fhir/provenance-entity-role", "Quotation"),
  Source("source", "http://hl7.org/fhir/provenance-entity-role", "Source"),
  Removal("removal", "http://hl7.org/fhir/provenance-entity-role", "Removal");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ProvenanceEntityRole =
      when (code) {
        "derivation" -> Derivation
        "revision" -> Revision
        "quotation" -> Quotation
        "source" -> Source
        "removal" -> Removal
        else -> throw IllegalArgumentException("Unknown code $code for enum ProvenanceEntityRole")
      }
  }
}
