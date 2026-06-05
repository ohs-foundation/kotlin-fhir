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

import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.PaymentReconciliation
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Task
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PaymentReconciliation] resource type. */
public object PaymentReconciliationSearchParams {
  public val created: SearchParam<PaymentReconciliation, DateTime> =
    SearchParam(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "PaymentReconciliation.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val disposition: SearchParam<PaymentReconciliation, String> =
    SearchParam(
      name = "disposition",
      type = SearchParamType.fromCode("string"),
      expression = "PaymentReconciliation.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val identifier: SearchParam<PaymentReconciliation, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "PaymentReconciliation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val outcome: SearchParam<PaymentReconciliation, Any> =
    SearchParam(
      name = "outcome",
      type = SearchParamType.fromCode("token"),
      expression = "PaymentReconciliation.outcome",
      extractor = { resource -> listOfNotNull(resource.outcome) },
    )

  public val paymentIssuer: SearchParam<PaymentReconciliation, Reference> =
    SearchParam(
      name = "payment-issuer",
      type = SearchParamType.fromCode("reference"),
      expression = "PaymentReconciliation.paymentIssuer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.paymentIssuer) },
    )

  public val request: SearchParam<PaymentReconciliation, Reference> =
    SearchParam(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "PaymentReconciliation.request",
      target = listOf(Task::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val requestor: SearchParam<PaymentReconciliation, Reference> =
    SearchParam(
      name = "requestor",
      type = SearchParamType.fromCode("reference"),
      expression = "PaymentReconciliation.requestor",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.requestor) },
    )

  public val status: SearchParam<PaymentReconciliation, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "PaymentReconciliation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<PaymentReconciliation, *>> = listOf()

  /**
   * Supported search parameters for the PaymentReconciliation resource type. Entries in
   * [unsupported] are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<PaymentReconciliation, *>> =
    listOf(created, disposition, identifier, outcome, paymentIssuer, request, requestor, status) -
      unsupported.toSet()
}
