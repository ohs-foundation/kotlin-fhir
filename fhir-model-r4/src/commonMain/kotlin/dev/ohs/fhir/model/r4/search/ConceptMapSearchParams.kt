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
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ConceptMap
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ConceptMap] resource type. */
public object ConceptMapSearchParams {
  public val context: SearchParam<ConceptMap, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(ConceptMap.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<ConceptMap, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression =
        "(ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range)",
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

  public val contextType: SearchParam<ConceptMap, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "ConceptMap.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<ConceptMap, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "ConceptMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<ConceptMap, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "ConceptMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<ConceptMap, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "ConceptMap.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val dependson: SearchParam<ConceptMap, Uri> =
    SearchParam(
      name = "dependson",
      type = SearchParamType.Uri,
      expression = "ConceptMap.group.element.target.dependsOn.property",
      extractor = { resource ->
        resource.group
          .flatMap { it.element }
          .flatMap { it.target }
          .flatMap { it.dependsOn }
          .map { it.`property` }
      },
    )

  public val description: SearchParam<ConceptMap, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "ConceptMap.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<ConceptMap, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ConceptMap.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val jurisdiction: SearchParam<ConceptMap, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "ConceptMap.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<ConceptMap, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "ConceptMap.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val other: SearchParam<ConceptMap, Canonical> =
    SearchParam(
      name = "other",
      type = SearchParamType.Reference,
      expression = "ConceptMap.group.unmapped.url",
      target = listOf(ConceptMap::class),
      extractor = { resource -> resource.group.mapNotNull { it.unmapped }.mapNotNull { it.url } },
    )

  public val product: SearchParam<ConceptMap, Any> =
    SearchParam(
      name = "product",
      type = SearchParamType.Uri,
      expression = "ConceptMap.group.element.target.product.property",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'product' has expression 'ConceptMap.group.element.target.product.property' which is not yet supported."
        )
      },
    )

  public val publisher: SearchParam<ConceptMap, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "ConceptMap.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val source: SearchParam<ConceptMap, Canonical> =
    SearchParam(
      name = "source",
      type = SearchParamType.Reference,
      expression = "(ConceptMap.source as canonical)",
      target = listOf(ValueSet::class),
      extractor = { resource ->
        listOfNotNull((resource.source as? ConceptMap.Source.Canonical)?.value)
      },
    )

  public val sourceCode: SearchParam<ConceptMap, Any> =
    SearchParam(
      name = "source-code",
      type = SearchParamType.Token,
      expression = "ConceptMap.group.element.code",
      extractor = { resource -> resource.group.flatMap { it.element }.mapNotNull { it.code } },
    )

  public val sourceSystem: SearchParam<ConceptMap, Uri> =
    SearchParam(
      name = "source-system",
      type = SearchParamType.Uri,
      expression = "ConceptMap.group.source",
      extractor = { resource -> resource.group.mapNotNull { it.source } },
    )

  public val sourceUri: SearchParam<ConceptMap, Uri> =
    SearchParam(
      name = "source-uri",
      type = SearchParamType.Reference,
      expression = "(ConceptMap.source as uri)",
      target = listOf(ValueSet::class),
      extractor = { resource -> listOfNotNull((resource.source as? ConceptMap.Source.Uri)?.value) },
    )

  public val status: SearchParam<ConceptMap, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ConceptMap.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val target: SearchParam<ConceptMap, Canonical> =
    SearchParam(
      name = "target",
      type = SearchParamType.Reference,
      expression = "(ConceptMap.target as canonical)",
      target = listOf(ValueSet::class),
      extractor = { resource ->
        listOfNotNull((resource.target as? ConceptMap.Target.Canonical)?.value)
      },
    )

  public val targetCode: SearchParam<ConceptMap, Any> =
    SearchParam(
      name = "target-code",
      type = SearchParamType.Token,
      expression = "ConceptMap.group.element.target.code",
      extractor = { resource ->
        resource.group.flatMap { it.element }.flatMap { it.target }.mapNotNull { it.code }
      },
    )

  public val targetSystem: SearchParam<ConceptMap, Uri> =
    SearchParam(
      name = "target-system",
      type = SearchParamType.Uri,
      expression = "ConceptMap.group.target",
      extractor = { resource -> resource.group.mapNotNull { it.target } },
    )

  public val targetUri: SearchParam<ConceptMap, Uri> =
    SearchParam(
      name = "target-uri",
      type = SearchParamType.Reference,
      expression = "(ConceptMap.target as uri)",
      target = listOf(ValueSet::class),
      extractor = { resource -> listOfNotNull((resource.target as? ConceptMap.Target.Uri)?.value) },
    )

  public val title: SearchParam<ConceptMap, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "ConceptMap.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<ConceptMap, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "ConceptMap.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<ConceptMap, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "ConceptMap.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ConceptMap, *>> = listOf(product)

  /**
   * Supported search parameters for the ConceptMap resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ConceptMap, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      dependson,
      description,
      identifier,
      jurisdiction,
      name,
      other,
      publisher,
      source,
      sourceCode,
      sourceSystem,
      sourceUri,
      status,
      target,
      targetCode,
      targetSystem,
      targetUri,
      title,
      url,
      version,
    )
}
