/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4b.terminologies

import kotlin.String

/** Used to specify why the normally expected content of the data element is missing. */
public enum class DataAbsentReason(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Unknown("unknown", "http://terminology.hl7.org/CodeSystem/data-absent-reason", "Unknown"),
  Asked_Unknown(
    "asked-unknown",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Asked But Unknown",
  ),
  Temp_Unknown(
    "temp-unknown",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Temporarily Unknown",
  ),
  Not_Asked("not-asked", "http://terminology.hl7.org/CodeSystem/data-absent-reason", "Not Asked"),
  Asked_Declined(
    "asked-declined",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Asked But Declined",
  ),
  Masked("masked", "http://terminology.hl7.org/CodeSystem/data-absent-reason", "Masked"),
  Not_Applicable(
    "not-applicable",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Not Applicable",
  ),
  Unsupported(
    "unsupported",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Unsupported",
  ),
  As_Text("as-text", "http://terminology.hl7.org/CodeSystem/data-absent-reason", "As Text"),
  Error("error", "http://terminology.hl7.org/CodeSystem/data-absent-reason", "Error"),
  Not_A_Number(
    "not-a-number",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Not a Number (NaN)",
  ),
  Negative_Infinity(
    "negative-infinity",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Negative Infinity (NINF)",
  ),
  Positive_Infinity(
    "positive-infinity",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Positive Infinity (PINF)",
  ),
  Not_Performed(
    "not-performed",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Not Performed",
  ),
  Not_Permitted(
    "not-permitted",
    "http://terminology.hl7.org/CodeSystem/data-absent-reason",
    "Not Permitted",
  );

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): DataAbsentReason =
      when (code) {
        "unknown" -> Unknown
        "asked-unknown" -> Asked_Unknown
        "temp-unknown" -> Temp_Unknown
        "not-asked" -> Not_Asked
        "asked-declined" -> Asked_Declined
        "masked" -> Masked
        "not-applicable" -> Not_Applicable
        "unsupported" -> Unsupported
        "as-text" -> As_Text
        "error" -> Error
        "not-a-number" -> Not_A_Number
        "negative-infinity" -> Negative_Infinity
        "positive-infinity" -> Positive_Infinity
        "not-performed" -> Not_Performed
        "not-permitted" -> Not_Permitted
        else -> throw IllegalArgumentException("Unknown code $code for enum DataAbsentReason")
      }
  }
}
