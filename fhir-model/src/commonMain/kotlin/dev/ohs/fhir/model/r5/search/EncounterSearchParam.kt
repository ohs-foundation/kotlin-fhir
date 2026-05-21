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

import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceRequest
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.ImmunizationRecommendation
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Encounter] resource type. */
public object EncounterSearchParam {
  /** All search parameters for the Encounter resource type. */
  public val ALL: List<SearchParam<Encounter, *>> =
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

  public data object Account : SearchParam<Encounter, Reference> {
    public override val paramName: String = "account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.account"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Account::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.account
  }

  public data object Appointment : SearchParam<Encounter, Reference> {
    public override val paramName: String = "appointment"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.appointment"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Appointment::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.appointment
  }

  public data object BasedOn : SearchParam<Encounter, Reference> {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(DeviceRequest::class, ServiceRequest::class, CarePlan::class, MedicationRequest::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.basedOn
  }

  public data object Careteam : SearchParam<Encounter, Reference> {
    public override val paramName: String = "careteam"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.careTeam"

    public override val target: List<KClass<out Resource>> = listOf(CareTeam::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.careTeam
  }

  public data object Class : SearchParam<Encounter, CodeableConcept> {
    public override val paramName: String = "class"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.class"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> = resource.`class`
  }

  public data object Date : SearchParam<Encounter, Period> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Period> =
      listOfNotNull(resource.actualPeriod)
  }

  public data object DateStart : SearchParam<Encounter, DateTime> {
    public override val paramName: String = "date-start"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod.start"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<DateTime> =
      listOfNotNull(resource.actualPeriod?.start)
  }

  public data object DiagnosisCode : SearchParam<Encounter, CodeableConcept> {
    public override val paramName: String = "diagnosis-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.diagnosis.condition.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
  }

  public data object DiagnosisReference : SearchParam<Encounter, Reference> {
    public override val paramName: String = "diagnosis-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.diagnosis.condition.reference"

    public override val target: List<KClass<out Resource>> = listOf(Condition::class)

    public override fun extract(resource: Encounter): List<Reference> =
      resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
  }

  public data object EndDate : SearchParam<Encounter, DateTime> {
    public override val paramName: String = "end-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.actualPeriod.end"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<DateTime> =
      listOfNotNull(resource.actualPeriod?.end)
  }

  public data object EpisodeOfCare : SearchParam<Encounter, Reference> {
    public override val paramName: String = "episode-of-care"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.episodeOfCare"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.EpisodeOfCare::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.episodeOfCare
  }

  public data object Identifier : SearchParam<Encounter, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Length : SearchParam<Encounter, Duration> {
    public override val paramName: String = "length"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Encounter.length"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Duration> =
      listOfNotNull(resource.length)
  }

  public data object Location : SearchParam<Encounter, Reference> {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.location.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: Encounter): List<Reference> =
      resource.location.map { it.location }
  }

  public data object LocationPeriod : SearchParam<Encounter, Encounter.Location> {
    public override val paramName: String = "location-period"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Encounter.location"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Encounter.Location> = resource.location
  }

  public data object PartOf : SearchParam<Encounter, Reference> {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.partOf"

    public override val target: List<KClass<out Resource>> = listOf(Encounter::class)

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Participant : SearchParam<Encounter, Reference> {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.participant.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        HealthcareService::class,
        Device::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Group::class,
        dev.ohs.fhir.model.r5.Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: Encounter): List<Reference> =
      resource.participant.mapNotNull { it.actor }
  }

  public data object ParticipantType : SearchParam<Encounter, CodeableConcept> {
    public override val paramName: String = "participant-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.participant.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.participant.flatMap { it.type }
  }

  public data object Patient : SearchParam<Encounter, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Practitioner : SearchParam<Encounter, Reference> {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Encounter.participant.actor.where(resolve() is Practitioner)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Practitioner::class)

    public override fun extract(resource: Encounter): List<Reference> =
      resource.participant
        .mapNotNull { it.actor }
        .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
  }

  public data object ReasonCode : SearchParam<Encounter, CodeableConcept> {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.reason.value.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.reason.flatMap { it.value }.mapNotNull { it.concept }
  }

  public data object ReasonReference : SearchParam<Encounter, Reference> {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.reason.value.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Procedure::class,
        Observation::class,
        DiagnosticReport::class,
        ImmunizationRecommendation::class,
        Condition::class,
      )

    public override fun extract(resource: Encounter): List<Reference> =
      resource.reason.flatMap { it.value }.mapNotNull { it.reference }
  }

  public data object ServiceProvider : SearchParam<Encounter, Reference> {
    public override val paramName: String = "service-provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.serviceProvider"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.serviceProvider)
  }

  public data object SpecialArrangement : SearchParam<Encounter, CodeableConcept> {
    public override val paramName: String = "special-arrangement"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.specialArrangement"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.specialArrangement
  }

  public data object Status : SearchParam<Encounter, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<Encounter, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object SubjectStatus : SearchParam<Encounter, CodeableConcept> {
    public override val paramName: String = "subject-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.subjectStatus"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      listOfNotNull(resource.subjectStatus)
  }

  public data object Type : SearchParam<Encounter, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> = resource.type
  }
}
