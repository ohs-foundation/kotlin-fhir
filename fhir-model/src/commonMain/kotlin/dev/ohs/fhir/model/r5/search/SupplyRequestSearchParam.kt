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

import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.SupplyRequest
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [SupplyRequest] resource type. */
public object SupplyRequestSearchParam {
  /** All search parameters for the SupplyRequest resource type. */
  public val ALL: List<SearchParam<SupplyRequest, *>> =
    listOf(Category, Date, Identifier, Patient, Requester, Status, Subject, Supplier)

  public data object Category : SearchParam<SupplyRequest, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyRequest): List<CodeableConcept> =
      listOfNotNull(resource.category)
  }

  public data object Date : SearchParam<SupplyRequest, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "SupplyRequest.authoredOn"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object Identifier : SearchParam<SupplyRequest, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyRequest): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Patient : SearchParam<SupplyRequest, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.deliverFor"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: SupplyRequest): List<Reference> =
      listOfNotNull(resource.deliverFor)
  }

  public data object Requester : SearchParam<SupplyRequest, Reference> {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.requester"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Organization::class,
        Device::class,
        CareTeam::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: SupplyRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : SearchParam<SupplyRequest, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyRequest.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyRequest): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<SupplyRequest, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.deliverTo"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Organization::class,
        RelatedPerson::class,
        Location::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: SupplyRequest): List<Reference> =
      listOfNotNull(resource.deliverTo)
  }

  public data object Supplier : SearchParam<SupplyRequest, Reference> {
    public override val paramName: String = "supplier"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyRequest.supplier"

    public override val target: List<KClass<out Resource>> =
      listOf(HealthcareService::class, Organization::class)

    public override fun extract(resource: SupplyRequest): List<Reference> = resource.supplier
  }
}
