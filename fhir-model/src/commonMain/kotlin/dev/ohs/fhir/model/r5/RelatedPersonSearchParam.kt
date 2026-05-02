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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RelatedPerson] resource type. */
public sealed class RelatedPersonSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RelatedPerson): List<T>

  public data object Active : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RelatedPerson.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Address : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.address"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object AddressCity : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.address.city"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object AddressCountry : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.address.country"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object AddressPostalcode : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.address.postalCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object AddressState : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.address.state"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object AddressUse : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RelatedPerson.address.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Birthdate : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "RelatedPerson.birthDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Email : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RelatedPerson.telecom.where(system='email')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Family : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.name.family"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Gender : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RelatedPerson.gender"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Given : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.name.given"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Identifier : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RelatedPerson.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Name : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Patient : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RelatedPerson.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Phone : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RelatedPerson.telecom.where(system='phone')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Phonetic : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RelatedPerson.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Relationship : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RelatedPerson.relationship"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public data object Telecom : RelatedPersonSearchParam<Any>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RelatedPerson.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the RelatedPerson resource type. */
    public val ALL: List<RelatedPersonSearchParam<*>> =
      listOf(
        Active,
        Address,
        AddressCity,
        AddressCountry,
        AddressPostalcode,
        AddressState,
        AddressUse,
        Birthdate,
        Email,
        Family,
        Gender,
        Given,
        Identifier,
        Name,
        Patient,
        Phone,
        Phonetic,
        Relationship,
        Telecom,
      )
  }
}
