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
 * This value set contains example structural roles. In general, two types of roles can be
 * distinguished: structural roles and functional roles. Structural Roles reflect human or
 * organizational categories (hierarchies), and describe prerequisites, feasibilities, or
 * competences for actions. Functional roles are bound to the realization or performance of actions.
 */
public enum class SecurityRoleType(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Regulated_Health_Professionals(
    "regulated-health-professionals",
    "sample-security-structural-roles",
    "Regulated Health Professionals",
  ),
  General_Medicine("general-medicine", "sample-security-structural-roles", "General Medicine"),
  General_Nursing("general-nursing", "sample-security-structural-roles", "General Nursing"),
  Dentist("dentist", "sample-security-structural-roles", "Dentist"),
  Veterinarian("veterinarian", "sample-security-structural-roles", "Veterinarian"),
  Pharmacy("pharmacy", "sample-security-structural-roles", "Pharmacy"),
  Dietician("dietician", "sample-security-structural-roles", "Dietician"),
  Pediatrics("pediatrics", "sample-security-structural-roles", "Pediatrics"),
  Non_Regulated_Health_Professionals(
    "non-regulated-health-professionals",
    "sample-security-structural-roles",
    "Non-Regulated health Professionals",
  ),
  Receptionist("receptionist", "sample-security-structural-roles", "Receptionist"),
  Business_Manager("business-manager", "sample-security-structural-roles", "Business Manager"),
  Transcriptionist("transcriptionist", "sample-security-structural-roles", "Transcriptionist"),
  Claims_Adjudicator(
    "claims-adjudicator",
    "sample-security-structural-roles",
    "Claims Adjudicator",
  );

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): SecurityRoleType =
      when (code) {
        "regulated-health-professionals" -> Regulated_Health_Professionals
        "general-medicine" -> General_Medicine
        "general-nursing" -> General_Nursing
        "dentist" -> Dentist
        "veterinarian" -> Veterinarian
        "pharmacy" -> Pharmacy
        "dietician" -> Dietician
        "pediatrics" -> Pediatrics
        "non-regulated-health-professionals" -> Non_Regulated_Health_Professionals
        "receptionist" -> Receptionist
        "business-manager" -> Business_Manager
        "transcriptionist" -> Transcriptionist
        "claims-adjudicator" -> Claims_Adjudicator
        else -> throw IllegalArgumentException("Unknown code $code for enum SecurityRoleType")
      }
  }
}
