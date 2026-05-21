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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CodeableConcept
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
    public override val paramName: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.active"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : SearchParam<Organization, dev.ohs.fhir.model.r5.Address> {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.contact.address"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<dev.ohs.fhir.model.r5.Address> =
      resource.contact.mapNotNull { it.address }
  }

  public data object AddressCity : SearchParam<Organization, R5String> {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.contact.address.city"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R5String> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<Organization, R5String> {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.contact.address.country"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R5String> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<Organization, R5String> {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.contact.address.postalCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R5String> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<Organization, R5String> {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.contact.address.state"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R5String> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<Organization, Any> {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.contact.address.use"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<Any> =
      resource.contact.mapNotNull { it.address }.mapNotNull { it.use }
  }

  public data object Endpoint : SearchParam<Organization, Reference> {
    public override val paramName: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Organization.endpoint"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Endpoint::class)

    public override fun extract(resource: Organization): List<Reference> = resource.endpoint
  }

  public data object Identifier : SearchParam<Organization, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<Organization, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Partof : SearchParam<Organization, Reference> {
    public override val paramName: KotlinString = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Organization.partOf"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Organization): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Phonetic : SearchParam<Organization, R5String> {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Type : SearchParam<Organization, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Organization): List<CodeableConcept> = resource.type
  }
}
