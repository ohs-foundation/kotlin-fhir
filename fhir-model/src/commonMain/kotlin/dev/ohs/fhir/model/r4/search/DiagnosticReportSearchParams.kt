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
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.DiagnosticReport
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.ImmunizationRecommendation
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.NutritionOrder
import dev.ohs.fhir.model.r4.Observation
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DiagnosticReport] resource type. */
public object DiagnosticReportSearchParams {
  public val AssessedCondition: SearchParam<DiagnosticReport, Any> =
    SimpleSearchParam<DiagnosticReport, Any>(
      name = "assessed-condition",
      type = SearchParamType.fromCode("reference"),
      expression =
        "DiagnosticReport.extension('http://hl7.org/fhir/StructureDefinition/DiagnosticReport-geneticsAssessedCondition')",
      extractor = { emptyList() },
    )

  public val BasedOn: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
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

  public val Category: SearchParam<DiagnosticReport, CodeableConcept> =
    SimpleSearchParam<DiagnosticReport, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.category",
      extractor = { resource -> resource.category },
    )

  public val Code: SearchParam<DiagnosticReport, CodeableConcept> =
    SimpleSearchParam<DiagnosticReport, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val Conclusion: SearchParam<DiagnosticReport, CodeableConcept> =
    SimpleSearchParam<DiagnosticReport, CodeableConcept>(
      name = "conclusion",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.conclusionCode",
      extractor = { resource -> resource.conclusionCode },
    )

  public val Date: SearchParam<DiagnosticReport, DiagnosticReport.Effective> =
    SimpleSearchParam<DiagnosticReport, DiagnosticReport.Effective>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "DiagnosticReport.effective",
      extractor = { resource -> listOfNotNull(resource.effective) },
    )

  public val Encounter: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.encounter",
      target = listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<DiagnosticReport, Identifier> =
    SimpleSearchParam<DiagnosticReport, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Issued: SearchParam<DiagnosticReport, Instant> =
    SimpleSearchParam<DiagnosticReport, Instant>(
      name = "issued",
      type = SearchParamType.fromCode("date"),
      expression = "DiagnosticReport.issued",
      extractor = { resource -> listOfNotNull(resource.issued) },
    )

  public val Media: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
      name = "media",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.media.link",
      target = listOf(dev.ohs.fhir.model.r4.Media::class),
      extractor = { resource -> resource.media.map { it.link } },
    )

  public val Patient: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.performer",
      target =
        listOf(Practitioner::class, Organization::class, CareTeam::class, PractitionerRole::class),
      extractor = { resource -> resource.performer },
    )

  public val Result: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
      name = "result",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.result",
      target = listOf(Observation::class),
      extractor = { resource -> resource.result },
    )

  public val ResultsInterpreter: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
      name = "results-interpreter",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.resultsInterpreter",
      target =
        listOf(Practitioner::class, Organization::class, CareTeam::class, PractitionerRole::class),
      extractor = { resource -> resource.resultsInterpreter },
    )

  public val Specimen: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
      name = "specimen",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.specimen",
      target = listOf(dev.ohs.fhir.model.r4.Specimen::class),
      extractor = { resource -> resource.specimen },
    )

  public val Status: SearchParam<DiagnosticReport, Any> =
    SimpleSearchParam<DiagnosticReport, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "DiagnosticReport.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<DiagnosticReport, Reference> =
    SimpleSearchParam<DiagnosticReport, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "DiagnosticReport.subject",
      target =
        listOf(Group::class, Device::class, dev.ohs.fhir.model.r4.Patient::class, Location::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the DiagnosticReport resource type. */
  public val ALL: List<SearchParam<DiagnosticReport, *>> =
    listOf(
      AssessedCondition,
      BasedOn,
      Category,
      Code,
      Conclusion,
      Date,
      Encounter,
      Identifier,
      Issued,
      Media,
      Patient,
      Performer,
      Result,
      ResultsInterpreter,
      Specimen,
      Status,
      Subject,
    )
}
