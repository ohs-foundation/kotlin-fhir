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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Evidence] resource type. */
public sealed class EvidenceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Evidence): List<T>

  public data object Context : EvidenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(Evidence.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<Any> = emptyList()
  }

  public data object ContextQuantity : EvidenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(Evidence.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<Any> = emptyList()
  }

  public data object ContextType : EvidenceSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Evidence.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : EvidenceSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Evidence.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : EvidenceSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Evidence.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<UsageContext> = resource.useContext
  }

  public data object Date : EvidenceSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Evidence.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : EvidenceSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Evidence.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : EvidenceSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Evidence.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Publisher : EvidenceSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Evidence.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : EvidenceSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Evidence.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<Any> = listOf(resource.status)
  }

  public data object Title : EvidenceSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Evidence.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<String> = listOfNotNull(resource.title)
  }

  public data object Url : EvidenceSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "Evidence.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : EvidenceSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Evidence.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Evidence): List<String> = listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the Evidence resource type. */
    public val ALL: List<EvidenceSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Identifier,
        Publisher,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
