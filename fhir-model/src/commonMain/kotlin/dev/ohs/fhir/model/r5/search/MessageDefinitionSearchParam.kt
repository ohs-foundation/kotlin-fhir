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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MessageDefinition
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MessageDefinition] resource type. */
public object MessageDefinitionSearchParam {
  /** All search parameters for the MessageDefinition resource type. */
  public val ALL: List<SearchParam<MessageDefinition, *>> =
    listOf(
      Category,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Event,
      Focus,
      Identifier,
      Jurisdiction,
      Name,
      Parent,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )

  public data object Category : SearchParam<MessageDefinition, Any> {
    public override val paramName: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageDefinition.category"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> =
      listOfNotNull(resource.category)
  }

  public data object Context : SearchParam<MessageDefinition, Any> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(MessageDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<MessageDefinition, Any> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(MessageDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<MessageDefinition, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageDefinition.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<MessageDefinition, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "MessageDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<MessageDefinition, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "MessageDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<MessageDefinition, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "MessageDefinition.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<DateTime> = listOf(resource.date)
  }

  public data object Description : SearchParam<MessageDefinition, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MessageDefinition.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Event : SearchParam<MessageDefinition, Any> {
    public override val paramName: KotlinString = "event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageDefinition.event.ofType(Coding)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = emptyList()
  }

  public data object Focus : SearchParam<MessageDefinition, Any> {
    public override val paramName: KotlinString = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageDefinition.focus.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> =
      resource.focus.map { it.code }
  }

  public data object Identifier : SearchParam<MessageDefinition, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: MessageDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Jurisdiction : SearchParam<MessageDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageDefinition.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<MessageDefinition, R5String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MessageDefinition.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Parent : SearchParam<MessageDefinition, Canonical> {
    public override val paramName: KotlinString = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MessageDefinition.parent"

    public override val target: List<KotlinString> = listOf("ActivityDefinition", "PlanDefinition")

    public override fun extract(resource: MessageDefinition): List<Canonical> = resource.parent
  }

  public data object Publisher : SearchParam<MessageDefinition, R5String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MessageDefinition.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<MessageDefinition, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<MessageDefinition, R5String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MessageDefinition.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<MessageDefinition, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "MessageDefinition.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<MessageDefinition, R5String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MessageDefinition.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MessageDefinition): List<R5String> =
      listOfNotNull(resource.version)
  }
}
