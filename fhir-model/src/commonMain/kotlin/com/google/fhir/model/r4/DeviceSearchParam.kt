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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Device] resource type. */
public sealed class DeviceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Device): List<T>

  public data object DeviceName : DeviceSearchParam<Any>() {
    public override val paramName: String = "device-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Device.deviceName.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Din : DeviceSearchParam<Any>() {
    public override val paramName: String = "din"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "Device.extension('http://hl7.org/fhir/SearchParameter/device-extensions-Device-din')"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Identifier : DeviceSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Device.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Location : DeviceSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Device.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Manufacturer : DeviceSearchParam<Any>() {
    public override val paramName: String = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Device.manufacturer"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Model : DeviceSearchParam<Any>() {
    public override val paramName: String = "model"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Device.modelNumber"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Organization : DeviceSearchParam<Any>() {
    public override val paramName: String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Device.owner"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Patient : DeviceSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Device.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Status : DeviceSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Device.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Type : DeviceSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Device.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object UdiCarrier : DeviceSearchParam<Any>() {
    public override val paramName: String = "udi-carrier"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Device.udiCarrier.carrierHRF"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object UdiDi : DeviceSearchParam<Any>() {
    public override val paramName: String = "udi-di"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Device.udiCarrier.deviceIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Url : DeviceSearchParam<Any>() {
    public override val paramName: String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Device.url"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Device resource type. */
    public val ALL: List<DeviceSearchParam<*>> =
      listOf(
        DeviceName,
        Din,
        Identifier,
        Location,
        Manufacturer,
        Model,
        Organization,
        Patient,
        Status,
        Type,
        UdiCarrier,
        UdiDi,
        Url,
      )
  }
}
