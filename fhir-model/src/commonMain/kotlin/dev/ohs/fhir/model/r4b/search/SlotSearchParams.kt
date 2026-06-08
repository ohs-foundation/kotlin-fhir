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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Schedule
import dev.ohs.fhir.model.r4b.Slot
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Slot] resource type. */
public object SlotSearchParams {
  public val appointmentType: SearchParam<Slot, CodeableConcept> =
    SearchParam(
      name = "appointment-type",
      type = SearchParamType.Token,
      expression = "Slot.appointmentType",
      extractor = { resource -> listOfNotNull(resource.appointmentType) },
    )

  public val identifier: SearchParam<Slot, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Slot.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val schedule: SearchParam<Slot, Reference> =
    SearchParam(
      name = "schedule",
      type = SearchParamType.Reference,
      expression = "Slot.schedule",
      target = listOf(Schedule::class),
      extractor = { resource -> listOf(resource.schedule) },
    )

  public val serviceCategory: SearchParam<Slot, CodeableConcept> =
    SearchParam(
      name = "service-category",
      type = SearchParamType.Token,
      expression = "Slot.serviceCategory",
      extractor = { resource -> resource.serviceCategory },
    )

  public val serviceType: SearchParam<Slot, CodeableConcept> =
    SearchParam(
      name = "service-type",
      type = SearchParamType.Token,
      expression = "Slot.serviceType",
      extractor = { resource -> resource.serviceType },
    )

  public val specialty: SearchParam<Slot, CodeableConcept> =
    SearchParam(
      name = "specialty",
      type = SearchParamType.Token,
      expression = "Slot.specialty",
      extractor = { resource -> resource.specialty },
    )

  public val start: SearchParam<Slot, Instant> =
    SearchParam(
      name = "start",
      type = SearchParamType.Date,
      expression = "Slot.start",
      extractor = { resource -> listOf(resource.start) },
    )

  public val status: SearchParam<Slot, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Slot.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Slot, *>> = listOf()

  /**
   * Supported search parameters for the Slot resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
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
