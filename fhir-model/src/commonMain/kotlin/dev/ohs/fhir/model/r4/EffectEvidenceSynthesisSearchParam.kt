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

/** Search parameters for the [EffectEvidenceSynthesis] resource type. */
public sealed class EffectEvidenceSynthesisSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: EffectEvidenceSynthesis): List<T>

  public data object Context : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(EffectEvidenceSynthesis.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object ContextQuantity : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String =
      "(EffectEvidenceSynthesis.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object ContextType : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EffectEvidenceSynthesis.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "EffectEvidenceSynthesis.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object ContextTypeValue : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "EffectEvidenceSynthesis.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Date : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "EffectEvidenceSynthesis.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Description : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EffectEvidenceSynthesis.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Effective : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "EffectEvidenceSynthesis.effectivePeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Identifier : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EffectEvidenceSynthesis.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Jurisdiction : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EffectEvidenceSynthesis.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Name : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EffectEvidenceSynthesis.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Publisher : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EffectEvidenceSynthesis.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Status : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EffectEvidenceSynthesis.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Title : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EffectEvidenceSynthesis.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Url : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "EffectEvidenceSynthesis.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public data object Version : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EffectEvidenceSynthesis.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the EffectEvidenceSynthesis resource type. */
    public val ALL: List<EffectEvidenceSynthesisSearchParam<*>> =
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
