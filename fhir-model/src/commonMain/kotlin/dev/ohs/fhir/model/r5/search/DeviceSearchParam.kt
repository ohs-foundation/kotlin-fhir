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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [Device] resource type. */
public object DeviceSearchParam {
  /** All search parameters for the Device resource type. */
  public val ALL: List<SearchParam<Device, *>> =
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

  public data object BiologicalSourceEvent : SearchParam<Device, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "biological-source-event"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.biologicalSourceEvent"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<dev.ohs.fhir.model.r5.Identifier> =
      listOfNotNull(resource.biologicalSourceEvent)
  }

  public data object Code : SearchParam<Device, CodeableConcept> {
    public override val name: KotlinString = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.definition.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<CodeableConcept> =
      listOfNotNull(resource.definition?.concept)
  }

  public data object CodeValueConcept : SearchParam<Device, Any> {
    public override val name: KotlinString = "code-value-concept"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Device"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<Any> = emptyList()
  }

  public data object Definition : SearchParam<Device, Reference> {
    public override val name: KotlinString = "definition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Device.definition.reference"

    public override val target: List<KClass<out Resource>> = listOf(DeviceDefinition::class)

    public override fun extract(resource: Device): List<Reference> =
      listOfNotNull(resource.definition?.reference)
  }

  public data object DeviceName : SearchParam<Device, R5String> {
    public override val name: KotlinString = "device-name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.name.value"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<R5String> = resource.name.map { it.value }
  }

  public data object ExpirationDate : SearchParam<Device, DateTime> {
    public override val name: KotlinString = "expiration-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Device.expirationDate"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<DateTime> =
      listOfNotNull(resource.expirationDate)
  }

  public data object Identifier : SearchParam<Device, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Location : SearchParam<Device, Reference> {
    public override val name: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Device.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: Device): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object LotNumber : SearchParam<Device, R5String> {
    public override val name: KotlinString = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.lotNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<R5String> =
      listOfNotNull(resource.lotNumber)
  }

  public data object ManufactureDate : SearchParam<Device, DateTime> {
    public override val name: KotlinString = "manufacture-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "Device.manufactureDate"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<DateTime> =
      listOfNotNull(resource.manufactureDate)
  }

  public data object Manufacturer : SearchParam<Device, R5String> {
    public override val name: KotlinString = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.manufacturer"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<R5String> =
      listOfNotNull(resource.manufacturer)
  }

  public data object Model : SearchParam<Device, R5String> {
    public override val name: KotlinString = "model"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.modelNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<R5String> =
      listOfNotNull(resource.modelNumber)
  }

  public data object Organization : SearchParam<Device, Reference> {
    public override val name: KotlinString = "organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Device.owner"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Organization::class)

    public override fun extract(resource: Device): List<Reference> = listOfNotNull(resource.owner)
  }

  public data object Parent : SearchParam<Device, Reference> {
    public override val name: KotlinString = "parent"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Device.parent"

    public override val target: List<KClass<out Resource>> = listOf(Device::class)

    public override fun extract(resource: Device): List<Reference> = listOfNotNull(resource.parent)
  }

  public data object SerialNumber : SearchParam<Device, R5String> {
    public override val name: KotlinString = "serial-number"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.serialNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<R5String> =
      listOfNotNull(resource.serialNumber)
  }

  public data object Specification : SearchParam<Device, CodeableConcept> {
    public override val name: KotlinString = "specification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.conformsTo.specification"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<CodeableConcept> =
      resource.conformsTo.map { it.specification }
  }

  public data object SpecificationVersion : SearchParam<Device, Device.ConformsTo> {
    public override val name: KotlinString = "specification-version"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "Device.conformsTo"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<Device.ConformsTo> = resource.conformsTo
  }

  public data object Status : SearchParam<Device, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<Any> = listOfNotNull(resource.status)
  }

  public data object Type : SearchParam<Device, CodeableConcept> {
    public override val name: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Device.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<CodeableConcept> = resource.type
  }

  public data object UdiCarrier : SearchParam<Device, R5String> {
    public override val name: KotlinString = "udi-carrier"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.udiCarrier.carrierHRF"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<R5String> =
      resource.udiCarrier.mapNotNull { it.carrierHRF }
  }

  public data object UdiDi : SearchParam<Device, R5String> {
    public override val name: KotlinString = "udi-di"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.udiCarrier.deviceIdentifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<R5String> =
      resource.udiCarrier.map { it.deviceIdentifier }
  }

  public data object Url : SearchParam<Device, Uri> {
    public override val name: KotlinString = "url"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "Device.url"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<Uri> = listOfNotNull(resource.url)
  }

  public data object Version : SearchParam<Device, R5String> {
    public override val name: KotlinString = "version"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Device.version.value"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Device): List<R5String> =
      resource.version.map { it.value }
  }
}
