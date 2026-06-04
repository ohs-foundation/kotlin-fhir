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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MedicationKnowledge
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationKnowledge] resource type. */
public object MedicationKnowledgeSearchParams {
  public val classification: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "classification",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.medicineClassification.classification",
      extractor = { resource -> resource.medicineClassification.flatMap { it.classification } },
    )

  public val classificationType: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "classification-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.medicineClassification.type",
      extractor = { resource -> resource.medicineClassification.map { it.type } },
    )

  public val code: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val doseform: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "doseform",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.definitional.doseForm",
      extractor = { resource -> listOfNotNull(resource.definitional?.doseForm) },
    )

  public val identifier: SearchParam<MedicationKnowledge, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ingredient: SearchParam<MedicationKnowledge, Reference> =
    SearchParam(
      name = "ingredient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationKnowledge.definitional.ingredient.item.reference",
      target = listOf(Substance::class),
      extractor = { resource ->
        (resource.definitional?.ingredient ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val ingredientCode: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "ingredient-code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.definitional.ingredient.item.concept",
      extractor = { resource ->
        (resource.definitional?.ingredient ?: emptyList()).map { it.item }.mapNotNull { it.concept }
      },
    )

  public val monitoringProgramName: SearchParam<MedicationKnowledge, String> =
    SearchParam(
      name = "monitoring-program-name",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.monitoringProgram.name",
      extractor = { resource -> resource.monitoringProgram.mapNotNull { it.name } },
    )

  public val monitoringProgramType: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "monitoring-program-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.monitoringProgram.type",
      extractor = { resource -> resource.monitoringProgram.mapNotNull { it.type } },
    )

  public val monograph: SearchParam<MedicationKnowledge, Reference> =
    SearchParam(
      name = "monograph",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationKnowledge.monograph.source",
      target = listOf(DocumentReference::class),
      extractor = { resource -> resource.monograph.mapNotNull { it.source } },
    )

  public val monographType: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "monograph-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.monograph.type",
      extractor = { resource -> resource.monograph.mapNotNull { it.type } },
    )

  public val packagingCost: SearchParam<MedicationKnowledge, Any> =
    SearchParam(
      name = "packaging-cost",
      type = SearchParamType.fromCode("quantity"),
      expression = "",
      extractor = { emptyList() },
    )

  public val packagingCostConcept: SearchParam<MedicationKnowledge, Any> =
    SearchParam(
      name = "packaging-cost-concept",
      type = SearchParamType.fromCode("token"),
      expression = "",
      extractor = { emptyList() },
    )

  public val productType: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "product-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.productType",
      extractor = { resource -> resource.productType },
    )

  public val sourceCost: SearchParam<MedicationKnowledge, String> =
    SearchParam(
      name = "source-cost",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.cost.source",
      extractor = { resource -> resource.cost.mapNotNull { it.source } },
    )

  public val status: SearchParam<MedicationKnowledge, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  /** All search parameters for the MedicationKnowledge resource type. */
  public val all: List<SearchParam<MedicationKnowledge, *>> =
    listOf(
      classification,
      classificationType,
      code,
      doseform,
      identifier,
      ingredient,
      ingredientCode,
      monitoringProgramName,
      monitoringProgramType,
      monograph,
      monographType,
      packagingCost,
      packagingCostConcept,
      productType,
      sourceCost,
      status,
    )
}
