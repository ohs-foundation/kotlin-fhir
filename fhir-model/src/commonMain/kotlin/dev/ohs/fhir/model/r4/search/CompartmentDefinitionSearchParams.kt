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
import dev.ohs.fhir.model.r4.CompartmentDefinition
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CompartmentDefinition] resource type. */
public object CompartmentDefinitionSearchParams {
  public val Code: SearchParam<CompartmentDefinition, Any> =
    SimpleSearchParam<CompartmentDefinition, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val Context: SearchParam<CompartmentDefinition, CodeableConcept> =
    SimpleSearchParam<CompartmentDefinition, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(CompartmentDefinition.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val ContextQuantity: SearchParam<CompartmentDefinition, Quantity> =
    SimpleSearchParam<CompartmentDefinition, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(CompartmentDefinition.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<CompartmentDefinition, Coding> =
    SimpleSearchParam<CompartmentDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<CompartmentDefinition, UsageContext> =
    SimpleSearchParam<CompartmentDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "CompartmentDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<CompartmentDefinition, UsageContext> =
    SimpleSearchParam<CompartmentDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "CompartmentDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<CompartmentDefinition, DateTime> =
    SimpleSearchParam<CompartmentDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CompartmentDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<CompartmentDefinition, Markdown> =
    SimpleSearchParam<CompartmentDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "CompartmentDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val Name: SearchParam<CompartmentDefinition, String> =
    SimpleSearchParam<CompartmentDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "CompartmentDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val Publisher: SearchParam<CompartmentDefinition, String> =
    SimpleSearchParam<CompartmentDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "CompartmentDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Resource: SearchParam<CompartmentDefinition, Any> =
    SimpleSearchParam<CompartmentDefinition, Any>(
      name = "resource",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.resource.code",
      extractor = { resource -> resource.resource.map { it.code } },
    )

  public val Status: SearchParam<CompartmentDefinition, Any> =
    SimpleSearchParam<CompartmentDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Url: SearchParam<CompartmentDefinition, Uri> =
    SimpleSearchParam<CompartmentDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "CompartmentDefinition.url",
      extractor = { resource -> listOf(resource.url) },
    )

  public val Version: SearchParam<CompartmentDefinition, String> =
    SimpleSearchParam<CompartmentDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "CompartmentDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the CompartmentDefinition resource type. */
  public val ALL: List<SearchParam<CompartmentDefinition, *>> =
    listOf(
      Code,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      Name,
      Publisher,
      Resource,
      Status,
      Url,
      Version,
    )
}
