/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NamingSystem] resource type. */
public sealed class NamingSystemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: NamingSystem): List<T>

  public data object Contact : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.contact.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Context : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(NamingSystem.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextQuantity : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(NamingSystem.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextType : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "NamingSystem.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object ContextTypeValue : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "NamingSystem.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Date : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NamingSystem.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Description : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object IdType : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "id-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.uniqueId.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Jurisdiction : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Kind : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.kind"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Name : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Period : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "NamingSystem.uniqueId.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Publisher : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Responsible : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.responsible"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Status : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Telecom : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.contact.telecom"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Type : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "NamingSystem.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public data object Value : NamingSystemSearchParam<Any>() {
    public override val paramName: String = "value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "NamingSystem.uniqueId.value"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the NamingSystem resource type. */
    public val ALL: List<NamingSystemSearchParam<*>> =
      listOf(
        Contact,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        IdType,
        Jurisdiction,
        Kind,
        Name,
        Period,
        Publisher,
        Responsible,
        Status,
        Telecom,
        Type,
        Value,
      )
  }
}
