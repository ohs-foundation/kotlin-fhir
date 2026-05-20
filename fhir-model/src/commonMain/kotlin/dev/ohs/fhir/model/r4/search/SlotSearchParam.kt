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
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Slot
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Slot] resource type. */
public sealed class SlotSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Slot): List<T>

  public data object AppointmentType : SlotSearchParam<CodeableConcept>() {
    public override val paramName: String = "appointment-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.appointmentType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<CodeableConcept> =
      listOfNotNull(resource.appointmentType)
  }

  public data object Identifier : SlotSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Schedule : SlotSearchParam<Reference>() {
    public override val paramName: String = "schedule"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Slot.schedule"

    public override val target: List<String> = listOf("Schedule")

    public override fun extract(resource: Slot): List<Reference> = listOf(resource.schedule)
  }

  public data object ServiceCategory : SlotSearchParam<CodeableConcept>() {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.serviceCategory"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<CodeableConcept> = resource.serviceCategory
  }

  public data object ServiceType : SlotSearchParam<CodeableConcept>() {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.serviceType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<CodeableConcept> = resource.serviceType
  }

  public data object Specialty : SlotSearchParam<CodeableConcept>() {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<CodeableConcept> = resource.specialty
  }

  public data object Start : SlotSearchParam<Instant>() {
    public override val paramName: String = "start"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Slot.start"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<Instant> = listOf(resource.start)
  }

  public data object Status : SlotSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<Any> = listOf(resource.status)
  }

  public companion object {
    /** All search parameters for the Slot resource type. */
    public val ALL: List<SlotSearchParam<*>> =
      listOf(
        AppointmentType,
        Identifier,
        Schedule,
        ServiceCategory,
        ServiceType,
        Specialty,
        Start,
        Status,
      )
  }
}
