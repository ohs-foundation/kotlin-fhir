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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CapabilityStatement
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.ImplementationGuide
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.StructureDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CapabilityStatement] resource type. */
public object CapabilityStatementSearchParams {
  public val context: SearchParam<CapabilityStatement, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(CapabilityStatement.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<CapabilityStatement, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression =
        "(CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range)",
      extractor = { resource ->
        buildList {
            addAll(
              resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
            )
            addAll(
              resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Range)?.value }
            )
          }
          .distinct()
      },
    )

  public val contextType: SearchParam<CapabilityStatement, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<CapabilityStatement, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "CapabilityStatement.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<CapabilityStatement, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "CapabilityStatement.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<CapabilityStatement, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "CapabilityStatement.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<CapabilityStatement, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "CapabilityStatement.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val fhirversion: SearchParam<CapabilityStatement, String> =
    SearchParam(
      name = "fhirversion",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  public val format: SearchParam<CapabilityStatement, Any> =
    SearchParam(
      name = "format",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.format",
      extractor = { resource -> resource.format },
    )

  public val guide: SearchParam<CapabilityStatement, Canonical> =
    SearchParam(
      name = "guide",
      type = SearchParamType.Reference,
      expression = "CapabilityStatement.implementationGuide",
      target = listOf(ImplementationGuide::class),
      extractor = { resource -> resource.implementationGuide },
    )

  public val jurisdiction: SearchParam<CapabilityStatement, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val mode: SearchParam<CapabilityStatement, Any> =
    SearchParam(
      name = "mode",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.rest.mode",
      extractor = { resource -> resource.rest.map { it.mode } },
    )

  public val name: SearchParam<CapabilityStatement, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "CapabilityStatement.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<CapabilityStatement, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "CapabilityStatement.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val resource: SearchParam<CapabilityStatement, Any> =
    SearchParam(
      name = "resource",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.rest.resource.type",
      extractor = { resource -> resource.rest.flatMap { it.resource }.map { it.type } },
    )

  public val resourceProfile: SearchParam<CapabilityStatement, Canonical> =
    SearchParam(
      name = "resource-profile",
      type = SearchParamType.Reference,
      expression = "CapabilityStatement.rest.resource.profile",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> resource.rest.flatMap { it.resource }.mapNotNull { it.profile } },
    )

  public val securityService: SearchParam<CapabilityStatement, CodeableConcept> =
    SearchParam(
      name = "security-service",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.rest.security.service",
      extractor = { resource -> resource.rest.mapNotNull { it.security }.flatMap { it.service } },
    )

  public val software: SearchParam<CapabilityStatement, String> =
    SearchParam(
      name = "software",
      type = SearchParamType.String,
      expression = "CapabilityStatement.software.name",
      extractor = { resource -> listOfNotNull(resource.software?.name) },
    )

  public val status: SearchParam<CapabilityStatement, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val supportedProfile: SearchParam<CapabilityStatement, Canonical> =
    SearchParam(
      name = "supported-profile",
      type = SearchParamType.Reference,
      expression = "CapabilityStatement.rest.resource.supportedProfile",
      target = listOf(StructureDefinition::class),
      extractor = { resource ->
        resource.rest.flatMap { it.resource }.flatMap { it.supportedProfile }
      },
    )

  public val title: SearchParam<CapabilityStatement, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "CapabilityStatement.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<CapabilityStatement, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "CapabilityStatement.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<CapabilityStatement, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "CapabilityStatement.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<CapabilityStatement, *>> = listOf()

  /**
   * Supported search parameters for the CapabilityStatement resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
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
