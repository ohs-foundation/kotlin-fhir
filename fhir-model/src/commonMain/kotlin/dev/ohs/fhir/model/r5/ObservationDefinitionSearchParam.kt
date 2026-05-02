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

/** Search parameters for the [ObservationDefinition] resource type. */
public sealed class ObservationDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ObservationDefinition): List<T>

  public data object Category : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ObservationDefinition.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> = emptyList()
  }

  public data object Code : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ObservationDefinition.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> = emptyList()
  }

  public data object Experimental : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: String = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ObservationDefinition.experimental"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> = emptyList()
  }

  public data object Identifier : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ObservationDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> = emptyList()
  }

  public data object Method : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: String = "method"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ObservationDefinition.method"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> = emptyList()
  }

  public data object Status : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ObservationDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> = emptyList()
  }

  public data object Title : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ObservationDefinition.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> = emptyList()
  }

  public data object Url : ObservationDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "ObservationDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ObservationDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ObservationDefinition resource type. */
    public val ALL: List<ObservationDefinitionSearchParam<*>> =
      listOf(Category, Code, Experimental, Identifier, Method, Status, Title, Url)
  }
}
