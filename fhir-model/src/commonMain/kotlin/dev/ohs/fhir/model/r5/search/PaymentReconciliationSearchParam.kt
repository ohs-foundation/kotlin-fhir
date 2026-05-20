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

import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.PaymentReconciliation
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PaymentReconciliation] resource type. */
public sealed class PaymentReconciliationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: PaymentReconciliation): List<T>

  public data object AllocationAccount : PaymentReconciliationSearchParam<Reference>() {
    public override val paramName: KotlinString = "allocation-account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "PaymentReconciliation.allocation.account"

    public override val target: List<KotlinString> = listOf("Account")

    public override fun extract(resource: PaymentReconciliation): List<Reference> =
      resource.allocation.mapNotNull { it.account }
  }

  public data object AllocationEncounter : PaymentReconciliationSearchParam<Reference>() {
    public override val paramName: KotlinString = "allocation-encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "PaymentReconciliation.allocation.encounter"

    public override val target: List<KotlinString> = listOf("Encounter")

    public override fun extract(resource: PaymentReconciliation): List<Reference> =
      resource.allocation.mapNotNull { it.encounter }
  }

  public data object Created : PaymentReconciliationSearchParam<DateTime>() {
    public override val paramName: KotlinString = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "PaymentReconciliation.created"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<DateTime> =
      listOf(resource.created)
  }

  public data object Disposition : PaymentReconciliationSearchParam<R5String>() {
    public override val paramName: KotlinString = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "PaymentReconciliation.disposition"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<R5String> =
      listOfNotNull(resource.disposition)
  }

  public data object Identifier :
    PaymentReconciliationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PaymentReconciliation.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: PaymentReconciliation
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Outcome : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: KotlinString = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PaymentReconciliation.outcome"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<Any> =
      listOfNotNull(resource.outcome)
  }

  public data object PaymentIssuer : PaymentReconciliationSearchParam<Reference>() {
    public override val paramName: KotlinString = "payment-issuer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "PaymentReconciliation.paymentIssuer"

    public override val target: List<KotlinString> =
      listOf("Organization", "RelatedPerson", "Patient")

    public override fun extract(resource: PaymentReconciliation): List<Reference> =
      listOfNotNull(resource.paymentIssuer)
  }

  public data object Request : PaymentReconciliationSearchParam<Reference>() {
    public override val paramName: KotlinString = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "PaymentReconciliation.request"

    public override val target: List<KotlinString> = listOf("Task")

    public override fun extract(resource: PaymentReconciliation): List<Reference> =
      listOfNotNull(resource.request)
  }

  public data object Requestor : PaymentReconciliationSearchParam<Reference>() {
    public override val paramName: KotlinString = "requestor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "PaymentReconciliation.requestor"

    public override val target: List<KotlinString> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: PaymentReconciliation): List<Reference> =
      listOfNotNull(resource.requestor)
  }

  public data object Status : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PaymentReconciliation.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<Any> =
      listOf(resource.status)
  }

  public companion object {
    /** All search parameters for the PaymentReconciliation resource type. */
    public val ALL: List<PaymentReconciliationSearchParam<*>> =
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
}
