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

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Schedule
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Schedule] resource type. */
public object ScheduleSearchParam {
  /** All search parameters for the Schedule resource type. */
  public val ALL: List<SearchParam<Schedule, *>> =
    listOf(Active, Actor, Date, Identifier, ServiceCategory, ServiceType, Specialty)

  public data object Active : SearchParam<Schedule, Boolean> {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.active"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<Boolean> = listOfNotNull(resource.active)
  }

  public data object Actor : SearchParam<Schedule, Reference> {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Schedule.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Device::class,
        Patient::class,
        HealthcareService::class,
        PractitionerRole::class,
        RelatedPerson::class,
        Location::class,
      )

    public override fun extract(resource: Schedule): List<Reference> = resource.actor
  }

  public data object Date : SearchParam<Schedule, Period> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Schedule.planningHorizon"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<Period> =
      listOfNotNull(resource.planningHorizon)
  }

  public data object Identifier : SearchParam<Schedule, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object ServiceCategory : SearchParam<Schedule, CodeableConcept> {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.serviceCategory"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> =
      resource.serviceCategory
  }

  public data object ServiceType : SearchParam<Schedule, CodeableConcept> {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.serviceType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> = resource.serviceType
  }

  public data object Specialty : SearchParam<Schedule, CodeableConcept> {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.specialty"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> = resource.specialty
  }
}
