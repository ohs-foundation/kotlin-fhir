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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Person
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Person] resource type. */
public object PersonSearchParams {
  public val address: SearchParam<Person, Address> =
    SearchParam(
      name = "address",
      type = SearchParamType.String,
      expression = "Person.address",
      extractor = { resource -> resource.address },
    )

  public val addressCity: SearchParam<Person, String> =
    SearchParam(
      name = "address-city",
      type = SearchParamType.String,
      expression = "Person.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val addressCountry: SearchParam<Person, String> =
    SearchParam(
      name = "address-country",
      type = SearchParamType.String,
      expression = "Person.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val addressPostalcode: SearchParam<Person, String> =
    SearchParam(
      name = "address-postalcode",
      type = SearchParamType.String,
      expression = "Person.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val addressState: SearchParam<Person, String> =
    SearchParam(
      name = "address-state",
      type = SearchParamType.String,
      expression = "Person.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val addressUse: SearchParam<Person, Any> =
    SearchParam(
      name = "address-use",
      type = SearchParamType.Token,
      expression = "Person.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val birthdate: SearchParam<Person, Date> =
    SearchParam(
      name = "birthdate",
      type = SearchParamType.Date,
      expression = "Person.birthDate",
      extractor = { resource -> listOfNotNull(resource.birthDate) },
    )

  public val email: SearchParam<Person, ContactPoint> =
    SearchParam(
      name = "email",
      type = SearchParamType.Token,
      expression = "Person.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val gender: SearchParam<Person, Any> =
    SearchParam(
      name = "gender",
      type = SearchParamType.Token,
      expression = "Person.gender",
      extractor = { resource -> listOfNotNull(resource.gender) },
    )

  public val identifier: SearchParam<Person, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Person.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val link: SearchParam<Person, Reference> =
    SearchParam(
      name = "link",
      type = SearchParamType.Reference,
      expression = "Person.link.target",
      target = listOf(Practitioner::class, Patient::class, Person::class, RelatedPerson::class),
      extractor = { resource -> resource.link.map { it.target } },
    )

  public val name: SearchParam<Person, HumanName> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "Person.name",
      extractor = { resource -> resource.name },
    )

  public val organization: SearchParam<Person, Reference> =
    SearchParam(
      name = "organization",
      type = SearchParamType.Reference,
      expression = "Person.managingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val patient: SearchParam<Person, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Person.link.target.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        resource.link.map { it.target }.filter { it.reference?.value?.contains("Patient/") == true }
      },
    )

  public val phone: SearchParam<Person, ContactPoint> =
    SearchParam(
      name = "phone",
      type = SearchParamType.Token,
      expression = "Person.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val phonetic: SearchParam<Person, HumanName> =
    SearchParam(
      name = "phonetic",
      type = SearchParamType.String,
      expression = "Person.name",
      extractor = { resource -> resource.name },
    )

  public val practitioner: SearchParam<Person, Reference> =
    SearchParam(
      name = "practitioner",
      type = SearchParamType.Reference,
      expression = "Person.link.target.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        resource.link
          .map { it.target }
          .filter { it.reference?.value?.contains("Practitioner/") == true }
      },
    )

  public val relatedperson: SearchParam<Person, Reference> =
    SearchParam(
      name = "relatedperson",
      type = SearchParamType.Reference,
      expression = "Person.link.target.where(resolve() is RelatedPerson)",
      target = listOf(RelatedPerson::class),
      extractor = { resource ->
        resource.link
          .map { it.target }
          .filter { it.reference?.value?.contains("RelatedPerson/") == true }
      },
    )

  public val telecom: SearchParam<Person, ContactPoint> =
    SearchParam(
      name = "telecom",
      type = SearchParamType.Token,
      expression = "Person.telecom",
      extractor = { resource -> resource.telecom },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Person, *>> = listOf()

  /**
   * Supported search parameters for the Person resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Person, *>> =
    listOf(
      address,
      addressCity,
      addressCountry,
      addressPostalcode,
      addressState,
      addressUse,
      birthdate,
      email,
      gender,
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
