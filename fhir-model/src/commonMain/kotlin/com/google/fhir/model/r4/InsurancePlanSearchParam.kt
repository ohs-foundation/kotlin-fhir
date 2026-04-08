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

/** Search parameters for the [InsurancePlan] resource type. */
public sealed class InsurancePlanSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: InsurancePlan): List<T>

  public data object Address : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "InsurancePlan.contact.address"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object AddressCity : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "InsurancePlan.contact.address.city"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object AddressCountry : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "InsurancePlan.contact.address.country"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object AddressPostalcode : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "InsurancePlan.contact.address.postalCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object AddressState : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "InsurancePlan.contact.address.state"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object AddressUse : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InsurancePlan.contact.address.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object AdministeredBy : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "administered-by"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "InsurancePlan.administeredBy"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object Endpoint : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "endpoint"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "InsurancePlan.endpoint"

    public override val target: List<String> = listOf("Endpoint")

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object Identifier : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InsurancePlan.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object Name : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "name | alias"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object OwnedBy : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "owned-by"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "InsurancePlan.ownedBy"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object Phonetic : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "InsurancePlan.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object Status : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InsurancePlan.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public data object Type : InsurancePlanSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InsurancePlan.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InsurancePlan): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the InsurancePlan resource type. */
    public val ALL: List<InsurancePlanSearchParam<*>> =
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
  }
}
