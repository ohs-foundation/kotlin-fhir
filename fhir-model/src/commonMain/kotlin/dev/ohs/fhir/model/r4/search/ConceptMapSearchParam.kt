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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ConceptMap
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [ConceptMap] resource type. */
public object ConceptMapSearchParam {
  /** All search parameters for the ConceptMap resource type. */
  public val ALL: List<SearchParam<ConceptMap, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Dependson,
      Description,
      Identifier,
      Jurisdiction,
      Name,
      Other,
      Product,
      Publisher,
      Source,
      SourceCode,
      SourceSystem,
      SourceUri,
      Status,
      Target,
      TargetCode,
      TargetSystem,
      TargetUri,
      Title,
      Url,
      Version,
    )

  public data object Context : SearchParam<ConceptMap, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ConceptMap.useContext.value as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<ConceptMap, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(ConceptMap.useContext.value as Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<ConceptMap, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ConceptMap, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ConceptMap.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ConceptMap, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ConceptMap.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<ConceptMap, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ConceptMap.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Dependson : SearchParam<ConceptMap, Uri> {
    public override val paramName: KotlinString = "dependson"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString =
      "ConceptMap.group.element.target.dependsOn.property"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      resource.group
        .flatMap { it.element }
        .flatMap { it.target }
        .flatMap { it.dependsOn }
        .map { it.property }
  }

  public data object Description : SearchParam<ConceptMap, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConceptMap.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : SearchParam<ConceptMap, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<dev.ohs.fhir.model.r4.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Jurisdiction : SearchParam<ConceptMap, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : SearchParam<ConceptMap, R4String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConceptMap.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<R4String> = listOfNotNull(resource.name)
  }

  public data object Other : SearchParam<ConceptMap, Canonical> {
    public override val paramName: KotlinString = "other"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ConceptMap.group.unmapped.url"

    public override val target: List<KClass<out Resource>> = listOf(ConceptMap::class)

    public override fun extract(resource: ConceptMap): List<Canonical> =
      resource.group.mapNotNull { it.unmapped }.mapNotNull { it.url }
  }

  public data object Product : SearchParam<ConceptMap, Any> {
    public override val paramName: KotlinString = "product"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString =
      "ConceptMap.group.element.target.product.property"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Publisher : SearchParam<ConceptMap, R4String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConceptMap.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Source : SearchParam<ConceptMap, Canonical> {
    public override val paramName: KotlinString = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(ConceptMap.source as canonical)"

    public override val target: List<KClass<out Resource>> = listOf(ValueSet::class)

    public override fun extract(resource: ConceptMap): List<Canonical> =
      listOfNotNull((resource.source as? ConceptMap.Source.Canonical)?.value)
  }

  public data object SourceCode : SearchParam<ConceptMap, Any> {
    public override val paramName: KotlinString = "source-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.group.element.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> =
      resource.group.flatMap { it.element }.mapNotNull { it.code }
  }

  public data object SourceSystem : SearchParam<ConceptMap, Uri> {
    public override val paramName: KotlinString = "source-system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ConceptMap.group.source"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      resource.group.mapNotNull { it.source }
  }

  public data object SourceUri : SearchParam<ConceptMap, Uri> {
    public override val paramName: KotlinString = "source-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(ConceptMap.source as uri)"

    public override val target: List<KClass<out Resource>> = listOf(ValueSet::class)

    public override fun extract(resource: ConceptMap): List<Uri> =
      listOfNotNull((resource.source as? ConceptMap.Source.Uri)?.value)
  }

  public data object Status : SearchParam<ConceptMap, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = listOf(resource.status)
  }

  public data object Target : SearchParam<ConceptMap, Canonical> {
    public override val paramName: KotlinString = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(ConceptMap.target as canonical)"

    public override val target: List<KClass<out Resource>> = listOf(ValueSet::class)

    public override fun extract(resource: ConceptMap): List<Canonical> =
      listOfNotNull((resource.target as? ConceptMap.Target.Canonical)?.value)
  }

  public data object TargetCode : SearchParam<ConceptMap, Any> {
    public override val paramName: KotlinString = "target-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.group.element.target.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> =
      resource.group.flatMap { it.element }.flatMap { it.target }.mapNotNull { it.code }
  }

  public data object TargetSystem : SearchParam<ConceptMap, Uri> {
    public override val paramName: KotlinString = "target-system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ConceptMap.group.target"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      resource.group.mapNotNull { it.target }
  }

  public data object TargetUri : SearchParam<ConceptMap, Uri> {
    public override val paramName: KotlinString = "target-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(ConceptMap.target as uri)"

    public override val target: List<KClass<out Resource>> = listOf(ValueSet::class)

    public override fun extract(resource: ConceptMap): List<Uri> =
      listOfNotNull((resource.target as? ConceptMap.Target.Uri)?.value)
  }

  public data object Title : SearchParam<ConceptMap, R4String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConceptMap.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<ConceptMap, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ConceptMap.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<ConceptMap, R4String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ConceptMap): List<R4String> =
      listOfNotNull(resource.version)
  }
}
