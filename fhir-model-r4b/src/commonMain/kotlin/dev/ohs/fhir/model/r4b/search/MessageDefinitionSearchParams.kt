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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

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
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "MessageDefinition.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val context: SearchParam<MessageDefinition, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(MessageDefinition.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<MessageDefinition, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(MessageDefinition.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<MessageDefinition, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "MessageDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<MessageDefinition, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "MessageDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<MessageDefinition, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "MessageDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<MessageDefinition, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "MessageDefinition.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<MessageDefinition, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "MessageDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val event: SearchParam<MessageDefinition, MessageDefinition.Event> =
    SearchParam(
      name = "event",
      type = SearchParamType.Token,
      expression = "MessageDefinition.event",
      extractor = { resource -> listOf(resource.event) },
    )

  public val focus: SearchParam<MessageDefinition, Any> =
    SearchParam(
      name = "focus",
      type = SearchParamType.Token,
      expression = "MessageDefinition.focus.code",
      extractor = { resource -> resource.focus.map { it.code } },
    )

  public val identifier: SearchParam<MessageDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "MessageDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<MessageDefinition, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "MessageDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<MessageDefinition, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "MessageDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val parent: SearchParam<MessageDefinition, Canonical> =
    SearchParam(
      name = "parent",
      type = SearchParamType.Reference,
      expression = "MessageDefinition.parent",
      target = listOf(PlanDefinition::class, ActivityDefinition::class),
      extractor = { resource -> resource.parent },
    )

  public val publisher: SearchParam<MessageDefinition, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "MessageDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<MessageDefinition, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "MessageDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<MessageDefinition, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "MessageDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<MessageDefinition, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "MessageDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<MessageDefinition, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "MessageDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<MessageDefinition, *>> = listOf()

  /**
   * Supported search parameters for the MessageDefinition resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
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
