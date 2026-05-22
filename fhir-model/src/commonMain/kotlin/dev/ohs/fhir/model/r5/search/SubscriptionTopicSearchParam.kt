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
public object SubscriptionTopicSearchParam {
  public val Date: SearchParam<SubscriptionTopic, DateTime> =
    SimpleSearchParam<SubscriptionTopic, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "SubscriptionTopic.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val DerivedOrSelf: SearchParam<SubscriptionTopic, Uri> =
    SimpleSearchParam<SubscriptionTopic, Uri>(
      name = "derived-or-self",
      type = SearchParamType.fromCode("uri"),
      expression = "SubscriptionTopic.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val Effective: SearchParam<SubscriptionTopic, Period> =
    SimpleSearchParam<SubscriptionTopic, Period>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "SubscriptionTopic.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val Event: SearchParam<SubscriptionTopic, CodeableConcept> =
    SimpleSearchParam<SubscriptionTopic, CodeableConcept>(
      name = "event",
      type = SearchParamType.fromCode("token"),
      expression = "SubscriptionTopic.eventTrigger.event",
      extractor = { resource -> resource.eventTrigger.map { it.event } },
    )

  public val Identifier: SearchParam<SubscriptionTopic, Identifier> =
    SimpleSearchParam<SubscriptionTopic, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SubscriptionTopic.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Resource: SearchParam<SubscriptionTopic, Uri> =
    SimpleSearchParam<SubscriptionTopic, Uri>(
      name = "resource",
      type = SearchParamType.fromCode("uri"),
      expression = "SubscriptionTopic.resourceTrigger.resource",
      extractor = { resource -> resource.resourceTrigger.map { it.resource } },
    )

  public val Status: SearchParam<SubscriptionTopic, Any> =
    SimpleSearchParam<SubscriptionTopic, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "SubscriptionTopic.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<SubscriptionTopic, String> =
    SimpleSearchParam<SubscriptionTopic, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "SubscriptionTopic.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val TriggerDescription: SearchParam<SubscriptionTopic, Markdown> =
    SimpleSearchParam<SubscriptionTopic, Markdown>(
      name = "trigger-description",
      type = SearchParamType.fromCode("string"),
      expression = "SubscriptionTopic.resourceTrigger.description",
      extractor = { resource -> resource.resourceTrigger.mapNotNull { it.description } },
    )

  public val Url: SearchParam<SubscriptionTopic, Uri> =
    SimpleSearchParam<SubscriptionTopic, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "SubscriptionTopic.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val Version: SearchParam<SubscriptionTopic, String> =
    SimpleSearchParam<SubscriptionTopic, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "SubscriptionTopic.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the SubscriptionTopic resource type. */
  public val ALL: List<SearchParam<SubscriptionTopic, *>> =
    listOf(
      Date,
      DerivedOrSelf,
      Effective,
      Event,
      Identifier,
      Resource,
      Status,
      Title,
      TriggerDescription,
      Url,
      Version,
    )
}
