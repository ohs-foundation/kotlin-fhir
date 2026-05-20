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
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Substance
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Substance] resource type. */
public object SubstanceSearchParam {
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

  public data object Category : SearchParam<Substance, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<CodeableConcept> = resource.category
  }

  public data object Code : SearchParam<Substance, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<CodeableConcept> = listOf(resource.code)
  }

  public data object ContainerIdentifier :
    SearchParam<Substance, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "container-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.instance.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.instance.mapNotNull { it.identifier }
  }

  public data object Expiry : SearchParam<Substance, DateTime> {
    public override val paramName: String = "expiry"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Substance.instance.expiry"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<DateTime> =
      resource.instance.mapNotNull { it.expiry }
  }

  public data object Identifier : SearchParam<Substance, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Quantity : SearchParam<Substance, dev.ohs.fhir.model.r4b.Quantity> {
    public override val paramName: String = "quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Substance.instance.quantity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<dev.ohs.fhir.model.r4b.Quantity> =
      resource.instance.mapNotNull { it.quantity }
  }

  public data object Status : SearchParam<Substance, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Substance): List<Any> = listOfNotNull(resource.status)
  }

  public data object SubstanceReference : SearchParam<Substance, Reference> {
    public override val paramName: String = "substance-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(Substance.ingredient.substance as Reference)"

    public override val target: List<String> = listOf("Substance")

    public override fun extract(resource: Substance): List<Reference> =
      resource.ingredient.mapNotNull {
        (it.substance as? Substance.Ingredient.Substance.Reference)?.value
      }
  }
}
