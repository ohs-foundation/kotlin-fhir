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
 * Some potential code systems are:
 * - [v3-DocumentCompletion](http://terminology.hl7.org/3.0.0/CodeSystem-v3-DocumentCompletion.html)
 * - [v3-DataOperation](http://terminology.hl7.org/3.0.0/CodeSystem-v3-DataOperation.html)
 * - [v3-ActCode](http://hl7.org/fhir/v3/ActCode/cs.html)
 * - [ISO Lifecycle](http://terminology.hl7.org/CodeSystem/iso-21089-lifecycle)
 */
public enum class ProvenanceActivityType(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Amend(
    "amend",
    "http://terminology.hl7.org/CodeSystem/iso-21089-lifecycle",
    "Amend (Update) Record Lifecycle Event",
  ),
  Originate(
    "originate",
    "http://terminology.hl7.org/CodeSystem/iso-21089-lifecycle",
    "Originate/Retain Record Lifecycle Event",
  ),
  Merge(
    "merge",
    "http://terminology.hl7.org/CodeSystem/iso-21089-lifecycle",
    "Merge Record Lifecycle Event",
  ),
  Deidentify(
    "deidentify",
    "http://terminology.hl7.org/CodeSystem/iso-21089-lifecycle",
    "De-Identify (Anononymize) Record Lifecycle Event",
  ),
  Receive(
    "receive",
    "http://terminology.hl7.org/CodeSystem/iso-21089-lifecycle",
    "Receive/Retain Record Lifecycle Event",
  ),
  Transform(
    "transform",
    "http://terminology.hl7.org/CodeSystem/iso-21089-lifecycle",
    "Transform/Translate Record Lifecycle Event",
  ),
  Verify(
    "verify",
    "http://terminology.hl7.org/CodeSystem/iso-21089-lifecycle",
    "Verify Record Lifecycle Event",
  );

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): ProvenanceActivityType =
      when (code) {
        "amend" -> Amend
        "originate" -> Originate
        "merge" -> Merge
        "deidentify" -> Deidentify
        "receive" -> Receive
        "transform" -> Transform
        "verify" -> Verify
        else -> throw IllegalArgumentException("Unknown code $code for enum ProvenanceActivityType")
      }
  }
}
