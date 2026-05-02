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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ImmunizationEvaluation] resource type. */
public sealed class ImmunizationEvaluationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ImmunizationEvaluation): List<T>

  public data object Date : ImmunizationEvaluationSearchParam<DateTime>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ImmunizationEvaluation.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationEvaluation): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DoseStatus : ImmunizationEvaluationSearchParam<CodeableConcept>() {
    public override val paramName: String = "dose-status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImmunizationEvaluation.doseStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationEvaluation): List<CodeableConcept> =
      listOf(resource.doseStatus)
  }

  public data object Identifier :
    ImmunizationEvaluationSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImmunizationEvaluation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ImmunizationEvaluation
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object ImmunizationEvent : ImmunizationEvaluationSearchParam<Reference>() {
    public override val paramName: String = "immunization-event"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImmunizationEvaluation.immunizationEvent"

    public override val target: List<String> = listOf("Immunization")

    public override fun extract(resource: ImmunizationEvaluation): List<Reference> =
      listOf(resource.immunizationEvent)
  }

  public data object Patient : ImmunizationEvaluationSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ImmunizationEvaluation.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ImmunizationEvaluation): List<Reference> =
      listOf(resource.patient)
  }

  public data object Status : ImmunizationEvaluationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImmunizationEvaluation.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationEvaluation): List<Any> =
      listOf(resource.status)
  }

  public data object TargetDisease : ImmunizationEvaluationSearchParam<CodeableConcept>() {
    public override val paramName: String = "target-disease"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ImmunizationEvaluation.targetDisease"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ImmunizationEvaluation): List<CodeableConcept> =
      listOf(resource.targetDisease)
  }

  public companion object {
    /** All search parameters for the ImmunizationEvaluation resource type. */
    public val ALL: List<ImmunizationEvaluationSearchParam<*>> =
      listOf(Date, DoseStatus, Identifier, ImmunizationEvent, Patient, Status, TargetDisease)
  }
}
