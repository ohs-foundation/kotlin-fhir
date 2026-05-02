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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CareTeam] resource type. */
public sealed class CareTeamSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CareTeam): List<T>

  public data object Category : CareTeamSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CareTeam.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CareTeam): List<CodeableConcept> = resource.category
  }

  public data object Date : CareTeamSearchParam<Any>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String =
      "AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Identifier : CareTeamSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CareTeam.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CareTeam): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Name : CareTeamSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CareTeam.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CareTeam): List<String> = listOfNotNull(resource.name)
  }

  public data object Participant : CareTeamSearchParam<Reference>() {
    public override val paramName: kotlin.String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CareTeam.participant.member"

    public override val target: List<kotlin.String> =
      listOf(
        "Organization",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: CareTeam): List<Reference> =
      resource.participant.mapNotNull { it.member }
  }

  public data object Patient : CareTeamSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CareTeam.subject.where(resolve() is Patient)"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: CareTeam): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Status : CareTeamSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CareTeam.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = listOfNotNull(resource.status)
  }

  public data object Subject : CareTeamSearchParam<Reference>() {
    public override val paramName: kotlin.String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CareTeam.subject"

    public override val target: List<kotlin.String> = listOf("Group", "Patient")

    public override fun extract(resource: CareTeam): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public companion object {
    /** All search parameters for the CareTeam resource type. */
    public val ALL: List<CareTeamSearchParam<*>> =
      listOf(Category, Date, Identifier, Name, Participant, Patient, Status, Subject)
  }
}
