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
  public val Context: SearchParam<TerminologyCapabilities, Any> =
    SimpleSearchParam<TerminologyCapabilities, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(TerminologyCapabilities.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<TerminologyCapabilities, Any> =
    SimpleSearchParam<TerminologyCapabilities, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(TerminologyCapabilities.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<TerminologyCapabilities, Coding> =
    SimpleSearchParam<TerminologyCapabilities, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<TerminologyCapabilities, UsageContext> =
    SimpleSearchParam<TerminologyCapabilities, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "TerminologyCapabilities.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<TerminologyCapabilities, UsageContext> =
    SimpleSearchParam<TerminologyCapabilities, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "TerminologyCapabilities.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<TerminologyCapabilities, DateTime> =
    SimpleSearchParam<TerminologyCapabilities, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "TerminologyCapabilities.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val Description: SearchParam<TerminologyCapabilities, Markdown> =
    SimpleSearchParam<TerminologyCapabilities, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Identifier: SearchParam<TerminologyCapabilities, Identifier> =
    SimpleSearchParam<TerminologyCapabilities, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<TerminologyCapabilities, CodeableConcept> =
    SimpleSearchParam<TerminologyCapabilities, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<TerminologyCapabilities, String> =
    SimpleSearchParam<TerminologyCapabilities, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<TerminologyCapabilities, String> =
    SimpleSearchParam<TerminologyCapabilities, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<TerminologyCapabilities, Any> =
    SimpleSearchParam<TerminologyCapabilities, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<TerminologyCapabilities, String> =
    SimpleSearchParam<TerminologyCapabilities, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "TerminologyCapabilities.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<TerminologyCapabilities, Uri> =
    SimpleSearchParam<TerminologyCapabilities, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "TerminologyCapabilities.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<TerminologyCapabilities, String> =
    SimpleSearchParam<TerminologyCapabilities, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "TerminologyCapabilities.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the TerminologyCapabilities resource type. */
  public val ALL: List<SearchParam<TerminologyCapabilities, *>> =
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
