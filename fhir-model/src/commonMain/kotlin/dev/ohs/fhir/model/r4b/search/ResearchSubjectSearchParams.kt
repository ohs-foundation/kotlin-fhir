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

import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.ResearchSubject
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchSubject] resource type. */
public object ResearchSubjectSearchParams {
  public val date: SearchParam<ResearchSubject, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ResearchSubject.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val identifier: SearchParam<ResearchSubject, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchSubject.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val individual: SearchParam<ResearchSubject, Reference> =
    SearchParam(
      name = "individual",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchSubject.individual",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.individual) },
    )

  public val patient: SearchParam<ResearchSubject, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchSubject.individual",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.individual) },
    )

  public val status: SearchParam<ResearchSubject, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchSubject.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val study: SearchParam<ResearchSubject, Reference> =
    SearchParam(
      name = "study",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchSubject.study",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> listOf(resource.study) },
    )

  /** All search parameters for the ResearchSubject resource type. */
  public val all: List<SearchParam<ResearchSubject, *>> =
    listOf(date, identifier, individual, patient, status, study)
}
