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

/**
 * A sample of security labels from
 * [Healthcare Privacy and Security Classification System](security-labels.html#hcs) as the
 * combination of data and event codes.
 */
public enum class SecurityLabelExamples(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  N("N", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "normal"),
  R("R", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "restricted"),
  Eth(
    "ETH",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "substance abuse information sensitivity",
  ),
  Psy(
    "PSY",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "psychiatry disorder information sensitivity",
  ),
  Std(
    "STD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "sexually transmitted disease information sensitivity",
  ),
  Treat("TREAT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "treatment"),
  Hpaymt("HPAYMT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "healthcare payment"),
  Etreat("ETREAT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "Emergency Treatment"),
  Noauth(
    "NOAUTH",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no disclosure without subject authorization",
  ),
  Delau("DELAU", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "delete after use"),
  Nordsclcd(
    "NORDSCLCD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no redisclosure without consent directive",
  );

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): SecurityLabelExamples =
      when (code) {
        "N" -> N
        "R" -> R
        "ETH" -> Eth
        "PSY" -> Psy
        "STD" -> Std
        "TREAT" -> Treat
        "HPAYMT" -> Hpaymt
        "ETREAT" -> Etreat
        "NOAUTH" -> Noauth
        "DELAU" -> Delau
        "NORDSCLCD" -> Nordsclcd
        else -> throw IllegalArgumentException("Unknown code $code for enum SecurityLabelExamples")
      }
  }
}
