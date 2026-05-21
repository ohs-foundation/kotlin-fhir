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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Schedule
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Schedule] resource type. */
public object ScheduleSearchParam {
  /** All search parameters for the Schedule resource type. */
  public val ALL: List<SearchParam<Schedule, *>> =
    listOf(
      Active,
      Actor,
      Date,
      Identifier,
      Name,
      ServiceCategory,
      ServiceType,
      ServiceTypeReference,
      Specialty,
    )

  public data object Active : SearchParam<Schedule, Boolean> {
    public override val name: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Schedule.active"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<Boolean> = listOfNotNull(resource.active)
  }

  public data object Actor : SearchParam<Schedule, Reference> {
    public override val name: KotlinString = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Schedule.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        HealthcareService::class,
        CareTeam::class,
        Device::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        Location::class,
        Patient::class,
      )

    public override fun extract(resource: Schedule): List<Reference> = resource.actor
  }

  public data object Date : SearchParam<Schedule, Period> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Schedule.planningHorizon"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<Period> =
      listOfNotNull(resource.planningHorizon)
  }

  public data object Identifier : SearchParam<Schedule, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Schedule.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<Schedule, R5String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Schedule.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<R5String> = listOfNotNull(resource.name)
  }

  public data object ServiceCategory : SearchParam<Schedule, CodeableConcept> {
    public override val name: KotlinString = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Schedule.serviceCategory"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> =
      resource.serviceCategory
  }

  public data object ServiceType : SearchParam<Schedule, CodeableConcept> {
    public override val name: KotlinString = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Schedule.serviceType.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> =
      resource.serviceType.mapNotNull { it.concept }
  }

  public data object ServiceTypeReference : SearchParam<Schedule, Reference> {
    public override val name: KotlinString = "service-type-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Schedule.serviceType.reference"

    public override val target: List<KClass<out Resource>> = listOf(HealthcareService::class)

    public override fun extract(resource: Schedule): List<Reference> =
      resource.serviceType.mapNotNull { it.reference }
  }

  public data object Specialty : SearchParam<Schedule, CodeableConcept> {
    public override val name: KotlinString = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Schedule.specialty"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> = resource.specialty
  }
}
