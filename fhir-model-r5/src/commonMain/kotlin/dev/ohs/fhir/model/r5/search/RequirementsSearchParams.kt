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
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Requirements] resource type. */
public object RequirementsSearchParams {
  public val actor: SearchParam<Requirements, Canonical> =
    SearchParam(
      name = "actor",
      type = SearchParamType.Reference,
      expression = "Requirements.actor",
      target = listOf(ActorDefinition::class),
      extractor = { resource -> resource.actor },
    )

  public val context: SearchParam<Requirements, Any> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(Requirements.useContext.value.ofType(CodeableConcept))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'context' has expression '(Requirements.useContext.value.ofType(CodeableConcept))' which is not yet supported."
        )
      },
    )

  public val contextQuantity: SearchParam<Requirements, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(Requirements.useContext.value.ofType(Quantity))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'context-quantity' has expression '(Requirements.useContext.value.ofType(Quantity))' which is not yet supported."
        )
      },
    )

  public val contextType: SearchParam<Requirements, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "Requirements.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<Requirements, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "Requirements.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<Requirements, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "Requirements.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<Requirements, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "Requirements.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val derivedFrom: SearchParam<Requirements, Canonical> =
    SearchParam(
      name = "derived-from",
      type = SearchParamType.Reference,
      expression = "Requirements.derivedFrom",
      target = listOf(Requirements::class),
      extractor = { resource -> resource.derivedFrom },
    )

  public val description: SearchParam<Requirements, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "Requirements.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<Requirements, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Requirements.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<Requirements, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "Requirements.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<Requirements, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "Requirements.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<Requirements, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "Requirements.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<Requirements, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Requirements.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<Requirements, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "Requirements.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<Requirements, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "Requirements.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<Requirements, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "Requirements.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Requirements, *>> = listOf(context, contextQuantity)

  /**
   * Supported search parameters for the Requirements resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Requirements, *>> =
    listOf(
      actor,
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
