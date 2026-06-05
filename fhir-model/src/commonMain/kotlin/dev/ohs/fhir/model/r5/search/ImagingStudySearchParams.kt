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

import dev.ohs.fhir.model.r5.Appointment
import dev.ohs.fhir.model.r5.AppointmentResponse
import dev.ohs.fhir.model.r5.BodyStructure
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Endpoint
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Task
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImagingStudy] resource type. */
public object ImagingStudySearchParams {
  public val basedOn: SearchParam<ImagingStudy, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.basedOn",
      target =
        listOf(
          Appointment::class,
          ServiceRequest::class,
          CarePlan::class,
          Task::class,
          AppointmentResponse::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val bodySite: SearchParam<ImagingStudy, CodeableConcept> =
    SearchParam(
      name = "body-site",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.bodySite.concept",
      extractor = { resource ->
        resource.series.mapNotNull { it.bodySite }.mapNotNull { it.concept }
      },
    )

  public val bodyStructure: SearchParam<ImagingStudy, Reference> =
    SearchParam(
      name = "body-structure",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.series.bodySite.reference",
      target = listOf(BodyStructure::class),
      extractor = { resource ->
        resource.series.mapNotNull { it.bodySite }.mapNotNull { it.reference }
      },
    )

  public val dicomClass: SearchParam<ImagingStudy, Coding> =
    SearchParam(
      name = "dicom-class",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.instance.sopClass",
      extractor = { resource -> resource.series.flatMap { it.instance }.map { it.sopClass } },
    )

  public val encounter: SearchParam<ImagingStudy, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val endpoint: SearchParam<ImagingStudy, Reference> =
    SearchParam(
      name = "endpoint",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.endpoint",
      target = listOf(Endpoint::class),
      extractor = { resource -> resource.endpoint },
    )

  public val identifier: SearchParam<ImagingStudy, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instance: SearchParam<ImagingStudy, Id> =
    SearchParam(
      name = "instance",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.instance.uid",
      extractor = { resource -> resource.series.flatMap { it.instance }.map { it.uid } },
    )

  public val modality: SearchParam<ImagingStudy, CodeableConcept> =
    SearchParam(
      name = "modality",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.modality",
      extractor = { resource -> resource.series.map { it.modality } },
    )

  public val patient: SearchParam<ImagingStudy, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<ImagingStudy, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.series.performer.actor",
      target =
        listOf(
          HealthcareService::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.series.flatMap { it.performer }.map { it.actor } },
    )

  public val reason: SearchParam<ImagingStudy, Any> =
    SearchParam(
      name = "reason",
      type = SearchParamType.fromCode("token"),
      expression = "",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'reason' has expression '' which is not yet supported."
        )
      },
    )

  public val referrer: SearchParam<ImagingStudy, Reference> =
    SearchParam(
      name = "referrer",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.referrer",
      target = listOf(PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.referrer) },
    )

  public val series: SearchParam<ImagingStudy, Id> =
    SearchParam(
      name = "series",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.series.uid",
      extractor = { resource -> resource.series.map { it.uid } },
    )

  public val started: SearchParam<ImagingStudy, DateTime> =
    SearchParam(
      name = "started",
      type = SearchParamType.fromCode("date"),
      expression = "ImagingStudy.started",
      extractor = { resource -> listOfNotNull(resource.started) },
    )

  public val status: SearchParam<ImagingStudy, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingStudy.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<ImagingStudy, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingStudy.subject",
      target = listOf(Device::class, Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ImagingStudy, *>> = listOf(reason)

  /**
   * Supported search parameters for the ImagingStudy resource type. Entries in [unsupported] are
   * excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<ImagingStudy, *>> =
    listOf(
      basedOn,
      bodySite,
      bodyStructure,
      dicomClass,
      encounter,
      endpoint,
      identifier,
      instance,
      modality,
      patient,
      performer,
      reason,
      referrer,
      series,
      started,
      status,
      subject,
    ) - unsupported.toSet()
}
