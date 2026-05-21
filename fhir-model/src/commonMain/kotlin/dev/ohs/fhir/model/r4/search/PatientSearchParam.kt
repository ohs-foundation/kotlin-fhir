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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.DocumentReference
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

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

  public data object Active : SearchParam<Patient, Boolean> {
    public override val name: KotlinString = "active"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.active"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<Boolean> = listOfNotNull(resource.active)
  }

  public data object Address : SearchParam<Patient, dev.ohs.fhir.model.r4.Address> {
    public override val name: KotlinString = "address"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<dev.ohs.fhir.model.r4.Address> =
      resource.address
  }

  public data object AddressCity : SearchParam<Patient, R4String> {
    public override val name: KotlinString = "address-city"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address.city"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<R4String> =
      resource.address.mapNotNull { it.city }
  }

  public data object AddressCountry : SearchParam<Patient, R4String> {
    public override val name: KotlinString = "address-country"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address.country"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<R4String> =
      resource.address.mapNotNull { it.country }
  }

  public data object AddressPostalcode : SearchParam<Patient, R4String> {
    public override val name: KotlinString = "address-postalcode"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address.postalCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<R4String> =
      resource.address.mapNotNull { it.postalCode }
  }

  public data object AddressState : SearchParam<Patient, R4String> {
    public override val name: KotlinString = "address-state"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.address.state"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<R4String> =
      resource.address.mapNotNull { it.state }
  }

  public data object AddressUse : SearchParam<Patient, Any> {
    public override val name: KotlinString = "address-use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.address.use"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<Any> =
      resource.address.mapNotNull { it.use }
  }

  public data object Age : SearchParam<Patient, Any> {
    public override val name: KotlinString = "age"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: KotlinString = ""

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object BirthOrderBoolean : SearchParam<Patient, Any> {
    public override val name: KotlinString = "birthOrderBoolean"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = ""

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Birthdate : SearchParam<Patient, Date> {
    public override val name: KotlinString = "birthdate"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Patient.birthDate"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<Date> = listOfNotNull(resource.birthDate)
  }

  public data object DeathDate : SearchParam<Patient, DateTime> {
    public override val name: KotlinString = "death-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "(Patient.deceased as dateTime)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<DateTime> =
      listOfNotNull((resource.deceased as? Patient.Deceased.DateTime)?.value)
  }

  public data object Deceased : SearchParam<Patient, Any> {
    public override val name: KotlinString = "deceased"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "Patient.deceased.exists() and Patient.deceased != false"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Email : SearchParam<Patient, ContactPoint> {
    public override val name: KotlinString = "email"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.telecom.where(system='email')"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "email" }
  }

  public data object Family : SearchParam<Patient, R4String> {
    public override val name: KotlinString = "family"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.name.family"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<R4String> =
      resource.name.mapNotNull { it.family }
  }

  public data object Gender : SearchParam<Patient, Any> {
    public override val name: KotlinString = "gender"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.gender"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<Any> = listOfNotNull(resource.gender)
  }

  public data object GeneralPractitioner : SearchParam<Patient, Reference> {
    public override val name: KotlinString = "general-practitioner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Patient.generalPractitioner"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        dev.ohs.fhir.model.r4.Organization::class,
        PractitionerRole::class,
      )

    public override fun extract(resource: Patient): List<Reference> = resource.generalPractitioner
  }

  public data object Given : SearchParam<Patient, R4String> {
    public override val name: KotlinString = "given"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.name.given"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<R4String> =
      resource.name.flatMap { it.given }
  }

  public data object Identifier : SearchParam<Patient, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Language : SearchParam<Patient, CodeableConcept> {
    public override val name: KotlinString = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.communication.language"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<CodeableConcept> =
      resource.communication.map { it.language }
  }

  public data object Link : SearchParam<Patient, Reference> {
    public override val name: KotlinString = "link"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Patient.link.other"

    public override val target: List<KClass<out Resource>> =
      listOf(Patient::class, RelatedPerson::class)

    public override fun extract(resource: Patient): List<Reference> = resource.link.map { it.other }
  }

  public data object MothersMaidenName : SearchParam<Patient, Any> {
    public override val name: KotlinString = "mothersMaidenName"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString =
      "Patient.extension('http://hl7.org/fhir/StructureDefinition/patient-extensions-Patient-mothersMaidenName')"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Name : SearchParam<Patient, HumanName> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<HumanName> = resource.name
  }

  public data object Organization : SearchParam<Patient, Reference> {
    public override val name: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Patient.managingOrganization"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Organization::class)

    public override fun extract(resource: Patient): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object PartAgree : SearchParam<Patient, Any> {
    public override val name: KotlinString = "part-agree"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "DocumentReference.extension('http://example.org/fhir/StructureDefinition/participation-agreement')"

    public override val target: List<KClass<out Resource>> = listOf(DocumentReference::class)

    public override fun extract(resource: Patient): List<Any> = emptyList()
  }

  public data object Phone : SearchParam<Patient, ContactPoint> {
    public override val name: KotlinString = "phone"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.telecom.where(system='phone')"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> =
      resource.telecom.filter { it.system?.value?.toString() == "phone" }
  }

  public data object Phonetic : SearchParam<Patient, HumanName> {
    public override val name: KotlinString = "phonetic"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Patient.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<HumanName> = resource.name
  }

  public data object Telecom : SearchParam<Patient, ContactPoint> {
    public override val name: KotlinString = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Patient.telecom"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Patient): List<ContactPoint> = resource.telecom
  }
}
