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

/** Search parameters for the [ActorDefinition] resource type. */
public sealed class ActorDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ActorDefinition): List<T>

  public data object Context : ActorDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(ActorDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : ActorDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(ActorDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object ContextType : ActorDefinitionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ActorDefinition.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ActorDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ActorDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : ActorDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ActorDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<UsageContext> = resource.useContext
  }

  public data object Date : ActorDefinitionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ActorDefinition.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : ActorDefinitionSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ActorDefinition.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : ActorDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ActorDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : ActorDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ActorDefinition.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Publisher : ActorDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ActorDefinition.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : ActorDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ActorDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : ActorDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ActorDefinition.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Type : ActorDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ActorDefinition.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = listOf(resource.type)
  }

  public data object Url : ActorDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ActorDefinition.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : ActorDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ActorDefinition.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ActorDefinition): List<String> =
      listOfNotNull(resource.version)
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
