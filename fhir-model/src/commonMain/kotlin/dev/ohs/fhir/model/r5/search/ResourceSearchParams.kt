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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.StructureDefinition
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Resource] resource type. */
public object ResourceSearchParams {
  public val _content: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_content",
      type = SearchParamType.fromCode("special"),
      expression = "",
      extractor = { emptyList() },
    )

  public val _filter: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_filter",
      type = SearchParamType.fromCode("special"),
      expression = "",
      extractor = { emptyList() },
    )

  public val _has: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_has",
      type = SearchParamType.fromCode("special"),
      expression = "",
      extractor = { emptyList() },
    )

  public val _id: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_id",
      type = SearchParamType.fromCode("token"),
      expression = "id",
      extractor = { emptyList() },
    )

  public val _in: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_in",
      type = SearchParamType.fromCode("reference"),
      expression = "Resource.id",
      extractor = { resource -> listOfNotNull(resource.id) },
    )

  public val _language: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_language",
      type = SearchParamType.fromCode("token"),
      expression = "Resource.language",
      extractor = { resource -> listOfNotNull(resource.language) },
    )

  public val _lastUpdated: SearchParam<Resource, Instant> =
    SearchParam<Resource, Instant>(
      name = "_lastUpdated",
      type = SearchParamType.fromCode("date"),
      expression = "Resource.meta.lastUpdated",
      extractor = { resource -> listOfNotNull(resource.meta?.lastUpdated) },
    )

  public val _list: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_list",
      type = SearchParamType.fromCode("special"),
      expression = "",
      extractor = { emptyList() },
    )

  public val _profile: SearchParam<Resource, Canonical> =
    SearchParam<Resource, Canonical>(
      name = "_profile",
      type = SearchParamType.fromCode("reference"),
      expression = "Resource.meta.profile",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> resource.meta?.profile ?: emptyList() },
    )

  public val _query: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_query",
      type = SearchParamType.fromCode("special"),
      expression = "",
      extractor = { emptyList() },
    )

  public val _security: SearchParam<Resource, Coding> =
    SearchParam<Resource, Coding>(
      name = "_security",
      type = SearchParamType.fromCode("token"),
      expression = "Resource.meta.security",
      extractor = { resource -> resource.meta?.security ?: emptyList() },
    )

  public val _source: SearchParam<Resource, Uri> =
    SearchParam<Resource, Uri>(
      name = "_source",
      type = SearchParamType.fromCode("uri"),
      expression = "Resource.meta.source",
      extractor = { resource -> listOfNotNull(resource.meta?.source) },
    )

  public val _tag: SearchParam<Resource, Coding> =
    SearchParam<Resource, Coding>(
      name = "_tag",
      type = SearchParamType.fromCode("token"),
      expression = "Resource.meta.tag",
      extractor = { resource -> resource.meta?.tag ?: emptyList() },
    )

  public val _text: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_text",
      type = SearchParamType.fromCode("string"),
      expression = "",
      extractor = { emptyList() },
    )

  public val _type: SearchParam<Resource, Any> =
    SearchParam<Resource, Any>(
      name = "_type",
      type = SearchParamType.fromCode("special"),
      expression = "",
      extractor = { emptyList() },
    )

  /** All search parameters for the Resource resource type. */
  public val all: List<SearchParam<Resource, *>> =
    listOf(
      _content,
      _filter,
      _has,
      _id,
      _in,
      _language,
      _lastUpdated,
      _list,
      _profile,
      _query,
      _security,
      _source,
      _tag,
      _text,
      _type,
    )
}
