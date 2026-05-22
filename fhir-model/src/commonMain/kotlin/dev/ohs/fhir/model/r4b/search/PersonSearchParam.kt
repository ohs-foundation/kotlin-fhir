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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Person
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Person] resource type. */
public object PersonSearchParam {
  public val Address: SearchParam<Person, Address> =
    SimpleSearchParam<Person, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address",
      extractor = { resource -> resource.address },
    )

  public val AddressCity: SearchParam<Person, String> =
    SimpleSearchParam<Person, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val AddressCountry: SearchParam<Person, String> =
    SimpleSearchParam<Person, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val AddressPostalcode: SearchParam<Person, String> =
    SimpleSearchParam<Person, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val AddressState: SearchParam<Person, String> =
    SimpleSearchParam<Person, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "Person.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val AddressUse: SearchParam<Person, Any> =
    SimpleSearchParam<Person, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "Person.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val Birthdate: SearchParam<Person, Date> =
    SimpleSearchParam<Person, Date>(
      name = "birthdate",
      type = SearchParamType.fromCode("date"),
      expression = "Person.birthDate",
      extractor = { resource -> listOfNotNull(resource.birthDate) },
    )

  public val Email: SearchParam<Person, ContactPoint> =
    SimpleSearchParam<Person, ContactPoint>(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "Person.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val Gender: SearchParam<Person, Any> =
    SimpleSearchParam<Person, Any>(
      name = "gender",
      type = SearchParamType.fromCode("token"),
      expression = "Person.gender",
      extractor = { resource -> listOfNotNull(resource.gender) },
    )

  public val Identifier: SearchParam<Person, Identifier> =
    SimpleSearchParam<Person, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Person.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Link: SearchParam<Person, Reference> =
    SimpleSearchParam<Person, Reference>(
      name = "link",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.link.target",
      target =
        listOf(
          dev.ohs.fhir.model.r4b.Practitioner::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          Person::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.link.map { it.target } },
    )

  public val Name: SearchParam<Person, HumanName> =
    SimpleSearchParam<Person, HumanName>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Person.name",
      extractor = { resource -> resource.name },
    )

  public val Organization: SearchParam<Person, Reference> =
    SimpleSearchParam<Person, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.managingOrganization",
      target = listOf(dev.ohs.fhir.model.r4b.Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val Patient: SearchParam<Person, Reference> =
    SimpleSearchParam<Person, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.link.target.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        resource.link
          .map { it.target }
          .filter { it.reference?.value?.toString()?.contains("Patient/") == true }
      },
    )

  public val Phone: SearchParam<Person, ContactPoint> =
    SimpleSearchParam<Person, ContactPoint>(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "Person.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val Phonetic: SearchParam<Person, HumanName> =
    SimpleSearchParam<Person, HumanName>(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "Person.name",
      extractor = { resource -> resource.name },
    )

  public val Practitioner: SearchParam<Person, Reference> =
    SimpleSearchParam<Person, Reference>(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "Person.link.target.where(resolve() is Practitioner)",
      target = listOf(dev.ohs.fhir.model.r4b.Practitioner::class),
      extractor = { resource ->
        resource.link
          .map { it.target }
          .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
      },
    )

  public val Relatedperson: SearchParam<Person, Reference> =
    SimpleSearchParam<Person, Reference>(
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

  public val Telecom: SearchParam<Person, ContactPoint> =
    SimpleSearchParam<Person, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "Person.telecom",
      extractor = { resource -> resource.telecom },
    )

  /** All search parameters for the Person resource type. */
  public val ALL: List<SearchParam<Person, *>> =
    listOf(
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      Birthdate,
      Email,
      Gender,
      Identifier,
      Link,
      Name,
      Organization,
      Patient,
      Phone,
      Phonetic,
      Practitioner,
      Relatedperson,
      Telecom,
    )
}
