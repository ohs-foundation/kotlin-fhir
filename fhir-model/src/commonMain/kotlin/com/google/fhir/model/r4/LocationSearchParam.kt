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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Location] resource type. */
public sealed class LocationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Location): List<T>

  public data object Address : LocationSearchParam<Any>() {
    public override val paramName: String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Location.address"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object AddressCity : LocationSearchParam<Any>() {
    public override val paramName: String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Location.address.city"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object AddressCountry : LocationSearchParam<Any>() {
    public override val paramName: String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Location.address.country"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object AddressPostalcode : LocationSearchParam<Any>() {
    public override val paramName: String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Location.address.postalCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object AddressState : LocationSearchParam<Any>() {
    public override val paramName: String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Location.address.state"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object AddressUse : LocationSearchParam<Any>() {
    public override val paramName: String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Location.address.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Endpoint : LocationSearchParam<Any>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Location.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Identifier : LocationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Location.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Name : LocationSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Location.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Near : LocationSearchParam<Any>() {
    public override val paramName: String = "near"

    public override val type: SearchParamType = SearchParamType.fromCode("special")

    public override val expression: String = "Location.position"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object OperationalStatus : LocationSearchParam<Any>() {
    public override val paramName: String = "operational-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Location.operationalStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Organization : LocationSearchParam<Any>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Location.managingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Partof : LocationSearchParam<Any>() {
    public override val paramName: String = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Location.partOf"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Status : LocationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Location.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public data object Type : LocationSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Location.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Location): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Location resource type. */
    public val ALL: List<LocationSearchParam<*>> =
      listOf(
        Address,
        AddressCity,
        AddressCountry,
        AddressPostalcode,
        AddressState,
        AddressUse,
        Endpoint,
        Identifier,
        Name,
        Near,
        OperationalStatus,
        Organization,
        Partof,
        Status,
        Type,
      )
  }
}
