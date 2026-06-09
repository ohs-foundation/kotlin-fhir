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

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Endpoint
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.OrganizationAffiliation
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [OrganizationAffiliation] resource type. */
public object OrganizationAffiliationSearchParams {
  public val active: SearchParam<OrganizationAffiliation, Boolean> =
    SearchParam(
      name = "active",
      type = SearchParamType.Token,
      expression = "OrganizationAffiliation.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val date: SearchParam<OrganizationAffiliation, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "OrganizationAffiliation.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val email: SearchParam<OrganizationAffiliation, ContactPoint> =
    SearchParam(
      name = "email",
      type = SearchParamType.Token,
      expression = "OrganizationAffiliation.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val endpoint: SearchParam<OrganizationAffiliation, Reference> =
    SearchParam(
      name = "endpoint",
      type = SearchParamType.Reference,
      expression = "OrganizationAffiliation.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<OrganizationAffiliation, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "OrganizationAffiliation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<OrganizationAffiliation, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.Reference,
      expression = "OrganizationAffiliation.location",
      target = listOf(Location::class),
      extractor = { resource -> resource.location },
    )

  public val network: SearchParam<OrganizationAffiliation, Reference> =
    SearchParam(
      name = "network",
      type = SearchParamType.Reference,
      expression = "OrganizationAffiliation.network",
      target = listOf(Organization::class),
      extractor = { resource -> resource.network },
    )

  public val participatingOrganization: SearchParam<OrganizationAffiliation, Reference> =
    SearchParam(
      name = "participating-organization",
      type = SearchParamType.Reference,
      expression = "OrganizationAffiliation.participatingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.participatingOrganization) },
    )

  public val phone: SearchParam<OrganizationAffiliation, ContactPoint> =
    SearchParam(
      name = "phone",
      type = SearchParamType.Token,
      expression = "OrganizationAffiliation.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val primaryOrganization: SearchParam<OrganizationAffiliation, Reference> =
    SearchParam(
      name = "primary-organization",
      type = SearchParamType.Reference,
      expression = "OrganizationAffiliation.organization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.organization) },
    )

  public val role: SearchParam<OrganizationAffiliation, CodeableConcept> =
    SearchParam(
      name = "role",
      type = SearchParamType.Token,
      expression = "OrganizationAffiliation.code",
      extractor = { resource -> resource.code },
    )

  public val service: SearchParam<OrganizationAffiliation, Reference> =
    SearchParam(
      name = "service",
      type = SearchParamType.Reference,
      expression = "OrganizationAffiliation.healthcareService",
      target = listOf(HealthcareService::class),
      extractor = { resource -> resource.healthcareService },
    )

  public val specialty: SearchParam<OrganizationAffiliation, CodeableConcept> =
    SearchParam(
      name = "specialty",
      type = SearchParamType.Token,
      expression = "OrganizationAffiliation.specialty",
      extractor = { resource -> resource.specialty },
    )

  public val telecom: SearchParam<OrganizationAffiliation, ContactPoint> =
    SearchParam(
      name = "telecom",
      type = SearchParamType.Token,
      expression = "OrganizationAffiliation.telecom",
      extractor = { resource -> resource.telecom },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<OrganizationAffiliation, *>> = listOf()

  /**
   * Supported search parameters for the OrganizationAffiliation resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<OrganizationAffiliation, *>> =
    listOf(
      active,
      date,
      email,
      endpoint,
      identifier,
      location,
      network,
      participatingOrganization,
      phone,
      primaryOrganization,
      role,
      service,
      specialty,
      telecom,
    )
}
