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
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Practitioner] resource type. */
public object PractitionerSearchParam {
  /** All search parameters for the Practitioner resource type. */
  public val ALL: List<SearchParam<Practitioner, *>> =
    listOf(
      Active,
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      Communication,
      Email,
      Family,
      Gender,
      Given,
      Identifier,
      Name,
      Phone,
      Phonetic,
      Telecom,
    )

  public data object Active : SearchParam<Practitioner, Boolean> {
    public override val paramName: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.active"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : SearchParam<Practitioner, dev.ohs.fhir.model.r4.Address> {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<dev.ohs.fhir.model.r4.Address> =
      resource.address
  }

  public data object AddressCity : SearchParam<Practitioner, R4String> {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R4String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<Practitioner, R4String> {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R4String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<Practitioner, R4String> {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R4String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<Practitioner, R4String> {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R4String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<Practitioner, Any> {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Communication : SearchParam<Practitioner, CodeableConcept> {
    public override val paramName: KotlinString = "communication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.communication"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<CodeableConcept> =
      resource.communication
  }

  public data object Email : SearchParam<Practitioner, ContactPoint> {
    public override val paramName: KotlinString = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.telecom.where(system='email')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Family : SearchParam<Practitioner, R4String> {
    public override val paramName: KotlinString = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.name.family"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R4String> =
      resource.name.mapNotNull { it.family }
  }

  public data object Gender : SearchParam<Practitioner, Any> {
    public override val paramName: KotlinString = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.gender"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = listOfNotNull(resource.gender)
  }

  public data object Given : SearchParam<Practitioner, R4String> {
    public override val paramName: KotlinString = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.name.given"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R4String> =
      resource.name.flatMap { it.given }
  }

  public data object Identifier : SearchParam<Practitioner, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<Practitioner, HumanName> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<HumanName> = resource.name
  }

  public data object Phone : SearchParam<Practitioner, ContactPoint> {
    public override val paramName: KotlinString = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.telecom.where(system='phone')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : SearchParam<Practitioner, HumanName> {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<HumanName> = resource.name
  }

  public data object Telecom : SearchParam<Practitioner, ContactPoint> {
    public override val paramName: KotlinString = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.telecom"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<ContactPoint> = resource.telecom
  }
}
