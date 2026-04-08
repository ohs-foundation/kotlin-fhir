/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationKnowledge] resource type. */
public sealed class MedicationKnowledgeSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicationKnowledge): List<T>

  public data object Classification : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "MedicationKnowledge.medicineClassification.classification"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object ClassificationType : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "classification-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.medicineClassification.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object Code : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object Doseform : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "doseform"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.definitional.doseForm"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object Identifier : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object Ingredient : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationKnowledge.definitional.ingredient.item.reference"

    public override val target: List<String> = listOf("Substance")

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object IngredientCode : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "ingredient-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "MedicationKnowledge.definitional.ingredient.item.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object MonitoringProgramName : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "monitoring-program-name"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.monitoringProgram.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object MonitoringProgramType : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "monitoring-program-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.monitoringProgram.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object Monograph : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "monograph"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationKnowledge.monograph.source"

    public override val target: List<String> = listOf("DocumentReference")

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object MonographType : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "monograph-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.monograph.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object PackagingCost : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "packaging-cost"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = ""

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object PackagingCostConcept : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "packaging-cost-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = ""

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object ProductType : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "product-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.productType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object SourceCost : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "source-cost"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.cost.source"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object Status : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationKnowledge.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the MedicationKnowledge resource type. */
    public val ALL: List<MedicationKnowledgeSearchParam<*>> =
      listOf(
        Classification,
        ClassificationType,
        Code,
        Doseform,
        Identifier,
        Ingredient,
        IngredientCode,
        MonitoringProgramName,
        MonitoringProgramType,
        Monograph,
        MonographType,
        PackagingCost,
        PackagingCostConcept,
        ProductType,
        SourceCost,
        Status,
      )
  }
}
