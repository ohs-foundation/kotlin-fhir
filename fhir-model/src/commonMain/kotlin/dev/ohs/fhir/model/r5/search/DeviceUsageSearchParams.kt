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
import dev.ohs.fhir.model.r5.DeviceUsage
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceUsage] resource type. */
public object DeviceUsageSearchParams {
  public val device: SearchParam<DeviceUsage, CodeableConcept> =
    SearchParam(
      name = "device",
      type = SearchParamType.Token,
      expression = "DeviceUsage.device.concept",
      extractor = { resource -> listOfNotNull(resource.device.concept) },
    )

  public val identifier: SearchParam<DeviceUsage, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "DeviceUsage.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<DeviceUsage, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "DeviceUsage.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val status: SearchParam<DeviceUsage, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "DeviceUsage.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<DeviceUsage, *>> = listOf()

  /**
   * Supported search parameters for the DeviceUsage resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<DeviceUsage, *>> = listOf(device, identifier, patient, status)
}
