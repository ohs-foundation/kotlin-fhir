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
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RelatedPerson] resource type. */
public sealed class RelatedPersonSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RelatedPerson): List<T>

  public data object Active : RelatedPersonSearchParam<Boolean>() {
    public override val paramName: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.active"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : RelatedPersonSearchParam<dev.ohs.fhir.model.r4b.Address>() {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<dev.ohs.fhir.model.r4b.Address> =
      resource.address
  }

  public data object AddressCity : RelatedPersonSearchParam<R4bString>() {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<R4bString> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : RelatedPersonSearchParam<R4bString>() {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<R4bString> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : RelatedPersonSearchParam<R4bString>() {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<R4bString> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : RelatedPersonSearchParam<R4bString>() {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<R4bString> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : RelatedPersonSearchParam<Any>() {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Birthdate : RelatedPersonSearchParam<Date>() {
    public override val paramName: KotlinString = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "RelatedPerson.birthDate"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Date> =
      listOfNotNull(resource.birthDate)
  }

  public data object Email : RelatedPersonSearchParam<ContactPoint>() {
    public override val paramName: KotlinString = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.telecom.where(system='email')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Gender : RelatedPersonSearchParam<Any>() {
    public override val paramName: KotlinString = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.gender"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = listOfNotNull(resource.gender)
  }

  public data object Identifier : RelatedPersonSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Name : RelatedPersonSearchParam<HumanName>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<HumanName> = resource.name
  }

  public data object Patient : RelatedPersonSearchParam<Reference>() {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "RelatedPerson.patient"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: RelatedPerson): List<Reference> = listOf(resource.patient)
  }

  public data object Phone : RelatedPersonSearchParam<ContactPoint>() {
    public override val paramName: KotlinString = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.telecom.where(system='phone')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : RelatedPersonSearchParam<HumanName>() {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<HumanName> = resource.name
  }

  public data object Relationship : RelatedPersonSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.relationship"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<CodeableConcept> =
      resource.relationship
  }

  public data object Telecom : RelatedPersonSearchParam<ContactPoint>() {
    public override val paramName: KotlinString = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.telecom"

    public override val target: List<KotlinString> = emptyList()

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
        Gender,
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
