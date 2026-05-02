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

/** Search parameters for the [ActorDefinition] resource type. */
public sealed class ActorDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ActorDefinition): List<T>

  public data object Context : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(ActorDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(ActorDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object ContextType : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ActorDefinition.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ActorDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeValue : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ActorDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Date : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ActorDefinition.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Description : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ActorDefinition.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Identifier : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ActorDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Jurisdiction : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ActorDefinition.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Publisher : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ActorDefinition.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Status : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ActorDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Title : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ActorDefinition.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Type : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ActorDefinition.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Url : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ActorDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object Version : ActorDefinitionSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ActorDefinition.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ActorDefinition resource type. */
    public val ALL: List<ActorDefinitionSearchParam<*>> =
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
        Publisher,
        Status,
        Title,
        Type,
        Url,
        Version,
      )
  }
}
