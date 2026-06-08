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
import dev.ohs.fhir.model.r4.Endpoint
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Organization] resource type. */
public object OrganizationSearchParams {
  public val active: SearchParam<Organization, Boolean> =
    SearchParam(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "Organization.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val address: SearchParam<Organization, Address> =
    SearchParam(
      name = "address",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.address",
      extractor = { resource -> resource.address },
    )

  public val addressCity: SearchParam<Organization, String> =
    SearchParam(
      name = "address-city",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.address.city",
      extractor = { resource -> resource.address.mapNotNull { it.city } },
    )

  public val addressCountry: SearchParam<Organization, String> =
    SearchParam(
      name = "address-country",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.address.country",
      extractor = { resource -> resource.address.mapNotNull { it.country } },
    )

  public val addressPostalcode: SearchParam<Organization, String> =
    SearchParam(
      name = "address-postalcode",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.address.postalCode",
      extractor = { resource -> resource.address.mapNotNull { it.postalCode } },
    )

  public val addressState: SearchParam<Organization, String> =
    SearchParam(
      name = "address-state",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.address.state",
      extractor = { resource -> resource.address.mapNotNull { it.state } },
    )

  public val addressUse: SearchParam<Organization, Any> =
    SearchParam(
      name = "address-use",
      type = SearchParamType.fromCode("token"),
      expression = "Organization.address.use",
      extractor = { resource -> resource.address.mapNotNull { it.use } },
    )

  public val endpoint: SearchParam<Organization, Reference> =
    SearchParam(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "Organization.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<Organization, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Organization.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Organization, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val partof: SearchParam<Organization, Reference> =
    SearchParam(
      name = "partof",
      type = SearchParamType.fromCode("reference"),
      expression = "Organization.partOf",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val phonetic: SearchParam<Organization, String> =
    SearchParam(
      name = "phonetic",
      type = SearchParamType.fromCode("string"),
      expression = "Organization.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val type: SearchParam<Organization, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Organization.type",
      extractor = { resource -> resource.type },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Organization, *>> = listOf()

  /**
   * Supported search parameters for the Organization resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Organization, *>> =
    listOf(
      active,
      address,
      addressCity,
      addressCountry,
      addressPostalcode,
      addressState,
      addressUse,
      endpoint,
      identifier,
      name,
      partof,
      phonetic,
      type,
    )
}
