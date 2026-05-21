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
import dev.ohs.fhir.model.r4.GraphDefinition
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [GraphDefinition] resource type. */
public object GraphDefinitionSearchParam {
  /** All search parameters for the GraphDefinition resource type. */
  public val ALL: List<SearchParam<GraphDefinition, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Jurisdiction,
      Name,
      Publisher,
      Start,
      Status,
      Url,
      Version,
    )

  public data object Context : SearchParam<GraphDefinition, CodeableConcept> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(GraphDefinition.useContext.value as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<GraphDefinition, Quantity> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(GraphDefinition.useContext.value as Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<GraphDefinition, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<GraphDefinition, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "GraphDefinition.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<GraphDefinition, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "GraphDefinition.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<GraphDefinition, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "GraphDefinition.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<GraphDefinition, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "GraphDefinition.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Jurisdiction : SearchParam<GraphDefinition, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<GraphDefinition, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "GraphDefinition.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<R4String> = listOf(resource.name)
  }

  public data object Publisher : SearchParam<GraphDefinition, R4String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "GraphDefinition.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Start : SearchParam<GraphDefinition, Any> {
    public override val name: KotlinString = "start"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.start"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = listOf(resource.start)
  }

  public data object Status : SearchParam<GraphDefinition, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = listOf(resource.status)
  }

  public data object Url : SearchParam<GraphDefinition, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "GraphDefinition.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<GraphDefinition, R4String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GraphDefinition): List<R4String> =
      listOfNotNull(resource.version)
  }
}
