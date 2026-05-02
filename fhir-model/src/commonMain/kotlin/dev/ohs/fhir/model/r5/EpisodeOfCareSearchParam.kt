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
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EpisodeOfCare] resource type. */
public sealed class EpisodeOfCareSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: EpisodeOfCare): List<T>

  public data object CareManager : EpisodeOfCareSearchParam<Reference>() {
    public override val paramName: String = "care-manager"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "EpisodeOfCare.careManager.where(resolve() is Practitioner)"

    public override val target: List<String> = listOf("Practitioner")

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      listOfNotNull(resource.careManager).filter {
        it.reference?.value?.toString()?.contains("Practitioner/") == true
      }
  }

  public data object Date : EpisodeOfCareSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "EpisodeOfCare.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object DiagnosisCode : EpisodeOfCareSearchParam<CodeableConcept>() {
    public override val paramName: String = "diagnosis-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.diagnosis.condition.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<CodeableConcept> =
      resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
  }

  public data object DiagnosisReference : EpisodeOfCareSearchParam<Reference>() {
    public override val paramName: String = "diagnosis-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.diagnosis.condition.reference"

    public override val target: List<String> = listOf("Condition")

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
  }

  public data object Identifier : EpisodeOfCareSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object IncomingReferral : EpisodeOfCareSearchParam<Reference>() {
    public override val paramName: String = "incoming-referral"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.referralRequest"

    public override val target: List<String> = listOf("ServiceRequest")

    public override fun extract(resource: EpisodeOfCare): List<Reference> = resource.referralRequest
  }

  public data object Organization : EpisodeOfCareSearchParam<Reference>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.managingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object Patient : EpisodeOfCareSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: EpisodeOfCare): List<Reference> = listOf(resource.patient)
  }

  public data object ReasonCode : EpisodeOfCareSearchParam<CodeableConcept>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.reason.value.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<CodeableConcept> =
      resource.reason.flatMap { it.value }.mapNotNull { it.concept }
  }

  public data object ReasonReference : EpisodeOfCareSearchParam<Reference>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.reason.value.reference"

    public override val target: List<String> =
      listOf("HealthcareService", "Procedure", "Observation", "Condition")

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      resource.reason.flatMap { it.value }.mapNotNull { it.reference }
  }

  public data object Status : EpisodeOfCareSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<Any> = listOf(resource.status)
  }

  public data object Type : EpisodeOfCareSearchParam<CodeableConcept>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<CodeableConcept> = resource.type
  }

  public companion object {
    /** All search parameters for the EpisodeOfCare resource type. */
    public val ALL: List<EpisodeOfCareSearchParam<*>> =
      listOf(
        CareManager,
        Date,
        DiagnosisCode,
        DiagnosisReference,
        Identifier,
        IncomingReferral,
        Organization,
        Patient,
        ReasonCode,
        ReasonReference,
        Status,
        Type,
      )
  }
}
