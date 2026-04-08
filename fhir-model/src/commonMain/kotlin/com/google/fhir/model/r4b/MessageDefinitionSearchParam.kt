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

/** Search parameters for the [MessageDefinition] resource type. */
public sealed class MessageDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MessageDefinition): List<T>

  public data object Category : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageDefinition.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Context : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(MessageDefinition.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(MessageDefinition.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object ContextType : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageDefinition.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "MessageDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeValue : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "MessageDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Date : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MessageDefinition.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Description : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "MessageDefinition.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Event : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageDefinition.event"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Focus : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageDefinition.focus.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Identifier : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Jurisdiction : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageDefinition.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Name : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "MessageDefinition.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Parent : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MessageDefinition.parent"

    public override val target: List<String> = listOf("PlanDefinition", "ActivityDefinition")

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Publisher : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "MessageDefinition.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Status : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Title : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "MessageDefinition.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Url : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "MessageDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Version : MessageDefinitionSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MessageDefinition.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the MessageDefinition resource type. */
    public val ALL: List<MessageDefinitionSearchParam<*>> =
      listOf(
        Category,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Event,
        Focus,
        Identifier,
        Jurisdiction,
        Name,
        Parent,
        Publisher,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
