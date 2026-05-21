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
import dev.ohs.fhir.model.r4b.InsurancePlan
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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

  public data object Address : SearchParam<InsurancePlan, dev.ohs.fhir.model.r4b.Address> {
    public override val name: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<dev.ohs.fhir.model.r4b.Address> =
      resource.contact.mapNotNull { it.address }
  }

  public data object AddressCity : SearchParam<InsurancePlan, R4bString> {
    public override val name: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address.city"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R4bString> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<InsurancePlan, R4bString> {
    public override val name: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address.country"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R4bString> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<InsurancePlan, R4bString> {
    public override val name: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address.postalCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R4bString> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<InsurancePlan, R4bString> {
    public override val name: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.contact.address.state"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R4bString> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<InsurancePlan, Any> {
    public override val name: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "InsurancePlan.contact.address.use"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.use }
  }

  public data object AdministeredBy : SearchParam<InsurancePlan, Reference> {
    public override val name: KotlinString = "administered-by"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "InsurancePlan.administeredBy"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: InsurancePlan): List<Reference> =
      listOfNotNull(resource.administeredBy)
  }

  public data object Endpoint : SearchParam<InsurancePlan, Reference> {
    public override val name: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "InsurancePlan.endpoint"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Endpoint::class)

    public override fun extract(resource: InsurancePlan): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<InsurancePlan, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "InsurancePlan.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<InsurancePlan, Any> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "name | alias"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object OwnedBy : SearchParam<InsurancePlan, Reference> {
    public override val name: KotlinString = "owned-by"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "InsurancePlan.ownedBy"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: InsurancePlan): List<Reference> =
      listOfNotNull(resource.ownedBy)
  }

  public data object Phonetic : SearchParam<InsurancePlan, R4bString> {
    public override val name: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "InsurancePlan.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<R4bString> =
      listOfNotNull(resource.name)
  }

  public data object Status : SearchParam<InsurancePlan, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "InsurancePlan.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = listOfNotNull(resource.status)
  }

  public data object Type : SearchParam<InsurancePlan, CodeableConcept> {
    public override val name: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "InsurancePlan.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InsurancePlan): List<CodeableConcept> = resource.type
  }
}
