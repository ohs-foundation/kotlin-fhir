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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Immunization
import dev.ohs.fhir.model.r4.ImmunizationEvaluation
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImmunizationEvaluation] resource type. */
public object ImmunizationEvaluationSearchParams {
  public val date: SearchParam<ImmunizationEvaluation, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ImmunizationEvaluation.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val doseStatus: SearchParam<ImmunizationEvaluation, CodeableConcept> =
    SearchParam(
      name = "dose-status",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.doseStatus",
      extractor = { resource -> listOf(resource.doseStatus) },
    )

  public val identifier: SearchParam<ImmunizationEvaluation, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val immunizationEvent: SearchParam<ImmunizationEvaluation, Reference> =
    SearchParam(
      name = "immunization-event",
      type = SearchParamType.fromCode("reference"),
      expression = "ImmunizationEvaluation.immunizationEvent",
      target = listOf(Immunization::class),
      extractor = { resource -> listOf(resource.immunizationEvent) },
    )

  public val patient: SearchParam<ImmunizationEvaluation, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ImmunizationEvaluation.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val status: SearchParam<ImmunizationEvaluation, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val targetDisease: SearchParam<ImmunizationEvaluation, CodeableConcept> =
    SearchParam(
      name = "target-disease",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.targetDisease",
      extractor = { resource -> listOf(resource.targetDisease) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ImmunizationEvaluation, *>> = listOf()

  /**
   * Supported search parameters for the ImmunizationEvaluation resource type. Entries in
   * [unsupported] are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<ImmunizationEvaluation, *>> =
    listOf(date, doseStatus, identifier, immunizationEvent, patient, status, targetDisease) -
      unsupported.toSet()
}
