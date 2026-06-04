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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CarePlan
import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DeviceMetric
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Media
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.Specimen
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Media] resource type. */
public object MediaSearchParams {
  public val BasedOn: SearchParam<Media, Reference> =
    SimpleSearchParam<Media, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.basedOn",
      target = listOf(CarePlan::class, ServiceRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val Created: SearchParam<Media, Media.Created> =
    SimpleSearchParam<Media, Media.Created>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "Media.created",
      extractor = { resource -> listOfNotNull(resource.created) },
    )

  public val Device: SearchParam<Media, Reference> =
    SimpleSearchParam<Media, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.device",
      target = listOf(dev.ohs.fhir.model.r4.Device::class, DeviceMetric::class),
      extractor = { resource -> listOfNotNull(resource.device) },
    )

  public val Encounter: SearchParam<Media, Reference> =
    SimpleSearchParam<Media, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.encounter",
      target = listOf(dev.ohs.fhir.model.r4.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<Media, Identifier> =
    SimpleSearchParam<Media, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Media.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Modality: SearchParam<Media, CodeableConcept> =
    SimpleSearchParam<Media, CodeableConcept>(
      name = "modality",
      type = SearchParamType.fromCode("token"),
      expression = "Media.modality",
      extractor = { resource -> listOfNotNull(resource.modality) },
    )

  public val Operator: SearchParam<Media, Reference> =
    SimpleSearchParam<Media, Reference>(
      name = "operator",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.operator",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          dev.ohs.fhir.model.r4.Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.`operator`) },
    )

  public val Patient: SearchParam<Media, Reference> =
    SimpleSearchParam<Media, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Site: SearchParam<Media, CodeableConcept> =
    SimpleSearchParam<Media, CodeableConcept>(
      name = "site",
      type = SearchParamType.fromCode("token"),
      expression = "Media.bodySite",
      extractor = { resource -> listOfNotNull(resource.bodySite) },
    )

  public val Status: SearchParam<Media, Any> =
    SimpleSearchParam<Media, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Media.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<Media, Reference> =
    SimpleSearchParam<Media, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Media.subject",
      target =
        listOf(
          Practitioner::class,
          Group::class,
          Specimen::class,
          dev.ohs.fhir.model.r4.Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
          Location::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val Type: SearchParam<Media, CodeableConcept> =
    SimpleSearchParam<Media, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Media.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val View: SearchParam<Media, CodeableConcept> =
    SimpleSearchParam<Media, CodeableConcept>(
      name = "view",
      type = SearchParamType.fromCode("token"),
      expression = "Media.view",
      extractor = { resource -> listOfNotNull(resource.view) },
    )

  /** All search parameters for the Media resource type. */
  public val ALL: List<SearchParam<Media, *>> =
    listOf(
      BasedOn,
      Created,
      Device,
      Encounter,
      Identifier,
      Modality,
      Operator,
      Patient,
      Site,
      Status,
      Subject,
      Type,
      View,
    )
}
