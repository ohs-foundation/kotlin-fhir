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

/** Search parameters for the [SearchParameter] resource type. */
public sealed class SearchParameterSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SearchParameter): List<T>

  public data object Base : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SearchParameter.base"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Code : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SearchParameter.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Component : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "component"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SearchParameter.component.definition"

    public override val target: List<String> = listOf("SearchParameter")

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Context : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(SearchParameter.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(SearchParameter.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object ContextType : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SearchParameter.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "SearchParameter.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object ContextTypeValue : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "SearchParameter.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Date : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "SearchParameter.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object DerivedFrom : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "SearchParameter.derivedFrom"

    public override val target: List<String> = listOf("SearchParameter")

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Description : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "SearchParameter.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Jurisdiction : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SearchParameter.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Name : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "SearchParameter.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Publisher : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "SearchParameter.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Status : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SearchParameter.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Target : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SearchParameter.target"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Type : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SearchParameter.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Url : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "SearchParameter.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public data object Version : SearchParameterSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SearchParameter.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the SearchParameter resource type. */
    public val ALL: List<SearchParameterSearchParam<*>> =
      listOf(
        Base,
        Code,
        Component,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        DerivedFrom,
        Description,
        Jurisdiction,
        Name,
        Publisher,
        Status,
        Target,
        Type,
        Url,
        Version,
      )
  }
}
