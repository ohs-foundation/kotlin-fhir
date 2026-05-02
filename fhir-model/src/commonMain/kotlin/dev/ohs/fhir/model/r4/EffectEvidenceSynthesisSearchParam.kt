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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EffectEvidenceSynthesis] resource type. */
public sealed class EffectEvidenceSynthesisSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: EffectEvidenceSynthesis): List<T>

  public data object Context : EffectEvidenceSynthesisSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(EffectEvidenceSynthesis.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : EffectEvidenceSynthesisSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(EffectEvidenceSynthesis.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : EffectEvidenceSynthesisSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : EffectEvidenceSynthesisSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : EffectEvidenceSynthesisSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<UsageContext> =
      resource.useContext
  }

  public data object Date : EffectEvidenceSynthesisSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : EffectEvidenceSynthesisSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : EffectEvidenceSynthesisSearchParam<Period>() {
    public override val paramName: kotlin.String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.effectivePeriod"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier :
    EffectEvidenceSynthesisSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: EffectEvidenceSynthesis
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Jurisdiction : EffectEvidenceSynthesisSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : EffectEvidenceSynthesisSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : EffectEvidenceSynthesisSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : EffectEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> =
      listOf(resource.status)
  }

  public data object Title : EffectEvidenceSynthesisSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : EffectEvidenceSynthesisSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : EffectEvidenceSynthesisSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "EffectEvidenceSynthesis.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the EffectEvidenceSynthesis resource type. */
    public val ALL: List<EffectEvidenceSynthesisSearchParam<*>> =
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
}
