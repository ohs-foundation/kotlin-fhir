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
public object EvidenceSearchParam {
  public val Context: SearchParam<Evidence, Any> =
    SimpleSearchParam<Evidence, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(Evidence.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<Evidence, Any> =
    SimpleSearchParam<Evidence, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Evidence.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<Evidence, Coding> =
    SimpleSearchParam<Evidence, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "Evidence.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<Evidence, UsageContext> =
    SimpleSearchParam<Evidence, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Evidence.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<Evidence, UsageContext> =
    SimpleSearchParam<Evidence, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Evidence.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<Evidence, DateTime> =
    SimpleSearchParam<Evidence, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Evidence.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<Evidence, Markdown> =
    SimpleSearchParam<Evidence, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "Evidence.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Identifier: SearchParam<Evidence, Identifier> =
    SimpleSearchParam<Evidence, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Evidence.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Publisher: SearchParam<Evidence, String> =
    SimpleSearchParam<Evidence, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "Evidence.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<Evidence, Any> =
    SimpleSearchParam<Evidence, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Evidence.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<Evidence, String> =
    SimpleSearchParam<Evidence, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "Evidence.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<Evidence, Uri> =
    SimpleSearchParam<Evidence, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Evidence.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<Evidence, String> =
    SimpleSearchParam<Evidence, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "Evidence.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the Evidence resource type. */
  public val ALL: List<SearchParam<Evidence, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Identifier,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )
}
