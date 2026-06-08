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
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Questionnaire
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Questionnaire] resource type. */
public object QuestionnaireSearchParams {
  public val code: SearchParam<Questionnaire, Coding> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "Questionnaire.item.code",
      extractor = { resource -> resource.item.flatMap { it.code } },
    )

  public val context: SearchParam<Questionnaire, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(Questionnaire.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<Questionnaire, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(Questionnaire.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<Questionnaire, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "Questionnaire.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<Questionnaire, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "Questionnaire.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<Questionnaire, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "Questionnaire.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<Questionnaire, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "Questionnaire.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val definition: SearchParam<Questionnaire, Uri> =
    SearchParam(
      name = "definition",
      type = SearchParamType.Uri,
      expression = "Questionnaire.item.definition",
      extractor = { resource -> resource.item.mapNotNull { it.definition } },
    )

  public val description: SearchParam<Questionnaire, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "Questionnaire.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val effective: SearchParam<Questionnaire, Period> =
    SearchParam(
      name = "effective",
      type = SearchParamType.Date,
      expression = "Questionnaire.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val identifier: SearchParam<Questionnaire, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Questionnaire.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<Questionnaire, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "Questionnaire.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<Questionnaire, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "Questionnaire.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<Questionnaire, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "Questionnaire.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<Questionnaire, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Questionnaire.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subjectType: SearchParam<Questionnaire, Any> =
    SearchParam(
      name = "subject-type",
      type = SearchParamType.Token,
      expression = "Questionnaire.subjectType",
      extractor = { resource -> resource.subjectType },
    )

  public val title: SearchParam<Questionnaire, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "Questionnaire.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<Questionnaire, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "Questionnaire.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<Questionnaire, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "Questionnaire.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Questionnaire, *>> = listOf()

  /**
   * Supported search parameters for the Questionnaire resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
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
