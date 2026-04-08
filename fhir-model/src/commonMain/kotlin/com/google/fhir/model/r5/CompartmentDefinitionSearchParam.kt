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

/** Search parameters for the [CompartmentDefinition] resource type. */
public sealed class CompartmentDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CompartmentDefinition): List<T>

  public data object Code : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CompartmentDefinition.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Context : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(CompartmentDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String =
      "(CompartmentDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object ContextType : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CompartmentDefinition.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "CompartmentDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeValue : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "CompartmentDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Date : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CompartmentDefinition.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Description : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CompartmentDefinition.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Name : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CompartmentDefinition.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Publisher : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CompartmentDefinition.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Resource : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CompartmentDefinition.resource.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Status : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CompartmentDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Url : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "CompartmentDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public data object Version : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CompartmentDefinition.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the CompartmentDefinition resource type. */
    public val ALL: List<CompartmentDefinitionSearchParam<*>> =
      listOf(
        Code,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Name,
        Publisher,
        Resource,
        Status,
        Url,
        Version,
      )
  }
}
