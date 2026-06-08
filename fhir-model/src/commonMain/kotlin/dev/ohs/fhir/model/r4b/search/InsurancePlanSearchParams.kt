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
import dev.ohs.fhir.model.r4b.Endpoint
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.InsurancePlan
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [InsurancePlan] resource type. */
public object InsurancePlanSearchParams {
  public val address: SearchParam<InsurancePlan, Address> =
    SearchParam(
      name = "address",
      type = SearchParamType.String,
      expression = "InsurancePlan.contact.address",
      extractor = { resource -> resource.contact.mapNotNull { it.address } },
    )

  public val addressCity: SearchParam<InsurancePlan, String> =
    SearchParam(
      name = "address-city",
      type = SearchParamType.String,
      expression = "InsurancePlan.contact.address.city",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.city } },
    )

  public val addressCountry: SearchParam<InsurancePlan, String> =
    SearchParam(
      name = "address-country",
      type = SearchParamType.String,
      expression = "InsurancePlan.contact.address.country",
      extractor = { resource ->
        resource.contact.mapNotNull { it.address }.mapNotNull { it.country }
      },
    )

  public val addressPostalcode: SearchParam<InsurancePlan, String> =
    SearchParam(
      name = "address-postalcode",
      type = SearchParamType.String,
      expression = "InsurancePlan.contact.address.postalCode",
      extractor = { resource ->
        resource.contact.mapNotNull { it.address }.mapNotNull { it.postalCode }
      },
    )

  public val addressState: SearchParam<InsurancePlan, String> =
    SearchParam(
      name = "address-state",
      type = SearchParamType.String,
      expression = "InsurancePlan.contact.address.state",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.state } },
    )

  public val addressUse: SearchParam<InsurancePlan, Any> =
    SearchParam(
      name = "address-use",
      type = SearchParamType.Token,
      expression = "InsurancePlan.contact.address.use",
      extractor = { resource -> resource.contact.mapNotNull { it.address }.mapNotNull { it.use } },
    )

  public val administeredBy: SearchParam<InsurancePlan, Reference> =
    SearchParam(
      name = "administered-by",
      type = SearchParamType.Reference,
      expression = "InsurancePlan.administeredBy",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.administeredBy) },
    )

  public val endpoint: SearchParam<InsurancePlan, Reference> =
    SearchParam(
      name = "endpoint",
      type = SearchParamType.Reference,
      expression = "InsurancePlan.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<InsurancePlan, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "InsurancePlan.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<InsurancePlan, Any> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "name | alias",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'name' has expression 'name | alias' which is not yet supported."
        )
      },
    )

  public val ownedBy: SearchParam<InsurancePlan, Reference> =
    SearchParam(
      name = "owned-by",
      type = SearchParamType.Reference,
      expression = "InsurancePlan.ownedBy",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.ownedBy) },
    )

  public val phonetic: SearchParam<InsurancePlan, String> =
    SearchParam(
      name = "phonetic",
      type = SearchParamType.String,
      expression = "InsurancePlan.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val status: SearchParam<InsurancePlan, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "InsurancePlan.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val type: SearchParam<InsurancePlan, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "InsurancePlan.type",
      extractor = { resource -> resource.type },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<InsurancePlan, *>> = listOf(name)

  /**
   * Supported search parameters for the InsurancePlan resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<InsurancePlan, *>> =
    listOf(
      address,
      addressCity,
      addressCountry,
      addressPostalcode,
      addressState,
      addressUse,
      administeredBy,
      endpoint,
      identifier,
      ownedBy,
      phonetic,
      status,
      type,
    )
}
