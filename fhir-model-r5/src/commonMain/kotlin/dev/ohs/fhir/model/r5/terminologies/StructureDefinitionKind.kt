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

/** Defines the type of structure that a definition is describing. */
public enum class StructureDefinitionKind(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Primitive_Type(
    "primitive-type",
    "http://hl7.org/fhir/structure-definition-kind",
    "Primitive Data Type",
  ),
  Complex_Type(
    "complex-type",
    "http://hl7.org/fhir/structure-definition-kind",
    "Complex Data Type",
  ),
  Resource("resource", "http://hl7.org/fhir/structure-definition-kind", "Resource"),
  Logical("logical", "http://hl7.org/fhir/structure-definition-kind", "Logical");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): StructureDefinitionKind =
      when (code) {
        "primitive-type" -> Primitive_Type
        "complex-type" -> Complex_Type
        "resource" -> Resource
        "logical" -> Logical
        else ->
          throw IllegalArgumentException("Unknown code $code for enum StructureDefinitionKind")
      }
  }
}
