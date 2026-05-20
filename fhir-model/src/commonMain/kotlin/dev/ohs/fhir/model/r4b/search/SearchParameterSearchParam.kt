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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.SearchParameter
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [SearchParameter] resource type. */
public object SearchParameterSearchParam {
  /** All search parameters for the SearchParameter resource type. */
  public val ALL: List<SearchParam<SearchParameter, *>> =
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

  public data object Base : SearchParam<SearchParameter, Any> {
    public override val paramName: KotlinString = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SearchParameter.base"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = resource.base
  }

  public data object Code : SearchParam<SearchParameter, Any> {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SearchParameter.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = listOf(resource.code)
  }

  public data object Component : SearchParam<SearchParameter, Canonical> {
    public override val paramName: KotlinString = "component"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "SearchParameter.component.definition"

    public override val target: List<KotlinString> = listOf("SearchParameter")

    public override fun extract(resource: SearchParameter): List<Canonical> =
      resource.component.map { it.definition }
  }

  public data object Context : SearchParam<SearchParameter, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(SearchParameter.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<SearchParameter, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(SearchParameter.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<SearchParameter, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SearchParameter.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<SearchParameter, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "SearchParameter.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<SearchParameter, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "SearchParameter.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<SearchParameter, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "SearchParameter.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DerivedFrom : SearchParam<SearchParameter, Canonical> {
    public override val paramName: KotlinString = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "SearchParameter.derivedFrom"

    public override val target: List<KotlinString> = listOf("SearchParameter")

    public override fun extract(resource: SearchParameter): List<Canonical> =
      listOfNotNull(resource.derivedFrom)
  }

  public data object Description : SearchParam<SearchParameter, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SearchParameter.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Markdown> =
      listOf(resource.description)
  }

  public data object Jurisdiction : SearchParam<SearchParameter, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SearchParameter.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<SearchParameter, R4bString> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SearchParameter.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<R4bString> = listOf(resource.name)
  }

  public data object Publisher : SearchParam<SearchParameter, R4bString> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "SearchParameter.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<R4bString> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<SearchParameter, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SearchParameter.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = listOf(resource.status)
  }

  public data object Target : SearchParam<SearchParameter, Any> {
    public override val paramName: KotlinString = "target"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SearchParameter.target"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = resource.target
  }

  public data object Type : SearchParam<SearchParameter, Any> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SearchParameter.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Any> = listOf(resource.type)
  }

  public data object Url : SearchParam<SearchParameter, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "SearchParameter.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<Uri> = listOf(resource.url)
  }

  public data object Version : SearchParam<SearchParameter, R4bString> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "SearchParameter.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: SearchParameter): List<R4bString> =
      listOfNotNull(resource.version)
  }
}
