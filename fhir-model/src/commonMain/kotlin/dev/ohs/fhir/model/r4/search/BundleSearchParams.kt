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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Bundle
import dev.ohs.fhir.model.r4.Composition
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.MessageHeader
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Bundle] resource type. */
public object BundleSearchParams {
  public val composition: SearchParam<Bundle, Any> =
    SearchParam(
      name = "composition",
      type = SearchParamType.fromCode("reference"),
      expression = "Bundle.entry[0].resource",
      target = listOf(Composition::class),
      extractor = {
        throw NotImplementedError(
          "Search parameter 'composition' has expression 'Bundle.entry[0].resource' which is not yet supported."
        )
      },
    )

  public val identifier: SearchParam<Bundle, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Bundle.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val message: SearchParam<Bundle, Any> =
    SearchParam(
      name = "message",
      type = SearchParamType.fromCode("reference"),
      expression = "Bundle.entry[0].resource",
      target = listOf(MessageHeader::class),
      extractor = {
        throw NotImplementedError(
          "Search parameter 'message' has expression 'Bundle.entry[0].resource' which is not yet supported."
        )
      },
    )

  public val timestamp: SearchParam<Bundle, Instant> =
    SearchParam(
      name = "timestamp",
      type = SearchParamType.fromCode("date"),
      expression = "Bundle.timestamp",
      extractor = { resource -> listOfNotNull(resource.timestamp) },
    )

  public val type: SearchParam<Bundle, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Bundle.type",
      extractor = { resource -> listOf(resource.type) },
    )

  /** All search parameters for the Bundle resource type. */
  public val all: List<SearchParam<Bundle, *>> =
    listOf(composition, identifier, message, timestamp, type)
}
