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

/** Type for quality report. */
public enum class QualityType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Indel("indel", "http://hl7.org/fhir/quality-type", "INDEL Comparison"),
  Snp("snp", "http://hl7.org/fhir/quality-type", "SNP Comparison"),
  Unknown("unknown", "http://hl7.org/fhir/quality-type", "UNKNOWN Comparison");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): QualityType =
      when (code) {
        "indel" -> Indel
        "snp" -> Snp
        "unknown" -> Unknown
        else -> throw IllegalArgumentException("Unknown code $code for enum QualityType")
      }
  }
}
