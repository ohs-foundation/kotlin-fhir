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
import dev.ohs.fhir.model.r5.DeviceAssociation
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceAssociation] resource type. */
public object DeviceAssociationSearchParam {
  public val Device: SearchParam<DeviceAssociation, Reference> =
    SimpleSearchParam<DeviceAssociation, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceAssociation.device",
      target = listOf(dev.ohs.fhir.model.r5.Device::class),
      extractor = { resource -> listOf(resource.device) },
    )

  public val Identifier: SearchParam<DeviceAssociation, Identifier> =
    SimpleSearchParam<DeviceAssociation, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceAssociation.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Operator: SearchParam<DeviceAssociation, Reference> =
    SimpleSearchParam<DeviceAssociation, Reference>(
      name = "operator",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceAssociation.operation.operator",
      target =
        listOf(RelatedPerson::class, Practitioner::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> resource.operation.flatMap { it.`operator` } },
    )

  public val Patient: SearchParam<DeviceAssociation, Reference> =
    SimpleSearchParam<DeviceAssociation, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceAssociation.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Status: SearchParam<DeviceAssociation, CodeableConcept> =
    SimpleSearchParam<DeviceAssociation, CodeableConcept>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "DeviceAssociation.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<DeviceAssociation, Reference> =
    SimpleSearchParam<DeviceAssociation, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "DeviceAssociation.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  /** All search parameters for the DeviceAssociation resource type. */
  public val ALL: List<SearchParam<DeviceAssociation, *>> =
    listOf(Device, Identifier, Operator, Patient, Status, Subject)
}
