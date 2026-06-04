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

import dev.ohs.fhir.model.r5.ActorDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ActorDefinition] resource type. */
public object ActorDefinitionSearchParams {
  public val context: SearchParam<ActorDefinition, Any> =
    SimpleSearchParam<ActorDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ActorDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<ActorDefinition, Any> =
    SimpleSearchParam<ActorDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ActorDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<ActorDefinition, Coding> =
    SimpleSearchParam<ActorDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<ActorDefinition, UsageContext> =
    SimpleSearchParam<ActorDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ActorDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<ActorDefinition, UsageContext> =
    SimpleSearchParam<ActorDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ActorDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<ActorDefinition, DateTime> =
    SimpleSearchParam<ActorDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ActorDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<ActorDefinition, Markdown> =
    SimpleSearchParam<ActorDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ActorDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<ActorDefinition, Identifier> =
    SimpleSearchParam<ActorDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<ActorDefinition, CodeableConcept> =
    SimpleSearchParam<ActorDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val publisher: SearchParam<ActorDefinition, String> =
    SimpleSearchParam<ActorDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ActorDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<ActorDefinition, Any> =
    SimpleSearchParam<ActorDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<ActorDefinition, String> =
    SimpleSearchParam<ActorDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ActorDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val type: SearchParam<ActorDefinition, Any> =
    SimpleSearchParam<ActorDefinition, Any>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val url: SearchParam<ActorDefinition, Uri> =
    SimpleSearchParam<ActorDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ActorDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<ActorDefinition, String> =
    SimpleSearchParam<ActorDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ActorDefinition resource type. */
  public val all: List<SearchParam<ActorDefinition, *>> =
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
      publisher,
      status,
      title,
      type,
      url,
      version,
    )
}
