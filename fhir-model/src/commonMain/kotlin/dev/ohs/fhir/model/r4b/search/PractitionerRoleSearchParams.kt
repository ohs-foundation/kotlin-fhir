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
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PractitionerRole] resource type. */
public object PractitionerRoleSearchParams {
  public val active: SearchParam<PractitionerRole, Boolean> =
    SearchParam<PractitionerRole, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val date: SearchParam<PractitionerRole, Period> =
    SearchParam<PractitionerRole, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "PractitionerRole.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val email: SearchParam<PractitionerRole, ContactPoint> =
    SearchParam<PractitionerRole, ContactPoint>(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.telecom.where(system='email')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val endpoint: SearchParam<PractitionerRole, Reference> =
    SearchParam<PractitionerRole, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<PractitionerRole, Identifier> =
    SearchParam<PractitionerRole, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<PractitionerRole, Reference> =
    SearchParam<PractitionerRole, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.location",
      target = listOf(Location::class),
      extractor = { resource -> resource.location },
    )

  public val organization: SearchParam<PractitionerRole, Reference> =
    SearchParam<PractitionerRole, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.organization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.organization) },
    )

  public val phone: SearchParam<PractitionerRole, ContactPoint> =
    SearchParam<PractitionerRole, ContactPoint>(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.telecom.where(system='phone')",
      extractor = { resource ->
        resource.telecom.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val practitioner: SearchParam<PractitionerRole, Reference> =
    SearchParam<PractitionerRole, Reference>(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.practitioner",
      target = listOf(Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.practitioner) },
    )

  public val role: SearchParam<PractitionerRole, CodeableConcept> =
    SearchParam<PractitionerRole, CodeableConcept>(
      name = "role",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.code",
      extractor = { resource -> resource.code },
    )

  public val service: SearchParam<PractitionerRole, Reference> =
    SearchParam<PractitionerRole, Reference>(
      name = "service",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.healthcareService",
      target = listOf(HealthcareService::class),
      extractor = { resource -> resource.healthcareService },
    )

  public val specialty: SearchParam<PractitionerRole, CodeableConcept> =
    SearchParam<PractitionerRole, CodeableConcept>(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.specialty",
      extractor = { resource -> resource.specialty },
    )

  public val telecom: SearchParam<PractitionerRole, ContactPoint> =
    SearchParam<PractitionerRole, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.telecom",
      extractor = { resource -> resource.telecom },
    )

  /** All search parameters for the PractitionerRole resource type. */
  public val all: List<SearchParam<PractitionerRole, *>> =
    listOf(
      active,
      date,
      email,
      endpoint,
      identifier,
      location,
      organization,
      phone,
      practitioner,
      role,
      service,
      specialty,
      telecom,
    )
}
