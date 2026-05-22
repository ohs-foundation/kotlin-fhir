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

import dev.ohs.fhir.model.r5.Account
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.PaymentReconciliation
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Task
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PaymentReconciliation] resource type. */
public object PaymentReconciliationSearchParam {
  public val AllocationAccount: SearchParam<PaymentReconciliation, Reference> =
    SimpleSearchParam<PaymentReconciliation, Reference>(
      name = "allocation-account",
      type = SearchParamType.fromCode("reference"),
      expression = "PaymentReconciliation.allocation.account",
      target = listOf(Account::class),
      extractor = { resource -> resource.allocation.mapNotNull { it.account } },
    )

  public val AllocationEncounter: SearchParam<PaymentReconciliation, Reference> =
    SimpleSearchParam<PaymentReconciliation, Reference>(
      name = "allocation-encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "PaymentReconciliation.allocation.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> resource.allocation.mapNotNull { it.encounter } },
    )

  public val Created: SearchParam<PaymentReconciliation, DateTime> =
    SimpleSearchParam<PaymentReconciliation, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "PaymentReconciliation.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val Disposition: SearchParam<PaymentReconciliation, String> =
    SimpleSearchParam<PaymentReconciliation, String>(
      name = "disposition",
      type = SearchParamType.fromCode("string"),
      expression = "PaymentReconciliation.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val Identifier: SearchParam<PaymentReconciliation, Identifier> =
    SimpleSearchParam<PaymentReconciliation, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "PaymentReconciliation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Outcome: SearchParam<PaymentReconciliation, Any> =
    SimpleSearchParam<PaymentReconciliation, Any>(
      name = "outcome",
      type = SearchParamType.fromCode("token"),
      expression = "PaymentReconciliation.outcome",
      extractor = { resource -> listOfNotNull(resource.outcome) },
    )

  public val PaymentIssuer: SearchParam<PaymentReconciliation, Reference> =
    SimpleSearchParam<PaymentReconciliation, Reference>(
      name = "payment-issuer",
      type = SearchParamType.fromCode("reference"),
      expression = "PaymentReconciliation.paymentIssuer",
      target = listOf(Organization::class, RelatedPerson::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.paymentIssuer) },
    )

  public val Request: SearchParam<PaymentReconciliation, Reference> =
    SimpleSearchParam<PaymentReconciliation, Reference>(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "PaymentReconciliation.request",
      target = listOf(Task::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val Requestor: SearchParam<PaymentReconciliation, Reference> =
    SimpleSearchParam<PaymentReconciliation, Reference>(
      name = "requestor",
      type = SearchParamType.fromCode("reference"),
      expression = "PaymentReconciliation.requestor",
      target = listOf(Organization::class, PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.requestor) },
    )

  public val Status: SearchParam<PaymentReconciliation, Any> =
    SimpleSearchParam<PaymentReconciliation, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "PaymentReconciliation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the PaymentReconciliation resource type. */
  public val ALL: List<SearchParam<PaymentReconciliation, *>> =
    listOf(
      AllocationAccount,
      AllocationEncounter,
      Created,
      Disposition,
      Identifier,
      Outcome,
      PaymentIssuer,
      Request,
      Requestor,
      Status,
    )
}
