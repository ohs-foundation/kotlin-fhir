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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Subscription
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Subscription] resource type. */
public object SubscriptionSearchParam {
  /** All search parameters for the Subscription resource type. */
  public val ALL: List<SearchParam<Subscription, *>> =
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

  public data object Contact : SearchParam<Subscription, ContactPoint> {
    public override val paramName: KotlinString = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.contact"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<ContactPoint> = resource.contact
  }

  public data object ContentLevel : SearchParam<Subscription, Any> {
    public override val paramName: KotlinString = "content-level"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.content"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = listOfNotNull(resource.content)
  }

  public data object FilterValue : SearchParam<Subscription, R5String> {
    public override val paramName: KotlinString = "filter-value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Subscription.filterBy.value"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<R5String> =
      resource.filterBy.map { it.value }
  }

  public data object Identifier : SearchParam<Subscription, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : SearchParam<Subscription, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Subscription.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Owner : SearchParam<Subscription, Reference> {
    public override val paramName: KotlinString = "owner"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Subscription.managingEntity"

    public override val target: List<KClass<out Resource>> =
      listOf(
        HealthcareService::class,
        CareTeam::class,
        Organization::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        Patient::class,
      )

    public override fun extract(resource: Subscription): List<Reference> =
      listOfNotNull(resource.managingEntity)
  }

  public data object Payload : SearchParam<Subscription, Any> {
    public override val paramName: KotlinString = "payload"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.contentType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<Any> =
      listOfNotNull(resource.contentType)
  }

  public data object Status : SearchParam<Subscription, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<Any> = listOf(resource.status)
  }

  public data object Topic : SearchParam<Subscription, Canonical> {
    public override val paramName: KotlinString = "topic"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Subscription.topic"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<Canonical> = listOf(resource.topic)
  }

  public data object Type : SearchParam<Subscription, Coding> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Subscription.channelType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<Coding> = listOf(resource.channelType)
  }

  public data object Url : SearchParam<Subscription, dev.ohs.fhir.model.r5.Url> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Subscription.endpoint"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Subscription): List<dev.ohs.fhir.model.r5.Url> =
      listOfNotNull(resource.endpoint)
  }
}
