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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DeviceUseStatement
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceUseStatement] resource type. */
public object DeviceUseStatementSearchParams {
  public val device: SearchParam<DeviceUseStatement, Reference> =
    SearchParam<DeviceUseStatement, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceUseStatement.device",
      target = listOf(Device::class),
      extractor = { resource -> listOf(resource.device) },
    )

  public val identifier: SearchParam<DeviceUseStatement, Identifier> =
    SearchParam<DeviceUseStatement, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceUseStatement.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<DeviceUseStatement, Reference> =
    SearchParam<DeviceUseStatement, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceUseStatement.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val subject: SearchParam<DeviceUseStatement, Reference> =
    SearchParam<DeviceUseStatement, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceUseStatement.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the DeviceUseStatement resource type. */
  public val all: List<SearchParam<DeviceUseStatement, *>> =
    listOf(device, identifier, patient, subject)
}
