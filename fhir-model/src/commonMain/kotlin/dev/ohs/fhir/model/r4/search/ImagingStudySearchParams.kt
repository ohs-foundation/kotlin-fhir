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

import dev.ohs.fhir.model.r4.Appointment
import dev.ohs.fhir.model.r4.AppointmentResponse
import dev.ohs.fhir.model.r4.CarePlan
import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.Endpoint
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.ImagingStudy
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.Task
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImagingStudy] resource type. */
public object ImagingStudySearchParams {
  public val basedon: SearchParam<ImagingStudy, Reference> =
    SearchParam<ImagingStudy, Reference>(
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

  public val bodysite: SearchParam<ImagingStudy, Coding> =
    SearchParam<ImagingStudy, Coding>(
      name = "bodysite",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.bodySite",
      extractor = { resource -> resource.series.mapNotNull { it.bodySite } },
    )

  public val dicomClass: SearchParam<ImagingStudy, Coding> =
    SearchParam<ImagingStudy, Coding>(
      name = "dicom-class",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.instance.sopClass",
      extractor = { resource -> resource.series.flatMap { it.instance }.map { it.sopClass } },
    )

  public val encounter: SearchParam<ImagingStudy, Reference> =
    SearchParam<ImagingStudy, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val endpoint: SearchParam<ImagingStudy, Reference> =
    SearchParam<ImagingStudy, Reference>(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<ImagingStudy, Identifier> =
    SearchParam<ImagingStudy, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instance: SearchParam<ImagingStudy, Id> =
    SearchParam<ImagingStudy, Id>(
      name = "instance",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.instance.uid",
      extractor = { resource -> resource.series.flatMap { it.instance }.map { it.uid } },
    )

  public val interpreter: SearchParam<ImagingStudy, Reference> =
    SearchParam<ImagingStudy, Reference>(
      name = "interpreter",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.interpreter",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> resource.interpreter },
    )

  public val modality: SearchParam<ImagingStudy, Coding> =
    SearchParam<ImagingStudy, Coding>(
      name = "modality",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.modality",
      extractor = { resource -> resource.series.map { it.modality } },
    )

  public val patient: SearchParam<ImagingStudy, Reference> =
    SearchParam<ImagingStudy, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.subject.where(resolve() is Patient)",
      target = listOf(Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<ImagingStudy, Reference> =
    SearchParam<ImagingStudy, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.series.performer.actor",
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
      extractor = { resource -> resource.series.flatMap { it.performer }.map { it.actor } },
    )

  public val reason: SearchParam<ImagingStudy, CodeableConcept> =
    SearchParam<ImagingStudy, CodeableConcept>(
      name = "reason",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.reasonCode",
      extractor = { resource -> resource.reasonCode },
    )

  public val referrer: SearchParam<ImagingStudy, Reference> =
    SearchParam<ImagingStudy, Reference>(
      name = "referrer",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.referrer",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.referrer) },
    )

  public val series: SearchParam<ImagingStudy, Id> =
    SearchParam<ImagingStudy, Id>(
      name = "series",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.uid",
      extractor = { resource -> resource.series.map { it.uid } },
    )

  public val started: SearchParam<ImagingStudy, DateTime> =
    SearchParam<ImagingStudy, DateTime>(
      name = "started",
      type = SearchParamType.fromCode("date"),
      expression = "ImagingStudy.started",
      extractor = { resource -> listOfNotNull(resource.started) },
    )

  public val status: SearchParam<ImagingStudy, Any> =
    SearchParam<ImagingStudy, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<ImagingStudy, Reference> =
    SearchParam<ImagingStudy, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.subject",
      target = listOf(Group::class, Device::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the ImagingStudy resource type. */
  public val all: List<SearchParam<ImagingStudy, *>> =
    listOf(
      basedon,
      bodysite,
      dicomClass,
      encounter,
      endpoint,
      identifier,
      instance,
      interpreter,
      modality,
      patient,
      performer,
      reason,
      referrer,
      series,
      started,
      status,
      subject,
    )
}
