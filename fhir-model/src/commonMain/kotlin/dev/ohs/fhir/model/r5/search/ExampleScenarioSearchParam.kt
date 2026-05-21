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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.ExampleScenario
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

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

  public data object Context : SearchParam<ExampleScenario, Any> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ExampleScenario.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<ExampleScenario, Any> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(ExampleScenario.useContext.value.ofType(Quantity))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<ExampleScenario, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ExampleScenario, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ExampleScenario.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ExampleScenario, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ExampleScenario.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<ExampleScenario, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ExampleScenario.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Identifier : SearchParam<ExampleScenario, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<ExampleScenario, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<ExampleScenario, R5String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ExampleScenario.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<ExampleScenario, R5String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ExampleScenario.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<ExampleScenario, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Any> = listOf(resource.status)
  }

  public data object Url : SearchParam<ExampleScenario, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ExampleScenario.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<ExampleScenario, R5String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExampleScenario.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ExampleScenario): List<R5String> =
      listOfNotNull(resource.version)
  }
}
