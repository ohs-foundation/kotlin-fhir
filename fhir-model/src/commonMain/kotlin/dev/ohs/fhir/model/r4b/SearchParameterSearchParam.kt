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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SearchParameter] resource type. */
public sealed class SearchParameterSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: SearchParameter): List<T>

  public data object Base : SearchParameterSearchParam<Any>() {
    public override val paramName: kotlin.String = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SearchParameter.base"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = resource.base
  }

  public data object Code : SearchParameterSearchParam<Any>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SearchParameter.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = listOf(resource.code)
  }

  public data object Component : SearchParameterSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "component"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "SearchParameter.component.definition"

    public override val target: List<kotlin.String> = listOf("SearchParameter")

    public override fun extract(resource: SearchParameter): List<Canonical> =
      resource.component.map { it.definition }
  }

  public data object Context : SearchParameterSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(SearchParameter.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParameterSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(SearchParameter.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParameterSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SearchParameter.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParameterSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "SearchParameter.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParameterSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "SearchParameter.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParameterSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "SearchParameter.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DerivedFrom : SearchParameterSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "SearchParameter.derivedFrom"

    public override val target: List<kotlin.String> = listOf("SearchParameter")

    public override fun extract(resource: SearchParameter): List<Canonical> =
      listOfNotNull(resource.derivedFrom)
  }

  public data object Description : SearchParameterSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "SearchParameter.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Markdown> =
      listOf(resource.description)
  }

  public data object Jurisdiction : SearchParameterSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SearchParameter.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParameterSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "SearchParameter.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<String> = listOf(resource.name)
  }

  public data object Publisher : SearchParameterSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "SearchParameter.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParameterSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SearchParameter.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = listOf(resource.status)
  }

  public data object Target : SearchParameterSearchParam<Any>() {
    public override val paramName: kotlin.String = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SearchParameter.target"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = resource.target
  }

  public data object Type : SearchParameterSearchParam<Any>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SearchParameter.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = listOf(resource.type)
  }

  public data object Url : SearchParameterSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "SearchParameter.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<Uri> = listOf(resource.url)
  }

  public data object Version : SearchParameterSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "SearchParameter.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: SearchParameter): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the SearchParameter resource type. */
    public val ALL: List<SearchParameterSearchParam<*>> =
      listOf(
        Base,
        Code,
        Component,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        DerivedFrom,
        Description,
        Jurisdiction,
        Name,
        Publisher,
        Status,
        Target,
        Type,
        Url,
        Version,
      )
  }
}
