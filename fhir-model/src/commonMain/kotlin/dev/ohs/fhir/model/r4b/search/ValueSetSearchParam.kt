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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.ValueSet
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ValueSet] resource type. */
public object ValueSetSearchParam {
  public val Code: SearchParam<ValueSet, Any> =
    SimpleSearchParam<ValueSet, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.expansion.contains.code",
      extractor = { resource ->
        (resource.expansion?.contains ?: emptyList()).mapNotNull { it.code }
      },
    )

  public val Context: SearchParam<ValueSet, CodeableConcept> =
    SimpleSearchParam<ValueSet, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ValueSet.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val ContextQuantity: SearchParam<ValueSet, Quantity> =
    SimpleSearchParam<ValueSet, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ValueSet.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<ValueSet, Coding> =
    SimpleSearchParam<ValueSet, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<ValueSet, UsageContext> =
    SimpleSearchParam<ValueSet, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ValueSet.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<ValueSet, UsageContext> =
    SimpleSearchParam<ValueSet, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ValueSet.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<ValueSet, DateTime> =
    SimpleSearchParam<ValueSet, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ValueSet.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<ValueSet, Markdown> =
    SimpleSearchParam<ValueSet, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ValueSet.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Expansion: SearchParam<ValueSet, Uri> =
    SimpleSearchParam<ValueSet, Uri>(
      name = "expansion",
      type = SearchParamType.fromCode("uri"),
      expression = "ValueSet.expansion.identifier",
      extractor = { resource -> listOfNotNull(resource.expansion?.identifier) },
    )

  public val Identifier: SearchParam<ValueSet, Identifier> =
    SimpleSearchParam<ValueSet, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<ValueSet, CodeableConcept> =
    SimpleSearchParam<ValueSet, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<ValueSet, String> =
    SimpleSearchParam<ValueSet, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "ValueSet.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<ValueSet, String> =
    SimpleSearchParam<ValueSet, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ValueSet.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Reference: SearchParam<ValueSet, Uri> =
    SimpleSearchParam<ValueSet, Uri>(
      name = "reference",
      type = SearchParamType.fromCode("uri"),
      expression = "ValueSet.compose.include.system",
      extractor = { resource ->
        (resource.compose?.include ?: emptyList()).mapNotNull { it.system }
      },
    )

  public val Status: SearchParam<ValueSet, Any> =
    SimpleSearchParam<ValueSet, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<ValueSet, String> =
    SimpleSearchParam<ValueSet, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ValueSet.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<ValueSet, Uri> =
    SimpleSearchParam<ValueSet, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ValueSet.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<ValueSet, String> =
    SimpleSearchParam<ValueSet, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ValueSet resource type. */
  public val ALL: List<SearchParam<ValueSet, *>> =
    listOf(
      Code,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Expansion,
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Reference,
      Status,
      Title,
      Url,
      Version,
    )
}
