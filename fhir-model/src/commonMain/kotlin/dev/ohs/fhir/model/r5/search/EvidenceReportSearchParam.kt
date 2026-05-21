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

import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.EvidenceReport
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [EvidenceReport] resource type. */
public object EvidenceReportSearchParam {
  /** All search parameters for the EvidenceReport resource type. */
  public val ALL: List<SearchParam<EvidenceReport, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Identifier,
      Publisher,
      Status,
      Url,
    )

  public data object Context : SearchParam<EvidenceReport, Any> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(EvidenceReport.useContext.value.ofType(CodeableConcept))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object ContextQuantity : SearchParam<EvidenceReport, Any> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(EvidenceReport.useContext.value.ofType(Quantity))"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = emptyList()
  }

  public data object ContextType : SearchParam<EvidenceReport, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EvidenceReport.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<EvidenceReport, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "EvidenceReport.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<EvidenceReport, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "EvidenceReport.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<UsageContext> = resource.useContext
  }

  public data object Identifier : SearchParam<EvidenceReport, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EvidenceReport.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Publisher : SearchParam<EvidenceReport, R5String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EvidenceReport.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<R5String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<EvidenceReport, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EvidenceReport.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Any> = listOf(resource.status)
  }

  public data object Url : SearchParam<EvidenceReport, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "EvidenceReport.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EvidenceReport): List<Uri> = listOfNotNull(resource.url)
  }
}
