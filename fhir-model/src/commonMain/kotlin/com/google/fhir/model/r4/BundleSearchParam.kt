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

/** Search parameters for the [Bundle] resource type. */
public sealed class BundleSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Bundle): List<T>

  public data object Composition : BundleSearchParam<Any>() {
    public override val paramName: String = "composition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Bundle.entry[0].resource"

    public override val target: List<String> = listOf("Composition")

    public override fun extract(resource: Bundle): List<Any> = emptyList()
  }

  public data object Identifier : BundleSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Bundle.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Bundle): List<Any> = emptyList()
  }

  public data object Message : BundleSearchParam<Any>() {
    public override val paramName: String = "message"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Bundle.entry[0].resource"

    public override val target: List<String> = listOf("MessageHeader")

    public override fun extract(resource: Bundle): List<Any> = emptyList()
  }

  public data object Timestamp : BundleSearchParam<Any>() {
    public override val paramName: String = "timestamp"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Bundle.timestamp"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Bundle): List<Any> = emptyList()
  }

  public data object Type : BundleSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Bundle.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Bundle): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Bundle resource type. */
    public val ALL: List<BundleSearchParam<*>> =
      listOf(Composition, Identifier, Message, Timestamp, Type)
  }
}
