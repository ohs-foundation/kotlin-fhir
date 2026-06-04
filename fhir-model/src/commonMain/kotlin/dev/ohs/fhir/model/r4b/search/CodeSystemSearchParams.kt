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
  public val Code: SearchParam<CodeSystem, Any> =
    SimpleSearchParam<CodeSystem, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.concept.code",
      extractor = { resource -> resource.concept.map { it.code } },
    )

  public val ContentMode: SearchParam<CodeSystem, Any> =
    SimpleSearchParam<CodeSystem, Any>(
      name = "content-mode",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.content",
      extractor = { resource -> listOf(resource.content) },
    )

  public val Context: SearchParam<CodeSystem, CodeableConcept> =
    SimpleSearchParam<CodeSystem, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(CodeSystem.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val ContextQuantity: SearchParam<CodeSystem, Quantity> =
    SimpleSearchParam<CodeSystem, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(CodeSystem.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<CodeSystem, Coding> =
    SimpleSearchParam<CodeSystem, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<CodeSystem, UsageContext> =
    SimpleSearchParam<CodeSystem, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "CodeSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<CodeSystem, UsageContext> =
    SimpleSearchParam<CodeSystem, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "CodeSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<CodeSystem, DateTime> =
    SimpleSearchParam<CodeSystem, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CodeSystem.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<CodeSystem, Markdown> =
    SimpleSearchParam<CodeSystem, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Identifier: SearchParam<CodeSystem, Identifier> =
    SimpleSearchParam<CodeSystem, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<CodeSystem, CodeableConcept> =
    SimpleSearchParam<CodeSystem, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Language: SearchParam<CodeSystem, Any> =
    SimpleSearchParam<CodeSystem, Any>(
      name = "language",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.concept.designation.language",
      extractor = { resource ->
        resource.concept.flatMap { it.designation }.mapNotNull { it.language }
      },
    )

  public val Name: SearchParam<CodeSystem, String> =
    SimpleSearchParam<CodeSystem, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<CodeSystem, String> =
    SimpleSearchParam<CodeSystem, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<CodeSystem, Any> =
    SimpleSearchParam<CodeSystem, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Supplements: SearchParam<CodeSystem, Canonical> =
    SimpleSearchParam<CodeSystem, Canonical>(
      name = "supplements",
      type = SearchParamType.fromCode("reference"),
      expression = "CodeSystem.supplements",
      target = listOf(CodeSystem::class),
      extractor = { resource -> listOfNotNull(resource.supplements) },
    )

  public val System: SearchParam<CodeSystem, Uri> =
    SimpleSearchParam<CodeSystem, Uri>(
      name = "system",
      type = SearchParamType.fromCode("uri"),
      expression = "CodeSystem.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Title: SearchParam<CodeSystem, String> =
    SimpleSearchParam<CodeSystem, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "CodeSystem.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<CodeSystem, Uri> =
    SimpleSearchParam<CodeSystem, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "CodeSystem.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<CodeSystem, String> =
    SimpleSearchParam<CodeSystem, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "CodeSystem.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the CodeSystem resource type. */
  public val ALL: List<SearchParam<CodeSystem, *>> =
    listOf(
      Code,
      ContentMode,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Identifier,
      Jurisdiction,
      Language,
      Name,
      Publisher,
      Status,
      Supplements,
      System,
      Title,
      Url,
      Version,
    )
}
