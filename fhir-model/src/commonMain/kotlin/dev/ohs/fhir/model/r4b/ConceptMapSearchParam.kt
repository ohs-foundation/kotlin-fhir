/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ConceptMap] resource type. */
public sealed class ConceptMapSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ConceptMap): List<T>

  public data object Context : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(ConceptMap.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextQuantity : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(ConceptMap.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextType : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ConceptMap.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object ContextTypeValue : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ConceptMap.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Date : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ConceptMap.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Dependson : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "dependson"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ConceptMap.group.element.target.dependsOn.property"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Description : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ConceptMap.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Identifier : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Jurisdiction : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Name : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ConceptMap.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Other : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "other"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ConceptMap.group.unmapped.url"

    public override val target: List<String> = listOf("ConceptMap")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Product : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "product"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ConceptMap.group.element.target.product.property"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Publisher : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ConceptMap.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Source : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(ConceptMap.source as canonical)"

    public override val target: List<String> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object SourceCode : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "source-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.group.element.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object SourceSystem : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "source-system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ConceptMap.group.source"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object SourceUri : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "source-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(ConceptMap.source as uri)"

    public override val target: List<String> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Status : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Target : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(ConceptMap.target as canonical)"

    public override val target: List<String> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object TargetCode : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "target-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.group.element.target.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object TargetSystem : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "target-system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ConceptMap.group.target"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object TargetUri : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "target-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(ConceptMap.target as uri)"

    public override val target: List<String> = listOf("ValueSet")

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Title : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ConceptMap.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Url : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ConceptMap.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
  }

  public data object Version : ConceptMapSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ConceptMap.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ConceptMap): List<Any> = emptyList()
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
