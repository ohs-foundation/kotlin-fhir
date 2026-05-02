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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CapabilityStatement] resource type. */
public sealed class CapabilityStatementSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CapabilityStatement): List<T>

  public data object Context : CapabilityStatementSearchParam<Any>() {
    public override val paramName: kotlin.String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "(CapabilityStatement.useContext.value.ofType(CodeableConcept))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object ContextQuantity : CapabilityStatementSearchParam<Any>() {
    public override val paramName: kotlin.String = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: kotlin.String =
      "(CapabilityStatement.useContext.value.ofType(Quantity))"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = emptyList()
  }

  public data object ContextType : CapabilityStatementSearchParam<Coding>() {
    public override val paramName: kotlin.String = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.useContext.code"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : CapabilityStatementSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "CapabilityStatement.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : CapabilityStatementSearchParam<UsageContext>() {
    public override val paramName: kotlin.String = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "CapabilityStatement.useContext"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<UsageContext> =
      resource.useContext
  }

  public data object Date : CapabilityStatementSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "CapabilityStatement.date"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<DateTime> =
      listOf(resource.date)
  }

  public data object Description : CapabilityStatementSearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CapabilityStatement.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Fhirversion : CapabilityStatementSearchParam<Any>() {
    public override val paramName: kotlin.String = "fhirversion"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.fhirVersion"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> =
      listOf(resource.fhirVersion)
  }

  public data object Format : CapabilityStatementSearchParam<Any>() {
    public override val paramName: kotlin.String = "format"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.format"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = resource.format
  }

  public data object Guide : CapabilityStatementSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "guide"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CapabilityStatement.implementationGuide"

    public override val target: List<kotlin.String> = listOf("ImplementationGuide")

    public override fun extract(resource: CapabilityStatement): List<Canonical> =
      resource.implementationGuide
  }

  public data object Identifier :
    CapabilityStatementSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: CapabilityStatement
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Jurisdiction : CapabilityStatementSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.jurisdiction"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Mode : CapabilityStatementSearchParam<Any>() {
    public override val paramName: kotlin.String = "mode"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.rest.mode"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> =
      resource.rest.map { it.mode }
  }

  public data object Name : CapabilityStatementSearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CapabilityStatement.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : CapabilityStatementSearchParam<String>() {
    public override val paramName: kotlin.String = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CapabilityStatement.publisher"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<String> =
      listOfNotNull(resource.publisher)
  }

  public data object Resource : CapabilityStatementSearchParam<Any>() {
    public override val paramName: kotlin.String = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.rest.resource.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> =
      resource.rest.flatMap { it.resource }.map { it.type }
  }

  public data object ResourceProfile : CapabilityStatementSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "resource-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "CapabilityStatement.rest.resource.profile"

    public override val target: List<kotlin.String> = listOf("StructureDefinition")

    public override fun extract(resource: CapabilityStatement): List<Canonical> =
      resource.rest.flatMap { it.resource }.mapNotNull { it.profile }
  }

  public data object SecurityService : CapabilityStatementSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "security-service"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.rest.security.service"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<CodeableConcept> =
      resource.rest.mapNotNull { it.security }.flatMap { it.service }
  }

  public data object Software : CapabilityStatementSearchParam<String>() {
    public override val paramName: kotlin.String = "software"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CapabilityStatement.software.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<String> =
      listOfNotNull(resource.software?.name)
  }

  public data object Status : CapabilityStatementSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = listOf(resource.status)
  }

  public data object SupportedProfile : CapabilityStatementSearchParam<Canonical>() {
    public override val paramName: kotlin.String = "supported-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String =
      "CapabilityStatement.rest.resource.supportedProfile"

    public override val target: List<kotlin.String> = listOf("StructureDefinition")

    public override fun extract(resource: CapabilityStatement): List<Canonical> =
      resource.rest.flatMap { it.resource }.flatMap { it.supportedProfile }
  }

  public data object Title : CapabilityStatementSearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "CapabilityStatement.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<String> =
      listOfNotNull(resource.title)
  }

  public data object Url : CapabilityStatementSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "CapabilityStatement.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : CapabilityStatementSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "CapabilityStatement.version"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<String> =
      listOfNotNull(resource.version)
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
        Identifier,
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
