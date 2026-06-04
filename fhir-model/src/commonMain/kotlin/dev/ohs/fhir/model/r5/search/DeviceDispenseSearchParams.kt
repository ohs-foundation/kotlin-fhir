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
import dev.ohs.fhir.model.r5.DeviceDispense
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceDispense] resource type. */
public object DeviceDispenseSearchParams {
  public val Code: SearchParam<DeviceDispense, CodeableConcept> =
    SimpleSearchParam<DeviceDispense, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDispense.device.concept",
      extractor = { resource -> listOfNotNull(resource.device.concept) },
    )

  public val Identifier: SearchParam<DeviceDispense, Identifier> =
    SimpleSearchParam<DeviceDispense, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDispense.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<DeviceDispense, Reference> =
    SimpleSearchParam<DeviceDispense, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceDispense.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Status: SearchParam<DeviceDispense, Any> =
    SimpleSearchParam<DeviceDispense, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceDispense.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<DeviceDispense, Reference> =
    SimpleSearchParam<DeviceDispense, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceDispense.subject",
      target = listOf(Practitioner::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the DeviceDispense resource type. */
  public val ALL: List<SearchParam<DeviceDispense, *>> =
    listOf(Code, Identifier, Patient, Status, Subject)
}
