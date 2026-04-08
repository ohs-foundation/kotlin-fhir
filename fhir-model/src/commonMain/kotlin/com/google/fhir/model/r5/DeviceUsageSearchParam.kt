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

/** Search parameters for the [DeviceUsage] resource type. */
public sealed class DeviceUsageSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DeviceUsage): List<T>

  public data object Device : DeviceUsageSearchParam<Any>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceUsage.device.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceUsage): List<Any> = emptyList()
  }

  public data object Identifier : DeviceUsageSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceUsage.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceUsage): List<Any> = emptyList()
  }

  public data object Patient : DeviceUsageSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceUsage.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: DeviceUsage): List<Any> = emptyList()
  }

  public data object Status : DeviceUsageSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceUsage.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceUsage): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the DeviceUsage resource type. */
    public val ALL: List<DeviceUsageSearchParam<*>> = listOf(Device, Identifier, Patient, Status)
  }
}
