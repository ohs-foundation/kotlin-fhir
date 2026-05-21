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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Evidence
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

/** Search parameters for the [Evidence] resource type. */
public object EvidenceSearchParam {
  /** All search parameters for the Evidence resource type. */
  public val ALL: List<SearchParam<Evidence, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Identifier,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )

  public data object Context : SearchParam<Evidence, Any> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(Evidence.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<Evidence, Any> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Evidence.useContext.value.ofType(Quantity))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<Evidence, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Evidence.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<Evidence, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Evidence.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<Evidence, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Evidence.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<Evidence, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Evidence.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<Evidence, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Evidence.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : SearchParam<Evidence, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Evidence.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Publisher : SearchParam<Evidence, R5String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Evidence.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<Evidence, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Evidence.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<Evidence, R5String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Evidence.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<R5String> = listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<Evidence, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Evidence.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<Evidence, R5String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Evidence.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Evidence): List<R5String> =
      listOfNotNull(resource.version)
  }
}
