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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Substance
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Medication] resource type. */
public object MedicationSearchParams {
  public val code: SearchParam<Medication, CodeableConcept> =
    SimpleSearchParam<Medication, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val expirationDate: SearchParam<Medication, DateTime> =
    SimpleSearchParam<Medication, DateTime>(
      name = "expiration-date",
      type = SearchParamType.fromCode("date"),
      expression = "Medication.batch.expirationDate",
      extractor = { resource -> listOfNotNull(resource.batch?.expirationDate) },
    )

  public val form: SearchParam<Medication, CodeableConcept> =
    SimpleSearchParam<Medication, CodeableConcept>(
      name = "form",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.form",
      extractor = { resource -> listOfNotNull(resource.form) },
    )

  public val identifier: SearchParam<Medication, Identifier> =
    SimpleSearchParam<Medication, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ingredient: SearchParam<Medication, Reference> =
    SimpleSearchParam<Medication, Reference>(
      name = "ingredient",
      type = SearchParamType.fromCode("reference"),
      expression = "(Medication.ingredient.item as Reference)",
      target = listOf(Medication::class, Substance::class),
      extractor = { resource ->
        resource.ingredient.mapNotNull { (it.item as? Medication.Ingredient.Item.Reference)?.value }
      },
    )

  public val ingredientCode: SearchParam<Medication, CodeableConcept> =
    SimpleSearchParam<Medication, CodeableConcept>(
      name = "ingredient-code",
      type = SearchParamType.fromCode("token"),
      expression = "(Medication.ingredient.item as CodeableConcept)",
      extractor = { resource ->
        resource.ingredient.mapNotNull {
          (it.item as? Medication.Ingredient.Item.CodeableConcept)?.value
        }
      },
    )

  public val lotNumber: SearchParam<Medication, String> =
    SimpleSearchParam<Medication, String>(
      name = "lot-number",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.batch.lotNumber",
      extractor = { resource -> listOfNotNull(resource.batch?.lotNumber) },
    )

  public val manufacturer: SearchParam<Medication, Reference> =
    SimpleSearchParam<Medication, Reference>(
      name = "manufacturer",
      type = SearchParamType.fromCode("reference"),
      expression = "Medication.manufacturer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
    )

  public val status: SearchParam<Medication, Any> =
    SimpleSearchParam<Medication, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Medication.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  /** All search parameters for the Medication resource type. */
  public val all: List<SearchParam<Medication, *>> =
    listOf(
      code,
      expirationDate,
      form,
      identifier,
      ingredient,
      ingredientCode,
      lotNumber,
      manufacturer,
      status,
    )
}
