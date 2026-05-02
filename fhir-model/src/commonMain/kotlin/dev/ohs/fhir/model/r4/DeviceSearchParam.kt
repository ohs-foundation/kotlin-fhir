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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Device] resource type. */
public sealed class DeviceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Device): List<T>

  public data object DeviceName : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "device-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.deviceName.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> =
      resource.deviceName.map { it.name }
  }

  public data object Din : DeviceSearchParam<Any>() {
    public override val paramName: kotlin.String = "din"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String =
      "Device.extension('http://hl7.org/fhir/SearchParameter/device-extensions-Device-din')"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Identifier : DeviceSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Device.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Location : DeviceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Device.location"

    public override val target: List<kotlin.String> = listOf("Location")

    public override fun extract(resource: Device): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object Manufacturer : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.manufacturer"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> =
      listOfNotNull(resource.manufacturer)
  }

  public data object Model : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "model"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.modelNumber"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> =
      listOfNotNull(resource.modelNumber)
  }

  public data object Organization : DeviceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Device.owner"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: Device): List<Reference> = listOfNotNull(resource.owner)
  }

  public data object Patient : DeviceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Device.patient"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: Device): List<Reference> = listOfNotNull(resource.patient)
  }

  public data object Status : DeviceSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Device.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<Any> = listOfNotNull(resource.status)
  }

  public data object Type : DeviceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Device.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object UdiCarrier : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "udi-carrier"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.udiCarrier.carrierHRF"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> =
      resource.udiCarrier.mapNotNull { it.carrierHRF }
  }

  public data object UdiDi : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "udi-di"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.udiCarrier.deviceIdentifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> =
      resource.udiCarrier.mapNotNull { it.deviceIdentifier }
  }

  public data object Url : DeviceSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "Device.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<Uri> = listOfNotNull(resource.url)
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
