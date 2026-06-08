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
import dev.ohs.fhir.model.r5.ObservationDefinition
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ObservationDefinition] resource type. */
public object ObservationDefinitionSearchParams {
  public val category: SearchParam<ObservationDefinition, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<ObservationDefinition, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val experimental: SearchParam<ObservationDefinition, Boolean> =
    SearchParam(
      name = "experimental",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.experimental",
      extractor = { resource -> listOfNotNull(resource.experimental) },
    )

  public val identifier: SearchParam<ObservationDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val method: SearchParam<ObservationDefinition, CodeableConcept> =
    SearchParam(
      name = "method",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.method",
      extractor = { resource -> listOfNotNull(resource.method) },
    )

  public val status: SearchParam<ObservationDefinition, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<ObservationDefinition, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ObservationDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<ObservationDefinition, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ObservationDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ObservationDefinition, *>> = listOf()

  /**
   * Supported search parameters for the ObservationDefinition resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<ObservationDefinition, *>> =
    listOf(category, code, experimental, identifier, method, status, title, url)
}
