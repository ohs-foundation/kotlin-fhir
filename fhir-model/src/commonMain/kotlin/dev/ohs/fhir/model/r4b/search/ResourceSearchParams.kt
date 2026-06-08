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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Resource] resource type. */
public object ResourceSearchParams {
  public val _content: SearchParam<Resource, Any> =
    SearchParam(
      name = "_content",
      type = SearchParamType.String,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter '_content' has expression '' which is not yet supported."
        )
      },
    )

  public val _filter: SearchParam<Resource, Any> =
    SearchParam(
      name = "_filter",
      type = SearchParamType.Special,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter '_filter' has expression '' which is not yet supported."
        )
      },
    )

  public val _has: SearchParam<Resource, Any> =
    SearchParam(
      name = "_has",
      type = SearchParamType.String,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter '_has' has expression '' which is not yet supported."
        )
      },
    )

  public val _id: SearchParam<Resource, Any> =
    SearchParam(
      name = "_id",
      type = SearchParamType.Token,
      expression = "id",
      extractor = {
        throw NotImplementedError(
          "Search parameter '_id' has expression 'id' which is not yet supported."
        )
      },
    )

  public val _lastUpdated: SearchParam<Resource, Instant> =
    SearchParam(
      name = "_lastUpdated",
      type = SearchParamType.Date,
      expression = "Resource.meta.lastUpdated",
      extractor = { resource -> listOfNotNull(resource.meta?.lastUpdated) },
    )

  public val _list: SearchParam<Resource, Any> =
    SearchParam(
      name = "_list",
      type = SearchParamType.String,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter '_list' has expression '' which is not yet supported."
        )
      },
    )

  public val _profile: SearchParam<Resource, Canonical> =
    SearchParam(
      name = "_profile",
      type = SearchParamType.Uri,
      expression = "Resource.meta.profile",
      extractor = { resource -> resource.meta?.profile ?: emptyList() },
    )

  public val _query: SearchParam<Resource, Any> =
    SearchParam(
      name = "_query",
      type = SearchParamType.Token,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter '_query' has expression '' which is not yet supported."
        )
      },
    )

  public val _security: SearchParam<Resource, Coding> =
    SearchParam(
      name = "_security",
      type = SearchParamType.Token,
      expression = "Resource.meta.security",
      extractor = { resource -> resource.meta?.security ?: emptyList() },
    )

  public val _source: SearchParam<Resource, Uri> =
    SearchParam(
      name = "_source",
      type = SearchParamType.Uri,
      expression = "Resource.meta.source",
      extractor = { resource -> listOfNotNull(resource.meta?.source) },
    )

  public val _tag: SearchParam<Resource, Coding> =
    SearchParam(
      name = "_tag",
      type = SearchParamType.Token,
      expression = "Resource.meta.tag",
      extractor = { resource -> resource.meta?.tag ?: emptyList() },
    )

  public val _text: SearchParam<Resource, Any> =
    SearchParam(
      name = "_text",
      type = SearchParamType.String,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter '_text' has expression '' which is not yet supported."
        )
      },
    )

  public val _type: SearchParam<Resource, Any> =
    SearchParam(
      name = "_type",
      type = SearchParamType.Token,
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter '_type' has expression '' which is not yet supported."
        )
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Resource, *>> =
    listOf(_content, _filter, _has, _id, _list, _query, _text, _type)

  /**
   * Supported search parameters for the Resource resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Resource, *>> =
    listOf(_lastUpdated, _profile, _security, _source, _tag)
}
