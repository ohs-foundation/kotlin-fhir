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
import dev.ohs.fhir.model.r4b.EvidenceVariable
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EvidenceVariable] resource type. */
public sealed class EvidenceVariableSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: EvidenceVariable): List<T>

  public data object Context : EvidenceVariableSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(EvidenceVariable.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : EvidenceVariableSearchParam<Quantity>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(EvidenceVariable.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : EvidenceVariableSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EvidenceVariable.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : EvidenceVariableSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "EvidenceVariable.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : EvidenceVariableSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "EvidenceVariable.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<UsageContext> =
      resource.useContext
  }

  public data object Date : EvidenceVariableSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "EvidenceVariable.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<DateTime> =
      listOfNotNull(resource.date)
  }

  public data object Description : EvidenceVariableSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EvidenceVariable.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : EvidenceVariableSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EvidenceVariable.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: EvidenceVariable
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Name : EvidenceVariableSearchParam<R4bString>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EvidenceVariable.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<R4bString> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : EvidenceVariableSearchParam<R4bString>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EvidenceVariable.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<R4bString> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : EvidenceVariableSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EvidenceVariable.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Any> = listOf(resource.status)
  }

  public data object Title : EvidenceVariableSearchParam<R4bString>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "EvidenceVariable.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<R4bString> =
      listOfNotNull(resource.title)
  }

  public data object Url : EvidenceVariableSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "EvidenceVariable.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : EvidenceVariableSearchParam<R4bString>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "EvidenceVariable.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: EvidenceVariable): List<R4bString> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the EvidenceVariable resource type. */
    public val ALL: List<EvidenceVariableSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Identifier,
        Name,
        Publisher,
        Status,
        Title,
        Url,
        Version,
      )
  }
}
