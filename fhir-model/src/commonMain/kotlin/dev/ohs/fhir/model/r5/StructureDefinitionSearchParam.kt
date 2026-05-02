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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [StructureDefinition] resource type. */
public sealed class StructureDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: StructureDefinition): List<T>

  public data object Abstract : StructureDefinitionSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "abstract"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.abstract"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Boolean> =
      listOf(resource.abstract)
  }

  public data object Base : StructureDefinitionSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "StructureDefinition.baseDefinition"

    public override val target: List<kotlin.String> = listOf("StructureDefinition")

    public override fun extract(resource: StructureDefinition): List<Canonical> =
      listOfNotNull(resource.baseDefinition)
  }

  public data object BasePath : StructureDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "base-path"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.snapshot.element.base.path"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<String> =
      (resource.snapshot?.element ?: emptyList()).mapNotNull { it.base }.map { it.path }
  }

  public data object Context : StructureDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(StructureDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : StructureDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(StructureDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = emptyList()
  }

  public data object ContextType : StructureDefinitionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : StructureDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "StructureDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : StructureDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "StructureDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : StructureDefinitionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "StructureDefinition.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Derivation : StructureDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "derivation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.derivation"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> =
      listOfNotNull(resource.derivation)
  }

  public data object Description : StructureDefinitionSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "StructureDefinition.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Experimental : StructureDefinitionSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.experimental"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Boolean> =
      listOfNotNull(resource.experimental)
  }

  public data object ExtContext : StructureDefinitionSearchParam<StructureDefinition.Context>() {
    public override val paramName: kotlin.String = "ext-context"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "StructureDefinition.context"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<StructureDefinition.Context> =
      resource.context
  }

  public data object ExtContextExpression : StructureDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "ext-context-expression"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.context.expression"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<String> =
      resource.context.map { it.expression }
  }

  public data object ExtContextType : StructureDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "ext-context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.context.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> =
      resource.context.map { it.type }
  }

  public data object Identifier :
    StructureDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: StructureDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Jurisdiction : StructureDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Keyword : StructureDefinitionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.keyword"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Coding> = resource.keyword
  }

  public data object Kind : StructureDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.kind"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = listOf(resource.kind)
  }

  public data object Name : StructureDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "StructureDefinition.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<String> = listOf(resource.name)
  }

  public data object Path : StructureDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "path"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.snapshot.element.path"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<String> =
      (resource.snapshot?.element ?: emptyList()).map { it.path }
  }

  public data object Publisher : StructureDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "StructureDefinition.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : StructureDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : StructureDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "StructureDefinition.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Type : StructureDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "StructureDefinition.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Uri> = listOf(resource.type)
  }

  public data object Url : StructureDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "StructureDefinition.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Uri> = listOf(resource.url)
  }

  public data object Valueset : StructureDefinitionSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "valueset"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "StructureDefinition.snapshot.element.binding.valueSet"

    public override val target: List<kotlin.String> = listOf("ValueSet")

    public override fun extract(resource: StructureDefinition): List<Canonical> =
      (resource.snapshot?.element ?: emptyList())
        .mapNotNull { it.binding }
        .mapNotNull { it.valueSet }
  }

  public data object Version : StructureDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureDefinition.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureDefinition): List<String> =
      listOfNotNull(resource.version)
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
        ExtContextExpression,
        ExtContextType,
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
