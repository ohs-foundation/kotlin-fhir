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
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.InsurancePlan
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [InsurancePlan] resource type. */
public object InsurancePlanSearchParams {
  public val Address: SearchParam<InsurancePlan, Address> =
    SimpleSearchParam<InsurancePlan, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "InsurancePlan.contact.address",
      extractor = { resource -> resource.contact.mapNotNull { it.address } },
    )

  public val AddressCity: SearchParam<InsurancePlan, String> =
    SimpleSearchParam<InsurancePlan, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "InsurancePlan.contact.address.city",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.city } },
    )

  public val AddressCountry: SearchParam<InsurancePlan, String> =
    SimpleSearchParam<InsurancePlan, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "InsurancePlan.contact.address.country",
      extractor = { resource ->
        resource.contact.mapNotNull { it.address }.mapNotNull { it.country }
      },
    )

  public val AddressPostalcode: SearchParam<InsurancePlan, String> =
    SimpleSearchParam<InsurancePlan, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "InsurancePlan.contact.address.postalCode",
      extractor = { resource ->
        resource.contact.mapNotNull { it.address }.mapNotNull { it.postalCode }
      },
    )

  public val AddressState: SearchParam<InsurancePlan, String> =
    SimpleSearchParam<InsurancePlan, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "InsurancePlan.contact.address.state",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.state } },
    )

  public val AddressUse: SearchParam<InsurancePlan, Any> =
    SimpleSearchParam<InsurancePlan, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "InsurancePlan.contact.address.use",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.use } },
    )

  public val AdministeredBy: SearchParam<InsurancePlan, Reference> =
    SimpleSearchParam<InsurancePlan, Reference>(
      name = "administered-by",
      type = SearchParamType.fromCode("reference"),
      expression = "InsurancePlan.administeredBy",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.administeredBy) },
    )

  public val Endpoint: SearchParam<InsurancePlan, Reference> =
    SimpleSearchParam<InsurancePlan, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "InsurancePlan.endpoint",
      target = listOf(dev.ohs.fhir.model.r4.Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val Identifier: SearchParam<InsurancePlan, Identifier> =
    SimpleSearchParam<InsurancePlan, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "InsurancePlan.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<InsurancePlan, Any> =
    SimpleSearchParam<InsurancePlan, Any>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "name | alias",
      extractor = { emptyList() },
    )

  public val OwnedBy: SearchParam<InsurancePlan, Reference> =
    SimpleSearchParam<InsurancePlan, Reference>(
      name = "owned-by",
      type = SearchParamType.fromCode("reference"),
      expression = "InsurancePlan.ownedBy",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.ownedBy) },
    )

  public val Phonetic: SearchParam<InsurancePlan, String> =
    SimpleSearchParam<InsurancePlan, String>(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "InsurancePlan.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Status: SearchParam<InsurancePlan, Any> =
    SimpleSearchParam<InsurancePlan, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "InsurancePlan.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Type: SearchParam<InsurancePlan, CodeableConcept> =
    SimpleSearchParam<InsurancePlan, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "InsurancePlan.type",
      extractor = { resource -> resource.type },
    )

  /** All search parameters for the InsurancePlan resource type. */
  public val ALL: List<SearchParam<InsurancePlan, *>> =
    listOf(
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      AdministeredBy,
      Endpoint,
      Identifier,
      Name,
      OwnedBy,
      Phonetic,
      Status,
      Type,
    )
}
