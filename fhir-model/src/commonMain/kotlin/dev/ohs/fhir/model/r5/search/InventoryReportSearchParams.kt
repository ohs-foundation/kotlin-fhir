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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.BiologicallyDerivedProduct
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.InventoryItem
import dev.ohs.fhir.model.r5.InventoryReport
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [InventoryReport] resource type. */
public object InventoryReportSearchParams {
  public val identifier: SearchParam<InventoryReport, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "InventoryReport.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val item: SearchParam<InventoryReport, CodeableConcept> =
    SearchParam(
      name = "item",
      type = SearchParamType.fromCode("token"),
      expression = "InventoryReport.inventoryListing.item.item.concept",
      extractor = { resource ->
        resource.inventoryListing.flatMap { it.item }.map { it.item }.mapNotNull { it.concept }
      },
    )

  public val itemReference: SearchParam<InventoryReport, Reference> =
    SearchParam(
      name = "item-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "InventoryReport.inventoryListing.item.item.reference",
      target =
        listOf(
          Device::class,
          InventoryItem::class,
          NutritionProduct::class,
          BiologicallyDerivedProduct::class,
          Medication::class,
        ),
      extractor = { resource ->
        resource.inventoryListing.flatMap { it.item }.map { it.item }.mapNotNull { it.reference }
      },
    )

  public val status: SearchParam<InventoryReport, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "InventoryReport.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the InventoryReport resource type. */
  public val all: List<SearchParam<InventoryReport, *>> =
    listOf(identifier, item, itemReference, status)
}
