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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EvidenceVariable] resource type. */
public sealed class EvidenceVariableSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: EvidenceVariable): List<T>

  public data object Context : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(EvidenceVariable.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object ContextQuantity : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(EvidenceVariable.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object ContextType : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EvidenceVariable.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "EvidenceVariable.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object ContextTypeValue : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "EvidenceVariable.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Date : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "EvidenceVariable.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Description : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EvidenceVariable.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Identifier : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EvidenceVariable.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Name : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EvidenceVariable.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Publisher : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EvidenceVariable.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Status : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EvidenceVariable.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Title : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "EvidenceVariable.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Url : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "EvidenceVariable.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public data object Version : EvidenceVariableSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EvidenceVariable.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the EvidenceVariable resource type. */
    public val ALL: List<EvidenceVariableSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Identifier,
        Name,
        Publisher,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
