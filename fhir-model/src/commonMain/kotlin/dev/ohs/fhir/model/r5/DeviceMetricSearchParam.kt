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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceMetric] resource type. */
public sealed class DeviceMetricSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DeviceMetric): List<T>

  public data object Category : DeviceMetricSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceMetric): List<Any> = listOf(resource.category)
  }

  public data object Device : DeviceMetricSearchParam<Reference>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceMetric.device"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: DeviceMetric): List<Reference> = listOf(resource.device)
  }

  public data object Identifier : DeviceMetricSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceMetric): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Type : DeviceMetricSearchParam<CodeableConcept>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceMetric.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceMetric): List<CodeableConcept> =
      listOf(resource.type)
  }

  public companion object {
    /** All search parameters for the DeviceMetric resource type. */
    public val ALL: List<DeviceMetricSearchParam<*>> = listOf(Category, Device, Identifier, Type)
  }
}
