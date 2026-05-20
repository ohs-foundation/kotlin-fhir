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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Encounter] resource type. */
public sealed class EncounterSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Encounter): List<T>

  public data object Account : EncounterSearchParam<Reference>() {
    public override val paramName: String = "account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.account"

    public override val target: List<String> = listOf("Account")

    public override fun extract(resource: Encounter): List<Reference> = resource.account
  }

  public data object Appointment : EncounterSearchParam<Reference>() {
    public override val paramName: String = "appointment"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.appointment"

    public override val target: List<String> = listOf("Appointment")

    public override fun extract(resource: Encounter): List<Reference> = resource.appointment
  }

  public data object BasedOn : EncounterSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.basedOn"

    public override val target: List<String> =
      listOf("DeviceRequest", "ServiceRequest", "CarePlan", "MedicationRequest")

    public override fun extract(resource: Encounter): List<Reference> = resource.basedOn
  }

  public data object Careteam : EncounterSearchParam<Reference>() {
    public override val paramName: String = "careteam"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.careTeam"

    public override val target: List<String> = listOf("CareTeam")

    public override fun extract(resource: Encounter): List<Reference> = resource.careTeam
  }

  public data object Class : EncounterSearchParam<CodeableConcept>() {
    public override val paramName: String = "class"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.class"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> = resource.`class`
  }

  public data object Date : EncounterSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Period> =
      listOfNotNull(resource.actualPeriod)
  }

  public data object DateStart : EncounterSearchParam<DateTime>() {
    public override val paramName: String = "date-start"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod.start"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<DateTime> =
      listOfNotNull(resource.actualPeriod?.start)
  }

  public data object DiagnosisCode : EncounterSearchParam<CodeableConcept>() {
    public override val paramName: String = "diagnosis-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.diagnosis.condition.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
  }

  public data object DiagnosisReference : EncounterSearchParam<Reference>() {
    public override val paramName: String = "diagnosis-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.diagnosis.condition.reference"

    public override val target: List<String> = listOf("Condition")

    public override fun extract(resource: Encounter): List<Reference> =
      resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
  }

  public data object EndDate : EncounterSearchParam<DateTime>() {
    public override val paramName: String = "end-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod.end"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<DateTime> =
      listOfNotNull(resource.actualPeriod?.end)
  }

  public data object EpisodeOfCare : EncounterSearchParam<Reference>() {
    public override val paramName: String = "episode-of-care"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.episodeOfCare"

    public override val target: List<String> = listOf("EpisodeOfCare")

    public override fun extract(resource: Encounter): List<Reference> = resource.episodeOfCare
  }

  public data object Identifier : EncounterSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Length : EncounterSearchParam<Duration>() {
    public override val paramName: String = "length"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Encounter.length"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Duration> =
      listOfNotNull(resource.length)
  }

  public data object Location : EncounterSearchParam<Reference>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.location.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Encounter): List<Reference> =
      resource.location.map { it.location }
  }

  public data object LocationPeriod : EncounterSearchParam<Encounter.Location>() {
    public override val paramName: String = "location-period"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Encounter.location"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Encounter.Location> = resource.location
  }

  public data object PartOf : EncounterSearchParam<Reference>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.partOf"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Participant : EncounterSearchParam<Reference>() {
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

    public override fun extract(resource: Encounter): List<Reference> =
      resource.participant.mapNotNull { it.actor }
  }

  public data object ParticipantType : EncounterSearchParam<CodeableConcept>() {
    public override val paramName: String = "participant-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.participant.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.participant.flatMap { it.type }
  }

  public data object Patient : EncounterSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Practitioner : EncounterSearchParam<Reference>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Encounter.participant.actor.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: Encounter): List<Reference> =
      resource.participant
        .mapNotNull { it.actor }
        .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
  }

  public data object ReasonCode : EncounterSearchParam<CodeableConcept>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.reason.value.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.reason.flatMap { it.value }.mapNotNull { it.concept }
  }

  public data object ReasonReference : EncounterSearchParam<Reference>() {
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

    public override fun extract(resource: Encounter): List<Reference> =
      resource.reason.flatMap { it.value }.mapNotNull { it.reference }
  }

  public data object ServiceProvider : EncounterSearchParam<Reference>() {
    public override val paramName: String = "service-provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.serviceProvider"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.serviceProvider)
  }

  public data object SpecialArrangement : EncounterSearchParam<CodeableConcept>() {
    public override val paramName: String = "special-arrangement"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.specialArrangement"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.specialArrangement
  }

  public data object Status : EncounterSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = listOf(resource.status)
  }

  public data object Subject : EncounterSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object SubjectStatus : EncounterSearchParam<CodeableConcept>() {
    public override val paramName: String = "subject-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.subjectStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      listOfNotNull(resource.subjectStatus)
  }

  public data object Type : EncounterSearchParam<CodeableConcept>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> = resource.type
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
