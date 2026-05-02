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

/** Search parameters for the [Requirements] resource type. */
public sealed class RequirementsSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Requirements): List<T>

  public data object Actor : RequirementsSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Requirements.actor"

    public override val target: List<kotlin.String> = listOf("ActorDefinition")

    public override fun extract(resource: Requirements): List<Canonical> = resource.actor
  }

  public data object Context : RequirementsSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(Requirements.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object ContextQuantity : RequirementsSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(Requirements.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = emptyList()
  }

  public data object ContextType : RequirementsSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Requirements.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : RequirementsSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Requirements.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : RequirementsSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Requirements.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<UsageContext> = resource.useContext
  }

  public data object Date : RequirementsSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Requirements.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object DerivedFrom : RequirementsSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "derived-from"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Requirements.derivedFrom"

    public override val target: List<kotlin.String> = listOf("Requirements")

    public override fun extract(resource: Requirements): List<Canonical> = resource.derivedFrom
  }

  public data object Description : RequirementsSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Requirements.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : RequirementsSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Requirements.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : RequirementsSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Requirements.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : RequirementsSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Requirements.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<String> = listOfNotNull(resource.name)
  }

  public data object Publisher : RequirementsSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Requirements.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : RequirementsSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Requirements.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<Any> = listOf(resource.status)
  }

  public data object Title : RequirementsSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Requirements.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : RequirementsSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "Requirements.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : RequirementsSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Requirements.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Requirements): List<String> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the Requirements resource type. */
    public val ALL: List<RequirementsSearchParam<*>> =
      listOf(
        Actor,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        DerivedFrom,
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
