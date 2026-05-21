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
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.SubscriptionTopic
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [SubscriptionTopic] resource type. */
public object SubscriptionTopicSearchParam {
  /** All search parameters for the SubscriptionTopic resource type. */
  public val ALL: List<SearchParam<SubscriptionTopic, *>> =
    listOf(
      Date,
      DerivedOrSelf,
      Identifier,
      Resource,
      Status,
      Title,
      TriggerDescription,
      Url,
      Version,
    )

  public data object Date : SearchParam<SubscriptionTopic, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "SubscriptionTopic.date"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DerivedOrSelf : SearchParam<SubscriptionTopic, Uri> {
    public override val name: KotlinString = "derived-or-self"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "SubscriptionTopic.url"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Uri> = listOf(resource.url)
  }

  public data object Identifier :
    SearchParam<SubscriptionTopic, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubscriptionTopic.identifier"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(
      resource: SubscriptionTopic
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Resource : SearchParam<SubscriptionTopic, Uri> {
    public override val name: KotlinString = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "SubscriptionTopic.resourceTrigger.resource"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Uri> =
      resource.resourceTrigger.map { it.resource }
  }

  public data object Status : SearchParam<SubscriptionTopic, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubscriptionTopic.status"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<SubscriptionTopic, R4bString> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SubscriptionTopic.title"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<R4bString> =
      listOfNotNull(resource.title)
  }

  public data object TriggerDescription : SearchParam<SubscriptionTopic, Markdown> {
    public override val name: KotlinString = "trigger-description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SubscriptionTopic.resourceTrigger.description"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Markdown> =
      resource.resourceTrigger.mapNotNull { it.description }
  }

  public data object Url : SearchParam<SubscriptionTopic, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "SubscriptionTopic.url"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<Uri> = listOf(resource.url)
  }

  public data object Version : SearchParam<SubscriptionTopic, R4bString> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SubscriptionTopic.version"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4b.Resource>> = emptyList()

    public override fun extract(resource: SubscriptionTopic): List<R4bString> =
      listOfNotNull(resource.version)
  }
}
