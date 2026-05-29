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
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.OperationDefinition
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.StructureDefinition
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [OperationDefinition] resource type. */
public object OperationDefinitionSearchParam {
  public val Base: SearchParam<OperationDefinition, Canonical> =
    SimpleSearchParam<OperationDefinition, Canonical>(
      name = "base",
      type = SearchParamType.fromCode("reference"),
      expression = "OperationDefinition.base",
      target = listOf(OperationDefinition::class),
      extractor = { resource -> listOfNotNull(resource.base) },
    )

  public val Code: SearchParam<OperationDefinition, Any> =
    SimpleSearchParam<OperationDefinition, Any>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val Context: SearchParam<OperationDefinition, CodeableConcept> =
    SimpleSearchParam<OperationDefinition, CodeableConcept>(
      name = "context",
      type = SearchParamType.fromCode("token"),
      expression = "(OperationDefinition.useContext.value as CodeableConcept)",
      extractor = { resource ->
        resource.useContext.mapNotNull {
          (it.`value` as? UsageContext.Value.CodeableConcept)?.value
        }
      },
    )

  public val ContextQuantity: SearchParam<OperationDefinition, Quantity> =
    SimpleSearchParam<OperationDefinition, Quantity>(
      name = "context-quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "(OperationDefinition.useContext.value as Quantity)",
      extractor = { resource ->
        resource.useContext.mapNotNull { (it.`value` as? UsageContext.Value.Quantity)?.value }
      },
    )

  public val ContextType: SearchParam<OperationDefinition, Coding> =
    SimpleSearchParam<OperationDefinition, Coding>(
      name = "context-type",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.useContext.code",
      extractor = { resource -> resource.useContext.map { it.code } },
    )

  public val ContextTypeQuantity: SearchParam<OperationDefinition, UsageContext> =
    SimpleSearchParam<OperationDefinition, UsageContext>(
      name = "context-type-quantity",
      type = SearchParamType.fromCode("composite"),
      expression = "OperationDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val ContextTypeValue: SearchParam<OperationDefinition, UsageContext> =
    SimpleSearchParam<OperationDefinition, UsageContext>(
      name = "context-type-value",
      type = SearchParamType.fromCode("composite"),
      expression = "OperationDefinition.useContext",
      extractor = { resource -> resource.useContext },
    )

  public val Date: SearchParam<OperationDefinition, DateTime> =
    SimpleSearchParam<OperationDefinition, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "OperationDefinition.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Description: SearchParam<OperationDefinition, Markdown> =
    SimpleSearchParam<OperationDefinition, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "OperationDefinition.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val InputProfile: SearchParam<OperationDefinition, Canonical> =
    SimpleSearchParam<OperationDefinition, Canonical>(
      name = "input-profile",
      type = SearchParamType.fromCode("reference"),
      expression = "OperationDefinition.inputProfile",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> listOfNotNull(resource.inputProfile) },
    )

  public val Instance: SearchParam<OperationDefinition, Boolean> =
    SimpleSearchParam<OperationDefinition, Boolean>(
      name = "instance",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.instance",
      extractor = { resource -> listOf(resource.instance) },
    )

  public val Jurisdiction: SearchParam<OperationDefinition, CodeableConcept> =
    SimpleSearchParam<OperationDefinition, CodeableConcept>(
      name = "jurisdiction",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.jurisdiction",
      extractor = { resource -> resource.jurisdiction },
    )

  public val Kind: SearchParam<OperationDefinition, Any> =
    SimpleSearchParam<OperationDefinition, Any>(
      name = "kind",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.kind",
      extractor = { resource -> listOf(resource.kind) },
    )

  public val Name: SearchParam<OperationDefinition, String> =
    SimpleSearchParam<OperationDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "OperationDefinition.name",
      extractor = { resource -> listOf(resource.name) },
    )

  public val OutputProfile: SearchParam<OperationDefinition, Canonical> =
    SimpleSearchParam<OperationDefinition, Canonical>(
      name = "output-profile",
      type = SearchParamType.fromCode("reference"),
      expression = "OperationDefinition.outputProfile",
      target = listOf(StructureDefinition::class),
      extractor = { resource -> listOfNotNull(resource.outputProfile) },
    )

  public val Publisher: SearchParam<OperationDefinition, String> =
    SimpleSearchParam<OperationDefinition, String>(
      name = "publisher",
      type = SearchParamType.fromCode("string"),
      expression = "OperationDefinition.publisher",
      extractor = { resource -> listOfNotNull(resource.publisher) },
    )

  public val Status: SearchParam<OperationDefinition, Any> =
    SimpleSearchParam<OperationDefinition, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val System: SearchParam<OperationDefinition, Boolean> =
    SimpleSearchParam<OperationDefinition, Boolean>(
      name = "system",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.system",
      extractor = { resource -> listOf(resource.system) },
    )

  public val Title: SearchParam<OperationDefinition, String> =
    SimpleSearchParam<OperationDefinition, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "OperationDefinition.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  public val Type: SearchParam<OperationDefinition, Boolean> =
    SimpleSearchParam<OperationDefinition, Boolean>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val Url: SearchParam<OperationDefinition, Uri> =
    SimpleSearchParam<OperationDefinition, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "OperationDefinition.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<OperationDefinition, String> =
    SimpleSearchParam<OperationDefinition, String>(
      name = "version",
      type = SearchParamType.fromCode("token"),
      expression = "OperationDefinition.version",
      extractor = { resource -> listOfNotNull(resource.version) },
    )

  /** All search parameters for the OperationDefinition resource type. */
  public val ALL: List<SearchParam<OperationDefinition, *>> =
    listOf(
      Base,
      Code,
      Context,
      ContextQuantity,
      ContextType,
      ContextTypeQuantity,
      ContextTypeValue,
      Date,
      Description,
      InputProfile,
      Instance,
      Jurisdiction,
      Kind,
      Name,
      OutputProfile,
      Publisher,
      Status,
      System,
      Title,
      Type,
      Url,
      Version,
    )
}
