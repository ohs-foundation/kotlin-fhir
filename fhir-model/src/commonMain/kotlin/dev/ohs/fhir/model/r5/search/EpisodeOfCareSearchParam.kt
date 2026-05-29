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
public object EpisodeOfCareSearchParam {
  public val CareManager: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "care-manager",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.careManager.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        listOfNotNull(resource.careManager).filter {
          it.reference?.value?.toString()?.contains("Practitioner/") == true
        }
      },
    )

  public val Date: SearchParam<EpisodeOfCare, Period> =
    SimpleSearchParam<EpisodeOfCare, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "EpisodeOfCare.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val DiagnosisCode: SearchParam<EpisodeOfCare, CodeableConcept> =
    SimpleSearchParam<EpisodeOfCare, CodeableConcept>(
      name = "diagnosis-code",
      type = SearchParamType.fromCode("token"),
      expression = "EpisodeOfCare.diagnosis.condition.concept",
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
      },
    )

  public val DiagnosisReference: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "diagnosis-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.diagnosis.condition.reference",
      target = listOf(Condition::class),
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
      },
    )

  public val Identifier: SearchParam<EpisodeOfCare, Identifier> =
    SimpleSearchParam<EpisodeOfCare, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "EpisodeOfCare.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val IncomingReferral: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "incoming-referral",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.referralRequest",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.referralRequest },
    )

  public val Organization: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.managingOrganization",
      target = listOf(dev.ohs.fhir.model.r5.Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val Patient: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.patient",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val ReasonCode: SearchParam<EpisodeOfCare, CodeableConcept> =
    SimpleSearchParam<EpisodeOfCare, CodeableConcept>(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "EpisodeOfCare.reason.value.concept",
      extractor = { resource -> resource.reason.flatMap { it.`value` }.mapNotNull { it.concept } },
    )

  public val ReasonReference: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "reason-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.reason.value.reference",
      target =
        listOf(HealthcareService::class, Procedure::class, Observation::class, Condition::class),
      extractor = { resource -> resource.reason.flatMap { it.`value` }.mapNotNull { it.reference } },
    )

  public val Status: SearchParam<EpisodeOfCare, Any> =
    SimpleSearchParam<EpisodeOfCare, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "EpisodeOfCare.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Type: SearchParam<EpisodeOfCare, CodeableConcept> =
    SimpleSearchParam<EpisodeOfCare, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "EpisodeOfCare.type",
      extractor = { resource -> resource.type },
    )

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
}
