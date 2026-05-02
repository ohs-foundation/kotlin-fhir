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

/** Search parameters for the [ValueSet] resource type. */
public sealed class ValueSetSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ValueSet): List<T>

  public data object Code : ValueSetSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ValueSet.expansion.contains.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Context : ValueSetSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(ValueSet.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object ContextQuantity : ValueSetSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(ValueSet.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object ContextType : ValueSetSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ValueSet.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : ValueSetSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ValueSet.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object ContextTypeValue : ValueSetSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ValueSet.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Date : ValueSetSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ValueSet.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Description : ValueSetSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ValueSet.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Expansion : ValueSetSearchParam<Any>() {
    public override val paramName: String = "expansion"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ValueSet.expansion.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Identifier : ValueSetSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ValueSet.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Jurisdiction : ValueSetSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ValueSet.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Name : ValueSetSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ValueSet.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Publisher : ValueSetSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ValueSet.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Reference : ValueSetSearchParam<Any>() {
    public override val paramName: String = "reference"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ValueSet.compose.include.system"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Status : ValueSetSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ValueSet.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Title : ValueSetSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ValueSet.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Url : ValueSetSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ValueSet.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public data object Version : ValueSetSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ValueSet.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ValueSet resource type. */
    public val ALL: List<ValueSetSearchParam<*>> =
      listOf(
        Code,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Expansion,
        Identifier,
        Jurisdiction,
        Name,
        Publisher,
        Reference,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
