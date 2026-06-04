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
    SearchParam<ClaimResponse, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "ClaimResponse.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val disposition: SearchParam<ClaimResponse, String> =
    SearchParam<ClaimResponse, String>(
      name = "disposition",
      type = SearchParamType.fromCode("string"),
      expression = "ClaimResponse.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val identifier: SearchParam<ClaimResponse, Identifier> =
    SearchParam<ClaimResponse, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ClaimResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val insurer: SearchParam<ClaimResponse, Reference> =
    SearchParam<ClaimResponse, Reference>(
      name = "insurer",
      type = SearchParamType.fromCode("reference"),
      expression = "ClaimResponse.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOf(resource.insurer) },
    )

  public val outcome: SearchParam<ClaimResponse, Any> =
    SearchParam<ClaimResponse, Any>(
      name = "outcome",
      type = SearchParamType.fromCode("token"),
      expression = "ClaimResponse.outcome",
      extractor = { resource -> listOf(resource.outcome) },
    )

  public val patient: SearchParam<ClaimResponse, Reference> =
    SearchParam<ClaimResponse, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ClaimResponse.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val paymentDate: SearchParam<ClaimResponse, Date> =
    SearchParam<ClaimResponse, Date>(
      name = "payment-date",
      type = SearchParamType.fromCode("date"),
      expression = "ClaimResponse.payment.date",
      extractor = { resource -> listOfNotNull(resource.payment?.date) },
    )

  public val request: SearchParam<ClaimResponse, Reference> =
    SearchParam<ClaimResponse, Reference>(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "ClaimResponse.request",
      target = listOf(Claim::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val requestor: SearchParam<ClaimResponse, Reference> =
    SearchParam<ClaimResponse, Reference>(
      name = "requestor",
      type = SearchParamType.fromCode("reference"),
      expression = "ClaimResponse.requestor",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.requestor) },
    )

  public val status: SearchParam<ClaimResponse, Any> =
    SearchParam<ClaimResponse, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ClaimResponse.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val use: SearchParam<ClaimResponse, Any> =
    SearchParam<ClaimResponse, Any>(
      name = "use",
      type = SearchParamType.fromCode("token"),
      expression = "ClaimResponse.use",
      extractor = { resource -> listOf(resource.use) },
    )

  /** All search parameters for the ClaimResponse resource type. */
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
