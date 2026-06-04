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

import dev.ohs.fhir.model.r4.ChargeItemDefinition
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ChargeItemDefinition] resource type. */
public object ChargeItemDefinitionSearchParams {
  public val context: SearchParam<ChargeItemDefinition, CodeableConcept> =
    SearchParam<ChargeItemDefinition, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ChargeItemDefinition.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<ChargeItemDefinition, Quantity> =
    SearchParam<ChargeItemDefinition, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ChargeItemDefinition.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<ChargeItemDefinition, Coding> =
    SearchParam<ChargeItemDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<ChargeItemDefinition, UsageContext> =
    SearchParam<ChargeItemDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ChargeItemDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<ChargeItemDefinition, UsageContext> =
    SearchParam<ChargeItemDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ChargeItemDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<ChargeItemDefinition, DateTime> =
    SearchParam<ChargeItemDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ChargeItemDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<ChargeItemDefinition, Markdown> =
    SearchParam<ChargeItemDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ChargeItemDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val effective: SearchParam<ChargeItemDefinition, Period> =
    SearchParam<ChargeItemDefinition, Period>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "ChargeItemDefinition.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val identifier: SearchParam<ChargeItemDefinition, Identifier> =
    SearchParam<ChargeItemDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<ChargeItemDefinition, CodeableConcept> =
    SearchParam<ChargeItemDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val publisher: SearchParam<ChargeItemDefinition, String> =
    SearchParam<ChargeItemDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ChargeItemDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<ChargeItemDefinition, Any> =
    SearchParam<ChargeItemDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<ChargeItemDefinition, String> =
    SearchParam<ChargeItemDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ChargeItemDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<ChargeItemDefinition, Uri> =
    SearchParam<ChargeItemDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ChargeItemDefinition.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<ChargeItemDefinition, String> =
    SearchParam<ChargeItemDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItemDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ChargeItemDefinition resource type. */
  public val all: List<SearchParam<ChargeItemDefinition, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      effective,
      identifier,
      jurisdiction,
      publisher,
      status,
      title,
      url,
      version,
    )
}
