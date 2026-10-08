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

/** Describes the state of a metric calibration. */
public enum class DeviceMetricCalibrationState(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Not_Calibrated(
    "not-calibrated",
    "http://hl7.org/fhir/metric-calibration-state",
    "Not Calibrated",
  ),
  Calibration_Required(
    "calibration-required",
    "http://hl7.org/fhir/metric-calibration-state",
    "Calibration Required",
  ),
  Calibrated("calibrated", "http://hl7.org/fhir/metric-calibration-state", "Calibrated"),
  Unspecified("unspecified", "http://hl7.org/fhir/metric-calibration-state", "Unspecified");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DeviceMetricCalibrationState =
      when (code) {
        "not-calibrated" -> Not_Calibrated
        "calibration-required" -> Calibration_Required
        "calibrated" -> Calibrated
        "unspecified" -> Unspecified
        else ->
          throw IllegalArgumentException("Unknown code $code for enum DeviceMetricCalibrationState")
      }
  }
}
