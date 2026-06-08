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
import dev.ohs.fhir.model.r4b.ExampleScenario
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ExampleScenario] resource type. */
public object ExampleScenarioSearchParams {
  public val context: SearchParam<ExampleScenario, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(ExampleScenario.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<ExampleScenario, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(ExampleScenario.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<ExampleScenario, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "ExampleScenario.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<ExampleScenario, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "ExampleScenario.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<ExampleScenario, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "ExampleScenario.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<ExampleScenario, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "ExampleScenario.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val identifier: SearchParam<ExampleScenario, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ExampleScenario.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<ExampleScenario, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "ExampleScenario.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<ExampleScenario, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "ExampleScenario.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<ExampleScenario, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "ExampleScenario.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<ExampleScenario, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ExampleScenario.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val url: SearchParam<ExampleScenario, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "ExampleScenario.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<ExampleScenario, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "ExampleScenario.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ExampleScenario, *>> = listOf()

  /**
   * Supported search parameters for the ExampleScenario resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ExampleScenario, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      identifier,
      jurisdiction,
      name,
      publisher,
      status,
      url,
      version,
    )
}
