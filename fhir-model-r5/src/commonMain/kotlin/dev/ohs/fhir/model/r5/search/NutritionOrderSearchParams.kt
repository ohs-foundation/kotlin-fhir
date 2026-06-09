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
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.NutritionOrder
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionOrder] resource type. */
public object NutritionOrderSearchParams {
  public val additive: SearchParam<NutritionOrder, CodeableConcept> =
    SearchParam(
      name = "additive",
      type = SearchParamType.Token,
      expression = "NutritionOrder.enteralFormula.additive.type.concept",
      extractor = { resource ->
        (resource.enteralFormula?.additive ?: emptyList())
          .mapNotNull { it.type }
          .mapNotNull { it.concept }
      },
    )

  public val datetime: SearchParam<NutritionOrder, DateTime> =
    SearchParam(
      name = "datetime",
      type = SearchParamType.Date,
      expression = "NutritionOrder.dateTime",
      extractor = { resource -> listOf(resource.dateTime) },
    )

  public val encounter: SearchParam<NutritionOrder, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "NutritionOrder.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val formula: SearchParam<NutritionOrder, CodeableConcept> =
    SearchParam(
      name = "formula",
      type = SearchParamType.Token,
      expression = "NutritionOrder.enteralFormula.baseFormulaType.concept",
      extractor = { resource -> listOfNotNull(resource.enteralFormula?.baseFormulaType?.concept) },
    )

  public val groupIdentifier: SearchParam<NutritionOrder, Identifier> =
    SearchParam(
      name = "group-identifier",
      type = SearchParamType.Token,
      expression = "NutritionOrder.groupIdentifier",
      extractor = { resource -> listOfNotNull(resource.groupIdentifier) },
    )

  public val identifier: SearchParam<NutritionOrder, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "NutritionOrder.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val oraldiet: SearchParam<NutritionOrder, CodeableConcept> =
    SearchParam(
      name = "oraldiet",
      type = SearchParamType.Token,
      expression = "NutritionOrder.oralDiet.type",
      extractor = { resource -> resource.oralDiet?.type ?: emptyList() },
    )

  public val patient: SearchParam<NutritionOrder, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "NutritionOrder.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val provider: SearchParam<NutritionOrder, Reference> =
    SearchParam(
      name = "provider",
      type = SearchParamType.Reference,
      expression = "NutritionOrder.orderer",
      target = listOf(PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.orderer) },
    )

  public val status: SearchParam<NutritionOrder, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "NutritionOrder.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<NutritionOrder, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "NutritionOrder.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val supplement: SearchParam<NutritionOrder, CodeableConcept> =
    SearchParam(
      name = "supplement",
      type = SearchParamType.Token,
      expression = "NutritionOrder.supplement.type.concept",
      extractor = { resource ->
        resource.supplement.mapNotNull { it.type }.mapNotNull { it.concept }
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
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
      groupIdentifier,
      identifier,
      oraldiet,
      patient,
      provider,
      status,
      subject,
      supplement,
    )
}
