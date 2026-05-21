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
import dev.ohs.fhir.model.r5.ConditionDefinition
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

/** Search parameters for the [ConditionDefinition] resource type. */
public object ConditionDefinitionSearchParam {
  /** All search parameters for the ConditionDefinition resource type. */
  public val ALL: List<SearchParam<ConditionDefinition, *>> =
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

  public data object Context : SearchParam<ConditionDefinition, Any> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ConditionDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<ConditionDefinition, Any> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(ConditionDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<ConditionDefinition, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConditionDefinition.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ConditionDefinition, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ConditionDefinition.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ConditionDefinition, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ConditionDefinition.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<ConditionDefinition, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ConditionDefinition.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<ConditionDefinition, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConditionDefinition.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier :
    SearchParam<ConditionDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConditionDefinition.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: ConditionDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Jurisdiction : SearchParam<ConditionDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConditionDefinition.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<ConditionDefinition, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConditionDefinition.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<ConditionDefinition, R5String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConditionDefinition.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<ConditionDefinition, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConditionDefinition.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<ConditionDefinition, R5String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConditionDefinition.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<ConditionDefinition, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ConditionDefinition.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<ConditionDefinition, R5String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConditionDefinition.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConditionDefinition): List<R5String> =
      listOfNotNull(resource.version)
  }
}
