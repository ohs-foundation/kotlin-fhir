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

/** If this is the default rule set to apply for the source type, or this combination of types. */
public enum class StructureMapGroupTypeMode(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  None("none", "http://hl7.org/fhir/map-group-type-mode", "Not a Default"),
  Types("types", "http://hl7.org/fhir/map-group-type-mode", "Default for Type Combination"),
  Type_And_Types(
    "type-and-types",
    "http://hl7.org/fhir/map-group-type-mode",
    "Default for type + combination",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): StructureMapGroupTypeMode =
      when (code) {
        "none" -> None
        "types" -> Types
        "type-and-types" -> Type_And_Types
        else ->
          throw IllegalArgumentException("Unknown code $code for enum StructureMapGroupTypeMode")
      }
  }
}
