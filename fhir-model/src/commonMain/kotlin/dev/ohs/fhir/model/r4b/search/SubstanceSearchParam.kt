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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Substance] resource type. */
public object SubstanceSearchParam {
  public val Category: SearchParam<Substance, CodeableConcept> =
    SimpleSearchParam<Substance, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.category",
      extractor = { resource -> resource.category },
    )

  public val Code: SearchParam<Substance, CodeableConcept> =
    SimpleSearchParam<Substance, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val ContainerIdentifier: SearchParam<Substance, Identifier> =
    SimpleSearchParam<Substance, Identifier>(
      name = "container-identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.instance.identifier",
      extractor = { resource -> resource.instance.mapNotNull { it.identifier } },
    )

  public val Expiry: SearchParam<Substance, DateTime> =
    SimpleSearchParam<Substance, DateTime>(
      name = "expiry",
      type = SearchParamType.fromCode("date"),
      expression = "Substance.instance.expiry",
      extractor = { resource -> resource.instance.mapNotNull { it.expiry } },
    )

  public val Identifier: SearchParam<Substance, Identifier> =
    SimpleSearchParam<Substance, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Quantity: SearchParam<Substance, Quantity> =
    SimpleSearchParam<Substance, Quantity>(
      name = "quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "Substance.instance.quantity",
      extractor = { resource -> resource.instance.mapNotNull { it.quantity } },
    )

  public val Status: SearchParam<Substance, Any> =
    SimpleSearchParam<Substance, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Substance.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val SubstanceReference: SearchParam<Substance, Reference> =
    SimpleSearchParam<Substance, Reference>(
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

  /** All search parameters for the Substance resource type. */
  public val ALL: List<SearchParam<Substance, *>> =
    listOf(
      Category,
      Code,
      ContainerIdentifier,
      Expiry,
      Identifier,
      Quantity,
      Status,
      SubstanceReference,
    )
}
