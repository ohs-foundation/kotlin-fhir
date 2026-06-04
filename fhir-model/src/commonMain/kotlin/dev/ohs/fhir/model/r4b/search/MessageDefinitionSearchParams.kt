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

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.MessageDefinition
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MessageDefinition] resource type. */
public object MessageDefinitionSearchParams {
  public val category: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val context: SearchParam<MessageDefinition, CodeableConcept> =
    SimpleSearchParam<MessageDefinition, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(MessageDefinition.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<MessageDefinition, Quantity> =
    SimpleSearchParam<MessageDefinition, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(MessageDefinition.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<MessageDefinition, Coding> =
    SimpleSearchParam<MessageDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<MessageDefinition, UsageContext> =
    SimpleSearchParam<MessageDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "MessageDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<MessageDefinition, UsageContext> =
    SimpleSearchParam<MessageDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "MessageDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<MessageDefinition, DateTime> =
    SimpleSearchParam<MessageDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "MessageDefinition.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<MessageDefinition, Markdown> =
    SimpleSearchParam<MessageDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val event: SearchParam<MessageDefinition, MessageDefinition.Event> =
    SimpleSearchParam<MessageDefinition, MessageDefinition.Event>(
      name = "event",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.event",
      extractor = { resource -> listOf(resource.event) },
    )

  public val focus: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "focus",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.focus.code",
      extractor = { resource -> resource.focus.map { it.code } },
    )

  public val identifier: SearchParam<MessageDefinition, Identifier> =
    SimpleSearchParam<MessageDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<MessageDefinition, CodeableConcept> =
    SimpleSearchParam<MessageDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<MessageDefinition, String> =
    SimpleSearchParam<MessageDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val parent: SearchParam<MessageDefinition, Canonical> =
    SimpleSearchParam<MessageDefinition, Canonical>(
      name = "parent",
      type = SearchParamType.fromCode("reference"),
      expression = "MessageDefinition.parent",
      target = listOf(PlanDefinition::class, ActivityDefinition::class),
      extractor = { resource -> resource.parent },
    )

  public val publisher: SearchParam<MessageDefinition, String> =
    SimpleSearchParam<MessageDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<MessageDefinition, String> =
    SimpleSearchParam<MessageDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<MessageDefinition, Uri> =
    SimpleSearchParam<MessageDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "MessageDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<MessageDefinition, String> =
    SimpleSearchParam<MessageDefinition, String>(
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
