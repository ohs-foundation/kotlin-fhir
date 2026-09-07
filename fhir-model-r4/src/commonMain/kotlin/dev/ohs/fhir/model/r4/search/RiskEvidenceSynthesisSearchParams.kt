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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Period
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
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(RiskEvidenceSynthesis.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<RiskEvidenceSynthesis, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression =
        "(RiskEvidenceSynthesis.useContext.value as Quantity) | (RiskEvidenceSynthesis.useContext.value as Range)",
      extractor = { resource ->
        buildList {
            addAll(
              resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
            )
            addAll(
              resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Range)?.value }
            )
          }
          .distinct()
      },
    )

  public val contextType: SearchParam<RiskEvidenceSynthesis, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "RiskEvidenceSynthesis.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<RiskEvidenceSynthesis, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "RiskEvidenceSynthesis.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<RiskEvidenceSynthesis, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "RiskEvidenceSynthesis.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<RiskEvidenceSynthesis, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "RiskEvidenceSynthesis.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<RiskEvidenceSynthesis, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "RiskEvidenceSynthesis.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val effective: SearchParam<RiskEvidenceSynthesis, Period> =
    SearchParam(
      name = "effective",
      type = SearchParamType.Date,
      expression = "RiskEvidenceSynthesis.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val identifier: SearchParam<RiskEvidenceSynthesis, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "RiskEvidenceSynthesis.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<RiskEvidenceSynthesis, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "RiskEvidenceSynthesis.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<RiskEvidenceSynthesis, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "RiskEvidenceSynthesis.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<RiskEvidenceSynthesis, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "RiskEvidenceSynthesis.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<RiskEvidenceSynthesis, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "RiskEvidenceSynthesis.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<RiskEvidenceSynthesis, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "RiskEvidenceSynthesis.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<RiskEvidenceSynthesis, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "RiskEvidenceSynthesis.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<RiskEvidenceSynthesis, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "RiskEvidenceSynthesis.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<RiskEvidenceSynthesis, *>> = listOf()

  /**
   * Supported search parameters for the RiskEvidenceSynthesis resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
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
