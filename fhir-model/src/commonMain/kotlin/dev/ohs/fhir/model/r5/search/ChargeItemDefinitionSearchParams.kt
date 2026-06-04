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

import dev.ohs.fhir.model.r5.ChargeItemDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ChargeItemDefinition] resource type. */
public object ChargeItemDefinitionSearchParams {
  public val Context: SearchParam<ChargeItemDefinition, Any> =
    SimpleSearchParam<ChargeItemDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ChargeItemDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<ChargeItemDefinition, Any> =
    SimpleSearchParam<ChargeItemDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ChargeItemDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<ChargeItemDefinition, Coding> =
    SimpleSearchParam<ChargeItemDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<ChargeItemDefinition, UsageContext> =
    SimpleSearchParam<ChargeItemDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ChargeItemDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<ChargeItemDefinition, UsageContext> =
    SimpleSearchParam<ChargeItemDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ChargeItemDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<ChargeItemDefinition, DateTime> =
    SimpleSearchParam<ChargeItemDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ChargeItemDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<ChargeItemDefinition, Markdown> =
    SimpleSearchParam<ChargeItemDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ChargeItemDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Effective: SearchParam<ChargeItemDefinition, Period> =
    SimpleSearchParam<ChargeItemDefinition, Period>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "ChargeItemDefinition.applicability.effectivePeriod",
      extractor = { resource -> resource.applicability.mapNotNull { it.effectivePeriod } },
    )

  public val Identifier: SearchParam<ChargeItemDefinition, Identifier> =
    SimpleSearchParam<ChargeItemDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<ChargeItemDefinition, CodeableConcept> =
    SimpleSearchParam<ChargeItemDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Publisher: SearchParam<ChargeItemDefinition, String> =
    SimpleSearchParam<ChargeItemDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ChargeItemDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<ChargeItemDefinition, Any> =
    SimpleSearchParam<ChargeItemDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<ChargeItemDefinition, String> =
    SimpleSearchParam<ChargeItemDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ChargeItemDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<ChargeItemDefinition, Uri> =
    SimpleSearchParam<ChargeItemDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ChargeItemDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<ChargeItemDefinition, String> =
    SimpleSearchParam<ChargeItemDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ChargeItemDefinition resource type. */
  public val ALL: List<SearchParam<ChargeItemDefinition, *>> =
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
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )
}
