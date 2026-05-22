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

import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CareTeam] resource type. */
public object CareTeamSearchParam {
  public val Category: SearchParam<CareTeam, CodeableConcept> =
    SimpleSearchParam<CareTeam, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "CareTeam.category",
      extractor = { resource -> resource.category },
    )

  public val Date: SearchParam<CareTeam, Any> =
    SimpleSearchParam<CareTeam, Any>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression =
        "AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn",
      extractor = { emptyList() },
    )

  public val Identifier: SearchParam<CareTeam, Identifier> =
    SimpleSearchParam<CareTeam, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CareTeam.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<CareTeam, String> =
    SimpleSearchParam<CareTeam, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "CareTeam.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Participant: SearchParam<CareTeam, Reference> =
    SimpleSearchParam<CareTeam, Reference>(
      name = "participant",
      type = SearchParamType.fromCode("reference"),
      expression = "CareTeam.participant.member",
      target =
        listOf(
          Organization::class,
          CareTeam::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.participant.mapNotNull { it.member } },
    )

  public val Patient: SearchParam<CareTeam, Reference> =
    SimpleSearchParam<CareTeam, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "CareTeam.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Status: SearchParam<CareTeam, Any> =
    SimpleSearchParam<CareTeam, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CareTeam.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Subject: SearchParam<CareTeam, Reference> =
    SimpleSearchParam<CareTeam, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "CareTeam.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the CareTeam resource type. */
  public val ALL: List<SearchParam<CareTeam, *>> =
    listOf(Category, Date, Identifier, Name, Participant, Patient, Status, Subject)
}
