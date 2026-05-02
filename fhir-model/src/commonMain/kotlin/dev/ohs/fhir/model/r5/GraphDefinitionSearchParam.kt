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

/** Search parameters for the [GraphDefinition] resource type. */
public sealed class GraphDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: GraphDefinition): List<T>

  public data object Context : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(GraphDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(GraphDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object ContextType : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GraphDefinition.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "GraphDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeValue : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "GraphDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Date : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "GraphDefinition.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Description : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "GraphDefinition.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Identifier : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GraphDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Jurisdiction : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GraphDefinition.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Name : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "GraphDefinition.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Publisher : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "GraphDefinition.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Start : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "start"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GraphDefinition.start"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Status : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GraphDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Url : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "GraphDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object Version : GraphDefinitionSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GraphDefinition.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the GraphDefinition resource type. */
    public val ALL: List<GraphDefinitionSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Identifier,
        Jurisdiction,
        Name,
        Publisher,
        Start,
        Status,
        Url,
        Version,
      )
  }
}
