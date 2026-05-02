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

package com.google.fhir.model.r5.terminologies

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
  _0_0("0.0", "http://hl7.org/fhir/FHIR-version", "0.0"),
  _0_0_80("0.0.80", "http://hl7.org/fhir/FHIR-version", "0.0.80"),
  _0_0_81("0.0.81", "http://hl7.org/fhir/FHIR-version", "0.0.81"),
  _0_0_82("0.0.82", "http://hl7.org/fhir/FHIR-version", "0.0.82"),
  _0_4("0.4", "http://hl7.org/fhir/FHIR-version", "0.4"),
  _0_4_0("0.4.0", "http://hl7.org/fhir/FHIR-version", "0.4.0"),
  _0_5("0.5", "http://hl7.org/fhir/FHIR-version", "0.5"),
  _0_5_0("0.5.0", "http://hl7.org/fhir/FHIR-version", "0.5.0"),
  _1_0("1.0", "http://hl7.org/fhir/FHIR-version", "1.0"),
  _1_0_0("1.0.0", "http://hl7.org/fhir/FHIR-version", "1.0.0"),
  _1_0_1("1.0.1", "http://hl7.org/fhir/FHIR-version", "1.0.1"),
  _1_0_2("1.0.2", "http://hl7.org/fhir/FHIR-version", "1.0.2"),
  _1_1("1.1", "http://hl7.org/fhir/FHIR-version", "1.1"),
  _1_1_0("1.1.0", "http://hl7.org/fhir/FHIR-version", "1.1.0"),
  _1_4("1.4", "http://hl7.org/fhir/FHIR-version", "1.4"),
  _1_4_0("1.4.0", "http://hl7.org/fhir/FHIR-version", "1.4.0"),
  _1_6("1.6", "http://hl7.org/fhir/FHIR-version", "1.6"),
  _1_6_0("1.6.0", "http://hl7.org/fhir/FHIR-version", "1.6.0"),
  _1_8("1.8", "http://hl7.org/fhir/FHIR-version", "1.8"),
  _1_8_0("1.8.0", "http://hl7.org/fhir/FHIR-version", "1.8.0"),
  _3_0("3.0", "http://hl7.org/fhir/FHIR-version", "3.0"),
  _3_0_0("3.0.0", "http://hl7.org/fhir/FHIR-version", "3.0.0"),
  _3_0_1("3.0.1", "http://hl7.org/fhir/FHIR-version", "3.0.1"),
  _3_0_2("3.0.2", "http://hl7.org/fhir/FHIR-version", "3.0.2"),
  _3_3("3.3", "http://hl7.org/fhir/FHIR-version", "3.3"),
  _3_3_0("3.3.0", "http://hl7.org/fhir/FHIR-version", "3.3.0"),
  _3_5("3.5", "http://hl7.org/fhir/FHIR-version", "3.5"),
  _3_5_0("3.5.0", "http://hl7.org/fhir/FHIR-version", "3.5.0"),
  _4_0("4.0", "http://hl7.org/fhir/FHIR-version", "4.0"),
  _4_0_0("4.0.0", "http://hl7.org/fhir/FHIR-version", "4.0.0"),
  _4_0_1("4.0.1", "http://hl7.org/fhir/FHIR-version", "4.0.1"),
  _4_1("4.1", "http://hl7.org/fhir/FHIR-version", "4.1"),
  _4_1_0("4.1.0", "http://hl7.org/fhir/FHIR-version", "4.1.0"),
  _4_2("4.2", "http://hl7.org/fhir/FHIR-version", "4.2"),
  _4_2_0("4.2.0", "http://hl7.org/fhir/FHIR-version", "4.2.0"),
  _4_3("4.3", "http://hl7.org/fhir/FHIR-version", "4.3"),
  _4_3_0("4.3.0", "http://hl7.org/fhir/FHIR-version", "4.3.0"),
  _4_3_0_Cibuild("4.3.0-cibuild", "http://hl7.org/fhir/FHIR-version", "4.3.0-cibuild"),
  _4_3_0_Snapshot1("4.3.0-snapshot1", "http://hl7.org/fhir/FHIR-version", "4.3.0-snapshot1"),
  _4_4("4.4", "http://hl7.org/fhir/FHIR-version", "4.4"),
  _4_4_0("4.4.0", "http://hl7.org/fhir/FHIR-version", "4.4.0"),
  _4_5("4.5", "http://hl7.org/fhir/FHIR-version", "4.5"),
  _4_5_0("4.5.0", "http://hl7.org/fhir/FHIR-version", "4.5.0"),
  _4_6("4.6", "http://hl7.org/fhir/FHIR-version", "4.6"),
  _4_6_0("4.6.0", "http://hl7.org/fhir/FHIR-version", "4.6.0"),
  _5_0("5.0", "http://hl7.org/fhir/FHIR-version", "5.0"),
  _5_0_0("5.0.0", "http://hl7.org/fhir/FHIR-version", "5.0.0"),
  _5_0_0_Cibuild("5.0.0-cibuild", "http://hl7.org/fhir/FHIR-version", "5.0.0-cibuild"),
  _5_0_0_Snapshot1("5.0.0-snapshot1", "http://hl7.org/fhir/FHIR-version", "5.0.0-snapshot1"),
  _5_0_0_Snapshot2("5.0.0-snapshot2", "http://hl7.org/fhir/FHIR-version", "5.0.0-snapshot2"),
  _5_0_0_Ballot("5.0.0-ballot", "http://hl7.org/fhir/FHIR-version", "5.0.0-ballot"),
  _5_0_0_Snapshot3("5.0.0-snapshot3", "http://hl7.org/fhir/FHIR-version", "5.0.0-snapshot3"),
  _5_0_0_Draft_Final("5.0.0-draft-final", "http://hl7.org/fhir/FHIR-version", "5.0.0-draft-final");

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
        "0.0" -> _0_0
        "0.0.80" -> _0_0_80
        "0.0.81" -> _0_0_81
        "0.0.82" -> _0_0_82
        "0.4" -> _0_4
        "0.4.0" -> _0_4_0
        "0.5" -> _0_5
        "0.5.0" -> _0_5_0
        "1.0" -> _1_0
        "1.0.0" -> _1_0_0
        "1.0.1" -> _1_0_1
        "1.0.2" -> _1_0_2
        "1.1" -> _1_1
        "1.1.0" -> _1_1_0
        "1.4" -> _1_4
        "1.4.0" -> _1_4_0
        "1.6" -> _1_6
        "1.6.0" -> _1_6_0
        "1.8" -> _1_8
        "1.8.0" -> _1_8_0
        "3.0" -> _3_0
        "3.0.0" -> _3_0_0
        "3.0.1" -> _3_0_1
        "3.0.2" -> _3_0_2
        "3.3" -> _3_3
        "3.3.0" -> _3_3_0
        "3.5" -> _3_5
        "3.5.0" -> _3_5_0
        "4.0" -> _4_0
        "4.0.0" -> _4_0_0
        "4.0.1" -> _4_0_1
        "4.1" -> _4_1
        "4.1.0" -> _4_1_0
        "4.2" -> _4_2
        "4.2.0" -> _4_2_0
        "4.3" -> _4_3
        "4.3.0" -> _4_3_0
        "4.3.0-cibuild" -> _4_3_0_Cibuild
        "4.3.0-snapshot1" -> _4_3_0_Snapshot1
        "4.4" -> _4_4
        "4.4.0" -> _4_4_0
        "4.5" -> _4_5
        "4.5.0" -> _4_5_0
        "4.6" -> _4_6
        "4.6.0" -> _4_6_0
        "5.0" -> _5_0
        "5.0.0" -> _5_0_0
        "5.0.0-cibuild" -> _5_0_0_Cibuild
        "5.0.0-snapshot1" -> _5_0_0_Snapshot1
        "5.0.0-snapshot2" -> _5_0_0_Snapshot2
        "5.0.0-ballot" -> _5_0_0_Ballot
        "5.0.0-snapshot3" -> _5_0_0_Snapshot3
        "5.0.0-draft-final" -> _5_0_0_Draft_Final
        else -> throw IllegalArgumentException("Unknown code $code for enum FHIRVersion")
      }
  }
}
