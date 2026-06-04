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

import dev.ohs.fhir.model.r5.AllergyIntolerance
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AllergyIntolerance] resource type. */
public object AllergyIntoleranceSearchParams {
  public val category: SearchParam<AllergyIntolerance, Any> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.category",
      extractor = { resource -> resource.category },
    )

  public val clinicalStatus: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "clinical-status",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.clinicalStatus",
      extractor = { resource -> listOfNotNull(resource.clinicalStatus) },
    )

  public val code: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val criticality: SearchParam<AllergyIntolerance, Any> =
    SearchParam(
      name = "criticality",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.criticality",
      extractor = { resource -> listOfNotNull(resource.criticality) },
    )

  public val date: SearchParam<AllergyIntolerance, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "AllergyIntolerance.recordedDate",
      extractor = { resource -> listOfNotNull(resource.recordedDate) },
    )

  public val identifier: SearchParam<AllergyIntolerance, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val lastDate: SearchParam<AllergyIntolerance, DateTime> =
    SearchParam(
      name = "last-date",
      type = SearchParamType.fromCode("date"),
      expression = "AllergyIntolerance.lastOccurrence",
      extractor = { resource -> listOfNotNull(resource.lastOccurrence) },
    )

  public val manifestationCode: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "manifestation-code",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.reaction.manifestation.concept",
      extractor = { resource ->
        resource.reaction.flatMap { it.manifestation }.mapNotNull { it.concept }
      },
    )

  public val manifestationReference: SearchParam<AllergyIntolerance, Reference> =
    SearchParam(
      name = "manifestation-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "AllergyIntolerance.reaction.manifestation.reference",
      target = listOf(Observation::class),
      extractor = { resource ->
        resource.reaction.flatMap { it.manifestation }.mapNotNull { it.reference }
      },
    )

  public val participant: SearchParam<AllergyIntolerance, Reference> =
    SearchParam(
      name = "participant",
      type = SearchParamType.fromCode("reference"),
      expression = "AllergyIntolerance.participant.actor",
      target =
        listOf(
          Device::class,
          Organization::class,
          CareTeam::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.participant.map { it.actor } },
    )

  public val patient: SearchParam<AllergyIntolerance, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "AllergyIntolerance.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val route: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "route",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.reaction.exposureRoute",
      extractor = { resource -> resource.reaction.mapNotNull { it.exposureRoute } },
    )

  public val severity: SearchParam<AllergyIntolerance, Any> =
    SearchParam(
      name = "severity",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.reaction.severity",
      extractor = { resource -> resource.reaction.mapNotNull { it.severity } },
    )

  public val type: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val verificationStatus: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "verification-status",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.verificationStatus",
      extractor = { resource -> listOfNotNull(resource.verificationStatus) },
    )

  /** All search parameters for the AllergyIntolerance resource type. */
  public val all: List<SearchParam<AllergyIntolerance, *>> =
    listOf(
      category,
      clinicalStatus,
      code,
      criticality,
      date,
      identifier,
      lastDate,
      manifestationCode,
      manifestationReference,
      participant,
      patient,
      route,
      severity,
      type,
      verificationStatus,
    )
}
