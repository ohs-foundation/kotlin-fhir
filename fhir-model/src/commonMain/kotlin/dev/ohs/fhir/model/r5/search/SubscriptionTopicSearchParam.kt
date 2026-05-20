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
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubscriptionTopic
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SubscriptionTopic] resource type. */
public sealed class SubscriptionTopicSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SubscriptionTopic): List<T>

  public data object Date : SubscriptionTopicSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "SubscriptionTopic.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DerivedOrSelf : SubscriptionTopicSearchParam<Uri>() {
    public override val paramName: KotlinString = "derived-or-self"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "SubscriptionTopic.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Uri> = listOf(resource.url)
  }

  public data object Effective : SubscriptionTopicSearchParam<Period>() {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "SubscriptionTopic.effectivePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Event : SubscriptionTopicSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubscriptionTopic.eventTrigger.event"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<CodeableConcept> =
      resource.eventTrigger.map { it.event }
  }

  public data object Identifier : SubscriptionTopicSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubscriptionTopic.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: SubscriptionTopic
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Resource : SubscriptionTopicSearchParam<Uri>() {
    public override val paramName: KotlinString = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "SubscriptionTopic.resourceTrigger.resource"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Uri> =
      resource.resourceTrigger.map { it.resource }
  }

  public data object Status : SubscriptionTopicSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubscriptionTopic.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = listOf(resource.status)
  }

  public data object Title : SubscriptionTopicSearchParam<R5String>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SubscriptionTopic.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object TriggerDescription : SubscriptionTopicSearchParam<Markdown>() {
    public override val paramName: KotlinString = "trigger-description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SubscriptionTopic.resourceTrigger.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Markdown> =
      resource.resourceTrigger.mapNotNull { it.description }
  }

  public data object Url : SubscriptionTopicSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "SubscriptionTopic.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Uri> = listOf(resource.url)
  }

  public data object Version : SubscriptionTopicSearchParam<R5String>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubscriptionTopic.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<R5String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the SubscriptionTopic resource type. */
    public val ALL: List<SubscriptionTopicSearchParam<*>> =
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
}
