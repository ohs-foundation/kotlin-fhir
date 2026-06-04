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

import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CareTeam] resource type. */
public object CareTeamSearchParams {
  public val category: SearchParam<CareTeam, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "CareTeam.category",
      extractor = { resource -> resource.category },
    )

  public val date: SearchParam<CareTeam, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CareTeam.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val encounter: SearchParam<CareTeam, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "CareTeam.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<CareTeam, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CareTeam.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val participant: SearchParam<CareTeam, Reference> =
    SearchParam(
      name = "participant",
      type = SearchParamType.fromCode("reference"),
      expression = "CareTeam.participant.member",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.participant.mapNotNull { it.member } },
    )

  public val patient: SearchParam<CareTeam, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "CareTeam.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val status: SearchParam<CareTeam, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CareTeam.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val subject: SearchParam<CareTeam, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "CareTeam.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  /** All search parameters for the CareTeam resource type. */
  public val all: List<SearchParam<CareTeam, *>> =
    listOf(category, date, encounter, identifier, participant, patient, status, subject)
}
