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

/** The type of 2D coordinates describing a 2D image region. */
public enum class ImagingSelection2DGraphicType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Point("point", "http://hl7.org/fhir/imagingselection-2dgraphictype", "POINT"),
  Polyline("polyline", "http://hl7.org/fhir/imagingselection-2dgraphictype", "POLYLINE"),
  Interpolated(
    "interpolated",
    "http://hl7.org/fhir/imagingselection-2dgraphictype",
    "INTERPOLATED",
  ),
  Circle("circle", "http://hl7.org/fhir/imagingselection-2dgraphictype", "CIRCLE"),
  Ellipse("ellipse", "http://hl7.org/fhir/imagingselection-2dgraphictype", "ELLIPSE");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ImagingSelection2DGraphicType =
      when (code) {
        "point" -> Point
        "polyline" -> Polyline
        "interpolated" -> Interpolated
        "circle" -> Circle
        "ellipse" -> Ellipse
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum ImagingSelection2DGraphicType"
          )
      }
  }
}
