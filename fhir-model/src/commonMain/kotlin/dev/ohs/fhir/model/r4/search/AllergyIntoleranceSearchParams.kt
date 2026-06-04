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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.AllergyIntolerance
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [AllergyIntolerance] resource type. */
public object AllergyIntoleranceSearchParams {
  public val Asserter: SearchParam<AllergyIntolerance, Reference> =
    SimpleSearchParam<AllergyIntolerance, Reference>(
      name = "asserter",
      type = SearchParamType.fromCode("reference"),
      expression = "AllergyIntolerance.asserter",
      target =
        listOf(
          Practitioner::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.asserter) },
    )

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

  public val Manifestation: SearchParam<AllergyIntolerance, CodeableConcept> =
    SimpleSearchParam<AllergyIntolerance, CodeableConcept>(
      name = "manifestation",
      type = SearchParamType.fromCode("token"),
      expression = "AllergyIntolerance.reaction.manifestation",
      extractor = { resource -> resource.reaction.flatMap { it.manifestation } },
    )

  public val Onset: SearchParam<AllergyIntolerance, DateTime> =
    SimpleSearchParam<AllergyIntolerance, DateTime>(
      name = "onset",
      type = SearchParamType.fromCode("date"),
      expression = "AllergyIntolerance.reaction.onset",
      extractor = { resource -> resource.reaction.mapNotNull { it.onset } },
    )

  public val Patient: SearchParam<AllergyIntolerance, Reference> =
    SimpleSearchParam<AllergyIntolerance, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "AllergyIntolerance.patient",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Recorder: SearchParam<AllergyIntolerance, Reference> =
    SimpleSearchParam<AllergyIntolerance, Reference>(
      name = "recorder",
      type = SearchParamType.fromCode("reference"),
      expression = "AllergyIntolerance.recorder",
      target =
        listOf(
          Practitioner::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.recorder) },
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

  public val Type: SearchParam<AllergyIntolerance, Any> =
    SimpleSearchParam<AllergyIntolerance, Any>(
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
      Asserter,
      Category,
      ClinicalStatus,
      Code,
      Criticality,
      Date,
      Identifier,
      LastDate,
      Manifestation,
      Onset,
      Patient,
      Recorder,
      Route,
      Severity,
      Type,
      VerificationStatus,
    )
}
