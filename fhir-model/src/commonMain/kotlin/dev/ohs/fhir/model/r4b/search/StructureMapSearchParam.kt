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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.StructureMap
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [StructureMap] resource type. */
public object StructureMapSearchParam {
  /** All search parameters for the StructureMap resource type. */
  public val ALL: List<SearchParam<StructureMap, *>> =
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

  public data object Context : SearchParam<StructureMap, CodeableConcept> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(StructureMap.useContext.value as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<StructureMap, Quantity> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(StructureMap.useContext.value as Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<StructureMap, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<StructureMap, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "StructureMap.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<StructureMap, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "StructureMap.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<StructureMap, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "StructureMap.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<StructureMap, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureMap.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : SearchParam<StructureMap, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<StructureMap, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<StructureMap, R4bString> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureMap.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<R4bString> = listOf(resource.name)
  }

  public data object Publisher : SearchParam<StructureMap, R4bString> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureMap.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<R4bString> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<StructureMap, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<StructureMap, R4bString> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureMap.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<R4bString> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<StructureMap, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "StructureMap.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<Uri> = listOf(resource.url)
  }

  public data object Version : SearchParam<StructureMap, R4bString> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: StructureMap): List<R4bString> =
      listOfNotNull(resource.version)
  }
}
