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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.StructureMap
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [StructureMap] resource type. */
public sealed class StructureMapSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: StructureMap): List<T>

  public data object Context : StructureMapSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(StructureMap.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : StructureMapSearchParam<Quantity>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(StructureMap.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : StructureMapSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : StructureMapSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "StructureMap.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : StructureMapSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "StructureMap.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<UsageContext> = resource.useContext
  }

  public data object Date : StructureMapSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "StructureMap.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : StructureMapSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureMap.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : StructureMapSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : StructureMapSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : StructureMapSearchParam<R4String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureMap.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<R4String> = listOf(resource.name)
  }

  public data object Publisher : StructureMapSearchParam<R4String>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureMap.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : StructureMapSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<Any> = listOf(resource.status)
  }

  public data object Title : StructureMapSearchParam<R4String>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "StructureMap.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : StructureMapSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "StructureMap.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<Uri> = listOf(resource.url)
  }

  public data object Version : StructureMapSearchParam<R4String>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "StructureMap.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: StructureMap): List<R4String> =
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
