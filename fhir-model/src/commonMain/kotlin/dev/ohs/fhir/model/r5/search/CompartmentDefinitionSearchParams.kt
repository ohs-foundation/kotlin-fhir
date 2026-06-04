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

import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.CompartmentDefinition
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CompartmentDefinition] resource type. */
public object CompartmentDefinitionSearchParams {
  public val code: SearchParam<CompartmentDefinition, Any> =
    SearchParam<CompartmentDefinition, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val context: SearchParam<CompartmentDefinition, Any> =
    SearchParam<CompartmentDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(CompartmentDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<CompartmentDefinition, Any> =
    SearchParam<CompartmentDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(CompartmentDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<CompartmentDefinition, Coding> =
    SearchParam<CompartmentDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<CompartmentDefinition, UsageContext> =
    SearchParam<CompartmentDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "CompartmentDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<CompartmentDefinition, UsageContext> =
    SearchParam<CompartmentDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "CompartmentDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<CompartmentDefinition, DateTime> =
    SearchParam<CompartmentDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CompartmentDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<CompartmentDefinition, Markdown> =
    SearchParam<CompartmentDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "CompartmentDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val name: SearchParam<CompartmentDefinition, String> =
    SearchParam<CompartmentDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "CompartmentDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<CompartmentDefinition, String> =
    SearchParam<CompartmentDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "CompartmentDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val resource: SearchParam<CompartmentDefinition, Any> =
    SearchParam<CompartmentDefinition, Any>(
      name = "resource",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.resource.code",
      extractor = { resource -> resource.resource.map { it.code } },
    )

  public val status: SearchParam<CompartmentDefinition, Any> =
    SearchParam<CompartmentDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val url: SearchParam<CompartmentDefinition, Uri> =
    SearchParam<CompartmentDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "CompartmentDefinition.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<CompartmentDefinition, String> =
    SearchParam<CompartmentDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the CompartmentDefinition resource type. */
  public val all: List<SearchParam<CompartmentDefinition, *>> =
    listOf(
      code,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      name,
      publisher,
      resource,
      status,
      url,
      version,
    )
}
