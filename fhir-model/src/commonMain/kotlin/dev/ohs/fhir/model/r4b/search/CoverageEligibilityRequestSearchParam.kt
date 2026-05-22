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

import dev.ohs.fhir.model.r4b.CoverageEligibilityRequest
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CoverageEligibilityRequest] resource type. */
public object CoverageEligibilityRequestSearchParam {
  public val Created: SearchParam<CoverageEligibilityRequest, DateTime> =
    SimpleSearchParam<CoverageEligibilityRequest, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "CoverageEligibilityRequest.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val Enterer: SearchParam<CoverageEligibilityRequest, Reference> =
    SimpleSearchParam<CoverageEligibilityRequest, Reference>(
      name = "enterer",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityRequest.enterer",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val Facility: SearchParam<CoverageEligibilityRequest, Reference> =
    SimpleSearchParam<CoverageEligibilityRequest, Reference>(
      name = "facility",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityRequest.facility",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.facility) },
    )

  public val Identifier: SearchParam<CoverageEligibilityRequest, Identifier> =
    SimpleSearchParam<CoverageEligibilityRequest, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<CoverageEligibilityRequest, Reference> =
    SimpleSearchParam<CoverageEligibilityRequest, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityRequest.patient",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Provider: SearchParam<CoverageEligibilityRequest, Reference> =
    SimpleSearchParam<CoverageEligibilityRequest, Reference>(
      name = "provider",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityRequest.provider",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.provider) },
    )

  public val Status: SearchParam<CoverageEligibilityRequest, Any> =
    SimpleSearchParam<CoverageEligibilityRequest, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityRequest.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the CoverageEligibilityRequest resource type. */
  public val ALL: List<SearchParam<CoverageEligibilityRequest, *>> =
    listOf(Created, Enterer, Facility, Identifier, Patient, Provider, Status)
}
