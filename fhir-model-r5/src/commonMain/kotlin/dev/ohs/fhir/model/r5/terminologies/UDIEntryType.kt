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

/** Codes to identify how UDI data was entered. */
public enum class UDIEntryType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Barcode("barcode", "http://hl7.org/fhir/udi-entry-type", "Barcode"),
  Rfid("rfid", "http://hl7.org/fhir/udi-entry-type", "RFID"),
  Manual("manual", "http://hl7.org/fhir/udi-entry-type", "Manual"),
  Card("card", "http://hl7.org/fhir/udi-entry-type", "Card"),
  Self_Reported("self-reported", "http://hl7.org/fhir/udi-entry-type", "Self Reported"),
  Electronic_Transmission(
    "electronic-transmission",
    "http://hl7.org/fhir/udi-entry-type",
    "Electronic Transmission",
  ),
  Unknown("unknown", "http://hl7.org/fhir/udi-entry-type", "Unknown");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): UDIEntryType =
      when (code) {
        "barcode" -> Barcode
        "rfid" -> Rfid
        "manual" -> Manual
        "card" -> Card
        "self-reported" -> Self_Reported
        "electronic-transmission" -> Electronic_Transmission
        "unknown" -> Unknown
        else -> throw IllegalArgumentException("Unknown code $code for enum UDIEntryType")
      }
  }
}
