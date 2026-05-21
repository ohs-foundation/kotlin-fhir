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
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Substance
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Substance] resource type. */
public object SubstanceSearchParam {
  /** All search parameters for the Substance resource type. */
  public val ALL: List<SearchParam<Substance, *>> =
    listOf(Category, Code, CodeReference, Expiry, Identifier, Quantity, Status, SubstanceReference)

  public data object Category : SearchParam<Substance, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Substance): List<CodeableConcept> = resource.category
  }

  public data object Code : SearchParam<Substance, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.code.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Substance): List<CodeableConcept> =
      listOfNotNull(resource.code.concept)
  }

  public data object CodeReference : SearchParam<Substance, Reference> {
    public override val paramName: String = "code-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Substance.code.reference"

    public override val target: List<KClass<out Resource>> = listOf(SubstanceDefinition::class)

    public override fun extract(resource: Substance): List<Reference> =
      listOfNotNull(resource.code.reference)
  }

  public data object Expiry : SearchParam<Substance, DateTime> {
    public override val paramName: String = "expiry"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Substance.expiry"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Substance): List<DateTime> =
      listOfNotNull(resource.expiry)
  }

  public data object Identifier : SearchParam<Substance, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Substance): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Quantity : SearchParam<Substance, dev.ohs.fhir.model.r5.Quantity> {
    public override val paramName: String = "quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Substance.quantity"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Substance): List<dev.ohs.fhir.model.r5.Quantity> =
      listOfNotNull(resource.quantity)
  }

  public data object Status : SearchParam<Substance, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Substance.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Substance): List<Any> = listOfNotNull(resource.status)
  }

  public data object SubstanceReference : SearchParam<Substance, Any> {
    public override val paramName: String = "substance-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(Substance.ingredient.substance.ofType(Reference))"

    public override val target: List<KClass<out Resource>> = listOf(Substance::class)

    public override fun extract(resource: Substance): List<Any> = emptyList()
  }
}
