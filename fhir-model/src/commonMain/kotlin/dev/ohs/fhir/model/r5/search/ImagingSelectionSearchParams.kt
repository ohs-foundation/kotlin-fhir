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
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImagingSelection
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.Task
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImagingSelection] resource type. */
public object ImagingSelectionSearchParams {
  public val basedOn: SearchParam<ImagingSelection, Reference> =
    SearchParam<ImagingSelection, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingSelection.basedOn",
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

  public val bodySite: SearchParam<ImagingSelection, CodeableConcept> =
    SearchParam<ImagingSelection, CodeableConcept>(
      name = "body-site",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingSelection.bodySite.concept",
      extractor = { resource -> listOfNotNull(resource.bodySite?.concept) },
    )

  public val bodyStructure: SearchParam<ImagingSelection, Reference> =
    SearchParam<ImagingSelection, Reference>(
      name = "body-structure",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingSelection.bodySite.reference",
      target = listOf(BodyStructure::class),
      extractor = { resource -> listOfNotNull(resource.bodySite?.reference) },
    )

  public val code: SearchParam<ImagingSelection, Any> =
    SearchParam<ImagingSelection, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingSelection.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val derivedFrom: SearchParam<ImagingSelection, Reference> =
    SearchParam<ImagingSelection, Reference>(
      name = "derived-from",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingSelection.derivedFrom",
      target = listOf(ImagingStudy::class, DocumentReference::class),
      extractor = { resource -> resource.derivedFrom },
    )

  public val identifier: SearchParam<ImagingSelection, Identifier> =
    SearchParam<ImagingSelection, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingSelection.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val issued: SearchParam<ImagingSelection, Instant> =
    SearchParam<ImagingSelection, Instant>(
      name = "issued",
      type = SearchParamType.fromCode("date"),
      expression = "ImagingSelection.issued",
      extractor = { resource -> listOfNotNull(resource.issued) },
    )

  public val patient: SearchParam<ImagingSelection, Reference> =
    SearchParam<ImagingSelection, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingSelection.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val status: SearchParam<ImagingSelection, Any> =
    SearchParam<ImagingSelection, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingSelection.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val studyUid: SearchParam<ImagingSelection, Id> =
    SearchParam<ImagingSelection, Id>(
      name = "study-uid",
      type = SearchParamType.fromCode("token"),
      expression = "ImagingSelection.studyUid",
      extractor = { resource -> listOfNotNull(resource.studyUid) },
    )

  public val subject: SearchParam<ImagingSelection, Reference> =
    SearchParam<ImagingSelection, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ImagingSelection.subject",
      target =
        listOf(
          Device::class,
          Organization::class,
          Procedure::class,
          Group::class,
          Practitioner::class,
          Specimen::class,
          Substance::class,
          Location::class,
          Patient::class,
          Medication::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the ImagingSelection resource type. */
  public val all: List<SearchParam<ImagingSelection, *>> =
    listOf(
      basedOn,
      bodySite,
      bodyStructure,
      code,
      derivedFrom,
      identifier,
      issued,
      patient,
      status,
      studyUid,
      subject,
    )
}
