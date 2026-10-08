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

/** Codes indicating the kind of the price component. */
public enum class PriceComponentType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Base("base", "http://hl7.org/fhir/price-component-type", "base price"),
  Surcharge("surcharge", "http://hl7.org/fhir/price-component-type", "surcharge"),
  Deduction("deduction", "http://hl7.org/fhir/price-component-type", "deduction"),
  Discount("discount", "http://hl7.org/fhir/price-component-type", "discount"),
  Tax("tax", "http://hl7.org/fhir/price-component-type", "tax"),
  Informational("informational", "http://hl7.org/fhir/price-component-type", "informational");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): PriceComponentType =
      when (code) {
        "base" -> Base
        "surcharge" -> Surcharge
        "deduction" -> Deduction
        "discount" -> Discount
        "tax" -> Tax
        "informational" -> Informational
        else -> throw IllegalArgumentException("Unknown code $code for enum PriceComponentType")
      }
  }
}
