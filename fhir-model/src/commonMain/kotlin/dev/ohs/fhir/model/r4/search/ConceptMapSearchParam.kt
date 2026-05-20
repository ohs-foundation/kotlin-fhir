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
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ConceptMap] resource type. */
public sealed class ConceptMapSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ConceptMap): List<T>

  public data object Context : ConceptMapSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ConceptMap.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : ConceptMapSearchParam<Quantity>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(ConceptMap.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : ConceptMapSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ConceptMapSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ConceptMap.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : ConceptMapSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ConceptMap.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<UsageContext> = resource.useContext
  }

  public data object Date : ConceptMapSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ConceptMap.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Dependson : ConceptMapSearchParam<Uri>() {
    public override val paramName: KotlinString = "dependson"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString =
      "ConceptMap.group.element.target.dependsOn.property"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      resource.group
        .flatMap { it.element }
        .flatMap { it.target }
        .flatMap { it.dependsOn }
        .map { it.property }
  }

  public data object Description : ConceptMapSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConceptMap.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : ConceptMapSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<dev.ohs.fhir.model.r4.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Jurisdiction : ConceptMapSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : ConceptMapSearchParam<R4String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConceptMap.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<R4String> = listOfNotNull(resource.name)
  }

  public data object Other : ConceptMapSearchParam<Canonical>() {
    public override val paramName: KotlinString = "other"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ConceptMap.group.unmapped.url"

    public override val target: List<KotlinString> = listOf("ConceptMap")

    public override fun extract(resource: ConceptMap): List<Canonical> =
      resource.group.mapNotNull { it.unmapped }.mapNotNull { it.url }
  }

  public data object Product : ConceptMapSearchParam<Any>() {
    public override val paramName: KotlinString = "product"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString =
      "ConceptMap.group.element.target.product.property"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Publisher : ConceptMapSearchParam<R4String>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConceptMap.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Source : ConceptMapSearchParam<Canonical>() {
    public override val paramName: KotlinString = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(ConceptMap.source as canonical)"

    public override val target: List<KotlinString> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Canonical> =
      listOfNotNull((resource.source as? ConceptMap.Source.Canonical)?.value)
  }

  public data object SourceCode : ConceptMapSearchParam<Any>() {
    public override val paramName: KotlinString = "source-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.group.element.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> =
      resource.group.flatMap { it.element }.mapNotNull { it.code }
  }

  public data object SourceSystem : ConceptMapSearchParam<Uri>() {
    public override val paramName: KotlinString = "source-system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ConceptMap.group.source"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      resource.group.mapNotNull { it.source }
  }

  public data object SourceUri : ConceptMapSearchParam<Uri>() {
    public override val paramName: KotlinString = "source-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(ConceptMap.source as uri)"

    public override val target: List<KotlinString> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Uri> =
      listOfNotNull((resource.source as? ConceptMap.Source.Uri)?.value)
  }

  public data object Status : ConceptMapSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = listOf(resource.status)
  }

  public data object Target : ConceptMapSearchParam<Canonical>() {
    public override val paramName: KotlinString = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(ConceptMap.target as canonical)"

    public override val target: List<KotlinString> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Canonical> =
      listOfNotNull((resource.target as? ConceptMap.Target.Canonical)?.value)
  }

  public data object TargetCode : ConceptMapSearchParam<Any>() {
    public override val paramName: KotlinString = "target-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.group.element.target.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> =
      resource.group.flatMap { it.element }.flatMap { it.target }.mapNotNull { it.code }
  }

  public data object TargetSystem : ConceptMapSearchParam<Uri>() {
    public override val paramName: KotlinString = "target-system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ConceptMap.group.target"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> =
      resource.group.mapNotNull { it.target }
  }

  public data object TargetUri : ConceptMapSearchParam<Uri>() {
    public override val paramName: KotlinString = "target-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(ConceptMap.target as uri)"

    public override val target: List<KotlinString> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Uri> =
      listOfNotNull((resource.target as? ConceptMap.Target.Uri)?.value)
  }

  public data object Title : ConceptMapSearchParam<R4String>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ConceptMap.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : ConceptMapSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ConceptMap.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : ConceptMapSearchParam<R4String>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ConceptMap.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ConceptMap): List<R4String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the ConceptMap resource type. */
    public val ALL: List<ConceptMapSearchParam<*>> =
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
  }
}
