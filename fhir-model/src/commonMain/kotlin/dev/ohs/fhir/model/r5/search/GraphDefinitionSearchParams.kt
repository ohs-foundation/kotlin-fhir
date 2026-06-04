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
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.GraphDefinition
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [GraphDefinition] resource type. */
public object GraphDefinitionSearchParams {
  public val context: SearchParam<GraphDefinition, Any> =
    SearchParam<GraphDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(GraphDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<GraphDefinition, Any> =
    SearchParam<GraphDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(GraphDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<GraphDefinition, Coding> =
    SearchParam<GraphDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<GraphDefinition, UsageContext> =
    SearchParam<GraphDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "GraphDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<GraphDefinition, UsageContext> =
    SearchParam<GraphDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "GraphDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<GraphDefinition, DateTime> =
    SearchParam<GraphDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "GraphDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<GraphDefinition, Markdown> =
    SearchParam<GraphDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "GraphDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<GraphDefinition, Identifier> =
    SearchParam<GraphDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<GraphDefinition, CodeableConcept> =
    SearchParam<GraphDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<GraphDefinition, String> =
    SearchParam<GraphDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "GraphDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<GraphDefinition, String> =
    SearchParam<GraphDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "GraphDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val start: SearchParam<GraphDefinition, Id> =
    SearchParam<GraphDefinition, Id>(
      name = "start",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.start",
      extractor = { resource -> listOfNotNull(resource.start) },
    )

  public val status: SearchParam<GraphDefinition, Any> =
    SearchParam<GraphDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val url: SearchParam<GraphDefinition, Uri> =
    SearchParam<GraphDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "GraphDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<GraphDefinition, String> =
    SearchParam<GraphDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the GraphDefinition resource type. */
  public val all: List<SearchParam<GraphDefinition, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      identifier,
      jurisdiction,
      name,
      publisher,
      start,
      status,
      url,
      version,
    )
}
