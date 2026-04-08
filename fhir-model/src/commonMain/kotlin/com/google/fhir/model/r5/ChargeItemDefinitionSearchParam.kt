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

/** Search parameters for the [ChargeItemDefinition] resource type. */
public sealed class ChargeItemDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ChargeItemDefinition): List<T>

  public data object Context : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(ChargeItemDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String =
      "(ChargeItemDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object ContextType : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItemDefinition.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ChargeItemDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeValue : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ChargeItemDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Date : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ChargeItemDefinition.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Description : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ChargeItemDefinition.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Effective : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ChargeItemDefinition.applicability.effectivePeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Identifier : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItemDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Jurisdiction : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItemDefinition.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Publisher : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ChargeItemDefinition.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Status : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItemDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Title : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ChargeItemDefinition.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Url : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ChargeItemDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object Version : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItemDefinition.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
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
