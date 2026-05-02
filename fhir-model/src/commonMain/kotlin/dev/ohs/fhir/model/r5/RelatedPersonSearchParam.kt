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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RelatedPerson] resource type. */
public sealed class RelatedPersonSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RelatedPerson): List<T>

  public data object Active : RelatedPersonSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RelatedPerson.active"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : RelatedPersonSearchParam<dev.ohs.fhir.model.r5.Address>() {
    public override val paramName: kotlin.String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.address"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<dev.ohs.fhir.model.r5.Address> =
      resource.address
  }

  public data object AddressCity : RelatedPersonSearchParam<String>() {
    public override val paramName: kotlin.String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.address.city"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : RelatedPersonSearchParam<String>() {
    public override val paramName: kotlin.String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.address.country"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : RelatedPersonSearchParam<String>() {
    public override val paramName: kotlin.String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.address.postalCode"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : RelatedPersonSearchParam<String>() {
    public override val paramName: kotlin.String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.address.state"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : RelatedPersonSearchParam<Any>() {
    public override val paramName: kotlin.String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RelatedPerson.address.use"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Birthdate : RelatedPersonSearchParam<Date>() {
    public override val paramName: kotlin.String = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "RelatedPerson.birthDate"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Date> =
      listOfNotNull(resource.birthDate)
  }

  public data object Email : RelatedPersonSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RelatedPerson.telecom.where(system='email')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Family : RelatedPersonSearchParam<String>() {
    public override val paramName: kotlin.String = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.name.family"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<String> =
      resource.name.mapNotNull { it.family }
  }

  public data object Gender : RelatedPersonSearchParam<Any>() {
    public override val paramName: kotlin.String = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RelatedPerson.gender"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = listOfNotNull(resource.gender)
  }

  public data object Given : RelatedPersonSearchParam<String>() {
    public override val paramName: kotlin.String = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.name.given"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<String> =
      resource.name.flatMap { it.given }
  }

  public data object Identifier : RelatedPersonSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RelatedPerson.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : RelatedPersonSearchParam<HumanName>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<HumanName> = resource.name
  }

  public data object Patient : RelatedPersonSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "RelatedPerson.patient"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: RelatedPerson): List<Reference> = listOf(resource.patient)
  }

  public data object Phone : RelatedPersonSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RelatedPerson.telecom.where(system='phone')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : RelatedPersonSearchParam<HumanName>() {
    public override val paramName: kotlin.String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RelatedPerson.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<HumanName> = resource.name
  }

  public data object Relationship : RelatedPersonSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RelatedPerson.relationship"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<CodeableConcept> =
      resource.relationship
  }

  public data object Telecom : RelatedPersonSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RelatedPerson.telecom"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RelatedPerson): List<ContactPoint> = resource.telecom
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
