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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Patient] resource type. */
public sealed class PatientSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Patient): List<T>

  public data object Active : PatientSearchParam<Any>() {
    public override val paramName: String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Patient.active"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Address : PatientSearchParam<Any>() {
    public override val paramName: String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.address"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object AddressCity : PatientSearchParam<Any>() {
    public override val paramName: String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.address.city"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object AddressCountry : PatientSearchParam<Any>() {
    public override val paramName: String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.address.country"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object AddressPostalcode : PatientSearchParam<Any>() {
    public override val paramName: String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.address.postalCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object AddressState : PatientSearchParam<Any>() {
    public override val paramName: String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.address.state"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object AddressUse : PatientSearchParam<Any>() {
    public override val paramName: String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Patient.address.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Age : PatientSearchParam<Any>() {
    public override val paramName: String = "age"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = ""

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object BirthOrderBoolean : PatientSearchParam<Any>() {
    public override val paramName: String = "birthOrderBoolean"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = ""

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Birthdate : PatientSearchParam<Any>() {
    public override val paramName: String = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Patient.birthDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object DeathDate : PatientSearchParam<Any>() {
    public override val paramName: String = "death-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "(Patient.deceased as dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Deceased : PatientSearchParam<Any>() {
    public override val paramName: String = "deceased"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "Patient.deceased.exists() and Patient.deceased != false"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Email : PatientSearchParam<Any>() {
    public override val paramName: String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Patient.telecom.where(system='email')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Family : PatientSearchParam<Any>() {
    public override val paramName: String = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.name.family"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Gender : PatientSearchParam<Any>() {
    public override val paramName: String = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Patient.gender"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object GeneralPractitioner : PatientSearchParam<Any>() {
    public override val paramName: String = "general-practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Patient.generalPractitioner"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Given : PatientSearchParam<Any>() {
    public override val paramName: String = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.name.given"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Identifier : PatientSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Patient.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Language : PatientSearchParam<Any>() {
    public override val paramName: String = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Patient.communication.language"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Link : PatientSearchParam<Any>() {
    public override val paramName: String = "link"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Patient.link.other"

    public override val target: List<String> = listOf("Patient", "RelatedPerson")

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object MothersMaidenName : PatientSearchParam<Any>() {
    public override val paramName: String = "mothersMaidenName"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String =
      "Patient.extension('http://hl7.org/fhir/StructureDefinition/patient-mothersMaidenName')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Name : PatientSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Organization : PatientSearchParam<Any>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Patient.managingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object PartAgree : PatientSearchParam<Any>() {
    public override val paramName: String = "part-agree"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "DocumentReference.extension('http://example.org/fhir/StructureDefinition/participation-agreement')"

    public override val target: List<String> = listOf("DocumentReference")

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Phone : PatientSearchParam<Any>() {
    public override val paramName: String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Patient.telecom.where(system='phone')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Phonetic : PatientSearchParam<Any>() {
    public override val paramName: String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Patient.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Telecom : PatientSearchParam<Any>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Patient.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Patient resource type. */
    public val ALL: List<PatientSearchParam<*>> =
      listOf(
        Active,
        Address,
        AddressCity,
        AddressCountry,
        AddressPostalcode,
        AddressState,
        AddressUse,
        Age,
        BirthOrderBoolean,
        Birthdate,
        DeathDate,
        Deceased,
        Email,
        Family,
        Gender,
        GeneralPractitioner,
        Given,
        Identifier,
        Language,
        Link,
        MothersMaidenName,
        Name,
        Organization,
        PartAgree,
        Phone,
        Phonetic,
        Telecom,
      )
  }
}
