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
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Substance
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Substance] resource type. */
public object SubstanceSearchParams {
  public val category: SearchParam<Substance, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<Substance, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val containerIdentifier: SearchParam<Substance, Identifier> =
    SearchParam(
      name = "container-identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.instance.identifier",
      extractor = { resource -> resource.instance.mapNotNull { it.identifier } },
    )

  public val expiry: SearchParam<Substance, DateTime> =
    SearchParam(
      name = "expiry",
      type = SearchParamType.fromCode("date"),
      expression = "Substance.instance.expiry",
      extractor = { resource -> resource.instance.mapNotNull { it.expiry } },
    )

  public val identifier: SearchParam<Substance, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val quantity: SearchParam<Substance, Quantity> =
    SearchParam(
      name = "quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "Substance.instance.quantity",
      extractor = { resource -> resource.instance.mapNotNull { it.quantity } },
    )

  public val status: SearchParam<Substance, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val substanceReference: SearchParam<Substance, Reference> =
    SearchParam(
      name = "substance-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "(Substance.ingredient.substance as Reference)",
      target = listOf(Substance::class),
      extractor = { resource ->
        resource.ingredient.mapNotNull {
          (it.substance as? Substance.Ingredient.Substance.Reference)?.value
        }
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Substance, *>> = listOf()

  /**
   * Supported search parameters for the Substance resource type. Entries in [unsupported] are
   * excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<Substance, *>> =
    listOf(
      category,
      code,
      containerIdentifier,
      expiry,
      identifier,
      quantity,
      status,
      substanceReference,
    ) - unsupported.toSet()
}
