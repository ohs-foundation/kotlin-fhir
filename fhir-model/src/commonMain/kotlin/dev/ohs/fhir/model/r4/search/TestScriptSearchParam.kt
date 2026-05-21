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
import dev.ohs.fhir.model.r4.TestScript
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [TestScript] resource type. */
public object TestScriptSearchParam {
  /** All search parameters for the TestScript resource type. */
  public val ALL: List<SearchParam<TestScript, *>> =
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

  public data object Context : SearchParam<TestScript, CodeableConcept> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(TestScript.useContext.value as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<TestScript, Quantity> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString = "(TestScript.useContext.value as Quantity)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<TestScript, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.useContext.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<TestScript, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TestScript.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<UsageContext> = resource.useContext
  }

  public data object ContextTypeValue : SearchParam<TestScript, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "TestScript.useContext"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<UsageContext> = resource.useContext
  }

  public data object Date : SearchParam<TestScript, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "TestScript.date"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Description : SearchParam<TestScript, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Identifier : SearchParam<TestScript, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<dev.ohs.fhir.model.r4.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Jurisdiction : SearchParam<TestScript, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.jurisdiction"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<CodeableConcept> = resource.jurisdiction
  }

  public data object Name : SearchParam<TestScript, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<R4String> = listOf(resource.name)
  }

  public data object Publisher : SearchParam<TestScript, R4String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.publisher"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Status : SearchParam<TestScript, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = listOf(resource.status)
  }

  public data object TestscriptCapability : SearchParam<TestScript, R4String> {
    public override val name: KotlinString = "testscript-capability"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.metadata.capability.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<R4String> =
      (resource.metadata?.capability ?: emptyList()).mapNotNull { it.description }
  }

  public data object Title : SearchParam<TestScript, R4String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestScript.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<TestScript, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "TestScript.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<Uri> = listOf(resource.url)
  }

  public data object Version : SearchParam<TestScript, R4String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestScript.version"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestScript): List<R4String> =
      listOfNotNull(resource.version)
  }
}
