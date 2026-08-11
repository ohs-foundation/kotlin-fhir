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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Substance] resource type. */
public object SubstanceSearchParams {
  public val category: SearchParam<Substance, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "Substance.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<Substance, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "Substance.code.concept",
      extractor = { resource -> listOfNotNull(resource.code.concept) },
    )

  public val codeReference: SearchParam<Substance, Reference> =
    SearchParam(
      name = "code-reference",
      type = SearchParamType.Reference,
      expression = "Substance.code.reference",
      target = listOf(SubstanceDefinition::class),
      extractor = { resource -> listOfNotNull(resource.code.reference) },
    )

  public val expiry: SearchParam<Substance, DateTime> =
    SearchParam(
      name = "expiry",
      type = SearchParamType.Date,
      expression = "Substance.expiry",
      extractor = { resource -> listOfNotNull(resource.expiry) },
    )

  public val identifier: SearchParam<Substance, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Substance.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val quantity: SearchParam<Substance, Quantity> =
    SearchParam(
      name = "quantity",
      type = SearchParamType.Quantity,
      expression = "Substance.quantity",
      extractor = { resource -> listOfNotNull(resource.quantity) },
    )

  public val status: SearchParam<Substance, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Substance.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val substanceReference: SearchParam<Substance, Reference> =
    SearchParam(
      name = "substance-reference",
      type = SearchParamType.Reference,
      expression = "(Substance.ingredient.substance.ofType(Reference))",
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
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Substance, *>> = listOf()

  /**
   * Supported search parameters for the Substance resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Substance, *>> =
    listOf(category, code, codeReference, expiry, identifier, quantity, status, substanceReference)
}
