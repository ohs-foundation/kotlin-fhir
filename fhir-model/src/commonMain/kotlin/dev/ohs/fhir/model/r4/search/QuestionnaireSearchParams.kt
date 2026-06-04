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
import dev.ohs.fhir.model.r4.Questionnaire
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Questionnaire] resource type. */
public object QuestionnaireSearchParams {
  public val code: SearchParam<Questionnaire, Coding> =
    SearchParam<Questionnaire, Coding>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.item.code",
      extractor = { resource -> resource.item.flatMap { it.code } },
    )

  public val context: SearchParam<Questionnaire, CodeableConcept> =
    SearchParam<Questionnaire, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(Questionnaire.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<Questionnaire, Quantity> =
    SearchParam<Questionnaire, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Questionnaire.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<Questionnaire, Coding> =
    SearchParam<Questionnaire, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<Questionnaire, UsageContext> =
    SearchParam<Questionnaire, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Questionnaire.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<Questionnaire, UsageContext> =
    SearchParam<Questionnaire, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Questionnaire.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<Questionnaire, DateTime> =
    SearchParam<Questionnaire, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Questionnaire.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val definition: SearchParam<Questionnaire, Uri> =
    SearchParam<Questionnaire, Uri>(
      name = "definition",
      type = SearchParamType.fromCode("uri"),
      expression = "Questionnaire.item.definition",
      extractor = { resource -> resource.item.mapNotNull { it.definition } },
    )

  public val description: SearchParam<Questionnaire, Markdown> =
    SearchParam<Questionnaire, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val effective: SearchParam<Questionnaire, Period> =
    SearchParam<Questionnaire, Period>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "Questionnaire.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val identifier: SearchParam<Questionnaire, Identifier> =
    SearchParam<Questionnaire, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<Questionnaire, CodeableConcept> =
    SearchParam<Questionnaire, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<Questionnaire, String> =
    SearchParam<Questionnaire, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<Questionnaire, String> =
    SearchParam<Questionnaire, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<Questionnaire, Any> =
    SearchParam<Questionnaire, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subjectType: SearchParam<Questionnaire, Any> =
    SearchParam<Questionnaire, Any>(
      name = "subject-type",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.subjectType",
      extractor = { resource -> resource.subjectType },
    )

  public val title: SearchParam<Questionnaire, String> =
    SearchParam<Questionnaire, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<Questionnaire, Uri> =
    SearchParam<Questionnaire, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Questionnaire.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<Questionnaire, String> =
    SearchParam<Questionnaire, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the Questionnaire resource type. */
  public val all: List<SearchParam<Questionnaire, *>> =
    listOf(
      code,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      definition,
      description,
      effective,
      identifier,
      jurisdiction,
      name,
      publisher,
      status,
      subjectType,
      title,
      url,
      version,
    )
}
