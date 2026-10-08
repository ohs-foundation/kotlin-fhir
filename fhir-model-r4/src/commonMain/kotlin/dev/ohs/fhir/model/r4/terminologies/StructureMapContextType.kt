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

/** How to interpret the context. */
public enum class StructureMapContextType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Type("type", "http://hl7.org/fhir/map-context-type", "Type"),
  Variable("variable", "http://hl7.org/fhir/map-context-type", "Variable");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): StructureMapContextType =
      when (code) {
        "type" -> Type
        "variable" -> Variable
        else ->
          throw IllegalArgumentException("Unknown code $code for enum StructureMapContextType")
      }
  }
}
