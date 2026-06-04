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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Organization] resource type. */
public object OrganizationSearchParams {
  public val Active: SearchParam<Organization, Boolean> =
    SimpleSearchParam<Organization, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "Organization.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val Address: SearchParam<Organization, Address> =
    SimpleSearchParam<Organization, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.contact.address",
      extractor = { resource -> resource.contact.mapNotNull { it.address } },
    )

  public val AddressCity: SearchParam<Organization, String> =
    SimpleSearchParam<Organization, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.contact.address.city",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.city } },
    )

  public val AddressCountry: SearchParam<Organization, String> =
    SimpleSearchParam<Organization, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.contact.address.country",
      extractor = { resource ->
        resource.contact.mapNotNull { it.address }.mapNotNull { it.country }
      },
    )

  public val AddressPostalcode: SearchParam<Organization, String> =
    SimpleSearchParam<Organization, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.contact.address.postalCode",
      extractor = { resource ->
        resource.contact.mapNotNull { it.address }.mapNotNull { it.postalCode }
      },
    )

  public val AddressState: SearchParam<Organization, String> =
    SimpleSearchParam<Organization, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.contact.address.state",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.state } },
    )

  public val AddressUse: SearchParam<Organization, Any> =
    SimpleSearchParam<Organization, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "Organization.contact.address.use",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.use } },
    )

  public val Endpoint: SearchParam<Organization, Reference> =
    SimpleSearchParam<Organization, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "Organization.endpoint",
      target = listOf(dev.ohs.fhir.model.r5.Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val Identifier: SearchParam<Organization, Identifier> =
    SimpleSearchParam<Organization, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Organization.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<Organization, String> =
    SimpleSearchParam<Organization, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Partof: SearchParam<Organization, Reference> =
    SimpleSearchParam<Organization, Reference>(
      name = "partof",
      type = SearchParamType.fromCode("reference"),
      expression = "Organization.partOf",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val Phonetic: SearchParam<Organization, String> =
    SimpleSearchParam<Organization, String>(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Type: SearchParam<Organization, CodeableConcept> =
    SimpleSearchParam<Organization, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Organization.type",
      extractor = { resource -> resource.type },
    )

  /** All search parameters for the Organization resource type. */
  public val ALL: List<SearchParam<Organization, *>> =
    listOf(
      Active,
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      Endpoint,
      Identifier,
      Name,
      Partof,
      Phonetic,
      Type,
    )
}
