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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Medication] resource type. */
public object MedicationSearchParam {
  public val Code: SearchParam<Medication, CodeableConcept> =
    SimpleSearchParam<Medication, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val ExpirationDate: SearchParam<Medication, DateTime> =
    SimpleSearchParam<Medication, DateTime>(
      name = "expiration-date",
      type = SearchParamType.fromCode("date"),
      expression = "Medication.batch.expirationDate",
      extractor = { resource -> listOfNotNull(resource.batch?.expirationDate) },
    )

  public val Form: SearchParam<Medication, Any> =
    SimpleSearchParam<Medication, Any>(
      name = "form",
      type = SearchParamType.fromCode("token"),
      expression = "",
      extractor = { emptyList() },
    )

  public val Identifier: SearchParam<Medication, Identifier> =
    SimpleSearchParam<Medication, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Ingredient: SearchParam<Medication, Reference> =
    SimpleSearchParam<Medication, Reference>(
      name = "ingredient",
      type = SearchParamType.fromCode("reference"),
      expression = "Medication.ingredient.item.reference",
      target = listOf(Substance::class, Medication::class),
      extractor = { resource -> resource.ingredient.map { it.item }.mapNotNull { it.reference } },
    )

  public val IngredientCode: SearchParam<Medication, CodeableConcept> =
    SimpleSearchParam<Medication, CodeableConcept>(
      name = "ingredient-code",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.ingredient.item.concept",
      extractor = { resource -> resource.ingredient.map { it.item }.mapNotNull { it.concept } },
    )

  public val LotNumber: SearchParam<Medication, String> =
    SimpleSearchParam<Medication, String>(
      name = "lot-number",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.batch.lotNumber",
      extractor = { resource -> listOfNotNull(resource.batch?.lotNumber) },
    )

  public val Marketingauthorizationholder: SearchParam<Medication, Reference> =
    SimpleSearchParam<Medication, Reference>(
      name = "marketingauthorizationholder",
      type = SearchParamType.fromCode("reference"),
      expression = "Medication.marketingAuthorizationHolder",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.marketingAuthorizationHolder) },
    )

  public val SerialNumber: SearchParam<Medication, Identifier> =
    SimpleSearchParam<Medication, Identifier>(
      name = "serial-number",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Status: SearchParam<Medication, Any> =
    SimpleSearchParam<Medication, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

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
}
