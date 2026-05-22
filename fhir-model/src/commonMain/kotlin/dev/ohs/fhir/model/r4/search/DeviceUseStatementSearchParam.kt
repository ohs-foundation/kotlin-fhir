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

import dev.ohs.fhir.model.r4.DeviceUseStatement
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceUseStatement] resource type. */
public object DeviceUseStatementSearchParam {
  public val Device: SearchParam<DeviceUseStatement, Reference> =
    SimpleSearchParam<DeviceUseStatement, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceUseStatement.device",
      target = listOf(dev.ohs.fhir.model.r4.Device::class),
      extractor = { resource -> listOf(resource.device) },
    )

  public val Identifier: SearchParam<DeviceUseStatement, Identifier> =
    SimpleSearchParam<DeviceUseStatement, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceUseStatement.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<DeviceUseStatement, Reference> =
    SimpleSearchParam<DeviceUseStatement, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceUseStatement.subject",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  public val Subject: SearchParam<DeviceUseStatement, Reference> =
    SimpleSearchParam<DeviceUseStatement, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceUseStatement.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the DeviceUseStatement resource type. */
  public val ALL: List<SearchParam<DeviceUseStatement, *>> =
    listOf(Device, Identifier, Patient, Subject)
}
