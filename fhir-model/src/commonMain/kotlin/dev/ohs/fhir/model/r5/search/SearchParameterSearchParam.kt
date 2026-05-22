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
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SearchParameter] resource type. */
public object SearchParameterSearchParam {
  public val Base: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "base",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.base",
      extractor = { resource -> resource.base },
    )

  public val Code: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val Component: SearchParam<SearchParameter, Canonical> =
    SimpleSearchParam<SearchParameter, Canonical>(
      name = "component",
      type = SearchParamType.fromCode("reference"),
      expression = "SearchParameter.component.definition",
      target = listOf(SearchParameter::class),
      extractor = { resource -> resource.component.map { it.definition } },
    )

  public val Context: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(SearchParameter.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(SearchParameter.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<SearchParameter, Coding> =
    SimpleSearchParam<SearchParameter, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<SearchParameter, UsageContext> =
    SimpleSearchParam<SearchParameter, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "SearchParameter.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<SearchParameter, UsageContext> =
    SimpleSearchParam<SearchParameter, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "SearchParameter.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<SearchParameter, DateTime> =
    SimpleSearchParam<SearchParameter, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "SearchParameter.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val DerivedFrom: SearchParam<SearchParameter, Canonical> =
    SimpleSearchParam<SearchParameter, Canonical>(
      name = "derived-from",
      type = SearchParamType.fromCode("reference"),
      expression = "SearchParameter.derivedFrom",
      target = listOf(SearchParameter::class),
      extractor = { resource -> listOfNotNull(resource.derivedFrom) },
    )

  public val Description: SearchParam<SearchParameter, Markdown> =
    SimpleSearchParam<SearchParameter, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.description",
      extractor = { resource -> listOf(resource.description) },
    )

  public val Identifier: SearchParam<SearchParameter, Identifier> =
    SimpleSearchParam<SearchParameter, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<SearchParameter, CodeableConcept> =
    SimpleSearchParam<SearchParameter, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<SearchParameter, String> =
    SimpleSearchParam<SearchParameter, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val Publisher: SearchParam<SearchParameter, String> =
    SimpleSearchParam<SearchParameter, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Target: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "target",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.target",
      extractor = { resource -> resource.target },
    )

  public val Type: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val Url: SearchParam<SearchParameter, Uri> =
    SimpleSearchParam<SearchParameter, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "SearchParameter.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val Version: SearchParam<SearchParameter, String> =
    SimpleSearchParam<SearchParameter, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the SearchParameter resource type. */
  public val ALL: List<SearchParam<SearchParameter, *>> =
    listOf(
      Base,
      Code,
      Component,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      DerivedFrom,
      Description,
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Status,
      Target,
      Type,
      Url,
      Version,
    )
}
