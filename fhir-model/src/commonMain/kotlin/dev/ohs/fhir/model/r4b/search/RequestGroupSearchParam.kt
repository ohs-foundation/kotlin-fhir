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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.RequestGroup
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RequestGroup] resource type. */
public object RequestGroupSearchParam {
  public val Author: SearchParam<RequestGroup, Reference> =
    SimpleSearchParam<RequestGroup, Reference>(
      name = "author",
      type = SearchParamType.fromCode("reference"),
      expression = "RequestGroup.author",
      target = listOf(Practitioner::class, Device::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.author) },
    )

  public val Authored: SearchParam<RequestGroup, DateTime> =
    SimpleSearchParam<RequestGroup, DateTime>(
      name = "authored",
      type = SearchParamType.fromCode("date"),
      expression = "RequestGroup.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val Code: SearchParam<RequestGroup, CodeableConcept> =
    SimpleSearchParam<RequestGroup, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "RequestGroup.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Encounter: SearchParam<RequestGroup, Reference> =
    SimpleSearchParam<RequestGroup, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "RequestGroup.encounter",
      target = listOf(dev.ohs.fhir.model.r4b.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val GroupIdentifier: SearchParam<RequestGroup, Identifier> =
    SimpleSearchParam<RequestGroup, Identifier>(
      name = "group-identifier",
      type = SearchParamType.fromCode("token"),
      expression = "RequestGroup.groupIdentifier",
      extractor = { resource -> listOfNotNull(resource.groupIdentifier) },
    )

  public val Identifier: SearchParam<RequestGroup, Identifier> =
    SimpleSearchParam<RequestGroup, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "RequestGroup.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val InstantiatesCanonical: SearchParam<RequestGroup, Canonical> =
    SimpleSearchParam<RequestGroup, Canonical>(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
      expression = "RequestGroup.instantiatesCanonical",
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val InstantiatesUri: SearchParam<RequestGroup, Uri> =
    SimpleSearchParam<RequestGroup, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "RequestGroup.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val Intent: SearchParam<RequestGroup, Any> =
    SimpleSearchParam<RequestGroup, Any>(
      name = "intent",
      type = SearchParamType.fromCode("token"),
      expression = "RequestGroup.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val Participant: SearchParam<RequestGroup, Reference> =
    SimpleSearchParam<RequestGroup, Reference>(
      name = "participant",
      type = SearchParamType.fromCode("reference"),
      expression = "RequestGroup.action.participant",
      target =
        listOf(
          Practitioner::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.action.flatMap { it.participant } },
    )

  public val Patient: SearchParam<RequestGroup, Reference> =
    SimpleSearchParam<RequestGroup, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "RequestGroup.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Priority: SearchParam<RequestGroup, Any> =
    SimpleSearchParam<RequestGroup, Any>(
      name = "priority",
      type = SearchParamType.fromCode("token"),
      expression = "RequestGroup.priority",
      extractor = { resource -> listOfNotNull(resource.priority) },
    )

  public val Status: SearchParam<RequestGroup, Any> =
    SimpleSearchParam<RequestGroup, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "RequestGroup.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<RequestGroup, Reference> =
    SimpleSearchParam<RequestGroup, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "RequestGroup.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the RequestGroup resource type. */
  public val ALL: List<SearchParam<RequestGroup, *>> =
    listOf(
      Author,
      Authored,
      Code,
      Encounter,
      GroupIdentifier,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Intent,
      Participant,
      Patient,
      Priority,
      Status,
      Subject,
    )
}
