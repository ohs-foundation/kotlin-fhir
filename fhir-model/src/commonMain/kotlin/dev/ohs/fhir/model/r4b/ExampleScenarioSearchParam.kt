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

/** Search parameters for the [ExampleScenario] resource type. */
public sealed class ExampleScenarioSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ExampleScenario): List<T>

  public data object Context : ExampleScenarioSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(ExampleScenario.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : ExampleScenarioSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(ExampleScenario.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : ExampleScenarioSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ExampleScenario.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ExampleScenarioSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ExampleScenario.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : ExampleScenarioSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ExampleScenario.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<UsageContext> = resource.useContext
  }

  public data object Date : ExampleScenarioSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ExampleScenario.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Identifier : ExampleScenarioSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ExampleScenario.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: ExampleScenario
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Jurisdiction : ExampleScenarioSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ExampleScenario.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : ExampleScenarioSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ExampleScenario.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : ExampleScenarioSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ExampleScenario.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : ExampleScenarioSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ExampleScenario.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = listOf(resource.status)
  }

  public data object Url : ExampleScenarioSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ExampleScenario.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : ExampleScenarioSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ExampleScenario.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExampleScenario): List<String> =
      listOfNotNull(resource.version)
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
