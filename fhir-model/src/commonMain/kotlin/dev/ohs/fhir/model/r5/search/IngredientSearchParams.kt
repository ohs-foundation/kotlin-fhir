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

import dev.ohs.fhir.model.r5.AdministrableProductDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Ingredient
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Ingredient] resource type. */
public object IngredientSearchParams {
  public val `for`: SearchParam<Ingredient, Reference> =
    SimpleSearchParam<Ingredient, Reference>(
      name = "for",
      type = SearchParamType.fromCode("reference"),
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
    SimpleSearchParam<Ingredient, CodeableConcept>(
      name = "function",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.function",
      extractor = { resource -> resource.function },
    )

  public val identifier: SearchParam<Ingredient, Identifier> =
    SimpleSearchParam<Ingredient, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val manufacturer: SearchParam<Ingredient, Reference> =
    SimpleSearchParam<Ingredient, Reference>(
      name = "manufacturer",
      type = SearchParamType.fromCode("reference"),
      expression = "Ingredient.manufacturer.manufacturer",
      target = listOf(Organization::class),
      extractor = { resource -> resource.manufacturer.map { it.manufacturer } },
    )

  public val role: SearchParam<Ingredient, CodeableConcept> =
    SimpleSearchParam<Ingredient, CodeableConcept>(
      name = "role",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.role",
      extractor = { resource -> listOf(resource.role) },
    )

  public val status: SearchParam<Ingredient, Any> =
    SimpleSearchParam<Ingredient, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val strengthConcentrationQuantity: SearchParam<Ingredient, Any> =
    SimpleSearchParam<Ingredient, Any>(
      name = "strength-concentration-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "Ingredient.substance.strength.concentration.ofType(Quantity)",
      extractor = { emptyList() },
    )

  public val strengthConcentrationRatio: SearchParam<Ingredient, Any> =
    SimpleSearchParam<Ingredient, Any>(
      name = "strength-concentration-ratio",
      type = SearchParamType.fromCode("composite"),
      expression = "Ingredient.substance.strength.concentration.ofType(Ratio)",
      extractor = { emptyList() },
    )

  public val strengthPresentationQuantity: SearchParam<Ingredient, Any> =
    SimpleSearchParam<Ingredient, Any>(
      name = "strength-presentation-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "Ingredient.substance.strength.presentation.ofType(Quantity)",
      extractor = { emptyList() },
    )

  public val strengthPresentationRatio: SearchParam<Ingredient, Any> =
    SimpleSearchParam<Ingredient, Any>(
      name = "strength-presentation-ratio",
      type = SearchParamType.fromCode("composite"),
      expression = "Ingredient.substance.strength.presentation.ofType(Ratio)",
      extractor = { emptyList() },
    )

  public val substance: SearchParam<Ingredient, Reference> =
    SimpleSearchParam<Ingredient, Reference>(
      name = "substance",
      type = SearchParamType.fromCode("reference"),
      expression = "Ingredient.substance.code.reference",
      target = listOf(SubstanceDefinition::class),
      extractor = { resource -> listOfNotNull(resource.substance.code.reference) },
    )

  public val substanceCode: SearchParam<Ingredient, CodeableConcept> =
    SimpleSearchParam<Ingredient, CodeableConcept>(
      name = "substance-code",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.substance.code.concept",
      extractor = { resource -> listOfNotNull(resource.substance.code.concept) },
    )

  public val substanceDefinition: SearchParam<Ingredient, Reference> =
    SimpleSearchParam<Ingredient, Reference>(
      name = "substance-definition",
      type = SearchParamType.fromCode("reference"),
      expression = "Ingredient.substance.code.reference",
      target = listOf(SubstanceDefinition::class),
      extractor = { resource -> listOfNotNull(resource.substance.code.reference) },
    )

  /** All search parameters for the Ingredient resource type. */
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
