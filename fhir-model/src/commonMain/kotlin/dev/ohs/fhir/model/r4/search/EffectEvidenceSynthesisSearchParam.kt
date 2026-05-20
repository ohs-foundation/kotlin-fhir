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
import dev.ohs.fhir.model.r4.EffectEvidenceSynthesis
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EffectEvidenceSynthesis] resource type. */
public object EffectEvidenceSynthesisSearchParam {
  /** All search parameters for the EffectEvidenceSynthesis resource type. */
  public val ALL: List<SearchParam<EffectEvidenceSynthesis, *>> =
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

  public data object Context : SearchParam<EffectEvidenceSynthesis, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(EffectEvidenceSynthesis.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<EffectEvidenceSynthesis, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(EffectEvidenceSynthesis.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<EffectEvidenceSynthesis, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<EffectEvidenceSynthesis, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<EffectEvidenceSynthesis, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<EffectEvidenceSynthesis, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<EffectEvidenceSynthesis, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Effective : SearchParam<EffectEvidenceSynthesis, Period> {
    public override val paramName: KotlinString = "effective"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.effectivePeriod"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Period> =
      listOfNotNull(resource.effectivePeriod)
  }

  public data object Identifier :
    SearchParam<EffectEvidenceSynthesis, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: EffectEvidenceSynthesis
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Jurisdiction : SearchParam<EffectEvidenceSynthesis, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<EffectEvidenceSynthesis, R4String> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<EffectEvidenceSynthesis, R4String> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<EffectEvidenceSynthesis, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Any> =
      listOf(resource.status)
  }

  public data object Title : SearchParam<EffectEvidenceSynthesis, R4String> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<EffectEvidenceSynthesis, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<EffectEvidenceSynthesis, R4String> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EffectEvidenceSynthesis.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EffectEvidenceSynthesis): List<R4String> =
      listOfNotNull(resource.version)
  }
}
