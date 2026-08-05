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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.ResearchSubject
import dev.ohs.fhir.model.r5.Specimen
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchSubject] resource type. */
public object ResearchSubjectSearchParams {
  public val date: SearchParam<ResearchSubject, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "ResearchSubject.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val identifier: SearchParam<ResearchSubject, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ResearchSubject.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<ResearchSubject, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "ResearchSubject.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter { it.reference?.value?.contains("Patient/") == true }
      },
    )

  public val status: SearchParam<ResearchSubject, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ResearchSubject.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val study: SearchParam<ResearchSubject, Reference> =
    SearchParam(
      name = "study",
      type = SearchParamType.Reference,
      expression = "ResearchSubject.study",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> listOf(resource.study) },
    )

  public val subject: SearchParam<ResearchSubject, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "ResearchSubject.subject",
      target =
        listOf(
          Device::class,
          Group::class,
          BiologicallyDerivedProduct::class,
          Specimen::class,
          Substance::class,
          Patient::class,
          Medication::class,
        ),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val subject_state: SearchParam<ResearchSubject, CodeableConcept> =
    SearchParam(
      name = "subject_state",
      type = SearchParamType.Token,
      expression = "ResearchSubject.progress.subjectState",
      extractor = { resource -> resource.progress.mapNotNull { it.subjectState } },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ResearchSubject, *>> = listOf()

  /**
   * Supported search parameters for the ResearchSubject resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ResearchSubject, *>> =
    listOf(date, identifier, patient, status, study, subject, subject_state)
}
