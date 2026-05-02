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

/** Search parameters for the [Subscription] resource type. */
public sealed class SubscriptionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Subscription): List<T>

  public data object Contact : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Subscription.contact"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Criteria : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "criteria"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Subscription.criteria"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Payload : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "payload"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Subscription.channel.payload"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Status : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Subscription.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Type : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Subscription.channel.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Url : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Subscription.channel.endpoint"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Subscription resource type. */
    public val ALL: List<SubscriptionSearchParam<*>> =
      listOf(Contact, Criteria, Payload, Status, Type, Url)
  }
}
