/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PackagedProductDefinition] resource type. */
public sealed class PackagedProductDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: PackagedProductDefinition): List<T>

  public data object Biological : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "biological"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<String> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object ContainedItem : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "contained-item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<String> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object Device : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<String> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object Identifier : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PackagedProductDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object ManufacturedItem : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "manufactured-item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<String> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object Medication : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<String> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object Name : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PackagedProductDefinition.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object Nutrition : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "nutrition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<String> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object Package : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "package"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "PackagedProductDefinition.packaging.containedItem.item.reference"

    public override val target: List<String> =
      listOf(
        "DeviceDefinition",
        "NutritionProduct",
        "BiologicallyDerivedProduct",
        "PackagedProductDefinition",
        "ManufacturedItemDefinition",
      )

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object PackageFor : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "package-for"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "PackagedProductDefinition.packageFor"

    public override val target: List<String> = listOf("MedicinalProductDefinition")

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
  }

  public data object Status : PackagedProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "PackagedProductDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Any> = emptyList()
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
