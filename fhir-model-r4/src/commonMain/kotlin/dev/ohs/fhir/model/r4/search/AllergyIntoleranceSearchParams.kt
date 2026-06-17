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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.AllergyIntolerance
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Patient
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
  public val asserter: SearchParam<AllergyIntolerance, Reference> =
    SearchParam(
      name = "asserter",
      type = SearchParamType.Reference,
      expression = "AllergyIntolerance.asserter",
      target =
        listOf(Practitioner::class, Patient::class, PractitionerRole::class, RelatedPerson::class),
      extractor = { resource -> listOfNotNull(resource.asserter) },
    )

  public val category: SearchParam<AllergyIntolerance, Any> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.category",
      extractor = { resource -> resource.category },
    )

  public val clinicalStatus: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "clinical-status",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.clinicalStatus",
      extractor = { resource -> listOfNotNull(resource.clinicalStatus) },
    )

  public val code: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val criticality: SearchParam<AllergyIntolerance, Any> =
    SearchParam(
      name = "criticality",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.criticality",
      extractor = { resource -> listOfNotNull(resource.criticality) },
    )

  public val date: SearchParam<AllergyIntolerance, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "AllergyIntolerance.recordedDate",
      extractor = { resource -> listOfNotNull(resource.recordedDate) },
    )

  public val identifier: SearchParam<AllergyIntolerance, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val lastDate: SearchParam<AllergyIntolerance, DateTime> =
    SearchParam(
      name = "last-date",
      type = SearchParamType.Date,
      expression = "AllergyIntolerance.lastOccurrence",
      extractor = { resource -> listOfNotNull(resource.lastOccurrence) },
    )

  public val manifestation: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "manifestation",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.reaction.manifestation",
      extractor = { resource -> resource.reaction.flatMap { it.manifestation } },
    )

  public val onset: SearchParam<AllergyIntolerance, DateTime> =
    SearchParam(
      name = "onset",
      type = SearchParamType.Date,
      expression = "AllergyIntolerance.reaction.onset",
      extractor = { resource -> resource.reaction.mapNotNull { it.onset } },
    )

  public val patient: SearchParam<AllergyIntolerance, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "AllergyIntolerance.patient",
      target = listOf(Patient::class, Group::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val recorder: SearchParam<AllergyIntolerance, Reference> =
    SearchParam(
      name = "recorder",
      type = SearchParamType.Reference,
      expression = "AllergyIntolerance.recorder",
      target =
        listOf(Practitioner::class, Patient::class, PractitionerRole::class, RelatedPerson::class),
      extractor = { resource -> listOfNotNull(resource.recorder) },
    )

  public val route: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "route",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.reaction.exposureRoute",
      extractor = { resource -> resource.reaction.mapNotNull { it.exposureRoute } },
    )

  public val severity: SearchParam<AllergyIntolerance, Any> =
    SearchParam(
      name = "severity",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.reaction.severity",
      extractor = { resource -> resource.reaction.mapNotNull { it.severity } },
    )

  public val type: SearchParam<AllergyIntolerance, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val verificationStatus: SearchParam<AllergyIntolerance, CodeableConcept> =
    SearchParam(
      name = "verification-status",
      type = SearchParamType.Token,
      expression = "AllergyIntolerance.verificationStatus",
      extractor = { resource -> listOfNotNull(resource.verificationStatus) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<AllergyIntolerance, *>> = listOf()

  /**
   * Supported search parameters for the AllergyIntolerance resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<AllergyIntolerance, *>> =
    listOf(
      asserter,
      category,
      clinicalStatus,
      code,
      criticality,
      date,
      identifier,
      lastDate,
      manifestation,
      onset,
      patient,
      recorder,
      route,
      severity,
      type,
      verificationStatus,
    )
}
