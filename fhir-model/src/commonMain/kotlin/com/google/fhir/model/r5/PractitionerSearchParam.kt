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

/** Search parameters for the [Practitioner] resource type. */
public sealed class PractitionerSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Practitioner): List<T>

  public data object Active : PractitionerSearchParam<Any>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Practitioner.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Address : PractitionerSearchParam<Any>() {
    public override val paramName: String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.address"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object AddressCity : PractitionerSearchParam<Any>() {
    public override val paramName: String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.address.city"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object AddressCountry : PractitionerSearchParam<Any>() {
    public override val paramName: String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.address.country"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object AddressPostalcode : PractitionerSearchParam<Any>() {
    public override val paramName: String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.address.postalCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object AddressState : PractitionerSearchParam<Any>() {
    public override val paramName: String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.address.state"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object AddressUse : PractitionerSearchParam<Any>() {
    public override val paramName: String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Practitioner.address.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Communication : PractitionerSearchParam<Any>() {
    public override val paramName: String = "communication"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Practitioner.communication.language"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object DeathDate : PractitionerSearchParam<Any>() {
    public override val paramName: String = "death-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(Practitioner.deceased.ofType(dateTime))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Deceased : PractitionerSearchParam<Any>() {
    public override val paramName: String = "deceased"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "Practitioner.deceased.exists() and Practitioner.deceased != false"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Email : PractitionerSearchParam<Any>() {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Practitioner.telecom.where(system='email')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Family : PractitionerSearchParam<Any>() {
    public override val paramName: String = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.name.family"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Gender : PractitionerSearchParam<Any>() {
    public override val paramName: String = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Practitioner.gender"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Given : PractitionerSearchParam<Any>() {
    public override val paramName: String = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.name.given"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Identifier : PractitionerSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Practitioner.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Name : PractitionerSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Phone : PractitionerSearchParam<Any>() {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Practitioner.telecom.where(system='phone')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Phonetic : PractitionerSearchParam<Any>() {
    public override val paramName: String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Practitioner.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object QualificationPeriod : PractitionerSearchParam<Any>() {
    public override val paramName: String = "qualification-period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Practitioner.qualification.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
  }

  public data object Telecom : PractitionerSearchParam<Any>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Practitioner.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Practitioner): List<Any> = emptyList()
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
