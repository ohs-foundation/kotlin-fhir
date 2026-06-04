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

import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.NutritionProduct
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionProduct] resource type. */
public object NutritionProductSearchParams {
  public val identifier: SearchParam<NutritionProduct, Identifier> =
    SimpleSearchParam<NutritionProduct, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionProduct.instance.identifier",
      extractor = { resource -> resource.instance?.identifier ?: emptyList() },
    )

  public val status: SearchParam<NutritionProduct, Any> =
    SimpleSearchParam<NutritionProduct, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionProduct.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the NutritionProduct resource type. */
  public val all: List<SearchParam<NutritionProduct, *>> = listOf(identifier, status)
}
