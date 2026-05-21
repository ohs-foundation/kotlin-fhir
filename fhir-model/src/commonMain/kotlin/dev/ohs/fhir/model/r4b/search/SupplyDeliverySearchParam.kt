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

import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.SupplyDelivery
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [SupplyDelivery] resource type. */
public object SupplyDeliverySearchParam {
  /** All search parameters for the SupplyDelivery resource type. */
  public val ALL: List<SearchParam<SupplyDelivery, *>> =
    listOf(Identifier, Patient, Receiver, Status, Supplier)

  public data object Identifier : SearchParam<SupplyDelivery, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyDelivery.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyDelivery): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Patient : SearchParam<SupplyDelivery, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyDelivery.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: SupplyDelivery): List<Reference> =
      listOfNotNull(resource.patient)
  }

  public data object Receiver : SearchParam<SupplyDelivery, Reference> {
    public override val name: String = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyDelivery.receiver"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: SupplyDelivery): List<Reference> = resource.receiver
  }

  public data object Status : SearchParam<SupplyDelivery, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SupplyDelivery.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: SupplyDelivery): List<Any> =
      listOfNotNull(resource.status)
  }

  public data object Supplier : SearchParam<SupplyDelivery, Reference> {
    public override val name: String = "supplier"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SupplyDelivery.supplier"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, PractitionerRole::class)

    public override fun extract(resource: SupplyDelivery): List<Reference> =
      listOfNotNull(resource.supplier)
  }
}
