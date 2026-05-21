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
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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
      Marketingauthorizationholder,
      SerialNumber,
      Status,
    )

  public data object Code : SearchParam<Medication, CodeableConcept> {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object ExpirationDate : SearchParam<Medication, DateTime> {
    public override val paramName: KotlinString = "expiration-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Medication.batch.expirationDate"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<DateTime> =
      listOfNotNull(resource.batch?.expirationDate)
  }

  public data object Form : SearchParam<Medication, Any> {
    public override val paramName: KotlinString = "form"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = ""

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<Any> = emptyList()
  }

  public data object Identifier : SearchParam<Medication, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Ingredient : SearchParam<Medication, Reference> {
    public override val paramName: KotlinString = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Medication.ingredient.item.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(Substance::class, Medication::class)

    public override fun extract(resource: Medication): List<Reference> =
      resource.ingredient.map { it.item }.mapNotNull { it.reference }
  }

  public data object IngredientCode : SearchParam<Medication, CodeableConcept> {
    public override val paramName: KotlinString = "ingredient-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.ingredient.item.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<CodeableConcept> =
      resource.ingredient.map { it.item }.mapNotNull { it.concept }
  }

  public data object LotNumber : SearchParam<Medication, R5String> {
    public override val paramName: KotlinString = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.batch.lotNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<R5String> =
      listOfNotNull(resource.batch?.lotNumber)
  }

  public data object Marketingauthorizationholder : SearchParam<Medication, Reference> {
    public override val paramName: KotlinString = "marketingauthorizationholder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Medication.marketingAuthorizationHolder"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Medication): List<Reference> =
      listOfNotNull(resource.marketingAuthorizationHolder)
  }

  public data object SerialNumber : SearchParam<Medication, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "serial-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Status : SearchParam<Medication, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Medication.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Medication): List<Any> = listOfNotNull(resource.status)
  }
}
