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

/** Device Production Identifier in UDI */
public enum class DeviceProductionIdentifierInUDI(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Lot_Number("lot-number", "http://hl7.org/fhir/device-productidentifierinudi", "Lot Number"),
  Manufactured_Date(
    "manufactured-date",
    "http://hl7.org/fhir/device-productidentifierinudi",
    "Manufactured date",
  ),
  Serial_Number(
    "serial-number",
    "http://hl7.org/fhir/device-productidentifierinudi",
    "Serial Number",
  ),
  Expiration_Date(
    "expiration-date",
    "http://hl7.org/fhir/device-productidentifierinudi",
    "Expiration date",
  ),
  Biological_Source(
    "biological-source",
    "http://hl7.org/fhir/device-productidentifierinudi",
    "Biological source",
  ),
  Software_Version(
    "software-version",
    "http://hl7.org/fhir/device-productidentifierinudi",
    "Software Version",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DeviceProductionIdentifierInUDI =
      when (code) {
        "lot-number" -> Lot_Number
        "manufactured-date" -> Manufactured_Date
        "serial-number" -> Serial_Number
        "expiration-date" -> Expiration_Date
        "biological-source" -> Biological_Source
        "software-version" -> Software_Version
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum DeviceProductionIdentifierInUDI"
          )
      }
  }
}
