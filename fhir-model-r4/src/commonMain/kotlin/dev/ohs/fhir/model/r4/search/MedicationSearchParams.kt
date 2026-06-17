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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

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
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "Medication.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val expirationDate: SearchParam<Medication, DateTime> =
    SearchParam(
      name = "expiration-date",
      type = SearchParamType.Date,
      expression = "Medication.batch.expirationDate",
      extractor = { resource -> listOfNotNull(resource.batch?.expirationDate) },
    )

  public val form: SearchParam<Medication, CodeableConcept> =
    SearchParam(
      name = "form",
      type = SearchParamType.Token,
      expression = "Medication.form",
      extractor = { resource -> listOfNotNull(resource.form) },
    )

  public val identifier: SearchParam<Medication, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Medication.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ingredient: SearchParam<Medication, Reference> =
    SearchParam(
      name = "ingredient",
      type = SearchParamType.Reference,
      expression = "(Medication.ingredient.item as Reference)",
      target = listOf(Medication::class, Substance::class),
      extractor = { resource ->
        resource.ingredient.mapNotNull { (it.item as? Medication.Ingredient.Item.Reference)?.value }
      },
    )

  public val ingredientCode: SearchParam<Medication, CodeableConcept> =
    SearchParam(
      name = "ingredient-code",
      type = SearchParamType.Token,
      expression = "(Medication.ingredient.item as CodeableConcept)",
      extractor = { resource ->
        resource.ingredient.mapNotNull {
          (it.item as? Medication.Ingredient.Item.CodeableConcept)?.value
        }
      },
    )

  public val lotNumber: SearchParam<Medication, String> =
    SearchParam(
      name = "lot-number",
      type = SearchParamType.Token,
      expression = "Medication.batch.lotNumber",
      extractor = { resource -> listOfNotNull(resource.batch?.lotNumber) },
    )

  public val manufacturer: SearchParam<Medication, Reference> =
    SearchParam(
      name = "manufacturer",
      type = SearchParamType.Reference,
      expression = "Medication.manufacturer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
    )

  public val status: SearchParam<Medication, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Medication.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Medication, *>> = listOf()

  /**
   * Supported search parameters for the Medication resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
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
