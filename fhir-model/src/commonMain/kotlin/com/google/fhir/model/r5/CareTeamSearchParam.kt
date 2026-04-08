/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CareTeam] resource type. */
public sealed class CareTeamSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CareTeam): List<T>

  public data object Category : CareTeamSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Date : CareTeamSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String =
      "AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Identifier : CareTeamSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Name : CareTeamSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CareTeam.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Participant : CareTeamSearchParam<Any>() {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.participant.member"

    public override val target: List<String> =
      listOf(
        "Organization",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Patient : CareTeamSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Status : CareTeamSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CareTeam.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public data object Subject : CareTeamSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CareTeam.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: CareTeam): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the CareTeam resource type. */
    public val ALL: List<CareTeamSearchParam<*>> =
      listOf(Category, Date, Identifier, Name, Participant, Patient, Status, Subject)
  }
}
