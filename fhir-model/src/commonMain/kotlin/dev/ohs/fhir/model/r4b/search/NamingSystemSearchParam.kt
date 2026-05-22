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
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.NamingSystem
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [NamingSystem] resource type. */
public object NamingSystemSearchParam {
  public val Contact: SearchParam<NamingSystem, String> =
    SimpleSearchParam<NamingSystem, String>(
      name = "contact",
      type = SearchParamType.fromCode("string"),
      expression = "NamingSystem.contact.name",
      extractor = { resource -> resource.contact.mapNotNull { it.name } },
    )

  public val Context: SearchParam<NamingSystem, CodeableConcept> =
    SimpleSearchParam<NamingSystem, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(NamingSystem.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.value as? UsageContext.Value.CodeableConcept)?.value }
      },
    )

  public val ContextQuantity: SearchParam<NamingSystem, Quantity> =
    SimpleSearchParam<NamingSystem, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(NamingSystem.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.value as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<NamingSystem, Coding> =
    SimpleSearchParam<NamingSystem, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "NamingSystem.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<NamingSystem, UsageContext> =
    SimpleSearchParam<NamingSystem, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "NamingSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<NamingSystem, UsageContext> =
    SimpleSearchParam<NamingSystem, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "NamingSystem.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<NamingSystem, DateTime> =
    SimpleSearchParam<NamingSystem, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "NamingSystem.date",
      extractor = { resource -> listOf(resource.date) },
    )

  public val Description: SearchParam<NamingSystem, Markdown> =
    SimpleSearchParam<NamingSystem, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "NamingSystem.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val IdType: SearchParam<NamingSystem, Any> =
    SimpleSearchParam<NamingSystem, Any>(
      name = "id-type",
      type = SearchParamType.fromCode("token"),
      expression = "NamingSystem.uniqueId.type",
      extractor = { resource -> resource.uniqueId.map { it.type } },
    )

  public val Jurisdiction: SearchParam<NamingSystem, CodeableConcept> =
    SimpleSearchParam<NamingSystem, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "NamingSystem.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Kind: SearchParam<NamingSystem, Any> =
    SimpleSearchParam<NamingSystem, Any>(
      name = "kind",
      type = SearchParamType.fromCode("token"),
      expression = "NamingSystem.kind",
      extractor = { resource -> listOf(resource.kind) },
    )

  public val Name: SearchParam<NamingSystem, String> =
    SimpleSearchParam<NamingSystem, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "NamingSystem.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val Period: SearchParam<NamingSystem, Period> =
    SimpleSearchParam<NamingSystem, Period>(
      name = "period",
      type = SearchParamType.fromCode("date"),
      expression = "NamingSystem.uniqueId.period",
      extractor = { resource -> resource.uniqueId.mapNotNull { it.period } },
    )

  public val Publisher: SearchParam<NamingSystem, String> =
    SimpleSearchParam<NamingSystem, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "NamingSystem.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Responsible: SearchParam<NamingSystem, String> =
    SimpleSearchParam<NamingSystem, String>(
      name = "responsible",
      type = SearchParamType.fromCode("string"),
      expression = "NamingSystem.responsible",
      extractor = { resource -> listOfNotNull(resource.responsible) },
    )

  public val Status: SearchParam<NamingSystem, Any> =
    SimpleSearchParam<NamingSystem, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "NamingSystem.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Telecom: SearchParam<NamingSystem, ContactPoint> =
    SimpleSearchParam<NamingSystem, ContactPoint>(
      name = "telecom",
      type = SearchParamType.fromCode("token"),
      expression = "NamingSystem.contact.telecom",
      extractor = { resource -> resource.contact.flatMap { it.telecom } },
    )

  public val Type: SearchParam<NamingSystem, CodeableConcept> =
    SimpleSearchParam<NamingSystem, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "NamingSystem.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val Value: SearchParam<NamingSystem, String> =
    SimpleSearchParam<NamingSystem, String>(
      name = "value",
      type = SearchParamType.fromCode("string"),
      expression = "NamingSystem.uniqueId.value",
      extractor = { resource -> resource.uniqueId.map { it.value } },
    )

  /** All search parameters for the NamingSystem resource type. */
  public val ALL: List<SearchParam<NamingSystem, *>> =
    listOf(
      Contact,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      IdType,
      Jurisdiction,
      Kind,
      Name,
      Period,
      Publisher,
      Responsible,
      Status,
      Telecom,
      Type,
      Value,
    )
}
