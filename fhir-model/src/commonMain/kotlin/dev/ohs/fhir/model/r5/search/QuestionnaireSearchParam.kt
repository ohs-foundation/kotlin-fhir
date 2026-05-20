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
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Questionnaire
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Questionnaire] resource type. */
public sealed class QuestionnaireSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Questionnaire): List<T>

  public data object ComboCode : QuestionnaireSearchParam<Coding>() {
    public override val paramName: KotlinString = "combo-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Coding> = resource.code
  }

  public data object Context : QuestionnaireSearchParam<Any>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(Questionnaire.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object ContextQuantity : QuestionnaireSearchParam<Any>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(Questionnaire.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object ContextType : QuestionnaireSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : QuestionnaireSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Questionnaire.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : QuestionnaireSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Questionnaire.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<UsageContext> = resource.useContext
  }

  public data object Date : QuestionnaireSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Questionnaire.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Definition : QuestionnaireSearchParam<Uri>() {
    public override val paramName: KotlinString = "definition"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Questionnaire.item.definition"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Uri> =
      resource.item.mapNotNull { it.definition }
  }

  public data object Description : QuestionnaireSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Questionnaire.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : QuestionnaireSearchParam<Period>() {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Questionnaire.effectivePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier : QuestionnaireSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object ItemCode : QuestionnaireSearchParam<Coding>() {
    public override val paramName: KotlinString = "item-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.item.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Coding> =
      resource.item.flatMap { it.code }
  }

  public data object Jurisdiction : QuestionnaireSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : QuestionnaireSearchParam<R5String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Questionnaire.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : QuestionnaireSearchParam<R5String>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Questionnaire.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object QuestionnaireCode : QuestionnaireSearchParam<Coding>() {
    public override val paramName: KotlinString = "questionnaire-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Coding> = resource.code
  }

  public data object Status : QuestionnaireSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = listOf(resource.status)
  }

  public data object SubjectType : QuestionnaireSearchParam<Any>() {
    public override val paramName: KotlinString = "subject-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.subjectType"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = resource.subjectType
  }

  public data object Title : QuestionnaireSearchParam<R5String>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Questionnaire.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Url : QuestionnaireSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Questionnaire.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : QuestionnaireSearchParam<R5String>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Questionnaire): List<R5String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the Questionnaire resource type. */
    public val ALL: List<QuestionnaireSearchParam<*>> =
      listOf(
        ComboCode,
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
        ItemCode,
        Jurisdiction,
        Name,
        Publisher,
        QuestionnaireCode,
        Status,
        SubjectType,
        Title,
        Url,
        Version,
      )
  }
}
