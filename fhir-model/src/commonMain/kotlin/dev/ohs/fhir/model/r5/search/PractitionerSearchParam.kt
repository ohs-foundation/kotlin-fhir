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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Practitioner] resource type. */
public sealed class PractitionerSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Practitioner): List<T>

  public data object Active : PractitionerSearchParam<Boolean>() {
    public override val paramName: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.active"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Boolean> =
      listOfNotNull(resource.active)
  }

  public data object Address : PractitionerSearchParam<dev.ohs.fhir.model.r5.Address>() {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<dev.ohs.fhir.model.r5.Address> =
      resource.address
  }

  public data object AddressCity : PractitionerSearchParam<R5String>() {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R5String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : PractitionerSearchParam<R5String>() {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R5String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : PractitionerSearchParam<R5String>() {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R5String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : PractitionerSearchParam<R5String>() {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R5String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : PractitionerSearchParam<Any>() {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Communication : PractitionerSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "communication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.communication.language"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<CodeableConcept> =
      resource.communication.map { it.language }
  }

  public data object DeathDate : PractitionerSearchParam<Any>() {
    public override val paramName: KotlinString = "death-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "(Practitioner.deceased.ofType(dateTime))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Deceased : PractitionerSearchParam<Any>() {
    public override val paramName: KotlinString = "deceased"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "Practitioner.deceased.exists() and Practitioner.deceased != false"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Email : PractitionerSearchParam<ContactPoint>() {
    public override val paramName: KotlinString = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.telecom.where(system='email')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Family : PractitionerSearchParam<R5String>() {
    public override val paramName: KotlinString = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.name.family"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R5String> =
      resource.name.mapNotNull { it.family }
  }

  public data object Gender : PractitionerSearchParam<Any>() {
    public override val paramName: KotlinString = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.gender"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = listOfNotNull(resource.gender)
  }

  public data object Given : PractitionerSearchParam<R5String>() {
    public override val paramName: KotlinString = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.name.given"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<R5String> =
      resource.name.flatMap { it.given }
  }

  public data object Identifier : PractitionerSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : PractitionerSearchParam<HumanName>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<HumanName> = resource.name
  }

  public data object Phone : PractitionerSearchParam<ContactPoint>() {
    public override val paramName: KotlinString = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.telecom.where(system='phone')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : PractitionerSearchParam<HumanName>() {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Practitioner.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<HumanName> = resource.name
  }

  public data object QualificationPeriod : PractitionerSearchParam<Period>() {
    public override val paramName: KotlinString = "qualification-period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Practitioner.qualification.period"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Practitioner): List<Period> =
      resource.qualification.mapNotNull { it.period }
  }

  public data object Telecom : PractitionerSearchParam<ContactPoint>() {
    public override val paramName: KotlinString = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Practitioner.telecom"

    public override val target: List<KotlinString> = emptyList()

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
        DeathDate,
        Deceased,
        Email,
        Family,
        Gender,
        Given,
        Identifier,
        Name,
        Phone,
        Phonetic,
        QualificationPeriod,
        Telecom,
      )
  }
}
