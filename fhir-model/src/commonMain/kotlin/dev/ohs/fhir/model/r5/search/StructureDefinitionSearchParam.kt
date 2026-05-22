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

import dev.ohs.fhir.model.r5.Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.StructureDefinition
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.ValueSet
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [StructureDefinition] resource type. */
public object StructureDefinitionSearchParam {
  public val Abstract: SearchParam<StructureDefinition, Boolean> =
    SimpleSearchParam<StructureDefinition, Boolean>(
      name = "abstract",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.abstract",
      extractor = { resource -> listOf(resource.abstract) },
    )

  public val Base: SearchParam<StructureDefinition, Canonical> =
    SimpleSearchParam<StructureDefinition, Canonical>(
      name = "base",
      type = SearchParamType.fromCode("reference"),
      expression = "StructureDefinition.baseDefinition",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> listOfNotNull(resource.baseDefinition) },
    )

  public val BasePath: SearchParam<StructureDefinition, String> =
    SimpleSearchParam<StructureDefinition, String>(
      name = "base-path",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.snapshot.element.base.path",
      extractor = { resource ->
        (resource.snapshot?.element ?: emptyList()).mapNotNull { it.base }.map { it.path }
      },
    )

  public val Context: SearchParam<StructureDefinition, Any> =
    SimpleSearchParam<StructureDefinition, Any>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(StructureDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { emptyList() },
    )

  public val ContextQuantity: SearchParam<StructureDefinition, Any> =
    SimpleSearchParam<StructureDefinition, Any>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(StructureDefinition.useContext.value.ofType(Quantity))",
      extractor = { emptyList() },
    )

  public val ContextType: SearchParam<StructureDefinition, Coding> =
    SimpleSearchParam<StructureDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<StructureDefinition, UsageContext> =
    SimpleSearchParam<StructureDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<StructureDefinition, UsageContext> =
    SimpleSearchParam<StructureDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<StructureDefinition, DateTime> =
    SimpleSearchParam<StructureDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "StructureDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Derivation: SearchParam<StructureDefinition, Any> =
    SimpleSearchParam<StructureDefinition, Any>(
      name = "derivation",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.derivation",
      extractor = { resource -> listOfNotNull(resource.derivation) },
    )

  public val Description: SearchParam<StructureDefinition, Markdown> =
    SimpleSearchParam<StructureDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "StructureDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Experimental: SearchParam<StructureDefinition, Boolean> =
    SimpleSearchParam<StructureDefinition, Boolean>(
      name = "experimental",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.experimental",
      extractor = { resource -> listOfNotNull(resource.experimental) },
    )

  public val ExtContext: SearchParam<StructureDefinition, StructureDefinition.Context> =
    SimpleSearchParam<StructureDefinition, StructureDefinition.Context>(
      name = "ext-context",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureDefinition.context",
      extractor = { resource -> resource.context },
    )

  public val ExtContextExpression: SearchParam<StructureDefinition, String> =
    SimpleSearchParam<StructureDefinition, String>(
      name = "ext-context-expression",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.context.expression",
      extractor = { resource -> resource.context.map { it.expression } },
    )

  public val ExtContextType: SearchParam<StructureDefinition, Any> =
    SimpleSearchParam<StructureDefinition, Any>(
      name = "ext-context-type",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.context.type",
      extractor = { resource -> resource.context.map { it.type } },
    )

  public val Identifier: SearchParam<StructureDefinition, Identifier> =
    SimpleSearchParam<StructureDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Jurisdiction: SearchParam<StructureDefinition, CodeableConcept> =
    SimpleSearchParam<StructureDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Keyword: SearchParam<StructureDefinition, Coding> =
    SimpleSearchParam<StructureDefinition, Coding>(
      name = "keyword",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.keyword",
      extractor = { resource -> resource.keyword },
    )

  public val Kind: SearchParam<StructureDefinition, Any> =
    SimpleSearchParam<StructureDefinition, Any>(
      name = "kind",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.kind",
      extractor = { resource -> listOf(resource.kind) },
    )

  public val Name: SearchParam<StructureDefinition, String> =
    SimpleSearchParam<StructureDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "StructureDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val Path: SearchParam<StructureDefinition, String> =
    SimpleSearchParam<StructureDefinition, String>(
      name = "path",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.snapshot.element.path",
      extractor = { resource -> (resource.snapshot?.element ?: emptyList()).map { it.path } },
    )

  public val Publisher: SearchParam<StructureDefinition, String> =
    SimpleSearchParam<StructureDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "StructureDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<StructureDefinition, Any> =
    SimpleSearchParam<StructureDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Title: SearchParam<StructureDefinition, String> =
    SimpleSearchParam<StructureDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "StructureDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Type: SearchParam<StructureDefinition, Uri> =
    SimpleSearchParam<StructureDefinition, Uri>(
      name = "type",
      type = SearchParamType.fromCode("uri"),
      expression = "StructureDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val Url: SearchParam<StructureDefinition, Uri> =
    SimpleSearchParam<StructureDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "StructureDefinition.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val Valueset: SearchParam<StructureDefinition, Canonical> =
    SimpleSearchParam<StructureDefinition, Canonical>(
      name = "valueset",
      type = SearchParamType.fromCode("reference"),
      expression = "StructureDefinition.snapshot.element.binding.valueSet",
      target = listOf(ValueSet::class),
      extractor = { resource ->
        (resource.snapshot?.element ?: emptyList())
          .mapNotNull { it.binding }
          .mapNotNull { it.valueSet }
      },
    )

  public val Version: SearchParam<StructureDefinition, String> =
    SimpleSearchParam<StructureDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the StructureDefinition resource type. */
  public val ALL: List<SearchParam<StructureDefinition, *>> =
    listOf(
      Abstract,
      Base,
      BasePath,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Derivation,
      Description,
      Experimental,
      ExtContext,
      ExtContextExpression,
      ExtContextType,
      Identifier,
      Jurisdiction,
      Keyword,
      Kind,
      Name,
      Path,
      Publisher,
      Status,
      Title,
      Type,
      Url,
      Valueset,
      Version,
    )
}
