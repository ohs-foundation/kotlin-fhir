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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
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

  public data object ContentLevel : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "content-level"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Subscription.content"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object FilterValue : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "filter-value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Subscription.filterBy.value"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Identifier : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Subscription.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Name : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Subscription.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Owner : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "owner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Subscription.managingEntity"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "CareTeam",
        "Organization",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Payload : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "payload"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Subscription.contentType"

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

  public data object Topic : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Subscription.topic"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Type : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Subscription.channelType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public data object Url : SubscriptionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Subscription.endpoint"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Subscription resource type. */
    public val ALL: List<SubscriptionSearchParam<*>> =
      listOf(
        Contact,
        ContentLevel,
        FilterValue,
        Identifier,
        Name,
        Owner,
        Payload,
        Status,
        Topic,
        Type,
        Url,
      )
  }
}
