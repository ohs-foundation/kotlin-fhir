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
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImmunizationEvaluation] resource type. */
public object ImmunizationEvaluationSearchParam {
  public val Date: SearchParam<ImmunizationEvaluation, DateTime> =
    SimpleSearchParam<ImmunizationEvaluation, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ImmunizationEvaluation.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val DoseStatus: SearchParam<ImmunizationEvaluation, CodeableConcept> =
    SimpleSearchParam<ImmunizationEvaluation, CodeableConcept>(
      name = "dose-status",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.doseStatus",
      extractor = { resource -> listOf(resource.doseStatus) },
    )

  public val Identifier: SearchParam<ImmunizationEvaluation, Identifier> =
    SimpleSearchParam<ImmunizationEvaluation, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ImmunizationEvent: SearchParam<ImmunizationEvaluation, Reference> =
    SimpleSearchParam<ImmunizationEvaluation, Reference>(
      name = "immunization-event",
      type = SearchParamType.fromCode("reference"),
      expression = "ImmunizationEvaluation.immunizationEvent",
      target = listOf(Immunization::class),
      extractor = { resource -> listOf(resource.immunizationEvent) },
    )

  public val Patient: SearchParam<ImmunizationEvaluation, Reference> =
    SimpleSearchParam<ImmunizationEvaluation, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ImmunizationEvaluation.patient",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Status: SearchParam<ImmunizationEvaluation, Any> =
    SimpleSearchParam<ImmunizationEvaluation, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val TargetDisease: SearchParam<ImmunizationEvaluation, CodeableConcept> =
    SimpleSearchParam<ImmunizationEvaluation, CodeableConcept>(
      name = "target-disease",
      type = SearchParamType.fromCode("token"),
      expression = "ImmunizationEvaluation.targetDisease",
      extractor = { resource -> listOf(resource.targetDisease) },
    )

  /** All search parameters for the ImmunizationEvaluation resource type. */
  public val ALL: List<SearchParam<ImmunizationEvaluation, *>> =
    listOf(Date, DoseStatus, Identifier, ImmunizationEvent, Patient, Status, TargetDisease)
}
