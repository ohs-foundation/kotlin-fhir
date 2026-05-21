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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Resource] resource type. */
public object ResourceSearchParam {
  /** All search parameters for the Resource resource type. */
  public val ALL: List<SearchParam<Resource, *>> =
    listOf(_content, _filter, _id, _lastUpdated, _profile, _query, _security, _source, _tag)

  public data object _content : SearchParam<Resource, Any> {
    public override val paramName: String = "_content"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = ""

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Any> = emptyList()
  }

  public data object _filter : SearchParam<Resource, Any> {
    public override val paramName: String = "_filter"

    public override val type: SearchParamType = SearchParamType.fromCode("special")

    public override val expression: String = ""

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Any> = emptyList()
  }

  public data object _id : SearchParam<Resource, Any> {
    public override val paramName: String = "_id"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "id"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Any> = emptyList()
  }

  public data object _lastUpdated : SearchParam<Resource, Instant> {
    public override val paramName: String = "_lastUpdated"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Resource.meta.lastUpdated"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Instant> =
      listOfNotNull(resource.meta?.lastUpdated)
  }

  public data object _profile : SearchParam<Resource, Canonical> {
    public override val paramName: String = "_profile"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Resource.meta.profile"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Canonical> =
      resource.meta?.profile ?: emptyList()
  }

  public data object _query : SearchParam<Resource, Any> {
    public override val paramName: String = "_query"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = ""

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Any> = emptyList()
  }

  public data object _security : SearchParam<Resource, Coding> {
    public override val paramName: String = "_security"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Resource.meta.security"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Coding> =
      resource.meta?.security ?: emptyList()
  }

  public data object _source : SearchParam<Resource, Uri> {
    public override val paramName: String = "_source"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Resource.meta.source"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Uri> =
      listOfNotNull(resource.meta?.source)
  }

  public data object _tag : SearchParam<Resource, Coding> {
    public override val paramName: String = "_tag"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Resource.meta.tag"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Resource): List<Coding> =
      resource.meta?.tag ?: emptyList()
  }
}
