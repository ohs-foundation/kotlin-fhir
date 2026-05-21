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
import dev.ohs.fhir.model.r5.Ingredient
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Ingredient] resource type. */
public object IngredientSearchParam {
  /** All search parameters for the Ingredient resource type. */
  public val ALL: List<SearchParam<Ingredient, *>> =
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

  public data object For : SearchParam<Ingredient, Reference> {
    public override val paramName: String = "for"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Ingredient.for"

    public override val target: List<KClass<out Resource>> =
      listOf(
        MedicinalProductDefinition::class,
        AdministrableProductDefinition::class,
        ManufacturedItemDefinition::class,
      )

    public override fun extract(resource: Ingredient): List<Reference> = resource.`for`
  }

  public data object Function : SearchParam<Ingredient, CodeableConcept> {
    public override val paramName: String = "function"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.function"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<CodeableConcept> = resource.function
  }

  public data object Identifier : SearchParam<Ingredient, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<dev.ohs.fhir.model.r5.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Manufacturer : SearchParam<Ingredient, Reference> {
    public override val paramName: String = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Ingredient.manufacturer.manufacturer"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Ingredient): List<Reference> =
      resource.manufacturer.map { it.manufacturer }
  }

  public data object Role : SearchParam<Ingredient, CodeableConcept> {
    public override val paramName: String = "role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.role"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<CodeableConcept> = listOf(resource.role)
  }

  public data object Status : SearchParam<Ingredient, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = listOf(resource.status)
  }

  public data object StrengthConcentrationQuantity : SearchParam<Ingredient, Any> {
    public override val paramName: String = "strength-concentration-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String =
      "Ingredient.substance.strength.concentration.ofType(Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = emptyList()
  }

  public data object StrengthConcentrationRatio : SearchParam<Ingredient, Any> {
    public override val paramName: String = "strength-concentration-ratio"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String =
      "Ingredient.substance.strength.concentration.ofType(Ratio)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = emptyList()
  }

  public data object StrengthPresentationQuantity : SearchParam<Ingredient, Any> {
    public override val paramName: String = "strength-presentation-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String =
      "Ingredient.substance.strength.presentation.ofType(Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = emptyList()
  }

  public data object StrengthPresentationRatio : SearchParam<Ingredient, Any> {
    public override val paramName: String = "strength-presentation-ratio"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String =
      "Ingredient.substance.strength.presentation.ofType(Ratio)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<Any> = emptyList()
  }

  public data object Substance : SearchParam<Ingredient, Reference> {
    public override val paramName: String = "substance"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Ingredient.substance.code.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.SubstanceDefinition::class)

    public override fun extract(resource: Ingredient): List<Reference> =
      listOfNotNull(resource.substance.code.reference)
  }

  public data object SubstanceCode : SearchParam<Ingredient, CodeableConcept> {
    public override val paramName: String = "substance-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Ingredient.substance.code.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Ingredient): List<CodeableConcept> =
      listOfNotNull(resource.substance.code.concept)
  }

  public data object SubstanceDefinition : SearchParam<Ingredient, Reference> {
    public override val paramName: String = "substance-definition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Ingredient.substance.code.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.SubstanceDefinition::class)

    public override fun extract(resource: Ingredient): List<Reference> =
      listOfNotNull(resource.substance.code.reference)
  }
}
