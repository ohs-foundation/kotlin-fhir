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

import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Person
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Person] resource type. */
public object PersonSearchParam {
  /** All search parameters for the Person resource type. */
  public val ALL: List<SearchParam<Person, *>> =
    listOf(
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      Birthdate,
      Email,
      Gender,
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

  public data object Address : SearchParam<Person, dev.ohs.fhir.model.r4b.Address> {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Person.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<dev.ohs.fhir.model.r4b.Address> =
      resource.address
  }

  public data object AddressCity : SearchParam<Person, R4bString> {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Person.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<R4bString> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<Person, R4bString> {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Person.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<R4bString> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<Person, R4bString> {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Person.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<R4bString> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<Person, R4bString> {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Person.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<R4bString> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<Person, Any> {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Person.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Birthdate : SearchParam<Person, Date> {
    public override val paramName: KotlinString = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Person.birthDate"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<Date> = listOfNotNull(resource.birthDate)
  }

  public data object Email : SearchParam<Person, ContactPoint> {
    public override val paramName: KotlinString = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Person.telecom.where(system='email')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Gender : SearchParam<Person, Any> {
    public override val paramName: KotlinString = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Person.gender"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<Any> = listOfNotNull(resource.gender)
  }

  public data object Identifier : SearchParam<Person, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Person.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Link : SearchParam<Person, Reference> {
    public override val paramName: KotlinString = "link"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Person.link.target"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Patient", "Person", "RelatedPerson")

    public override fun extract(resource: Person): List<Reference> = resource.link.map { it.target }
  }

  public data object Name : SearchParam<Person, HumanName> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Person.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<HumanName> = resource.name
  }

  public data object Organization : SearchParam<Person, Reference> {
    public override val paramName: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Person.managingOrganization"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Person): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object Patient : SearchParam<Person, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Person.link.target.where(resolve() is Patient)"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Person): List<Reference> =
      resource.link
        .map { it.target }
        .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
  }

  public data object Phone : SearchParam<Person, ContactPoint> {
    public override val paramName: KotlinString = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Person.telecom.where(system='phone')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : SearchParam<Person, HumanName> {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Person.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<HumanName> = resource.name
  }

  public data object Practitioner : SearchParam<Person, Reference> {
    public override val paramName: KotlinString = "practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "Person.link.target.where(resolve() is Practitioner)"

    public override val target: List<KotlinString> = listOf("Practitioner")

    public override fun extract(resource: Person): List<Reference> =
      resource.link
        .map { it.target }
        .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
  }

  public data object Relatedperson : SearchParam<Person, Reference> {
    public override val paramName: KotlinString = "relatedperson"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "Person.link.target.where(resolve() is RelatedPerson)"

    public override val target: List<KotlinString> = listOf("RelatedPerson")

    public override fun extract(resource: Person): List<Reference> =
      resource.link
        .map { it.target }
        .filter { it.reference?.value?.toString()?.contains("RelatedPerson/") == true }
  }

  public data object Telecom : SearchParam<Person, ContactPoint> {
    public override val paramName: KotlinString = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Person.telecom"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Person): List<ContactPoint> = resource.telecom
  }
}
