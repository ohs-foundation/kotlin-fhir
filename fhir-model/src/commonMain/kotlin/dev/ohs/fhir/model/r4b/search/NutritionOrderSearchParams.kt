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

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.NutritionOrder
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionOrder] resource type. */
public object NutritionOrderSearchParams {
  public val additive: SearchParam<NutritionOrder, CodeableConcept> =
    SearchParam(
      name = "additive",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionOrder.enteralFormula.additiveType",
      extractor = { resource -> listOfNotNull(resource.enteralFormula?.additiveType) },
    )

  public val datetime: SearchParam<NutritionOrder, DateTime> =
    SearchParam(
      name = "datetime",
      type = SearchParamType.fromCode("date"),
      expression = "NutritionOrder.dateTime",
      extractor = { resource -> listOf(resource.dateTime) },
    )

  public val encounter: SearchParam<NutritionOrder, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionOrder.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val formula: SearchParam<NutritionOrder, CodeableConcept> =
    SearchParam(
      name = "formula",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionOrder.enteralFormula.baseFormulaType",
      extractor = { resource -> listOfNotNull(resource.enteralFormula?.baseFormulaType) },
    )

  public val identifier: SearchParam<NutritionOrder, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionOrder.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<NutritionOrder, Canonical> =
    SearchParam(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionOrder.instantiatesCanonical",
      target = listOf(PlanDefinition::class, ActivityDefinition::class),
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val instantiatesUri: SearchParam<NutritionOrder, Uri> =
    SearchParam(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "NutritionOrder.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val oraldiet: SearchParam<NutritionOrder, CodeableConcept> =
    SearchParam(
      name = "oraldiet",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionOrder.oralDiet.type",
      extractor = { resource -> resource.oralDiet?.type ?: emptyList() },
    )

  public val patient: SearchParam<NutritionOrder, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionOrder.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val provider: SearchParam<NutritionOrder, Reference> =
    SearchParam(
      name = "provider",
      type = SearchParamType.fromCode("reference"),
      expression = "NutritionOrder.orderer",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.orderer) },
    )

  public val status: SearchParam<NutritionOrder, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionOrder.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val supplement: SearchParam<NutritionOrder, CodeableConcept> =
    SearchParam(
      name = "supplement",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionOrder.supplement.type",
      extractor = { resource -> resource.supplement.mapNotNull { it.type } },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<NutritionOrder, *>> = listOf()

  /**
   * Supported search parameters for the NutritionOrder resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<NutritionOrder, *>> =
    listOf(
      additive,
      datetime,
      encounter,
      formula,
      identifier,
      instantiatesCanonical,
      instantiatesUri,
      oraldiet,
      patient,
      provider,
      status,
      supplement,
    )
}
