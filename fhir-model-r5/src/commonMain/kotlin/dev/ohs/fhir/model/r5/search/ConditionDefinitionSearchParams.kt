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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ConditionDefinition
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

/** Search parameters for the [ConditionDefinition] resource type. */
public object ConditionDefinitionSearchParams {
  public val context: SearchParam<ConditionDefinition, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(ConditionDefinition.useContext.value.ofType(CodeableConcept))",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<ConditionDefinition, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression =
        "(ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range))",
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

  public val contextType: SearchParam<ConditionDefinition, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "ConditionDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<ConditionDefinition, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "ConditionDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<ConditionDefinition, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "ConditionDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<ConditionDefinition, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "ConditionDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<ConditionDefinition, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "ConditionDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<ConditionDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ConditionDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val jurisdiction: SearchParam<ConditionDefinition, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "ConditionDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val name: SearchParam<ConditionDefinition, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "ConditionDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<ConditionDefinition, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "ConditionDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<ConditionDefinition, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ConditionDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<ConditionDefinition, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "ConditionDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<ConditionDefinition, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "ConditionDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<ConditionDefinition, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "ConditionDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ConditionDefinition, *>> = listOf()

  /**
   * Supported search parameters for the ConditionDefinition resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<ConditionDefinition, *>> =
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
