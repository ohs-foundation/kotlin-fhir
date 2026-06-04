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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.ImmunizationEvaluation
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImmunizationEvaluation] resource type. */
public object ImmunizationEvaluationSearchParams {
  public val date: SearchParam<ImmunizationEvaluation, DateTime> =
    SearchParam<ImmunizationEvaluation, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ImmunizationEvaluation.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val doseStatus: SearchParam<ImmunizationEvaluation, CodeableConcept> =
    SearchParam<ImmunizationEvaluation, CodeableConcept>(
      name = "dose-status",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.doseStatus",
      extractor = { resource -> listOf(resource.doseStatus) },
    )

  public val identifier: SearchParam<ImmunizationEvaluation, Identifier> =
    SearchParam<ImmunizationEvaluation, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val immunizationEvent: SearchParam<ImmunizationEvaluation, Reference> =
    SearchParam<ImmunizationEvaluation, Reference>(
      name = "immunization-event",
      type = SearchParamType.fromCode("reference"),
      expression = "ImmunizationEvaluation.immunizationEvent",
      target = listOf(Immunization::class),
      extractor = { resource -> listOf(resource.immunizationEvent) },
    )

  public val patient: SearchParam<ImmunizationEvaluation, Reference> =
    SearchParam<ImmunizationEvaluation, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ImmunizationEvaluation.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val status: SearchParam<ImmunizationEvaluation, Any> =
    SearchParam<ImmunizationEvaluation, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val targetDisease: SearchParam<ImmunizationEvaluation, CodeableConcept> =
    SearchParam<ImmunizationEvaluation, CodeableConcept>(
      name = "target-disease",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.targetDisease",
      extractor = { resource -> listOf(resource.targetDisease) },
    )

  /** All search parameters for the ImmunizationEvaluation resource type. */
  public val all: List<SearchParam<ImmunizationEvaluation, *>> =
    listOf(date, doseStatus, identifier, immunizationEvent, patient, status, targetDisease)
}
