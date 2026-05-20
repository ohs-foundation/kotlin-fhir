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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Bundle
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Bundle] resource type. */
public object BundleSearchParam {
  /** All search parameters for the Bundle resource type. */
  public val ALL: List<SearchParam<Bundle, *>> =
    listOf(Composition, Identifier, Message, Timestamp, Type)

  public data object Composition : SearchParam<Bundle, Any> {
    public override val paramName: String = "composition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Bundle.entry[0].resource"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Bundle): List<Any> = emptyList()
  }

  public data object Identifier : SearchParam<Bundle, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Bundle.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Bundle): List<dev.ohs.fhir.model.r4b.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Message : SearchParam<Bundle, Any> {
    public override val paramName: String = "message"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Bundle.entry[0].resource"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Bundle): List<Any> = emptyList()
  }

  public data object Timestamp : SearchParam<Bundle, Instant> {
    public override val paramName: String = "timestamp"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Bundle.timestamp"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Bundle): List<Instant> = listOfNotNull(resource.timestamp)
  }

  public data object Type : SearchParam<Bundle, Any> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Bundle.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Bundle): List<Any> = listOf(resource.type)
  }
}
