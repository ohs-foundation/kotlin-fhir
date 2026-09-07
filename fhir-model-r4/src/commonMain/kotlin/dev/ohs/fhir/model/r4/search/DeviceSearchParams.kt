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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

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
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Device] resource type. */
public object DeviceSearchParams {
  public val deviceName: SearchParam<Device, String> =
    SearchParam(
      name = "device-name",
      type = SearchParamType.String,
      expression = "Device.deviceName.name | Device.type.coding.display | Device.type.text",
      extractor = { resource ->
        buildList {
            addAll(resource.deviceName.map { it.name })
            addAll((resource.type?.coding ?: emptyList()).mapNotNull { it.display })
            addAll(listOfNotNull(resource.type?.text))
          }
          .distinct()
      },
    )

  public val din: SearchParam<Device, Any> =
    SearchParam(
      name = "din",
      type = SearchParamType.Token,
      expression =
        "Device.extension('http://hl7.org/fhir/SearchParameter/device-extensions-Device-din')",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'din' has expression 'Device.extension('http://hl7.org/fhir/SearchParameter/device-extensions-Device-din')' which is not yet supported."
        )
      },
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

  public val patient: SearchParam<Device, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Device.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOfNotNull(resource.patient) },
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
      extractor = { resource -> listOfNotNull(resource.type) },
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
      extractor = { resource -> resource.udiCarrier.mapNotNull { it.deviceIdentifier } },
    )

  public val url: SearchParam<Device, Uri> =
    SearchParam(
      name = "url",
      type = SearchParamType.Uri,
      expression = "Device.url",
      extractor = { resource -> listOfNotNull(resource.url) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Device, *>> = listOf(din)

  /**
   * Supported search parameters for the Device resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Device, *>> =
    listOf(
      deviceName,
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
