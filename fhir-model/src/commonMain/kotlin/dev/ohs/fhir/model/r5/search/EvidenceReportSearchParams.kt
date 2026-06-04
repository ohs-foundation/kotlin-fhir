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
import dev.ohs.fhir.model.r5.EvidenceReport
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EvidenceReport] resource type. */
public object EvidenceReportSearchParams {
  public val Context: SearchParam<EvidenceReport, Any> =
    SimpleSearchParam<EvidenceReport, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(EvidenceReport.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<EvidenceReport, Any> =
    SimpleSearchParam<EvidenceReport, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(EvidenceReport.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<EvidenceReport, Coding> =
    SimpleSearchParam<EvidenceReport, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "EvidenceReport.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<EvidenceReport, UsageContext> =
    SimpleSearchParam<EvidenceReport, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "EvidenceReport.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<EvidenceReport, UsageContext> =
    SimpleSearchParam<EvidenceReport, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "EvidenceReport.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Identifier: SearchParam<EvidenceReport, Identifier> =
    SimpleSearchParam<EvidenceReport, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "EvidenceReport.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Publisher: SearchParam<EvidenceReport, String> =
    SimpleSearchParam<EvidenceReport, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "EvidenceReport.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<EvidenceReport, Any> =
    SimpleSearchParam<EvidenceReport, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "EvidenceReport.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Url: SearchParam<EvidenceReport, Uri> =
    SimpleSearchParam<EvidenceReport, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "EvidenceReport.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  /** All search parameters for the EvidenceReport resource type. */
  public val ALL: List<SearchParam<EvidenceReport, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Identifier,
      Publisher,
      Status,
      Url,
    )
}
