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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.InventoryReport
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [InventoryReport] resource type. */
public object InventoryReportSearchParam {
  /** All search parameters for the InventoryReport resource type. */
  public val ALL: List<SearchParam<InventoryReport, *>> =
    listOf(Identifier, Item, ItemReference, Status)

  public data object Identifier : SearchParam<InventoryReport, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InventoryReport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InventoryReport): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Item : SearchParam<InventoryReport, CodeableConcept> {
    public override val paramName: String = "item"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InventoryReport.inventoryListing.item.item.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InventoryReport): List<CodeableConcept> =
      resource.inventoryListing.flatMap { it.item }.map { it.item }.mapNotNull { it.concept }
  }

  public data object ItemReference : SearchParam<InventoryReport, Reference> {
    public override val paramName: String = "item-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "InventoryReport.inventoryListing.item.item.reference"

    public override val target: List<String> =
      listOf(
        "Device",
        "InventoryItem",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "Medication",
      )

    public override fun extract(resource: InventoryReport): List<Reference> =
      resource.inventoryListing.flatMap { it.item }.map { it.item }.mapNotNull { it.reference }
  }

  public data object Status : SearchParam<InventoryReport, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InventoryReport.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: InventoryReport): List<Any> = listOf(resource.status)
  }
}
