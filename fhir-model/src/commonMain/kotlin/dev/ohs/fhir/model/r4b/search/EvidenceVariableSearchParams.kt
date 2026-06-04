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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.EvidenceVariable
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EvidenceVariable] resource type. */
public object EvidenceVariableSearchParams {
  public val Context: SearchParam<EvidenceVariable, CodeableConcept> =
    SimpleSearchParam<EvidenceVariable, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(EvidenceVariable.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val ContextQuantity: SearchParam<EvidenceVariable, Quantity> =
    SimpleSearchParam<EvidenceVariable, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(EvidenceVariable.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<EvidenceVariable, Coding> =
    SimpleSearchParam<EvidenceVariable, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "EvidenceVariable.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<EvidenceVariable, UsageContext> =
    SimpleSearchParam<EvidenceVariable, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "EvidenceVariable.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<EvidenceVariable, UsageContext> =
    SimpleSearchParam<EvidenceVariable, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "EvidenceVariable.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<EvidenceVariable, DateTime> =
    SimpleSearchParam<EvidenceVariable, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "EvidenceVariable.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<EvidenceVariable, Markdown> =
    SimpleSearchParam<EvidenceVariable, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "EvidenceVariable.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Identifier: SearchParam<EvidenceVariable, Identifier> =
    SimpleSearchParam<EvidenceVariable, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "EvidenceVariable.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Name: SearchParam<EvidenceVariable, String> =
    SimpleSearchParam<EvidenceVariable, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "EvidenceVariable.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<EvidenceVariable, String> =
    SimpleSearchParam<EvidenceVariable, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "EvidenceVariable.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<EvidenceVariable, Any> =
    SimpleSearchParam<EvidenceVariable, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "EvidenceVariable.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<EvidenceVariable, String> =
    SimpleSearchParam<EvidenceVariable, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "EvidenceVariable.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<EvidenceVariable, Uri> =
    SimpleSearchParam<EvidenceVariable, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "EvidenceVariable.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<EvidenceVariable, String> =
    SimpleSearchParam<EvidenceVariable, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "EvidenceVariable.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the EvidenceVariable resource type. */
  public val ALL: List<SearchParam<EvidenceVariable, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Identifier,
      Name,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )
}
