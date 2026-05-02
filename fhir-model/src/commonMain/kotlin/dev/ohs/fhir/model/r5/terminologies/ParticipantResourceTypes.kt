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

/** All Resource Types that represent participant resources */
public enum class ParticipantResourceTypes(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  CareTeam("CareTeam", "http://hl7.org/fhir/fhir-types", "CareTeam"),
  Device("Device", "http://hl7.org/fhir/fhir-types", "Device"),
  Group("Group", "http://hl7.org/fhir/fhir-types", "Group"),
  HealthcareService("HealthcareService", "http://hl7.org/fhir/fhir-types", "HealthcareService"),
  Location("Location", "http://hl7.org/fhir/fhir-types", "Location"),
  Organization("Organization", "http://hl7.org/fhir/fhir-types", "Organization"),
  Patient("Patient", "http://hl7.org/fhir/fhir-types", "Patient"),
  Practitioner("Practitioner", "http://hl7.org/fhir/fhir-types", "Practitioner"),
  PractitionerRole("PractitionerRole", "http://hl7.org/fhir/fhir-types", "PractitionerRole"),
  RelatedPerson("RelatedPerson", "http://hl7.org/fhir/fhir-types", "RelatedPerson");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): ParticipantResourceTypes =
      when (code) {
        "CareTeam" -> CareTeam
        "Device" -> Device
        "Group" -> Group
        "HealthcareService" -> HealthcareService
        "Location" -> Location
        "Organization" -> Organization
        "Patient" -> Patient
        "Practitioner" -> Practitioner
        "PractitionerRole" -> PractitionerRole
        "RelatedPerson" -> RelatedPerson
        else ->
          throw IllegalArgumentException("Unknown code $code for enum ParticipantResourceTypes")
      }
  }
}
