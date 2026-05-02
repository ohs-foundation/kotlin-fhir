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

/** Search parameters for the [ChargeItemDefinition] resource type. */
public sealed class ChargeItemDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ChargeItemDefinition): List<T>

  public data object Context : ChargeItemDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(ChargeItemDefinition.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : ChargeItemDefinitionSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(ChargeItemDefinition.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : ChargeItemDefinitionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ChargeItemDefinition.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ChargeItemDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ChargeItemDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : ChargeItemDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ChargeItemDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : ChargeItemDefinitionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ChargeItemDefinition.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : ChargeItemDefinitionSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ChargeItemDefinition.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : ChargeItemDefinitionSearchParam<Period>() {
    public override val paramName: kotlin.String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ChargeItemDefinition.effectivePeriod"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier :
    ChargeItemDefinitionSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ChargeItemDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: ChargeItemDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Jurisdiction : ChargeItemDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ChargeItemDefinition.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Publisher : ChargeItemDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ChargeItemDefinition.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ChargeItemDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : ChargeItemDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ChargeItemDefinition.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : ChargeItemDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ChargeItemDefinition.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Uri> = listOf(resource.url)
  }

  public data object Version : ChargeItemDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ChargeItemDefinition.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the ChargeItemDefinition resource type. */
    public val ALL: List<ChargeItemDefinitionSearchParam<*>> =
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
        Publisher,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
