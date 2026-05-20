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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RelatedPerson] resource type. */
public object RelatedPersonSearchParam {
  /** All search parameters for the RelatedPerson resource type. */
  public val ALL: List<SearchParam<RelatedPerson, *>> =
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

  public data object Active : SearchParam<RelatedPerson, Boolean> {
    public override val paramName: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.active"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : SearchParam<RelatedPerson, dev.ohs.fhir.model.r4.Address> {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<dev.ohs.fhir.model.r4.Address> =
      resource.address
  }

  public data object AddressCity : SearchParam<RelatedPerson, R4String> {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<R4String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<RelatedPerson, R4String> {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<R4String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<RelatedPerson, R4String> {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<R4String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<RelatedPerson, R4String> {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<R4String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<RelatedPerson, Any> {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Birthdate : SearchParam<RelatedPerson, Date> {
    public override val paramName: KotlinString = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "RelatedPerson.birthDate"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Date> =
      listOfNotNull(resource.birthDate)
  }

  public data object Email : SearchParam<RelatedPerson, ContactPoint> {
    public override val paramName: KotlinString = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.telecom.where(system='email')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Gender : SearchParam<RelatedPerson, Any> {
    public override val paramName: KotlinString = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.gender"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<Any> = listOfNotNull(resource.gender)
  }

  public data object Identifier : SearchParam<RelatedPerson, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<RelatedPerson, HumanName> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<HumanName> = resource.name
  }

  public data object Patient : SearchParam<RelatedPerson, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "RelatedPerson.patient"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: RelatedPerson): List<Reference> = listOf(resource.patient)
  }

  public data object Phone : SearchParam<RelatedPerson, ContactPoint> {
    public override val paramName: KotlinString = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.telecom.where(system='phone')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : SearchParam<RelatedPerson, HumanName> {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RelatedPerson.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<HumanName> = resource.name
  }

  public data object Relationship : SearchParam<RelatedPerson, CodeableConcept> {
    public override val paramName: KotlinString = "relationship"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.relationship"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<CodeableConcept> =
      resource.relationship
  }

  public data object Telecom : SearchParam<RelatedPerson, ContactPoint> {
    public override val paramName: KotlinString = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RelatedPerson.telecom"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RelatedPerson): List<ContactPoint> = resource.telecom
  }
}
