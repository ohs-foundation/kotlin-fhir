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

import dev.ohs.fhir.model.r5.CoverageEligibilityRequest
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CoverageEligibilityRequest] resource type. */
public object CoverageEligibilityRequestSearchParams {
  public val created: SearchParam<CoverageEligibilityRequest, DateTime> =
    SearchParam<CoverageEligibilityRequest, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "CoverageEligibilityRequest.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val enterer: SearchParam<CoverageEligibilityRequest, Reference> =
    SearchParam<CoverageEligibilityRequest, Reference>(
      name = "enterer",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityRequest.enterer",
      target = listOf(PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val facility: SearchParam<CoverageEligibilityRequest, Reference> =
    SearchParam<CoverageEligibilityRequest, Reference>(
      name = "facility",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityRequest.facility",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.facility) },
    )

  public val identifier: SearchParam<CoverageEligibilityRequest, Identifier> =
    SearchParam<CoverageEligibilityRequest, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<CoverageEligibilityRequest, Reference> =
    SearchParam<CoverageEligibilityRequest, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityRequest.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val provider: SearchParam<CoverageEligibilityRequest, Reference> =
    SearchParam<CoverageEligibilityRequest, Reference>(
      name = "provider",
      type = SearchParamType.fromCode("reference"),
      expression = "CoverageEligibilityRequest.provider",
      target = listOf(Organization::class, PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.provider) },
    )

  public val status: SearchParam<CoverageEligibilityRequest, Any> =
    SearchParam<CoverageEligibilityRequest, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CoverageEligibilityRequest.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the CoverageEligibilityRequest resource type. */
  public val all: List<SearchParam<CoverageEligibilityRequest, *>> =
    listOf(created, enterer, facility, identifier, patient, provider, status)
}
