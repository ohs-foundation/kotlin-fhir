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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClaimResponse] resource type. */
public sealed class ClaimResponseSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ClaimResponse): List<T>

  public data object Created : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ClaimResponse.created"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Disposition : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ClaimResponse.disposition"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Identifier : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClaimResponse.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Insurer : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClaimResponse.insurer"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Outcome : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClaimResponse.outcome"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Patient : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClaimResponse.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object PaymentDate : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "payment-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ClaimResponse.payment.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Request : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClaimResponse.request"

    public override val target: List<String> = listOf("Claim")

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Requestor : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "requestor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ClaimResponse.requestor"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Status : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClaimResponse.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
  }

  public data object Use : ClaimResponseSearchParam<Any>() {
    public override val paramName: String = "use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ClaimResponse.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = emptyList()
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
