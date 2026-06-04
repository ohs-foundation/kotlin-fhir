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
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Schedule
import dev.ohs.fhir.model.r5.Slot
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Slot] resource type. */
public object SlotSearchParams {
  public val appointmentType: SearchParam<Slot, CodeableConcept> =
    SearchParam<Slot, CodeableConcept>(
      name = "appointment-type",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.appointmentType",
      extractor = { resource -> resource.appointmentType },
    )

  public val identifier: SearchParam<Slot, Identifier> =
    SearchParam<Slot, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val schedule: SearchParam<Slot, Reference> =
    SearchParam<Slot, Reference>(
      name = "schedule",
      type = SearchParamType.fromCode("reference"),
      expression = "Slot.schedule",
      target = listOf(Schedule::class),
      extractor = { resource -> listOf(resource.schedule) },
    )

  public val serviceCategory: SearchParam<Slot, CodeableConcept> =
    SearchParam<Slot, CodeableConcept>(
      name = "service-category",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.serviceCategory",
      extractor = { resource -> resource.serviceCategory },
    )

  public val serviceType: SearchParam<Slot, CodeableConcept> =
    SearchParam<Slot, CodeableConcept>(
      name = "service-type",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.serviceType.concept",
      extractor = { resource -> resource.serviceType.mapNotNull { it.concept } },
    )

  public val serviceTypeReference: SearchParam<Slot, Reference> =
    SearchParam<Slot, Reference>(
      name = "service-type-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Slot.serviceType.reference",
      target = listOf(HealthcareService::class),
      extractor = { resource -> resource.serviceType.mapNotNull { it.reference } },
    )

  public val specialty: SearchParam<Slot, CodeableConcept> =
    SearchParam<Slot, CodeableConcept>(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "Slot.specialty",
      extractor = { resource -> resource.specialty },
    )

  public val start: SearchParam<Slot, Instant> =
    SearchParam<Slot, Instant>(
      name = "start",
      type = SearchParamType.fromCode("date"),
      expression = "Slot.start",
      extractor = { resource -> listOf(resource.start) },
    )

  public val status: SearchParam<Slot, Any> =
    SearchParam<Slot, Any>(
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
      serviceTypeReference,
      specialty,
      start,
      status,
    )
}
