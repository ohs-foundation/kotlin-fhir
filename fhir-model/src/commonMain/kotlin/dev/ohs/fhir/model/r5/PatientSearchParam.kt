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

/** Search parameters for the [Patient] resource type. */
public sealed class PatientSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Patient): List<T>

  public data object Active : PatientSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Patient.active"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<Boolean> = listOfNotNull(resource.active)
  }

  public data object Address : PatientSearchParam<dev.ohs.fhir.model.r5.Address>() {
    public override val paramName: kotlin.String = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.address"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<dev.ohs.fhir.model.r5.Address> =
      resource.address
  }

  public data object AddressCity : PatientSearchParam<String>() {
    public override val paramName: kotlin.String = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.address.city"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : PatientSearchParam<String>() {
    public override val paramName: kotlin.String = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.address.country"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : PatientSearchParam<String>() {
    public override val paramName: kotlin.String = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.address.postalCode"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : PatientSearchParam<String>() {
    public override val paramName: kotlin.String = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.address.state"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : PatientSearchParam<Any>() {
    public override val paramName: kotlin.String = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Patient.address.use"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Birthdate : PatientSearchParam<Date>() {
    public override val paramName: kotlin.String = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Patient.birthDate"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<Date> = listOfNotNull(resource.birthDate)
  }

  public data object DeathDate : PatientSearchParam<Any>() {
    public override val paramName: kotlin.String = "death-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "(Patient.deceased.ofType(dateTime))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Deceased : PatientSearchParam<Any>() {
    public override val paramName: kotlin.String = "deceased"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "Patient.deceased.exists() and Patient.deceased != false"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Email : PatientSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Patient.telecom.where(system='email')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Family : PatientSearchParam<String>() {
    public override val paramName: kotlin.String = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.name.family"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<String> =
      resource.name.mapNotNull { it.family }
  }

  public data object Gender : PatientSearchParam<Any>() {
    public override val paramName: kotlin.String = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Patient.gender"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<Any> = listOfNotNull(resource.gender)
  }

  public data object GeneralPractitioner : PatientSearchParam<Reference>() {
    public override val paramName: kotlin.String = "general-practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Patient.generalPractitioner"

    public override val target: List<kotlin.String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: Patient): List<Reference> = resource.generalPractitioner
  }

  public data object Given : PatientSearchParam<String>() {
    public override val paramName: kotlin.String = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.name.given"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<String> =
      resource.name.flatMap { it.given }
  }

  public data object Identifier : PatientSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Patient.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Language : PatientSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Patient.communication.language"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<CodeableConcept> =
      resource.communication.map { it.language }
  }

  public data object Link : PatientSearchParam<Reference>() {
    public override val paramName: kotlin.String = "link"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Patient.link.other"

    public override val target: List<kotlin.String> = listOf("RelatedPerson", "Patient")

    public override fun extract(resource: Patient): List<Reference> = resource.link.map { it.other }
  }

  public data object Name : PatientSearchParam<HumanName>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<HumanName> = resource.name
  }

  public data object Organization : PatientSearchParam<Reference>() {
    public override val paramName: kotlin.String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Patient.managingOrganization"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: Patient): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object PartAgree : PatientSearchParam<Any>() {
    public override val paramName: kotlin.String = "part-agree"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "Patient.extension('http://example.org/fhir/StructureDefinition/participation-agreement').value"

    public override val target: List<kotlin.String> = listOf("DocumentReference")

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Phone : PatientSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Patient.telecom.where(system='phone')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : PatientSearchParam<HumanName>() {
    public override val paramName: kotlin.String = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Patient.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<HumanName> = resource.name
  }

  public data object Telecom : PatientSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Patient.telecom"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> = resource.telecom
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
        Name,
        Organization,
        PartAgree,
        Phone,
        Phonetic,
        Telecom,
      )
  }
}
