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

/** A coded concept listing the eye codes. */
public enum class VisionEyes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Right("right", "http://hl7.org/fhir/vision-eye-codes", "Right Eye"),
  Left("left", "http://hl7.org/fhir/vision-eye-codes", "Left Eye");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): VisionEyes =
      when (code) {
        "right" -> Right
        "left" -> Left
        else -> throw IllegalArgumentException("Unknown code $code for enum VisionEyes")
      }
  }
}
