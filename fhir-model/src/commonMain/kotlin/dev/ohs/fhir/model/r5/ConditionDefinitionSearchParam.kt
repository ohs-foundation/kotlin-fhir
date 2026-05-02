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

/** Search parameters for the [ConditionDefinition] resource type. */
public sealed class ConditionDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ConditionDefinition): List<T>

  public data object Context : ConditionDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(ConditionDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : ConditionDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(ConditionDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Any> = emptyList()
  }

  public data object ContextType : ConditionDefinitionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConditionDefinition.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ConditionDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ConditionDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : ConditionDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ConditionDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : ConditionDefinitionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ConditionDefinition.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : ConditionDefinitionSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ConditionDefinition.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier :
    ConditionDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConditionDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: ConditionDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Jurisdiction : ConditionDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConditionDefinition.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : ConditionDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ConditionDefinition.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : ConditionDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ConditionDefinition.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : ConditionDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConditionDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : ConditionDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ConditionDefinition.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : ConditionDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ConditionDefinition.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : ConditionDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ConditionDefinition.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the ConditionDefinition resource type. */
    public val ALL: List<ConditionDefinitionSearchParam<*>> =
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
        Status,
        Title,
        Url,
        Version,
      )
  }
}
