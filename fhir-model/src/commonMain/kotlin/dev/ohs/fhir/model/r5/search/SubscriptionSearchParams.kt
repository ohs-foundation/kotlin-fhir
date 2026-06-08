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
  public val contact: SearchParam<Subscription, ContactPoint> =
    SearchParam(
      name = "contact",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.contact",
      extractor = { resource -> resource.contact },
    )

  public val contentLevel: SearchParam<Subscription, Any> =
    SearchParam(
      name = "content-level",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.content",
      extractor = { resource -> listOfNotNull(resource.content) },
    )

  public val filterValue: SearchParam<Subscription, String> =
    SearchParam(
      name = "filter-value",
      type = SearchParamType.fromCode("string"),
      expression = "Subscription.filterBy.value",
      extractor = { resource -> resource.filterBy.map { it.`value` } },
    )

  public val identifier: SearchParam<Subscription, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<Subscription, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Subscription.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val owner: SearchParam<Subscription, Reference> =
    SearchParam(
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

  public val payload: SearchParam<Subscription, Any> =
    SearchParam(
      name = "payload",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.contentType",
      extractor = { resource -> listOfNotNull(resource.contentType) },
    )

  public val status: SearchParam<Subscription, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val topic: SearchParam<Subscription, Canonical> =
    SearchParam(
      name = "topic",
      type = SearchParamType.fromCode("uri"),
      expression = "Subscription.topic",
      extractor = { resource -> listOf(resource.topic) },
    )

  public val type: SearchParam<Subscription, Coding> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Subscription.channelType",
      extractor = { resource -> listOf(resource.channelType) },
    )

  public val url: SearchParam<Subscription, Url> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Subscription.endpoint",
      extractor = { resource -> listOfNotNull(resource.endpoint) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Subscription, *>> = listOf()

  /**
   * Supported search parameters for the Subscription resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Subscription, *>> =
    listOf(
      contact,
      contentLevel,
      filterValue,
      identifier,
      name,
      owner,
      payload,
      status,
      topic,
      type,
      url,
    )
}
