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

/**
 * Set of codes used to value Act.Confidentiality and Role.Confidentiality attribute in accordance
 * with the definition for concept domain "Confidentiality".
 */
public enum class V3ConfidentialityClassification(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  U("U", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "unrestricted"),
  L("L", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "low"),
  M("M", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "moderate"),
  N("N", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "normal"),
  R("R", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "restricted"),
  V("V", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "very restricted");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): V3ConfidentialityClassification =
      when (code) {
        "U" -> U
        "L" -> L
        "M" -> M
        "N" -> N
        "R" -> R
        "V" -> V
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum V3ConfidentialityClassification"
          )
      }
  }
}
