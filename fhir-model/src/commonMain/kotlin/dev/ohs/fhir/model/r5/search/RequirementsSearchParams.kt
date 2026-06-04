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
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Requirements
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Requirements] resource type. */
public object RequirementsSearchParams {
  public val Actor: SearchParam<Requirements, Canonical> =
    SimpleSearchParam<Requirements, Canonical>(
      name = "actor",
      type = SearchParamType.fromCode("reference"),
      expression = "Requirements.actor",
      target = listOf(ActorDefinition::class),
      extractor = { resource -> resource.actor },
    )

  public val Context: SearchParam<Requirements, Any> =
    SimpleSearchParam<Requirements, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(Requirements.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<Requirements, Any> =
    SimpleSearchParam<Requirements, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(Requirements.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<Requirements, Coding> =
    SimpleSearchParam<Requirements, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<Requirements, UsageContext> =
    SimpleSearchParam<Requirements, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "Requirements.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<Requirements, UsageContext> =
    SimpleSearchParam<Requirements, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Requirements.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<Requirements, DateTime> =
    SimpleSearchParam<Requirements, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Requirements.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val DerivedFrom: SearchParam<Requirements, Canonical> =
    SimpleSearchParam<Requirements, Canonical>(
      name = "derived-from",
      type = SearchParamType.fromCode("reference"),
      expression = "Requirements.derivedFrom",
      target = listOf(Requirements::class),
      extractor = { resource -> resource.derivedFrom },
    )

  public val Description: SearchParam<Requirements, Markdown> =
    SimpleSearchParam<Requirements, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "Requirements.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Identifier: SearchParam<Requirements, Identifier> =
    SimpleSearchParam<Requirements, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<Requirements, CodeableConcept> =
    SimpleSearchParam<Requirements, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<Requirements, String> =
    SimpleSearchParam<Requirements, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "Requirements.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Publisher: SearchParam<Requirements, String> =
    SimpleSearchParam<Requirements, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "Requirements.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<Requirements, Any> =
    SimpleSearchParam<Requirements, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<Requirements, String> =
    SimpleSearchParam<Requirements, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "Requirements.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<Requirements, Uri> =
    SimpleSearchParam<Requirements, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Requirements.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<Requirements, String> =
    SimpleSearchParam<Requirements, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "Requirements.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the Requirements resource type. */
  public val ALL: List<SearchParam<Requirements, *>> =
    listOf(
      Actor,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      DerivedFrom,
      Description,
      Identifier,
      Jurisdiction,
      Name,
      Publisher,
      Status,
      Title,
      Url,
      Version,
    )
}
