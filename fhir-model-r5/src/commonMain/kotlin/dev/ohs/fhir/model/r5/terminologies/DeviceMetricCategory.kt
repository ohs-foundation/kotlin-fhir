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

/** Describes the category of the metric. */
public enum class DeviceMetricCategory(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Measurement("measurement", "http://hl7.org/fhir/metric-category", "Measurement"),
  Setting("setting", "http://hl7.org/fhir/metric-category", "Setting"),
  Calculation("calculation", "http://hl7.org/fhir/metric-category", "Calculation"),
  Unspecified("unspecified", "http://hl7.org/fhir/metric-category", "Unspecified");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DeviceMetricCategory =
      when (code) {
        "measurement" -> Measurement
        "setting" -> Setting
        "calculation" -> Calculation
        "unspecified" -> Unspecified
        else -> throw IllegalArgumentException("Unknown code $code for enum DeviceMetricCategory")
      }
  }
}
