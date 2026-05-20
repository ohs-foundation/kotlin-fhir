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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Medication] resource type. */
public sealed class MedicationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Medication): List<T>

  public data object Code : MedicationSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Medication): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object ExpirationDate : MedicationSearchParam<DateTime>() {
    public override val paramName: KotlinString = "expiration-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Medication.batch.expirationDate"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Medication): List<DateTime> =
      listOfNotNull(resource.batch?.expirationDate)
  }

  public data object Form : MedicationSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "form"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.form"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Medication): List<CodeableConcept> =
      listOfNotNull(resource.form)
  }

  public data object Identifier : MedicationSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Medication): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Ingredient : MedicationSearchParam<Reference>() {
    public override val paramName: KotlinString = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(Medication.ingredient.item as Reference)"

    public override val target: List<KotlinString> = listOf("Medication", "Substance")

    public override fun extract(resource: Medication): List<Reference> =
      resource.ingredient.mapNotNull { (it.item as? Medication.Ingredient.Item.Reference)?.value }
  }

  public data object IngredientCode : MedicationSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "ingredient-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Medication.ingredient.item as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Medication): List<CodeableConcept> =
      resource.ingredient.mapNotNull {
        (it.item as? Medication.Ingredient.Item.CodeableConcept)?.value
      }
  }

  public data object LotNumber : MedicationSearchParam<R4String>() {
    public override val paramName: KotlinString = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.batch.lotNumber"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Medication): List<R4String> =
      listOfNotNull(resource.batch?.lotNumber)
  }

  public data object Manufacturer : MedicationSearchParam<Reference>() {
    public override val paramName: KotlinString = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Medication.manufacturer"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Medication): List<Reference> =
      listOfNotNull(resource.manufacturer)
  }

  public data object Status : MedicationSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Medication): List<Any> = listOfNotNull(resource.status)
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
        Manufacturer,
        Status,
      )
  }
}
