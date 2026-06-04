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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Device] resource type. */
public object DeviceSearchParams {
  public val BiologicalSourceEvent: SearchParam<Device, Identifier> =
    SimpleSearchParam<Device, Identifier>(
      name = "biological-source-event",
      type = SearchParamType.fromCode("token"),
      expression = "Device.biologicalSourceEvent",
      extractor = { resource -> listOfNotNull(resource.biologicalSourceEvent) },
    )

  public val Code: SearchParam<Device, CodeableConcept> =
    SimpleSearchParam<Device, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Device.definition.concept",
      extractor = { resource -> listOfNotNull(resource.definition?.concept) },
    )

  public val CodeValueConcept: SearchParam<Device, Any> =
    SimpleSearchParam<Device, Any>(
      name = "code-value-concept",
      type = SearchParamType.fromCode("composite"),
      expression = "Device",
      extractor = { emptyList() },
    )

  public val Definition: SearchParam<Device, Reference> =
    SimpleSearchParam<Device, Reference>(
      name = "definition",
      type = SearchParamType.fromCode("reference"),
      expression = "Device.definition.reference",
      target = listOf(DeviceDefinition::class),
      extractor = { resource -> listOfNotNull(resource.definition?.reference) },
    )

  public val DeviceName: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "device-name",
      type = SearchParamType.fromCode("string"),
      expression = "Device.name.value",
      extractor = { resource -> resource.name.map { it.`value` } },
    )

  public val ExpirationDate: SearchParam<Device, DateTime> =
    SimpleSearchParam<Device, DateTime>(
      name = "expiration-date",
      type = SearchParamType.fromCode("date"),
      expression = "Device.expirationDate",
      extractor = { resource -> listOfNotNull(resource.expirationDate) },
    )

  public val Identifier: SearchParam<Device, Identifier> =
    SimpleSearchParam<Device, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Device.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Location: SearchParam<Device, Reference> =
    SimpleSearchParam<Device, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Device.location",
      target = listOf(dev.ohs.fhir.model.r5.Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val LotNumber: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "lot-number",
      type = SearchParamType.fromCode("string"),
      expression = "Device.lotNumber",
      extractor = { resource -> listOfNotNull(resource.lotNumber) },
    )

  public val ManufactureDate: SearchParam<Device, DateTime> =
    SimpleSearchParam<Device, DateTime>(
      name = "manufacture-date",
      type = SearchParamType.fromCode("date"),
      expression = "Device.manufactureDate",
      extractor = { resource -> listOfNotNull(resource.manufactureDate) },
    )

  public val Manufacturer: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "manufacturer",
      type = SearchParamType.fromCode("string"),
      expression = "Device.manufacturer",
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
    )

  public val Model: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "model",
      type = SearchParamType.fromCode("string"),
      expression = "Device.modelNumber",
      extractor = { resource -> listOfNotNull(resource.modelNumber) },
    )

  public val Organization: SearchParam<Device, Reference> =
    SimpleSearchParam<Device, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Device.owner",
      target = listOf(dev.ohs.fhir.model.r5.Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val Parent: SearchParam<Device, Reference> =
    SimpleSearchParam<Device, Reference>(
      name = "parent",
      type = SearchParamType.fromCode("reference"),
      expression = "Device.parent",
      target = listOf(Device::class),
      extractor = { resource -> listOfNotNull(resource.parent) },
    )

  public val SerialNumber: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "serial-number",
      type = SearchParamType.fromCode("string"),
      expression = "Device.serialNumber",
      extractor = { resource -> listOfNotNull(resource.serialNumber) },
    )

  public val Specification: SearchParam<Device, CodeableConcept> =
    SimpleSearchParam<Device, CodeableConcept>(
      name = "specification",
      type = SearchParamType.fromCode("token"),
      expression = "Device.conformsTo.specification",
      extractor = { resource -> resource.conformsTo.map { it.specification } },
    )

  public val SpecificationVersion: SearchParam<Device, Device.ConformsTo> =
    SimpleSearchParam<Device, Device.ConformsTo>(
      name = "specification-version",
      type = SearchParamType.fromCode("composite"),
      expression = "Device.conformsTo",
      extractor = { resource -> resource.conformsTo },
    )

  public val Status: SearchParam<Device, Any> =
    SimpleSearchParam<Device, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Device.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Type: SearchParam<Device, CodeableConcept> =
    SimpleSearchParam<Device, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Device.type",
      extractor = { resource -> resource.type },
    )

  public val UdiCarrier: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "udi-carrier",
      type = SearchParamType.fromCode("string"),
      expression = "Device.udiCarrier.carrierHRF",
      extractor = { resource -> resource.udiCarrier.mapNotNull { it.carrierHRF } },
    )

  public val UdiDi: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "udi-di",
      type = SearchParamType.fromCode("string"),
      expression = "Device.udiCarrier.deviceIdentifier",
      extractor = { resource -> resource.udiCarrier.map { it.deviceIdentifier } },
    )

  public val Url: SearchParam<Device, Uri> =
    SimpleSearchParam<Device, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Device.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val Version: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "version",
      type = SearchParamType.fromCode("string"),
      expression = "Device.version.value",
      extractor = { resource -> resource.version.map { it.`value` } },
    )

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
}
