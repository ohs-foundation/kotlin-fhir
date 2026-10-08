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

/** Codes indicating the kind of the price component. */
public enum class InvoicePriceComponentType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Base("base", "http://hl7.org/fhir/invoice-priceComponentType", "base price"),
  Surcharge("surcharge", "http://hl7.org/fhir/invoice-priceComponentType", "surcharge"),
  Deduction("deduction", "http://hl7.org/fhir/invoice-priceComponentType", "deduction"),
  Discount("discount", "http://hl7.org/fhir/invoice-priceComponentType", "discount"),
  Tax("tax", "http://hl7.org/fhir/invoice-priceComponentType", "tax"),
  Informational("informational", "http://hl7.org/fhir/invoice-priceComponentType", "informational");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): InvoicePriceComponentType =
      when (code) {
        "base" -> Base
        "surcharge" -> Surcharge
        "deduction" -> Deduction
        "discount" -> Discount
        "tax" -> Tax
        "informational" -> Informational
        else ->
          throw IllegalArgumentException("Unknown code $code for enum InvoicePriceComponentType")
      }
  }
}
