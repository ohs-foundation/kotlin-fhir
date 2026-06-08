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
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceDefinition] resource type. */
public object DeviceDefinitionSearchParams {
  public val deviceName: SearchParam<DeviceDefinition, String> =
    SearchParam(
      name = "device-name",
      type = SearchParamType.fromCode("string"),
      expression = "DeviceDefinition.deviceName.name",
      extractor = { resource -> resource.deviceName.map { it.name } },
    )

  public val identifier: SearchParam<DeviceDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val manufacturer: SearchParam<DeviceDefinition, Reference> =
    SearchParam(
      name = "manufacturer",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceDefinition.manufacturer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
    )

  public val organization: SearchParam<DeviceDefinition, Reference> =
    SearchParam(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceDefinition.owner",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val specification: SearchParam<DeviceDefinition, CodeableConcept> =
    SearchParam(
      name = "specification",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDefinition.conformsTo.specification",
      extractor = { resource -> resource.conformsTo.map { it.specification } },
    )

  public val specificationVersion: SearchParam<DeviceDefinition, DeviceDefinition.ConformsTo> =
    SearchParam(
      name = "specification-version",
      type = SearchParamType.fromCode("composite"),
      expression = "DeviceDefinition.conformsTo",
      extractor = { resource -> resource.conformsTo },
    )

  public val type: SearchParam<DeviceDefinition, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDefinition.conformsTo.category",
      extractor = { resource -> resource.conformsTo.mapNotNull { it.category } },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<DeviceDefinition, *>> = listOf()

  /**
   * Supported search parameters for the DeviceDefinition resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<DeviceDefinition, *>> =
    listOf(
      deviceName,
      identifier,
      manufacturer,
      organization,
      specification,
      specificationVersion,
      type,
    )
}
