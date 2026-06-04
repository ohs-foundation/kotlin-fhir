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

import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Evidence
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Evidence] resource type. */
public object EvidenceSearchParams {
  public val context: SearchParam<Evidence, Any> =
    SearchParam(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(Evidence.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<Evidence, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Evidence.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<Evidence, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "Evidence.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<Evidence, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Evidence.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<Evidence, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Evidence.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<Evidence, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Evidence.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<Evidence, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "Evidence.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<Evidence, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Evidence.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val publisher: SearchParam<Evidence, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "Evidence.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<Evidence, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Evidence.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<Evidence, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "Evidence.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<Evidence, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Evidence.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<Evidence, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "Evidence.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the Evidence resource type. */
  public val all: List<SearchParam<Evidence, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      identifier,
      publisher,
      status,
      title,
      url,
      version,
    )
}
