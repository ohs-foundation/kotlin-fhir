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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CapabilityStatement
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.ImplementationGuide
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.StructureDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [CapabilityStatement] resource type. */
public object CapabilityStatementSearchParam {
  /** All search parameters for the CapabilityStatement resource type. */
  public val ALL: List<SearchParam<CapabilityStatement, *>> =
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

  public data object Context : SearchParam<CapabilityStatement, CodeableConcept> {
    public override val name: KotlinString = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "(CapabilityStatement.useContext.value as CodeableConcept)"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<CodeableConcept> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
  }

  public data object ContextQuantity : SearchParam<CapabilityStatement, Quantity> {
    public override val name: KotlinString = "context-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: KotlinString =
      "(CapabilityStatement.useContext.value as Quantity)"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Quantity> =
      resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
  }

  public data object ContextType : SearchParam<CapabilityStatement, Coding> {
    public override val name: KotlinString = "context-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.useContext.code"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Coding> =
      resource.useContext.map { it.code }
  }

  public data object ContextTypeQuantity : SearchParam<CapabilityStatement, UsageContext> {
    public override val name: KotlinString = "context-type-quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "CapabilityStatement.useContext"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<UsageContext> =
      resource.useContext
  }

  public data object ContextTypeValue : SearchParam<CapabilityStatement, UsageContext> {
    public override val name: KotlinString = "context-type-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "CapabilityStatement.useContext"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<UsageContext> =
      resource.useContext
  }

  public data object Date : SearchParam<CapabilityStatement, DateTime> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "CapabilityStatement.date"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<DateTime> =
      listOf(resource.date)
  }

  public data object Description : SearchParam<CapabilityStatement, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CapabilityStatement.description"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Fhirversion : SearchParam<CapabilityStatement, R4String> {
    public override val name: KotlinString = "fhirversion"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.version"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<R4String> =
      listOfNotNull(resource.version)
  }

  public data object Format : SearchParam<CapabilityStatement, Any> {
    public override val name: KotlinString = "format"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.format"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = resource.format
  }

  public data object Guide : SearchParam<CapabilityStatement, Canonical> {
    public override val name: KotlinString = "guide"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "CapabilityStatement.implementationGuide"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> =
      listOf(ImplementationGuide::class)

    public override fun extract(resource: CapabilityStatement): List<Canonical> =
      resource.implementationGuide
  }

  public data object Jurisdiction : SearchParam<CapabilityStatement, CodeableConcept> {
    public override val name: KotlinString = "jurisdiction"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.jurisdiction"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<CodeableConcept> =
      resource.jurisdiction
  }

  public data object Mode : SearchParam<CapabilityStatement, Any> {
    public override val name: KotlinString = "mode"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.rest.mode"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> =
      resource.rest.map { it.mode }
  }

  public data object Name : SearchParam<CapabilityStatement, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CapabilityStatement.name"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<R4String> =
      listOfNotNull(resource.name)
  }

  public data object Publisher : SearchParam<CapabilityStatement, R4String> {
    public override val name: KotlinString = "publisher"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CapabilityStatement.publisher"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<R4String> =
      listOfNotNull(resource.publisher)
  }

  public data object Resource : SearchParam<CapabilityStatement, Any> {
    public override val name: KotlinString = "resource"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.rest.resource.type"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> =
      resource.rest.flatMap { it.resource }.map { it.type }
  }

  public data object ResourceProfile : SearchParam<CapabilityStatement, Canonical> {
    public override val name: KotlinString = "resource-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "CapabilityStatement.rest.resource.profile"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> =
      listOf(StructureDefinition::class)

    public override fun extract(resource: CapabilityStatement): List<Canonical> =
      resource.rest.flatMap { it.resource }.mapNotNull { it.profile }
  }

  public data object SecurityService : SearchParam<CapabilityStatement, CodeableConcept> {
    public override val name: KotlinString = "security-service"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.rest.security.service"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<CodeableConcept> =
      resource.rest.mapNotNull { it.security }.flatMap { it.service }
  }

  public data object Software : SearchParam<CapabilityStatement, R4String> {
    public override val name: KotlinString = "software"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CapabilityStatement.software.name"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<R4String> =
      listOfNotNull(resource.software?.name)
  }

  public data object Status : SearchParam<CapabilityStatement, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.status"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Any> = listOf(resource.status)
  }

  public data object SupportedProfile : SearchParam<CapabilityStatement, Canonical> {
    public override val name: KotlinString = "supported-profile"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "CapabilityStatement.rest.resource.supportedProfile"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> =
      listOf(StructureDefinition::class)

    public override fun extract(resource: CapabilityStatement): List<Canonical> =
      resource.rest.flatMap { it.resource }.flatMap { it.supportedProfile }
  }

  public data object Title : SearchParam<CapabilityStatement, R4String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "CapabilityStatement.title"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<R4String> =
      listOfNotNull(resource.title)
  }

  public data object Url : SearchParam<CapabilityStatement, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "CapabilityStatement.url"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<Uri> =
      listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<CapabilityStatement, R4String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "CapabilityStatement.version"

    public override val target: List<KClass<out dev.ohs.fhir.model.r4.Resource>> = emptyList()

    public override fun extract(resource: CapabilityStatement): List<R4String> =
      listOfNotNull(resource.version)
  }
}
