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
 * Whether the results by exposure is describing the results for the primary exposure of interest
 * (exposure) or the alternative state (exposureAlternative).
 */
public enum class ExposureState(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Exposure("exposure", "http://hl7.org/fhir/exposure-state", "Exposure"),
  Exposure_Alternative(
    "exposure-alternative",
    "http://hl7.org/fhir/exposure-state",
    "Exposure Alternative",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ExposureState =
      when (code) {
        "exposure" -> Exposure
        "exposure-alternative" -> Exposure_Alternative
        else -> throw IllegalArgumentException("Unknown code $code for enum ExposureState")
      }
  }
}
