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

import dev.ohs.fhir.model.r5.ActorDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ActorDefinition] resource type. */
public object ActorDefinitionSearchParams {
  public val Context: SearchParam<ActorDefinition, Any> =
    SimpleSearchParam<ActorDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ActorDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<ActorDefinition, Any> =
    SimpleSearchParam<ActorDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ActorDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<ActorDefinition, Coding> =
    SimpleSearchParam<ActorDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<ActorDefinition, UsageContext> =
    SimpleSearchParam<ActorDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ActorDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<ActorDefinition, UsageContext> =
    SimpleSearchParam<ActorDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ActorDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<ActorDefinition, DateTime> =
    SimpleSearchParam<ActorDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ActorDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<ActorDefinition, Markdown> =
    SimpleSearchParam<ActorDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ActorDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Identifier: SearchParam<ActorDefinition, Identifier> =
    SimpleSearchParam<ActorDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<ActorDefinition, CodeableConcept> =
    SimpleSearchParam<ActorDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Publisher: SearchParam<ActorDefinition, String> =
    SimpleSearchParam<ActorDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ActorDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<ActorDefinition, Any> =
    SimpleSearchParam<ActorDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<ActorDefinition, String> =
    SimpleSearchParam<ActorDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ActorDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Type: SearchParam<ActorDefinition, Any> =
    SimpleSearchParam<ActorDefinition, Any>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val Url: SearchParam<ActorDefinition, Uri> =
    SimpleSearchParam<ActorDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ActorDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<ActorDefinition, String> =
    SimpleSearchParam<ActorDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ActorDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ActorDefinition resource type. */
  public val ALL: List<SearchParam<ActorDefinition, *>> =
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
      Publisher,
      Status,
      Title,
      Type,
      Url,
      Version,
    )
}
