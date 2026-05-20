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
import dev.ohs.fhir.model.r4b.PackagedProductDefinition
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PackagedProductDefinition] resource type. */
public object PackagedProductDefinitionSearchParam {
  /** All search parameters for the PackagedProductDefinition resource type. */
  public val ALL: List<SearchParam<PackagedProductDefinition, *>> =
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

  public data object Biological : SearchParam<PackagedProductDefinition, Reference> {
    public override val paramName: KotlinString = "biological"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.package.containedItem.item.reference"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.`package`?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object ContainedItem : SearchParam<PackagedProductDefinition, Reference> {
    public override val paramName: KotlinString = "contained-item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.package.containedItem.item.reference"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.`package`?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Device : SearchParam<PackagedProductDefinition, Reference> {
    public override val paramName: KotlinString = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.package.containedItem.item.reference"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.`package`?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Identifier :
    SearchParam<PackagedProductDefinition, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PackagedProductDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: PackagedProductDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object ManufacturedItem : SearchParam<PackagedProductDefinition, Reference> {
    public override val paramName: KotlinString = "manufactured-item"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.package.containedItem.item.reference"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.`package`?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Medication : SearchParam<PackagedProductDefinition, Reference> {
    public override val paramName: KotlinString = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.package.containedItem.item.reference"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.`package`?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Name : SearchParam<PackagedProductDefinition, R4bString> {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PackagedProductDefinition.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<R4bString> =
      listOfNotNull(resource.name)
  }

  public data object Nutrition : SearchParam<PackagedProductDefinition, Reference> {
    public override val paramName: KotlinString = "nutrition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.package.containedItem.item.reference"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.`package`?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object Package : SearchParam<PackagedProductDefinition, Reference> {
    public override val paramName: KotlinString = "package"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString =
      "PackagedProductDefinition.package.containedItem.item.reference"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      (resource.`package`?.containedItem ?: emptyList()).map { it.item }.mapNotNull { it.reference }
  }

  public data object PackageFor : SearchParam<PackagedProductDefinition, Reference> {
    public override val paramName: KotlinString = "package-for"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "PackagedProductDefinition.packageFor"

    public override val target: List<KotlinString> = listOf("MedicinalProductDefinition")

    public override fun extract(resource: PackagedProductDefinition): List<Reference> =
      resource.packageFor
  }

  public data object Status : SearchParam<PackagedProductDefinition, CodeableConcept> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "PackagedProductDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: PackagedProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.status)
  }
}
