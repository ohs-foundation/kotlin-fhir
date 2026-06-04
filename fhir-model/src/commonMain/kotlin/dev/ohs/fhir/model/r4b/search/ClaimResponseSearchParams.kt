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

import dev.ohs.fhir.model.r4b.Claim
import dev.ohs.fhir.model.r4b.ClaimResponse
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClaimResponse] resource type. */
public object ClaimResponseSearchParams {
  public val Created: SearchParam<ClaimResponse, DateTime> =
    SimpleSearchParam<ClaimResponse, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "ClaimResponse.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val Disposition: SearchParam<ClaimResponse, String> =
    SimpleSearchParam<ClaimResponse, String>(
      name = "disposition",
      type = SearchParamType.fromCode("string"),
      expression = "ClaimResponse.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val Identifier: SearchParam<ClaimResponse, Identifier> =
    SimpleSearchParam<ClaimResponse, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ClaimResponse.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Insurer: SearchParam<ClaimResponse, Reference> =
    SimpleSearchParam<ClaimResponse, Reference>(
      name = "insurer",
      type = SearchParamType.fromCode("reference"),
      expression = "ClaimResponse.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOf(resource.insurer) },
    )

  public val Outcome: SearchParam<ClaimResponse, Any> =
    SimpleSearchParam<ClaimResponse, Any>(
      name = "outcome",
      type = SearchParamType.fromCode("token"),
      expression = "ClaimResponse.outcome",
      extractor = { resource -> listOf(resource.outcome) },
    )

  public val Patient: SearchParam<ClaimResponse, Reference> =
    SimpleSearchParam<ClaimResponse, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ClaimResponse.patient",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val PaymentDate: SearchParam<ClaimResponse, Date> =
    SimpleSearchParam<ClaimResponse, Date>(
      name = "payment-date",
      type = SearchParamType.fromCode("date"),
      expression = "ClaimResponse.payment.date",
      extractor = { resource -> listOfNotNull(resource.payment?.date) },
    )

  public val Request: SearchParam<ClaimResponse, Reference> =
    SimpleSearchParam<ClaimResponse, Reference>(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "ClaimResponse.request",
      target = listOf(Claim::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val Requestor: SearchParam<ClaimResponse, Reference> =
    SimpleSearchParam<ClaimResponse, Reference>(
      name = "requestor",
      type = SearchParamType.fromCode("reference"),
      expression = "ClaimResponse.requestor",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.requestor) },
    )

  public val Status: SearchParam<ClaimResponse, Any> =
    SimpleSearchParam<ClaimResponse, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ClaimResponse.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Use: SearchParam<ClaimResponse, Any> =
    SimpleSearchParam<ClaimResponse, Any>(
      name = "use",
      type = SearchParamType.fromCode("token"),
      expression = "ClaimResponse.use",
      extractor = { resource -> listOf(resource.use) },
    )

  /** All search parameters for the ClaimResponse resource type. */
  public val ALL: List<SearchParam<ClaimResponse, *>> =
    listOf(
      Created,
      Disposition,
      Identifier,
      Insurer,
      Outcome,
      Patient,
      PaymentDate,
      Request,
      Requestor,
      Status,
      Use,
    )
}
