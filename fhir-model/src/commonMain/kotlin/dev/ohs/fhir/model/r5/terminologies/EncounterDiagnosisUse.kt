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

package com.google.fhir.model.r5.terminologies

import kotlin.String

/** What a specific Encounter/EpisodeOfCare `diagnosis.condition` is to be used for. */
public enum class EncounterDiagnosisUse(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Working("working", "http://hl7.org/fhir/encounter-diagnosis-use", "Working"),
  Final("final", "http://hl7.org/fhir/encounter-diagnosis-use", "Final");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): EncounterDiagnosisUse =
      when (code) {
        "working" -> Working
        "final" -> Final
        else -> throw IllegalArgumentException("Unknown code $code for enum EncounterDiagnosisUse")
      }
  }
}
