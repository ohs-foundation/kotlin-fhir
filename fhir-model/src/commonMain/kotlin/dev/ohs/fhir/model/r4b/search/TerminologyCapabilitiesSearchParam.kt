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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.TerminologyCapabilities
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TerminologyCapabilities] resource type. */
public object TerminologyCapabilitiesSearchParam {
  /** All search parameters for the TerminologyCapabilities resource type. */
  public val ALL: List<SearchParam<TerminologyCapabilities, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Jurisdiction,
      Name,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )

  public data object Context : SearchParam<TerminologyCapabilities, CodeableConcept> {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(TerminologyCapabilities.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<TerminologyCapabilities, Quantity> {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(TerminologyCapabilities.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<TerminologyCapabilities, Coding> {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TerminologyCapabilities.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<TerminologyCapabilities, UsageContext> {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TerminologyCapabilities.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<TerminologyCapabilities, UsageContext> {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TerminologyCapabilities.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<TerminologyCapabilities, DateTime> {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "TerminologyCapabilities.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<DateTime> =
      listOf(resource.date)
  }

  public data object Description : SearchParam<TerminologyCapabilities, Markdown> {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TerminologyCapabilities.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Jurisdiction : SearchParam<TerminologyCapabilities, CodeableConcept> {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TerminologyCapabilities.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Name : SearchParam<TerminologyCapabilities, R4bString> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TerminologyCapabilities.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<R4bString> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<TerminologyCapabilities, R4bString> {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TerminologyCapabilities.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<R4bString> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<TerminologyCapabilities, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TerminologyCapabilities.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Any> =
      listOf(resource.status)
  }

  public data object Title : SearchParam<TerminologyCapabilities, R4bString> {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TerminologyCapabilities.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<R4bString> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<TerminologyCapabilities, Uri> {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "TerminologyCapabilities.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<TerminologyCapabilities, R4bString> {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TerminologyCapabilities.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TerminologyCapabilities): List<R4bString> =
      listOfNotNull(resource.version)
  }
}
