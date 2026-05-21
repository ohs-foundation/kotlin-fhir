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

import dev.ohs.fhir.model.r4b.NutritionProduct
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [NutritionProduct] resource type. */
public object NutritionProductSearchParam {
  /** All search parameters for the NutritionProduct resource type. */
  public val ALL: List<SearchParam<NutritionProduct, *>> = listOf(Identifier, Status)

  public data object Identifier : SearchParam<NutritionProduct, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionProduct.instance.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: NutritionProduct
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.instance?.identifier ?: emptyList()
  }

  public data object Status : SearchParam<NutritionProduct, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NutritionProduct.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: NutritionProduct): List<Any> = listOf(resource.status)
  }
}
