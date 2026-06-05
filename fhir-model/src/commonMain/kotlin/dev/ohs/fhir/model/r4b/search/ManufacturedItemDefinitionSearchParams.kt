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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ManufacturedItemDefinition
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ManufacturedItemDefinition] resource type. */
public object ManufacturedItemDefinitionSearchParams {
  public val doseForm: SearchParam<ManufacturedItemDefinition, CodeableConcept> =
    SearchParam(
      name = "dose-form",
      type = SearchParamType.fromCode("token"),
      expression = "ManufacturedItemDefinition.manufacturedDoseForm",
      extractor = { resource -> listOf(resource.manufacturedDoseForm) },
    )

  public val identifier: SearchParam<ManufacturedItemDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ManufacturedItemDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ingredient: SearchParam<ManufacturedItemDefinition, CodeableConcept> =
    SearchParam(
      name = "ingredient",
      type = SearchParamType.fromCode("token"),
      expression = "ManufacturedItemDefinition.ingredient",
      extractor = { resource -> resource.ingredient },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ManufacturedItemDefinition, *>> = listOf()

  /**
   * Supported search parameters for the ManufacturedItemDefinition resource type. Entries in
   * [unsupported] are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<ManufacturedItemDefinition, *>> =
    listOf(doseForm, identifier, ingredient) - unsupported.toSet()
}
