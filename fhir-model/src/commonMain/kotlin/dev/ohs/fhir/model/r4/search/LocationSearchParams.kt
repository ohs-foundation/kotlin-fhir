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
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Endpoint
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Location] resource type. */
public object LocationSearchParams {
  public val address: SearchParam<Location, Address> =
    SimpleSearchParam<Location, Address>(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address",
      extractor = { resource -> listOfNotNull(resource.address) },
    )

  public val addressCity: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address.city",
      extractor = { resource -> listOfNotNull(resource.address?.city) },
    )

  public val addressCountry: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address.country",
      extractor = { resource -> listOfNotNull(resource.address?.country) },
    )

  public val addressPostalcode: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address.postalCode",
      extractor = { resource -> listOfNotNull(resource.address?.postalCode) },
    )

  public val addressState: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "Location.address.state",
      extractor = { resource -> listOfNotNull(resource.address?.state) },
    )

  public val addressUse: SearchParam<Location, Any> =
    SimpleSearchParam<Location, Any>(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "Location.address.use",
      extractor = { resource -> listOfNotNull(resource.address?.use) },
    )

  public val endpoint: SearchParam<Location, Reference> =
    SimpleSearchParam<Location, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "Location.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<Location, Identifier> =
    SimpleSearchParam<Location, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Location.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Location, String> =
    SimpleSearchParam<Location, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Location.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val near: SearchParam<Location, Location.Position> =
    SimpleSearchParam<Location, Location.Position>(
      name = "near",
      type = SearchParamType.fromCode("special"),
      expression = "Location.position",
      extractor = { resource -> listOfNotNull(resource.position) },
    )

  public val operationalStatus: SearchParam<Location, Coding> =
    SimpleSearchParam<Location, Coding>(
      name = "operational-status",
      type = SearchParamType.fromCode("token"),
      expression = "Location.operationalStatus",
      extractor = { resource -> listOfNotNull(resource.operationalStatus) },
    )

  public val organization: SearchParam<Location, Reference> =
    SimpleSearchParam<Location, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Location.managingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val partof: SearchParam<Location, Reference> =
    SimpleSearchParam<Location, Reference>(
      name = "partof",
      type = SearchParamType.fromCode("reference"),
      expression = "Location.partOf",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val status: SearchParam<Location, Any> =
    SimpleSearchParam<Location, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Location.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val type: SearchParam<Location, CodeableConcept> =
    SimpleSearchParam<Location, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Location.type",
      extractor = { resource -> resource.type },
    )

  /** All search parameters for the Location resource type. */
  public val all: List<SearchParam<Location, *>> =
    listOf(
      address,
      addressCity,
      addressCountry,
      addressPostalcode,
      addressState,
      addressUse,
      endpoint,
      identifier,
      name,
      near,
      operationalStatus,
      organization,
      partof,
      status,
      type,
    )
}
