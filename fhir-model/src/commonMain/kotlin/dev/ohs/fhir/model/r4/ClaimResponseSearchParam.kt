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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClaimResponse] resource type. */
public sealed class ClaimResponseSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ClaimResponse): List<T>

  public data object Created : ClaimResponseSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ClaimResponse.created"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<DateTime> = listOf(resource.created)
  }

  public data object Disposition : ClaimResponseSearchParam<String>() {
    public override val paramName: kotlin.String = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ClaimResponse.disposition"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<String> =
      listOfNotNull(resource.disposition)
  }

  public data object Identifier : ClaimResponseSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ClaimResponse.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Insurer : ClaimResponseSearchParam<Reference>() {
    public override val paramName: kotlin.String = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ClaimResponse.insurer"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: ClaimResponse): List<Reference> = listOf(resource.insurer)
  }

  public data object Outcome : ClaimResponseSearchParam<Any>() {
    public override val paramName: kotlin.String = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ClaimResponse.outcome"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = listOf(resource.outcome)
  }

  public data object Patient : ClaimResponseSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ClaimResponse.patient"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: ClaimResponse): List<Reference> = listOf(resource.patient)
  }

  public data object PaymentDate : ClaimResponseSearchParam<Date>() {
    public override val paramName: kotlin.String = "payment-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ClaimResponse.payment.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Date> =
      listOfNotNull(resource.payment?.date)
  }

  public data object Request : ClaimResponseSearchParam<Reference>() {
    public override val paramName: kotlin.String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ClaimResponse.request"

    public override val target: List<kotlin.String> = listOf("Claim")

    public override fun extract(resource: ClaimResponse): List<Reference> =
      listOfNotNull(resource.request)
  }

  public data object Requestor : ClaimResponseSearchParam<Reference>() {
    public override val paramName: kotlin.String = "requestor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ClaimResponse.requestor"

    public override val target: List<kotlin.String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: ClaimResponse): List<Reference> =
      listOfNotNull(resource.requestor)
  }

  public data object Status : ClaimResponseSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ClaimResponse.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = listOf(resource.status)
  }

  public data object Use : ClaimResponseSearchParam<Any>() {
    public override val paramName: kotlin.String = "use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ClaimResponse.use"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = listOf(resource.use)
  }

  public companion object {
    /** All search parameters for the ClaimResponse resource type. */
    public val ALL: List<ClaimResponseSearchParam<*>> =
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
}
