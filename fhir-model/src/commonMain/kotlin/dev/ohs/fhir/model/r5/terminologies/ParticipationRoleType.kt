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
 * This FHIR value set is comprised of Actor participation Type codes, which can be used to value
 * FHIR agents, actors, and other role elements. The codes are intended to express how the agent
 * participated in some activity. Sometimes refered to the agent functional-role relative to the
 * activity.
 */
public enum class ParticipationRoleType(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Enterer(
    "enterer",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Enterer",
  ),
  Performer(
    "performer",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Performer",
  ),
  Author("author", "http://terminology.hl7.org/CodeSystem/provenance-participant-type", "Author"),
  Verifier(
    "verifier",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Verifier",
  ),
  Legal(
    "legal",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Legal Authenticator",
  ),
  Attester(
    "attester",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Attester",
  ),
  Informant(
    "informant",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Informant",
  ),
  Custodian(
    "custodian",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Custodian",
  ),
  Assembler(
    "assembler",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Assembler",
  ),
  Composer(
    "composer",
    "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
    "Composer",
  ),
  _110150("110150", "http://dicom.nema.org/resources/ontology/DCM", "Application"),
  _110151("110151", "http://dicom.nema.org/resources/ontology/DCM", "Application Launcher"),
  _110152("110152", "http://dicom.nema.org/resources/ontology/DCM", "Destination Role ID"),
  _110153("110153", "http://dicom.nema.org/resources/ontology/DCM", "Source Role ID"),
  _110154("110154", "http://dicom.nema.org/resources/ontology/DCM", "Destination Media"),
  _110155("110155", "http://dicom.nema.org/resources/ontology/DCM", "Source Media"),
  Authserver(
    "authserver",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "Authorization Server",
  ),
  Datacollector(
    "datacollector",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "Data Collector",
  ),
  Dataprocessor(
    "dataprocessor",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "Data Processor",
  ),
  Datasubject(
    "datasubject",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "Data Subject",
  ),
  Humanuser(
    "humanuser",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "Human User",
  );

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): ParticipationRoleType =
      when (code) {
        "enterer" -> Enterer
        "performer" -> Performer
        "author" -> Author
        "verifier" -> Verifier
        "legal" -> Legal
        "attester" -> Attester
        "informant" -> Informant
        "custodian" -> Custodian
        "assembler" -> Assembler
        "composer" -> Composer
        "110150" -> _110150
        "110151" -> _110151
        "110152" -> _110152
        "110153" -> _110153
        "110154" -> _110154
        "110155" -> _110155
        "authserver" -> Authserver
        "datacollector" -> Datacollector
        "dataprocessor" -> Dataprocessor
        "datasubject" -> Datasubject
        "humanuser" -> Humanuser
        else -> throw IllegalArgumentException("Unknown code $code for enum ParticipationRoleType")
      }
  }
}
