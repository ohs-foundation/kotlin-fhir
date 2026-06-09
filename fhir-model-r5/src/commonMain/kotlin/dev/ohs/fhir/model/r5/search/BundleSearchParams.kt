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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Bundle
import dev.ohs.fhir.model.r5.Composition
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.MessageHeader
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Bundle] resource type. */
public object BundleSearchParams {
  public val composition: SearchParam<Bundle, Any> =
    SearchParam(
      name = "composition",
      type = SearchParamType.Reference,
      expression = "Bundle.entry[0].resource as Composition",
      target = listOf(Composition::class),
      extractor = {
        throw NotImplementedError(
          "Search parameter 'composition' has expression 'Bundle.entry[0].resource as Composition' which is not yet supported."
        )
      },
    )

  public val exampleConstraint: SearchParam<Bundle, Any> =
    SearchParam(
      name = "example-constraint",
      type = SearchParamType.Reference,
      expression = "Bundle.entry[0].resource",
      target = listOf(Composition::class),
      extractor = {
        throw NotImplementedError(
          "Search parameter 'example-constraint' has expression 'Bundle.entry[0].resource' which is not yet supported."
        )
      },
    )

  public val identifier: SearchParam<Bundle, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Bundle.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val message: SearchParam<Bundle, Any> =
    SearchParam(
      name = "message",
      type = SearchParamType.Reference,
      expression = "Bundle.entry[0].resource as MessageHeader",
      target = listOf(MessageHeader::class),
      extractor = {
        throw NotImplementedError(
          "Search parameter 'message' has expression 'Bundle.entry[0].resource as MessageHeader' which is not yet supported."
        )
      },
    )

  public val timestamp: SearchParam<Bundle, Instant> =
    SearchParam(
      name = "timestamp",
      type = SearchParamType.Date,
      expression = "Bundle.timestamp",
      extractor = { resource -> listOfNotNull(resource.timestamp) },
    )

  public val type: SearchParam<Bundle, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "Bundle.type",
      extractor = { resource -> listOf(resource.type) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Bundle, *>> =
    listOf(composition, exampleConstraint, message)

  /**
   * Supported search parameters for the Bundle resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Bundle, *>> = listOf(identifier, timestamp, type)
}
