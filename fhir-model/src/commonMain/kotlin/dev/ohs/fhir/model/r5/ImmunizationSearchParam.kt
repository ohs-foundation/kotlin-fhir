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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Immunization] resource type. */
public sealed class ImmunizationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Immunization): List<T>

  public data object Date : ImmunizationSearchParam<Any>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "(Immunization.occurrence.ofType(dateTime))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Identifier : ImmunizationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Immunization.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Location : ImmunizationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Immunization.location"

    public override val target: List<kotlin.String> = listOf("Location")

    public override fun extract(resource: Immunization): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object LotNumber : ImmunizationSearchParam<String>() {
    public override val paramName: kotlin.String = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Immunization.lotNumber"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<String> =
      listOfNotNull(resource.lotNumber)
  }

  public data object Manufacturer : ImmunizationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Immunization.manufacturer.reference"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: Immunization): List<Reference> =
      listOfNotNull(resource.manufacturer?.reference)
  }

  public data object Patient : ImmunizationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Immunization.patient"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: Immunization): List<Reference> = listOf(resource.patient)
  }

  public data object Performer : ImmunizationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Immunization.performer.actor"

    public override val target: List<kotlin.String> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: Immunization): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object Reaction : ImmunizationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "reaction"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Immunization.reaction.manifestation.reference"

    public override val target: List<kotlin.String> = listOf("Observation")

    public override fun extract(resource: Immunization): List<Reference> =
      resource.reaction.mapNotNull { it.manifestation }.mapNotNull { it.reference }
  }

  public data object ReactionDate : ImmunizationSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "reaction-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Immunization.reaction.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<DateTime> =
      resource.reaction.mapNotNull { it.date }
  }

  public data object ReasonCode : ImmunizationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Immunization.reason.concept"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      resource.reason.mapNotNull { it.concept }
  }

  public data object ReasonReference : ImmunizationSearchParam<Reference>() {
    public override val paramName: kotlin.String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Immunization.reason.reference"

    public override val target: List<kotlin.String> =
      listOf("Observation", "DiagnosticReport", "Condition")

    public override fun extract(resource: Immunization): List<Reference> =
      resource.reason.mapNotNull { it.reference }
  }

  public data object Series : ImmunizationSearchParam<String>() {
    public override val paramName: kotlin.String = "series"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Immunization.protocolApplied.series"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<String> =
      resource.protocolApplied.mapNotNull { it.series }
  }

  public data object Status : ImmunizationSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Immunization.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = listOf(resource.status)
  }

  public data object StatusReason : ImmunizationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "status-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Immunization.statusReason"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      listOfNotNull(resource.statusReason)
  }

  public data object TargetDisease : ImmunizationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "target-disease"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Immunization.protocolApplied.targetDisease"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      resource.protocolApplied.flatMap { it.targetDisease }
  }

  public data object VaccineCode : ImmunizationSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "vaccine-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Immunization.vaccineCode"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      listOf(resource.vaccineCode)
  }

  public companion object {
    /** All search parameters for the Immunization resource type. */
    public val ALL: List<ImmunizationSearchParam<*>> =
      listOf(
        Date,
        Identifier,
        Location,
        LotNumber,
        Manufacturer,
        Patient,
        Performer,
        Reaction,
        ReactionDate,
        ReasonCode,
        ReasonReference,
        Series,
        Status,
        StatusReason,
        TargetDisease,
        VaccineCode,
      )
  }
}
