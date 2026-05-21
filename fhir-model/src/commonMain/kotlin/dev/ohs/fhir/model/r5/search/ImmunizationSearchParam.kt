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
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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

  public data object Date : SearchParam<Immunization, Any> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "(Immunization.occurrence.ofType(dateTime))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Identifier : SearchParam<Immunization, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Location : SearchParam<Immunization, Reference> {
    public override val paramName: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: Immunization): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object LotNumber : SearchParam<Immunization, R5String> {
    public override val paramName: KotlinString = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Immunization.lotNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<R5String> =
      listOfNotNull(resource.lotNumber)
  }

  public data object Manufacturer : SearchParam<Immunization, Reference> {
    public override val paramName: KotlinString = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.manufacturer.reference"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Immunization): List<Reference> =
      listOfNotNull(resource.manufacturer?.reference)
  }

  public data object Patient : SearchParam<Immunization, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: Immunization): List<Reference> = listOf(resource.patient)
  }

  public data object Performer : SearchParam<Immunization, Reference> {
    public override val paramName: KotlinString = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.performer.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Organization::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: Immunization): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object Reaction : SearchParam<Immunization, Reference> {
    public override val paramName: KotlinString = "reaction"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.reaction.manifestation.reference"

    public override val target: List<KClass<out Resource>> = listOf(Observation::class)

    public override fun extract(resource: Immunization): List<Reference> =
      resource.reaction.mapNotNull { it.manifestation }.mapNotNull { it.reference }
  }

  public data object ReactionDate : SearchParam<Immunization, DateTime> {
    public override val paramName: KotlinString = "reaction-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Immunization.reaction.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<DateTime> =
      resource.reaction.mapNotNull { it.date }
  }

  public data object ReasonCode : SearchParam<Immunization, CodeableConcept> {
    public override val paramName: KotlinString = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.reason.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      resource.reason.mapNotNull { it.concept }
  }

  public data object ReasonReference : SearchParam<Immunization, Reference> {
    public override val paramName: KotlinString = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Immunization.reason.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(Observation::class, DiagnosticReport::class, Condition::class)

    public override fun extract(resource: Immunization): List<Reference> =
      resource.reason.mapNotNull { it.reference }
  }

  public data object Series : SearchParam<Immunization, R5String> {
    public override val paramName: KotlinString = "series"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Immunization.protocolApplied.series"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<R5String> =
      resource.protocolApplied.mapNotNull { it.series }
  }

  public data object Status : SearchParam<Immunization, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = listOf(resource.status)
  }

  public data object StatusReason : SearchParam<Immunization, CodeableConcept> {
    public override val paramName: KotlinString = "status-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.statusReason"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      listOfNotNull(resource.statusReason)
  }

  public data object TargetDisease : SearchParam<Immunization, CodeableConcept> {
    public override val paramName: KotlinString = "target-disease"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.protocolApplied.targetDisease"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      resource.protocolApplied.flatMap { it.targetDisease }
  }

  public data object VaccineCode : SearchParam<Immunization, CodeableConcept> {
    public override val paramName: KotlinString = "vaccine-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Immunization.vaccineCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Immunization): List<CodeableConcept> =
      listOf(resource.vaccineCode)
  }
}
