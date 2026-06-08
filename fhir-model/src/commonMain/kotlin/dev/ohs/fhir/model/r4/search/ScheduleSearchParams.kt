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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.Schedule
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Schedule] resource type. */
public object ScheduleSearchParams {
  public val active: SearchParam<Schedule, Boolean> =
    SearchParam(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val actor: SearchParam<Schedule, Reference> =
    SearchParam(
      name = "actor",
      type = SearchParamType.fromCode("reference"),
      expression = "Schedule.actor",
      target =
        listOf(
          Practitioner::class,
          Device::class,
          Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          RelatedPerson::class,
          Location::class,
        ),
      extractor = { resource -> resource.actor },
    )

  public val date: SearchParam<Schedule, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Schedule.planningHorizon",
      extractor = { resource -> listOfNotNull(resource.planningHorizon) },
    )

  public val identifier: SearchParam<Schedule, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val serviceCategory: SearchParam<Schedule, CodeableConcept> =
    SearchParam(
      name = "service-category",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.serviceCategory",
      extractor = { resource -> resource.serviceCategory },
    )

  public val serviceType: SearchParam<Schedule, CodeableConcept> =
    SearchParam(
      name = "service-type",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.serviceType",
      extractor = { resource -> resource.serviceType },
    )

  public val specialty: SearchParam<Schedule, CodeableConcept> =
    SearchParam(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "Schedule.specialty",
      extractor = { resource -> resource.specialty },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Schedule, *>> = listOf()

  /**
   * Supported search parameters for the Schedule resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Schedule, *>> =
    listOf(active, actor, date, identifier, serviceCategory, serviceType, specialty)
}
