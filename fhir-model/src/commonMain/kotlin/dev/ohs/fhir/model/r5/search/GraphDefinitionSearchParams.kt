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
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [GraphDefinition] resource type. */
public object GraphDefinitionSearchParams {
  public val context: SearchParam<GraphDefinition, Any> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(GraphDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'context' has expression '(GraphDefinition.useContext.value.ofType(CodeableConcept))' which is not yet supported."
        )
      },
    )

  public val contextQuantity: SearchParam<GraphDefinition, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(GraphDefinition.useContext.value.ofType(Quantity))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'context-quantity' has expression '(GraphDefinition.useContext.value.ofType(Quantity))' which is not yet supported."
        )
      },
    )

  public val contextType: SearchParam<GraphDefinition, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "GraphDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<GraphDefinition, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "GraphDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<GraphDefinition, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "GraphDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<GraphDefinition, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "GraphDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<GraphDefinition, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "GraphDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<GraphDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "GraphDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<GraphDefinition, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "GraphDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<GraphDefinition, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "GraphDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<GraphDefinition, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "GraphDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val start: SearchParam<GraphDefinition, Id> =
    SearchParam(
      name = "start",
      type = SearchParamType.Token,
      expression = "GraphDefinition.start",
      extractor = { resource -> listOfNotNull(resource.start) },
    )

  public val status: SearchParam<GraphDefinition, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "GraphDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val url: SearchParam<GraphDefinition, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "GraphDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<GraphDefinition, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "GraphDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<GraphDefinition, *>> = listOf(context, contextQuantity)

  /**
   * Supported search parameters for the GraphDefinition resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<GraphDefinition, *>> =
    listOf(
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
