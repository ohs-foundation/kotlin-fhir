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
public object QuestionnaireSearchParam {
  public val Code: SearchParam<Questionnaire, Coding> =
    SimpleSearchParam<Questionnaire, Coding>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.item.code",
      extractor = { resource -> resource.item.flatMap { it.code } },
    )

  public val Context: SearchParam<Questionnaire, CodeableConcept> =
    SimpleSearchParam<Questionnaire, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(Questionnaire.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
      },
    )

  public val ContextQuantity: SearchParam<Questionnaire, Quantity> =
    SimpleSearchParam<Questionnaire, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Questionnaire.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<Questionnaire, Coding> =
    SimpleSearchParam<Questionnaire, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<Questionnaire, UsageContext> =
    SimpleSearchParam<Questionnaire, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Questionnaire.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<Questionnaire, UsageContext> =
    SimpleSearchParam<Questionnaire, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Questionnaire.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<Questionnaire, DateTime> =
    SimpleSearchParam<Questionnaire, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Questionnaire.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Definition: SearchParam<Questionnaire, Uri> =
    SimpleSearchParam<Questionnaire, Uri>(
      name = "definition",
      type = SearchParamType.fromCode("uri"),
      expression = "Questionnaire.item.definition",
      extractor = { resource -> resource.item.mapNotNull { it.definition } },
    )

  public val Description: SearchParam<Questionnaire, Markdown> =
    SimpleSearchParam<Questionnaire, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Effective: SearchParam<Questionnaire, Period> =
    SimpleSearchParam<Questionnaire, Period>(
      name = "effective",
      type = SearchParamType.fromCode("date"),
      expression = "Questionnaire.effectivePeriod",
      extractor = { resource -> listOfNotNull(resource.effectivePeriod) },
    )

  public val Identifier: SearchParam<Questionnaire, Identifier> =
    SimpleSearchParam<Questionnaire, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<Questionnaire, CodeableConcept> =
    SimpleSearchParam<Questionnaire, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<Questionnaire, String> =
    SimpleSearchParam<Questionnaire, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<Questionnaire, String> =
    SimpleSearchParam<Questionnaire, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<Questionnaire, Any> =
    SimpleSearchParam<Questionnaire, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val SubjectType: SearchParam<Questionnaire, Any> =
    SimpleSearchParam<Questionnaire, Any>(
      name = "subject-type",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.subjectType",
      extractor = { resource -> resource.subjectType },
    )

  public val Title: SearchParam<Questionnaire, String> =
    SimpleSearchParam<Questionnaire, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "Questionnaire.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<Questionnaire, Uri> =
    SimpleSearchParam<Questionnaire, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Questionnaire.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<Questionnaire, String> =
    SimpleSearchParam<Questionnaire, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "Questionnaire.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the Questionnaire resource type. */
  public val ALL: List<SearchParam<Questionnaire, *>> =
    listOf(
      Code,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Definition,
      Description,
      Effective,
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Status,
      SubjectType,
      Title,
      Url,
      Version,
    )
}
