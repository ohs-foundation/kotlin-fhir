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
import dev.ohs.fhir.model.r5.PackagedProductDefinition
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PackagedProductDefinition] resource type. */
public sealed class PackagedProductDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: PackagedProductDefinition): List<T>

  public data object Biological : PackagedProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "biological"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<KotlinString> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.packaging?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object ContainedItem : PackagedProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "contained-item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<KotlinString> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.packaging?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Device : PackagedProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<KotlinString> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.packaging?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Identifier :
    PackagedProductDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PackagedProductDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: PackagedProductDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object ManufacturedItem : PackagedProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "manufactured-item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<KotlinString> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.packaging?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Medication : PackagedProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<KotlinString> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.packaging?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Name : PackagedProductDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PackagedProductDefinition.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object Nutrition : PackagedProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "nutrition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<KotlinString> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.packaging?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Package : PackagedProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "package"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<KotlinString> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.packaging?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object PackageFor : PackagedProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "package-for"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "PackagedProductDefinition.packageFor"

    public override val target: List<KotlinString> = listOf("MedicinalProductDefinition")

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      resource.packageFor
  }

  public data object Status : PackagedProductDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PackagedProductDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.status)
  }

  public companion object {
    /** All search parameters for the PackagedProductDefinition resource type. */
    public val ALL: List<PackagedProductDefinitionSearchParam<*>> =
      listOf(
        Biological,
        ContainedItem,
        Device,
        Identifier,
        ManufacturedItem,
        Medication,
        Name,
        Nutrition,
        Package,
        PackageFor,
        Status,
      )
  }
}
