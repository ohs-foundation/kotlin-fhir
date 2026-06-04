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
  public val Category: SearchParam<ObservationDefinition, CodeableConcept> =
    SimpleSearchParam<ObservationDefinition, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.category",
      extractor = { resource -> resource.category },
    )

  public val Code: SearchParam<ObservationDefinition, CodeableConcept> =
    SimpleSearchParam<ObservationDefinition, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val Experimental: SearchParam<ObservationDefinition, Boolean> =
    SimpleSearchParam<ObservationDefinition, Boolean>(
      name = "experimental",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.experimental",
      extractor = { resource -> listOfNotNull(resource.experimental) },
    )

  public val Identifier: SearchParam<ObservationDefinition, Identifier> =
    SimpleSearchParam<ObservationDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val Method: SearchParam<ObservationDefinition, CodeableConcept> =
    SimpleSearchParam<ObservationDefinition, CodeableConcept>(
      name = "method",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.method",
      extractor = { resource -> listOfNotNull(resource.method) },
    )

  public val Status: SearchParam<ObservationDefinition, Any> =
    SimpleSearchParam<ObservationDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ObservationDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<ObservationDefinition, String> =
    SimpleSearchParam<ObservationDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ObservationDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<ObservationDefinition, Uri> =
    SimpleSearchParam<ObservationDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ObservationDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  /** All search parameters for the ObservationDefinition resource type. */
  public val ALL: List<SearchParam<ObservationDefinition, *>> =
    listOf(Category, Code, Experimental, Identifier, Method, Status, Title, Url)
}
