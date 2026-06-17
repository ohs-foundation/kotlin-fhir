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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.CompartmentDefinition
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CompartmentDefinition] resource type. */
public object CompartmentDefinitionSearchParams {
  public val code: SearchParam<CompartmentDefinition, Any> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "CompartmentDefinition.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val context: SearchParam<CompartmentDefinition, Any> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(CompartmentDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'context' has expression '(CompartmentDefinition.useContext.value.ofType(CodeableConcept))' which is not yet supported."
        )
      },
    )

  public val contextQuantity: SearchParam<CompartmentDefinition, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(CompartmentDefinition.useContext.value.ofType(Quantity))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'context-quantity' has expression '(CompartmentDefinition.useContext.value.ofType(Quantity))' which is not yet supported."
        )
      },
    )

  public val contextType: SearchParam<CompartmentDefinition, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "CompartmentDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<CompartmentDefinition, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "CompartmentDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<CompartmentDefinition, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "CompartmentDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<CompartmentDefinition, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "CompartmentDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<CompartmentDefinition, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "CompartmentDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val name: SearchParam<CompartmentDefinition, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "CompartmentDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<CompartmentDefinition, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "CompartmentDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val resource: SearchParam<CompartmentDefinition, Any> =
    SearchParam(
      name = "resource",
      type = SearchParamType.Token,
      expression = "CompartmentDefinition.resource.code",
      extractor = { resource -> resource.resource.map { it.code } },
    )

  public val status: SearchParam<CompartmentDefinition, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "CompartmentDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val url: SearchParam<CompartmentDefinition, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "CompartmentDefinition.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<CompartmentDefinition, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "CompartmentDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<CompartmentDefinition, *>> =
    listOf(context, contextQuantity)

  /**
   * Supported search parameters for the CompartmentDefinition resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<CompartmentDefinition, *>> =
    listOf(
      code,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      name,
      publisher,
      resource,
      status,
      url,
      version,
    )
}
