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

package com.google.fhir.model.r4.terminologies

import kotlin.String

/** All published FHIR Versions. */
public enum class FHIRVersion(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  _0_01("0.01", "http://hl7.org/fhir/FHIR-version", "0.01"),
  _0_05("0.05", "http://hl7.org/fhir/FHIR-version", "0.05"),
  _0_06("0.06", "http://hl7.org/fhir/FHIR-version", "0.06"),
  _0_11("0.11", "http://hl7.org/fhir/FHIR-version", "0.11"),
  _0_0_80("0.0.80", "http://hl7.org/fhir/FHIR-version", "0.0.80"),
  _0_0_81("0.0.81", "http://hl7.org/fhir/FHIR-version", "0.0.81"),
  _0_0_82("0.0.82", "http://hl7.org/fhir/FHIR-version", "0.0.82"),
  _0_4_0("0.4.0", "http://hl7.org/fhir/FHIR-version", "0.4.0"),
  _0_5_0("0.5.0", "http://hl7.org/fhir/FHIR-version", "0.5.0"),
  _1_0_0("1.0.0", "http://hl7.org/fhir/FHIR-version", "1.0.0"),
  _1_0_1("1.0.1", "http://hl7.org/fhir/FHIR-version", "1.0.1"),
  _1_0_2("1.0.2", "http://hl7.org/fhir/FHIR-version", "1.0.2"),
  _1_1_0("1.1.0", "http://hl7.org/fhir/FHIR-version", "1.1.0"),
  _1_4_0("1.4.0", "http://hl7.org/fhir/FHIR-version", "1.4.0"),
  _1_6_0("1.6.0", "http://hl7.org/fhir/FHIR-version", "1.6.0"),
  _1_8_0("1.8.0", "http://hl7.org/fhir/FHIR-version", "1.8.0"),
  _3_0_0("3.0.0", "http://hl7.org/fhir/FHIR-version", "3.0.0"),
  _3_0_1("3.0.1", "http://hl7.org/fhir/FHIR-version", "3.0.1"),
  _3_3_0("3.3.0", "http://hl7.org/fhir/FHIR-version", "3.3.0"),
  _3_5_0("3.5.0", "http://hl7.org/fhir/FHIR-version", "3.5.0"),
  _4_0_0("4.0.0", "http://hl7.org/fhir/FHIR-version", "4.0.0"),
  _4_0_1("4.0.1", "http://hl7.org/fhir/FHIR-version", "4.0.1");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): FHIRVersion =
      when (code) {
        "0.01" -> _0_01
        "0.05" -> _0_05
        "0.06" -> _0_06
        "0.11" -> _0_11
        "0.0.80" -> _0_0_80
        "0.0.81" -> _0_0_81
        "0.0.82" -> _0_0_82
        "0.4.0" -> _0_4_0
        "0.5.0" -> _0_5_0
        "1.0.0" -> _1_0_0
        "1.0.1" -> _1_0_1
        "1.0.2" -> _1_0_2
        "1.1.0" -> _1_1_0
        "1.4.0" -> _1_4_0
        "1.6.0" -> _1_6_0
        "1.8.0" -> _1_8_0
        "3.0.0" -> _3_0_0
        "3.0.1" -> _3_0_1
        "3.3.0" -> _3_3_0
        "3.5.0" -> _3_5_0
        "4.0.0" -> _4_0_0
        "4.0.1" -> _4_0_1
        else -> throw IllegalArgumentException("Unknown code $code for enum FHIRVersion")
      }
  }
}
