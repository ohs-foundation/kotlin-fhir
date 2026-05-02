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
 * This value set defines a set of codes that can be used to express the role of a diagnosis on the
 * Encounter or EpisodeOfCare record.
 */
public enum class DiagnosisRole(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Ad("AD", "http://terminology.hl7.org/CodeSystem/diagnosis-role", "Admission diagnosis"),
  Dd("DD", "http://terminology.hl7.org/CodeSystem/diagnosis-role", "Discharge diagnosis"),
  Cc("CC", "http://terminology.hl7.org/CodeSystem/diagnosis-role", "Chief complaint"),
  Cm("CM", "http://terminology.hl7.org/CodeSystem/diagnosis-role", "Comorbidity diagnosis"),
  Pre_Op("pre-op", "http://terminology.hl7.org/CodeSystem/diagnosis-role", "pre-op diagnosis"),
  Post_Op("post-op", "http://terminology.hl7.org/CodeSystem/diagnosis-role", "post-op diagnosis"),
  Billing("billing", "http://terminology.hl7.org/CodeSystem/diagnosis-role", "Billing");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): DiagnosisRole =
      when (code) {
        "AD" -> Ad
        "DD" -> Dd
        "CC" -> Cc
        "CM" -> Cm
        "pre-op" -> Pre_Op
        "post-op" -> Post_Op
        "billing" -> Billing
        else -> throw IllegalArgumentException("Unknown code $code for enum DiagnosisRole")
      }
  }
}
