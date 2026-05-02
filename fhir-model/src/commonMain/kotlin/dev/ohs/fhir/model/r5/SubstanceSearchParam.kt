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

/** Search parameters for the [Substance] resource type. */
public sealed class SubstanceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Substance): List<T>

  public data object Category : SubstanceSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }

  public data object Code : SubstanceSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.code.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }

  public data object CodeReference : SubstanceSearchParam<Any>() {
    public override val paramName: String = "code-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Substance.code.reference"

    public override val target: List<String> = listOf("SubstanceDefinition")

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }

  public data object Expiry : SubstanceSearchParam<Any>() {
    public override val paramName: String = "expiry"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Substance.expiry"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }

  public data object Identifier : SubstanceSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }

  public data object Quantity : SubstanceSearchParam<Any>() {
    public override val paramName: String = "quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Substance.quantity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }

  public data object Status : SubstanceSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }

  public data object SubstanceReference : SubstanceSearchParam<Any>() {
    public override val paramName: String = "substance-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(Substance.ingredient.substance.ofType(Reference))"

    public override val target: List<String> = listOf("Substance")

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Substance resource type. */
    public val ALL: List<SubstanceSearchParam<*>> =
      listOf(
        Category,
        Code,
        CodeReference,
        Expiry,
        Identifier,
        Quantity,
        Status,
        SubstanceReference,
      )
  }
}
