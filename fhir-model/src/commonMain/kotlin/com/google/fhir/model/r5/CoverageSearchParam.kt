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

/** Search parameters for the [Coverage] resource type. */
public sealed class CoverageSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Coverage): List<T>

  public data object Beneficiary : CoverageSearchParam<Any>() {
    public override val paramName: String = "beneficiary"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Coverage.beneficiary"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object ClassType : CoverageSearchParam<Any>() {
    public override val paramName: String = "class-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Coverage.class.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object ClassValue : CoverageSearchParam<Any>() {
    public override val paramName: String = "class-value"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Coverage.class.value"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object Dependent : CoverageSearchParam<Any>() {
    public override val paramName: String = "dependent"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Coverage.dependent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object Identifier : CoverageSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Coverage.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object Insurer : CoverageSearchParam<Any>() {
    public override val paramName: String = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Coverage.insurer"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object Patient : CoverageSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Coverage.beneficiary"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object PaymentbyParty : CoverageSearchParam<Any>() {
    public override val paramName: String = "paymentby-party"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Coverage.paymentBy.party"

    public override val target: List<String> = listOf("Organization", "RelatedPerson", "Patient")

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object PolicyHolder : CoverageSearchParam<Any>() {
    public override val paramName: String = "policy-holder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Coverage.policyHolder"

    public override val target: List<String> = listOf("Organization", "RelatedPerson", "Patient")

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object Status : CoverageSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Coverage.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object Subscriber : CoverageSearchParam<Any>() {
    public override val paramName: String = "subscriber"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Coverage.subscriber"

    public override val target: List<String> = listOf("RelatedPerson", "Patient")

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object Subscriberid : CoverageSearchParam<Any>() {
    public override val paramName: String = "subscriberid"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Coverage.subscriberId"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public data object Type : CoverageSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Coverage.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Coverage resource type. */
    public val ALL: List<CoverageSearchParam<*>> =
      listOf(
        Beneficiary,
        ClassType,
        ClassValue,
        Dependent,
        Identifier,
        Insurer,
        Patient,
        PaymentbyParty,
        PolicyHolder,
        Status,
        Subscriber,
        Subscriberid,
        Type,
      )
  }
}
