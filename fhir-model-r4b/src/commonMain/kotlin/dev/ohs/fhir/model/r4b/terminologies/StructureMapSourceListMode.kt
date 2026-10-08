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

/** If field is a list, how to manage the source. */
public enum class StructureMapSourceListMode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  First("first", "http://hl7.org/fhir/map-source-list-mode", "First"),
  Not_First("not_first", "http://hl7.org/fhir/map-source-list-mode", "All but the first"),
  Last("last", "http://hl7.org/fhir/map-source-list-mode", "Last"),
  Not_Last("not_last", "http://hl7.org/fhir/map-source-list-mode", "All but the last"),
  Only_One("only_one", "http://hl7.org/fhir/map-source-list-mode", "Enforce only one");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): StructureMapSourceListMode =
      when (code) {
        "first" -> First
        "not_first" -> Not_First
        "last" -> Last
        "not_last" -> Not_Last
        "only_one" -> Only_One
        else ->
          throw IllegalArgumentException("Unknown code $code for enum StructureMapSourceListMode")
      }
  }
}
