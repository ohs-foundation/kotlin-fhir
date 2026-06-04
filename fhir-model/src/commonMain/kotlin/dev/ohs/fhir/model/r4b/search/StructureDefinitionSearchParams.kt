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

import dev.ohs.fhir.model.r4b.Boolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.StructureDefinition
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.ValueSet
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [StructureDefinition] resource type. */
public object StructureDefinitionSearchParams {
  public val `abstract`: SearchParam<StructureDefinition, Boolean> =
    SearchParam<StructureDefinition, Boolean>(
      name = "abstract",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.abstract",
      extractor = { resource -> listOf(resource.`abstract`) },
    )

  public val base: SearchParam<StructureDefinition, Canonical> =
    SearchParam<StructureDefinition, Canonical>(
      name = "base",
      type = SearchParamType.fromCode("reference"),
      expression = "StructureDefinition.baseDefinition",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> listOfNotNull(resource.baseDefinition) },
    )

  public val basePath: SearchParam<StructureDefinition, String> =
    SearchParam<StructureDefinition, String>(
      name = "base-path",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.snapshot.element.base.path",
      extractor = { resource ->
        (resource.snapshot?.element ?: emptyList()).mapNotNull { it.base }.map { it.path }
      },
    )

  public val context: SearchParam<StructureDefinition, CodeableConcept> =
    SearchParam<StructureDefinition, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(StructureDefinition.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<StructureDefinition, Quantity> =
    SearchParam<StructureDefinition, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(StructureDefinition.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<StructureDefinition, Coding> =
    SearchParam<StructureDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<StructureDefinition, UsageContext> =
    SearchParam<StructureDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<StructureDefinition, UsageContext> =
    SearchParam<StructureDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "StructureDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<StructureDefinition, DateTime> =
    SearchParam<StructureDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "StructureDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val derivation: SearchParam<StructureDefinition, Any> =
    SearchParam<StructureDefinition, Any>(
      name = "derivation",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.derivation",
      extractor = { resource -> listOfNotNull(resource.derivation) },
    )

  public val description: SearchParam<StructureDefinition, Markdown> =
    SearchParam<StructureDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "StructureDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val experimental: SearchParam<StructureDefinition, Boolean> =
    SearchParam<StructureDefinition, Boolean>(
      name = "experimental",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.experimental",
      extractor = { resource -> listOfNotNull(resource.experimental) },
    )

  public val extContext: SearchParam<StructureDefinition, Any> =
    SearchParam<StructureDefinition, Any>(
      name = "ext-context",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.context.type",
      extractor = { resource -> resource.context.map { it.type } },
    )

  public val identifier: SearchParam<StructureDefinition, Identifier> =
    SearchParam<StructureDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<StructureDefinition, CodeableConcept> =
    SearchParam<StructureDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val keyword: SearchParam<StructureDefinition, Coding> =
    SearchParam<StructureDefinition, Coding>(
      name = "keyword",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.keyword",
      extractor = { resource -> resource.keyword },
    )

  public val kind: SearchParam<StructureDefinition, Any> =
    SearchParam<StructureDefinition, Any>(
      name = "kind",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.kind",
      extractor = { resource -> listOf(resource.kind) },
    )

  public val name: SearchParam<StructureDefinition, String> =
    SearchParam<StructureDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "StructureDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val path: SearchParam<StructureDefinition, String> =
    SearchParam<StructureDefinition, String>(
      name = "path",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.snapshot.element.path",
      extractor = { resource -> (resource.snapshot?.element ?: emptyList()).map { it.path } },
    )

  public val publisher: SearchParam<StructureDefinition, String> =
    SearchParam<StructureDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "StructureDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<StructureDefinition, Any> =
    SearchParam<StructureDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<StructureDefinition, String> =
    SearchParam<StructureDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "StructureDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val type: SearchParam<StructureDefinition, Uri> =
    SearchParam<StructureDefinition, Uri>(
      name = "type",
      type = SearchParamType.fromCode("uri"),
      expression = "StructureDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val url: SearchParam<StructureDefinition, Uri> =
    SearchParam<StructureDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "StructureDefinition.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val valueset: SearchParam<StructureDefinition, Canonical> =
    SearchParam<StructureDefinition, Canonical>(
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

  public val version: SearchParam<StructureDefinition, String> =
    SearchParam<StructureDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "StructureDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the StructureDefinition resource type. */
  public val all: List<SearchParam<StructureDefinition, *>> =
    listOf(
      `abstract`,
      base,
      basePath,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      derivation,
      description,
      experimental,
      extContext,
      identifier,
      jurisdiction,
      keyword,
      kind,
      name,
      path,
      publisher,
      status,
      title,
      type,
      url,
      valueset,
      version,
    )
}
