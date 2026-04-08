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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CapabilityStatement] resource type. */
public sealed class CapabilityStatementSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CapabilityStatement): List<T>

  public data object Context : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(CapabilityStatement.useContext.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object ContextQuantity : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "(CapabilityStatement.useContext.value as Quantity)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object ContextType : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.useContext.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object ContextTypeQuantity : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "CapabilityStatement.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object ContextTypeValue : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "CapabilityStatement.useContext"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Date : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CapabilityStatement.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Description : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CapabilityStatement.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Fhirversion : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "fhirversion"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Format : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "format"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.format"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Guide : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "guide"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CapabilityStatement.implementationGuide"

    public override val target: List<String> = listOf("ImplementationGuide")

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Jurisdiction : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.jurisdiction"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Mode : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "mode"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.rest.mode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Name : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CapabilityStatement.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Publisher : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CapabilityStatement.publisher"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Resource : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.rest.resource.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object ResourceProfile : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "resource-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CapabilityStatement.rest.resource.profile"

    public override val target: List<String> = listOf("StructureDefinition")

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object SecurityService : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "security-service"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.rest.security.service"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Software : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "software"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CapabilityStatement.software.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Status : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object SupportedProfile : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "supported-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CapabilityStatement.rest.resource.supportedProfile"

    public override val target: List<String> = listOf("StructureDefinition")

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Title : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "CapabilityStatement.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Url : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "CapabilityStatement.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object Version : CapabilityStatementSearchParam<Any>() {
    public override val paramName: String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CapabilityStatement.version"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the CapabilityStatement resource type. */
    public val ALL: List<CapabilityStatementSearchParam<*>> =
      listOf(
        Context,
        ContextQuantity,
        ContextType,
        ContextTypeQuantity,
        ContextTypeValue,
        Date,
        Description,
        Fhirversion,
        Format,
        Guide,
        Jurisdiction,
        Mode,
        Name,
        Publisher,
        Resource,
        ResourceProfile,
        SecurityService,
        Software,
        Status,
        SupportedProfile,
        Title,
        Url,
        Version,
      )
  }
}
