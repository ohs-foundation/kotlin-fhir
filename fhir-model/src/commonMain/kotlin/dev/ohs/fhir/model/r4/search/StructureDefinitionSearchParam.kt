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

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.StructureDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [StructureDefinition] resource type. */
public sealed class StructureDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: StructureDefinition): List<T>

  public data object Abstract : StructureDefinitionSearchParam<Boolean>() {
    public override val paramName: KotlinString = "abstract"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.abstract"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Boolean> =
      listOf(resource.abstract)
  }

  public data object Base : StructureDefinitionSearchParam<Canonical>() {
    public override val paramName: KotlinString = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "StructureDefinition.baseDefinition"

    public override val target: List<KotlinString> = listOf("StructureDefinition")

    public override fun extract(resource: StructureDefinition): List<Canonical> =
      listOfNotNull(resource.baseDefinition)
  }

  public data object BasePath : StructureDefinitionSearchParam<R4String>() {
    public override val paramName: KotlinString = "base-path"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.snapshot.element.base.path"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<R4String> =
      (resource.snapshot?.element ?: emptyList()).mapNotNull { it.base }.map { it.path }
  }

  public data object Context : StructureDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(StructureDefinition.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : StructureDefinitionSearchParam<Quantity>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(StructureDefinition.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : StructureDefinitionSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : StructureDefinitionSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "StructureDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : StructureDefinitionSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "StructureDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : StructureDefinitionSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "StructureDefinition.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Derivation : StructureDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "derivation"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.derivation"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> =
      listOfNotNull(resource.derivation)
  }

  public data object Description : StructureDefinitionSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureDefinition.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Experimental : StructureDefinitionSearchParam<Boolean>() {
    public override val paramName: KotlinString = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.experimental"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Boolean> =
      listOfNotNull(resource.experimental)
  }

  public data object ExtContext : StructureDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "ext-context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.context.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> =
      resource.context.map { it.type }
  }

  public data object Identifier :
    StructureDefinitionSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: StructureDefinition
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Jurisdiction : StructureDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Keyword : StructureDefinitionSearchParam<Coding>() {
    public override val paramName: KotlinString = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.keyword"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Coding> = resource.keyword
  }

  public data object Kind : StructureDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.kind"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = listOf(resource.kind)
  }

  public data object Name : StructureDefinitionSearchParam<R4String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureDefinition.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<R4String> =
      listOf(resource.name)
  }

  public data object Path : StructureDefinitionSearchParam<R4String>() {
    public override val paramName: KotlinString = "path"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.snapshot.element.path"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<R4String> =
      (resource.snapshot?.element ?: emptyList()).map { it.path }
  }

  public data object Publisher : StructureDefinitionSearchParam<R4String>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureDefinition.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : StructureDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : StructureDefinitionSearchParam<R4String>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureDefinition.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Type : StructureDefinitionSearchParam<Uri>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "StructureDefinition.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Uri> = listOf(resource.type)
  }

  public data object Url : StructureDefinitionSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "StructureDefinition.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<Uri> = listOf(resource.url)
  }

  public data object Valueset : StructureDefinitionSearchParam<Canonical>() {
    public override val paramName: KotlinString = "valueset"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "StructureDefinition.snapshot.element.binding.valueSet"

    public override val target: List<KotlinString> = listOf("ValueSet")

    public override fun extract(resource: StructureDefinition): List<Canonical> =
      (resource.snapshot?.element ?: emptyList())
        .mapNotNull { it.binding }
        .mapNotNull { it.valueSet }
  }

  public data object Version : StructureDefinitionSearchParam<R4String>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureDefinition.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureDefinition): List<R4String> =
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
