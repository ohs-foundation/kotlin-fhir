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

/** The outcome of the processing. */
public enum class RemittanceOutcome(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Queued("queued", "http://hl7.org/fhir/remittance-outcome", "Queued"),
  Complete("complete", "http://hl7.org/fhir/remittance-outcome", "Complete"),
  Error("error", "http://hl7.org/fhir/remittance-outcome", "Error"),
  Partial("partial", "http://hl7.org/fhir/remittance-outcome", "Partial");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): RemittanceOutcome =
      fromCodeOrNull(code)
        ?: throw IllegalArgumentException("Unknown code $code for enum RemittanceOutcome")

    public fun fromCodeOrNull(code: String?): RemittanceOutcome? =
      when (code) {
        "queued" -> Queued
        "complete" -> Complete
        "error" -> Error
        "partial" -> Partial
        else -> null
      }
  }
}
