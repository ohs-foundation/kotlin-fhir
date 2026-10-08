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

/** Permitted data type for observation value. */
public enum class ObservationDataType(
  override val code: kotlin.String,
  override val system: kotlin.String,
  override val display: kotlin.String?,
) : FhirEnum {
  Quantity("Quantity", "http://hl7.org/fhir/permitted-data-type", "Quantity"),
  CodeableConcept("CodeableConcept", "http://hl7.org/fhir/permitted-data-type", "CodeableConcept"),
  String("string", "http://hl7.org/fhir/permitted-data-type", "string"),
  Boolean("boolean", "http://hl7.org/fhir/permitted-data-type", "boolean"),
  Integer("integer", "http://hl7.org/fhir/permitted-data-type", "integer"),
  Range("Range", "http://hl7.org/fhir/permitted-data-type", "Range"),
  Ratio("Ratio", "http://hl7.org/fhir/permitted-data-type", "Ratio"),
  SampledData("SampledData", "http://hl7.org/fhir/permitted-data-type", "SampledData"),
  Time("time", "http://hl7.org/fhir/permitted-data-type", "time"),
  DateTime("dateTime", "http://hl7.org/fhir/permitted-data-type", "dateTime"),
  Period("Period", "http://hl7.org/fhir/permitted-data-type", "Period");

  override fun toString(): kotlin.String = code

  public companion object {
    public fun fromCode(code: kotlin.String): ObservationDataType =
      when (code) {
        "Quantity" -> Quantity
        "CodeableConcept" -> CodeableConcept
        "string" -> String
        "boolean" -> Boolean
        "integer" -> Integer
        "Range" -> Range
        "Ratio" -> Ratio
        "SampledData" -> SampledData
        "time" -> Time
        "dateTime" -> DateTime
        "Period" -> Period
        else -> throw IllegalArgumentException("Unknown code $code for enum ObservationDataType")
      }
  }
}
