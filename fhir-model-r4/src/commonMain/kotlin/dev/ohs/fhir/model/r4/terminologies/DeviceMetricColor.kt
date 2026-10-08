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

/** Describes the typical color of representation. */
public enum class DeviceMetricColor(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Black("black", "http://hl7.org/fhir/metric-color", "Color Black"),
  Red("red", "http://hl7.org/fhir/metric-color", "Color Red"),
  Green("green", "http://hl7.org/fhir/metric-color", "Color Green"),
  Yellow("yellow", "http://hl7.org/fhir/metric-color", "Color Yellow"),
  Blue("blue", "http://hl7.org/fhir/metric-color", "Color Blue"),
  Magenta("magenta", "http://hl7.org/fhir/metric-color", "Color Magenta"),
  Cyan("cyan", "http://hl7.org/fhir/metric-color", "Color Cyan"),
  White("white", "http://hl7.org/fhir/metric-color", "Color White");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DeviceMetricColor =
      when (code) {
        "black" -> Black
        "red" -> Red
        "green" -> Green
        "yellow" -> Yellow
        "blue" -> Blue
        "magenta" -> Magenta
        "cyan" -> Cyan
        "white" -> White
        else -> throw IllegalArgumentException("Unknown code $code for enum DeviceMetricColor")
      }
  }
}
