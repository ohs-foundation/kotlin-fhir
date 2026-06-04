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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.RiskEvidenceSynthesis
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RiskEvidenceSynthesis] resource type. */
public object RiskEvidenceSynthesisSearchParams {
  public val context: SearchParam<RiskEvidenceSynthesis, CodeableConcept> =
    SimpleSearchParam<RiskEvidenceSynthesis, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(RiskEvidenceSynthesis.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<RiskEvidenceSynthesis, Quantity> =
    SimpleSearchParam<RiskEvidenceSynthesis, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(RiskEvidenceSynthesis.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<RiskEvidenceSynthesis, Coding> =
    SimpleSearchParam<RiskEvidenceSynthesis, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "RiskEvidenceSynthesis.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<RiskEvidenceSynthesis, UsageContext> =
    SimpleSearchParam<RiskEvidenceSynthesis, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "RiskEvidenceSynthesis.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<RiskEvidenceSynthesis, UsageContext> =
    SimpleSearchParam<RiskEvidenceSynthesis, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "RiskEvidenceSynthesis.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<RiskEvidenceSynthesis, DateTime> =
    SimpleSearchParam<RiskEvidenceSynthesis, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "RiskEvidenceSynthesis.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<RiskEvidenceSynthesis, Markdown> =
    SimpleSearchParam<RiskEvidenceSynthesis, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "RiskEvidenceSynthesis.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val effective: SearchParam<RiskEvidenceSynthesis, Period> =
    SimpleSearchParam<RiskEvidenceSynthesis, Period>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "RiskEvidenceSynthesis.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val identifier: SearchParam<RiskEvidenceSynthesis, Identifier> =
    SimpleSearchParam<RiskEvidenceSynthesis, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "RiskEvidenceSynthesis.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<RiskEvidenceSynthesis, CodeableConcept> =
    SimpleSearchParam<RiskEvidenceSynthesis, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "RiskEvidenceSynthesis.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<RiskEvidenceSynthesis, String> =
    SimpleSearchParam<RiskEvidenceSynthesis, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "RiskEvidenceSynthesis.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<RiskEvidenceSynthesis, String> =
    SimpleSearchParam<RiskEvidenceSynthesis, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "RiskEvidenceSynthesis.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<RiskEvidenceSynthesis, Any> =
    SimpleSearchParam<RiskEvidenceSynthesis, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "RiskEvidenceSynthesis.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<RiskEvidenceSynthesis, String> =
    SimpleSearchParam<RiskEvidenceSynthesis, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "RiskEvidenceSynthesis.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<RiskEvidenceSynthesis, Uri> =
    SimpleSearchParam<RiskEvidenceSynthesis, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "RiskEvidenceSynthesis.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<RiskEvidenceSynthesis, String> =
    SimpleSearchParam<RiskEvidenceSynthesis, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "RiskEvidenceSynthesis.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the RiskEvidenceSynthesis resource type. */
  public val all: List<SearchParam<RiskEvidenceSynthesis, *>> =
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
      name,
      publisher,
      status,
      title,
      url,
      version,
    )
}
