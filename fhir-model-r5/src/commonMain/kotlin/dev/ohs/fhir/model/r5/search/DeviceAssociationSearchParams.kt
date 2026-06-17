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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceAssociation
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceAssociation] resource type. */
public object DeviceAssociationSearchParams {
  public val device: SearchParam<DeviceAssociation, Reference> =
    SearchParam(
      name = "device",
      type = SearchParamType.Reference,
      expression = "DeviceAssociation.device",
      target = listOf(Device::class),
      extractor = { resource -> listOf(resource.device) },
    )

  public val identifier: SearchParam<DeviceAssociation, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "DeviceAssociation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val `operator`: SearchParam<DeviceAssociation, Reference> =
    SearchParam(
      name = "operator",
      type = SearchParamType.Reference,
      expression = "DeviceAssociation.operation.operator",
      target = listOf(RelatedPerson::class, Practitioner::class, Patient::class),
      extractor = { resource -> resource.operation.flatMap { it.`operator` } },
    )

  public val patient: SearchParam<DeviceAssociation, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "DeviceAssociation.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val status: SearchParam<DeviceAssociation, CodeableConcept> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "DeviceAssociation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<DeviceAssociation, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "DeviceAssociation.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<DeviceAssociation, *>> = listOf()

  /**
   * Supported search parameters for the DeviceAssociation resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<DeviceAssociation, *>> =
    listOf(device, identifier, `operator`, patient, status, subject)
}
