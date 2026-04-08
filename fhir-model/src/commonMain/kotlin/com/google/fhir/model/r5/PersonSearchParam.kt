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

/** Search parameters for the [Person] resource type. */
public sealed class PersonSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Person): List<T>

  public data object Address : PersonSearchParam<Any>() {
    public override val paramName: String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.address"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object AddressCity : PersonSearchParam<Any>() {
    public override val paramName: String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.address.city"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object AddressCountry : PersonSearchParam<Any>() {
    public override val paramName: String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.address.country"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object AddressPostalcode : PersonSearchParam<Any>() {
    public override val paramName: String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.address.postalCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object AddressState : PersonSearchParam<Any>() {
    public override val paramName: String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.address.state"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object AddressUse : PersonSearchParam<Any>() {
    public override val paramName: String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Person.address.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Birthdate : PersonSearchParam<Any>() {
    public override val paramName: String = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Person.birthDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object DeathDate : PersonSearchParam<Any>() {
    public override val paramName: String = "death-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(Person.deceased.ofType(dateTime))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Deceased : PersonSearchParam<Any>() {
    public override val paramName: String = "deceased"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Person.deceased.exists() and Person.deceased != false"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Email : PersonSearchParam<Any>() {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Person.telecom.where(system='email')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Family : PersonSearchParam<Any>() {
    public override val paramName: String = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.name.family"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Gender : PersonSearchParam<Any>() {
    public override val paramName: String = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Person.gender"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Given : PersonSearchParam<Any>() {
    public override val paramName: String = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.name.given"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Identifier : PersonSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Person.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Link : PersonSearchParam<Any>() {
    public override val paramName: String = "link"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Person.link.target"

    public override val target: List<String> =
      listOf("RelatedPerson", "Practitioner", "Person", "Patient")

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Name : PersonSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Organization : PersonSearchParam<Any>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Person.managingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Patient : PersonSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Person.link.target.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Phone : PersonSearchParam<Any>() {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Person.telecom.where(system='phone')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Phonetic : PersonSearchParam<Any>() {
    public override val paramName: String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Person.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Practitioner : PersonSearchParam<Any>() {
    public override val paramName: String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Person.link.target.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Relatedperson : PersonSearchParam<Any>() {
    public override val paramName: String = "relatedperson"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Person.link.target.where(resolve() is RelatedPerson)"

    public override val target: List<String> = listOf("RelatedPerson")

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Telecom : PersonSearchParam<Any>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Person.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Person resource type. */
    public val ALL: List<PersonSearchParam<*>> =
      listOf(
        Address,
        AddressCity,
        AddressCountry,
        AddressPostalcode,
        AddressState,
        AddressUse,
        Birthdate,
        DeathDate,
        Deceased,
        Email,
        Family,
        Gender,
        Given,
        Identifier,
        Link,
        Name,
        Organization,
        Patient,
        Phone,
        Phonetic,
        Practitioner,
        Relatedperson,
        Telecom,
      )
  }
}
