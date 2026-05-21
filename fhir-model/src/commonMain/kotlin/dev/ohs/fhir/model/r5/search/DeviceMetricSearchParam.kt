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
import dev.ohs.fhir.model.r5.DeviceMetric
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [DeviceMetric] resource type. */
public object DeviceMetricSearchParam {
  /** All search parameters for the DeviceMetric resource type. */
  public val ALL: List<SearchParam<DeviceMetric, *>> = listOf(Category, Device, Identifier, Type)

  public data object Category : SearchParam<DeviceMetric, Any> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceMetric): List<Any> = listOf(resource.category)
  }

  public data object Device : SearchParam<DeviceMetric, Reference> {
    public override val name: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceMetric.device"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Device::class)

    public override fun extract(resource: DeviceMetric): List<Reference> = listOf(resource.device)
  }

  public data object Identifier : SearchParam<DeviceMetric, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceMetric): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Type : SearchParam<DeviceMetric, CodeableConcept> {
    public override val name: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceMetric): List<CodeableConcept> =
      listOf(resource.type)
  }
}
