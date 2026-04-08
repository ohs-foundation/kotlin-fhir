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

/** Search parameters for the [RiskEvidenceSynthesis] resource type. */
public sealed class RiskEvidenceSynthesisSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RiskEvidenceSynthesis): List<T>

  public data object Context : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(RiskEvidenceSynthesis.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object ContextQuantity : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(RiskEvidenceSynthesis.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object ContextType : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RiskEvidenceSynthesis.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "RiskEvidenceSynthesis.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object ContextTypeValue : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "RiskEvidenceSynthesis.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Date : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "RiskEvidenceSynthesis.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Description : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RiskEvidenceSynthesis.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Effective : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "RiskEvidenceSynthesis.effectivePeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Identifier : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RiskEvidenceSynthesis.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Jurisdiction : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RiskEvidenceSynthesis.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Name : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RiskEvidenceSynthesis.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Publisher : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RiskEvidenceSynthesis.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Status : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RiskEvidenceSynthesis.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Title : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "RiskEvidenceSynthesis.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Url : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "RiskEvidenceSynthesis.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Version : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RiskEvidenceSynthesis.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the RiskEvidenceSynthesis resource type. */
    public val ALL: List<RiskEvidenceSynthesisSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Effective,
        Identifier,
        Jurisdiction,
        Name,
        Publisher,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
