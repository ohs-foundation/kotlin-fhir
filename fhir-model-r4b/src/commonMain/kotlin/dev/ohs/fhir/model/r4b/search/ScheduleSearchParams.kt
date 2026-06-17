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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Boolean
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Schedule
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Schedule] resource type. */
public object ScheduleSearchParams {
  public val active: SearchParam<Schedule, Boolean> =
    SearchParam(
      name = "active",
      type = SearchParamType.Token,
      expression = "Schedule.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val actor: SearchParam<Schedule, Reference> =
    SearchParam(
      name = "actor",
      type = SearchParamType.Reference,
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
      type = SearchParamType.Date,
      expression = "Schedule.planningHorizon",
      extractor = { resource -> listOfNotNull(resource.planningHorizon) },
    )

  public val identifier: SearchParam<Schedule, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Schedule.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val serviceCategory: SearchParam<Schedule, CodeableConcept> =
    SearchParam(
      name = "service-category",
      type = SearchParamType.Token,
      expression = "Schedule.serviceCategory",
      extractor = { resource -> resource.serviceCategory },
    )

  public val serviceType: SearchParam<Schedule, CodeableConcept> =
    SearchParam(
      name = "service-type",
      type = SearchParamType.Token,
      expression = "Schedule.serviceType",
      extractor = { resource -> resource.serviceType },
    )

  public val specialty: SearchParam<Schedule, CodeableConcept> =
    SearchParam(
      name = "specialty",
      type = SearchParamType.Token,
      expression = "Schedule.specialty",
      extractor = { resource -> resource.specialty },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
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
