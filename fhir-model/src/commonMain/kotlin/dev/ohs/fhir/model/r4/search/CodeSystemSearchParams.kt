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
import dev.ohs.fhir.model.r4.CodeSystem
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CodeSystem] resource type. */
public object CodeSystemSearchParams {
  public val code: SearchParam<CodeSystem, Any> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.concept.code",
      extractor = { resource -> resource.concept.map { it.code } },
    )

  public val contentMode: SearchParam<CodeSystem, Any> =
    SearchParam(
      name = "content-mode",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.content",
      extractor = { resource -> listOf(resource.content) },
    )

  public val context: SearchParam<CodeSystem, CodeableConcept> =
    SearchParam(
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
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(CodeSystem.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<CodeSystem, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<CodeSystem, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "CodeSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<CodeSystem, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "CodeSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<CodeSystem, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CodeSystem.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<CodeSystem, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<CodeSystem, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<CodeSystem, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val language: SearchParam<CodeSystem, Any> =
    SearchParam(
      name = "language",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.concept.designation.language",
      extractor = { resource ->
        resource.concept.flatMap { it.designation }.mapNotNull { it.language }
      },
    )

  public val name: SearchParam<CodeSystem, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<CodeSystem, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<CodeSystem, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val supplements: SearchParam<CodeSystem, Canonical> =
    SearchParam(
      name = "supplements",
      type = SearchParamType.fromCode("reference"),
      expression = "CodeSystem.supplements",
      target = listOf(CodeSystem::class),
      extractor = { resource -> listOfNotNull(resource.supplements) },
    )

  public val system: SearchParam<CodeSystem, Uri> =
    SearchParam(
      name = "system",
      type = SearchParamType.fromCode("uri"),
      expression = "CodeSystem.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val title: SearchParam<CodeSystem, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<CodeSystem, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "CodeSystem.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<CodeSystem, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<CodeSystem, *>> = listOf()

  /**
   * Supported search parameters for the CodeSystem resource type. Entries in [unsupported] are
   * excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
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
    ) - unsupported.toSet()
}
