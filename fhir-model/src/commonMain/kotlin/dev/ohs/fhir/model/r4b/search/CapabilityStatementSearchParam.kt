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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CapabilityStatement
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.ImplementationGuide
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.StructureDefinition
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CapabilityStatement] resource type. */
public object CapabilityStatementSearchParam {
  public val Context: SearchParam<CapabilityStatement, CodeableConcept> =
    SimpleSearchParam<CapabilityStatement, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(CapabilityStatement.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val ContextQuantity: SearchParam<CapabilityStatement, Quantity> =
    SimpleSearchParam<CapabilityStatement, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(CapabilityStatement.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<CapabilityStatement, Coding> =
    SimpleSearchParam<CapabilityStatement, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<CapabilityStatement, UsageContext> =
    SimpleSearchParam<CapabilityStatement, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "CapabilityStatement.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<CapabilityStatement, UsageContext> =
    SimpleSearchParam<CapabilityStatement, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "CapabilityStatement.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<CapabilityStatement, DateTime> =
    SimpleSearchParam<CapabilityStatement, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CapabilityStatement.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val Description: SearchParam<CapabilityStatement, Markdown> =
    SimpleSearchParam<CapabilityStatement, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Fhirversion: SearchParam<CapabilityStatement, String> =
    SimpleSearchParam<CapabilityStatement, String>(
      name = "fhirversion",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  public val Format: SearchParam<CapabilityStatement, Any> =
    SimpleSearchParam<CapabilityStatement, Any>(
      name = "format",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.format",
      extractor = { resource -> resource.format },
    )

  public val Guide: SearchParam<CapabilityStatement, Canonical> =
    SimpleSearchParam<CapabilityStatement, Canonical>(
      name = "guide",
      type = SearchParamType.fromCode("reference"),
      expression = "CapabilityStatement.implementationGuide",
      target = listOf(ImplementationGuide::class),
      extractor = { resource -> resource.implementationGuide },
    )

  public val Jurisdiction: SearchParam<CapabilityStatement, CodeableConcept> =
    SimpleSearchParam<CapabilityStatement, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Mode: SearchParam<CapabilityStatement, Any> =
    SimpleSearchParam<CapabilityStatement, Any>(
      name = "mode",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.rest.mode",
      extractor = { resource -> resource.rest.map { it.mode } },
    )

  public val Name: SearchParam<CapabilityStatement, String> =
    SimpleSearchParam<CapabilityStatement, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<CapabilityStatement, String> =
    SimpleSearchParam<CapabilityStatement, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Resource: SearchParam<CapabilityStatement, Any> =
    SimpleSearchParam<CapabilityStatement, Any>(
      name = "resource",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.rest.resource.type",
      extractor = { resource -> resource.rest.flatMap { it.resource }.map { it.type } },
    )

  public val ResourceProfile: SearchParam<CapabilityStatement, Canonical> =
    SimpleSearchParam<CapabilityStatement, Canonical>(
      name = "resource-profile",
      type = SearchParamType.fromCode("reference"),
      expression = "CapabilityStatement.rest.resource.profile",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> resource.rest.flatMap { it.resource }.mapNotNull { it.profile } },
    )

  public val SecurityService: SearchParam<CapabilityStatement, CodeableConcept> =
    SimpleSearchParam<CapabilityStatement, CodeableConcept>(
      name = "security-service",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.rest.security.service",
      extractor = { resource -> resource.rest.mapNotNull { it.security }.flatMap { it.service } },
    )

  public val Software: SearchParam<CapabilityStatement, String> =
    SimpleSearchParam<CapabilityStatement, String>(
      name = "software",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.software.name",
      extractor = { resource -> listOfNotNull(resource.software?.name) },
    )

  public val Status: SearchParam<CapabilityStatement, Any> =
    SimpleSearchParam<CapabilityStatement, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val SupportedProfile: SearchParam<CapabilityStatement, Canonical> =
    SimpleSearchParam<CapabilityStatement, Canonical>(
      name = "supported-profile",
      type = SearchParamType.fromCode("reference"),
      expression = "CapabilityStatement.rest.resource.supportedProfile",
      target = listOf(StructureDefinition::class),
      extractor = { resource ->
        resource.rest.flatMap { it.resource }.flatMap { it.supportedProfile }
      },
    )

  public val Title: SearchParam<CapabilityStatement, String> =
    SimpleSearchParam<CapabilityStatement, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<CapabilityStatement, Uri> =
    SimpleSearchParam<CapabilityStatement, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "CapabilityStatement.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<CapabilityStatement, String> =
    SimpleSearchParam<CapabilityStatement, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

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
}
