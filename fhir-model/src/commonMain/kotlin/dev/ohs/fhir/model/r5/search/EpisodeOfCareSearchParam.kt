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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.EpisodeOfCare
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [EpisodeOfCare] resource type. */
public object EpisodeOfCareSearchParam {
  /** All search parameters for the EpisodeOfCare resource type. */
  public val ALL: List<SearchParam<EpisodeOfCare, *>> =
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

  public data object CareManager : SearchParam<EpisodeOfCare, Reference> {
    public override val paramName: String = "care-manager"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "EpisodeOfCare.careManager.where(resolve() is Practitioner)"

    public override val target: List<KClass<out Resource>> = listOf(Practitioner::class)

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      listOfNotNull(resource.careManager).filter {
        it.reference?.value?.toString()?.contains("Practitioner/") == true
      }
  }

  public data object Date : SearchParam<EpisodeOfCare, Period> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "EpisodeOfCare.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object DiagnosisCode : SearchParam<EpisodeOfCare, CodeableConcept> {
    public override val paramName: String = "diagnosis-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.diagnosis.condition.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<CodeableConcept> =
      resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
  }

  public data object DiagnosisReference : SearchParam<EpisodeOfCare, Reference> {
    public override val paramName: String = "diagnosis-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.diagnosis.condition.reference"

    public override val target: List<KClass<out Resource>> = listOf(Condition::class)

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
  }

  public data object Identifier : SearchParam<EpisodeOfCare, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object IncomingReferral : SearchParam<EpisodeOfCare, Reference> {
    public override val paramName: String = "incoming-referral"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.referralRequest"

    public override val target: List<KClass<out Resource>> = listOf(ServiceRequest::class)

    public override fun extract(resource: EpisodeOfCare): List<Reference> = resource.referralRequest
  }

  public data object Organization : SearchParam<EpisodeOfCare, Reference> {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.managingOrganization"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Organization::class)

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      listOfNotNull(resource.managingOrganization)
  }

  public data object Patient : SearchParam<EpisodeOfCare, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: EpisodeOfCare): List<Reference> = listOf(resource.patient)
  }

  public data object ReasonCode : SearchParam<EpisodeOfCare, CodeableConcept> {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.reason.value.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<CodeableConcept> =
      resource.reason.flatMap { it.value }.mapNotNull { it.concept }
  }

  public data object ReasonReference : SearchParam<EpisodeOfCare, Reference> {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.reason.value.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(HealthcareService::class, Procedure::class, Observation::class, Condition::class)

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      resource.reason.flatMap { it.value }.mapNotNull { it.reference }
  }

  public data object Status : SearchParam<EpisodeOfCare, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<Any> = listOf(resource.status)
  }

  public data object Type : SearchParam<EpisodeOfCare, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<CodeableConcept> = resource.type
  }
}
