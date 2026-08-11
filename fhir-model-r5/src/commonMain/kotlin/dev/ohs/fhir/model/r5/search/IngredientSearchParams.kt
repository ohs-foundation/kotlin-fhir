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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.AdministrableProductDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Ingredient
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Ingredient] resource type. */
public object IngredientSearchParams {
  public val `for`: SearchParam<Ingredient, Reference> =
    SearchParam(
      name = "for",
      type = SearchParamType.Reference,
      expression = "Ingredient.for",
      target =
        listOf(
          MedicinalProductDefinition::class,
          AdministrableProductDefinition::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource -> resource.`for` },
    )

  public val function: SearchParam<Ingredient, CodeableConcept> =
    SearchParam(
      name = "function",
      type = SearchParamType.Token,
      expression = "Ingredient.function",
      extractor = { resource -> resource.function },
    )

  public val identifier: SearchParam<Ingredient, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Ingredient.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val manufacturer: SearchParam<Ingredient, Reference> =
    SearchParam(
      name = "manufacturer",
      type = SearchParamType.Reference,
      expression = "Ingredient.manufacturer.manufacturer",
      target = listOf(Organization::class),
      extractor = { resource -> resource.manufacturer.map { it.manufacturer } },
    )

  public val role: SearchParam<Ingredient, CodeableConcept> =
    SearchParam(
      name = "role",
      type = SearchParamType.Token,
      expression = "Ingredient.role",
      extractor = { resource -> listOf(resource.role) },
    )

  public val status: SearchParam<Ingredient, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Ingredient.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val strengthConcentrationQuantity: SearchParam<Ingredient, Quantity> =
    SearchParam(
      name = "strength-concentration-quantity",
      type = SearchParamType.Quantity,
      expression = "Ingredient.substance.strength.concentration.ofType(Quantity)",
      extractor = { resource ->
        resource.substance.strength.mapNotNull {
          (it.concentration as? Ingredient.Substance.Strength.Concentration.Quantity)?.value
        }
      },
    )

  public val strengthConcentrationRatio: SearchParam<Ingredient, Ratio> =
    SearchParam(
      name = "strength-concentration-ratio",
      type = SearchParamType.Composite,
      expression = "Ingredient.substance.strength.concentration.ofType(Ratio)",
      extractor = { resource ->
        resource.substance.strength.mapNotNull {
          (it.concentration as? Ingredient.Substance.Strength.Concentration.Ratio)?.value
        }
      },
    )

  public val strengthPresentationQuantity: SearchParam<Ingredient, Quantity> =
    SearchParam(
      name = "strength-presentation-quantity",
      type = SearchParamType.Quantity,
      expression = "Ingredient.substance.strength.presentation.ofType(Quantity)",
      extractor = { resource ->
        resource.substance.strength.mapNotNull {
          (it.presentation as? Ingredient.Substance.Strength.Presentation.Quantity)?.value
        }
      },
    )

  public val strengthPresentationRatio: SearchParam<Ingredient, Ratio> =
    SearchParam(
      name = "strength-presentation-ratio",
      type = SearchParamType.Composite,
      expression = "Ingredient.substance.strength.presentation.ofType(Ratio)",
      extractor = { resource ->
        resource.substance.strength.mapNotNull {
          (it.presentation as? Ingredient.Substance.Strength.Presentation.Ratio)?.value
        }
      },
    )

  public val substance: SearchParam<Ingredient, Reference> =
    SearchParam(
      name = "substance",
      type = SearchParamType.Reference,
      expression = "Ingredient.substance.code.reference",
      target = listOf(SubstanceDefinition::class),
      extractor = { resource -> listOfNotNull(resource.substance.code.reference) },
    )

  public val substanceCode: SearchParam<Ingredient, CodeableConcept> =
    SearchParam(
      name = "substance-code",
      type = SearchParamType.Token,
      expression = "Ingredient.substance.code.concept",
      extractor = { resource -> listOfNotNull(resource.substance.code.concept) },
    )

  public val substanceDefinition: SearchParam<Ingredient, Reference> =
    SearchParam(
      name = "substance-definition",
      type = SearchParamType.Reference,
      expression = "Ingredient.substance.code.reference",
      target = listOf(SubstanceDefinition::class),
      extractor = { resource -> listOfNotNull(resource.substance.code.reference) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Ingredient, *>> = listOf()

  /**
   * Supported search parameters for the Ingredient resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Ingredient, *>> =
    listOf(
      `for`,
      function,
      identifier,
      manufacturer,
      role,
      status,
      strengthConcentrationQuantity,
      strengthConcentrationRatio,
      strengthPresentationQuantity,
      strengthPresentationRatio,
      substance,
      substanceCode,
      substanceDefinition,
    )
}
