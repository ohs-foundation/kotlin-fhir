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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
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

    public override val target: List<String> = listOf("ServiceRequest")

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

    public override val expression: String = "Encounter.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Diagnosis : EncounterSearchParam<Any>() {
    public override val paramName: String = "diagnosis"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.diagnosis.condition"

    public override val target: List<String> = listOf("Condition", "Procedure")

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

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Encounter.location.period"

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

    public override val expression: String = "Encounter.participant.individual"

    public override val target: List<String> =
      listOf("Practitioner", "PractitionerRole", "RelatedPerson")

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

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object Practitioner : EncounterSearchParam<Any>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "Encounter.participant.individual.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object ReasonCode : EncounterSearchParam<Any>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Encounter.reasonCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Encounter): List<Any> = emptyList()
  }

  public data object ReasonReference : EncounterSearchParam<Any>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Encounter.reasonReference"

    public override val target: List<String> =
      listOf("Condition", "Observation", "Procedure", "ImmunizationRecommendation")

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

    public override val expression: String = "Encounter.hospitalization.specialArrangement"

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
