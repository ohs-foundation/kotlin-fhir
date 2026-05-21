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

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Organization] resource type. */
public object OrganizationSearchParam {
  /** All search parameters for the Organization resource type. */
  public val ALL: List<SearchParam<Organization, *>> =
    listOf(
      Active,
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      Endpoint,
      Identifier,
      Name,
      Partof,
      Phonetic,
      Type,
    )

  public data object Active : SearchParam<Organization, Boolean> {
    public override val name: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.active"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : SearchParam<Organization, dev.ohs.fhir.model.r4.Address> {
    public override val name: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<dev.ohs.fhir.model.r4.Address> =
      resource.address
  }

  public data object AddressCity : SearchParam<Organization, R4String> {
    public override val name: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address.city"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R4String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<Organization, R4String> {
    public override val name: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address.country"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R4String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<Organization, R4String> {
    public override val name: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address.postalCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R4String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<Organization, R4String> {
    public override val name: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address.state"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R4String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<Organization, Any> {
    public override val name: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.address.use"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Endpoint : SearchParam<Organization, Reference> {
    public override val name: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Organization.endpoint"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Endpoint::class)

    public override fun extract(resource: Organization): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<Organization, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<Organization, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Partof : SearchParam<Organization, Reference> {
    public override val name: KotlinString = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Organization.partOf"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Organization): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Phonetic : SearchParam<Organization, R4String> {
    public override val name: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Type : SearchParam<Organization, CodeableConcept> {
    public override val name: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<CodeableConcept> = resource.type
  }
}
