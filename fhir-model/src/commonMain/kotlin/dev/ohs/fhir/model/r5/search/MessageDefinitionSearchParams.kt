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

import dev.ohs.fhir.model.r5.ActivityDefinition
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MessageDefinition
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MessageDefinition] resource type. */
public object MessageDefinitionSearchParams {
  public val category: SearchParam<MessageDefinition, Any> =
    SearchParam<MessageDefinition, Any>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val context: SearchParam<MessageDefinition, Any> =
    SearchParam<MessageDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(MessageDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<MessageDefinition, Any> =
    SearchParam<MessageDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(MessageDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<MessageDefinition, Coding> =
    SearchParam<MessageDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<MessageDefinition, UsageContext> =
    SearchParam<MessageDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "MessageDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<MessageDefinition, UsageContext> =
    SearchParam<MessageDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "MessageDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<MessageDefinition, DateTime> =
    SearchParam<MessageDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "MessageDefinition.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<MessageDefinition, Markdown> =
    SearchParam<MessageDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val event: SearchParam<MessageDefinition, Any> =
    SearchParam<MessageDefinition, Any>(
      name = "event",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.event.ofType(Coding)",
      extractor = { emptyList() },
    )

  public val focus: SearchParam<MessageDefinition, Any> =
    SearchParam<MessageDefinition, Any>(
      name = "focus",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.focus.code",
      extractor = { resource -> resource.focus.map { it.code } },
    )

  public val identifier: SearchParam<MessageDefinition, Identifier> =
    SearchParam<MessageDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<MessageDefinition, CodeableConcept> =
    SearchParam<MessageDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<MessageDefinition, String> =
    SearchParam<MessageDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val parent: SearchParam<MessageDefinition, Canonical> =
    SearchParam<MessageDefinition, Canonical>(
      name = "parent",
      type = SearchParamType.fromCode("reference"),
      expression = "MessageDefinition.parent",
      target = listOf(ActivityDefinition::class, PlanDefinition::class),
      extractor = { resource -> resource.parent },
    )

  public val publisher: SearchParam<MessageDefinition, String> =
    SearchParam<MessageDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<MessageDefinition, Any> =
    SearchParam<MessageDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<MessageDefinition, String> =
    SearchParam<MessageDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<MessageDefinition, Uri> =
    SearchParam<MessageDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "MessageDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<MessageDefinition, String> =
    SearchParam<MessageDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the MessageDefinition resource type. */
  public val all: List<SearchParam<MessageDefinition, *>> =
    listOf(
      category,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      event,
      focus,
      identifier,
      jurisdiction,
      name,
      parent,
      publisher,
      status,
      title,
      url,
      version,
    )
}
