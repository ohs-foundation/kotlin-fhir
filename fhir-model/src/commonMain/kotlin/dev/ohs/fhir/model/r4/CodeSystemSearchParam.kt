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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CodeSystem] resource type. */
public sealed class CodeSystemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CodeSystem): List<T>

  public data object Code : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CodeSystem.concept.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object ContentMode : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "content-mode"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CodeSystem.content"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Context : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(CodeSystem.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object ContextQuantity : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(CodeSystem.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object ContextType : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CodeSystem.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "CodeSystem.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object ContextTypeValue : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "CodeSystem.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Date : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CodeSystem.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Description : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CodeSystem.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Identifier : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CodeSystem.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Jurisdiction : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CodeSystem.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Language : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CodeSystem.concept.designation.language"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Name : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CodeSystem.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Publisher : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CodeSystem.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Status : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CodeSystem.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Supplements : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "supplements"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CodeSystem.supplements"

    public override val target: List<String> = listOf("CodeSystem")

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object System : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "system"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "CodeSystem.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Title : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CodeSystem.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Url : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "CodeSystem.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
  }

  public data object Version : CodeSystemSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CodeSystem.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CodeSystem): List<Any> = emptyList()
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
