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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.ImmunizationRecommendation
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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
      Class,
      Date,
      Diagnosis,
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
      Type,
    )

  public data object Account : SearchParam<Encounter, Reference> {
    public override val name: String = "account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.account"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Account::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.account
  }

  public data object Appointment : SearchParam<Encounter, Reference> {
    public override val name: String = "appointment"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.appointment"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Appointment::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.appointment
  }

  public data object BasedOn : SearchParam<Encounter, Reference> {
    public override val name: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.basedOn"

    public override val target: List<KClass<out Resource>> = listOf(ServiceRequest::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.basedOn
  }

  public data object Class : SearchParam<Encounter, Coding> {
    public override val name: String = "class"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.class"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Coding> = listOf(resource.`class`)
  }

  public data object Date : SearchParam<Encounter, Period> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Period> = listOfNotNull(resource.period)
  }

  public data object Diagnosis : SearchParam<Encounter, Reference> {
    public override val name: String = "diagnosis"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.diagnosis.condition"

    public override val target: List<KClass<out Resource>> =
      listOf(Condition::class, Procedure::class)

    public override fun extract(resource: Encounter): List<Reference> =
      resource.diagnosis.map { it.condition }
  }

  public data object EpisodeOfCare : SearchParam<Encounter, Reference> {
    public override val name: String = "episode-of-care"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.episodeOfCare"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.EpisodeOfCare::class)

    public override fun extract(resource: Encounter): List<Reference> = resource.episodeOfCare
  }

  public data object Identifier : SearchParam<Encounter, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Length : SearchParam<Encounter, Duration> {
    public override val name: String = "length"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Encounter.length"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Duration> =
      listOfNotNull(resource.length)
  }

  public data object Location : SearchParam<Encounter, Reference> {
    public override val name: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.location.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Location::class)

    public override fun extract(resource: Encounter): List<Reference> =
      resource.location.map { it.location }
  }

  public data object LocationPeriod : SearchParam<Encounter, Period> {
    public override val name: String = "location-period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.location.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Period> =
      resource.location.mapNotNull { it.period }
  }

  public data object PartOf : SearchParam<Encounter, Reference> {
    public override val name: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.partOf"

    public override val target: List<KClass<out Resource>> = listOf(Encounter::class)

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Participant : SearchParam<Encounter, Reference> {
    public override val name: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.participant.individual"

    public override val target: List<KClass<out Resource>> =
      listOf(
        dev.ohs.fhir.model.r4b.Practitioner::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: Encounter): List<Reference> =
      resource.participant.mapNotNull { it.individual }
  }

  public data object ParticipantType : SearchParam<Encounter, CodeableConcept> {
    public override val name: String = "participant-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.participant.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.participant.flatMap { it.type }
  }

  public data object Patient : SearchParam<Encounter, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Practitioner : SearchParam<Encounter, Reference> {
    public override val name: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Encounter.participant.individual.where(resolve() is Practitioner)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Practitioner::class)

    public override fun extract(resource: Encounter): List<Reference> =
      resource.participant
        .mapNotNull { it.individual }
        .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
  }

  public data object ReasonCode : SearchParam<Encounter, CodeableConcept> {
    public override val name: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.reasonCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> = resource.reasonCode
  }

  public data object ReasonReference : SearchParam<Encounter, Reference> {
    public override val name: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.reasonReference"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Condition::class,
        Observation::class,
        Procedure::class,
        ImmunizationRecommendation::class,
      )

    public override fun extract(resource: Encounter): List<Reference> = resource.reasonReference
  }

  public data object ServiceProvider : SearchParam<Encounter, Reference> {
    public override val name: String = "service-provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.serviceProvider"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.serviceProvider)
  }

  public data object SpecialArrangement : SearchParam<Encounter, CodeableConcept> {
    public override val name: String = "special-arrangement"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.hospitalization.specialArrangement"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.hospitalization?.specialArrangement ?: emptyList()
  }

  public data object Status : SearchParam<Encounter, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<Encounter, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: Encounter): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Type : SearchParam<Encounter, CodeableConcept> {
    public override val name: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> = resource.type
  }
}
