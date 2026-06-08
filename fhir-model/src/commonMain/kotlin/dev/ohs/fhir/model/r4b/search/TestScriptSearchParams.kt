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
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(TestScript.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<TestScript, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(TestScript.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<TestScript, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "TestScript.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<TestScript, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "TestScript.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<TestScript, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "TestScript.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<TestScript, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "TestScript.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<TestScript, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "TestScript.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<TestScript, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "TestScript.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val jurisdiction: SearchParam<TestScript, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "TestScript.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<TestScript, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "TestScript.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<TestScript, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "TestScript.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<TestScript, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "TestScript.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val testscriptCapability: SearchParam<TestScript, String> =
    SearchParam(
      name = "testscript-capability",
      type = SearchParamType.String,
      expression = "TestScript.metadata.capability.description",
      extractor = { resource ->
        (resource.metadata?.capability ?: emptyList()).mapNotNull { it.description }
      },
    )

  public val title: SearchParam<TestScript, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "TestScript.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<TestScript, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "TestScript.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<TestScript, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "TestScript.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<TestScript, *>> = listOf()

  /**
   * Supported search parameters for the TestScript resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
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
