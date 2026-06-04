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
import dev.ohs.fhir.model.r4b.DiagnosticReport
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ImmunizationRecommendation
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Media
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.NutritionOrder
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Specimen
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DiagnosticReport] resource type. */
public object DiagnosticReportSearchParams {
  public val assessedCondition: SearchParam<DiagnosticReport, Any> =
    SearchParam(
      name = "assessed-condition",
      type = SearchParamType.fromCode("reference"),
      expression =
        "DiagnosticReport.extension('http://hl7.org/fhir/StructureDefinition/DiagnosticReport-geneticsAssessedCondition')",
      extractor = { emptyList() },
    )

  public val basedOn: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.basedOn",
      target =
        listOf(
          CarePlan::class,
          MedicationRequest::class,
          NutritionOrder::class,
          ServiceRequest::class,
          ImmunizationRecommendation::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val category: SearchParam<DiagnosticReport, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<DiagnosticReport, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val conclusion: SearchParam<DiagnosticReport, CodeableConcept> =
    SearchParam(
      name = "conclusion",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.conclusionCode",
      extractor = { resource -> resource.conclusionCode },
    )

  public val date: SearchParam<DiagnosticReport, DiagnosticReport.Effective> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "DiagnosticReport.effective",
      extractor = { resource -> listOfNotNull(resource.effective) },
    )

  public val encounter: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<DiagnosticReport, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val issued: SearchParam<DiagnosticReport, Instant> =
    SearchParam(
      name = "issued",
      type = SearchParamType.fromCode("date"),
      expression = "DiagnosticReport.issued",
      extractor = { resource -> listOfNotNull(resource.issued) },
    )

  public val media: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "media",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.media.link",
      target = listOf(Media::class),
      extractor = { resource -> resource.media.map { it.link } },
    )

  public val patient: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.performer",
      target =
        listOf(Practitioner::class, Organization::class, CareTeam::class, PractitionerRole::class),
      extractor = { resource -> resource.performer },
    )

  public val result: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "result",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.result",
      target = listOf(Observation::class),
      extractor = { resource -> resource.result },
    )

  public val resultsInterpreter: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "results-interpreter",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.resultsInterpreter",
      target =
        listOf(Practitioner::class, Organization::class, CareTeam::class, PractitionerRole::class),
      extractor = { resource -> resource.resultsInterpreter },
    )

  public val specimen: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "specimen",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.specimen",
      target = listOf(Specimen::class),
      extractor = { resource -> resource.specimen },
    )

  public val status: SearchParam<DiagnosticReport, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<DiagnosticReport, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.subject",
      target =
        listOf(
          Practitioner::class,
          Group::class,
          Organization::class,
          Device::class,
          Medication::class,
          Patient::class,
          Procedure::class,
          Substance::class,
          Location::class,
        ),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the DiagnosticReport resource type. */
  public val all: List<SearchParam<DiagnosticReport, *>> =
    listOf(
      assessedCondition,
      basedOn,
      category,
      code,
      conclusion,
      date,
      encounter,
      identifier,
      issued,
      media,
      patient,
      performer,
      result,
      resultsInterpreter,
      specimen,
      status,
      subject,
    )
}
