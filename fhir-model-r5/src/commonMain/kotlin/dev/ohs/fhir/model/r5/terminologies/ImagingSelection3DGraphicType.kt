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

/** The type of coordinates describing a 3D image region. */
public enum class ImagingSelection3DGraphicType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Point("point", "http://hl7.org/fhir/imagingselection-3dgraphictype", "POINT"),
  Multipoint("multipoint", "http://hl7.org/fhir/imagingselection-3dgraphictype", "MULTIPOINT"),
  Polyline("polyline", "http://hl7.org/fhir/imagingselection-3dgraphictype", "POLYLINE"),
  Polygon("polygon", "http://hl7.org/fhir/imagingselection-3dgraphictype", "POLYGON"),
  Ellipse("ellipse", "http://hl7.org/fhir/imagingselection-3dgraphictype", "ELLIPSE"),
  Ellipsoid("ellipsoid", "http://hl7.org/fhir/imagingselection-3dgraphictype", "ELLIPSOID");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ImagingSelection3DGraphicType =
      when (code) {
        "point" -> Point
        "multipoint" -> Multipoint
        "polyline" -> Polyline
        "polygon" -> Polygon
        "ellipse" -> Ellipse
        "ellipsoid" -> Ellipsoid
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum ImagingSelection3DGraphicType"
          )
      }
  }
}
