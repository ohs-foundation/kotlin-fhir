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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Encounter] resource type. */
public sealed class EncounterSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Encounter): List<T>

  public data object Account : EncounterSearchParam<Any>() {
    public override val paramName: String = "account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.account"

    public override val target: List<String> = listOf("Account")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Appointment : EncounterSearchParam<Any>() {
    public override val paramName: String = "appointment"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.appointment"

    public override val target: List<String> = listOf("Appointment")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object BasedOn : EncounterSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.basedOn"

    public override val target: List<String> =
      listOf("DeviceRequest", "ServiceRequest", "CarePlan", "MedicationRequest")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Careteam : EncounterSearchParam<Any>() {
    public override val paramName: String = "careteam"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.careTeam"

    public override val target: List<String> = listOf("CareTeam")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Class : EncounterSearchParam<Any>() {
    public override val paramName: String = "class"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.class"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Date : EncounterSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object DateStart : EncounterSearchParam<Any>() {
    public override val paramName: String = "date-start"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod.start"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object DiagnosisCode : EncounterSearchParam<Any>() {
    public override val paramName: String = "diagnosis-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.diagnosis.condition.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object DiagnosisReference : EncounterSearchParam<Any>() {
    public override val paramName: String = "diagnosis-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.diagnosis.condition.reference"

    public override val target: List<String> = listOf("Condition")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object EndDate : EncounterSearchParam<Any>() {
    public override val paramName: String = "end-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod.end"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object EpisodeOfCare : EncounterSearchParam<Any>() {
    public override val paramName: String = "episode-of-care"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.episodeOfCare"

    public override val target: List<String> = listOf("EpisodeOfCare")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Identifier : EncounterSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Length : EncounterSearchParam<Any>() {
    public override val paramName: String = "length"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Encounter.length"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Location : EncounterSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.location.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object LocationPeriod : EncounterSearchParam<Any>() {
    public override val paramName: String = "location-period"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Encounter.location"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object PartOf : EncounterSearchParam<Any>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.partOf"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Participant : EncounterSearchParam<Any>() {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.participant.actor"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Group",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object ParticipantType : EncounterSearchParam<Any>() {
    public override val paramName: String = "participant-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.participant.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Patient : EncounterSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Practitioner : EncounterSearchParam<Any>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Encounter.participant.actor.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object ReasonCode : EncounterSearchParam<Any>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.reason.value.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object ReasonReference : EncounterSearchParam<Any>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.reason.value.reference"

    public override val target: List<String> =
      listOf(
        "Procedure",
        "Observation",
        "DiagnosticReport",
        "ImmunizationRecommendation",
        "Condition",
      )

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object ServiceProvider : EncounterSearchParam<Any>() {
    public override val paramName: String = "service-provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.serviceProvider"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object SpecialArrangement : EncounterSearchParam<Any>() {
    public override val paramName: String = "special-arrangement"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.specialArrangement"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Status : EncounterSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Subject : EncounterSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object SubjectStatus : EncounterSearchParam<Any>() {
    public override val paramName: String = "subject-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.subjectStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Type : EncounterSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Encounter resource type. */
    public val ALL: List<EncounterSearchParam<*>> =
      listOf(
        Account,
        Appointment,
        BasedOn,
        Careteam,
        Class,
        Date,
        DateStart,
        DiagnosisCode,
        DiagnosisReference,
        EndDate,
        EpisodeOfCare,
        Identifier,
        Length,
        Location,
        LocationPeriod,
        PartOf,
        Participant,
        ParticipantType,
        Patient,
        Practitioner,
        ReasonCode,
        ReasonReference,
        ServiceProvider,
        SpecialArrangement,
        Status,
        Subject,
        SubjectStatus,
        Type,
      )
  }
}
