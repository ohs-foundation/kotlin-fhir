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
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DeviceMetric
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceMetric] resource type. */
public object DeviceMetricSearchParams {
  public val category: SearchParam<DeviceMetric, Any> =
    SearchParam(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceMetric.category",
      extractor = { resource -> listOf(resource.category) },
    )

  public val identifier: SearchParam<DeviceMetric, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceMetric.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val parent: SearchParam<DeviceMetric, Reference> =
    SearchParam(
      name = "parent",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceMetric.parent",
      target = listOf(Device::class),
      extractor = { resource -> listOfNotNull(resource.parent) },
    )

  public val source: SearchParam<DeviceMetric, Reference> =
    SearchParam(
      name = "source",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceMetric.source",
      target = listOf(Device::class),
      extractor = { resource -> listOfNotNull(resource.source) },
    )

  public val type: SearchParam<DeviceMetric, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceMetric.type",
      extractor = { resource -> listOf(resource.type) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<DeviceMetric, *>> = listOf()

  /**
   * Supported search parameters for the DeviceMetric resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<DeviceMetric, *>> =
    listOf(category, identifier, parent, source, type)
}
