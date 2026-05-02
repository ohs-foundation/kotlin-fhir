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

/**
 * This value set defines the set of codes that can be used to indicate the marital status of a
 * person.
 */
public enum class MaritalStatusCodes(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  A("A", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Annulled"),
  D("D", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Divorced"),
  I("I", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Interlocutory"),
  L("L", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Legally Separated"),
  M("M", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Married"),
  C("C", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Common Law"),
  P("P", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Polygamous"),
  T("T", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Domestic partner"),
  U("U", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "unmarried"),
  S("S", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Never Married"),
  W("W", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "Widowed"),
  Unk("UNK", "http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "unknown");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): MaritalStatusCodes =
      when (code) {
        "A" -> A
        "D" -> D
        "I" -> I
        "L" -> L
        "M" -> M
        "C" -> C
        "P" -> P
        "T" -> T
        "U" -> U
        "S" -> S
        "W" -> W
        "UNK" -> Unk
        else -> throw IllegalArgumentException("Unknown code $code for enum MaritalStatusCodes")
      }
  }
}
