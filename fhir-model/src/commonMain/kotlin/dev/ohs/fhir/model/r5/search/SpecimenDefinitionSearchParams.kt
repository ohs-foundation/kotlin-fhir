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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.SpecimenDefinition
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SpecimenDefinition] resource type. */
public object SpecimenDefinitionSearchParams {
  public val container: SearchParam<SpecimenDefinition, CodeableConcept> =
    SearchParam(
      name = "container",
      type = SearchParamType.Token,
      expression = "SpecimenDefinition.typeTested.container.type",
      extractor = { resource ->
        resource.typeTested.mapNotNull { it.container }.mapNotNull { it.type }
      },
    )

  public val experimental: SearchParam<SpecimenDefinition, Boolean> =
    SearchParam(
      name = "experimental",
      type = SearchParamType.Token,
      expression = "SpecimenDefinition.experimental",
      extractor = { resource -> listOfNotNull(resource.experimental) },
    )

  public val identifier: SearchParam<SpecimenDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "SpecimenDefinition.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val isDerived: SearchParam<SpecimenDefinition, Boolean> =
    SearchParam(
      name = "is-derived",
      type = SearchParamType.Token,
      expression = "SpecimenDefinition.typeTested.isDerived",
      extractor = { resource -> resource.typeTested.mapNotNull { it.isDerived } },
    )

  public val status: SearchParam<SpecimenDefinition, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "SpecimenDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<SpecimenDefinition, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "SpecimenDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val type: SearchParam<SpecimenDefinition, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "SpecimenDefinition.typeCollected",
      extractor = { resource -> listOfNotNull(resource.typeCollected) },
    )

  public val typeTested: SearchParam<SpecimenDefinition, CodeableConcept> =
    SearchParam(
      name = "type-tested",
      type = SearchParamType.Token,
      expression = "SpecimenDefinition.typeTested.type",
      extractor = { resource -> resource.typeTested.mapNotNull { it.type } },
    )

  public val url: SearchParam<SpecimenDefinition, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "SpecimenDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<SpecimenDefinition, *>> = listOf()

  /**
   * Supported search parameters for the SpecimenDefinition resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<SpecimenDefinition, *>> =
    listOf(container, experimental, identifier, isDerived, status, title, type, typeTested, url)
}
