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
public object DeviceMetricSearchParam {
  public val Category: SearchParam<DeviceMetric, Any> =
    SimpleSearchParam<DeviceMetric, Any>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceMetric.category",
      extractor = { resource -> listOf(resource.category) },
    )

  public val Identifier: SearchParam<DeviceMetric, Identifier> =
    SimpleSearchParam<DeviceMetric, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceMetric.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Parent: SearchParam<DeviceMetric, Reference> =
    SimpleSearchParam<DeviceMetric, Reference>(
      name = "parent",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceMetric.parent",
      target = listOf(Device::class),
      extractor = { resource -> listOfNotNull(resource.parent) },
    )

  public val Source: SearchParam<DeviceMetric, Reference> =
    SimpleSearchParam<DeviceMetric, Reference>(
      name = "source",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceMetric.source",
      target = listOf(Device::class),
      extractor = { resource -> listOfNotNull(resource.source) },
    )

  public val Type: SearchParam<DeviceMetric, CodeableConcept> =
    SimpleSearchParam<DeviceMetric, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceMetric.type",
      extractor = { resource -> listOf(resource.type) },
    )

  /** All search parameters for the DeviceMetric resource type. */
  public val ALL: List<SearchParam<DeviceMetric, *>> =
    listOf(Category, Identifier, Parent, Source, Type)
}
