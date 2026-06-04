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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProduct
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProduct] resource type. */
public object MedicinalProductSearchParams {
  public val identifier: SearchParam<MedicinalProduct, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProduct.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<MedicinalProduct, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "MedicinalProduct.name.productName",
      extractor = { resource -> resource.name.map { it.productName } },
    )

  public val nameLanguage: SearchParam<MedicinalProduct, CodeableConcept> =
    SearchParam(
      name = "name-language",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProduct.name.countryLanguage.language",
      extractor = { resource -> resource.name.flatMap { it.countryLanguage }.map { it.language } },
    )

  /** All search parameters for the MedicinalProduct resource type. */
  public val all: List<SearchParam<MedicinalProduct, *>> = listOf(identifier, name, nameLanguage)
}
