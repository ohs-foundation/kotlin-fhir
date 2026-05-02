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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionProduct] resource type. */
public sealed class NutritionProductSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: NutritionProduct): List<T>

  public data object Code : NutritionProductSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NutritionProduct.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NutritionProduct): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Identifier : NutritionProductSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NutritionProduct.instance.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: NutritionProduct
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.instance.flatMap { it.identifier }
  }

  public data object LotNumber : NutritionProductSearchParam<String>() {
    public override val paramName: kotlin.String = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NutritionProduct.instance.lotNumber"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NutritionProduct): List<String> =
      resource.instance.mapNotNull { it.lotNumber }
  }

  public data object SerialNumber :
    NutritionProductSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "serial-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NutritionProduct.instance.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: NutritionProduct
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.instance.flatMap { it.identifier }
  }

  public data object Status : NutritionProductSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NutritionProduct.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NutritionProduct): List<CodeableConcept> =
      resource.category
  }

  public companion object {
    /** All search parameters for the NutritionProduct resource type. */
    public val ALL: List<NutritionProductSearchParam<*>> =
      listOf(Code, Identifier, LotNumber, SerialNumber, Status)
  }
}
