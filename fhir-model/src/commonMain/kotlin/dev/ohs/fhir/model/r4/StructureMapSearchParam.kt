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

/** Search parameters for the [StructureMap] resource type. */
public sealed class StructureMapSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: StructureMap): List<T>

  public data object Context : StructureMapSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(StructureMap.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : StructureMapSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(StructureMap.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : StructureMapSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureMap.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : StructureMapSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "StructureMap.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : StructureMapSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "StructureMap.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<UsageContext> = resource.useContext
  }

  public data object Date : StructureMapSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "StructureMap.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : StructureMapSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "StructureMap.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : StructureMapSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureMap.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : StructureMapSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureMap.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : StructureMapSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "StructureMap.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<String> = listOf(resource.name)
  }

  public data object Publisher : StructureMapSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "StructureMap.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : StructureMapSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureMap.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<Any> = listOf(resource.status)
  }

  public data object Title : StructureMapSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "StructureMap.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : StructureMapSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "StructureMap.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<Uri> = listOf(resource.url)
  }

  public data object Version : StructureMapSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "StructureMap.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: StructureMap): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the StructureMap resource type. */
    public val ALL: List<StructureMapSearchParam<*>> =
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
