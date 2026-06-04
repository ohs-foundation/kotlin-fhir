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
  public val For: SearchParam<Ingredient, Reference> =
    SimpleSearchParam<Ingredient, Reference>(
      name = "for",
      type = SearchParamType.fromCode("reference"),
      expression = "Ingredient.for",
      target =
        listOf(
          AdministrableProductDefinition::class,
          ManufacturedItemDefinition::class,
          MedicinalProductDefinition::class,
        ),
      extractor = { resource -> resource.`for` },
    )

  public val Function: SearchParam<Ingredient, CodeableConcept> =
    SimpleSearchParam<Ingredient, CodeableConcept>(
      name = "function",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.function",
      extractor = { resource -> resource.function },
    )

  public val Identifier: SearchParam<Ingredient, Identifier> =
    SimpleSearchParam<Ingredient, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val Manufacturer: SearchParam<Ingredient, Ingredient.Manufacturer> =
    SimpleSearchParam<Ingredient, Ingredient.Manufacturer>(
      name = "manufacturer",
      type = SearchParamType.fromCode("reference"),
      expression = "Ingredient.manufacturer",
      extractor = { resource -> resource.manufacturer },
    )

  public val Role: SearchParam<Ingredient, CodeableConcept> =
    SimpleSearchParam<Ingredient, CodeableConcept>(
      name = "role",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.role",
      extractor = { resource -> listOf(resource.role) },
    )

  public val Substance: SearchParam<Ingredient, Reference> =
    SimpleSearchParam<Ingredient, Reference>(
      name = "substance",
      type = SearchParamType.fromCode("reference"),
      expression = "Ingredient.substance.code.reference",
      extractor = { resource -> listOfNotNull(resource.substance.code.reference) },
    )

  public val SubstanceCode: SearchParam<Ingredient, CodeableConcept> =
    SimpleSearchParam<Ingredient, CodeableConcept>(
      name = "substance-code",
      type = SearchParamType.fromCode("token"),
      expression = "Ingredient.substance.code.concept",
      extractor = { resource -> listOfNotNull(resource.substance.code.concept) },
    )

  public val SubstanceDefinition: SearchParam<Ingredient, Reference> =
    SimpleSearchParam<Ingredient, Reference>(
      name = "substance-definition",
      type = SearchParamType.fromCode("reference"),
      expression = "Ingredient.substance.code.reference",
      extractor = { resource -> listOfNotNull(resource.substance.code.reference) },
    )

  /** All search parameters for the Ingredient resource type. */
  public val ALL: List<SearchParam<Ingredient, *>> =
    listOf(
      For,
      Function,
      Identifier,
      Manufacturer,
      Role,
      Substance,
      SubstanceCode,
      SubstanceDefinition,
    )
}
