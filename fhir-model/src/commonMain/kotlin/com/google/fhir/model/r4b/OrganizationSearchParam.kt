/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Organization] resource type. */
public sealed class OrganizationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Organization): List<T>

  public data object Active : OrganizationSearchParam<Any>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Organization.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object Address : OrganizationSearchParam<Any>() {
    public override val paramName: String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Organization.address"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object AddressCity : OrganizationSearchParam<Any>() {
    public override val paramName: String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Organization.address.city"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object AddressCountry : OrganizationSearchParam<Any>() {
    public override val paramName: String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Organization.address.country"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object AddressPostalcode : OrganizationSearchParam<Any>() {
    public override val paramName: String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Organization.address.postalCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object AddressState : OrganizationSearchParam<Any>() {
    public override val paramName: String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Organization.address.state"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object AddressUse : OrganizationSearchParam<Any>() {
    public override val paramName: String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Organization.address.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object Endpoint : OrganizationSearchParam<Any>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Organization.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object Identifier : OrganizationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Organization.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object Name : OrganizationSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Organization.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object Partof : OrganizationSearchParam<Any>() {
    public override val paramName: String = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Organization.partOf"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object Phonetic : OrganizationSearchParam<Any>() {
    public override val paramName: String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Organization.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
  }

  public data object Type : OrganizationSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Organization.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Organization): List<Any> = emptyList()
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
