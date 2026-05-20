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
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionProduct] resource type. */
public object NutritionProductSearchParam {
  /** All search parameters for the NutritionProduct resource type. */
  public val ALL: List<SearchParam<NutritionProduct, *>> =
    listOf(Code, Identifier, LotNumber, SerialNumber, Status)

  public data object Code : SearchParam<NutritionProduct, CodeableConcept> {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NutritionProduct.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NutritionProduct): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Identifier : SearchParam<NutritionProduct, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NutritionProduct.instance.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: NutritionProduct
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.instance.flatMap { it.identifier }
  }

  public data object LotNumber : SearchParam<NutritionProduct, R5String> {
    public override val paramName: KotlinString = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NutritionProduct.instance.lotNumber"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NutritionProduct): List<R5String> =
      resource.instance.mapNotNull { it.lotNumber }
  }

  public data object SerialNumber :
    SearchParam<NutritionProduct, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "serial-number"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NutritionProduct.instance.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: NutritionProduct
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.instance.flatMap { it.identifier }
  }

  public data object Status : SearchParam<NutritionProduct, CodeableConcept> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NutritionProduct.category"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NutritionProduct): List<CodeableConcept> =
      resource.category
  }
}
