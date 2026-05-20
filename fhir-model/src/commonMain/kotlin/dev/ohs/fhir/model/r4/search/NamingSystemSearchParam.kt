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
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.NamingSystem
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NamingSystem] resource type. */
public object NamingSystemSearchParam {
  /** All search parameters for the NamingSystem resource type. */
  public val ALL: List<SearchParam<NamingSystem, *>> =
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

  public data object Contact : SearchParam<NamingSystem, R4String> {
    public override val paramName: KotlinString = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "NamingSystem.contact.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<R4String> =
      resource.contact.mapNotNull { it.name }
  }

  public data object Context : SearchParam<NamingSystem, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(NamingSystem.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<NamingSystem, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(NamingSystem.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<NamingSystem, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NamingSystem.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<NamingSystem, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "NamingSystem.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<NamingSystem, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "NamingSystem.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<NamingSystem, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "NamingSystem.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<DateTime> = listOf(resource.date)
  }

  public data object Description : SearchParam<NamingSystem, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "NamingSystem.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object IdType : SearchParam<NamingSystem, Any> {
    public override val paramName: KotlinString = "id-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NamingSystem.uniqueId.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> =
      resource.uniqueId.map { it.type }
  }

  public data object Jurisdiction : SearchParam<NamingSystem, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NamingSystem.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Kind : SearchParam<NamingSystem, Any> {
    public override val paramName: KotlinString = "kind"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NamingSystem.kind"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = listOf(resource.kind)
  }

  public data object Name : SearchParam<NamingSystem, R4String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "NamingSystem.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<R4String> = listOf(resource.name)
  }

  public data object Period : SearchParam<NamingSystem, dev.ohs.fhir.model.r4.Period> {
    public override val paramName: KotlinString = "period"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "NamingSystem.uniqueId.period"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<dev.ohs.fhir.model.r4.Period> =
      resource.uniqueId.mapNotNull { it.period }
  }

  public data object Publisher : SearchParam<NamingSystem, R4String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "NamingSystem.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Responsible : SearchParam<NamingSystem, R4String> {
    public override val paramName: KotlinString = "responsible"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "NamingSystem.responsible"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<R4String> =
      listOfNotNull(resource.responsible)
  }

  public data object Status : SearchParam<NamingSystem, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NamingSystem.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<Any> = listOf(resource.status)
  }

  public data object Telecom : SearchParam<NamingSystem, ContactPoint> {
    public override val paramName: KotlinString = "telecom"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NamingSystem.contact.telecom"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<ContactPoint> =
      resource.contact.flatMap { it.telecom }
  }

  public data object Type : SearchParam<NamingSystem, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "NamingSystem.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Value : SearchParam<NamingSystem, R4String> {
    public override val paramName: KotlinString = "value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "NamingSystem.uniqueId.value"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: NamingSystem): List<R4String> =
      resource.uniqueId.map { it.value }
  }
}
