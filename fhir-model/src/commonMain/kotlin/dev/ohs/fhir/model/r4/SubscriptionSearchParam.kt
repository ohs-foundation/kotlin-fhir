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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Subscription] resource type. */
public sealed class SubscriptionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Subscription): List<T>

  public data object Contact : SubscriptionSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.contact"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<ContactPoint> = resource.contact
  }

  public data object Criteria : SubscriptionSearchParam<String>() {
    public override val paramName: kotlin.String = "criteria"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Subscription.criteria"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<String> = listOf(resource.criteria)
  }

  public data object Payload : SubscriptionSearchParam<Any>() {
    public override val paramName: kotlin.String = "payload"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.channel.payload"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> =
      listOfNotNull(resource.channel.payload)
  }

  public data object Status : SubscriptionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = listOf(resource.status)
  }

  public data object Type : SubscriptionSearchParam<Any>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.channel.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = listOf(resource.channel.type)
  }

  public data object Url : SubscriptionSearchParam<dev.ohs.fhir.model.r4.Url>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "Subscription.channel.endpoint"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<dev.ohs.fhir.model.r4.Url> =
      listOfNotNull(resource.channel.endpoint)
  }

  public companion object {
    /** All search parameters for the Subscription resource type. */
    public val ALL: List<SubscriptionSearchParam<*>> =
      listOf(Contact, Criteria, Payload, Status, Type, Url)
  }
}
