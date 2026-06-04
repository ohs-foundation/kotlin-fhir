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

import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DeviceMetric
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Media
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Specimen
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Media] resource type. */
public object MediaSearchParams {
  public val basedOn: SearchParam<Media, Reference> =
    SearchParam<Media, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.basedOn",
      target = listOf(CarePlan::class, ServiceRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val created: SearchParam<Media, Media.Created> =
    SearchParam<Media, Media.Created>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "Media.created",
      extractor = { resource -> listOfNotNull(resource.created) },
    )

  public val device: SearchParam<Media, Reference> =
    SearchParam<Media, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.device",
      target = listOf(Device::class, DeviceMetric::class),
      extractor = { resource -> listOfNotNull(resource.device) },
    )

  public val encounter: SearchParam<Media, Reference> =
    SearchParam<Media, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<Media, Identifier> =
    SearchParam<Media, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Media.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val modality: SearchParam<Media, CodeableConcept> =
    SearchParam<Media, CodeableConcept>(
      name = "modality",
      type = SearchParamType.fromCode("token"),
      expression = "Media.modality",
      extractor = { resource -> listOfNotNull(resource.modality) },
    )

  public val `operator`: SearchParam<Media, Reference> =
    SearchParam<Media, Reference>(
      name = "operator",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.operator",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.`operator`) },
    )

  public val patient: SearchParam<Media, Reference> =
    SearchParam<Media, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val site: SearchParam<Media, CodeableConcept> =
    SearchParam<Media, CodeableConcept>(
      name = "site",
      type = SearchParamType.fromCode("token"),
      expression = "Media.bodySite",
      extractor = { resource -> listOfNotNull(resource.bodySite) },
    )

  public val status: SearchParam<Media, Any> =
    SearchParam<Media, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Media.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Media, Reference> =
    SearchParam<Media, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.subject",
      target =
        listOf(
          Practitioner::class,
          Group::class,
          Specimen::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          Location::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val type: SearchParam<Media, CodeableConcept> =
    SearchParam<Media, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Media.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val view: SearchParam<Media, CodeableConcept> =
    SearchParam<Media, CodeableConcept>(
      name = "view",
      type = SearchParamType.fromCode("token"),
      expression = "Media.view",
      extractor = { resource -> listOfNotNull(resource.view) },
    )

  /** All search parameters for the Media resource type. */
  public val all: List<SearchParam<Media, *>> =
    listOf(
      basedOn,
      created,
      device,
      encounter,
      identifier,
      modality,
      `operator`,
      patient,
      site,
      status,
      subject,
      type,
      view,
    )
}
