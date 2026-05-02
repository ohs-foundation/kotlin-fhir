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
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationKnowledge] resource type. */
public sealed class MedicationKnowledgeSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicationKnowledge): List<T>

  public data object Classification : MedicationKnowledgeSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "MedicationKnowledge.medicineClassification.classification"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.medicineClassification.flatMap { it.classification }
  }

  public data object ClassificationType : MedicationKnowledgeSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "classification-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "MedicationKnowledge.medicineClassification.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.medicineClassification.map { it.type }
  }

  public data object Code : MedicationKnowledgeSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicationKnowledge.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Doseform : MedicationKnowledgeSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "doseform"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicationKnowledge.doseForm"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      listOfNotNull(resource.doseForm)
  }

  public data object Ingredient : MedicationKnowledgeSearchParam<Reference>() {
    public override val paramName: kotlin.String = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "(MedicationKnowledge.ingredient.item as Reference)"

    public override val target: List<kotlin.String> = listOf("Substance")

    public override fun extract(resource: MedicationKnowledge): List<Reference> =
      resource.ingredient.mapNotNull {
        (it.item as? MedicationKnowledge.Ingredient.Item.Reference)?.value
      }
  }

  public data object IngredientCode : MedicationKnowledgeSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "ingredient-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(MedicationKnowledge.ingredient.item as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.ingredient.mapNotNull {
        (it.item as? MedicationKnowledge.Ingredient.Item.CodeableConcept)?.value
      }
  }

  public data object Manufacturer : MedicationKnowledgeSearchParam<Reference>() {
    public override val paramName: kotlin.String = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MedicationKnowledge.manufacturer"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: MedicationKnowledge): List<Reference> =
      listOfNotNull(resource.manufacturer)
  }

  public data object MonitoringProgramName : MedicationKnowledgeSearchParam<String>() {
    public override val paramName: kotlin.String = "monitoring-program-name"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicationKnowledge.monitoringProgram.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<String> =
      resource.monitoringProgram.mapNotNull { it.name }
  }

  public data object MonitoringProgramType : MedicationKnowledgeSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "monitoring-program-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicationKnowledge.monitoringProgram.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.monitoringProgram.mapNotNull { it.type }
  }

  public data object Monograph : MedicationKnowledgeSearchParam<Reference>() {
    public override val paramName: kotlin.String = "monograph"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "MedicationKnowledge.monograph.source"

    public override val target: List<kotlin.String> = listOf("Media", "DocumentReference")

    public override fun extract(resource: MedicationKnowledge): List<Reference> =
      resource.monograph.mapNotNull { it.source }
  }

  public data object MonographType : MedicationKnowledgeSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "monograph-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicationKnowledge.monograph.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.monograph.mapNotNull { it.type }
  }

  public data object SourceCost : MedicationKnowledgeSearchParam<String>() {
    public override val paramName: kotlin.String = "source-cost"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicationKnowledge.cost.source"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<String> =
      resource.cost.mapNotNull { it.source }
  }

  public data object Status : MedicationKnowledgeSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "MedicationKnowledge.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> =
      listOfNotNull(resource.status)
  }

  public companion object {
    /** All search parameters for the MedicationKnowledge resource type. */
    public val ALL: List<MedicationKnowledgeSearchParam<*>> =
      listOf(
        Classification,
        ClassificationType,
        Code,
        Doseform,
        Ingredient,
        IngredientCode,
        Manufacturer,
        MonitoringProgramName,
        MonitoringProgramType,
        Monograph,
        MonographType,
        SourceCost,
        Status,
      )
  }
}
