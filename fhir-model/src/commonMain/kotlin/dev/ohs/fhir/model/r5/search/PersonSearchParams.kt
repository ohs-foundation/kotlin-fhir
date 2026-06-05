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
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Person
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Person] resource type. */
public object PersonSearchParams {
  public val address: SearchParam<Person, Address> =
    SearchParam(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address",
      extractor = { resource -> resource.address },
    )

  public val addressCity: SearchParam<Person, String> =
    SearchParam(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val addressCountry: SearchParam<Person, String> =
    SearchParam(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val addressPostalcode: SearchParam<Person, String> =
    SearchParam(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val addressState: SearchParam<Person, String> =
    SearchParam(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val addressUse: SearchParam<Person, Any> =
    SearchParam(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "Person.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val birthdate: SearchParam<Person, Date> =
    SearchParam(
      name = "birthdate",
      type = SearchParamType.fromCode("date"),
      expression = "Person.birthDate",
      extractor = { resource -> listOfNotNull(resource.birthDate) },
    )

  public val deathDate: SearchParam<Person, Any> =
    SearchParam(
      name = "death-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Person.deceased.ofType(dateTime))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'death-date' has expression '(Person.deceased.ofType(dateTime))' which is not yet supported."
        )
      },
    )

  public val deceased: SearchParam<Person, Any> =
    SearchParam(
      name = "deceased",
      type = SearchParamType.fromCode("token"),
      expression = "Person.deceased.exists() and Person.deceased != false",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'deceased' has expression 'Person.deceased.exists() and Person.deceased != false' which is not yet supported."
        )
      },
    )

  public val email: SearchParam<Person, ContactPoint> =
    SearchParam(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "Person.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val family: SearchParam<Person, String> =
    SearchParam(
      name = "family",
      type = SearchParamType.fromCode("string"),
      expression = "Person.name.family",
      extractor = { resource -> resource.name.mapNotNull { it.family } },
    )

  public val gender: SearchParam<Person, Any> =
    SearchParam(
      name = "gender",
      type = SearchParamType.fromCode("token"),
      expression = "Person.gender",
      extractor = { resource -> listOfNotNull(resource.gender) },
    )

  public val given: SearchParam<Person, String> =
    SearchParam(
      name = "given",
      type = SearchParamType.fromCode("string"),
      expression = "Person.name.given",
      extractor = { resource -> resource.name.flatMap { it.given } },
    )

  public val identifier: SearchParam<Person, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Person.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val link: SearchParam<Person, Reference> =
    SearchParam(
      name = "link",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.link.target",
      target = listOf(RelatedPerson::class, Practitioner::class, Person::class, Patient::class),
      extractor = { resource -> resource.link.map { it.target } },
    )

  public val name: SearchParam<Person, HumanName> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Person.name",
      extractor = { resource -> resource.name },
    )

  public val organization: SearchParam<Person, Reference> =
    SearchParam(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.managingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val patient: SearchParam<Person, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.link.target.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        resource.link
          .map { it.target }
          .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
      },
    )

  public val phone: SearchParam<Person, ContactPoint> =
    SearchParam(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "Person.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val phonetic: SearchParam<Person, HumanName> =
    SearchParam(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "Person.name",
      extractor = { resource -> resource.name },
    )

  public val practitioner: SearchParam<Person, Reference> =
    SearchParam(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.link.target.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        resource.link
          .map { it.target }
          .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
      },
    )

  public val relatedperson: SearchParam<Person, Reference> =
    SearchParam(
      name = "relatedperson",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.link.target.where(resolve() is RelatedPerson)",
      target = listOf(RelatedPerson::class),
      extractor = { resource ->
        resource.link
          .map { it.target }
          .filter { it.reference?.value?.toString()?.contains("RelatedPerson/") == true }
      },
    )

  public val telecom: SearchParam<Person, ContactPoint> =
    SearchParam(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "Person.telecom",
      extractor = { resource -> resource.telecom },
    )

  /** All search parameters for the Person resource type. */
  public val all: List<SearchParam<Person, *>> =
    listOf(
      address,
      addressCity,
      addressCountry,
      addressPostalcode,
      addressState,
      addressUse,
      birthdate,
      deathDate,
      deceased,
      email,
      family,
      gender,
      given,
      identifier,
      link,
      name,
      organization,
      patient,
      phone,
      phonetic,
      practitioner,
      relatedperson,
      telecom,
    )
}
