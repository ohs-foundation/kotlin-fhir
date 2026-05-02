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

/** Search parameters for the [StructureDefinition] resource type. */
public sealed class StructureDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: StructureDefinition): List<T>

  public data object Abstract : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "abstract"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.abstract"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Base : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "StructureDefinition.baseDefinition"

    public override val target: List<String> = listOf("StructureDefinition")

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object BasePath : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "base-path"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.snapshot.element.base.path"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Context : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(StructureDefinition.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(StructureDefinition.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object ContextType : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "StructureDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeValue : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "StructureDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Date : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "StructureDefinition.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Derivation : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "derivation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.derivation"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Description : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "StructureDefinition.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Experimental : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.experimental"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object ExtContext : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "ext-context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.context.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Identifier : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Jurisdiction : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Keyword : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.keyword"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Kind : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.kind"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Name : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "StructureDefinition.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Path : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "path"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.snapshot.element.path"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Publisher : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "StructureDefinition.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Status : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Title : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "StructureDefinition.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Type : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "StructureDefinition.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Url : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "StructureDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Valueset : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "valueset"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "StructureDefinition.snapshot.element.binding.valueSet"

    public override val target: List<String> = listOf("ValueSet")

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object Version : StructureDefinitionSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "StructureDefinition.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the StructureDefinition resource type. */
    public val ALL: List<StructureDefinitionSearchParam<*>> =
      listOf(
        Abstract,
        Base,
        BasePath,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Derivation,
        Description,
        Experimental,
        ExtContext,
        Identifier,
        Jurisdiction,
        Keyword,
        Kind,
        Name,
        Path,
        Publisher,
        Status,
        Title,
        Type,
        Url,
        Valueset,
        Version,
      )
  }
}
