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
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RelatedPerson] resource type. */
public object RelatedPersonSearchParams {
  public val active: SearchParam<RelatedPerson, Boolean> =
    SimpleSearchParam<RelatedPerson, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val address: SearchParam<RelatedPerson, Address> =
    SimpleSearchParam<RelatedPerson, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address",
      extractor = { resource -> resource.address },
    )

  public val addressCity: SearchParam<RelatedPerson, String> =
    SimpleSearchParam<RelatedPerson, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val addressCountry: SearchParam<RelatedPerson, String> =
    SimpleSearchParam<RelatedPerson, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val addressPostalcode: SearchParam<RelatedPerson, String> =
    SimpleSearchParam<RelatedPerson, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val addressState: SearchParam<RelatedPerson, String> =
    SimpleSearchParam<RelatedPerson, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val addressUse: SearchParam<RelatedPerson, Any> =
    SimpleSearchParam<RelatedPerson, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val birthdate: SearchParam<RelatedPerson, Date> =
    SimpleSearchParam<RelatedPerson, Date>(
      name = "birthdate",
      type = SearchParamType.fromCode("date"),
      expression = "RelatedPerson.birthDate",
      extractor = { resource -> listOfNotNull(resource.birthDate) },
    )

  public val email: SearchParam<RelatedPerson, ContactPoint> =
    SimpleSearchParam<RelatedPerson, ContactPoint>(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val gender: SearchParam<RelatedPerson, Any> =
    SimpleSearchParam<RelatedPerson, Any>(
      name = "gender",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.gender",
      extractor = { resource -> listOfNotNull(resource.gender) },
    )

  public val identifier: SearchParam<RelatedPerson, Identifier> =
    SimpleSearchParam<RelatedPerson, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<RelatedPerson, HumanName> =
    SimpleSearchParam<RelatedPerson, HumanName>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.name",
      extractor = { resource -> resource.name },
    )

  public val patient: SearchParam<RelatedPerson, Reference> =
    SimpleSearchParam<RelatedPerson, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "RelatedPerson.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val phone: SearchParam<RelatedPerson, ContactPoint> =
    SimpleSearchParam<RelatedPerson, ContactPoint>(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val phonetic: SearchParam<RelatedPerson, HumanName> =
    SimpleSearchParam<RelatedPerson, HumanName>(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "RelatedPerson.name",
      extractor = { resource -> resource.name },
    )

  public val relationship: SearchParam<RelatedPerson, CodeableConcept> =
    SimpleSearchParam<RelatedPerson, CodeableConcept>(
      name = "relationship",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.relationship",
      extractor = { resource -> resource.relationship },
    )

  public val telecom: SearchParam<RelatedPerson, ContactPoint> =
    SimpleSearchParam<RelatedPerson, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "RelatedPerson.telecom",
      extractor = { resource -> resource.telecom },
    )

  /** All search parameters for the RelatedPerson resource type. */
  public val all: List<SearchParam<RelatedPerson, *>> =
    listOf(
      active,
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
      name,
      patient,
      phone,
      phonetic,
      relationship,
      telecom,
    )
}
