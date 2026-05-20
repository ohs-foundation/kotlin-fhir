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
import dev.ohs.fhir.model.r5.GraphDefinition
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

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
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Start,
      Status,
      Url,
      Version,
    )

  public data object Context : SearchParam<GraphDefinition, Any> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(GraphDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<GraphDefinition, Any> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(GraphDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<GraphDefinition, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<GraphDefinition, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "GraphDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<GraphDefinition, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "GraphDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<GraphDefinition, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "GraphDefinition.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<GraphDefinition, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "GraphDefinition.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : SearchParam<GraphDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<GraphDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<GraphDefinition, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "GraphDefinition.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<R5String> = listOf(resource.name)
  }

  public data object Publisher : SearchParam<GraphDefinition, R5String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "GraphDefinition.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Start : SearchParam<GraphDefinition, Id> {
    public override val paramName: KotlinString = "start"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.start"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Id> = listOfNotNull(resource.start)
  }

  public data object Status : SearchParam<GraphDefinition, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Any> = listOf(resource.status)
  }

  public data object Url : SearchParam<GraphDefinition, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "GraphDefinition.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<GraphDefinition, R5String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "GraphDefinition.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: GraphDefinition): List<R5String> =
      listOfNotNull(resource.version)
  }
}
