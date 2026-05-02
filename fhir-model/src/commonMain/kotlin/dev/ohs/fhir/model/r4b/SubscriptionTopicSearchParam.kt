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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SubscriptionTopic] resource type. */
public sealed class SubscriptionTopicSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SubscriptionTopic): List<T>

  public data object Date : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "SubscriptionTopic.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public data object DerivedOrSelf : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "derived-or-self"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "SubscriptionTopic.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public data object Identifier : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SubscriptionTopic.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public data object Resource : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "SubscriptionTopic.resourceTrigger.resource"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public data object Status : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SubscriptionTopic.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public data object Title : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "SubscriptionTopic.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public data object TriggerDescription : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "trigger-description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "SubscriptionTopic.resourceTrigger.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public data object Url : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "SubscriptionTopic.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public data object Version : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "SubscriptionTopic.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the SubscriptionTopic resource type. */
    public val ALL: List<SubscriptionTopicSearchParam<*>> =
      listOf(
        Date,
        DerivedOrSelf,
        Identifier,
        Resource,
        Status,
        Title,
        TriggerDescription,
        Url,
        Version,
      )
  }
}
