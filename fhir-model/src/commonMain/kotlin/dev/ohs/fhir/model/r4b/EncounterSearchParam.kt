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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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

    public override val target: List<String> = listOf("ServiceRequest")

    public override fun extract(resource: Encounter): List<Reference> = resource.basedOn
  }

  public data object Class : EncounterSearchParam<Coding>() {
    public override val paramName: String = "class"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.class"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Coding> = listOf(resource.`class`)
  }

  public data object Date : EncounterSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Period> = listOfNotNull(resource.period)
  }

  public data object Diagnosis : EncounterSearchParam<Reference>() {
    public override val paramName: String = "diagnosis"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.diagnosis.condition"

    public override val target: List<String> = listOf("Condition", "Procedure")

    public override fun extract(resource: Encounter): List<Reference> =
      resource.diagnosis.map { it.condition }
  }

  public data object EpisodeOfCare : EncounterSearchParam<Reference>() {
    public override val paramName: String = "episode-of-care"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.episodeOfCare"

    public override val target: List<String> = listOf("EpisodeOfCare")

    public override fun extract(resource: Encounter): List<Reference> = resource.episodeOfCare
  }

  public data object Identifier : EncounterSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<dev.ohs.fhir.model.r4b.Identifier> =
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

  public data object LocationPeriod : EncounterSearchParam<Period>() {
    public override val paramName: String = "location-period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.location.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Period> =
      resource.location.mapNotNull { it.period }
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

    public override val expression: String = "Encounter.participant.individual"

    public override val target: List<String> =
      listOf("Practitioner", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Encounter): List<Reference> =
      resource.participant.mapNotNull { it.individual }
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
      "Encounter.participant.individual.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: Encounter): List<Reference> =
      resource.participant
        .mapNotNull { it.individual }
        .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
  }

  public data object ReasonCode : EncounterSearchParam<CodeableConcept>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.reasonCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> = resource.reasonCode
  }

  public data object ReasonReference : EncounterSearchParam<Reference>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.reasonReference"

    public override val target: List<String> =
      listOf("Condition", "Observation", "Procedure", "ImmunizationRecommendation")

    public override fun extract(resource: Encounter): List<Reference> = resource.reasonReference
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

    public override val expression: String = "Encounter.hospitalization.specialArrangement"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<CodeableConcept> =
      resource.hospitalization?.specialArrangement ?: emptyList()
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
  }
}
