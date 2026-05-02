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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Ingredient] resource type. */
public sealed class IngredientSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Ingredient): List<T>

  public data object For : IngredientSearchParam<Reference>() {
    public override val paramName: String = "for"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Ingredient.for"

    public override val target: List<String> =
      listOf(
        "MedicinalProductDefinition",
        "AdministrableProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: Ingredient): List<Reference> = resource.`for`
  }

  public data object Function : IngredientSearchParam<CodeableConcept>() {
    public override val paramName: String = "function"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.function"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<CodeableConcept> = resource.function
  }

  public data object Identifier : IngredientSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<dev.ohs.fhir.model.r5.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Manufacturer : IngredientSearchParam<Reference>() {
    public override val paramName: String = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Ingredient.manufacturer.manufacturer"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Ingredient): List<Reference> =
      resource.manufacturer.map { it.manufacturer }
  }

  public data object Role : IngredientSearchParam<CodeableConcept>() {
    public override val paramName: String = "role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.role"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<CodeableConcept> = listOf(resource.role)
  }

  public data object Status : IngredientSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = listOf(resource.status)
  }

  public data object StrengthConcentrationQuantity : IngredientSearchParam<Any>() {
    public override val paramName: String = "strength-concentration-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String =
      "Ingredient.substance.strength.concentration.ofType(Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = emptyList()
  }

  public data object StrengthConcentrationRatio : IngredientSearchParam<Any>() {
    public override val paramName: String = "strength-concentration-ratio"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String =
      "Ingredient.substance.strength.concentration.ofType(Ratio)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = emptyList()
  }

  public data object StrengthPresentationQuantity : IngredientSearchParam<Any>() {
    public override val paramName: String = "strength-presentation-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String =
      "Ingredient.substance.strength.presentation.ofType(Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = emptyList()
  }

  public data object StrengthPresentationRatio : IngredientSearchParam<Any>() {
    public override val paramName: String = "strength-presentation-ratio"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String =
      "Ingredient.substance.strength.presentation.ofType(Ratio)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = emptyList()
  }

  public data object Substance : IngredientSearchParam<Reference>() {
    public override val paramName: String = "substance"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Ingredient.substance.code.reference"

    public override val target: List<String> = listOf("SubstanceDefinition")

    public override fun extract(resource: Ingredient): List<Reference> =
      listOfNotNull(resource.substance.code.reference)
  }

  public data object SubstanceCode : IngredientSearchParam<CodeableConcept>() {
    public override val paramName: String = "substance-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.substance.code.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Ingredient): List<CodeableConcept> =
      listOfNotNull(resource.substance.code.concept)
  }

  public data object SubstanceDefinition : IngredientSearchParam<Reference>() {
    public override val paramName: String = "substance-definition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Ingredient.substance.code.reference"

    public override val target: List<String> = listOf("SubstanceDefinition")

    public override fun extract(resource: Ingredient): List<Reference> =
      listOfNotNull(resource.substance.code.reference)
  }

  public companion object {
    /** All search parameters for the Ingredient resource type. */
    public val ALL: List<IngredientSearchParam<*>> =
      listOf(
        For,
        Function,
        Identifier,
        Manufacturer,
        Role,
        Status,
        StrengthConcentrationQuantity,
        StrengthConcentrationRatio,
        StrengthPresentationQuantity,
        StrengthPresentationRatio,
        Substance,
        SubstanceCode,
        SubstanceDefinition,
      )
  }
}
