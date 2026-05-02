/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Medication] resource type. */
public sealed class MedicationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Medication): List<T>

  public data object Code : MedicationSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Medication.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object ExpirationDate : MedicationSearchParam<Any>() {
    public override val paramName: String = "expiration-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Medication.batch.expirationDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object Form : MedicationSearchParam<Any>() {
    public override val paramName: String = "form"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = ""

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object Identifier : MedicationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Medication.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object Ingredient : MedicationSearchParam<Any>() {
    public override val paramName: String = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Medication.ingredient.item.reference"

    public override val target: List<String> = listOf("Substance", "Medication")

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object IngredientCode : MedicationSearchParam<Any>() {
    public override val paramName: String = "ingredient-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Medication.ingredient.item.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object LotNumber : MedicationSearchParam<Any>() {
    public override val paramName: String = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Medication.batch.lotNumber"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object Marketingauthorizationholder : MedicationSearchParam<Any>() {
    public override val paramName: String = "marketingauthorizationholder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Medication.marketingAuthorizationHolder"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object SerialNumber : MedicationSearchParam<Any>() {
    public override val paramName: String = "serial-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Medication.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object Status : MedicationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Medication.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Medication resource type. */
    public val ALL: List<MedicationSearchParam<*>> =
      listOf(
        Code,
        ExpirationDate,
        Form,
        Identifier,
        Ingredient,
        IngredientCode,
        LotNumber,
        Marketingauthorizationholder,
        SerialNumber,
        Status,
      )
  }
}
