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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EvidenceReport] resource type. */
public sealed class EvidenceReportSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: EvidenceReport): List<T>

  public data object Context : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(EvidenceReport.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object ContextQuantity : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(EvidenceReport.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object ContextType : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EvidenceReport.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "EvidenceReport.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object ContextTypeValue : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "EvidenceReport.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object Identifier : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EvidenceReport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object Publisher : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EvidenceReport.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object Status : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EvidenceReport.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object Url : EvidenceReportSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "EvidenceReport.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the EvidenceReport resource type. */
    public val ALL: List<EvidenceReportSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Identifier,
        Publisher,
        Status,
        Url,
      )
  }
}
