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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.StructureMap
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [StructureMap] resource type. */
public object StructureMapSearchParams {
  public val context: SearchParam<StructureMap, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(StructureMap.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<StructureMap, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(StructureMap.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<StructureMap, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "StructureMap.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<StructureMap, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "StructureMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<StructureMap, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "StructureMap.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<StructureMap, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "StructureMap.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<StructureMap, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "StructureMap.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<StructureMap, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "StructureMap.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<StructureMap, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "StructureMap.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<StructureMap, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "StructureMap.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val publisher: SearchParam<StructureMap, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "StructureMap.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<StructureMap, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "StructureMap.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<StructureMap, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "StructureMap.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<StructureMap, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "StructureMap.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val version: SearchParam<StructureMap, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "StructureMap.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<StructureMap, *>> = listOf()

  /**
   * Supported search parameters for the StructureMap resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<StructureMap, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      identifier,
      jurisdiction,
      name,
      publisher,
      status,
      title,
      url,
      version,
    )
}
