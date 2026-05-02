/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4.terminologies

import kotlin.String

/** This value set includes Claim Processing Outcome codes. */
public enum class ClaimProcessingCodes(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Queued("queued", "http://hl7.org/fhir/remittance-outcome", "Queued"),
  Complete("complete", "http://hl7.org/fhir/remittance-outcome", "Processing Complete"),
  Error("error", "http://hl7.org/fhir/remittance-outcome", "Error"),
  Partial("partial", "http://hl7.org/fhir/remittance-outcome", "Partial Processing");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): ClaimProcessingCodes =
      when (code) {
        "queued" -> Queued
        "complete" -> Complete
        "error" -> Error
        "partial" -> Partial
        else -> throw IllegalArgumentException("Unknown code $code for enum ClaimProcessingCodes")
      }
  }
}
