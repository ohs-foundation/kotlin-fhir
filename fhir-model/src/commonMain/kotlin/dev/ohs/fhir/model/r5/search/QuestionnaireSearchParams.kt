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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Questionnaire
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Questionnaire] resource type. */
public object QuestionnaireSearchParams {
  public val comboCode: SearchParam<Questionnaire, Coding> =
    SearchParam(
      name = "combo-code",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.code",
      extractor = { resource -> resource.code },
    )

  public val context: SearchParam<Questionnaire, Any> =
    SearchParam(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(Questionnaire.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<Questionnaire, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Questionnaire.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<Questionnaire, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<Questionnaire, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Questionnaire.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<Questionnaire, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Questionnaire.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<Questionnaire, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Questionnaire.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val definition: SearchParam<Questionnaire, Uri> =
    SearchParam(
      name = "definition",
      type = SearchParamType.fromCode("uri"),
      expression = "Questionnaire.item.definition",
      extractor = { resource -> resource.item.mapNotNull { it.definition } },
    )

  public val description: SearchParam<Questionnaire, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val effective: SearchParam<Questionnaire, Period> =
    SearchParam(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "Questionnaire.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val identifier: SearchParam<Questionnaire, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val itemCode: SearchParam<Questionnaire, Coding> =
    SearchParam(
      name = "item-code",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.item.code",
      extractor = { resource -> resource.item.flatMap { it.code } },
    )

  public val jurisdiction: SearchParam<Questionnaire, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<Questionnaire, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<Questionnaire, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val questionnaireCode: SearchParam<Questionnaire, Coding> =
    SearchParam(
      name = "questionnaire-code",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.code",
      extractor = { resource -> resource.code },
    )

  public val status: SearchParam<Questionnaire, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subjectType: SearchParam<Questionnaire, Any> =
    SearchParam(
      name = "subject-type",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.subjectType",
      extractor = { resource -> resource.subjectType },
    )

  public val title: SearchParam<Questionnaire, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<Questionnaire, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Questionnaire.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<Questionnaire, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the Questionnaire resource type. */
  public val all: List<SearchParam<Questionnaire, *>> =
    listOf(
      comboCode,
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
      itemCode,
      jurisdiction,
      name,
      publisher,
      questionnaireCode,
      status,
      subjectType,
      title,
      url,
      version,
    )
}
