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
  public val Category: SearchParam<AllergyIntolerance, Any> =
    SimpleSearchParam<AllergyIntolerance, Any>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.category",
      extractor = { resource -> resource.category },
    )

  public val ClinicalStatus: SearchParam<AllergyIntolerance, CodeableConcept> =
    SimpleSearchParam<AllergyIntolerance, CodeableConcept>(
      name = "clinical-status",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.clinicalStatus",
      extractor = { resource -> listOfNotNull(resource.clinicalStatus) },
    )

  public val Code: SearchParam<AllergyIntolerance, CodeableConcept> =
    SimpleSearchParam<AllergyIntolerance, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Criticality: SearchParam<AllergyIntolerance, Any> =
    SimpleSearchParam<AllergyIntolerance, Any>(
      name = "criticality",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.criticality",
      extractor = { resource -> listOfNotNull(resource.criticality) },
    )

  public val Date: SearchParam<AllergyIntolerance, DateTime> =
    SimpleSearchParam<AllergyIntolerance, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "AllergyIntolerance.recordedDate",
      extractor = { resource -> listOfNotNull(resource.recordedDate) },
    )

  public val Identifier: SearchParam<AllergyIntolerance, Identifier> =
    SimpleSearchParam<AllergyIntolerance, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val LastDate: SearchParam<AllergyIntolerance, DateTime> =
    SimpleSearchParam<AllergyIntolerance, DateTime>(
      name = "last-date",
      type = SearchParamType.fromCode("date"),
      expression = "AllergyIntolerance.lastOccurrence",
      extractor = { resource -> listOfNotNull(resource.lastOccurrence) },
    )

  public val ManifestationCode: SearchParam<AllergyIntolerance, CodeableConcept> =
    SimpleSearchParam<AllergyIntolerance, CodeableConcept>(
      name = "manifestation-code",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.reaction.manifestation.concept",
      extractor = { resource ->
        resource.reaction.flatMap { it.manifestation }.mapNotNull { it.concept }
      },
    )

  public val ManifestationReference: SearchParam<AllergyIntolerance, Reference> =
    SimpleSearchParam<AllergyIntolerance, Reference>(
      name = "manifestation-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "AllergyIntolerance.reaction.manifestation.reference",
      target = listOf(Observation::class),
      extractor = { resource ->
        resource.reaction.flatMap { it.manifestation }.mapNotNull { it.reference }
      },
    )

  public val Participant: SearchParam<AllergyIntolerance, Reference> =
    SimpleSearchParam<AllergyIntolerance, Reference>(
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
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.participant.map { it.actor } },
    )

  public val Patient: SearchParam<AllergyIntolerance, Reference> =
    SimpleSearchParam<AllergyIntolerance, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "AllergyIntolerance.patient",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Route: SearchParam<AllergyIntolerance, CodeableConcept> =
    SimpleSearchParam<AllergyIntolerance, CodeableConcept>(
      name = "route",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.reaction.exposureRoute",
      extractor = { resource -> resource.reaction.mapNotNull { it.exposureRoute } },
    )

  public val Severity: SearchParam<AllergyIntolerance, Any> =
    SimpleSearchParam<AllergyIntolerance, Any>(
      name = "severity",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.reaction.severity",
      extractor = { resource -> resource.reaction.mapNotNull { it.severity } },
    )

  public val Type: SearchParam<AllergyIntolerance, CodeableConcept> =
    SimpleSearchParam<AllergyIntolerance, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val VerificationStatus: SearchParam<AllergyIntolerance, CodeableConcept> =
    SimpleSearchParam<AllergyIntolerance, CodeableConcept>(
      name = "verification-status",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.verificationStatus",
      extractor = { resource -> listOfNotNull(resource.verificationStatus) },
    )

  /** All search parameters for the AllergyIntolerance resource type. */
  public val ALL: List<SearchParam<AllergyIntolerance, *>> =
    listOf(
      Category,
      ClinicalStatus,
      Code,
      Criticality,
      Date,
      Identifier,
      LastDate,
      ManifestationCode,
      ManifestationReference,
      Participant,
      Patient,
      Route,
      Severity,
      Type,
      VerificationStatus,
    )
}
