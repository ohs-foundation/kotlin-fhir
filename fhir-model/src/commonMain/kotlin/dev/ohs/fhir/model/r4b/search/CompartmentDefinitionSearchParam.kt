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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.CompartmentDefinition
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CompartmentDefinition] resource type. */
public sealed class CompartmentDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CompartmentDefinition): List<T>

  public data object Code : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> = listOf(resource.code)
  }

  public data object Context : CompartmentDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(CompartmentDefinition.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : CompartmentDefinitionSearchParam<Quantity>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(CompartmentDefinition.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : CompartmentDefinitionSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : CompartmentDefinitionSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "CompartmentDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : CompartmentDefinitionSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "CompartmentDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : CompartmentDefinitionSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "CompartmentDefinition.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : CompartmentDefinitionSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CompartmentDefinition.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Name : CompartmentDefinitionSearchParam<R4bString>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CompartmentDefinition.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<R4bString> =
      listOf(resource.name)
  }

  public data object Publisher : CompartmentDefinitionSearchParam<R4bString>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CompartmentDefinition.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<R4bString> =
      listOfNotNull(resource.publisher)
  }

  public data object Resource : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.resource.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> =
      resource.resource.map { it.code }
  }

  public data object Status : CompartmentDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Any> =
      listOf(resource.status)
  }

  public data object Url : CompartmentDefinitionSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "CompartmentDefinition.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<Uri> = listOf(resource.url)
  }

  public data object Version : CompartmentDefinitionSearchParam<R4bString>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CompartmentDefinition.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: CompartmentDefinition): List<R4bString> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the CompartmentDefinition resource type. */
    public val ALL: List<CompartmentDefinitionSearchParam<*>> =
      listOf(
        Code,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Name,
        Publisher,
        Resource,
        Status,
        Url,
        Version,
      )
  }
}
