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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.NamingSystem
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NamingSystem] resource type. */
public object NamingSystemSearchParams {
  public val contact: SearchParam<NamingSystem, String> =
    SearchParam(
      name = "contact",
      type = SearchParamType.String,
      expression = "NamingSystem.contact.name",
      extractor = { resource -> resource.contact.mapNotNull { it.name } },
    )

  public val context: SearchParam<NamingSystem, CodeableConcept> =
    SearchParam(
      name = "context",
      type = SearchParamType.Token,
      expression = "(NamingSystem.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val contextQuantity: SearchParam<NamingSystem, Any> =
    SearchParam(
      name = "context-quantity",
      type = SearchParamType.Quantity,
      expression =
        "(NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range)",
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

  public val contextType: SearchParam<NamingSystem, Coding> =
    SearchParam(
      name = "context-type",
      type = SearchParamType.Token,
      expression = "NamingSystem.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val contextTypeQuantity: SearchParam<NamingSystem, UsageContext> =
    SearchParam(
      name = "context-type-quantity",
      type = SearchParamType.Composite,
      expression = "NamingSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val contextTypeValue: SearchParam<NamingSystem, UsageContext> =
    SearchParam(
      name = "context-type-value",
      type = SearchParamType.Composite,
      expression = "NamingSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val date: SearchParam<NamingSystem, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "NamingSystem.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val description: SearchParam<NamingSystem, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "NamingSystem.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val idType: SearchParam<NamingSystem, Any> =
    SearchParam(
      name = "id-type",
      type = SearchParamType.Token,
      expression = "NamingSystem.uniqueId.type",
      extractor = { resource -> resource.uniqueId.map { it.type } },
    )

  public val jurisdiction: SearchParam<NamingSystem, CodeableConcept> =
    SearchParam(
      name = "jurisdiction",
      type = SearchParamType.Token,
      expression = "NamingSystem.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val kind: SearchParam<NamingSystem, Any> =
    SearchParam(
      name = "kind",
      type = SearchParamType.Token,
      expression = "NamingSystem.kind",
      extractor = { resource -> listOf(resource.kind) },
    )

  public val name: SearchParam<NamingSystem, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "NamingSystem.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val period: SearchParam<NamingSystem, Period> =
    SearchParam(
      name = "period",
      type = SearchParamType.Date,
      expression = "NamingSystem.uniqueId.period",
      extractor = { resource -> resource.uniqueId.mapNotNull { it.period } },
    )

  public val publisher: SearchParam<NamingSystem, String> =
    SearchParam(
      name = "publisher",
      type = SearchParamType.String,
      expression = "NamingSystem.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val responsible: SearchParam<NamingSystem, String> =
    SearchParam(
      name = "responsible",
      type = SearchParamType.String,
      expression = "NamingSystem.responsible",
      extractor = { resource -> listOfNotNull(resource.responsible) },
    )

  public val status: SearchParam<NamingSystem, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "NamingSystem.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val telecom: SearchParam<NamingSystem, ContactPoint> =
    SearchParam(
      name = "telecom",
      type = SearchParamType.Token,
      expression = "NamingSystem.contact.telecom",
      extractor = { resource -> resource.contact.flatMap { it.telecom } },
    )

  public val type: SearchParam<NamingSystem, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "NamingSystem.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val `value`: SearchParam<NamingSystem, String> =
    SearchParam(
      name = "value",
      type = SearchParamType.String,
      expression = "NamingSystem.uniqueId.value",
      extractor = { resource -> resource.uniqueId.map { it.`value` } },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<NamingSystem, *>> = listOf()

  /**
   * Supported search parameters for the NamingSystem resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<NamingSystem, *>> =
    listOf(
      contact,
      context,
      contextQuantity,
      contextType,
      contextTypeQuantity,
      contextTypeValue,
      date,
      description,
      idType,
      jurisdiction,
      kind,
      name,
      period,
      publisher,
      responsible,
      status,
      telecom,
      type,
      `value`,
    )
}
