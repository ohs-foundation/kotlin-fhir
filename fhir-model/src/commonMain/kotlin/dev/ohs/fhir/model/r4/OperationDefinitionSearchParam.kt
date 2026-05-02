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

/** Search parameters for the [OperationDefinition] resource type. */
public sealed class OperationDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: OperationDefinition): List<T>

  public data object Base : OperationDefinitionSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "OperationDefinition.base"

    public override val target: List<kotlin.String> = listOf("OperationDefinition")

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.base)
  }

  public data object Code : OperationDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.code)
  }

  public data object Context : OperationDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(OperationDefinition.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : OperationDefinitionSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(OperationDefinition.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : OperationDefinitionSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : OperationDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "OperationDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : OperationDefinitionSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "OperationDefinition.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : OperationDefinitionSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "OperationDefinition.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : OperationDefinitionSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "OperationDefinition.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object InputProfile : OperationDefinitionSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "input-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "OperationDefinition.inputProfile"

    public override val target: List<kotlin.String> = listOf("StructureDefinition")

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.inputProfile)
  }

  public data object Instance : OperationDefinitionSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "instance"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.instance"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.instance)
  }

  public data object Jurisdiction : OperationDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Kind : OperationDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.kind"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.kind)
  }

  public data object Name : OperationDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "OperationDefinition.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<String> = listOf(resource.name)
  }

  public data object OutputProfile : OperationDefinitionSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "output-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "OperationDefinition.outputProfile"

    public override val target: List<kotlin.String> = listOf("StructureDefinition")

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.outputProfile)
  }

  public data object Publisher : OperationDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "OperationDefinition.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : OperationDefinitionSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.status)
  }

  public data object System : OperationDefinitionSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "system"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.system"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.system)
  }

  public data object Title : OperationDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "OperationDefinition.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Type : OperationDefinitionSearchParam<Boolean>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.type)
  }

  public data object Url : OperationDefinitionSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "OperationDefinition.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : OperationDefinitionSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "OperationDefinition.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: OperationDefinition): List<String> =
      listOfNotNull(resource.version)
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
