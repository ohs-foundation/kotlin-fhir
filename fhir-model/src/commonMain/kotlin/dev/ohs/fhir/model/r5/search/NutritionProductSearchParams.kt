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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NutritionProduct] resource type. */
public object NutritionProductSearchParams {
  public val code: SearchParam<NutritionProduct, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionProduct.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val identifier: SearchParam<NutritionProduct, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionProduct.instance.identifier",
      extractor = { resource -> resource.instance.flatMap { it.identifier } },
    )

  public val lotNumber: SearchParam<NutritionProduct, String> =
    SearchParam(
      name = "lot-number",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionProduct.instance.lotNumber",
      extractor = { resource -> resource.instance.mapNotNull { it.lotNumber } },
    )

  public val serialNumber: SearchParam<NutritionProduct, Identifier> =
    SearchParam(
      name = "serial-number",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionProduct.instance.identifier",
      extractor = { resource -> resource.instance.flatMap { it.identifier } },
    )

  public val status: SearchParam<NutritionProduct, CodeableConcept> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "NutritionProduct.category",
      extractor = { resource -> resource.category },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<NutritionProduct, *>> = listOf()

  /**
   * Supported search parameters for the NutritionProduct resource type. Entries in [unsupported]
   * are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<NutritionProduct, *>> =
    listOf(code, identifier, lotNumber, serialNumber, status) - unsupported.toSet()
}
