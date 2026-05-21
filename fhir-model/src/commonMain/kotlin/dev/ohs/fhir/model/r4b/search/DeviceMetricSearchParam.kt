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
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [DeviceMetric] resource type. */
public object DeviceMetricSearchParam {
  /** All search parameters for the DeviceMetric resource type. */
  public val ALL: List<SearchParam<DeviceMetric, *>> =
    listOf(Category, Identifier, Parent, Source, Type)

  public data object Category : SearchParam<DeviceMetric, Any> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceMetric): List<Any> = listOf(resource.category)
  }

  public data object Identifier : SearchParam<DeviceMetric, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceMetric): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Parent : SearchParam<DeviceMetric, Reference> {
    public override val paramName: String = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceMetric.parent"

    public override val target: List<KClass<out Resource>> = listOf(Device::class)

    public override fun extract(resource: DeviceMetric): List<Reference> =
      listOfNotNull(resource.parent)
  }

  public data object Source : SearchParam<DeviceMetric, Reference> {
    public override val paramName: String = "source"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceMetric.source"

    public override val target: List<KClass<out Resource>> = listOf(Device::class)

    public override fun extract(resource: DeviceMetric): List<Reference> =
      listOfNotNull(resource.source)
  }

  public data object Type : SearchParam<DeviceMetric, CodeableConcept> {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: DeviceMetric): List<CodeableConcept> =
      listOf(resource.type)
  }
}
