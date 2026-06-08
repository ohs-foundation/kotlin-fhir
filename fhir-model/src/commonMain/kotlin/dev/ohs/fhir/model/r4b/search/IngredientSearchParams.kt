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

import dev.ohs.fhir.model.r4b.AdministrableProductDefinition
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Ingredient
import dev.ohs.fhir.model.r4b.ManufacturedItemDefinition
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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
          AdministrableProductDefinition::class,
          ManufacturedItemDefinition::class,
          MedicinalProductDefinition::class,
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

  public val manufacturer: SearchParam<Ingredient, Ingredient.Manufacturer> =
    SearchParam(
      name = "manufacturer",
      type = SearchParamType.Reference,
      expression = "Ingredient.manufacturer",
      extractor = { resource -> resource.manufacturer },
    )

  public val role: SearchParam<Ingredient, CodeableConcept> =
    SearchParam(
      name = "role",
      type = SearchParamType.Token,
      expression = "Ingredient.role",
      extractor = { resource -> listOf(resource.role) },
    )

  public val substance: SearchParam<Ingredient, Reference> =
    SearchParam(
      name = "substance",
      type = SearchParamType.Reference,
      expression = "Ingredient.substance.code.reference",
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
      extractor = { resource -> listOfNotNull(resource.substance.code.reference) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
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
      substance,
      substanceCode,
      substanceDefinition,
    )
}
