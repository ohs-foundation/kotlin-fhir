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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Device] resource type. */
public object DeviceSearchParams {
  public val deviceName: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "device-name",
      type = SearchParamType.fromCode("string"),
      expression = "Device.deviceName.name",
      extractor = { resource -> resource.deviceName.map { it.name } },
    )

  public val din: SearchParam<Device, Any> =
    SimpleSearchParam<Device, Any>(
      name = "din",
      type = SearchParamType.fromCode("token"),
      expression =
        "Device.extension('http://hl7.org/fhir/SearchParameter/device-extensions-Device-din')",
      extractor = { emptyList() },
    )

  public val identifier: SearchParam<Device, Identifier> =
    SimpleSearchParam<Device, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Device.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<Device, Reference> =
    SimpleSearchParam<Device, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Device.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val manufacturer: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "manufacturer",
      type = SearchParamType.fromCode("string"),
      expression = "Device.manufacturer",
      extractor = { resource -> listOfNotNull(resource.manufacturer) },
    )

  public val model: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "model",
      type = SearchParamType.fromCode("string"),
      expression = "Device.modelNumber",
      extractor = { resource -> listOfNotNull(resource.modelNumber) },
    )

  public val organization: SearchParam<Device, Reference> =
    SimpleSearchParam<Device, Reference>(
      name = "organization",
      type = SearchParamType.fromCode("reference"),
      expression = "Device.owner",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.owner) },
    )

  public val patient: SearchParam<Device, Reference> =
    SimpleSearchParam<Device, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Device.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOfNotNull(resource.patient) },
    )

  public val status: SearchParam<Device, Any> =
    SimpleSearchParam<Device, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Device.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val type: SearchParam<Device, CodeableConcept> =
    SimpleSearchParam<Device, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Device.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val udiCarrier: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "udi-carrier",
      type = SearchParamType.fromCode("string"),
      expression = "Device.udiCarrier.carrierHRF",
      extractor = { resource -> resource.udiCarrier.mapNotNull { it.carrierHRF } },
    )

  public val udiDi: SearchParam<Device, String> =
    SimpleSearchParam<Device, String>(
      name = "udi-di",
      type = SearchParamType.fromCode("string"),
      expression = "Device.udiCarrier.deviceIdentifier",
      extractor = { resource -> resource.udiCarrier.mapNotNull { it.deviceIdentifier } },
    )

  public val url: SearchParam<Device, Uri> =
    SimpleSearchParam<Device, Uri>(
      name = "url",
      type = SearchParamType.fromCode("uri"),
      expression = "Device.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  /** All search parameters for the Device resource type. */
  public val all: List<SearchParam<Device, *>> =
    listOf(
      deviceName,
      din,
      identifier,
      location,
      manufacturer,
      model,
      organization,
      patient,
      status,
      type,
      udiCarrier,
      udiDi,
      url,
    )
}
