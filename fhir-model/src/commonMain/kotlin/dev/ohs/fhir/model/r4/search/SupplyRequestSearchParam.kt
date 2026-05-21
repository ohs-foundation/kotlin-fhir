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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.SupplyRequest
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [SupplyRequest] resource type. */
public object SupplyRequestSearchParam {
  /** All search parameters for the SupplyRequest resource type. */
  public val ALL: List<SearchParam<SupplyRequest, *>> =
    listOf(Category, Date, Identifier, Requester, Status, Subject, Supplier)

  public data object Category : SearchParam<SupplyRequest, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyRequest): List<CodeableConcept> =
      listOfNotNull(resource.category)
  }

  public data object Date : SearchParam<SupplyRequest, DateTime> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "SupplyRequest.authoredOn"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object Identifier : SearchParam<SupplyRequest, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyRequest): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Requester : SearchParam<SupplyRequest, Reference> {
    public override val name: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.requester"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        Device::class,
        Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: SupplyRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : SearchParam<SupplyRequest, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyRequest): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<SupplyRequest, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.deliverTo"

    public override val target: List<KClass<out Resource>> =
      listOf(Organization::class, Patient::class, Location::class)

    public override fun extract(resource: SupplyRequest): List<Reference> =
      listOfNotNull(resource.deliverTo)
  }

  public data object Supplier : SearchParam<SupplyRequest, Reference> {
    public override val name: String = "supplier"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.supplier"

    public override val target: List<KClass<out Resource>> =
      listOf(Organization::class, HealthcareService::class)

    public override fun extract(resource: SupplyRequest): List<Reference> = resource.supplier
  }
}
