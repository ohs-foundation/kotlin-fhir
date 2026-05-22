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
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.GraphDefinition
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [GraphDefinition] resource type. */
public object GraphDefinitionSearchParam {
  public val Context: SearchParam<GraphDefinition, CodeableConcept> =
    SimpleSearchParam<GraphDefinition, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(GraphDefinition.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
      },
    )

  public val ContextQuantity: SearchParam<GraphDefinition, Quantity> =
    SimpleSearchParam<GraphDefinition, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(GraphDefinition.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<GraphDefinition, Coding> =
    SimpleSearchParam<GraphDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<GraphDefinition, UsageContext> =
    SimpleSearchParam<GraphDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "GraphDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<GraphDefinition, UsageContext> =
    SimpleSearchParam<GraphDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "GraphDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<GraphDefinition, DateTime> =
    SimpleSearchParam<GraphDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "GraphDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<GraphDefinition, Markdown> =
    SimpleSearchParam<GraphDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "GraphDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Jurisdiction: SearchParam<GraphDefinition, CodeableConcept> =
    SimpleSearchParam<GraphDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<GraphDefinition, String> =
    SimpleSearchParam<GraphDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "GraphDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val Publisher: SearchParam<GraphDefinition, String> =
    SimpleSearchParam<GraphDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "GraphDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Start: SearchParam<GraphDefinition, Any> =
    SimpleSearchParam<GraphDefinition, Any>(
      name = "start",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.start",
      extractor = { resource -> listOf(resource.start) },
    )

  public val Status: SearchParam<GraphDefinition, Any> =
    SimpleSearchParam<GraphDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Url: SearchParam<GraphDefinition, Uri> =
    SimpleSearchParam<GraphDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "GraphDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<GraphDefinition, String> =
    SimpleSearchParam<GraphDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "GraphDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the GraphDefinition resource type. */
  public val ALL: List<SearchParam<GraphDefinition, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Jurisdiction,
      Name,
      Publisher,
      Start,
      Status,
      Url,
      Version,
    )
}
