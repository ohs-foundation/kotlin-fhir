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

/** The type of a property value. */
public enum class PropertyType(
  override val code: kotlin.String,
  override val system: kotlin.String,
  override val display: kotlin.String?,
) : FhirEnum {
  Code("code", "http://hl7.org/fhir/concept-property-type", "code (internal reference)"),
  Coding("Coding", "http://hl7.org/fhir/concept-property-type", "Coding (external reference)"),
  String("string", "http://hl7.org/fhir/concept-property-type", "string"),
  Integer("integer", "http://hl7.org/fhir/concept-property-type", "integer"),
  Boolean("boolean", "http://hl7.org/fhir/concept-property-type", "boolean"),
  DateTime("dateTime", "http://hl7.org/fhir/concept-property-type", "dateTime"),
  Decimal("decimal", "http://hl7.org/fhir/concept-property-type", "decimal");

  override fun toString(): kotlin.String = code

  public companion object {
    public fun fromCode(code: kotlin.String): PropertyType =
      when (code) {
        "code" -> Code
        "Coding" -> Coding
        "string" -> String
        "integer" -> Integer
        "boolean" -> Boolean
        "dateTime" -> DateTime
        "decimal" -> Decimal
        else -> throw IllegalArgumentException("Unknown code $code for enum PropertyType")
      }
  }
}
