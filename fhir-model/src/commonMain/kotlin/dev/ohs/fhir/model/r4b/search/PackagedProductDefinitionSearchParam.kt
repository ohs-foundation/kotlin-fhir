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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.PackagedProductDefinition
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [PackagedProductDefinition] resource type. */
public object PackagedProductDefinitionSearchParam {
  public val Biological: SearchParam<PackagedProductDefinition, Reference> =
    SimpleSearchParam<PackagedProductDefinition, Reference>(
      name = "biological",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.package.containedItem.item.reference",
      extractor = { resource ->
        (resource.`package`?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val ContainedItem: SearchParam<PackagedProductDefinition, Reference> =
    SimpleSearchParam<PackagedProductDefinition, Reference>(
      name = "contained-item",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.package.containedItem.item.reference",
      extractor = { resource ->
        (resource.`package`?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val Device: SearchParam<PackagedProductDefinition, Reference> =
    SimpleSearchParam<PackagedProductDefinition, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.package.containedItem.item.reference",
      extractor = { resource ->
        (resource.`package`?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val Identifier: SearchParam<PackagedProductDefinition, Identifier> =
    SimpleSearchParam<PackagedProductDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "PackagedProductDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ManufacturedItem: SearchParam<PackagedProductDefinition, Reference> =
    SimpleSearchParam<PackagedProductDefinition, Reference>(
      name = "manufactured-item",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.package.containedItem.item.reference",
      extractor = { resource ->
        (resource.`package`?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val Medication: SearchParam<PackagedProductDefinition, Reference> =
    SimpleSearchParam<PackagedProductDefinition, Reference>(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.package.containedItem.item.reference",
      extractor = { resource ->
        (resource.`package`?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val Name: SearchParam<PackagedProductDefinition, String> =
    SimpleSearchParam<PackagedProductDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("token"),
      expression = "PackagedProductDefinition.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val Nutrition: SearchParam<PackagedProductDefinition, Reference> =
    SimpleSearchParam<PackagedProductDefinition, Reference>(
      name = "nutrition",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.package.containedItem.item.reference",
      extractor = { resource ->
        (resource.`package`?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val Package: SearchParam<PackagedProductDefinition, Reference> =
    SimpleSearchParam<PackagedProductDefinition, Reference>(
      name = "package",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.package.containedItem.item.reference",
      extractor = { resource ->
        (resource.`package`?.containedItem ?: emptyList())
          .map { it.item }
          .mapNotNull { it.reference }
      },
    )

  public val PackageFor: SearchParam<PackagedProductDefinition, Reference> =
    SimpleSearchParam<PackagedProductDefinition, Reference>(
      name = "package-for",
      type = SearchParamType.fromCode("reference"),
      expression = "PackagedProductDefinition.packageFor",
      target = listOf(MedicinalProductDefinition::class),
      extractor = { resource -> resource.packageFor },
    )

  public val Status: SearchParam<PackagedProductDefinition, CodeableConcept> =
    SimpleSearchParam<PackagedProductDefinition, CodeableConcept>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "PackagedProductDefinition.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

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
}
