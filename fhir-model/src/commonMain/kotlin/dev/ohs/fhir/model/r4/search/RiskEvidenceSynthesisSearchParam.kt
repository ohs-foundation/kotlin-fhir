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
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.RiskEvidenceSynthesis
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RiskEvidenceSynthesis] resource type. */
public object RiskEvidenceSynthesisSearchParam {
  /** All search parameters for the RiskEvidenceSynthesis resource type. */
  public val ALL: List<SearchParam<RiskEvidenceSynthesis, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Effective,
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )

  public data object Context : SearchParam<RiskEvidenceSynthesis, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(RiskEvidenceSynthesis.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<RiskEvidenceSynthesis, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(RiskEvidenceSynthesis.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<RiskEvidenceSynthesis, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<RiskEvidenceSynthesis, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<RiskEvidenceSynthesis, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<RiskEvidenceSynthesis, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<RiskEvidenceSynthesis, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : SearchParam<RiskEvidenceSynthesis, Period> {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.effectivePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier :
    SearchParam<RiskEvidenceSynthesis, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: RiskEvidenceSynthesis
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Jurisdiction : SearchParam<RiskEvidenceSynthesis, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<RiskEvidenceSynthesis, R4String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<RiskEvidenceSynthesis, R4String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<RiskEvidenceSynthesis, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Any> =
      listOf(resource.status)
  }

  public data object Title : SearchParam<RiskEvidenceSynthesis, R4String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<RiskEvidenceSynthesis, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<RiskEvidenceSynthesis, R4String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "RiskEvidenceSynthesis.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: RiskEvidenceSynthesis): List<R4String> =
      listOfNotNull(resource.version)
  }
}
