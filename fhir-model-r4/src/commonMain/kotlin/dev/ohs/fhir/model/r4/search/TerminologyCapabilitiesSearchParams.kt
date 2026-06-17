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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.TerminologyCapabilities
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TerminologyCapabilities] resource type. */
public object TerminologyCapabilitiesSearchParams {
  public val context: SearchParam<TerminologyCapabilities, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(TerminologyCapabilities.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<TerminologyCapabilities, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(TerminologyCapabilities.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<TerminologyCapabilities, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "TerminologyCapabilities.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<TerminologyCapabilities, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "TerminologyCapabilities.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<TerminologyCapabilities, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "TerminologyCapabilities.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<TerminologyCapabilities, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "TerminologyCapabilities.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<TerminologyCapabilities, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "TerminologyCapabilities.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val jurisdiction: SearchParam<TerminologyCapabilities, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "TerminologyCapabilities.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<TerminologyCapabilities, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "TerminologyCapabilities.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<TerminologyCapabilities, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "TerminologyCapabilities.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<TerminologyCapabilities, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "TerminologyCapabilities.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<TerminologyCapabilities, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "TerminologyCapabilities.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<TerminologyCapabilities, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "TerminologyCapabilities.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<TerminologyCapabilities, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "TerminologyCapabilities.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<TerminologyCapabilities, *>> = listOf()

  /**
   * Supported search parameters for the TerminologyCapabilities resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<TerminologyCapabilities, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      jurisdiction,
      name,
      publisher,
      status,
      title,
      url,
      version,
    )
}
