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

import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Subscription
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Subscription] resource type. */
public object SubscriptionSearchParams {
  public val contact: SearchParam<Subscription, ContactPoint> =
    SearchParam(
      name = "contact",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.contact",
      extractor = { resource -> resource.contact },
    )

  public val criteria: SearchParam<Subscription, String> =
    SearchParam(
      name = "criteria",
      type = SearchParamType.fromCode("string"),
      expression = "Subscription.criteria",
      extractor = { resource -> listOf(resource.criteria) },
    )

  public val payload: SearchParam<Subscription, Any> =
    SearchParam(
      name = "payload",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.channel.payload",
      extractor = { resource -> listOfNotNull(resource.channel.payload) },
    )

  public val status: SearchParam<Subscription, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val type: SearchParam<Subscription, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.channel.type",
      extractor = { resource -> listOf(resource.channel.type) },
    )

  public val url: SearchParam<Subscription, Url> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Subscription.channel.endpoint",
      extractor = { resource -> listOfNotNull(resource.channel.endpoint) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Subscription, *>> = listOf()

  /**
   * Supported search parameters for the Subscription resource type. Entries in [unsupported] are
   * excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<Subscription, *>> =
    listOf(contact, criteria, payload, status, type, url) - unsupported.toSet()
}
