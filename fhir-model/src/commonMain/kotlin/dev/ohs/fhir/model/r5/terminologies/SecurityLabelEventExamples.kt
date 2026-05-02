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
 * [Healthcare Privacy and Security Classification System](security-labels.html#hcs) that are used
 * on events and requests/responses (aka user context or organization context) made up of
 * PurposeOfUse and maybe a refrain/obligation.
 */
public enum class SecurityLabelEventExamples(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
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
    public fun fromCode(code: String): SecurityLabelEventExamples =
      when (code) {
        "TREAT" -> Treat
        "HPAYMT" -> Hpaymt
        "ETREAT" -> Etreat
        "NOAUTH" -> Noauth
        "DELAU" -> Delau
        "NORDSCLCD" -> Nordsclcd
        else ->
          throw IllegalArgumentException("Unknown code $code for enum SecurityLabelEventExamples")
      }
  }
}
