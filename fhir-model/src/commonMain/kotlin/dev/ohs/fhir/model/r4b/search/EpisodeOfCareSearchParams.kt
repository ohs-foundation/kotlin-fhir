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
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.EpisodeOfCare
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EpisodeOfCare] resource type. */
public object EpisodeOfCareSearchParams {
  public val careManager: SearchParam<EpisodeOfCare, Reference> =
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

  public val condition: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "condition",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.diagnosis.condition",
      target = listOf(Condition::class),
      extractor = { resource -> resource.diagnosis.map { it.condition } },
    )

  public val date: SearchParam<EpisodeOfCare, Period> =
    SimpleSearchParam<EpisodeOfCare, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "EpisodeOfCare.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val identifier: SearchParam<EpisodeOfCare, Identifier> =
    SimpleSearchParam<EpisodeOfCare, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "EpisodeOfCare.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val incomingReferral: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "incoming-referral",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.referralRequest",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.referralRequest },
    )

  public val organization: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.managingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.managingOrganization) },
    )

  public val patient: SearchParam<EpisodeOfCare, Reference> =
    SimpleSearchParam<EpisodeOfCare, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "EpisodeOfCare.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val status: SearchParam<EpisodeOfCare, Any> =
    SimpleSearchParam<EpisodeOfCare, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "EpisodeOfCare.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val type: SearchParam<EpisodeOfCare, CodeableConcept> =
    SimpleSearchParam<EpisodeOfCare, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "EpisodeOfCare.type",
      extractor = { resource -> resource.type },
    )

  /** All search parameters for the EpisodeOfCare resource type. */
  public val all: List<SearchParam<EpisodeOfCare, *>> =
    listOf(
      careManager,
      condition,
      date,
      identifier,
      incomingReferral,
      organization,
      patient,
      status,
      type,
    )
}
