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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.TestScript
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TestScript] resource type. */
public object TestScriptSearchParams {
  public val context: SearchParam<TestScript, CodeableConcept> =
    SearchParam<TestScript, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(TestScript.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<TestScript, Quantity> =
    SearchParam<TestScript, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(TestScript.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<TestScript, Coding> =
    SearchParam<TestScript, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "TestScript.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<TestScript, UsageContext> =
    SearchParam<TestScript, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "TestScript.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<TestScript, UsageContext> =
    SearchParam<TestScript, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "TestScript.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<TestScript, DateTime> =
    SearchParam<TestScript, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "TestScript.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<TestScript, Markdown> =
    SearchParam<TestScript, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "TestScript.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<TestScript, Identifier> =
    SearchParam<TestScript, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "TestScript.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val jurisdiction: SearchParam<TestScript, CodeableConcept> =
    SearchParam<TestScript, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "TestScript.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<TestScript, String> =
    SearchParam<TestScript, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "TestScript.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<TestScript, String> =
    SearchParam<TestScript, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "TestScript.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<TestScript, Any> =
    SearchParam<TestScript, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "TestScript.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val testscriptCapability: SearchParam<TestScript, String> =
    SearchParam<TestScript, String>(
      name = "testscript-capability",
      type = SearchParamType.fromCode("string"),
      expression = "TestScript.metadata.capability.description",
      extractor = { resource ->
        (resource.metadata?.capability ?: emptyList()).mapNotNull { it.description }
      },
    )

  public val title: SearchParam<TestScript, String> =
    SearchParam<TestScript, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "TestScript.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<TestScript, Uri> =
    SearchParam<TestScript, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "TestScript.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<TestScript, String> =
    SearchParam<TestScript, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "TestScript.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the TestScript resource type. */
  public val all: List<SearchParam<TestScript, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      identifier,
      jurisdiction,
      name,
      publisher,
      status,
      testscriptCapability,
      title,
      url,
      version,
    )
}
