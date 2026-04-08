/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PaymentReconciliation] resource type. */
public sealed class PaymentReconciliationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: PaymentReconciliation): List<T>

  public data object AllocationAccount : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "allocation-account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PaymentReconciliation.allocation.account"

    public override val target: List<String> = listOf("Account")

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object AllocationEncounter : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "allocation-encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PaymentReconciliation.allocation.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object Created : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "PaymentReconciliation.created"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object Disposition : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "PaymentReconciliation.disposition"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object Identifier : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PaymentReconciliation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object Outcome : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PaymentReconciliation.outcome"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object PaymentIssuer : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "payment-issuer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PaymentReconciliation.paymentIssuer"

    public override val target: List<String> = listOf("Organization", "RelatedPerson", "Patient")

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object Request : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PaymentReconciliation.request"

    public override val target: List<String> = listOf("Task")

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object Requestor : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "requestor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PaymentReconciliation.requestor"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
  }

  public data object Status : PaymentReconciliationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PaymentReconciliation.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PaymentReconciliation): List<Any> = emptyList()
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
