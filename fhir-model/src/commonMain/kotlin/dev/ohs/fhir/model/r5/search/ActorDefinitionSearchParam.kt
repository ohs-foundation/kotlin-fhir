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

import dev.ohs.fhir.model.r5.ActorDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
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

/** Search parameters for the [ActorDefinition] resource type. */
public object ActorDefinitionSearchParam {
  /** All search parameters for the ActorDefinition resource type. */
  public val ALL: List<SearchParam<ActorDefinition, *>> =
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

  public data object Context : SearchParam<ActorDefinition, Any> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ActorDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<ActorDefinition, Any> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(ActorDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<ActorDefinition, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ActorDefinition.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ActorDefinition, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ActorDefinition.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ActorDefinition, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ActorDefinition.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<ActorDefinition, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ActorDefinition.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<ActorDefinition, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ActorDefinition.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : SearchParam<ActorDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ActorDefinition.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<ActorDefinition, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ActorDefinition.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Publisher : SearchParam<ActorDefinition, R5String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ActorDefinition.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<ActorDefinition, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ActorDefinition.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<ActorDefinition, R5String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ActorDefinition.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Type : SearchParam<ActorDefinition, Any> {
    public override val name: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ActorDefinition.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Any> = listOf(resource.type)
  }

  public data object Url : SearchParam<ActorDefinition, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ActorDefinition.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<ActorDefinition, R5String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ActorDefinition.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ActorDefinition): List<R5String> =
      listOfNotNull(resource.version)
  }
}
