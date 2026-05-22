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

import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Patient] resource type. */
public object PatientSearchParam {
  public val Active: SearchParam<Patient, Boolean> =
    SimpleSearchParam<Patient, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val Address: SearchParam<Patient, Address> =
    SimpleSearchParam<Patient, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.address",
      extractor = { resource -> resource.address },
    )

  public val AddressCity: SearchParam<Patient, String> =
    SimpleSearchParam<Patient, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val AddressCountry: SearchParam<Patient, String> =
    SimpleSearchParam<Patient, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val AddressPostalcode: SearchParam<Patient, String> =
    SimpleSearchParam<Patient, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val AddressState: SearchParam<Patient, String> =
    SimpleSearchParam<Patient, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val AddressUse: SearchParam<Patient, Any> =
    SimpleSearchParam<Patient, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val Birthdate: SearchParam<Patient, Date> =
    SimpleSearchParam<Patient, Date>(
      name = "birthdate",
      type = SearchParamType.fromCode("date"),
      expression = "Patient.birthDate",
      extractor = { resource -> listOfNotNull(resource.birthDate) },
    )

  public val DeathDate: SearchParam<Patient, Any> =
    SimpleSearchParam<Patient, Any>(
      name = "death-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Patient.deceased.ofType(dateTime))",
      extractor = { emptyList() },
    )

  public val Deceased: SearchParam<Patient, Any> =
    SimpleSearchParam<Patient, Any>(
      name = "deceased",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.deceased.exists() and Patient.deceased != false",
      extractor = { emptyList() },
    )

  public val Email: SearchParam<Patient, ContactPoint> =
    SimpleSearchParam<Patient, ContactPoint>(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val Family: SearchParam<Patient, String> =
    SimpleSearchParam<Patient, String>(
      name = "family",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.name.family",
      extractor = { resource -> resource.name.mapNotNull { it.family } },
    )

  public val Gender: SearchParam<Patient, Any> =
    SimpleSearchParam<Patient, Any>(
      name = "gender",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.gender",
      extractor = { resource -> listOfNotNull(resource.gender) },
    )

  public val GeneralPractitioner: SearchParam<Patient, Reference> =
    SimpleSearchParam<Patient, Reference>(
      name = "general-practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "Patient.generalPractitioner",
      target =
        listOf(
          dev.ohs.fhir.model.r5.Organization::class,
          PractitionerRole::class,
          Practitioner::class,
        ),
      extractor = { resource -> resource.generalPractitioner },
    )

  public val Given: SearchParam<Patient, String> =
    SimpleSearchParam<Patient, String>(
      name = "given",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.name.given",
      extractor = { resource -> resource.name.flatMap { it.given } },
    )

  public val Identifier: SearchParam<Patient, Identifier> =
    SimpleSearchParam<Patient, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Language: SearchParam<Patient, CodeableConcept> =
    SimpleSearchParam<Patient, CodeableConcept>(
      name = "language",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.communication.language",
      extractor = { resource -> resource.communication.map { it.language } },
    )

  public val Link: SearchParam<Patient, Reference> =
    SimpleSearchParam<Patient, Reference>(
      name = "link",
      type = SearchParamType.fromCode("reference"),
      expression = "Patient.link.other",
      target = listOf(RelatedPerson::class, Patient::class),
      extractor = { resource -> resource.link.map { it.other } },
    )

  public val Name: SearchParam<Patient, HumanName> =
    SimpleSearchParam<Patient, HumanName>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.name",
      extractor = { resource -> resource.name },
    )

  public val Organization: SearchParam<Patient, Reference> =
    SimpleSearchParam<Patient, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Patient.managingOrganization",
      target = listOf(dev.ohs.fhir.model.r5.Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val PartAgree: SearchParam<Patient, Any> =
    SimpleSearchParam<Patient, Any>(
      name = "part-agree",
      type = SearchParamType.fromCode("reference"),
      expression =
        "Patient.extension('http://example.org/fhir/StructureDefinition/participation-agreement').value",
      target = listOf(DocumentReference::class),
      extractor = { emptyList() },
    )

  public val Phone: SearchParam<Patient, ContactPoint> =
    SimpleSearchParam<Patient, ContactPoint>(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val Phonetic: SearchParam<Patient, HumanName> =
    SimpleSearchParam<Patient, HumanName>(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "Patient.name",
      extractor = { resource -> resource.name },
    )

  public val Telecom: SearchParam<Patient, ContactPoint> =
    SimpleSearchParam<Patient, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "Patient.telecom",
      extractor = { resource -> resource.telecom },
    )

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
}
