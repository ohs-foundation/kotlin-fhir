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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Device] resource type. */
public sealed class DeviceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Device): List<T>

  public data object DeviceName : DeviceSearchParam<R4String>() {
    public override val paramName: KotlinString = "device-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.deviceName.name"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<R4String> =
      resource.deviceName.map { it.name }
  }

  public data object Din : DeviceSearchParam<Any>() {
    public override val paramName: KotlinString = "din"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "Device.extension('http://hl7.org/fhir/SearchParameter/device-extensions-Device-din')"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Identifier : DeviceSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Location : DeviceSearchParam<Reference>() {
    public override val paramName: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Device.location"

    public override val target: List<KotlinString> = listOf("Location")

    public override fun extract(resource: Device): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object Manufacturer : DeviceSearchParam<R4String>() {
    public override val paramName: KotlinString = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.manufacturer"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<R4String> =
      listOfNotNull(resource.manufacturer)
  }

  public data object Model : DeviceSearchParam<R4String>() {
    public override val paramName: KotlinString = "model"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.modelNumber"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<R4String> =
      listOfNotNull(resource.modelNumber)
  }

  public data object Organization : DeviceSearchParam<Reference>() {
    public override val paramName: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Device.owner"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Device): List<Reference> = listOfNotNull(resource.owner)
  }

  public data object Patient : DeviceSearchParam<Reference>() {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Device.patient"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Device): List<Reference> = listOfNotNull(resource.patient)
  }

  public data object Status : DeviceSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<Any> = listOfNotNull(resource.status)
  }

  public data object Type : DeviceSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object UdiCarrier : DeviceSearchParam<R4String>() {
    public override val paramName: KotlinString = "udi-carrier"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.udiCarrier.carrierHRF"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<R4String> =
      resource.udiCarrier.mapNotNull { it.carrierHRF }
  }

  public data object UdiDi : DeviceSearchParam<R4String>() {
    public override val paramName: KotlinString = "udi-di"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.udiCarrier.deviceIdentifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Device): List<R4String> =
      resource.udiCarrier.mapNotNull { it.deviceIdentifier }
  }

  public data object Url : DeviceSearchParam<Uri>() {
    public override val paramName: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Device.url"

    public override val target: List<KotlinString> = emptyList()

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
