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

/** The use of an address. */
public enum class AddressUse(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Home("home", "http://hl7.org/fhir/address-use", "Home"),
  Work("work", "http://hl7.org/fhir/address-use", "Work"),
  Temp("temp", "http://hl7.org/fhir/address-use", "Temporary"),
  Old("old", "http://hl7.org/fhir/address-use", "Old / Incorrect"),
  Billing("billing", "http://hl7.org/fhir/address-use", "Billing");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AddressUse =
      when (code) {
        "home" -> Home
        "work" -> Work
        "temp" -> Temp
        "old" -> Old
        "billing" -> Billing
        else -> throw IllegalArgumentException("Unknown code $code for enum AddressUse")
      }
  }
}
