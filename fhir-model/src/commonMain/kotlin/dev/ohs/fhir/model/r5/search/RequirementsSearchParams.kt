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
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Requirements
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Requirements] resource type. */
public object RequirementsSearchParams {
  public val actor: SearchParam<Requirements, Canonical> =
    SimpleSearchParam<Requirements, Canonical>(
      name = "actor",
      type = SearchParamType.fromCode("reference"),
      expression = "Requirements.actor",
      target = listOf(ActorDefinition::class),
      extractor = { resource -> resource.actor },
    )

  public val context: SearchParam<Requirements, Any> =
    SimpleSearchParam<Requirements, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(Requirements.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<Requirements, Any> =
    SimpleSearchParam<Requirements, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Requirements.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<Requirements, Coding> =
    SimpleSearchParam<Requirements, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<Requirements, UsageContext> =
    SimpleSearchParam<Requirements, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Requirements.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<Requirements, UsageContext> =
    SimpleSearchParam<Requirements, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Requirements.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<Requirements, DateTime> =
    SimpleSearchParam<Requirements, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Requirements.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val derivedFrom: SearchParam<Requirements, Canonical> =
    SimpleSearchParam<Requirements, Canonical>(
      name = "derived-from",
      type = SearchParamType.fromCode("reference"),
      expression = "Requirements.derivedFrom",
      target = listOf(Requirements::class),
      extractor = { resource -> resource.derivedFrom },
    )

  public val description: SearchParam<Requirements, Markdown> =
    SimpleSearchParam<Requirements, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "Requirements.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<Requirements, Identifier> =
    SimpleSearchParam<Requirements, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<Requirements, CodeableConcept> =
    SimpleSearchParam<Requirements, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<Requirements, String> =
    SimpleSearchParam<Requirements, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Requirements.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<Requirements, String> =
    SimpleSearchParam<Requirements, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "Requirements.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<Requirements, Any> =
    SimpleSearchParam<Requirements, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<Requirements, String> =
    SimpleSearchParam<Requirements, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "Requirements.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<Requirements, Uri> =
    SimpleSearchParam<Requirements, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Requirements.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<Requirements, String> =
    SimpleSearchParam<Requirements, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the Requirements resource type. */
  public val all: List<SearchParam<Requirements, *>> =
    listOf(
      actor,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      derivedFrom,
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
