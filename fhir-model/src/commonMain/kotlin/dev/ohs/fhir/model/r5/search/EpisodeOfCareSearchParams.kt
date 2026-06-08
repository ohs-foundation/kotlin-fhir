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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EpisodeOfCare] resource type. */
public object EpisodeOfCareSearchParams {
  public val careManager: SearchParam<EpisodeOfCare, Reference> =
    SearchParam(
      name = "care-manager",
      type = SearchParamType.Reference,
      expression = "EpisodeOfCare.careManager.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        listOfNotNull(resource.careManager).filter {
          it.reference?.value?.toString()?.contains("Practitioner/") == true
        }
      },
    )

  public val date: SearchParam<EpisodeOfCare, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "EpisodeOfCare.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val diagnosisCode: SearchParam<EpisodeOfCare, CodeableConcept> =
    SearchParam(
      name = "diagnosis-code",
      type = SearchParamType.Token,
      expression = "EpisodeOfCare.diagnosis.condition.concept",
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
      },
    )

  public val diagnosisReference: SearchParam<EpisodeOfCare, Reference> =
    SearchParam(
      name = "diagnosis-reference",
      type = SearchParamType.Reference,
      expression = "EpisodeOfCare.diagnosis.condition.reference",
      target = listOf(Condition::class),
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
      },
    )

  public val identifier: SearchParam<EpisodeOfCare, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "EpisodeOfCare.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val incomingReferral: SearchParam<EpisodeOfCare, Reference> =
    SearchParam(
      name = "incoming-referral",
      type = SearchParamType.Reference,
      expression = "EpisodeOfCare.referralRequest",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.referralRequest },
    )

  public val organization: SearchParam<EpisodeOfCare, Reference> =
    SearchParam(
      name = "organization",
      type = SearchParamType.Reference,
      expression = "EpisodeOfCare.managingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val patient: SearchParam<EpisodeOfCare, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "EpisodeOfCare.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val reasonCode: SearchParam<EpisodeOfCare, CodeableConcept> =
    SearchParam(
      name = "reason-code",
      type = SearchParamType.Token,
      expression = "EpisodeOfCare.reason.value.concept",
      extractor = { resource -> resource.reason.flatMap { it.`value` }.mapNotNull { it.concept } },
    )

  public val reasonReference: SearchParam<EpisodeOfCare, Reference> =
    SearchParam(
      name = "reason-reference",
      type = SearchParamType.Reference,
      expression = "EpisodeOfCare.reason.value.reference",
      target =
        listOf(HealthcareService::class, Procedure::class, Observation::class, Condition::class),
      extractor = { resource -> resource.reason.flatMap { it.`value` }.mapNotNull { it.reference } },
    )

  public val status: SearchParam<EpisodeOfCare, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "EpisodeOfCare.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val type: SearchParam<EpisodeOfCare, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "EpisodeOfCare.type",
      extractor = { resource -> resource.type },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<EpisodeOfCare, *>> = listOf()

  /**
   * Supported search parameters for the EpisodeOfCare resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<EpisodeOfCare, *>> =
    listOf(
      careManager,
      date,
      diagnosisCode,
      diagnosisReference,
      identifier,
      incomingReferral,
      organization,
      patient,
      reasonCode,
      reasonReference,
      status,
      type,
    )
}
