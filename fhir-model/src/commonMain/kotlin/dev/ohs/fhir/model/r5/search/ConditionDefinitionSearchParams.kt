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
import dev.ohs.fhir.model.r5.ConditionDefinition
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

/** Search parameters for the [ConditionDefinition] resource type. */
public object ConditionDefinitionSearchParams {
  public val context: SearchParam<ConditionDefinition, Any> =
    SimpleSearchParam<ConditionDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ConditionDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<ConditionDefinition, Any> =
    SimpleSearchParam<ConditionDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ConditionDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<ConditionDefinition, Coding> =
    SimpleSearchParam<ConditionDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ConditionDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<ConditionDefinition, UsageContext> =
    SimpleSearchParam<ConditionDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ConditionDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<ConditionDefinition, UsageContext> =
    SimpleSearchParam<ConditionDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ConditionDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<ConditionDefinition, DateTime> =
    SimpleSearchParam<ConditionDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ConditionDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<ConditionDefinition, Markdown> =
    SimpleSearchParam<ConditionDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ConditionDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<ConditionDefinition, Identifier> =
    SimpleSearchParam<ConditionDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ConditionDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<ConditionDefinition, CodeableConcept> =
    SimpleSearchParam<ConditionDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ConditionDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<ConditionDefinition, String> =
    SimpleSearchParam<ConditionDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "ConditionDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<ConditionDefinition, String> =
    SimpleSearchParam<ConditionDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ConditionDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<ConditionDefinition, Any> =
    SimpleSearchParam<ConditionDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ConditionDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<ConditionDefinition, String> =
    SimpleSearchParam<ConditionDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ConditionDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<ConditionDefinition, Uri> =
    SimpleSearchParam<ConditionDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ConditionDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<ConditionDefinition, String> =
    SimpleSearchParam<ConditionDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ConditionDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ConditionDefinition resource type. */
  public val all: List<SearchParam<ConditionDefinition, *>> =
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
      status,
      title,
      url,
      version,
    )
}
