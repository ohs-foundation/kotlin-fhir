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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.ExampleScenario
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ExampleScenario] resource type. */
public object ExampleScenarioSearchParam {
  /** All search parameters for the ExampleScenario resource type. */
  public val ALL: List<SearchParam<ExampleScenario, *>> =
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

  public data object Context : SearchParam<ExampleScenario, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ExampleScenario.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<ExampleScenario, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(ExampleScenario.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<ExampleScenario, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ExampleScenario, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ExampleScenario.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ExampleScenario, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ExampleScenario.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<ExampleScenario, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ExampleScenario.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Identifier : SearchParam<ExampleScenario, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<ExampleScenario, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<ExampleScenario, R4String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ExampleScenario.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<ExampleScenario, R4String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ExampleScenario.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<ExampleScenario, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = listOf(resource.status)
  }

  public data object Url : SearchParam<ExampleScenario, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ExampleScenario.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<ExampleScenario, R4String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExampleScenario): List<R4String> =
      listOfNotNull(resource.version)
  }
}
