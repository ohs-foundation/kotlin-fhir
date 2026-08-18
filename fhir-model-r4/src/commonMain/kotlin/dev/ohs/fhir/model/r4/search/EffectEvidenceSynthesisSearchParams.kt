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
import dev.ohs.fhir.model.r4.EffectEvidenceSynthesis
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EffectEvidenceSynthesis] resource type. */
public object EffectEvidenceSynthesisSearchParams {
  public val context: SearchParam<EffectEvidenceSynthesis, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(EffectEvidenceSynthesis.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<EffectEvidenceSynthesis, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression =
        "(EffectEvidenceSynthesis.useContext.value as Quantity) | (EffectEvidenceSynthesis.useContext.value as Range)",
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

  public val contextType: SearchParam<EffectEvidenceSynthesis, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "EffectEvidenceSynthesis.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<EffectEvidenceSynthesis, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "EffectEvidenceSynthesis.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<EffectEvidenceSynthesis, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "EffectEvidenceSynthesis.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<EffectEvidenceSynthesis, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "EffectEvidenceSynthesis.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<EffectEvidenceSynthesis, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "EffectEvidenceSynthesis.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val effective: SearchParam<EffectEvidenceSynthesis, Period> =
    SearchParam(
      name = "effective",
      type = SearchParamType.Date,
      expression = "EffectEvidenceSynthesis.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val identifier: SearchParam<EffectEvidenceSynthesis, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "EffectEvidenceSynthesis.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<EffectEvidenceSynthesis, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "EffectEvidenceSynthesis.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<EffectEvidenceSynthesis, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "EffectEvidenceSynthesis.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<EffectEvidenceSynthesis, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "EffectEvidenceSynthesis.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<EffectEvidenceSynthesis, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "EffectEvidenceSynthesis.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<EffectEvidenceSynthesis, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "EffectEvidenceSynthesis.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<EffectEvidenceSynthesis, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "EffectEvidenceSynthesis.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<EffectEvidenceSynthesis, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "EffectEvidenceSynthesis.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<EffectEvidenceSynthesis, *>> = listOf()

  /**
   * Supported search parameters for the EffectEvidenceSynthesis resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<EffectEvidenceSynthesis, *>> =
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
