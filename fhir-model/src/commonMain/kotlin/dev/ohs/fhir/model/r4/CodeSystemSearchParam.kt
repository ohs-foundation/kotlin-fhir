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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CodeSystem] resource type. */
public sealed class CodeSystemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CodeSystem): List<T>

  public data object Code : CodeSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CodeSystem.concept.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = resource.concept.map { it.code }
  }

  public data object ContentMode : CodeSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "content-mode"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CodeSystem.content"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = listOf(resource.content)
  }

  public data object Context : CodeSystemSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(CodeSystem.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : CodeSystemSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(CodeSystem.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : CodeSystemSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CodeSystem.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : CodeSystemSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "CodeSystem.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : CodeSystemSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "CodeSystem.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<UsageContext> = resource.useContext
  }

  public data object Date : CodeSystemSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "CodeSystem.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : CodeSystemSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CodeSystem.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : CodeSystemSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CodeSystem.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : CodeSystemSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CodeSystem.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Language : CodeSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CodeSystem.concept.designation.language"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> =
      resource.concept.flatMap { it.designation }.mapNotNull { it.language }
  }

  public data object Name : CodeSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CodeSystem.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<String> = listOfNotNull(resource.name)
  }

  public data object Publisher : CodeSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CodeSystem.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : CodeSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CodeSystem.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = listOf(resource.status)
  }

  public data object Supplements : CodeSystemSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "supplements"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CodeSystem.supplements"

    public override val target: List<kotlin.String> = listOf("CodeSystem")

    public override fun extract(resource: CodeSystem): List<Canonical> =
      listOfNotNull(resource.supplements)
  }

  public data object System : CodeSystemSearchParam<Uri>() {
    public override val paramName: kotlin.String = "system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "CodeSystem.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Title : CodeSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CodeSystem.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<String> = listOfNotNull(resource.title)
  }

  public data object Url : CodeSystemSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "CodeSystem.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : CodeSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CodeSystem.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CodeSystem): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the CodeSystem resource type. */
    public val ALL: List<CodeSystemSearchParam<*>> =
      listOf(
        Code,
        ContentMode,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Identifier,
        Jurisdiction,
        Language,
        Name,
        Publisher,
        Status,
        Supplements,
        System,
        Title,
        Url,
        Version,
      )
  }
}
