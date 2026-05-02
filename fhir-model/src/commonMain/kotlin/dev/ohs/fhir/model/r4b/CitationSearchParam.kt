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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Citation] resource type. */
public sealed class CitationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Citation): List<T>

  public data object Context : CitationSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(Citation.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object ContextQuantity : CitationSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(Citation.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object ContextType : CitationSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Citation.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : CitationSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Citation.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object ContextTypeValue : CitationSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Citation.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Date : CitationSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Citation.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Description : CitationSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Citation.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Effective : CitationSearchParam<Any>() {
    public override val paramName: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Citation.effectivePeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Identifier : CitationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Citation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Jurisdiction : CitationSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Citation.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Name : CitationSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Citation.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Publisher : CitationSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Citation.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Status : CitationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Citation.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Title : CitationSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Citation.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Url : CitationSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Citation.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Version : CitationSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Citation.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Citation resource type. */
    public val ALL: List<CitationSearchParam<*>> =
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
