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

/** Logical grouping of characteristics. */
public enum class CharacteristicCombination(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  All_Of("all-of", "http://hl7.org/fhir/characteristic-combination", "All of"),
  Any_Of("any-of", "http://hl7.org/fhir/characteristic-combination", "Any of"),
  At_Least("at-least", "http://hl7.org/fhir/characteristic-combination", "At least"),
  At_Most("at-most", "http://hl7.org/fhir/characteristic-combination", "At most"),
  Statistical("statistical", "http://hl7.org/fhir/characteristic-combination", "Statistical"),
  Net_Effect("net-effect", "http://hl7.org/fhir/characteristic-combination", "Net effect"),
  Dataset("dataset", "http://hl7.org/fhir/characteristic-combination", "Dataset");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): CharacteristicCombination =
      when (code) {
        "all-of" -> All_Of
        "any-of" -> Any_Of
        "at-least" -> At_Least
        "at-most" -> At_Most
        "statistical" -> Statistical
        "net-effect" -> Net_Effect
        "dataset" -> Dataset
        else ->
          throw IllegalArgumentException("Unknown code $code for enum CharacteristicCombination")
      }
  }
}
