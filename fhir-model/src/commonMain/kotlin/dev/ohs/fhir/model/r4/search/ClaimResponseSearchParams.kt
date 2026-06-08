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

import dev.ohs.fhir.model.r4.Claim
import dev.ohs.fhir.model.r4.ClaimResponse
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClaimResponse] resource type. */
public object ClaimResponseSearchParams {
  public val created: SearchParam<ClaimResponse, DateTime> =
    SearchParam(
      name = "created",
      type = SearchParamType.Date,
      expression = "ClaimResponse.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val disposition: SearchParam<ClaimResponse, String> =
    SearchParam(
      name = "disposition",
      type = SearchParamType.String,
      expression = "ClaimResponse.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val identifier: SearchParam<ClaimResponse, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ClaimResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val insurer: SearchParam<ClaimResponse, Reference> =
    SearchParam(
      name = "insurer",
      type = SearchParamType.Reference,
      expression = "ClaimResponse.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOf(resource.insurer) },
    )

  public val outcome: SearchParam<ClaimResponse, Any> =
    SearchParam(
      name = "outcome",
      type = SearchParamType.Token,
      expression = "ClaimResponse.outcome",
      extractor = { resource -> listOf(resource.outcome) },
    )

  public val patient: SearchParam<ClaimResponse, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "ClaimResponse.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val paymentDate: SearchParam<ClaimResponse, Date> =
    SearchParam(
      name = "payment-date",
      type = SearchParamType.Date,
      expression = "ClaimResponse.payment.date",
      extractor = { resource -> listOfNotNull(resource.payment?.date) },
    )

  public val request: SearchParam<ClaimResponse, Reference> =
    SearchParam(
      name = "request",
      type = SearchParamType.Reference,
      expression = "ClaimResponse.request",
      target = listOf(Claim::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val requestor: SearchParam<ClaimResponse, Reference> =
    SearchParam(
      name = "requestor",
      type = SearchParamType.Reference,
      expression = "ClaimResponse.requestor",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.requestor) },
    )

  public val status: SearchParam<ClaimResponse, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ClaimResponse.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val use: SearchParam<ClaimResponse, Any> =
    SearchParam(
      name = "use",
      type = SearchParamType.Token,
      expression = "ClaimResponse.use",
      extractor = { resource -> listOf(resource.use) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ClaimResponse, *>> = listOf()

  /**
   * Supported search parameters for the ClaimResponse resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ClaimResponse, *>> =
    listOf(
      created,
      disposition,
      identifier,
      insurer,
      outcome,
      patient,
      paymentDate,
      request,
      requestor,
      status,
      use,
    )
}
