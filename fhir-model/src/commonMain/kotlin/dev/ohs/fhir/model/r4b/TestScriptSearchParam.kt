/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TestScript] resource type. */
public sealed class TestScriptSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: TestScript): List<T>

  public data object Context : TestScriptSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(TestScript.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object ContextQuantity : TestScriptSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(TestScript.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object ContextType : TestScriptSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "TestScript.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : TestScriptSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "TestScript.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object ContextTypeValue : TestScriptSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "TestScript.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Date : TestScriptSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "TestScript.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Description : TestScriptSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "TestScript.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Identifier : TestScriptSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "TestScript.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Jurisdiction : TestScriptSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "TestScript.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Name : TestScriptSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "TestScript.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Publisher : TestScriptSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "TestScript.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Status : TestScriptSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "TestScript.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object TestscriptCapability : TestScriptSearchParam<Any>() {
    public override val paramName: String = "testscript-capability"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "TestScript.metadata.capability.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Title : TestScriptSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "TestScript.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Url : TestScriptSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "TestScript.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
  }

  public data object Version : TestScriptSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "TestScript.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestScript): List<Any> = emptyList()
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
