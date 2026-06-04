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
  public val Context: SearchParam<Citation, CodeableConcept> =
    SimpleSearchParam<Citation, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(Citation.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val ContextQuantity: SearchParam<Citation, Quantity> =
    SimpleSearchParam<Citation, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Citation.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<Citation, Coding> =
    SimpleSearchParam<Citation, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "Citation.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<Citation, UsageContext> =
    SimpleSearchParam<Citation, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Citation.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<Citation, UsageContext> =
    SimpleSearchParam<Citation, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Citation.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<Citation, DateTime> =
    SimpleSearchParam<Citation, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Citation.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<Citation, Markdown> =
    SimpleSearchParam<Citation, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "Citation.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Effective: SearchParam<Citation, Period> =
    SimpleSearchParam<Citation, Period>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "Citation.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val Identifier: SearchParam<Citation, Identifier> =
    SimpleSearchParam<Citation, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Citation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<Citation, CodeableConcept> =
    SimpleSearchParam<Citation, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "Citation.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<Citation, String> =
    SimpleSearchParam<Citation, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Citation.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<Citation, String> =
    SimpleSearchParam<Citation, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "Citation.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<Citation, Any> =
    SimpleSearchParam<Citation, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Citation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<Citation, String> =
    SimpleSearchParam<Citation, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "Citation.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<Citation, Uri> =
    SimpleSearchParam<Citation, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Citation.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<Citation, String> =
    SimpleSearchParam<Citation, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "Citation.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the Citation resource type. */
  public val ALL: List<SearchParam<Citation, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Effective,
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
