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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Subscription
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Subscription] resource type. */
public object SubscriptionSearchParams {
  public val Contact: SearchParam<Subscription, ContactPoint> =
    SimpleSearchParam<Subscription, ContactPoint>(
      name = "contact",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.contact",
      extractor = { resource -> resource.contact },
    )

  public val ContentLevel: SearchParam<Subscription, Any> =
    SimpleSearchParam<Subscription, Any>(
      name = "content-level",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.content",
      extractor = { resource -> listOfNotNull(resource.content) },
    )

  public val FilterValue: SearchParam<Subscription, String> =
    SimpleSearchParam<Subscription, String>(
      name = "filter-value",
      type = SearchParamType.fromCode("string"),
      expression = "Subscription.filterBy.value",
      extractor = { resource -> resource.filterBy.map { it.`value` } },
    )

  public val Identifier: SearchParam<Subscription, Identifier> =
    SimpleSearchParam<Subscription, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<Subscription, String> =
    SimpleSearchParam<Subscription, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Subscription.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Owner: SearchParam<Subscription, Reference> =
    SimpleSearchParam<Subscription, Reference>(
      name = "owner",
      type = SearchParamType.fromCode("reference"),
      expression = "Subscription.managingEntity",
      target =
        listOf(
          HealthcareService::class,
          CareTeam::class,
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.managingEntity) },
    )

  public val Payload: SearchParam<Subscription, Any> =
    SimpleSearchParam<Subscription, Any>(
      name = "payload",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.contentType",
      extractor = { resource -> listOfNotNull(resource.contentType) },
    )

  public val Status: SearchParam<Subscription, Any> =
    SimpleSearchParam<Subscription, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Topic: SearchParam<Subscription, Canonical> =
    SimpleSearchParam<Subscription, Canonical>(
      name = "topic",
      type = SearchParamType.fromCode("uri"),
      expression = "Subscription.topic",
      extractor = { resource -> listOf(resource.topic) },
    )

  public val Type: SearchParam<Subscription, Coding> =
    SimpleSearchParam<Subscription, Coding>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.channelType",
      extractor = { resource -> listOf(resource.channelType) },
    )

  public val Url: SearchParam<Subscription, Url> =
    SimpleSearchParam<Subscription, Url>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Subscription.endpoint",
      extractor = { resource -> listOfNotNull(resource.endpoint) },
    )

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
}
