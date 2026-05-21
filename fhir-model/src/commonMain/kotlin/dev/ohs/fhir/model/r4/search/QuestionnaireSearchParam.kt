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
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Questionnaire
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Questionnaire] resource type. */
public object QuestionnaireSearchParam {
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

  public data object Code : SearchParam<Questionnaire, Coding> {
    public override val name: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.item.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Coding> =
      resource.item.flatMap { it.code }
  }

  public data object Context : SearchParam<Questionnaire, CodeableConcept> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(Questionnaire.useContext.value as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<Questionnaire, Quantity> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Questionnaire.useContext.value as Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<Questionnaire, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<Questionnaire, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Questionnaire.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<Questionnaire, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Questionnaire.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<Questionnaire, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Questionnaire.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Definition : SearchParam<Questionnaire, Uri> {
    public override val name: KotlinString = "definition"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Questionnaire.item.definition"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Uri> =
      resource.item.mapNotNull { it.definition }
  }

  public data object Description : SearchParam<Questionnaire, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Questionnaire.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : SearchParam<Questionnaire, Period> {
    public override val name: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Questionnaire.effectivePeriod"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier : SearchParam<Questionnaire, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<Questionnaire, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<Questionnaire, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Questionnaire.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<Questionnaire, R4String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Questionnaire.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<Questionnaire, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = listOf(resource.status)
  }

  public data object SubjectType : SearchParam<Questionnaire, Any> {
    public override val name: KotlinString = "subject-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.subjectType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Any> = resource.subjectType
  }

  public data object Title : SearchParam<Questionnaire, R4String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Questionnaire.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<Questionnaire, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Questionnaire.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<Questionnaire, R4String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Questionnaire.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Questionnaire): List<R4String> =
      listOfNotNull(resource.version)
  }
}
