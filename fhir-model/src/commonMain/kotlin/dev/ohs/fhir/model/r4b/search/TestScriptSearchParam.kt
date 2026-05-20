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
import dev.ohs.fhir.model.r4b.TestScript
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TestScript] resource type. */
public sealed class TestScriptSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: TestScript): List<T>

  public data object Context : TestScriptSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(TestScript.useContext.value as CodeableConcept)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : TestScriptSearchParam<Quantity>() {
    public override val paramName: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(TestScript.useContext.value as Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : TestScriptSearchParam<Coding>() {
    public override val paramName: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.useContext.code"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : TestScriptSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TestScript.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : TestScriptSearchParam<UsageContext>() {
    public override val paramName: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TestScript.useContext"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<UsageContext> = resource.useContext
  }

  public data object Date : TestScriptSearchParam<DateTime>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "TestScript.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : TestScriptSearchParam<Markdown>() {
    public override val paramName: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : TestScriptSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<dev.ohs.fhir.model.r4b.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Jurisdiction : TestScriptSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.jurisdiction"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : TestScriptSearchParam<R4bString>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R4bString> = listOf(resource.name)
  }

  public data object Publisher : TestScriptSearchParam<R4bString>() {
    public override val paramName: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.publisher"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R4bString> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : TestScriptSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = listOf(resource.status)
  }

  public data object TestscriptCapability : TestScriptSearchParam<R4bString>() {
    public override val paramName: KotlinString = "testscript-capability"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.metadata.capability.description"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R4bString> =
      (resource.metadata?.capability ?: emptyList()).mapNotNull { it.description }
  }

  public data object Title : TestScriptSearchParam<R4bString>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R4bString> =
      listOfNotNull(resource.title)
  }

  public data object Url : TestScriptSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "TestScript.url"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<Uri> = listOf(resource.url)
  }

  public data object Version : TestScriptSearchParam<R4bString>() {
    public override val paramName: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.version"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestScript): List<R4bString> =
      listOfNotNull(resource.version)
  }

  public companion object {
    /** All search parameters for the TestScript resource type. */
    public val ALL: List<TestScriptSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Identifier,
        Jurisdiction,
        Name,
        Publisher,
        Status,
        TestscriptCapability,
        Title,
        Url,
        Version,
      )
  }
}
