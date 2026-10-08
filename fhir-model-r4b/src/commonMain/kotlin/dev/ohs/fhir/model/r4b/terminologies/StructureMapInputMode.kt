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

/** Mode for this instance of data. */
public enum class StructureMapInputMode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Source("source", "http://hl7.org/fhir/map-input-mode", "Source Instance"),
  Target("target", "http://hl7.org/fhir/map-input-mode", "Target Instance");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): StructureMapInputMode =
      when (code) {
        "source" -> Source
        "target" -> Target
        else -> throw IllegalArgumentException("Unknown code $code for enum StructureMapInputMode")
      }
  }
}
