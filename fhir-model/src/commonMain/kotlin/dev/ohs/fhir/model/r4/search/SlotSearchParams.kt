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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Schedule
import dev.ohs.fhir.model.r4.Slot
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Slot] resource type. */
public object SlotSearchParams {
  public val appointmentType: SearchParam<Slot, CodeableConcept> =
    SimpleSearchParam<Slot, CodeableConcept>(
      name = "appointment-type",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.appointmentType",
      extractor = { resource -> listOfNotNull(resource.appointmentType) },
    )

  public val identifier: SearchParam<Slot, Identifier> =
    SimpleSearchParam<Slot, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val schedule: SearchParam<Slot, Reference> =
    SimpleSearchParam<Slot, Reference>(
      name = "schedule",
      type = SearchParamType.fromCode("reference"),
      expression = "Slot.schedule",
      target = listOf(Schedule::class),
      extractor = { resource -> listOf(resource.schedule) },
    )

  public val serviceCategory: SearchParam<Slot, CodeableConcept> =
    SimpleSearchParam<Slot, CodeableConcept>(
      name = "service-category",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.serviceCategory",
      extractor = { resource -> resource.serviceCategory },
    )

  public val serviceType: SearchParam<Slot, CodeableConcept> =
    SimpleSearchParam<Slot, CodeableConcept>(
      name = "service-type",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.serviceType",
      extractor = { resource -> resource.serviceType },
    )

  public val specialty: SearchParam<Slot, CodeableConcept> =
    SimpleSearchParam<Slot, CodeableConcept>(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.specialty",
      extractor = { resource -> resource.specialty },
    )

  public val start: SearchParam<Slot, Instant> =
    SimpleSearchParam<Slot, Instant>(
      name = "start",
      type = SearchParamType.fromCode("date"),
      expression = "Slot.start",
      extractor = { resource -> listOf(resource.start) },
    )

  public val status: SearchParam<Slot, Any> =
    SimpleSearchParam<Slot, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the Slot resource type. */
  public val all: List<SearchParam<Slot, *>> =
    listOf(
      appointmentType,
      identifier,
      schedule,
      serviceCategory,
      serviceType,
      specialty,
      start,
      status,
    )
}
