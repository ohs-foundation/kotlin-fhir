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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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

  public data object ContentLevel : SubscriptionSearchParam<Any>() {
    public override val paramName: kotlin.String = "content-level"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.content"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = listOfNotNull(resource.content)
  }

  public data object FilterValue : SubscriptionSearchParam<String>() {
    public override val paramName: kotlin.String = "filter-value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Subscription.filterBy.value"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<String> =
      resource.filterBy.map { it.value }
  }

  public data object Identifier : SubscriptionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : SubscriptionSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Subscription.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<String> = listOfNotNull(resource.name)
  }

  public data object Owner : SubscriptionSearchParam<Reference>() {
    public override val paramName: kotlin.String = "owner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Subscription.managingEntity"

    public override val target: List<kotlin.String> =
      listOf(
        "HealthcareService",
        "CareTeam",
        "Organization",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Subscription): List<Reference> =
      listOfNotNull(resource.managingEntity)
  }

  public data object Payload : SubscriptionSearchParam<Any>() {
    public override val paramName: kotlin.String = "payload"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.contentType"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> =
      listOfNotNull(resource.contentType)
  }

  public data object Status : SubscriptionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = listOf(resource.status)
  }

  public data object Topic : SubscriptionSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "Subscription.topic"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<Canonical> = listOf(resource.topic)
  }

  public data object Type : SubscriptionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Subscription.channelType"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<Coding> = listOf(resource.channelType)
  }

  public data object Url : SubscriptionSearchParam<dev.ohs.fhir.model.r5.Url>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "Subscription.endpoint"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Subscription): List<dev.ohs.fhir.model.r5.Url> =
      listOfNotNull(resource.endpoint)
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
