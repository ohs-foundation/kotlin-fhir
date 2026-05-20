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

import dev.ohs.fhir.model.r4b.Boolean
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Schedule
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Schedule] resource type. */
public sealed class ScheduleSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Schedule): List<T>

  public data object Active : ScheduleSearchParam<Boolean>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Boolean> = listOfNotNull(resource.active)
  }

  public data object Actor : ScheduleSearchParam<Reference>() {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Schedule.actor"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Device",
        "Patient",
        "HealthcareService",
        "PractitionerRole",
        "RelatedPerson",
        "Location",
      )

    public override fun extract(resource: Schedule): List<Reference> = resource.actor
  }

  public data object Date : ScheduleSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Schedule.planningHorizon"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Period> =
      listOfNotNull(resource.planningHorizon)
  }

  public data object Identifier : ScheduleSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object ServiceCategory : ScheduleSearchParam<CodeableConcept>() {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.serviceCategory"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> =
      resource.serviceCategory
  }

  public data object ServiceType : ScheduleSearchParam<CodeableConcept>() {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.serviceType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> = resource.serviceType
  }

  public data object Specialty : ScheduleSearchParam<CodeableConcept>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<CodeableConcept> = resource.specialty
  }

  public companion object {
    /** All search parameters for the Schedule resource type. */
    public val ALL: List<ScheduleSearchParam<*>> =
      listOf(Active, Actor, Date, Identifier, ServiceCategory, ServiceType, Specialty)
  }
}
