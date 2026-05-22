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
public object ManufacturedItemDefinitionSearchParam {
  public val DoseForm: SearchParam<ManufacturedItemDefinition, CodeableConcept> =
    SimpleSearchParam<ManufacturedItemDefinition, CodeableConcept>(
      name = "dose-form",
      type = SearchParamType.fromCode("token"),
      expression = "ManufacturedItemDefinition.manufacturedDoseForm",
      extractor = { resource -> listOf(resource.manufacturedDoseForm) },
    )

  public val Identifier: SearchParam<ManufacturedItemDefinition, Identifier> =
    SimpleSearchParam<ManufacturedItemDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ManufacturedItemDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Ingredient: SearchParam<ManufacturedItemDefinition, CodeableConcept> =
    SimpleSearchParam<ManufacturedItemDefinition, CodeableConcept>(
      name = "ingredient",
      type = SearchParamType.fromCode("token"),
      expression = "ManufacturedItemDefinition.ingredient",
      extractor = { resource -> resource.ingredient },
    )

  /** All search parameters for the ManufacturedItemDefinition resource type. */
  public val ALL: List<SearchParam<ManufacturedItemDefinition, *>> =
    listOf(DoseForm, Identifier, Ingredient)
}
