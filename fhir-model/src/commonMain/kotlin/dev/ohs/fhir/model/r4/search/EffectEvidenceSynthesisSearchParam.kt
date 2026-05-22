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
import dev.ohs.fhir.model.r4.EffectEvidenceSynthesis
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

/** Search parameters for the [EffectEvidenceSynthesis] resource type. */
public object EffectEvidenceSynthesisSearchParam {
  public val Context: SearchParam<EffectEvidenceSynthesis, CodeableConcept> =
    SimpleSearchParam<EffectEvidenceSynthesis, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(EffectEvidenceSynthesis.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
      },
    )

  public val ContextQuantity: SearchParam<EffectEvidenceSynthesis, Quantity> =
    SimpleSearchParam<EffectEvidenceSynthesis, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(EffectEvidenceSynthesis.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<EffectEvidenceSynthesis, Coding> =
    SimpleSearchParam<EffectEvidenceSynthesis, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "EffectEvidenceSynthesis.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<EffectEvidenceSynthesis, UsageContext> =
    SimpleSearchParam<EffectEvidenceSynthesis, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "EffectEvidenceSynthesis.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<EffectEvidenceSynthesis, UsageContext> =
    SimpleSearchParam<EffectEvidenceSynthesis, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "EffectEvidenceSynthesis.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<EffectEvidenceSynthesis, DateTime> =
    SimpleSearchParam<EffectEvidenceSynthesis, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "EffectEvidenceSynthesis.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<EffectEvidenceSynthesis, Markdown> =
    SimpleSearchParam<EffectEvidenceSynthesis, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "EffectEvidenceSynthesis.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Effective: SearchParam<EffectEvidenceSynthesis, Period> =
    SimpleSearchParam<EffectEvidenceSynthesis, Period>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "EffectEvidenceSynthesis.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val Identifier: SearchParam<EffectEvidenceSynthesis, Identifier> =
    SimpleSearchParam<EffectEvidenceSynthesis, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "EffectEvidenceSynthesis.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<EffectEvidenceSynthesis, CodeableConcept> =
    SimpleSearchParam<EffectEvidenceSynthesis, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "EffectEvidenceSynthesis.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<EffectEvidenceSynthesis, String> =
    SimpleSearchParam<EffectEvidenceSynthesis, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "EffectEvidenceSynthesis.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<EffectEvidenceSynthesis, String> =
    SimpleSearchParam<EffectEvidenceSynthesis, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "EffectEvidenceSynthesis.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<EffectEvidenceSynthesis, Any> =
    SimpleSearchParam<EffectEvidenceSynthesis, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "EffectEvidenceSynthesis.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<EffectEvidenceSynthesis, String> =
    SimpleSearchParam<EffectEvidenceSynthesis, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "EffectEvidenceSynthesis.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<EffectEvidenceSynthesis, Uri> =
    SimpleSearchParam<EffectEvidenceSynthesis, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "EffectEvidenceSynthesis.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<EffectEvidenceSynthesis, String> =
    SimpleSearchParam<EffectEvidenceSynthesis, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "EffectEvidenceSynthesis.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the EffectEvidenceSynthesis resource type. */
  public val ALL: List<SearchParam<EffectEvidenceSynthesis, *>> =
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
      Name,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )
}
