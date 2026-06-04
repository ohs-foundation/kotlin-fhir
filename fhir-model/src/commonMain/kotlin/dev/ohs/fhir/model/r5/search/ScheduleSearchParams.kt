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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Schedule
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Schedule] resource type. */
public object ScheduleSearchParams {
  public val Active: SearchParam<Schedule, Boolean> =
    SimpleSearchParam<Schedule, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val Actor: SearchParam<Schedule, Reference> =
    SimpleSearchParam<Schedule, Reference>(
      name = "actor",
      type = SearchParamType.fromCode("reference"),
      expression = "Schedule.actor",
      target =
        listOf(
          HealthcareService::class,
          CareTeam::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Location::class,
          Patient::class,
        ),
      extractor = { resource -> resource.actor },
    )

  public val Date: SearchParam<Schedule, Period> =
    SimpleSearchParam<Schedule, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Schedule.planningHorizon",
      extractor = { resource -> listOfNotNull(resource.planningHorizon) },
    )

  public val Identifier: SearchParam<Schedule, Identifier> =
    SimpleSearchParam<Schedule, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<Schedule, String> =
    SimpleSearchParam<Schedule, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Schedule.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val ServiceCategory: SearchParam<Schedule, CodeableConcept> =
    SimpleSearchParam<Schedule, CodeableConcept>(
      name = "service-category",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.serviceCategory",
      extractor = { resource -> resource.serviceCategory },
    )

  public val ServiceType: SearchParam<Schedule, CodeableConcept> =
    SimpleSearchParam<Schedule, CodeableConcept>(
      name = "service-type",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.serviceType.concept",
      extractor = { resource -> resource.serviceType.mapNotNull { it.concept } },
    )

  public val ServiceTypeReference: SearchParam<Schedule, Reference> =
    SimpleSearchParam<Schedule, Reference>(
      name = "service-type-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Schedule.serviceType.reference",
      target = listOf(HealthcareService::class),
      extractor = { resource -> resource.serviceType.mapNotNull { it.reference } },
    )

  public val Specialty: SearchParam<Schedule, CodeableConcept> =
    SimpleSearchParam<Schedule, CodeableConcept>(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.specialty",
      extractor = { resource -> resource.specialty },
    )

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
}
