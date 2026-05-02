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

/** Search parameters for the [TerminologyCapabilities] resource type. */
public sealed class TerminologyCapabilitiesSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: TerminologyCapabilities): List<T>

  public data object Context : TerminologyCapabilitiesSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(TerminologyCapabilities.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Any> = emptyList()
  }

  public data object ContextQuantity : TerminologyCapabilitiesSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(TerminologyCapabilities.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Any> = emptyList()
  }

  public data object ContextType : TerminologyCapabilitiesSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TerminologyCapabilities.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : TerminologyCapabilitiesSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "TerminologyCapabilities.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : TerminologyCapabilitiesSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "TerminologyCapabilities.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<UsageContext> =
      resource.useContext
  }

  public data object Date : TerminologyCapabilitiesSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "TerminologyCapabilities.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<DateTime> =
      listOf(resource.date)
  }

  public data object Description : TerminologyCapabilitiesSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TerminologyCapabilities.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier :
    TerminologyCapabilitiesSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TerminologyCapabilities.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: TerminologyCapabilities
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Jurisdiction : TerminologyCapabilitiesSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TerminologyCapabilities.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : TerminologyCapabilitiesSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TerminologyCapabilities.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : TerminologyCapabilitiesSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TerminologyCapabilities.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : TerminologyCapabilitiesSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TerminologyCapabilities.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Any> =
      listOf(resource.status)
  }

  public data object Title : TerminologyCapabilitiesSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "TerminologyCapabilities.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : TerminologyCapabilitiesSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "TerminologyCapabilities.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : TerminologyCapabilitiesSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "TerminologyCapabilities.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the TerminologyCapabilities resource type. */
    public val ALL: List<TerminologyCapabilitiesSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
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
