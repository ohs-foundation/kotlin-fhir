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

/** Search parameters for the [OperationDefinition] resource type. */
public sealed class OperationDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: OperationDefinition): List<T>

  public data object Base : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OperationDefinition.base"

    public override val target: List<String> = listOf("OperationDefinition")

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Code : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Context : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(OperationDefinition.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(OperationDefinition.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object ContextType : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "OperationDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object ContextTypeValue : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "OperationDefinition.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Date : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "OperationDefinition.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Description : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "OperationDefinition.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object InputProfile : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "input-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OperationDefinition.inputProfile"

    public override val target: List<String> = listOf("StructureDefinition")

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Instance : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "instance"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.instance"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Jurisdiction : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Kind : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.kind"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Name : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "OperationDefinition.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object OutputProfile : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "output-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "OperationDefinition.outputProfile"

    public override val target: List<String> = listOf("StructureDefinition")

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Publisher : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "OperationDefinition.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Status : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object System : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "system"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.system"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Title : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "OperationDefinition.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Type : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Url : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "OperationDefinition.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object Version : OperationDefinitionSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "OperationDefinition.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the OperationDefinition resource type. */
    public val ALL: List<OperationDefinitionSearchParam<*>> =
      listOf(
        Base,
        Code,
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        InputProfile,
        Instance,
        Jurisdiction,
        Kind,
        Name,
        OutputProfile,
        Publisher,
        Status,
        System,
        Title,
        Type,
        Url,
        Version,
      )
  }
}
