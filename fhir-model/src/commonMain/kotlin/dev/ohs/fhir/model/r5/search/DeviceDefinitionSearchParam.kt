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
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceDefinition] resource type. */
public object DeviceDefinitionSearchParam {
  public val DeviceName: SearchParam<DeviceDefinition, String> =
    SimpleSearchParam<DeviceDefinition, String>(
      name = "device-name",
      type = SearchParamType.fromCode("string"),
      expression = "DeviceDefinition.deviceName.name",
      extractor = { resource -> resource.deviceName.map { it.name } },
    )

  public val Identifier: SearchParam<DeviceDefinition, Identifier> =
    SimpleSearchParam<DeviceDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Manufacturer: SearchParam<DeviceDefinition, Reference> =
    SimpleSearchParam<DeviceDefinition, Reference>(
      name = "manufacturer",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceDefinition.manufacturer",
      target = listOf(dev.ohs.fhir.model.r5.Organization::class),
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
    )

  public val Organization: SearchParam<DeviceDefinition, Reference> =
    SimpleSearchParam<DeviceDefinition, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceDefinition.owner",
      target = listOf(dev.ohs.fhir.model.r5.Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val Specification: SearchParam<DeviceDefinition, CodeableConcept> =
    SimpleSearchParam<DeviceDefinition, CodeableConcept>(
      name = "specification",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDefinition.conformsTo.specification",
      extractor = { resource -> resource.conformsTo.map { it.specification } },
    )

  public val SpecificationVersion: SearchParam<DeviceDefinition, DeviceDefinition.ConformsTo> =
    SimpleSearchParam<DeviceDefinition, DeviceDefinition.ConformsTo>(
      name = "specification-version",
      type = SearchParamType.fromCode("composite"),
      expression = "DeviceDefinition.conformsTo",
      extractor = { resource -> resource.conformsTo },
    )

  public val Type: SearchParam<DeviceDefinition, CodeableConcept> =
    SimpleSearchParam<DeviceDefinition, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDefinition.conformsTo.category",
      extractor = { resource -> resource.conformsTo.mapNotNull { it.category } },
    )

  /** All search parameters for the DeviceDefinition resource type. */
  public val ALL: List<SearchParam<DeviceDefinition, *>> =
    listOf(
      DeviceName,
      Identifier,
      Manufacturer,
      Organization,
      Specification,
      SpecificationVersion,
      Type,
    )
}
