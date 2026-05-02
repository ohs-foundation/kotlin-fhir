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

/** Search parameters for the [Person] resource type. */
public sealed class PersonSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Person): List<T>

  public data object Address : PersonSearchParam<dev.ohs.fhir.model.r5.Address>() {
    public override val paramName: kotlin.String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.address"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<dev.ohs.fhir.model.r5.Address> =
      resource.address
  }

  public data object AddressCity : PersonSearchParam<String>() {
    public override val paramName: kotlin.String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.address.city"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : PersonSearchParam<String>() {
    public override val paramName: kotlin.String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.address.country"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : PersonSearchParam<String>() {
    public override val paramName: kotlin.String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.address.postalCode"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : PersonSearchParam<String>() {
    public override val paramName: kotlin.String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.address.state"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : PersonSearchParam<Any>() {
    public override val paramName: kotlin.String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Person.address.use"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Birthdate : PersonSearchParam<Date>() {
    public override val paramName: kotlin.String = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Person.birthDate"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<Date> = listOfNotNull(resource.birthDate)
  }

  public data object DeathDate : PersonSearchParam<Any>() {
    public override val paramName: kotlin.String = "death-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "(Person.deceased.ofType(dateTime))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Deceased : PersonSearchParam<Any>() {
    public override val paramName: kotlin.String = "deceased"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "Person.deceased.exists() and Person.deceased != false"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<Any> = emptyList()
  }

  public data object Email : PersonSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Person.telecom.where(system='email')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Family : PersonSearchParam<String>() {
    public override val paramName: kotlin.String = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.name.family"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<String> =
      resource.name.mapNotNull { it.family }
  }

  public data object Gender : PersonSearchParam<Any>() {
    public override val paramName: kotlin.String = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Person.gender"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<Any> = listOfNotNull(resource.gender)
  }

  public data object Given : PersonSearchParam<String>() {
    public override val paramName: kotlin.String = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.name.given"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<String> = resource.name.flatMap { it.given }
  }

  public data object Identifier : PersonSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Person.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Link : PersonSearchParam<Reference>() {
    public override val paramName: kotlin.String = "link"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Person.link.target"

    public override val target: List<kotlin.String> =
      listOf("RelatedPerson", "Practitioner", "Person", "Patient")

    public override fun extract(resource: Person): List<Reference> = resource.link.map { it.target }
  }

  public data object Name : PersonSearchParam<HumanName>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<HumanName> = resource.name
  }

  public data object Organization : PersonSearchParam<Reference>() {
    public override val paramName: kotlin.String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Person.managingOrganization"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: Person): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object Patient : PersonSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Person.link.target.where(resolve() is Patient)"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: Person): List<Reference> =
      resource.link
        .map { it.target }
        .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Phone : PersonSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Person.telecom.where(system='phone')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : PersonSearchParam<HumanName>() {
    public override val paramName: kotlin.String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Person.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<HumanName> = resource.name
  }

  public data object Practitioner : PersonSearchParam<Reference>() {
    public override val paramName: kotlin.String = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "Person.link.target.where(resolve() is Practitioner)"

    public override val target: List<kotlin.String> = listOf("Practitioner")

    public override fun extract(resource: Person): List<Reference> =
      resource.link
        .map { it.target }
        .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
  }

  public data object Relatedperson : PersonSearchParam<Reference>() {
    public override val paramName: kotlin.String = "relatedperson"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "Person.link.target.where(resolve() is RelatedPerson)"

    public override val target: List<kotlin.String> = listOf("RelatedPerson")

    public override fun extract(resource: Person): List<Reference> =
      resource.link
        .map { it.target }
        .filter { it.reference?.value?.toString()?.contains("RelatedPerson/") == true }
  }

  public data object Telecom : PersonSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Person.telecom"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Person): List<ContactPoint> = resource.telecom
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
