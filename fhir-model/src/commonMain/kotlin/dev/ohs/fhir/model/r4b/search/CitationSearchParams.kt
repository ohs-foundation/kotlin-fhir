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

import dev.ohs.fhir.model.r4b.Citation
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Citation] resource type. */
public object CitationSearchParams {
  public val context: SearchParam<Citation, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(Citation.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<Citation, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(Citation.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<Citation, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "Citation.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<Citation, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "Citation.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<Citation, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "Citation.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<Citation, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "Citation.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<Citation, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "Citation.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val effective: SearchParam<Citation, Period> =
    SearchParam(
      name = "effective",
      type = SearchParamType.Date,
      expression = "Citation.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val identifier: SearchParam<Citation, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Citation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<Citation, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "Citation.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<Citation, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "Citation.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<Citation, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "Citation.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<Citation, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Citation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<Citation, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "Citation.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<Citation, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "Citation.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<Citation, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "Citation.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Citation, *>> = listOf()

  /**
   * Supported search parameters for the Citation resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Citation, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      effective,
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
