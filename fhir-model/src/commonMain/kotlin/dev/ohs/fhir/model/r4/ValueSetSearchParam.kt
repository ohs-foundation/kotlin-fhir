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

/** Search parameters for the [ValueSet] resource type. */
public sealed class ValueSetSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ValueSet): List<T>

  public data object Code : ValueSetSearchParam<Any>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.expansion.contains.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> =
      (resource.expansion?.contains ?: emptyList()).mapNotNull { it.code }
  }

  public data object Context : ValueSetSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "(ValueSet.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : ValueSetSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(ValueSet.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : ValueSetSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ValueSetSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ValueSet.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : ValueSetSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ValueSet.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<UsageContext> = resource.useContext
  }

  public data object Date : ValueSetSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ValueSet.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : ValueSetSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ValueSet.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Expansion : ValueSetSearchParam<Uri>() {
    public override val paramName: kotlin.String = "expansion"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ValueSet.expansion.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> =
      listOfNotNull(resource.expansion?.identifier)
  }

  public data object Identifier : ValueSetSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : ValueSetSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : ValueSetSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ValueSet.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<String> = listOfNotNull(resource.name)
  }

  public data object Publisher : ValueSetSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ValueSet.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Reference : ValueSetSearchParam<Uri>() {
    public override val paramName: kotlin.String = "reference"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ValueSet.compose.include.system"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> =
      (resource.compose?.include ?: emptyList()).mapNotNull { it.system }
  }

  public data object Status : ValueSetSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = listOf(resource.status)
  }

  public data object Title : ValueSetSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ValueSet.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<String> = listOfNotNull(resource.title)
  }

  public data object Url : ValueSetSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "ValueSet.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : ValueSetSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ValueSet.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ValueSet): List<String> = listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the ValueSet resource type. */
    public val ALL: List<ValueSetSearchParam<*>> =
      listOf(
        Code,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Expansion,
        Identifier,
        Jurisdiction,
        Name,
        Publisher,
        Reference,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
