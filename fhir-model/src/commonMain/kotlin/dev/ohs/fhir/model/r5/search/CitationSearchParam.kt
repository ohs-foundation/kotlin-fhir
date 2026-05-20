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

import dev.ohs.fhir.model.r5.Citation
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Citation] resource type. */
public sealed class CitationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Citation): List<T>

  public data object Classification : CitationSearchParam<Citation.Classification>() {
    public override val paramName: KotlinString = "classification"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Citation.classification"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Citation.Classification> =
      resource.classification
  }

  public data object ClassificationType : CitationSearchParam<Any>() {
    public override val paramName: KotlinString = "classification-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Citation.classification.type)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Classifier : CitationSearchParam<Any>() {
    public override val paramName: KotlinString = "classifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(Citation.classification.classifier)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object Context : CitationSearchParam<Any>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(Citation.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object ContextQuantity : CitationSearchParam<Any>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(Citation.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Any> = emptyList()
  }

  public data object ContextType : CitationSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Citation.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : CitationSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Citation.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : CitationSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Citation.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<UsageContext> = resource.useContext
  }

  public data object Date : CitationSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Citation.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : CitationSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Citation.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : CitationSearchParam<Period>() {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Citation.effectivePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier : CitationSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Citation.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : CitationSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Citation.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : CitationSearchParam<R5String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Citation.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<R5String> = listOfNotNull(resource.name)
  }

  public data object Publisher : CitationSearchParam<R5String>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Citation.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : CitationSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Citation.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Any> = listOf(resource.status)
  }

  public data object Title : CitationSearchParam<R5String>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Citation.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<R5String> = listOfNotNull(resource.title)
  }

  public data object Url : CitationSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Citation.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : CitationSearchParam<R5String>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Citation.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Citation): List<R5String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the Citation resource type. */
    public val ALL: List<CitationSearchParam<*>> =
      listOf(
        Classification,
        ClassificationType,
        Classifier,
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
}
