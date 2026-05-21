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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [ValueSet] resource type. */
public object ValueSetSearchParam {
  /** All search parameters for the ValueSet resource type. */
  public val ALL: List<SearchParam<ValueSet, *>> =
    listOf(
      Code,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Expansion,
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Reference,
      Status,
      Title,
      Url,
      Version,
    )

  public data object Code : SearchParam<ValueSet, Any> {
    public override val name: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ValueSet.expansion.contains.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> =
      (resource.expansion?.contains ?: emptyList()).mapNotNull { it.code }
  }

  public data object Context : SearchParam<ValueSet, CodeableConcept> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "(ValueSet.useContext.value as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<ValueSet, Quantity> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(ValueSet.useContext.value as Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<ValueSet, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ValueSet.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<ValueSet, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ValueSet.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<ValueSet, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ValueSet.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<ValueSet, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ValueSet.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<ValueSet, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ValueSet.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Expansion : SearchParam<ValueSet, Uri> {
    public override val name: KotlinString = "expansion"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ValueSet.expansion.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> =
      listOfNotNull(resource.expansion?.identifier)
  }

  public data object Identifier : SearchParam<ValueSet, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ValueSet.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Jurisdiction : SearchParam<ValueSet, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ValueSet.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : SearchParam<ValueSet, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ValueSet.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<R4String> = listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<ValueSet, R4String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ValueSet.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Reference : SearchParam<ValueSet, Uri> {
    public override val name: KotlinString = "reference"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ValueSet.compose.include.system"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> =
      (resource.compose?.include ?: emptyList()).mapNotNull { it.system }
  }

  public data object Status : SearchParam<ValueSet, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ValueSet.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<ValueSet, R4String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ValueSet.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<R4String> = listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<ValueSet, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "ValueSet.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<ValueSet, R4String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ValueSet.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ValueSet): List<R4String> =
      listOfNotNull(resource.version)
  }
}
