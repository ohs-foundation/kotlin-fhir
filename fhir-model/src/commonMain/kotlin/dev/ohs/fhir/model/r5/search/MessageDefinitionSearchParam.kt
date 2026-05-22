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
public object MessageDefinitionSearchParam {
  public val Category: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val Context: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(MessageDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(MessageDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<MessageDefinition, Coding> =
    SimpleSearchParam<MessageDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<MessageDefinition, UsageContext> =
    SimpleSearchParam<MessageDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "MessageDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<MessageDefinition, UsageContext> =
    SimpleSearchParam<MessageDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "MessageDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<MessageDefinition, DateTime> =
    SimpleSearchParam<MessageDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "MessageDefinition.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val Description: SearchParam<MessageDefinition, Markdown> =
    SimpleSearchParam<MessageDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Event: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "event",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.event.ofType(Coding)",
      extractor = { emptyList() },
    )

  public val Focus: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "focus",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.focus.code",
      extractor = { resource -> resource.focus.map { it.code } },
    )

  public val Identifier: SearchParam<MessageDefinition, Identifier> =
    SimpleSearchParam<MessageDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<MessageDefinition, CodeableConcept> =
    SimpleSearchParam<MessageDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<MessageDefinition, String> =
    SimpleSearchParam<MessageDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Parent: SearchParam<MessageDefinition, Canonical> =
    SimpleSearchParam<MessageDefinition, Canonical>(
      name = "parent",
      type = SearchParamType.fromCode("reference"),
      expression = "MessageDefinition.parent",
      target = listOf(ActivityDefinition::class, PlanDefinition::class),
      extractor = { resource -> resource.parent },
    )

  public val Publisher: SearchParam<MessageDefinition, String> =
    SimpleSearchParam<MessageDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<MessageDefinition, Any> =
    SimpleSearchParam<MessageDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<MessageDefinition, String> =
    SimpleSearchParam<MessageDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "MessageDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<MessageDefinition, Uri> =
    SimpleSearchParam<MessageDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "MessageDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<MessageDefinition, String> =
    SimpleSearchParam<MessageDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "MessageDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the MessageDefinition resource type. */
  public val ALL: List<SearchParam<MessageDefinition, *>> =
    listOf(
      Category,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Event,
      Focus,
      Identifier,
      Jurisdiction,
      Name,
      Parent,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )
}
