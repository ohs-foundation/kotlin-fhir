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
import dev.ohs.fhir.model.r4b.CodeSystem
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CodeSystem] resource type. */
public object CodeSystemSearchParams {
  public val code: SearchParam<CodeSystem, Any> =
    SearchParam<CodeSystem, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.concept.code",
      extractor = { resource -> resource.concept.map { it.code } },
    )

  public val contentMode: SearchParam<CodeSystem, Any> =
    SearchParam<CodeSystem, Any>(
      name = "content-mode",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.content",
      extractor = { resource -> listOf(resource.content) },
    )

  public val context: SearchParam<CodeSystem, CodeableConcept> =
    SearchParam<CodeSystem, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(CodeSystem.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<CodeSystem, Quantity> =
    SearchParam<CodeSystem, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(CodeSystem.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<CodeSystem, Coding> =
    SearchParam<CodeSystem, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<CodeSystem, UsageContext> =
    SearchParam<CodeSystem, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "CodeSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<CodeSystem, UsageContext> =
    SearchParam<CodeSystem, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "CodeSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<CodeSystem, DateTime> =
    SearchParam<CodeSystem, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CodeSystem.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<CodeSystem, Markdown> =
    SearchParam<CodeSystem, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<CodeSystem, Identifier> =
    SearchParam<CodeSystem, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<CodeSystem, CodeableConcept> =
    SearchParam<CodeSystem, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val language: SearchParam<CodeSystem, Any> =
    SearchParam<CodeSystem, Any>(
      name = "language",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.concept.designation.language",
      extractor = { resource ->
        resource.concept.flatMap { it.designation }.mapNotNull { it.language }
      },
    )

  public val name: SearchParam<CodeSystem, String> =
    SearchParam<CodeSystem, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<CodeSystem, String> =
    SearchParam<CodeSystem, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<CodeSystem, Any> =
    SearchParam<CodeSystem, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val supplements: SearchParam<CodeSystem, Canonical> =
    SearchParam<CodeSystem, Canonical>(
      name = "supplements",
      type = SearchParamType.fromCode("reference"),
      expression = "CodeSystem.supplements",
      target = listOf(CodeSystem::class),
      extractor = { resource -> listOfNotNull(resource.supplements) },
    )

  public val system: SearchParam<CodeSystem, Uri> =
    SearchParam<CodeSystem, Uri>(
      name = "system",
      type = SearchParamType.fromCode("uri"),
      expression = "CodeSystem.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val title: SearchParam<CodeSystem, String> =
    SearchParam<CodeSystem, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<CodeSystem, Uri> =
    SearchParam<CodeSystem, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "CodeSystem.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<CodeSystem, String> =
    SearchParam<CodeSystem, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the CodeSystem resource type. */
  public val all: List<SearchParam<CodeSystem, *>> =
    listOf(
      code,
      contentMode,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      identifier,
      jurisdiction,
      language,
      name,
      publisher,
      status,
      supplements,
      system,
      title,
      url,
      version,
    )
}
