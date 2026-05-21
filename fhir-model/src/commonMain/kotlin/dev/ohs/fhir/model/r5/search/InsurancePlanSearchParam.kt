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
import dev.ohs.fhir.model.r5.InsurancePlan
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [InsurancePlan] resource type. */
public object InsurancePlanSearchParam {
  /** All search parameters for the InsurancePlan resource type. */
  public val ALL: List<SearchParam<InsurancePlan, *>> =
    listOf(
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      AdministeredBy,
      Endpoint,
      Identifier,
      Name,
      OwnedBy,
      Phonetic,
      Status,
      Type,
    )

  public data object Address : SearchParam<InsurancePlan, dev.ohs.fhir.model.r5.Address> {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<dev.ohs.fhir.model.r5.Address> =
      resource.contact.mapNotNull { it.address }
  }

  public data object AddressCity : SearchParam<InsurancePlan, R5String> {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address.city"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R5String> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<InsurancePlan, R5String> {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address.country"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R5String> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<InsurancePlan, R5String> {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address.postalCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R5String> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<InsurancePlan, R5String> {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address.state"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R5String> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<InsurancePlan, Any> {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "InsurancePlan.contact.address.use"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.use }
  }

  public data object AdministeredBy : SearchParam<InsurancePlan, Reference> {
    public override val paramName: KotlinString = "administered-by"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "InsurancePlan.administeredBy"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: InsurancePlan): List<Reference> =
      listOfNotNull(resource.administeredBy)
  }

  public data object Endpoint : SearchParam<InsurancePlan, Reference> {
    public override val paramName: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "InsurancePlan.endpoint"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Endpoint::class)

    public override fun extract(resource: InsurancePlan): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<InsurancePlan, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "InsurancePlan.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<InsurancePlan, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object OwnedBy : SearchParam<InsurancePlan, Reference> {
    public override val paramName: KotlinString = "owned-by"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "InsurancePlan.ownedBy"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: InsurancePlan): List<Reference> =
      listOfNotNull(resource.ownedBy)
  }

  public data object Phonetic : SearchParam<InsurancePlan, R5String> {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Status : SearchParam<InsurancePlan, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "InsurancePlan.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = listOfNotNull(resource.status)
  }

  public data object Type : SearchParam<InsurancePlan, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "InsurancePlan.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<CodeableConcept> = resource.type
  }
}
