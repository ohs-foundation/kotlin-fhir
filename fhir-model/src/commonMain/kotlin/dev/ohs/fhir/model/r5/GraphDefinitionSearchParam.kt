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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [GraphDefinition] resource type. */
public sealed class GraphDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: GraphDefinition): List<T>

  public data object Context : GraphDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(GraphDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : GraphDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(GraphDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object ContextType : GraphDefinitionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "GraphDefinition.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : GraphDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "GraphDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : GraphDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "GraphDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<UsageContext> = resource.useContext
  }

  public data object Date : GraphDefinitionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "GraphDefinition.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : GraphDefinitionSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "GraphDefinition.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : GraphDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "GraphDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : GraphDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "GraphDefinition.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : GraphDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "GraphDefinition.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<String> = listOf(resource.name)
  }

  public data object Publisher : GraphDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "GraphDefinition.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Start : GraphDefinitionSearchParam<Id>() {
    public override val paramName: kotlin.String = "start"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "GraphDefinition.start"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Id> = listOfNotNull(resource.start)
  }

  public data object Status : GraphDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "GraphDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = listOf(resource.status)
  }

  public data object Url : GraphDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "GraphDefinition.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : GraphDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "GraphDefinition.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: GraphDefinition): List<String> =
      listOfNotNull(resource.version)
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
