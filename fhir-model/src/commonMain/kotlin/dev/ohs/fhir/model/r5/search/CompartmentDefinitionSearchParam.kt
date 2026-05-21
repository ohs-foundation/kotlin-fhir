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

import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.CompartmentDefinition
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [CompartmentDefinition] resource type. */
public object CompartmentDefinitionSearchParam {
  /** All search parameters for the CompartmentDefinition resource type. */
  public val ALL: List<SearchParam<CompartmentDefinition, *>> =
    listOf(
      Code,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Name,
      Publisher,
      Resource,
      Status,
      Url,
      Version,
    )

  public data object Code : SearchParam<CompartmentDefinition, Any> {
    public override val name: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.code"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = listOf(resource.code)
  }

  public data object Context : SearchParam<CompartmentDefinition, Any> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(CompartmentDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<CompartmentDefinition, Any> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(CompartmentDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<CompartmentDefinition, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.useContext.code"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<CompartmentDefinition, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "CompartmentDefinition.useContext"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<CompartmentDefinition, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "CompartmentDefinition.useContext"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<CompartmentDefinition, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "CompartmentDefinition.date"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<CompartmentDefinition, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CompartmentDefinition.description"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Name : SearchParam<CompartmentDefinition, R5String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CompartmentDefinition.name"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<R5String> =
      listOf(resource.name)
  }

  public data object Publisher : SearchParam<CompartmentDefinition, R5String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CompartmentDefinition.publisher"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Resource : SearchParam<CompartmentDefinition, Any> {
    public override val name: KotlinString = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.resource.code"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> =
      resource.resource.map { it.code }
  }

  public data object Status : SearchParam<CompartmentDefinition, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.status"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> =
      listOf(resource.status)
  }

  public data object Url : SearchParam<CompartmentDefinition, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "CompartmentDefinition.url"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Uri> = listOf(resource.url)
  }

  public data object Version : SearchParam<CompartmentDefinition, R5String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.version"

    public override val target: List<KClass<out dev.ohs.fhir.model.r5.Resource>> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<R5String> =
      listOfNotNull(resource.version)
  }
}
