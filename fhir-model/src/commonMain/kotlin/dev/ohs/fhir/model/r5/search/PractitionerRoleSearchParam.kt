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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PractitionerRole] resource type. */
public object PractitionerRoleSearchParam {
  public val Active: SearchParam<PractitionerRole, Boolean> =
    SimpleSearchParam<PractitionerRole, Boolean>(
      name = "active",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.active",
      extractor = { resource -> listOfNotNull(resource.active) },
    )

  public val Characteristic: SearchParam<PractitionerRole, CodeableConcept> =
    SimpleSearchParam<PractitionerRole, CodeableConcept>(
      name = "characteristic",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.characteristic",
      extractor = { resource -> resource.characteristic },
    )

  public val Communication: SearchParam<PractitionerRole, CodeableConcept> =
    SimpleSearchParam<PractitionerRole, CodeableConcept>(
      name = "communication",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.communication",
      extractor = { resource -> resource.communication },
    )

  public val Date: SearchParam<PractitionerRole, Period> =
    SimpleSearchParam<PractitionerRole, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "PractitionerRole.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val Email: SearchParam<PractitionerRole, ContactPoint> =
    SimpleSearchParam<PractitionerRole, ContactPoint>(
      name = "email",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.contact.telecom.where(system='email')",
      extractor = { resource ->
        resource.contact.flatMap { it.telecom }.filter { it.system?.value?.toString() == "email" }
      },
    )

  public val Endpoint: SearchParam<PractitionerRole, Reference> =
    SimpleSearchParam<PractitionerRole, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.endpoint",
      target = listOf(dev.ohs.fhir.model.r5.Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val Identifier: SearchParam<PractitionerRole, Identifier> =
    SimpleSearchParam<PractitionerRole, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Location: SearchParam<PractitionerRole, Reference> =
    SimpleSearchParam<PractitionerRole, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.location",
      target = listOf(dev.ohs.fhir.model.r5.Location::class),
      extractor = { resource -> resource.location },
    )

  public val Organization: SearchParam<PractitionerRole, Reference> =
    SimpleSearchParam<PractitionerRole, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.organization",
      target = listOf(dev.ohs.fhir.model.r5.Organization::class),
      extractor = { resource -> listOfNotNull(resource.organization) },
    )

  public val Phone: SearchParam<PractitionerRole, ContactPoint> =
    SimpleSearchParam<PractitionerRole, ContactPoint>(
      name = "phone",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.contact.telecom.where(system='phone')",
      extractor = { resource ->
        resource.contact.flatMap { it.telecom }.filter { it.system?.value?.toString() == "phone" }
      },
    )

  public val Practitioner: SearchParam<PractitionerRole, Reference> =
    SimpleSearchParam<PractitionerRole, Reference>(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.practitioner",
      target = listOf(dev.ohs.fhir.model.r5.Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.practitioner) },
    )

  public val Role: SearchParam<PractitionerRole, CodeableConcept> =
    SimpleSearchParam<PractitionerRole, CodeableConcept>(
      name = "role",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.code",
      extractor = { resource -> resource.code },
    )

  public val Service: SearchParam<PractitionerRole, Reference> =
    SimpleSearchParam<PractitionerRole, Reference>(
      name = "service",
      type = SearchParamType.fromCode("reference"),
      expression = "PractitionerRole.healthcareService",
      target = listOf(HealthcareService::class),
      extractor = { resource -> resource.healthcareService },
    )

  public val Specialty: SearchParam<PractitionerRole, CodeableConcept> =
    SimpleSearchParam<PractitionerRole, CodeableConcept>(
      name = "specialty",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.specialty",
      extractor = { resource -> resource.specialty },
    )

  public val Telecom: SearchParam<PractitionerRole, ContactPoint> =
    SimpleSearchParam<PractitionerRole, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "PractitionerRole.contact.telecom",
      extractor = { resource -> resource.contact.flatMap { it.telecom } },
    )

  /** All search parameters for the PractitionerRole resource type. */
  public val ALL: List<SearchParam<PractitionerRole, *>> =
    listOf(
      Active,
      Characteristic,
      Communication,
      Date,
      Email,
      Endpoint,
      Identifier,
      Location,
      Organization,
      Phone,
      Practitioner,
      Role,
      Service,
      Specialty,
      Telecom,
    )
}
