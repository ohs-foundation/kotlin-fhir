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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CapabilityStatement
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImplementationGuide
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.StructureDefinition
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CapabilityStatement] resource type. */
public object CapabilityStatementSearchParams {
  public val context: SearchParam<CapabilityStatement, Any> =
    SearchParam<CapabilityStatement, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(CapabilityStatement.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val contextQuantity: SearchParam<CapabilityStatement, Any> =
    SearchParam<CapabilityStatement, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(CapabilityStatement.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val contextType: SearchParam<CapabilityStatement, Coding> =
    SearchParam<CapabilityStatement, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<CapabilityStatement, UsageContext> =
    SearchParam<CapabilityStatement, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "CapabilityStatement.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<CapabilityStatement, UsageContext> =
    SearchParam<CapabilityStatement, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "CapabilityStatement.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<CapabilityStatement, DateTime> =
    SearchParam<CapabilityStatement, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CapabilityStatement.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<CapabilityStatement, Markdown> =
    SearchParam<CapabilityStatement, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val fhirversion: SearchParam<CapabilityStatement, Any> =
    SearchParam<CapabilityStatement, Any>(
      name = "fhirversion",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.fhirVersion",
      extractor = { resource -> listOf(resource.fhirVersion) },
    )

  public val format: SearchParam<CapabilityStatement, Any> =
    SearchParam<CapabilityStatement, Any>(
      name = "format",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.format",
      extractor = { resource -> resource.format },
    )

  public val guide: SearchParam<CapabilityStatement, Canonical> =
    SearchParam<CapabilityStatement, Canonical>(
      name = "guide",
      type = SearchParamType.fromCode("reference"),
      expression = "CapabilityStatement.implementationGuide",
      target = listOf(ImplementationGuide::class),
      extractor = { resource -> resource.implementationGuide },
    )

  public val identifier: SearchParam<CapabilityStatement, Identifier> =
    SearchParam<CapabilityStatement, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<CapabilityStatement, CodeableConcept> =
    SearchParam<CapabilityStatement, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val mode: SearchParam<CapabilityStatement, Any> =
    SearchParam<CapabilityStatement, Any>(
      name = "mode",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.rest.mode",
      extractor = { resource -> resource.rest.map { it.mode } },
    )

  public val name: SearchParam<CapabilityStatement, String> =
    SearchParam<CapabilityStatement, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<CapabilityStatement, String> =
    SearchParam<CapabilityStatement, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val resource: SearchParam<CapabilityStatement, Any> =
    SearchParam<CapabilityStatement, Any>(
      name = "resource",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.rest.resource.type",
      extractor = { resource -> resource.rest.flatMap { it.resource }.map { it.type } },
    )

  public val resourceProfile: SearchParam<CapabilityStatement, Canonical> =
    SearchParam<CapabilityStatement, Canonical>(
      name = "resource-profile",
      type = SearchParamType.fromCode("reference"),
      expression = "CapabilityStatement.rest.resource.profile",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> resource.rest.flatMap { it.resource }.mapNotNull { it.profile } },
    )

  public val securityService: SearchParam<CapabilityStatement, CodeableConcept> =
    SearchParam<CapabilityStatement, CodeableConcept>(
      name = "security-service",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.rest.security.service",
      extractor = { resource -> resource.rest.mapNotNull { it.security }.flatMap { it.service } },
    )

  public val software: SearchParam<CapabilityStatement, String> =
    SearchParam<CapabilityStatement, String>(
      name = "software",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.software.name",
      extractor = { resource -> listOfNotNull(resource.software?.name) },
    )

  public val status: SearchParam<CapabilityStatement, Any> =
    SearchParam<CapabilityStatement, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val supportedProfile: SearchParam<CapabilityStatement, Canonical> =
    SearchParam<CapabilityStatement, Canonical>(
      name = "supported-profile",
      type = SearchParamType.fromCode("reference"),
      expression = "CapabilityStatement.rest.resource.supportedProfile",
      target = listOf(StructureDefinition::class),
      extractor = { resource ->
        resource.rest.flatMap { it.resource }.flatMap { it.supportedProfile }
      },
    )

  public val title: SearchParam<CapabilityStatement, String> =
    SearchParam<CapabilityStatement, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "CapabilityStatement.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<CapabilityStatement, Uri> =
    SearchParam<CapabilityStatement, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "CapabilityStatement.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<CapabilityStatement, String> =
    SearchParam<CapabilityStatement, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "CapabilityStatement.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the CapabilityStatement resource type. */
  public val all: List<SearchParam<CapabilityStatement, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      fhirversion,
      format,
      guide,
      identifier,
      jurisdiction,
      mode,
      name,
      publisher,
      resource,
      resourceProfile,
      securityService,
      software,
      status,
      supportedProfile,
      title,
      url,
      version,
    )
}
