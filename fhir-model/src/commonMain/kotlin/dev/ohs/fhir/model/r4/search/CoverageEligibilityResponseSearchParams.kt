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

import dev.ohs.fhir.model.r4.CoverageEligibilityRequest
import dev.ohs.fhir.model.r4.CoverageEligibilityResponse
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CoverageEligibilityResponse] resource type. */
public object CoverageEligibilityResponseSearchParams {
  public val Created: SearchParam<CoverageEligibilityResponse, DateTime> =
    SimpleSearchParam<CoverageEligibilityResponse, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "CoverageEligibilityResponse.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val Disposition: SearchParam<CoverageEligibilityResponse, String> =
    SimpleSearchParam<CoverageEligibilityResponse, String>(
      name = "disposition",
      type = SearchParamType.fromCode("string"),
      expression = "CoverageEligibilityResponse.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val Identifier: SearchParam<CoverageEligibilityResponse, Identifier> =
    SimpleSearchParam<CoverageEligibilityResponse, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Insurer: SearchParam<CoverageEligibilityResponse, Reference> =
    SimpleSearchParam<CoverageEligibilityResponse, Reference>(
      name = "insurer",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityResponse.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOf(resource.insurer) },
    )

  public val Outcome: SearchParam<CoverageEligibilityResponse, Any> =
    SimpleSearchParam<CoverageEligibilityResponse, Any>(
      name = "outcome",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityResponse.outcome",
      extractor = { resource -> listOf(resource.outcome) },
    )

  public val Patient: SearchParam<CoverageEligibilityResponse, Reference> =
    SimpleSearchParam<CoverageEligibilityResponse, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityResponse.patient",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Request: SearchParam<CoverageEligibilityResponse, Reference> =
    SimpleSearchParam<CoverageEligibilityResponse, Reference>(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityResponse.request",
      target = listOf(CoverageEligibilityRequest::class),
      extractor = { resource -> listOf(resource.request) },
    )

  public val Requestor: SearchParam<CoverageEligibilityResponse, Reference> =
    SimpleSearchParam<CoverageEligibilityResponse, Reference>(
      name = "requestor",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityResponse.requestor",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.requestor) },
    )

  public val Status: SearchParam<CoverageEligibilityResponse, Any> =
    SimpleSearchParam<CoverageEligibilityResponse, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityResponse.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the CoverageEligibilityResponse resource type. */
  public val ALL: List<SearchParam<CoverageEligibilityResponse, *>> =
    listOf(Created, Disposition, Identifier, Insurer, Outcome, Patient, Request, Requestor, Status)
}
