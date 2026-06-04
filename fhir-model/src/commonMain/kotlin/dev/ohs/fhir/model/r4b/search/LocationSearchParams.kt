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
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Location] resource type. */
public object LocationSearchParams {
  public val Address: SearchParam<Location, Address> =
    SimpleSearchParam<Location, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address",
      extractor = { resource -> listOfNotNull(resource.address) },
    )

  public val AddressCity: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address.city",
      extractor = { resource -> listOfNotNull(resource.address?.city) },
    )

  public val AddressCountry: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address.country",
      extractor = { resource -> listOfNotNull(resource.address?.country) },
    )

  public val AddressPostalcode: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address.postalCode",
      extractor = { resource -> listOfNotNull(resource.address?.postalCode) },
    )

  public val AddressState: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address.state",
      extractor = { resource -> listOfNotNull(resource.address?.state) },
    )

  public val AddressUse: SearchParam<Location, Any> =
    SimpleSearchParam<Location, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "Location.address.use",
      extractor = { resource -> listOfNotNull(resource.address?.use) },
    )

  public val Endpoint: SearchParam<Location, Reference> =
    SimpleSearchParam<Location, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "Location.endpoint",
      target = listOf(dev.ohs.fhir.model.r4b.Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val Identifier: SearchParam<Location, Identifier> =
    SimpleSearchParam<Location, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Location.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Location.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Near: SearchParam<Location, Location.Position> =
    SimpleSearchParam<Location, Location.Position>(
      name = "near",
      type = SearchParamType.fromCode("special"),
      expression = "Location.position",
      extractor = { resource -> listOfNotNull(resource.position) },
    )

  public val OperationalStatus: SearchParam<Location, Coding> =
    SimpleSearchParam<Location, Coding>(
      name = "operational-status",
      type = SearchParamType.fromCode("token"),
      expression = "Location.operationalStatus",
      extractor = { resource -> listOfNotNull(resource.operationalStatus) },
    )

  public val Organization: SearchParam<Location, Reference> =
    SimpleSearchParam<Location, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Location.managingOrganization",
      target = listOf(dev.ohs.fhir.model.r4b.Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val Partof: SearchParam<Location, Reference> =
    SimpleSearchParam<Location, Reference>(
      name = "partof",
      type = SearchParamType.fromCode("reference"),
      expression = "Location.partOf",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val Status: SearchParam<Location, Any> =
    SimpleSearchParam<Location, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Location.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Type: SearchParam<Location, CodeableConcept> =
    SimpleSearchParam<Location, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Location.type",
      extractor = { resource -> resource.type },
    )

  /** All search parameters for the Location resource type. */
  public val ALL: List<SearchParam<Location, *>> =
    listOf(
      Address,
      AddressCity,
      AddressCountry,
      AddressPostalcode,
      AddressState,
      AddressUse,
      Endpoint,
      Identifier,
      Name,
      Near,
      OperationalStatus,
      Organization,
      Partof,
      Status,
      Type,
    )
}
