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

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.OperationDefinition
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.StructureDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [OperationDefinition] resource type. */
public object OperationDefinitionSearchParams {
  public val base: SearchParam<OperationDefinition, Canonical> =
    SearchParam(
      name = "base",
      type = SearchParamType.fromCode("reference"),
      expression = "OperationDefinition.base",
      target = listOf(OperationDefinition::class),
      extractor = { resource -> listOfNotNull(resource.base) },
    )

  public val code: SearchParam<OperationDefinition, Any> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val context: SearchParam<OperationDefinition, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(OperationDefinition.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<OperationDefinition, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(OperationDefinition.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<OperationDefinition, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<OperationDefinition, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "OperationDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<OperationDefinition, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "OperationDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<OperationDefinition, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "OperationDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<OperationDefinition, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "OperationDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val inputProfile: SearchParam<OperationDefinition, Canonical> =
    SearchParam(
      name = "input-profile",
      type = SearchParamType.fromCode("reference"),
      expression = "OperationDefinition.inputProfile",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> listOfNotNull(resource.inputProfile) },
    )

  public val instance: SearchParam<OperationDefinition, Boolean> =
    SearchParam(
      name = "instance",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.instance",
      extractor = { resource -> listOf(resource.instance) },
    )

  public val jurisdiction: SearchParam<OperationDefinition, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val kind: SearchParam<OperationDefinition, Any> =
    SearchParam(
      name = "kind",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.kind",
      extractor = { resource -> listOf(resource.kind) },
    )

  public val name: SearchParam<OperationDefinition, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "OperationDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val outputProfile: SearchParam<OperationDefinition, Canonical> =
    SearchParam(
      name = "output-profile",
      type = SearchParamType.fromCode("reference"),
      expression = "OperationDefinition.outputProfile",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> listOfNotNull(resource.outputProfile) },
    )

  public val publisher: SearchParam<OperationDefinition, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "OperationDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<OperationDefinition, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val system: SearchParam<OperationDefinition, Boolean> =
    SearchParam(
      name = "system",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.system",
      extractor = { resource -> listOf(resource.system) },
    )

  public val title: SearchParam<OperationDefinition, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "OperationDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val type: SearchParam<OperationDefinition, Boolean> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val url: SearchParam<OperationDefinition, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "OperationDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<OperationDefinition, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<OperationDefinition, *>> = listOf()

  /**
   * Supported search parameters for the OperationDefinition resource type. Entries in [unsupported]
   * are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<OperationDefinition, *>> =
    listOf(
      base,
      code,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      inputProfile,
      instance,
      jurisdiction,
      kind,
      name,
      outputProfile,
      publisher,
      status,
      system,
      title,
      type,
      url,
      version,
    ) - unsupported.toSet()
}
