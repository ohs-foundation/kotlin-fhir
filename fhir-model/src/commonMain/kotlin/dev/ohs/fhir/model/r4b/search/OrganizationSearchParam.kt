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

import dev.ohs.fhir.model.r4b.Boolean
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Organization] resource type. */
public sealed class OrganizationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Organization): List<T>

  public data object Active : OrganizationSearchParam<Boolean>() {
    public override val paramName: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.active"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : OrganizationSearchParam<dev.ohs.fhir.model.r4b.Address>() {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<dev.ohs.fhir.model.r4b.Address> =
      resource.address
  }

  public data object AddressCity : OrganizationSearchParam<R4bString>() {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<R4bString> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : OrganizationSearchParam<R4bString>() {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<R4bString> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : OrganizationSearchParam<R4bString>() {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<R4bString> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : OrganizationSearchParam<R4bString>() {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<R4bString> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : OrganizationSearchParam<Any>() {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Endpoint : OrganizationSearchParam<Reference>() {
    public override val paramName: KotlinString = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Organization.endpoint"

    public override val target: List<KotlinString> = listOf("Endpoint")

    public override fun extract(resource: Organization): List<Reference> = resource.endpoint
  }

  public data object Identifier : OrganizationSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Name : OrganizationSearchParam<R4bString>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<R4bString> =
      listOfNotNull(resource.name)
  }

  public data object Partof : OrganizationSearchParam<Reference>() {
    public override val paramName: KotlinString = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Organization.partOf"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Organization): List<Reference> =
      listOfNotNull(resource.partOf)
  }

  public data object Phonetic : OrganizationSearchParam<R4bString>() {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Organization.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<R4bString> =
      listOfNotNull(resource.name)
  }

  public data object Type : OrganizationSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Organization.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Organization): List<CodeableConcept> = resource.type
  }

  public companion object {
    /** All search parameters for the Organization resource type. */
    public val ALL: List<OrganizationSearchParam<*>> =
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
  }
}
