/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Questionnaire] resource type. */
public sealed class QuestionnaireSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Questionnaire): List<T>

  public data object Code : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Questionnaire.item.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Context : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(Questionnaire.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object ContextQuantity : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(Questionnaire.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object ContextType : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Questionnaire.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Questionnaire.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object ContextTypeValue : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Questionnaire.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Date : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Questionnaire.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Definition : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "definition"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Questionnaire.item.definition"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Description : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Questionnaire.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Effective : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Questionnaire.effectivePeriod"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Identifier : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Questionnaire.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Jurisdiction : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Questionnaire.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Name : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Questionnaire.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Publisher : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Questionnaire.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Status : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Questionnaire.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object SubjectType : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "subject-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Questionnaire.subjectType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Title : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Questionnaire.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Url : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Questionnaire.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public data object Version : QuestionnaireSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Questionnaire.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Questionnaire resource type. */
    public val ALL: List<QuestionnaireSearchParam<*>> =
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
}
