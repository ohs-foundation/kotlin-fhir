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
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ManufacturedItemDefinition
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.PackagedProductDefinition
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PackagedProductDefinition] resource type. */
public object PackagedProductDefinitionSearchParams {
  public val biological: SearchParam<PackagedProductDefinition, Reference> =
    SearchParam(
      name = "biological",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packaging.containedItem.item.reference",
      target =
        listOf(
          DeviceDefinition::class,
          NutritionProduct::class,
          BiologicallyDerivedProduct::class,
          PackagedProductDefinition::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource ->
        (resource.packaging?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val containedItem: SearchParam<PackagedProductDefinition, Reference> =
    SearchParam(
      name = "contained-item",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packaging.containedItem.item.reference",
      target =
        listOf(
          DeviceDefinition::class,
          NutritionProduct::class,
          BiologicallyDerivedProduct::class,
          PackagedProductDefinition::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource ->
        (resource.packaging?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val device: SearchParam<PackagedProductDefinition, Reference> =
    SearchParam(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packaging.containedItem.item.reference",
      target =
        listOf(
          DeviceDefinition::class,
          NutritionProduct::class,
          BiologicallyDerivedProduct::class,
          PackagedProductDefinition::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource ->
        (resource.packaging?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val identifier: SearchParam<PackagedProductDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "PackagedProductDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val manufacturedItem: SearchParam<PackagedProductDefinition, Reference> =
    SearchParam(
      name = "manufactured-item",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packaging.containedItem.item.reference",
      target =
        listOf(
          DeviceDefinition::class,
          NutritionProduct::class,
          BiologicallyDerivedProduct::class,
          PackagedProductDefinition::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource ->
        (resource.packaging?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val medication: SearchParam<PackagedProductDefinition, Reference> =
    SearchParam(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packaging.containedItem.item.reference",
      target =
        listOf(
          DeviceDefinition::class,
          NutritionProduct::class,
          BiologicallyDerivedProduct::class,
          PackagedProductDefinition::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource ->
        (resource.packaging?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val name: SearchParam<PackagedProductDefinition, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("token"),
      expression = "PackagedProductDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val nutrition: SearchParam<PackagedProductDefinition, Reference> =
    SearchParam(
      name = "nutrition",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packaging.containedItem.item.reference",
      target =
        listOf(
          DeviceDefinition::class,
          NutritionProduct::class,
          BiologicallyDerivedProduct::class,
          PackagedProductDefinition::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource ->
        (resource.packaging?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val `package`: SearchParam<PackagedProductDefinition, Reference> =
    SearchParam(
      name = "package",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packaging.containedItem.item.reference",
      target =
        listOf(
          DeviceDefinition::class,
          NutritionProduct::class,
          BiologicallyDerivedProduct::class,
          PackagedProductDefinition::class,
          ManufacturedItemDefinition::class,
        ),
      extractor = { resource ->
        (resource.packaging?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val packageFor: SearchParam<PackagedProductDefinition, Reference> =
    SearchParam(
      name = "package-for",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packageFor",
      target = listOf(MedicinalProductDefinition::class),
      extractor = { resource -> resource.packageFor },
    )

  public val status: SearchParam<PackagedProductDefinition, CodeableConcept> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "PackagedProductDefinition.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<PackagedProductDefinition, *>> = listOf()

  /**
   * Supported search parameters for the PackagedProductDefinition resource type. Iterating `all`
   * and calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded
   * from this list.
   */
  public val all: List<SearchParam<PackagedProductDefinition, *>> =
    listOf(
      biological,
      containedItem,
      device,
      identifier,
      manufacturedItem,
      medication,
      name,
      nutrition,
      `package`,
      packageFor,
      status,
    )
}
