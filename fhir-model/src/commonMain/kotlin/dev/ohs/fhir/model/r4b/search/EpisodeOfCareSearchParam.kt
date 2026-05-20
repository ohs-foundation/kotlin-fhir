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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.EpisodeOfCare
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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

  public data object Condition : EpisodeOfCareSearchParam<Reference>() {
    public override val paramName: String = "condition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EpisodeOfCare.diagnosis.condition"

    public override val target: List<String> = listOf("Condition")

    public override fun extract(resource: EpisodeOfCare): List<Reference> =
      resource.diagnosis.map { it.condition }
  }

  public data object Date : EpisodeOfCareSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "EpisodeOfCare.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Identifier : EpisodeOfCareSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EpisodeOfCare.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EpisodeOfCare): List<dev.ohs.fhir.model.r4b.Identifier> =
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
        Condition,
        Date,
        Identifier,
        IncomingReferral,
        Organization,
        Patient,
        Status,
        Type,
      )
  }
}
