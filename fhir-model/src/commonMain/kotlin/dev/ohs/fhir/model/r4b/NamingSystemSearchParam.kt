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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NamingSystem] resource type. */
public sealed class NamingSystemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: NamingSystem): List<T>

  public data object Contact : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.contact.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      resource.contact.mapNotNull { it.name }
  }

  public data object Context : NamingSystemSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(NamingSystem.useContext.value as CodeableConcept)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : NamingSystemSearchParam<Quantity>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String = "(NamingSystem.useContext.value as Quantity)"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : NamingSystemSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : NamingSystemSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "NamingSystem.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : NamingSystemSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "NamingSystem.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<UsageContext> = resource.useContext
  }

  public data object Date : NamingSystemSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "NamingSystem.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<DateTime> = listOf(resource.date)
  }

  public data object Description : NamingSystemSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object IdType : NamingSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "id-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.uniqueId.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> =
      resource.uniqueId.map { it.type }
  }

  public data object Jurisdiction : NamingSystemSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Kind : NamingSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.kind"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = listOf(resource.kind)
  }

  public data object Name : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> = listOf(resource.name)
  }

  public data object Period : NamingSystemSearchParam<dev.ohs.fhir.model.r4b.Period>() {
    public override val paramName: kotlin.String = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "NamingSystem.uniqueId.period"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<dev.ohs.fhir.model.r4b.Period> =
      resource.uniqueId.mapNotNull { it.period }
  }

  public data object Publisher : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Responsible : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.responsible"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      listOfNotNull(resource.responsible)
  }

  public data object Status : NamingSystemSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = listOf(resource.status)
  }

  public data object Telecom : NamingSystemSearchParam<ContactPoint>() {
    public override val paramName: kotlin.String = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.contact.telecom"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<ContactPoint> =
      resource.contact.flatMap { it.telecom }
  }

  public data object Type : NamingSystemSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "NamingSystem.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Value : NamingSystemSearchParam<String>() {
    public override val paramName: kotlin.String = "value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "NamingSystem.uniqueId.value"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: NamingSystem): List<String> =
      resource.uniqueId.map { it.value }
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
