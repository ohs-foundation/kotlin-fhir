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
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.TerminologyCapabilities
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TerminologyCapabilities] resource type. */
public object TerminologyCapabilitiesSearchParams {
  public val context: SearchParam<TerminologyCapabilities, CodeableConcept> =
    SearchParam<TerminologyCapabilities, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(TerminologyCapabilities.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<TerminologyCapabilities, Quantity> =
    SearchParam<TerminologyCapabilities, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(TerminologyCapabilities.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<TerminologyCapabilities, Coding> =
    SearchParam<TerminologyCapabilities, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<TerminologyCapabilities, UsageContext> =
    SearchParam<TerminologyCapabilities, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "TerminologyCapabilities.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<TerminologyCapabilities, UsageContext> =
    SearchParam<TerminologyCapabilities, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "TerminologyCapabilities.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<TerminologyCapabilities, DateTime> =
    SearchParam<TerminologyCapabilities, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "TerminologyCapabilities.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<TerminologyCapabilities, Markdown> =
    SearchParam<TerminologyCapabilities, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val jurisdiction: SearchParam<TerminologyCapabilities, CodeableConcept> =
    SearchParam<TerminologyCapabilities, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<TerminologyCapabilities, String> =
    SearchParam<TerminologyCapabilities, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<TerminologyCapabilities, String> =
    SearchParam<TerminologyCapabilities, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<TerminologyCapabilities, Any> =
    SearchParam<TerminologyCapabilities, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<TerminologyCapabilities, String> =
    SearchParam<TerminologyCapabilities, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<TerminologyCapabilities, Uri> =
    SearchParam<TerminologyCapabilities, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "TerminologyCapabilities.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<TerminologyCapabilities, String> =
    SearchParam<TerminologyCapabilities, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the TerminologyCapabilities resource type. */
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
