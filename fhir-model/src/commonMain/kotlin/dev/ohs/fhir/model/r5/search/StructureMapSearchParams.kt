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
import dev.ohs.fhir.model.r5.StructureMap
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [StructureMap] resource type. */
public object StructureMapSearchParams {
  public val context: SearchParam<StructureMap, Any> =
    SearchParam<StructureMap, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(StructureMap.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<StructureMap, Any> =
    SearchParam<StructureMap, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(StructureMap.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<StructureMap, Coding> =
    SearchParam<StructureMap, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<StructureMap, UsageContext> =
    SearchParam<StructureMap, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<StructureMap, UsageContext> =
    SearchParam<StructureMap, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<StructureMap, DateTime> =
    SearchParam<StructureMap, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "StructureMap.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<StructureMap, Markdown> =
    SearchParam<StructureMap, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "StructureMap.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<StructureMap, Identifier> =
    SearchParam<StructureMap, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<StructureMap, CodeableConcept> =
    SearchParam<StructureMap, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<StructureMap, String> =
    SearchParam<StructureMap, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "StructureMap.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<StructureMap, String> =
    SearchParam<StructureMap, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "StructureMap.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<StructureMap, Any> =
    SearchParam<StructureMap, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<StructureMap, String> =
    SearchParam<StructureMap, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "StructureMap.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<StructureMap, Uri> =
    SearchParam<StructureMap, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "StructureMap.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<StructureMap, String> =
    SearchParam<StructureMap, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the StructureMap resource type. */
  public val all: List<SearchParam<StructureMap, *>> =
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
