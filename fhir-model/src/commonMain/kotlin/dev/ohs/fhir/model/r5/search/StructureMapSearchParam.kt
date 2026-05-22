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
public object StructureMapSearchParam {
  public val Context: SearchParam<StructureMap, Any> =
    SimpleSearchParam<StructureMap, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(StructureMap.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<StructureMap, Any> =
    SimpleSearchParam<StructureMap, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(StructureMap.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<StructureMap, Coding> =
    SimpleSearchParam<StructureMap, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<StructureMap, UsageContext> =
    SimpleSearchParam<StructureMap, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<StructureMap, UsageContext> =
    SimpleSearchParam<StructureMap, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<StructureMap, DateTime> =
    SimpleSearchParam<StructureMap, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "StructureMap.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<StructureMap, Markdown> =
    SimpleSearchParam<StructureMap, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "StructureMap.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Identifier: SearchParam<StructureMap, Identifier> =
    SimpleSearchParam<StructureMap, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<StructureMap, CodeableConcept> =
    SimpleSearchParam<StructureMap, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<StructureMap, String> =
    SimpleSearchParam<StructureMap, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "StructureMap.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val Publisher: SearchParam<StructureMap, String> =
    SimpleSearchParam<StructureMap, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "StructureMap.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<StructureMap, Any> =
    SimpleSearchParam<StructureMap, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<StructureMap, String> =
    SimpleSearchParam<StructureMap, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "StructureMap.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<StructureMap, Uri> =
    SimpleSearchParam<StructureMap, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "StructureMap.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val Version: SearchParam<StructureMap, String> =
    SimpleSearchParam<StructureMap, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "StructureMap.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the StructureMap resource type. */
  public val ALL: List<SearchParam<StructureMap, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )
}
