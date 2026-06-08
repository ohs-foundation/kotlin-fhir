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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DocumentReference
import dev.ohs.fhir.model.r4b.Media
import dev.ohs.fhir.model.r4b.MedicationKnowledge
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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
      expression = "MedicationKnowledge.doseForm",
      extractor = { resource -> listOfNotNull(resource.doseForm) },
    )

  public val ingredient: SearchParam<MedicationKnowledge, Reference> =
    SearchParam(
      name = "ingredient",
      type = SearchParamType.fromCode("reference"),
      expression = "(MedicationKnowledge.ingredient.item as Reference)",
      target = listOf(Substance::class),
      extractor = { resource ->
        resource.ingredient.mapNotNull {
          (it.item as? MedicationKnowledge.Ingredient.Item.Reference)?.value
        }
      },
    )

  public val ingredientCode: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "ingredient-code",
      type = SearchParamType.fromCode("token"),
      expression = "(MedicationKnowledge.ingredient.item as CodeableConcept)",
      extractor = { resource ->
        resource.ingredient.mapNotNull {
          (it.item as? MedicationKnowledge.Ingredient.Item.CodeableConcept)?.value
        }
      },
    )

  public val manufacturer: SearchParam<MedicationKnowledge, Reference> =
    SearchParam(
      name = "manufacturer",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationKnowledge.manufacturer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
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
      target = listOf(Media::class, DocumentReference::class),
      extractor = { resource -> resource.monograph.mapNotNull { it.source } },
    )

  public val monographType: SearchParam<MedicationKnowledge, CodeableConcept> =
    SearchParam(
      name = "monograph-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.monograph.type",
      extractor = { resource -> resource.monograph.mapNotNull { it.type } },
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

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<MedicationKnowledge, *>> = listOf()

  /**
   * Supported search parameters for the MedicationKnowledge resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<MedicationKnowledge, *>> =
    listOf(
      classification,
      classificationType,
      code,
      doseform,
      ingredient,
      ingredientCode,
      manufacturer,
      monitoringProgramName,
      monitoringProgramType,
      monograph,
      monographType,
      sourceCost,
      status,
    )
}
