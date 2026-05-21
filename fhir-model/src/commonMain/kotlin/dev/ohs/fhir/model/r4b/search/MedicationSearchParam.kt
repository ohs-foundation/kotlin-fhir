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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Medication] resource type. */
public object MedicationSearchParam {
  /** All search parameters for the Medication resource type. */
  public val ALL: List<SearchParam<Medication, *>> =
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

  public data object Code : SearchParam<Medication, CodeableConcept> {
    public override val name: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object ExpirationDate : SearchParam<Medication, DateTime> {
    public override val name: KotlinString = "expiration-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Medication.batch.expirationDate"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<DateTime> =
      listOfNotNull(resource.batch?.expirationDate)
  }

  public data object Form : SearchParam<Medication, CodeableConcept> {
    public override val name: KotlinString = "form"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.form"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<CodeableConcept> =
      listOfNotNull(resource.form)
  }

  public data object Identifier : SearchParam<Medication, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Ingredient : SearchParam<Medication, Reference> {
    public override val name: KotlinString = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "(Medication.ingredient.item as Reference)"

    public override val target: List<KClass<out Resource>> =
      listOf(Medication::class, Substance::class)

    public override fun extract(resource: Medication): List<Reference> =
      resource.ingredient.mapNotNull { (it.item as? Medication.Ingredient.Item.Reference)?.value }
  }

  public data object IngredientCode : SearchParam<Medication, CodeableConcept> {
    public override val name: KotlinString = "ingredient-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Medication.ingredient.item as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<CodeableConcept> =
      resource.ingredient.mapNotNull {
        (it.item as? Medication.Ingredient.Item.CodeableConcept)?.value
      }
  }

  public data object LotNumber : SearchParam<Medication, R4bString> {
    public override val name: KotlinString = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.batch.lotNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<R4bString> =
      listOfNotNull(resource.batch?.lotNumber)
  }

  public data object Manufacturer : SearchParam<Medication, Reference> {
    public override val name: KotlinString = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Medication.manufacturer"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Medication): List<Reference> =
      listOfNotNull(resource.manufacturer)
  }

  public data object Status : SearchParam<Medication, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<Any> = listOfNotNull(resource.status)
  }
}
