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
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.ValueSet
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ValueSet] resource type. */
public object ValueSetSearchParams {
  public val code: SearchParam<ValueSet, Any> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.expansion.contains.code",
      extractor = { resource ->
        (resource.expansion?.contains ?: emptyList()).mapNotNull { it.code }
      },
    )

  public val context: SearchParam<ValueSet, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(ValueSet.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<ValueSet, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(ValueSet.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<ValueSet, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<ValueSet, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "ValueSet.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<ValueSet, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "ValueSet.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<ValueSet, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ValueSet.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<ValueSet, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ValueSet.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val expansion: SearchParam<ValueSet, Uri> =
    SearchParam(
      name = "expansion",
      type = SearchParamType.fromCode("uri"),
      expression = "ValueSet.expansion.identifier",
      extractor = { resource -> listOfNotNull(resource.expansion?.identifier) },
    )

  public val identifier: SearchParam<ValueSet, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<ValueSet, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<ValueSet, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "ValueSet.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<ValueSet, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "ValueSet.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val reference: SearchParam<ValueSet, Uri> =
    SearchParam(
      name = "reference",
      type = SearchParamType.fromCode("uri"),
      expression = "ValueSet.compose.include.system",
      extractor = { resource ->
        (resource.compose?.include ?: emptyList()).mapNotNull { it.system }
      },
    )

  public val status: SearchParam<ValueSet, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<ValueSet, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ValueSet.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<ValueSet, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "ValueSet.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<ValueSet, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "ValueSet.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ValueSet, *>> = listOf()

  /**
   * Supported search parameters for the ValueSet resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ValueSet, *>> =
    listOf(
      code,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      expansion,
      identifier,
      jurisdiction,
      name,
      publisher,
      reference,
      status,
      title,
      url,
      version,
    )
}
