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
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Slot
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Slot] resource type. */
public object SlotSearchParam {
  /** All search parameters for the Slot resource type. */
  public val ALL: List<SearchParam<Slot, *>> =
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

  public data object AppointmentType : SearchParam<Slot, CodeableConcept> {
    public override val paramName: String = "appointment-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.appointmentType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<CodeableConcept> =
      listOfNotNull(resource.appointmentType)
  }

  public data object Identifier : SearchParam<Slot, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Schedule : SearchParam<Slot, Reference> {
    public override val paramName: String = "schedule"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Slot.schedule"

    public override val target: List<String> = listOf("Schedule")

    public override fun extract(resource: Slot): List<Reference> = listOf(resource.schedule)
  }

  public data object ServiceCategory : SearchParam<Slot, CodeableConcept> {
    public override val paramName: String = "service-category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.serviceCategory"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<CodeableConcept> = resource.serviceCategory
  }

  public data object ServiceType : SearchParam<Slot, CodeableConcept> {
    public override val paramName: String = "service-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.serviceType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<CodeableConcept> = resource.serviceType
  }

  public data object Specialty : SearchParam<Slot, CodeableConcept> {
    public override val paramName: String = "specialty"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.specialty"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<CodeableConcept> = resource.specialty
  }

  public data object Start : SearchParam<Slot, Instant> {
    public override val paramName: String = "start"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Slot.start"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<Instant> = listOf(resource.start)
  }

  public data object Status : SearchParam<Slot, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Slot.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Slot): List<Any> = listOf(resource.status)
  }
}
