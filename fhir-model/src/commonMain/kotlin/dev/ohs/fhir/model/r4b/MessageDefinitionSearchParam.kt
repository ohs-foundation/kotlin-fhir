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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MessageDefinition] resource type. */
public sealed class MessageDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MessageDefinition): List<T>

  public data object Category : MessageDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageDefinition.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> =
      listOfNotNull(resource.category)
  }

  public data object Context : MessageDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(MessageDefinition.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : MessageDefinitionSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(MessageDefinition.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : MessageDefinitionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageDefinition.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : MessageDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "MessageDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : MessageDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "MessageDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : MessageDefinitionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "MessageDefinition.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<DateTime> = listOf(resource.date)
  }

  public data object Description : MessageDefinitionSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "MessageDefinition.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Event : MessageDefinitionSearchParam<MessageDefinition.Event>() {
    public override val paramName: kotlin.String = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageDefinition.event"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<MessageDefinition.Event> =
      listOf(resource.event)
  }

  public data object Focus : MessageDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageDefinition.focus.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> =
      resource.focus.map { it.code }
  }

  public data object Identifier :
    MessageDefinitionSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: MessageDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Jurisdiction : MessageDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageDefinition.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : MessageDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "MessageDefinition.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Parent : MessageDefinitionSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MessageDefinition.parent"

    public override val target: List<kotlin.String> = listOf("PlanDefinition", "ActivityDefinition")

    public override fun extract(resource: MessageDefinition): List<Canonical> = resource.parent
  }

  public data object Publisher : MessageDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "MessageDefinition.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : MessageDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : MessageDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "MessageDefinition.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : MessageDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "MessageDefinition.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : MessageDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MessageDefinition.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MessageDefinition): List<String> =
      listOfNotNull(resource.version)
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
