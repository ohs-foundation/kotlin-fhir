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

import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Subscription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Subscription] resource type. */
public object SubscriptionSearchParam {
  /** All search parameters for the Subscription resource type. */
  public val ALL: List<SearchParam<Subscription, *>> =
    listOf(Contact, Criteria, Payload, Status, Type, Url)

  public data object Contact : SearchParam<Subscription, ContactPoint> {
    public override val paramName: KotlinString = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.contact"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Subscription): List<ContactPoint> = resource.contact
  }

  public data object Criteria : SearchParam<Subscription, R4String> {
    public override val paramName: KotlinString = "criteria"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Subscription.criteria"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Subscription): List<R4String> = listOf(resource.criteria)
  }

  public data object Payload : SearchParam<Subscription, Any> {
    public override val paramName: KotlinString = "payload"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.channel.payload"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Subscription): List<Any> =
      listOfNotNull(resource.channel.payload)
  }

  public data object Status : SearchParam<Subscription, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = listOf(resource.status)
  }

  public data object Type : SearchParam<Subscription, Any> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.channel.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = listOf(resource.channel.type)
  }

  public data object Url : SearchParam<Subscription, dev.ohs.fhir.model.r4.Url> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Subscription.channel.endpoint"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Subscription): List<dev.ohs.fhir.model.r4.Url> =
      listOfNotNull(resource.channel.endpoint)
  }
}
