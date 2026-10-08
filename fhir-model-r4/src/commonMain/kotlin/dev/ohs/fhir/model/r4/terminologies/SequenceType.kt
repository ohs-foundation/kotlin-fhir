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

/** Type if a sequence -- DNA, RNA, or amino acid sequence. */
public enum class SequenceType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Aa("aa", "http://hl7.org/fhir/sequence-type", "AA Sequence"),
  Dna("dna", "http://hl7.org/fhir/sequence-type", "DNA Sequence"),
  Rna("rna", "http://hl7.org/fhir/sequence-type", "RNA Sequence");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SequenceType =
      when (code) {
        "aa" -> Aa
        "dna" -> Dna
        "rna" -> Rna
        else -> throw IllegalArgumentException("Unknown code $code for enum SequenceType")
      }
  }
}
