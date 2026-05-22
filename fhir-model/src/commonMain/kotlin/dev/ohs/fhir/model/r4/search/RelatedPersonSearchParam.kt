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
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RelatedPerson] resource type. */
public object RelatedPersonSearchParam {
  public val Active: SearchParam<RelatedPerson, Boolean> =
    SimpleSearchParam<RelatedPerson, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val Address: SearchParam<RelatedPerson, Address> =
    SimpleSearchParam<RelatedPerson, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address",
      extractor = { resource -> resource.address },
    )

  public val AddressCity: SearchParam<RelatedPerson, String> =
    SimpleSearchParam<RelatedPerson, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val AddressCountry: SearchParam<RelatedPerson, String> =
    SimpleSearchParam<RelatedPerson, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val AddressPostalcode: SearchParam<RelatedPerson, String> =
    SimpleSearchParam<RelatedPerson, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val AddressState: SearchParam<RelatedPerson, String> =
    SimpleSearchParam<RelatedPerson, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val AddressUse: SearchParam<RelatedPerson, Any> =
    SimpleSearchParam<RelatedPerson, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val Birthdate: SearchParam<RelatedPerson, Date> =
    SimpleSearchParam<RelatedPerson, Date>(
      name = "birthdate",
      type = SearchParamType.fromCode("date"),
      expression = "RelatedPerson.birthDate",
      extractor = { resource -> listOfNotNull(resource.birthDate) },
    )

  public val Email: SearchParam<RelatedPerson, ContactPoint> =
    SimpleSearchParam<RelatedPerson, ContactPoint>(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val Gender: SearchParam<RelatedPerson, Any> =
    SimpleSearchParam<RelatedPerson, Any>(
      name = "gender",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.gender",
      extractor = { resource -> listOfNotNull(resource.gender) },
    )

  public val Identifier: SearchParam<RelatedPerson, Identifier> =
    SimpleSearchParam<RelatedPerson, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<RelatedPerson, HumanName> =
    SimpleSearchParam<RelatedPerson, HumanName>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.name",
      extractor = { resource -> resource.name },
    )

  public val Patient: SearchParam<RelatedPerson, Reference> =
    SimpleSearchParam<RelatedPerson, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "RelatedPerson.patient",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Phone: SearchParam<RelatedPerson, ContactPoint> =
    SimpleSearchParam<RelatedPerson, ContactPoint>(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val Phonetic: SearchParam<RelatedPerson, HumanName> =
    SimpleSearchParam<RelatedPerson, HumanName>(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.name",
      extractor = { resource -> resource.name },
    )

  public val Relationship: SearchParam<RelatedPerson, CodeableConcept> =
    SimpleSearchParam<RelatedPerson, CodeableConcept>(
      name = "relationship",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.relationship",
      extractor = { resource -> resource.relationship },
    )

  public val Telecom: SearchParam<RelatedPerson, ContactPoint> =
    SimpleSearchParam<RelatedPerson, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.telecom",
      extractor = { resource -> resource.telecom },
    )

  /** All search parameters for the RelatedPerson resource type. */
  public val ALL: List<SearchParam<RelatedPerson, *>> =
    listOf(
      Active,
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
      Name,
      Patient,
      Phone,
      Phonetic,
      Relationship,
      Telecom,
    )
}
