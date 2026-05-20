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

import dev.ohs.fhir.model.r4.ChargeItemDefinition
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ChargeItemDefinition] resource type. */
public object ChargeItemDefinitionSearchParam {
  /** All search parameters for the ChargeItemDefinition resource type. */
  public val ALL: List<SearchParam<ChargeItemDefinition, *>> =
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

  public data object Context : SearchParam<ChargeItemDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(ChargeItemDefinition.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<ChargeItemDefinition, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(ChargeItemDefinition.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<ChargeItemDefinition, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ChargeItemDefinition, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ChargeItemDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ChargeItemDefinition, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ChargeItemDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<ChargeItemDefinition, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ChargeItemDefinition.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<ChargeItemDefinition, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ChargeItemDefinition.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : SearchParam<ChargeItemDefinition, Period> {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ChargeItemDefinition.effectivePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier :
    SearchParam<ChargeItemDefinition, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: ChargeItemDefinition
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Jurisdiction : SearchParam<ChargeItemDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Publisher : SearchParam<ChargeItemDefinition, R4String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ChargeItemDefinition.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<ChargeItemDefinition, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<ChargeItemDefinition, R4String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ChargeItemDefinition.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<ChargeItemDefinition, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ChargeItemDefinition.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<Uri> = listOf(resource.url)
  }

  public data object Version : SearchParam<ChargeItemDefinition, R4String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ChargeItemDefinition.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ChargeItemDefinition): List<R4String> =
      listOfNotNull(resource.version)
  }
}
