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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Practitioner] resource type. */
public sealed class PractitionerSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Practitioner): List<T>

  public data object Active : PractitionerSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Practitioner.active"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : PractitionerSearchParam<dev.ohs.fhir.model.r4.Address>() {
    public override val paramName: kotlin.String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.address"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<dev.ohs.fhir.model.r4.Address> =
      resource.address
  }

  public data object AddressCity : PractitionerSearchParam<String>() {
    public override val paramName: kotlin.String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.address.city"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : PractitionerSearchParam<String>() {
    public override val paramName: kotlin.String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.address.country"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : PractitionerSearchParam<String>() {
    public override val paramName: kotlin.String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.address.postalCode"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : PractitionerSearchParam<String>() {
    public override val paramName: kotlin.String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.address.state"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : PractitionerSearchParam<Any>() {
    public override val paramName: kotlin.String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Practitioner.address.use"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Communication : PractitionerSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "communication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Practitioner.communication"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<CodeableConcept> =
      resource.communication
  }

  public data object Email : PractitionerSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Practitioner.telecom.where(system='email')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Family : PractitionerSearchParam<String>() {
    public override val paramName: kotlin.String = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.name.family"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<String> =
      resource.name.mapNotNull { it.family }
  }

  public data object Gender : PractitionerSearchParam<Any>() {
    public override val paramName: kotlin.String = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Practitioner.gender"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = listOfNotNull(resource.gender)
  }

  public data object Given : PractitionerSearchParam<String>() {
    public override val paramName: kotlin.String = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.name.given"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<String> =
      resource.name.flatMap { it.given }
  }

  public data object Identifier : PractitionerSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Practitioner.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Name : PractitionerSearchParam<HumanName>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<HumanName> = resource.name
  }

  public data object Phone : PractitionerSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Practitioner.telecom.where(system='phone')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : PractitionerSearchParam<HumanName>() {
    public override val paramName: kotlin.String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Practitioner.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<HumanName> = resource.name
  }

  public data object Telecom : PractitionerSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Practitioner.telecom"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Practitioner): List<ContactPoint> = resource.telecom
  }

  public companion object {
    /** All search parameters for the Practitioner resource type. */
    public val ALL: List<PractitionerSearchParam<*>> =
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
  }
}
