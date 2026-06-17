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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Patient
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
public object RequestGroupSearchParams {
  public val author: SearchParam<RequestGroup, Reference> =
    SearchParam(
      name = "author",
      type = SearchParamType.Reference,
      expression = "RequestGroup.author",
      target = listOf(Practitioner::class, Device::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.author) },
    )

  public val authored: SearchParam<RequestGroup, DateTime> =
    SearchParam(
      name = "authored",
      type = SearchParamType.Date,
      expression = "RequestGroup.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val code: SearchParam<RequestGroup, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "RequestGroup.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val encounter: SearchParam<RequestGroup, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "RequestGroup.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val groupIdentifier: SearchParam<RequestGroup, Identifier> =
    SearchParam(
      name = "group-identifier",
      type = SearchParamType.Token,
      expression = "RequestGroup.groupIdentifier",
      extractor = { resource -> listOfNotNull(resource.groupIdentifier) },
    )

  public val identifier: SearchParam<RequestGroup, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "RequestGroup.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<RequestGroup, Canonical> =
    SearchParam(
      name = "instantiates-canonical",
      type = SearchParamType.Reference,
      expression = "RequestGroup.instantiatesCanonical",
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val instantiatesUri: SearchParam<RequestGroup, Uri> =
    SearchParam(
      name = "instantiates-uri",
      type = SearchParamType.Uri,
      expression = "RequestGroup.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val intent: SearchParam<RequestGroup, Any> =
    SearchParam(
      name = "intent",
      type = SearchParamType.Token,
      expression = "RequestGroup.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val participant: SearchParam<RequestGroup, Reference> =
    SearchParam(
      name = "participant",
      type = SearchParamType.Reference,
      expression = "RequestGroup.action.participant",
      target =
        listOf(
          Practitioner::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.action.flatMap { it.participant } },
    )

  public val patient: SearchParam<RequestGroup, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "RequestGroup.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val priority: SearchParam<RequestGroup, Any> =
    SearchParam(
      name = "priority",
      type = SearchParamType.Token,
      expression = "RequestGroup.priority",
      extractor = { resource -> listOfNotNull(resource.priority) },
    )

  public val status: SearchParam<RequestGroup, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "RequestGroup.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<RequestGroup, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "RequestGroup.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<RequestGroup, *>> = listOf()

  /**
   * Supported search parameters for the RequestGroup resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<RequestGroup, *>> =
    listOf(
      author,
      authored,
      code,
      encounter,
      groupIdentifier,
      identifier,
      instantiatesCanonical,
      instantiatesUri,
      intent,
      participant,
      patient,
      priority,
      status,
      subject,
    )
}
