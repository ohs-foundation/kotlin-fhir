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

import dev.ohs.fhir.model.r4b.Boolean
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Endpoint
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.OrganizationAffiliation
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [OrganizationAffiliation] resource type. */
public object OrganizationAffiliationSearchParams {
  public val active: SearchParam<OrganizationAffiliation, Boolean> =
    SimpleSearchParam<OrganizationAffiliation, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "OrganizationAffiliation.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val date: SearchParam<OrganizationAffiliation, Period> =
    SimpleSearchParam<OrganizationAffiliation, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "OrganizationAffiliation.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val email: SearchParam<OrganizationAffiliation, ContactPoint> =
    SimpleSearchParam<OrganizationAffiliation, ContactPoint>(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "OrganizationAffiliation.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val endpoint: SearchParam<OrganizationAffiliation, Reference> =
    SimpleSearchParam<OrganizationAffiliation, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "OrganizationAffiliation.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<OrganizationAffiliation, Identifier> =
    SimpleSearchParam<OrganizationAffiliation, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "OrganizationAffiliation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<OrganizationAffiliation, Reference> =
    SimpleSearchParam<OrganizationAffiliation, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "OrganizationAffiliation.location",
      target = listOf(Location::class),
      extractor = { resource -> resource.location },
    )

  public val network: SearchParam<OrganizationAffiliation, Reference> =
    SimpleSearchParam<OrganizationAffiliation, Reference>(
      name = "network",
      type = SearchParamType.fromCode("reference"),
      expression = "OrganizationAffiliation.network",
      target = listOf(Organization::class),
      extractor = { resource -> resource.network },
    )

  public val participatingOrganization: SearchParam<OrganizationAffiliation, Reference> =
    SimpleSearchParam<OrganizationAffiliation, Reference>(
      name = "participating-organization",
      type = SearchParamType.fromCode("reference"),
      expression = "OrganizationAffiliation.participatingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.participatingOrganization) },
    )

  public val phone: SearchParam<OrganizationAffiliation, ContactPoint> =
    SimpleSearchParam<OrganizationAffiliation, ContactPoint>(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "OrganizationAffiliation.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val primaryOrganization: SearchParam<OrganizationAffiliation, Reference> =
    SimpleSearchParam<OrganizationAffiliation, Reference>(
      name = "primary-organization",
      type = SearchParamType.fromCode("reference"),
      expression = "OrganizationAffiliation.organization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.organization) },
    )

  public val role: SearchParam<OrganizationAffiliation, CodeableConcept> =
    SimpleSearchParam<OrganizationAffiliation, CodeableConcept>(
      name = "role",
      type = SearchParamType.fromCode("token"),
      expression = "OrganizationAffiliation.code",
      extractor = { resource -> resource.code },
    )

  public val service: SearchParam<OrganizationAffiliation, Reference> =
    SimpleSearchParam<OrganizationAffiliation, Reference>(
      name = "service",
      type = SearchParamType.fromCode("reference"),
      expression = "OrganizationAffiliation.healthcareService",
      target = listOf(HealthcareService::class),
      extractor = { resource -> resource.healthcareService },
    )

  public val specialty: SearchParam<OrganizationAffiliation, CodeableConcept> =
    SimpleSearchParam<OrganizationAffiliation, CodeableConcept>(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "OrganizationAffiliation.specialty",
      extractor = { resource -> resource.specialty },
    )

  public val telecom: SearchParam<OrganizationAffiliation, ContactPoint> =
    SimpleSearchParam<OrganizationAffiliation, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "OrganizationAffiliation.telecom",
      extractor = { resource -> resource.telecom },
    )

  /** All search parameters for the OrganizationAffiliation resource type. */
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
