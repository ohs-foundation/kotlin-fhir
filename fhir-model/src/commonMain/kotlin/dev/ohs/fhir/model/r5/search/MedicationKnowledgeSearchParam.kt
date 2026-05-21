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
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.MedicationKnowledge
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [MedicationKnowledge] resource type. */
public object MedicationKnowledgeSearchParam {
  /** All search parameters for the MedicationKnowledge resource type. */
  public val ALL: List<SearchParam<MedicationKnowledge, *>> =
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

  public data object Classification : SearchParam<MedicationKnowledge, CodeableConcept> {
    public override val name: KotlinString = "classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "MedicationKnowledge.medicineClassification.classification"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.medicineClassification.flatMap { it.classification }
  }

  public data object ClassificationType : SearchParam<MedicationKnowledge, CodeableConcept> {
    public override val name: KotlinString = "classification-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.medicineClassification.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.medicineClassification.map { it.type }
  }

  public data object Code : SearchParam<MedicationKnowledge, CodeableConcept> {
    public override val name: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Doseform : SearchParam<MedicationKnowledge, CodeableConcept> {
    public override val name: KotlinString = "doseform"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.definitional.doseForm"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      listOfNotNull(resource.definitional?.doseForm)
  }

  public data object Identifier :
    SearchParam<MedicationKnowledge, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationKnowledge
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Ingredient : SearchParam<MedicationKnowledge, Reference> {
    public override val name: KotlinString = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "MedicationKnowledge.definitional.ingredient.item.reference"

    public override val target: List<KClass<out Resource>> = listOf(Substance::class)

    public override fun extract(resource: MedicationKnowledge): List<Reference> =
      (resource.definitional?.ingredient ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object IngredientCode : SearchParam<MedicationKnowledge, CodeableConcept> {
    public override val name: KotlinString = "ingredient-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "MedicationKnowledge.definitional.ingredient.item.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      (resource.definitional?.ingredient ?: emptyList()).map { it.item }.mapNotNull { it.concept }
  }

  public data object MonitoringProgramName : SearchParam<MedicationKnowledge, R5String> {
    public override val name: KotlinString = "monitoring-program-name"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.monitoringProgram.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<R5String> =
      resource.monitoringProgram.mapNotNull { it.name }
  }

  public data object MonitoringProgramType : SearchParam<MedicationKnowledge, CodeableConcept> {
    public override val name: KotlinString = "monitoring-program-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.monitoringProgram.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.monitoringProgram.mapNotNull { it.type }
  }

  public data object Monograph : SearchParam<MedicationKnowledge, Reference> {
    public override val name: KotlinString = "monograph"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MedicationKnowledge.monograph.source"

    public override val target: List<KClass<out Resource>> = listOf(DocumentReference::class)

    public override fun extract(resource: MedicationKnowledge): List<Reference> =
      resource.monograph.mapNotNull { it.source }
  }

  public data object MonographType : SearchParam<MedicationKnowledge, CodeableConcept> {
    public override val name: KotlinString = "monograph-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.monograph.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.monograph.mapNotNull { it.type }
  }

  public data object PackagingCost : SearchParam<MedicationKnowledge, Any> {
    public override val name: KotlinString = "packaging-cost"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = ""

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object PackagingCostConcept : SearchParam<MedicationKnowledge, Any> {
    public override val name: KotlinString = "packaging-cost-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = ""

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> = emptyList()
  }

  public data object ProductType : SearchParam<MedicationKnowledge, CodeableConcept> {
    public override val name: KotlinString = "product-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.productType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<CodeableConcept> =
      resource.productType
  }

  public data object SourceCost : SearchParam<MedicationKnowledge, R5String> {
    public override val name: KotlinString = "source-cost"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.cost.source"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<R5String> =
      resource.cost.mapNotNull { it.source }
  }

  public data object Status : SearchParam<MedicationKnowledge, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicationKnowledge.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationKnowledge): List<Any> =
      listOfNotNull(resource.status)
  }
}
