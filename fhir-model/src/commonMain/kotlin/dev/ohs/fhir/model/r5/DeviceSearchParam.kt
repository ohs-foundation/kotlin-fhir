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
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Device] resource type. */
public sealed class DeviceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Device): List<T>

  public data object BiologicalSourceEvent : DeviceSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "biological-source-event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Device.biologicalSourceEvent"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<dev.ohs.fhir.model.r5.Identifier> =
      listOfNotNull(resource.biologicalSourceEvent)
  }

  public data object Code : DeviceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Device.definition.concept"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<CodeableConcept> =
      listOfNotNull(resource.definition?.concept)
  }

  public data object CodeValueConcept : DeviceSearchParam<Any>() {
    public override val paramName: kotlin.String = "code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Device"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Definition : DeviceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "definition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Device.definition.reference"

    public override val target: List<kotlin.String> = listOf("DeviceDefinition")

    public override fun extract(resource: Device): List<Reference> =
      listOfNotNull(resource.definition?.reference)
  }

  public data object DeviceName : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "device-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.name.value"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> = resource.name.map { it.value }
  }

  public data object ExpirationDate : DeviceSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "expiration-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Device.expirationDate"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<DateTime> =
      listOfNotNull(resource.expirationDate)
  }

  public data object Identifier : DeviceSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Device.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<dev.ohs.fhir.model.r5.Identifier> =
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

  public data object LotNumber : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.lotNumber"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> = listOfNotNull(resource.lotNumber)
  }

  public data object ManufactureDate : DeviceSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "manufacture-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "Device.manufactureDate"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<DateTime> =
      listOfNotNull(resource.manufactureDate)
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

  public data object Parent : DeviceSearchParam<Reference>() {
    public override val paramName: kotlin.String = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "Device.parent"

    public override val target: List<kotlin.String> = listOf("Device")

    public override fun extract(resource: Device): List<Reference> = listOfNotNull(resource.parent)
  }

  public data object SerialNumber : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "serial-number"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.serialNumber"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> =
      listOfNotNull(resource.serialNumber)
  }

  public data object Specification : DeviceSearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "specification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "Device.conformsTo.specification"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<CodeableConcept> =
      resource.conformsTo.map { it.specification }
  }

  public data object SpecificationVersion : DeviceSearchParam<Device.ConformsTo>() {
    public override val paramName: kotlin.String = "specification-version"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "Device.conformsTo"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<Device.ConformsTo> = resource.conformsTo
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

    public override fun extract(resource: Device): List<CodeableConcept> = resource.type
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
      resource.udiCarrier.map { it.deviceIdentifier }
  }

  public data object Url : DeviceSearchParam<Uri>() {
    public override val paramName: kotlin.String = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: kotlin.String = "Device.url"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : DeviceSearchParam<String>() {
    public override val paramName: kotlin.String = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "Device.version.value"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: Device): List<String> = resource.version.map { it.value }
  }

  public companion object {
    /** All search parameters for the Device resource type. */
    public val ALL: List<DeviceSearchParam<*>> =
      listOf(
        BiologicalSourceEvent,
        Code,
        CodeValueConcept,
        Definition,
        DeviceName,
        ExpirationDate,
        Identifier,
        Location,
        LotNumber,
        ManufactureDate,
        Manufacturer,
        Model,
        Organization,
        Parent,
        SerialNumber,
        Specification,
        SpecificationVersion,
        Status,
        Type,
        UdiCarrier,
        UdiDi,
        Url,
        Version,
      )
  }
}
