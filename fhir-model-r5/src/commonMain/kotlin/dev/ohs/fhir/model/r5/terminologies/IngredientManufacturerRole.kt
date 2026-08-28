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

/**
 * The way in which this manufacturer is associated with the ingredient. For example whether it is a
 * possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this
 * is not the manufacturing process role.
 */
public enum class IngredientManufacturerRole(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Allowed(
    "allowed",
    "http://hl7.org/fhir/ingredient-manufacturer-role",
    "Manufacturer is specifically allowed for this ingredient",
  ),
  Possible(
    "possible",
    "http://hl7.org/fhir/ingredient-manufacturer-role",
    "Manufacturer is known to make this ingredient in general",
  ),
  Actual(
    "actual",
    "http://hl7.org/fhir/ingredient-manufacturer-role",
    "Manufacturer actually makes this particular ingredient",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): IngredientManufacturerRole =
      fromCodeOrNull(code)
        ?: throw IllegalArgumentException("Unknown code $code for enum IngredientManufacturerRole")

    public fun fromCodeOrNull(code: String?): IngredientManufacturerRole? =
      when (code) {
        "allowed" -> Allowed
        "possible" -> Possible
        "actual" -> Actual
        else -> null
      }
  }
}
