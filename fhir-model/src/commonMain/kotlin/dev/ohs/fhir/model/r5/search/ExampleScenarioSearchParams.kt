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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.ExampleScenario
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ExampleScenario] resource type. */
public object ExampleScenarioSearchParams {
  public val context: SearchParam<ExampleScenario, Any> =
    SearchParam<ExampleScenario, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ExampleScenario.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<ExampleScenario, Any> =
    SearchParam<ExampleScenario, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ExampleScenario.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<ExampleScenario, Coding> =
    SearchParam<ExampleScenario, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<ExampleScenario, UsageContext> =
    SearchParam<ExampleScenario, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ExampleScenario.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<ExampleScenario, UsageContext> =
    SearchParam<ExampleScenario, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ExampleScenario.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<ExampleScenario, DateTime> =
    SearchParam<ExampleScenario, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ExampleScenario.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val identifier: SearchParam<ExampleScenario, Identifier> =
    SearchParam<ExampleScenario, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<ExampleScenario, CodeableConcept> =
    SearchParam<ExampleScenario, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<ExampleScenario, String> =
    SearchParam<ExampleScenario, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "ExampleScenario.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<ExampleScenario, String> =
    SearchParam<ExampleScenario, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ExampleScenario.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<ExampleScenario, Any> =
    SearchParam<ExampleScenario, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val url: SearchParam<ExampleScenario, Uri> =
    SearchParam<ExampleScenario, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ExampleScenario.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<ExampleScenario, String> =
    SearchParam<ExampleScenario, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ExampleScenario resource type. */
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
