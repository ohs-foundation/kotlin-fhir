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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.EvidenceVariable
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [EvidenceVariable] resource type. */
public object EvidenceVariableSearchParams {
  public val context: SearchParam<EvidenceVariable, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(EvidenceVariable.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<EvidenceVariable, Quantity> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression = "(EvidenceVariable.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val contextType: SearchParam<EvidenceVariable, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "EvidenceVariable.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<EvidenceVariable, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "EvidenceVariable.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<EvidenceVariable, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "EvidenceVariable.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<EvidenceVariable, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "EvidenceVariable.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val description: SearchParam<EvidenceVariable, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "EvidenceVariable.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val identifier: SearchParam<EvidenceVariable, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "EvidenceVariable.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val name: SearchParam<EvidenceVariable, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "EvidenceVariable.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val publisher: SearchParam<EvidenceVariable, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "EvidenceVariable.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val status: SearchParam<EvidenceVariable, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "EvidenceVariable.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val title: SearchParam<EvidenceVariable, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "EvidenceVariable.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val url: SearchParam<EvidenceVariable, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "EvidenceVariable.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<EvidenceVariable, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.Token,
      expression = "EvidenceVariable.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<EvidenceVariable, *>> = listOf()

  /**
   * Supported search parameters for the EvidenceVariable resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<EvidenceVariable, *>> =
    listOf(
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      identifier,
      name,
      publisher,
      status,
      title,
      url,
      version,
    )
}
