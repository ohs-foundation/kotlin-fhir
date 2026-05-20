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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.ChargeItemDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ChargeItemDefinition] resource type. */
public sealed class ChargeItemDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ChargeItemDefinition): List<T>

  public data object Context : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ChargeItemDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(ChargeItemDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = emptyList()
  }

  public data object ContextType : ChargeItemDefinitionSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : ChargeItemDefinitionSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ChargeItemDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : ChargeItemDefinitionSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ChargeItemDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : ChargeItemDefinitionSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ChargeItemDefinition.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : ChargeItemDefinitionSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ChargeItemDefinition.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : ChargeItemDefinitionSearchParam<Period>() {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString =
      "ChargeItemDefinition.applicability.effectivePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Period> =
      resource.applicability.mapNotNull { it.effectivePeriod }
  }

  public data object Identifier :
    ChargeItemDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: ChargeItemDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Jurisdiction : ChargeItemDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Publisher : ChargeItemDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ChargeItemDefinition.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : ChargeItemDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : ChargeItemDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ChargeItemDefinition.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Url : ChargeItemDefinitionSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ChargeItemDefinition.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : ChargeItemDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<R5String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the ChargeItemDefinition resource type. */
    public val ALL: List<ChargeItemDefinitionSearchParam<*>> =
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
        Publisher,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
