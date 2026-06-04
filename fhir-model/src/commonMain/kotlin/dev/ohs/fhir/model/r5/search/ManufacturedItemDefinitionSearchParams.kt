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
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ManufacturedItemDefinition] resource type. */
public object ManufacturedItemDefinitionSearchParams {
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

  public val Name: SearchParam<ManufacturedItemDefinition, String> =
    SimpleSearchParam<ManufacturedItemDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("token"),
      expression = "ManufacturedItemDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Status: SearchParam<ManufacturedItemDefinition, Any> =
    SimpleSearchParam<ManufacturedItemDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ManufacturedItemDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the ManufacturedItemDefinition resource type. */
  public val ALL: List<SearchParam<ManufacturedItemDefinition, *>> =
    listOf(DoseForm, Identifier, Ingredient, Name, Status)
}
