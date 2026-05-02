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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Schedule] resource type. */
public sealed class ScheduleSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Schedule): List<T>

  public data object Active : ScheduleSearchParam<Any>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public data object Actor : ScheduleSearchParam<Any>() {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Schedule.actor"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "CareTeam",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Location",
        "Patient",
      )

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public data object Date : ScheduleSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Schedule.planningHorizon"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public data object Identifier : ScheduleSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public data object Name : ScheduleSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Schedule.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public data object ServiceCategory : ScheduleSearchParam<Any>() {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.serviceCategory"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public data object ServiceType : ScheduleSearchParam<Any>() {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.serviceType.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public data object ServiceTypeReference : ScheduleSearchParam<Any>() {
    public override val paramName: String = "service-type-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Schedule.serviceType.reference"

    public override val target: List<String> = listOf("HealthcareService")

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public data object Specialty : ScheduleSearchParam<Any>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Schedule.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Schedule): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Schedule resource type. */
    public val ALL: List<ScheduleSearchParam<*>> =
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
  }
}
