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

/** Search parameters for the [ExampleScenario] resource type. */
public sealed class ExampleScenarioSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ExampleScenario): List<T>

  public data object Context : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(ExampleScenario.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object ContextQuantity : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(ExampleScenario.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object ContextType : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ExampleScenario.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ExampleScenario.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object ContextTypeValue : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ExampleScenario.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object Date : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ExampleScenario.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object Identifier : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ExampleScenario.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object Jurisdiction : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ExampleScenario.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object Name : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ExampleScenario.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object Publisher : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ExampleScenario.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object Status : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ExampleScenario.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object Url : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ExampleScenario.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object Version : ExampleScenarioSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ExampleScenario.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ExampleScenario resource type. */
    public val ALL: List<ExampleScenarioSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Identifier,
        Jurisdiction,
        Name,
        Publisher,
        Status,
        Url,
        Version,
      )
  }
}
