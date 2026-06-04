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
import dev.ohs.fhir.model.r4.DocumentReference
import dev.ohs.fhir.model.r4.Media
import dev.ohs.fhir.model.r4.MedicationKnowledge
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Substance
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationKnowledge] resource type. */
public object MedicationKnowledgeSearchParams {
  public val Classification: SearchParam<MedicationKnowledge, CodeableConcept> =
    SimpleSearchParam<MedicationKnowledge, CodeableConcept>(
      name = "classification",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.medicineClassification.classification",
      extractor = { resource -> resource.medicineClassification.flatMap { it.classification } },
    )

  public val ClassificationType: SearchParam<MedicationKnowledge, CodeableConcept> =
    SimpleSearchParam<MedicationKnowledge, CodeableConcept>(
      name = "classification-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.medicineClassification.type",
      extractor = { resource -> resource.medicineClassification.map { it.type } },
    )

  public val Code: SearchParam<MedicationKnowledge, CodeableConcept> =
    SimpleSearchParam<MedicationKnowledge, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Doseform: SearchParam<MedicationKnowledge, CodeableConcept> =
    SimpleSearchParam<MedicationKnowledge, CodeableConcept>(
      name = "doseform",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.doseForm",
      extractor = { resource -> listOfNotNull(resource.doseForm) },
    )

  public val Ingredient: SearchParam<MedicationKnowledge, Reference> =
    SimpleSearchParam<MedicationKnowledge, Reference>(
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

  public val IngredientCode: SearchParam<MedicationKnowledge, CodeableConcept> =
    SimpleSearchParam<MedicationKnowledge, CodeableConcept>(
      name = "ingredient-code",
      type = SearchParamType.fromCode("token"),
      expression = "(MedicationKnowledge.ingredient.item as CodeableConcept)",
      extractor = { resource ->
        resource.ingredient.mapNotNull {
          (it.item as? MedicationKnowledge.Ingredient.Item.CodeableConcept)?.value
        }
      },
    )

  public val Manufacturer: SearchParam<MedicationKnowledge, Reference> =
    SimpleSearchParam<MedicationKnowledge, Reference>(
      name = "manufacturer",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationKnowledge.manufacturer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
    )

  public val MonitoringProgramName: SearchParam<MedicationKnowledge, String> =
    SimpleSearchParam<MedicationKnowledge, String>(
      name = "monitoring-program-name",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.monitoringProgram.name",
      extractor = { resource -> resource.monitoringProgram.mapNotNull { it.name } },
    )

  public val MonitoringProgramType: SearchParam<MedicationKnowledge, CodeableConcept> =
    SimpleSearchParam<MedicationKnowledge, CodeableConcept>(
      name = "monitoring-program-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.monitoringProgram.type",
      extractor = { resource -> resource.monitoringProgram.mapNotNull { it.type } },
    )

  public val Monograph: SearchParam<MedicationKnowledge, Reference> =
    SimpleSearchParam<MedicationKnowledge, Reference>(
      name = "monograph",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationKnowledge.monograph.source",
      target = listOf(Media::class, DocumentReference::class),
      extractor = { resource -> resource.monograph.mapNotNull { it.source } },
    )

  public val MonographType: SearchParam<MedicationKnowledge, CodeableConcept> =
    SimpleSearchParam<MedicationKnowledge, CodeableConcept>(
      name = "monograph-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.monograph.type",
      extractor = { resource -> resource.monograph.mapNotNull { it.type } },
    )

  public val SourceCost: SearchParam<MedicationKnowledge, String> =
    SimpleSearchParam<MedicationKnowledge, String>(
      name = "source-cost",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.cost.source",
      extractor = { resource -> resource.cost.mapNotNull { it.source } },
    )

  public val Status: SearchParam<MedicationKnowledge, Any> =
    SimpleSearchParam<MedicationKnowledge, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationKnowledge.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  /** All search parameters for the MedicationKnowledge resource type. */
  public val ALL: List<SearchParam<MedicationKnowledge, *>> =
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
