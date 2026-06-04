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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.SearchParameter
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SearchParameter] resource type. */
public object SearchParameterSearchParams {
  public val base: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "base",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.base",
      extractor = { resource -> resource.base },
    )

  public val code: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val component: SearchParam<SearchParameter, Canonical> =
    SimpleSearchParam<SearchParameter, Canonical>(
      name = "component",
      type = SearchParamType.fromCode("reference"),
      expression = "SearchParameter.component.definition",
      target = listOf(SearchParameter::class),
      extractor = { resource -> resource.component.map { it.definition } },
    )

  public val context: SearchParam<SearchParameter, CodeableConcept> =
    SimpleSearchParam<SearchParameter, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(SearchParameter.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<SearchParameter, Quantity> =
    SimpleSearchParam<SearchParameter, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(SearchParameter.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<SearchParameter, Coding> =
    SimpleSearchParam<SearchParameter, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<SearchParameter, UsageContext> =
    SimpleSearchParam<SearchParameter, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "SearchParameter.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<SearchParameter, UsageContext> =
    SimpleSearchParam<SearchParameter, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "SearchParameter.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<SearchParameter, DateTime> =
    SimpleSearchParam<SearchParameter, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "SearchParameter.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val derivedFrom: SearchParam<SearchParameter, Canonical> =
    SimpleSearchParam<SearchParameter, Canonical>(
      name = "derived-from",
      type = SearchParamType.fromCode("reference"),
      expression = "SearchParameter.derivedFrom",
      target = listOf(SearchParameter::class),
      extractor = { resource -> listOfNotNull(resource.derivedFrom) },
    )

  public val description: SearchParam<SearchParameter, Markdown> =
    SimpleSearchParam<SearchParameter, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.description",
      extractor = { resource -> listOf(resource.description) },
    )

  public val jurisdiction: SearchParam<SearchParameter, CodeableConcept> =
    SimpleSearchParam<SearchParameter, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<SearchParameter, String> =
    SimpleSearchParam<SearchParameter, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<SearchParameter, String> =
    SimpleSearchParam<SearchParameter, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "SearchParameter.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val target: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "target",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.target",
      extractor = { resource -> resource.target },
    )

  public val type: SearchParam<SearchParameter, Any> =
    SimpleSearchParam<SearchParameter, Any>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val url: SearchParam<SearchParameter, Uri> =
    SimpleSearchParam<SearchParameter, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "SearchParameter.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<SearchParameter, String> =
    SimpleSearchParam<SearchParameter, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "SearchParameter.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the SearchParameter resource type. */
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
      jurisdiction,
      name,
      publisher,
      status,
      target,
      type,
      url,
      version,
    )
}
