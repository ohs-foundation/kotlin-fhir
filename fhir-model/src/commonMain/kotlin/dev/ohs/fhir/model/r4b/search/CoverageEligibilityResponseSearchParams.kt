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
import dev.ohs.fhir.model.r4b.CoverageEligibilityResponse
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CoverageEligibilityResponse] resource type. */
public object CoverageEligibilityResponseSearchParams {
  public val created: SearchParam<CoverageEligibilityResponse, DateTime> =
    SearchParam(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "CoverageEligibilityResponse.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val disposition: SearchParam<CoverageEligibilityResponse, String> =
    SearchParam(
      name = "disposition",
      type = SearchParamType.fromCode("string"),
      expression = "CoverageEligibilityResponse.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val identifier: SearchParam<CoverageEligibilityResponse, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val insurer: SearchParam<CoverageEligibilityResponse, Reference> =
    SearchParam(
      name = "insurer",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityResponse.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOf(resource.insurer) },
    )

  public val outcome: SearchParam<CoverageEligibilityResponse, Any> =
    SearchParam(
      name = "outcome",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityResponse.outcome",
      extractor = { resource -> listOf(resource.outcome) },
    )

  public val patient: SearchParam<CoverageEligibilityResponse, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityResponse.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val request: SearchParam<CoverageEligibilityResponse, Reference> =
    SearchParam(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityResponse.request",
      target = listOf(CoverageEligibilityRequest::class),
      extractor = { resource -> listOf(resource.request) },
    )

  public val requestor: SearchParam<CoverageEligibilityResponse, Reference> =
    SearchParam(
      name = "requestor",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityResponse.requestor",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.requestor) },
    )

  public val status: SearchParam<CoverageEligibilityResponse, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityResponse.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<CoverageEligibilityResponse, *>> = listOf()

  /**
   * Supported search parameters for the CoverageEligibilityResponse resource type. Iterating `all`
   * and calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded
   * from this list.
   */
  public val all: List<SearchParam<CoverageEligibilityResponse, *>> =
    listOf(created, disposition, identifier, insurer, outcome, patient, request, requestor, status)
}
