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

/** A coded concept listing the base codes. */
public enum class VisionBase(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Up("up", "http://hl7.org/fhir/vision-base-codes", "Up"),
  Down("down", "http://hl7.org/fhir/vision-base-codes", "Down"),
  In("in", "http://hl7.org/fhir/vision-base-codes", "In"),
  Out("out", "http://hl7.org/fhir/vision-base-codes", "Out");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): VisionBase =
      when (code) {
        "up" -> Up
        "down" -> Down
        "in" -> In
        "out" -> Out
        else -> throw IllegalArgumentException("Unknown code $code for enum VisionBase")
      }
  }
}
