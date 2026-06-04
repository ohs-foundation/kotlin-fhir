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

import dev.ohs.fhir.model.r4b.Appointment
import dev.ohs.fhir.model.r4b.AppointmentResponse
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ImagingStudy
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Task
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImagingStudy] resource type. */
public object ImagingStudySearchParams {
  public val Basedon: SearchParam<ImagingStudy, Reference> =
    SimpleSearchParam<ImagingStudy, Reference>(
      name = "basedon",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.basedOn",
      target =
        listOf(
          Appointment::class,
          AppointmentResponse::class,
          CarePlan::class,
          Task::class,
          ServiceRequest::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val Bodysite: SearchParam<ImagingStudy, Coding> =
    SimpleSearchParam<ImagingStudy, Coding>(
      name = "bodysite",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.bodySite",
      extractor = { resource -> resource.series.mapNotNull { it.bodySite } },
    )

  public val DicomClass: SearchParam<ImagingStudy, Coding> =
    SimpleSearchParam<ImagingStudy, Coding>(
      name = "dicom-class",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.instance.sopClass",
      extractor = { resource -> resource.series.flatMap { it.instance }.map { it.sopClass } },
    )

  public val Encounter: SearchParam<ImagingStudy, Reference> =
    SimpleSearchParam<ImagingStudy, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.encounter",
      target = listOf(dev.ohs.fhir.model.r4b.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Endpoint: SearchParam<ImagingStudy, Reference> =
    SimpleSearchParam<ImagingStudy, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.endpoint",
      target = listOf(dev.ohs.fhir.model.r4b.Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val Identifier: SearchParam<ImagingStudy, Identifier> =
    SimpleSearchParam<ImagingStudy, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Instance: SearchParam<ImagingStudy, Id> =
    SimpleSearchParam<ImagingStudy, Id>(
      name = "instance",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.instance.uid",
      extractor = { resource -> resource.series.flatMap { it.instance }.map { it.uid } },
    )

  public val Interpreter: SearchParam<ImagingStudy, Reference> =
    SimpleSearchParam<ImagingStudy, Reference>(
      name = "interpreter",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.interpreter",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> resource.interpreter },
    )

  public val Modality: SearchParam<ImagingStudy, Coding> =
    SimpleSearchParam<ImagingStudy, Coding>(
      name = "modality",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.modality",
      extractor = { resource -> resource.series.map { it.modality } },
    )

  public val Patient: SearchParam<ImagingStudy, Reference> =
    SimpleSearchParam<ImagingStudy, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<ImagingStudy, Reference> =
    SimpleSearchParam<ImagingStudy, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.series.performer.actor",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.series.flatMap { it.performer }.map { it.actor } },
    )

  public val Reason: SearchParam<ImagingStudy, CodeableConcept> =
    SimpleSearchParam<ImagingStudy, CodeableConcept>(
      name = "reason",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.reasonCode",
      extractor = { resource -> resource.reasonCode },
    )

  public val Referrer: SearchParam<ImagingStudy, Reference> =
    SimpleSearchParam<ImagingStudy, Reference>(
      name = "referrer",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.referrer",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.referrer) },
    )

  public val Series: SearchParam<ImagingStudy, Id> =
    SimpleSearchParam<ImagingStudy, Id>(
      name = "series",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.uid",
      extractor = { resource -> resource.series.map { it.uid } },
    )

  public val Started: SearchParam<ImagingStudy, DateTime> =
    SimpleSearchParam<ImagingStudy, DateTime>(
      name = "started",
      type = SearchParamType.fromCode("date"),
      expression = "ImagingStudy.started",
      extractor = { resource -> listOfNotNull(resource.started) },
    )

  public val Status: SearchParam<ImagingStudy, Any> =
    SimpleSearchParam<ImagingStudy, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<ImagingStudy, Reference> =
    SimpleSearchParam<ImagingStudy, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.subject",
      target = listOf(Group::class, Device::class, dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the ImagingStudy resource type. */
  public val ALL: List<SearchParam<ImagingStudy, *>> =
    listOf(
      Basedon,
      Bodysite,
      DicomClass,
      Encounter,
      Endpoint,
      Identifier,
      Instance,
      Interpreter,
      Modality,
      Patient,
      Performer,
      Reason,
      Referrer,
      Series,
      Started,
      Status,
      Subject,
    )
}
