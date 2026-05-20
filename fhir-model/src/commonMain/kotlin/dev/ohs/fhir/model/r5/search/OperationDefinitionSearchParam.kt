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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.OperationDefinition
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [OperationDefinition] resource type. */
public sealed class OperationDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: OperationDefinition): List<T>

  public data object Base : OperationDefinitionSearchParam<Canonical>() {
    public override val paramName: KotlinString = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "OperationDefinition.base"

    public override val target: List<KotlinString> = listOf("OperationDefinition")

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.base)
  }

  public data object Code : OperationDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.code)
  }

  public data object Context : OperationDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(OperationDefinition.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object ContextQuantity : OperationDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(OperationDefinition.useContext.value.ofType(Quantity))"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = emptyList()
  }

  public data object ContextType : OperationDefinitionSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : OperationDefinitionSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "OperationDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : OperationDefinitionSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "OperationDefinition.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : OperationDefinitionSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "OperationDefinition.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : OperationDefinitionSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "OperationDefinition.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier :
    OperationDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: OperationDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object InputProfile : OperationDefinitionSearchParam<Canonical>() {
    public override val paramName: KotlinString = "input-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "OperationDefinition.inputProfile"

    public override val target: List<KotlinString> = listOf("StructureDefinition")

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.inputProfile)
  }

  public data object Instance : OperationDefinitionSearchParam<Boolean>() {
    public override val paramName: KotlinString = "instance"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.instance"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.instance)
  }

  public data object Jurisdiction : OperationDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Kind : OperationDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.kind"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.kind)
  }

  public data object Name : OperationDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "OperationDefinition.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<R5String> =
      listOf(resource.name)
  }

  public data object OutputProfile : OperationDefinitionSearchParam<Canonical>() {
    public override val paramName: KotlinString = "output-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "OperationDefinition.outputProfile"

    public override val target: List<KotlinString> = listOf("StructureDefinition")

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.outputProfile)
  }

  public data object Publisher : OperationDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "OperationDefinition.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : OperationDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.status)
  }

  public data object System : OperationDefinitionSearchParam<Boolean>() {
    public override val paramName: KotlinString = "system"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.system"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.system)
  }

  public data object Title : OperationDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "OperationDefinition.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<R5String> =
      listOfNotNull(resource.title)
  }

  public data object Type : OperationDefinitionSearchParam<Boolean>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.type)
  }

  public data object Url : OperationDefinitionSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "OperationDefinition.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : OperationDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: OperationDefinition): List<R5String> =
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
        Identifier,
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
