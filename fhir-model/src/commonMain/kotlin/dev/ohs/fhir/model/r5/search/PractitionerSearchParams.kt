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
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Practitioner] resource type. */
public object PractitionerSearchParams {
  public val active: SearchParam<Practitioner, Boolean> =
    SimpleSearchParam<Practitioner, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val address: SearchParam<Practitioner, Address> =
    SimpleSearchParam<Practitioner, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.address",
      extractor = { resource -> resource.address },
    )

  public val addressCity: SearchParam<Practitioner, String> =
    SimpleSearchParam<Practitioner, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val addressCountry: SearchParam<Practitioner, String> =
    SimpleSearchParam<Practitioner, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val addressPostalcode: SearchParam<Practitioner, String> =
    SimpleSearchParam<Practitioner, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val addressState: SearchParam<Practitioner, String> =
    SimpleSearchParam<Practitioner, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val addressUse: SearchParam<Practitioner, Any> =
    SimpleSearchParam<Practitioner, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val communication: SearchParam<Practitioner, CodeableConcept> =
    SimpleSearchParam<Practitioner, CodeableConcept>(
      name = "communication",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.communication.language",
      extractor = { resource -> resource.communication.map { it.language } },
    )

  public val deathDate: SearchParam<Practitioner, Any> =
    SimpleSearchParam<Practitioner, Any>(
      name = "death-date",
      type = SearchParamType.fromCode("date"),
      expression = "(Practitioner.deceased.ofType(dateTime))",
      extractor = { emptyList() },
    )

  public val deceased: SearchParam<Practitioner, Any> =
    SimpleSearchParam<Practitioner, Any>(
      name = "deceased",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.deceased.exists() and Practitioner.deceased != false",
      extractor = { emptyList() },
    )

  public val email: SearchParam<Practitioner, ContactPoint> =
    SimpleSearchParam<Practitioner, ContactPoint>(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val family: SearchParam<Practitioner, String> =
    SimpleSearchParam<Practitioner, String>(
      name = "family",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.name.family",
      extractor = { resource -> resource.name.mapNotNull { it.family } },
    )

  public val gender: SearchParam<Practitioner, Any> =
    SimpleSearchParam<Practitioner, Any>(
      name = "gender",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.gender",
      extractor = { resource -> listOfNotNull(resource.gender) },
    )

  public val given: SearchParam<Practitioner, String> =
    SimpleSearchParam<Practitioner, String>(
      name = "given",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.name.given",
      extractor = { resource -> resource.name.flatMap { it.given } },
    )

  public val identifier: SearchParam<Practitioner, Identifier> =
    SimpleSearchParam<Practitioner, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Practitioner, HumanName> =
    SimpleSearchParam<Practitioner, HumanName>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.name",
      extractor = { resource -> resource.name },
    )

  public val phone: SearchParam<Practitioner, ContactPoint> =
    SimpleSearchParam<Practitioner, ContactPoint>(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val phonetic: SearchParam<Practitioner, HumanName> =
    SimpleSearchParam<Practitioner, HumanName>(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "Practitioner.name",
      extractor = { resource -> resource.name },
    )

  public val qualificationPeriod: SearchParam<Practitioner, Period> =
    SimpleSearchParam<Practitioner, Period>(
      name = "qualification-period",
      type = SearchParamType.fromCode("date"),
      expression = "Practitioner.qualification.period",
      extractor = { resource -> resource.qualification.mapNotNull { it.period } },
    )

  public val telecom: SearchParam<Practitioner, ContactPoint> =
    SimpleSearchParam<Practitioner, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "Practitioner.telecom",
      extractor = { resource -> resource.telecom },
    )

  /** All search parameters for the Practitioner resource type. */
  public val all: List<SearchParam<Practitioner, *>> =
    listOf(
      active,
      address,
      addressCity,
      addressCountry,
      addressPostalcode,
      addressState,
      addressUse,
      communication,
      deathDate,
      deceased,
      email,
      family,
      gender,
      given,
      identifier,
      name,
      phone,
      phonetic,
      qualificationPeriod,
      telecom,
    )
}
