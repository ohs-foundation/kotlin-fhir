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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.SearchParameter
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SearchParameter] resource type. */
public object SearchParameterSearchParams {
  public val base: SearchParam<SearchParameter, Any> =
    SearchParam(
      name = "base",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.base",
      extractor = { resource -> resource.base },
    )

  public val code: SearchParam<SearchParameter, Any> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val component: SearchParam<SearchParameter, Canonical> =
    SearchParam(
      name = "component",
      type = SearchParamType.fromCode("reference"),
      expression = "SearchParameter.component.definition",
      target = listOf(SearchParameter::class),
      extractor = { resource -> resource.component.map { it.definition } },
    )

  public val context: SearchParam<SearchParameter, Any> =
    SearchParam(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(SearchParameter.useContext.value.ofType(CodeableConcept))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'context' has expression '(SearchParameter.useContext.value.ofType(CodeableConcept))' which is not yet supported."
        )
      },
    )

  public val contextQuantity: SearchParam<SearchParameter, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(SearchParameter.useContext.value.ofType(Quantity))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'context-quantity' has expression '(SearchParameter.useContext.value.ofType(Quantity))' which is not yet supported."
        )
      },
    )

  public val contextType: SearchParam<SearchParameter, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<SearchParameter, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "SearchParameter.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<SearchParameter, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "SearchParameter.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<SearchParameter, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "SearchParameter.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val derivedFrom: SearchParam<SearchParameter, Canonical> =
    SearchParam(
      name = "derived-from",
      type = SearchParamType.fromCode("reference"),
      expression = "SearchParameter.derivedFrom",
      target = listOf(SearchParameter::class),
      extractor = { resource -> listOfNotNull(resource.derivedFrom) },
    )

  public val description: SearchParam<SearchParameter, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.description",
      extractor = { resource -> listOf(resource.description) },
    )

  public val identifier: SearchParam<SearchParameter, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<SearchParameter, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<SearchParameter, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<SearchParameter, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<SearchParameter, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val target: SearchParam<SearchParameter, Any> =
    SearchParam(
      name = "target",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.target",
      extractor = { resource -> resource.target },
    )

  public val type: SearchParam<SearchParameter, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val url: SearchParam<SearchParameter, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "SearchParameter.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<SearchParameter, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<SearchParameter, *>> = listOf(context, contextQuantity)

  /**
   * Supported search parameters for the SearchParameter resource type. Entries in [unsupported] are
   * excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<SearchParameter, *>> =
    listOf(
      base,
      code,
      component,
      context,
      contextQuantity,
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
      target,
      type,
      url,
      version,
    ) - unsupported.toSet()
}
