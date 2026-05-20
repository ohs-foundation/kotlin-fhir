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
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Patient] resource type. */
public object PatientSearchParam {
  /** All search parameters for the Patient resource type. */
  public val ALL: List<SearchParam<Patient, *>> =
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

  public data object Active : SearchParam<Patient, Boolean> {
    public override val paramName: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.active"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<Boolean> = listOfNotNull(resource.active)
  }

  public data object Address : SearchParam<Patient, dev.ohs.fhir.model.r5.Address> {
    public override val paramName: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<dev.ohs.fhir.model.r5.Address> =
      resource.address
  }

  public data object AddressCity : SearchParam<Patient, R5String> {
    public override val paramName: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address.city"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<R5String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<Patient, R5String> {
    public override val paramName: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address.country"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<R5String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<Patient, R5String> {
    public override val paramName: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address.postalCode"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<R5String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<Patient, R5String> {
    public override val paramName: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address.state"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<R5String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<Patient, Any> {
    public override val paramName: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.address.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Birthdate : SearchParam<Patient, Date> {
    public override val paramName: KotlinString = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Patient.birthDate"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<Date> = listOfNotNull(resource.birthDate)
  }

  public data object DeathDate : SearchParam<Patient, Any> {
    public override val paramName: KotlinString = "death-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "(Patient.deceased.ofType(dateTime))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Deceased : SearchParam<Patient, Any> {
    public override val paramName: KotlinString = "deceased"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "Patient.deceased.exists() and Patient.deceased != false"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Email : SearchParam<Patient, ContactPoint> {
    public override val paramName: KotlinString = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.telecom.where(system='email')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Family : SearchParam<Patient, R5String> {
    public override val paramName: KotlinString = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.name.family"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<R5String> =
      resource.name.mapNotNull { it.family }
  }

  public data object Gender : SearchParam<Patient, Any> {
    public override val paramName: KotlinString = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.gender"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<Any> = listOfNotNull(resource.gender)
  }

  public data object GeneralPractitioner : SearchParam<Patient, Reference> {
    public override val paramName: KotlinString = "general-practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Patient.generalPractitioner"

    public override val target: List<KotlinString> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: Patient): List<Reference> = resource.generalPractitioner
  }

  public data object Given : SearchParam<Patient, R5String> {
    public override val paramName: KotlinString = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.name.given"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<R5String> =
      resource.name.flatMap { it.given }
  }

  public data object Identifier : SearchParam<Patient, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Language : SearchParam<Patient, CodeableConcept> {
    public override val paramName: KotlinString = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.communication.language"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<CodeableConcept> =
      resource.communication.map { it.language }
  }

  public data object Link : SearchParam<Patient, Reference> {
    public override val paramName: KotlinString = "link"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Patient.link.other"

    public override val target: List<KotlinString> = listOf("RelatedPerson", "Patient")

    public override fun extract(resource: Patient): List<Reference> = resource.link.map { it.other }
  }

  public data object Name : SearchParam<Patient, HumanName> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<HumanName> = resource.name
  }

  public data object Organization : SearchParam<Patient, Reference> {
    public override val paramName: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Patient.managingOrganization"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Patient): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object PartAgree : SearchParam<Patient, Any> {
    public override val paramName: KotlinString = "part-agree"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "Patient.extension('http://example.org/fhir/StructureDefinition/participation-agreement').value"

    public override val target: List<KotlinString> = listOf("DocumentReference")

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Phone : SearchParam<Patient, ContactPoint> {
    public override val paramName: KotlinString = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.telecom.where(system='phone')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : SearchParam<Patient, HumanName> {
    public override val paramName: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<HumanName> = resource.name
  }

  public data object Telecom : SearchParam<Patient, ContactPoint> {
    public override val paramName: KotlinString = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.telecom"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> = resource.telecom
  }
}
