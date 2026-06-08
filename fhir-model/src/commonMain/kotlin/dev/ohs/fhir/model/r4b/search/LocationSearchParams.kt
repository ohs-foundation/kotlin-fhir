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
import dev.ohs.fhir.model.r4b.Endpoint
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Location] resource type. */
public object LocationSearchParams {
  public val address: SearchParam<Location, Address> =
    SearchParam(
      name = "address",
      type = SearchParamType.String,
      expression = "Location.address",
      extractor = { resource -> listOfNotNull(resource.address) },
    )

  public val addressCity: SearchParam<Location, String> =
    SearchParam(
      name = "address-city",
      type = SearchParamType.String,
      expression = "Location.address.city",
      extractor = { resource -> listOfNotNull(resource.address?.city) },
    )

  public val addressCountry: SearchParam<Location, String> =
    SearchParam(
      name = "address-country",
      type = SearchParamType.String,
      expression = "Location.address.country",
      extractor = { resource -> listOfNotNull(resource.address?.country) },
    )

  public val addressPostalcode: SearchParam<Location, String> =
    SearchParam(
      name = "address-postalcode",
      type = SearchParamType.String,
      expression = "Location.address.postalCode",
      extractor = { resource -> listOfNotNull(resource.address?.postalCode) },
    )

  public val addressState: SearchParam<Location, String> =
    SearchParam(
      name = "address-state",
      type = SearchParamType.String,
      expression = "Location.address.state",
      extractor = { resource -> listOfNotNull(resource.address?.state) },
    )

  public val addressUse: SearchParam<Location, Any> =
    SearchParam(
      name = "address-use",
      type = SearchParamType.Token,
      expression = "Location.address.use",
      extractor = { resource -> listOfNotNull(resource.address?.use) },
    )

  public val endpoint: SearchParam<Location, Reference> =
    SearchParam(
      name = "endpoint",
      type = SearchParamType.Reference,
      expression = "Location.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<Location, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Location.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Location, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "Location.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val near: SearchParam<Location, Location.Position> =
    SearchParam(
      name = "near",
      type = SearchParamType.Special,
      expression = "Location.position",
      extractor = { resource -> listOfNotNull(resource.position) },
    )

  public val operationalStatus: SearchParam<Location, Coding> =
    SearchParam(
      name = "operational-status",
      type = SearchParamType.Token,
      expression = "Location.operationalStatus",
      extractor = { resource -> listOfNotNull(resource.operationalStatus) },
    )

  public val organization: SearchParam<Location, Reference> =
    SearchParam(
      name = "organization",
      type = SearchParamType.Reference,
      expression = "Location.managingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val partof: SearchParam<Location, Reference> =
    SearchParam(
      name = "partof",
      type = SearchParamType.Reference,
      expression = "Location.partOf",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val status: SearchParam<Location, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Location.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val type: SearchParam<Location, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "Location.type",
      extractor = { resource -> resource.type },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Location, *>> = listOf()

  /**
   * Supported search parameters for the Location resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
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
