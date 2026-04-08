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

/** Search parameters for the [SubstanceDefinition] resource type. */
public sealed class SubstanceDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SubstanceDefinition): List<T>

  public data object Classification : SubstanceDefinitionSearchParam<Any>() {
    public override val paramName: String = "classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SubstanceDefinition.classification"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<Any> = emptyList()
  }

  public data object Code : SubstanceDefinitionSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SubstanceDefinition.code.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<Any> = emptyList()
  }

  public data object Domain : SubstanceDefinitionSearchParam<Any>() {
    public override val paramName: String = "domain"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SubstanceDefinition.domain"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<Any> = emptyList()
  }

  public data object Identifier : SubstanceDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SubstanceDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<Any> = emptyList()
  }

  public data object Name : SubstanceDefinitionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "SubstanceDefinition.name.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubstanceDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the SubstanceDefinition resource type. */
    public val ALL: List<SubstanceDefinitionSearchParam<*>> =
      listOf(Classification, Code, Domain, Identifier, Name)
  }
}
