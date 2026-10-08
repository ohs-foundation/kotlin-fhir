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

/** If field is a list, how to manage the production. */
public enum class StructureMapTargetListMode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  First("first", "http://hl7.org/fhir/map-target-list-mode", "First"),
  Share("share", "http://hl7.org/fhir/map-target-list-mode", "Share"),
  Last("last", "http://hl7.org/fhir/map-target-list-mode", "Last"),
  Single("single", "http://hl7.org/fhir/map-target-list-mode", "single");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): StructureMapTargetListMode =
      when (code) {
        "first" -> First
        "share" -> Share
        "last" -> Last
        "single" -> Single
        else ->
          throw IllegalArgumentException("Unknown code $code for enum StructureMapTargetListMode")
      }
  }
}
