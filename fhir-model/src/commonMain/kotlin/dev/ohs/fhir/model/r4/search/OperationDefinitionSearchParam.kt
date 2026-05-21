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

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.OperationDefinition
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.StructureDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [OperationDefinition] resource type. */
public object OperationDefinitionSearchParam {
  /** All search parameters for the OperationDefinition resource type. */
  public val ALL: List<SearchParam<OperationDefinition, *>> =
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

  public data object Base : SearchParam<OperationDefinition, Canonical> {
    public override val name: KotlinString = "base"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "OperationDefinition.base"

    public override val target: List<KClass<out Resource>> = listOf(OperationDefinition::class)

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.base)
  }

  public data object Code : SearchParam<OperationDefinition, Any> {
    public override val name: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.code)
  }

  public data object Context : SearchParam<OperationDefinition, CodeableConcept> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(OperationDefinition.useContext.value as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<OperationDefinition, Quantity> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(OperationDefinition.useContext.value as Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<OperationDefinition, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<OperationDefinition, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "OperationDefinition.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<OperationDefinition, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "OperationDefinition.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<OperationDefinition, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "OperationDefinition.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<OperationDefinition, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "OperationDefinition.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object InputProfile : SearchParam<OperationDefinition, Canonical> {
    public override val name: KotlinString = "input-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "OperationDefinition.inputProfile"

    public override val target: List<KClass<out Resource>> = listOf(StructureDefinition::class)

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.inputProfile)
  }

  public data object Instance : SearchParam<OperationDefinition, Boolean> {
    public override val name: KotlinString = "instance"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.instance"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.instance)
  }

  public data object Jurisdiction : SearchParam<OperationDefinition, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Kind : SearchParam<OperationDefinition, Any> {
    public override val name: KotlinString = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.kind"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.kind)
  }

  public data object Name : SearchParam<OperationDefinition, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "OperationDefinition.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<R4String> =
      listOf(resource.name)
  }

  public data object OutputProfile : SearchParam<OperationDefinition, Canonical> {
    public override val name: KotlinString = "output-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "OperationDefinition.outputProfile"

    public override val target: List<KClass<out Resource>> = listOf(StructureDefinition::class)

    public override fun extract(resource: OperationDefinition): List<Canonical> =
      listOfNotNull(resource.outputProfile)
  }

  public data object Publisher : SearchParam<OperationDefinition, R4String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "OperationDefinition.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<OperationDefinition, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Any> = listOf(resource.status)
  }

  public data object System : SearchParam<OperationDefinition, Boolean> {
    public override val name: KotlinString = "system"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.system"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.system)
  }

  public data object Title : SearchParam<OperationDefinition, R4String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "OperationDefinition.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Type : SearchParam<OperationDefinition, Boolean> {
    public override val name: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Boolean> =
      listOf(resource.type)
  }

  public data object Url : SearchParam<OperationDefinition, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "OperationDefinition.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<OperationDefinition, R4String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "OperationDefinition.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: OperationDefinition): List<R4String> =
      listOfNotNull(resource.version)
  }
}
