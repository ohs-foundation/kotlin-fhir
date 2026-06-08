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
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Device] resource type. */
public object DeviceSearchParams {
  public val biologicalSourceEvent: SearchParam<Device, Identifier> =
    SearchParam(
      name = "biological-source-event",
      type = SearchParamType.Token,
      expression = "Device.biologicalSourceEvent",
      extractor = { resource -> listOfNotNull(resource.biologicalSourceEvent) },
    )

  public val code: SearchParam<Device, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "Device.definition.concept",
      extractor = { resource -> listOfNotNull(resource.definition?.concept) },
    )

  public val codeValueConcept: SearchParam<Device, Any> =
    SearchParam(
      name = "code-value-concept",
      type = SearchParamType.Composite,
      expression = "Device",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'code-value-concept' has expression 'Device' which is not yet supported."
        )
      },
    )

  public val definition: SearchParam<Device, Reference> =
    SearchParam(
      name = "definition",
      type = SearchParamType.Reference,
      expression = "Device.definition.reference",
      target = listOf(DeviceDefinition::class),
      extractor = { resource -> listOfNotNull(resource.definition?.reference) },
    )

  public val deviceName: SearchParam<Device, String> =
    SearchParam(
      name = "device-name",
      type = SearchParamType.String,
      expression = "Device.name.value",
      extractor = { resource -> resource.name.map { it.`value` } },
    )

  public val expirationDate: SearchParam<Device, DateTime> =
    SearchParam(
      name = "expiration-date",
      type = SearchParamType.Date,
      expression = "Device.expirationDate",
      extractor = { resource -> listOfNotNull(resource.expirationDate) },
    )

  public val identifier: SearchParam<Device, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Device.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<Device, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.Reference,
      expression = "Device.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val lotNumber: SearchParam<Device, String> =
    SearchParam(
      name = "lot-number",
      type = SearchParamType.String,
      expression = "Device.lotNumber",
      extractor = { resource -> listOfNotNull(resource.lotNumber) },
    )

  public val manufactureDate: SearchParam<Device, DateTime> =
    SearchParam(
      name = "manufacture-date",
      type = SearchParamType.Date,
      expression = "Device.manufactureDate",
      extractor = { resource -> listOfNotNull(resource.manufactureDate) },
    )

  public val manufacturer: SearchParam<Device, String> =
    SearchParam(
      name = "manufacturer",
      type = SearchParamType.String,
      expression = "Device.manufacturer",
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
    )

  public val model: SearchParam<Device, String> =
    SearchParam(
      name = "model",
      type = SearchParamType.String,
      expression = "Device.modelNumber",
      extractor = { resource -> listOfNotNull(resource.modelNumber) },
    )

  public val organization: SearchParam<Device, Reference> =
    SearchParam(
      name = "organization",
      type = SearchParamType.Reference,
      expression = "Device.owner",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val parent: SearchParam<Device, Reference> =
    SearchParam(
      name = "parent",
      type = SearchParamType.Reference,
      expression = "Device.parent",
      target = listOf(Device::class),
      extractor = { resource -> listOfNotNull(resource.parent) },
    )

  public val serialNumber: SearchParam<Device, String> =
    SearchParam(
      name = "serial-number",
      type = SearchParamType.String,
      expression = "Device.serialNumber",
      extractor = { resource -> listOfNotNull(resource.serialNumber) },
    )

  public val specification: SearchParam<Device, CodeableConcept> =
    SearchParam(
      name = "specification",
      type = SearchParamType.Token,
      expression = "Device.conformsTo.specification",
      extractor = { resource -> resource.conformsTo.map { it.specification } },
    )

  public val specificationVersion: SearchParam<Device, Device.ConformsTo> =
    SearchParam(
      name = "specification-version",
      type = SearchParamType.Composite,
      expression = "Device.conformsTo",
      extractor = { resource -> resource.conformsTo },
    )

  public val status: SearchParam<Device, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Device.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val type: SearchParam<Device, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "Device.type",
      extractor = { resource -> resource.type },
    )

  public val udiCarrier: SearchParam<Device, String> =
    SearchParam(
      name = "udi-carrier",
      type = SearchParamType.String,
      expression = "Device.udiCarrier.carrierHRF",
      extractor = { resource -> resource.udiCarrier.mapNotNull { it.carrierHRF } },
    )

  public val udiDi: SearchParam<Device, String> =
    SearchParam(
      name = "udi-di",
      type = SearchParamType.String,
      expression = "Device.udiCarrier.deviceIdentifier",
      extractor = { resource -> resource.udiCarrier.map { it.deviceIdentifier } },
    )

  public val url: SearchParam<Device, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "Device.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  public val version: SearchParam<Device, String> =
    SearchParam(
      name = "version",
      type = SearchParamType.String,
      expression = "Device.version.value",
      extractor = { resource -> resource.version.map { it.`value` } },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Device, *>> = listOf(codeValueConcept)

  /**
   * Supported search parameters for the Device resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Device, *>> =
    listOf(
      biologicalSourceEvent,
      code,
      definition,
      deviceName,
      expirationDate,
      identifier,
      location,
      lotNumber,
      manufactureDate,
      manufacturer,
      model,
      organization,
      parent,
      serialNumber,
      specification,
      specificationVersion,
      status,
      type,
      udiCarrier,
      udiDi,
      url,
      version,
    )
}
