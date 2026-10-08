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

/** Overall defining type of this clinical use definition. */
public enum class ClinicalUseDefinitionType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Indication("indication", "http://hl7.org/fhir/clinical-use-definition-type", "Indication"),
  Contraindication(
    "contraindication",
    "http://hl7.org/fhir/clinical-use-definition-type",
    "Contraindication",
  ),
  Interaction("interaction", "http://hl7.org/fhir/clinical-use-definition-type", "Interaction"),
  Undesirable_Effect(
    "undesirable-effect",
    "http://hl7.org/fhir/clinical-use-definition-type",
    "Undesirable Effect",
  ),
  Warning("warning", "http://hl7.org/fhir/clinical-use-definition-type", "Warning");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ClinicalUseDefinitionType =
      when (code) {
        "indication" -> Indication
        "contraindication" -> Contraindication
        "interaction" -> Interaction
        "undesirable-effect" -> Undesirable_Effect
        "warning" -> Warning
        else ->
          throw IllegalArgumentException("Unknown code $code for enum ClinicalUseDefinitionType")
      }
  }
}
