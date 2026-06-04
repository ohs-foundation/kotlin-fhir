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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.TerminologyCapabilities
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TerminologyCapabilities] resource type. */
public object TerminologyCapabilitiesSearchParams {
  public val context: SearchParam<TerminologyCapabilities, Any> =
    SearchParam(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(TerminologyCapabilities.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<TerminologyCapabilities, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(TerminologyCapabilities.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<TerminologyCapabilities, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<TerminologyCapabilities, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "TerminologyCapabilities.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<TerminologyCapabilities, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "TerminologyCapabilities.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<TerminologyCapabilities, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "TerminologyCapabilities.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<TerminologyCapabilities, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<TerminologyCapabilities, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<TerminologyCapabilities, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<TerminologyCapabilities, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<TerminologyCapabilities, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<TerminologyCapabilities, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<TerminologyCapabilities, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<TerminologyCapabilities, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "TerminologyCapabilities.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<TerminologyCapabilities, String> =
    SearchParam(
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
