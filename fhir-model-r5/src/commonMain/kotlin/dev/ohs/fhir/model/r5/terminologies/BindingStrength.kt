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

/** Indication of the degree of conformance expectations associated with a binding. */
public enum class BindingStrength(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Required("required", "http://hl7.org/fhir/binding-strength", "Required"),
  Extensible("extensible", "http://hl7.org/fhir/binding-strength", "Extensible"),
  Preferred("preferred", "http://hl7.org/fhir/binding-strength", "Preferred"),
  Example("example", "http://hl7.org/fhir/binding-strength", "Example");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): BindingStrength =
      when (code) {
        "required" -> Required
        "extensible" -> Extensible
        "preferred" -> Preferred
        "example" -> Example
        else -> throw IllegalArgumentException("Unknown code $code for enum BindingStrength")
      }
  }
}
