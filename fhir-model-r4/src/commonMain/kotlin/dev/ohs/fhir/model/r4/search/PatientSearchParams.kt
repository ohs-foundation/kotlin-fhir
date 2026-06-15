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

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Patient] resource type. */
public object PatientSearchParams {
  public val active: SearchParam<Patient, Boolean> =
    SearchParam(
      name = "active",
      type = SearchParamType.Token,
      expression = "Patient.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val address: SearchParam<Patient, Address> =
    SearchParam(
      name = "address",
      type = SearchParamType.String,
      expression = "Patient.address",
      extractor = { resource -> resource.address },
    )

  public val addressCity: SearchParam<Patient, String> =
    SearchParam(
      name = "address-city",
      type = SearchParamType.String,
      expression = "Patient.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val addressCountry: SearchParam<Patient, String> =
    SearchParam(
      name = "address-country",
      type = SearchParamType.String,
      expression = "Patient.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val addressPostalcode: SearchParam<Patient, String> =
    SearchParam(
      name = "address-postalcode",
      type = SearchParamType.String,
      expression = "Patient.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val addressState: SearchParam<Patient, String> =
    SearchParam(
      name = "address-state",
      type = SearchParamType.String,
      expression = "Patient.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val addressUse: SearchParam<Patient, Any> =
    SearchParam(
      name = "address-use",
      type = SearchParamType.Token,
      expression = "Patient.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val age: SearchParam<Patient, Any> =
    SearchParam(
      name = "age",
      type = SearchParamType.Number,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'age' has expression '' which is not yet supported."
        )
      },
    )

  public val birthOrderBoolean: SearchParam<Patient, Any> =
    SearchParam(
      name = "birthOrderBoolean",
      type = SearchParamType.Token,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'birthOrderBoolean' has expression '' which is not yet supported."
        )
      },
    )

  public val birthdate: SearchParam<Patient, Date> =
    SearchParam(
      name = "birthdate",
      type = SearchParamType.Date,
      expression = "Patient.birthDate",
      extractor = { resource -> listOfNotNull(resource.birthDate) },
    )

  public val deathDate: SearchParam<Patient, DateTime> =
    SearchParam(
      name = "death-date",
      type = SearchParamType.Date,
      expression = "(Patient.deceased as dateTime)",
      extractor = { resource ->
        listOfNotNull((resource.deceased as? Patient.Deceased.DateTime)?.value)
      },
    )

  public val deceased: SearchParam<Patient, Any> =
    SearchParam(
      name = "deceased",
      type = SearchParamType.Token,
      expression = "Patient.deceased.exists() and Patient.deceased != false",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'deceased' has expression 'Patient.deceased.exists() and Patient.deceased != false' which is not yet supported."
        )
      },
    )

  public val email: SearchParam<Patient, ContactPoint> =
    SearchParam(
      name = "email",
      type = SearchParamType.Token,
      expression = "Patient.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val family: SearchParam<Patient, String> =
    SearchParam(
      name = "family",
      type = SearchParamType.String,
      expression = "Patient.name.family",
      extractor = { resource -> resource.name.mapNotNull { it.family } },
    )

  public val gender: SearchParam<Patient, Any> =
    SearchParam(
      name = "gender",
      type = SearchParamType.Token,
      expression = "Patient.gender",
      extractor = { resource -> listOfNotNull(resource.gender) },
    )

  public val generalPractitioner: SearchParam<Patient, Reference> =
    SearchParam(
      name = "general-practitioner",
      type = SearchParamType.Reference,
      expression = "Patient.generalPractitioner",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> resource.generalPractitioner },
    )

  public val given: SearchParam<Patient, String> =
    SearchParam(
      name = "given",
      type = SearchParamType.String,
      expression = "Patient.name.given",
      extractor = { resource -> resource.name.flatMap { it.given } },
    )

  public val identifier: SearchParam<Patient, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Patient.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val language: SearchParam<Patient, CodeableConcept> =
    SearchParam(
      name = "language",
      type = SearchParamType.Token,
      expression = "Patient.communication.language",
      extractor = { resource -> resource.communication.map { it.language } },
    )

  public val link: SearchParam<Patient, Reference> =
    SearchParam(
      name = "link",
      type = SearchParamType.Reference,
      expression = "Patient.link.other",
      target = listOf(Patient::class, RelatedPerson::class),
      extractor = { resource -> resource.link.map { it.other } },
    )

  public val mothersMaidenName: SearchParam<Patient, Any> =
    SearchParam(
      name = "mothersMaidenName",
      type = SearchParamType.String,
      expression =
        "Patient.extension('http://hl7.org/fhir/StructureDefinition/patient-extensions-Patient-mothersMaidenName')",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'mothersMaidenName' has expression 'Patient.extension('http://hl7.org/fhir/StructureDefinition/patient-extensions-Patient-mothersMaidenName')' which is not yet supported."
        )
      },
    )

  public val name: SearchParam<Patient, HumanName> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "Patient.name",
      extractor = { resource -> resource.name },
    )

  public val organization: SearchParam<Patient, Reference> =
    SearchParam(
      name = "organization",
      type = SearchParamType.Reference,
      expression = "Patient.managingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val phone: SearchParam<Patient, ContactPoint> =
    SearchParam(
      name = "phone",
      type = SearchParamType.Token,
      expression = "Patient.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val phonetic: SearchParam<Patient, HumanName> =
    SearchParam(
      name = "phonetic",
      type = SearchParamType.String,
      expression = "Patient.name",
      extractor = { resource -> resource.name },
    )

  public val telecom: SearchParam<Patient, ContactPoint> =
    SearchParam(
      name = "telecom",
      type = SearchParamType.Token,
      expression = "Patient.telecom",
      extractor = { resource -> resource.telecom },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Patient, *>> =
    listOf(age, birthOrderBoolean, deceased, mothersMaidenName)

  /**
   * Supported search parameters for the Patient resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Patient, *>> =
    listOf(
      active,
      address,
      addressCity,
      addressCountry,
      addressPostalcode,
      addressState,
      addressUse,
      birthdate,
      deathDate,
      email,
      family,
      gender,
      generalPractitioner,
      given,
      identifier,
      language,
      link,
      name,
      organization,
      phone,
      phonetic,
      telecom,
    )
}
