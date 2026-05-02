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

/** Search parameters for the [RiskEvidenceSynthesis] resource type. */
public sealed class RiskEvidenceSynthesisSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: RiskEvidenceSynthesis): List<T>

  public data object Context : RiskEvidenceSynthesisSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(RiskEvidenceSynthesis.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : RiskEvidenceSynthesisSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(RiskEvidenceSynthesis.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : RiskEvidenceSynthesisSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : RiskEvidenceSynthesisSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : RiskEvidenceSynthesisSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<UsageContext> =
      resource.useContext
  }

  public data object Date : RiskEvidenceSynthesisSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : RiskEvidenceSynthesisSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : RiskEvidenceSynthesisSearchParam<Period>() {
    public override val paramName: kotlin.String = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.effectivePeriod"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier :
    RiskEvidenceSynthesisSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: RiskEvidenceSynthesis
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Jurisdiction : RiskEvidenceSynthesisSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : RiskEvidenceSynthesisSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : RiskEvidenceSynthesisSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : RiskEvidenceSynthesisSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> =
      listOf(resource.status)
  }

  public data object Title : RiskEvidenceSynthesisSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : RiskEvidenceSynthesisSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : RiskEvidenceSynthesisSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "RiskEvidenceSynthesis.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the RiskEvidenceSynthesis resource type. */
    public val ALL: List<RiskEvidenceSynthesisSearchParam<*>> =
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
