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

import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.SubscriptionTopic
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SubscriptionTopic] resource type. */
public object SubscriptionTopicSearchParams {
  public val date: SearchParam<SubscriptionTopic, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "SubscriptionTopic.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val derivedOrSelf: SearchParam<SubscriptionTopic, Uri> =
    SearchParam(
      name = "derived-or-self",
      type = SearchParamType.fromCode("uri"),
      expression = "SubscriptionTopic.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val identifier: SearchParam<SubscriptionTopic, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SubscriptionTopic.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val resource: SearchParam<SubscriptionTopic, Uri> =
    SearchParam(
      name = "resource",
      type = SearchParamType.fromCode("uri"),
      expression = "SubscriptionTopic.resourceTrigger.resource",
      extractor = { resource -> resource.resourceTrigger.map { it.resource } },
    )

  public val status: SearchParam<SubscriptionTopic, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "SubscriptionTopic.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<SubscriptionTopic, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "SubscriptionTopic.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val triggerDescription: SearchParam<SubscriptionTopic, Markdown> =
    SearchParam(
      name = "trigger-description",
      type = SearchParamType.fromCode("string"),
      expression = "SubscriptionTopic.resourceTrigger.description",
      extractor = { resource -> resource.resourceTrigger.mapNotNull { it.description } },
    )

  public val url: SearchParam<SubscriptionTopic, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "SubscriptionTopic.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<SubscriptionTopic, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "SubscriptionTopic.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the SubscriptionTopic resource type. */
  public val all: List<SearchParam<SubscriptionTopic, *>> =
    listOf(
      date,
      derivedOrSelf,
      identifier,
      resource,
      status,
      title,
      triggerDescription,
      url,
      version,
    )
}
