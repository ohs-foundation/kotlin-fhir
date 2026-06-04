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
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ConceptMap
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.ValueSet
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ConceptMap] resource type. */
public object ConceptMapSearchParams {
  public val Context: SearchParam<ConceptMap, CodeableConcept> =
    SimpleSearchParam<ConceptMap, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ConceptMap.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val ContextQuantity: SearchParam<ConceptMap, Quantity> =
    SimpleSearchParam<ConceptMap, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ConceptMap.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<ConceptMap, Coding> =
    SimpleSearchParam<ConceptMap, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ConceptMap.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<ConceptMap, UsageContext> =
    SimpleSearchParam<ConceptMap, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ConceptMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<ConceptMap, UsageContext> =
    SimpleSearchParam<ConceptMap, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ConceptMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<ConceptMap, DateTime> =
    SimpleSearchParam<ConceptMap, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ConceptMap.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Dependson: SearchParam<ConceptMap, Uri> =
    SimpleSearchParam<ConceptMap, Uri>(
      name = "dependson",
      type = SearchParamType.fromCode("uri"),
      expression = "ConceptMap.group.element.target.dependsOn.property",
      extractor = { resource ->
        resource.group
          .flatMap { it.element }
          .flatMap { it.target }
          .flatMap { it.dependsOn }
          .map { it.`property` }
      },
    )

  public val Description: SearchParam<ConceptMap, Markdown> =
    SimpleSearchParam<ConceptMap, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ConceptMap.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Identifier: SearchParam<ConceptMap, Identifier> =
    SimpleSearchParam<ConceptMap, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ConceptMap.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val Jurisdiction: SearchParam<ConceptMap, CodeableConcept> =
    SimpleSearchParam<ConceptMap, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ConceptMap.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Name: SearchParam<ConceptMap, String> =
    SimpleSearchParam<ConceptMap, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "ConceptMap.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Other: SearchParam<ConceptMap, Canonical> =
    SimpleSearchParam<ConceptMap, Canonical>(
      name = "other",
      type = SearchParamType.fromCode("reference"),
      expression = "ConceptMap.group.unmapped.url",
      target = listOf(ConceptMap::class),
      extractor = { resource -> resource.group.mapNotNull { it.unmapped }.mapNotNull { it.url } },
    )

  public val Product: SearchParam<ConceptMap, Any> =
    SimpleSearchParam<ConceptMap, Any>(
      name = "product",
      type = SearchParamType.fromCode("uri"),
      expression = "ConceptMap.group.element.target.product.property",
      extractor = { emptyList() },
    )

  public val Publisher: SearchParam<ConceptMap, String> =
    SimpleSearchParam<ConceptMap, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ConceptMap.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Source: SearchParam<ConceptMap, Canonical> =
    SimpleSearchParam<ConceptMap, Canonical>(
      name = "source",
      type = SearchParamType.fromCode("reference"),
      expression = "(ConceptMap.source as canonical)",
      target = listOf(ValueSet::class),
      extractor = { resource ->
        listOfNotNull((resource.source as? ConceptMap.Source.Canonical)?.value)
      },
    )

  public val SourceCode: SearchParam<ConceptMap, Any> =
    SimpleSearchParam<ConceptMap, Any>(
      name = "source-code",
      type = SearchParamType.fromCode("token"),
      expression = "ConceptMap.group.element.code",
      extractor = { resource -> resource.group.flatMap { it.element }.mapNotNull { it.code } },
    )

  public val SourceSystem: SearchParam<ConceptMap, Uri> =
    SimpleSearchParam<ConceptMap, Uri>(
      name = "source-system",
      type = SearchParamType.fromCode("uri"),
      expression = "ConceptMap.group.source",
      extractor = { resource -> resource.group.mapNotNull { it.source } },
    )

  public val SourceUri: SearchParam<ConceptMap, Uri> =
    SimpleSearchParam<ConceptMap, Uri>(
      name = "source-uri",
      type = SearchParamType.fromCode("reference"),
      expression = "(ConceptMap.source as uri)",
      target = listOf(ValueSet::class),
      extractor = { resource -> listOfNotNull((resource.source as? ConceptMap.Source.Uri)?.value) },
    )

  public val Status: SearchParam<ConceptMap, Any> =
    SimpleSearchParam<ConceptMap, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ConceptMap.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Target: SearchParam<ConceptMap, Canonical> =
    SimpleSearchParam<ConceptMap, Canonical>(
      name = "target",
      type = SearchParamType.fromCode("reference"),
      expression = "(ConceptMap.target as canonical)",
      target = listOf(ValueSet::class),
      extractor = { resource ->
        listOfNotNull((resource.target as? ConceptMap.Target.Canonical)?.value)
      },
    )

  public val TargetCode: SearchParam<ConceptMap, Any> =
    SimpleSearchParam<ConceptMap, Any>(
      name = "target-code",
      type = SearchParamType.fromCode("token"),
      expression = "ConceptMap.group.element.target.code",
      extractor = { resource ->
        resource.group.flatMap { it.element }.flatMap { it.target }.mapNotNull { it.code }
      },
    )

  public val TargetSystem: SearchParam<ConceptMap, Uri> =
    SimpleSearchParam<ConceptMap, Uri>(
      name = "target-system",
      type = SearchParamType.fromCode("uri"),
      expression = "ConceptMap.group.target",
      extractor = { resource -> resource.group.mapNotNull { it.target } },
    )

  public val TargetUri: SearchParam<ConceptMap, Uri> =
    SimpleSearchParam<ConceptMap, Uri>(
      name = "target-uri",
      type = SearchParamType.fromCode("reference"),
      expression = "(ConceptMap.target as uri)",
      target = listOf(ValueSet::class),
      extractor = { resource -> listOfNotNull((resource.target as? ConceptMap.Target.Uri)?.value) },
    )

  public val Title: SearchParam<ConceptMap, String> =
    SimpleSearchParam<ConceptMap, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ConceptMap.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Url: SearchParam<ConceptMap, Uri> =
    SimpleSearchParam<ConceptMap, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ConceptMap.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<ConceptMap, String> =
    SimpleSearchParam<ConceptMap, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ConceptMap.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the ConceptMap resource type. */
  public val ALL: List<SearchParam<ConceptMap, *>> =
    listOf(
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Dependson,
      Description,
      Identifier,
      Jurisdiction,
      Name,
      Other,
      Product,
      Publisher,
      Source,
      SourceCode,
      SourceSystem,
      SourceUri,
      Status,
      Target,
      TargetCode,
      TargetSystem,
      TargetUri,
      Title,
      Url,
      Version,
    )
}
