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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.SubscriptionTopic
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SubscriptionTopic] resource type. */
public object SubscriptionTopicSearchParams {
  public val date: SearchParam<SubscriptionTopic, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "SubscriptionTopic.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val derivedOrSelf: SearchParam<SubscriptionTopic, Any> =
    SearchParam(
      name = "derived-or-self",
      type = SearchParamType.Uri,
      expression = "SubscriptionTopic.url | SubscriptionTopic.derivedFrom",
      extractor = { resource ->
        buildList {
            addAll(listOf(resource.url))
            addAll(resource.derivedFrom)
          }
          .distinct()
      },
    )

  public val effective: SearchParam<SubscriptionTopic, Period> =
    SearchParam(
      name = "effective",
      type = SearchParamType.Date,
      expression = "SubscriptionTopic.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val event: SearchParam<SubscriptionTopic, CodeableConcept> =
    SearchParam(
      name = "event",
      type = SearchParamType.Token,
      expression = "SubscriptionTopic.eventTrigger.event",
      extractor = { resource -> resource.eventTrigger.map { it.event } },
    )

  public val identifier: SearchParam<SubscriptionTopic, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "SubscriptionTopic.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val resource: SearchParam<SubscriptionTopic, Uri> =
    SearchParam(
      name = "resource",
      type = SearchParamType.Uri,
      expression =
        "SubscriptionTopic.resourceTrigger.resource | SubscriptionTopic.eventTrigger.resource | SubscriptionTopic.canFilterBy.resource | SubscriptionTopic.notificationShape.resource",
      extractor = { resource ->
        buildList {
            addAll(resource.resourceTrigger.map { it.resource })
            addAll(resource.eventTrigger.map { it.resource })
            addAll(resource.canFilterBy.mapNotNull { it.resource })
            addAll(resource.notificationShape.map { it.resource })
          }
          .distinct()
      },
    )

  public val status: SearchParam<SubscriptionTopic, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "SubscriptionTopic.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<SubscriptionTopic, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "SubscriptionTopic.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val triggerDescription: SearchParam<SubscriptionTopic, Markdown> =
    SearchParam(
      name = "trigger-description",
      type = SearchParamType.String,
      expression = "SubscriptionTopic.resourceTrigger.description",
      extractor = { resource -> resource.resourceTrigger.mapNotNull { it.description } },
    )

  public val url: SearchParam<SubscriptionTopic, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "SubscriptionTopic.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<SubscriptionTopic, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "SubscriptionTopic.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<SubscriptionTopic, *>> = listOf()

  /**
   * Supported search parameters for the SubscriptionTopic resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<SubscriptionTopic, *>> =
    listOf(
      date,
      derivedOrSelf,
      effective,
      event,
      identifier,
      resource,
      status,
      title,
      triggerDescription,
      url,
      version,
    )
}
