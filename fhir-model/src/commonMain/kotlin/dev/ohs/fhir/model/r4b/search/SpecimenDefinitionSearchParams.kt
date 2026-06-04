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
import dev.ohs.fhir.model.r4b.SpecimenDefinition
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SpecimenDefinition] resource type. */
public object SpecimenDefinitionSearchParams {
  public val container: SearchParam<SpecimenDefinition, CodeableConcept> =
    SearchParam(
      name = "container",
      type = SearchParamType.fromCode("token"),
      expression = "SpecimenDefinition.typeTested.container.type",
      extractor = { resource ->
        resource.typeTested.mapNotNull { it.container }.mapNotNull { it.type }
      },
    )

  public val identifier: SearchParam<SpecimenDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SpecimenDefinition.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val type: SearchParam<SpecimenDefinition, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "SpecimenDefinition.typeCollected",
      extractor = { resource -> listOfNotNull(resource.typeCollected) },
    )

  /** All search parameters for the SpecimenDefinition resource type. */
  public val all: List<SearchParam<SpecimenDefinition, *>> = listOf(container, identifier, type)
}
