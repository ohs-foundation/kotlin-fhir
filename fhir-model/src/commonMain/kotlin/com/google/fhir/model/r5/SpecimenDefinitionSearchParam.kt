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

/** Search parameters for the [SpecimenDefinition] resource type. */
public sealed class SpecimenDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SpecimenDefinition): List<T>

  public data object Container : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "container"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.typeTested.container.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public data object Experimental : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "experimental"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.experimental"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public data object Identifier : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public data object IsDerived : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "is-derived"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.typeTested.isDerived"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public data object Status : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public data object Title : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "SpecimenDefinition.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public data object Type : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.typeCollected"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public data object TypeTested : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "type-tested"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SpecimenDefinition.typeTested.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public data object Url : SpecimenDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "SpecimenDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SpecimenDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the SpecimenDefinition resource type. */
    public val ALL: List<SpecimenDefinitionSearchParam<*>> =
      listOf(Container, Experimental, Identifier, IsDerived, Status, Title, Type, TypeTested, Url)
  }
}
