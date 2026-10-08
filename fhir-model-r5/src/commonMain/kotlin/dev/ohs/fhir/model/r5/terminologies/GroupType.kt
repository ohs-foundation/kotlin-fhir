/*
 * Copyright 2026 Open Health Stack Foundation
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

package dev.ohs.fhir.model.r5.terminologies

import dev.ohs.fhir.model.r5.FhirEnum
import kotlin.String

/** Types of resources that are part of group. */
public enum class GroupType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Person("person", "http://hl7.org/fhir/group-type", "Person"),
  Animal("animal", "http://hl7.org/fhir/group-type", "Animal"),
  Practitioner("practitioner", "http://hl7.org/fhir/group-type", "Practitioner"),
  Device("device", "http://hl7.org/fhir/group-type", "Device"),
  Careteam("careteam", "http://hl7.org/fhir/group-type", "CareTeam"),
  Healthcareservice("healthcareservice", "http://hl7.org/fhir/group-type", "HealthcareService"),
  Location("location", "http://hl7.org/fhir/group-type", "Location"),
  Organization("organization", "http://hl7.org/fhir/group-type", "Organization"),
  Relatedperson("relatedperson", "http://hl7.org/fhir/group-type", "RelatedPerson"),
  Specimen("specimen", "http://hl7.org/fhir/group-type", "Specimen");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): GroupType =
      when (code) {
        "person" -> Person
        "animal" -> Animal
        "practitioner" -> Practitioner
        "device" -> Device
        "careteam" -> Careteam
        "healthcareservice" -> Healthcareservice
        "location" -> Location
        "organization" -> Organization
        "relatedperson" -> Relatedperson
        "specimen" -> Specimen
        else -> throw IllegalArgumentException("Unknown code $code for enum GroupType")
      }
  }
}
