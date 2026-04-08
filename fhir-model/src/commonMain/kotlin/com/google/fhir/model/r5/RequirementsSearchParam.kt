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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Requirements] resource type. */
public sealed class RequirementsSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Requirements): List<T>

  public data object Actor : RequirementsSearchParam<Any>() {
    public override val paramName: String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Requirements.actor"

    public override val target: List<String> = listOf("ActorDefinition")

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Context : RequirementsSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(Requirements.useContext.value.ofType(CodeableConcept))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object ContextQuantity : RequirementsSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(Requirements.useContext.value.ofType(Quantity))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object ContextType : RequirementsSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Requirements.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : RequirementsSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Requirements.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object ContextTypeValue : RequirementsSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Requirements.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Date : RequirementsSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Requirements.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object DerivedFrom : RequirementsSearchParam<Any>() {
    public override val paramName: String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Requirements.derivedFrom"

    public override val target: List<String> = listOf("Requirements")

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Description : RequirementsSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Requirements.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Identifier : RequirementsSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Requirements.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Jurisdiction : RequirementsSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Requirements.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Name : RequirementsSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Requirements.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Publisher : RequirementsSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Requirements.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Status : RequirementsSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Requirements.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Title : RequirementsSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Requirements.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Url : RequirementsSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Requirements.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object Version : RequirementsSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Requirements.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Requirements resource type. */
    public val ALL: List<RequirementsSearchParam<*>> =
      listOf(
        Actor,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        DerivedFrom,
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
  }
}
