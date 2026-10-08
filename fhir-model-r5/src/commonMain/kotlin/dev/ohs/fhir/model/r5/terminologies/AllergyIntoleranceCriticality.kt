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
 * Estimate of the potential clinical harm, or seriousness, of a reaction to an identified
 * substance.
 */
public enum class AllergyIntoleranceCriticality(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Low("low", "http://hl7.org/fhir/allergy-intolerance-criticality", "Low Risk"),
  High("high", "http://hl7.org/fhir/allergy-intolerance-criticality", "High Risk"),
  Unable_To_Assess(
    "unable-to-assess",
    "http://hl7.org/fhir/allergy-intolerance-criticality",
    "Unable to Assess Risk",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AllergyIntoleranceCriticality =
      when (code) {
        "low" -> Low
        "high" -> High
        "unable-to-assess" -> Unable_To_Assess
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum AllergyIntoleranceCriticality"
          )
      }
  }
}
