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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Condition
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.DiagnosticReport
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Immunization
import dev.ohs.fhir.model.r4.Observation
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Immunization] resource type. */
public object ImmunizationSearchParam {
  /** All search parameters for the Immunization resource type. */
  public val ALL: List<SearchParam<Immunization, *>> =
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

  public data object Date : SearchParam<Immunization, Immunization.Occurrence> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Immunization.occurrence"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<Immunization.Occurrence> =
      listOf(resource.occurrence)
  }

  public data object Identifier : SearchParam<Immunization, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Location : SearchParam<Immunization, Reference> {
    public override val name: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Location::class)

    public override fun extract(resource: Immunization): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object LotNumber : SearchParam<Immunization, R4String> {
    public override val name: KotlinString = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Immunization.lotNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<R4String> =
      listOfNotNull(resource.lotNumber)
  }

  public data object Manufacturer : SearchParam<Immunization, Reference> {
    public override val name: KotlinString = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.manufacturer"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Immunization): List<Reference> =
      listOfNotNull(resource.manufacturer)
  }

  public data object Patient : SearchParam<Immunization, Reference> {
    public override val name: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: Immunization): List<Reference> = listOf(resource.patient)
  }

  public data object Performer : SearchParam<Immunization, Reference> {
    public override val name: KotlinString = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.performer.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, PractitionerRole::class)

    public override fun extract(resource: Immunization): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object Reaction : SearchParam<Immunization, Reference> {
    public override val name: KotlinString = "reaction"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.reaction.detail"

    public override val target: List<KClass<out Resource>> = listOf(Observation::class)

    public override fun extract(resource: Immunization): List<Reference> =
      resource.reaction.mapNotNull { it.detail }
  }

  public data object ReactionDate : SearchParam<Immunization, DateTime> {
    public override val name: KotlinString = "reaction-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Immunization.reaction.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<DateTime> =
      resource.reaction.mapNotNull { it.date }
  }

  public data object ReasonCode : SearchParam<Immunization, CodeableConcept> {
    public override val name: KotlinString = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.reasonCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> = resource.reasonCode
  }

  public data object ReasonReference : SearchParam<Immunization, Reference> {
    public override val name: KotlinString = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.reasonReference"

    public override val target: List<KClass<out Resource>> =
      listOf(Condition::class, Observation::class, DiagnosticReport::class)

    public override fun extract(resource: Immunization): List<Reference> = resource.reasonReference
  }

  public data object Series : SearchParam<Immunization, R4String> {
    public override val name: KotlinString = "series"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Immunization.protocolApplied.series"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<R4String> =
      resource.protocolApplied.mapNotNull { it.series }
  }

  public data object Status : SearchParam<Immunization, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = listOf(resource.status)
  }

  public data object StatusReason : SearchParam<Immunization, CodeableConcept> {
    public override val name: KotlinString = "status-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.statusReason"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      listOfNotNull(resource.statusReason)
  }

  public data object TargetDisease : SearchParam<Immunization, CodeableConcept> {
    public override val name: KotlinString = "target-disease"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.protocolApplied.targetDisease"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      resource.protocolApplied.flatMap { it.targetDisease }
  }

  public data object VaccineCode : SearchParam<Immunization, CodeableConcept> {
    public override val name: KotlinString = "vaccine-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.vaccineCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      listOf(resource.vaccineCode)
  }
}
