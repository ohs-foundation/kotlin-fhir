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
  public val Context: SearchParam<ExampleScenario, Any> =
    SimpleSearchParam<ExampleScenario, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ExampleScenario.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<ExampleScenario, Any> =
    SimpleSearchParam<ExampleScenario, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ExampleScenario.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<ExampleScenario, Coding> =
    SimpleSearchParam<ExampleScenario, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<ExampleScenario, UsageContext> =
    SimpleSearchParam<ExampleScenario, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ExampleScenario.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<ExampleScenario, UsageContext> =
    SimpleSearchParam<ExampleScenario, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ExampleScenario.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<ExampleScenario, DateTime> =
    SimpleSearchParam<ExampleScenario, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ExampleScenario.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Identifier: SearchParam<ExampleScenario, Identifier> =
    SimpleSearchParam<ExampleScenario, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<ExampleScenario, CodeableConcept> =
    SimpleSearchParam<ExampleScenario, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<ExampleScenario, String> =
    SimpleSearchParam<ExampleScenario, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "ExampleScenario.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<ExampleScenario, String> =
    SimpleSearchParam<ExampleScenario, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ExampleScenario.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<ExampleScenario, Any> =
    SimpleSearchParam<ExampleScenario, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Url: SearchParam<ExampleScenario, Uri> =
    SimpleSearchParam<ExampleScenario, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ExampleScenario.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<ExampleScenario, String> =
    SimpleSearchParam<ExampleScenario, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ExampleScenario.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ExampleScenario resource type. */
  public val ALL: List<SearchParam<ExampleScenario, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Status,
      Url,
      Version,
    )
}
