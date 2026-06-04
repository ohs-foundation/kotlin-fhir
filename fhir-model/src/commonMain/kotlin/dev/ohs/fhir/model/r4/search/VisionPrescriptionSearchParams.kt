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

import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [VisionPrescription] resource type. */
public object VisionPrescriptionSearchParams {
  public val Datewritten: SearchParam<VisionPrescription, DateTime> =
    SimpleSearchParam<VisionPrescription, DateTime>(
      name = "datewritten",
      type = SearchParamType.fromCode("date"),
      expression = "VisionPrescription.dateWritten",
      extractor = { resource -> listOf(resource.dateWritten) },
    )

  public val Encounter: SearchParam<VisionPrescription, Reference> =
    SimpleSearchParam<VisionPrescription, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "VisionPrescription.encounter",
      target = listOf(dev.ohs.fhir.model.r4.Encounter::class, EpisodeOfCare::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<VisionPrescription, Identifier> =
    SimpleSearchParam<VisionPrescription, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "VisionPrescription.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Patient: SearchParam<VisionPrescription, Reference> =
    SimpleSearchParam<VisionPrescription, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "VisionPrescription.patient",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Prescriber: SearchParam<VisionPrescription, Reference> =
    SimpleSearchParam<VisionPrescription, Reference>(
      name = "prescriber",
      type = SearchParamType.fromCode("reference"),
      expression = "VisionPrescription.prescriber",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOf(resource.prescriber) },
    )

  public val Status: SearchParam<VisionPrescription, Any> =
    SimpleSearchParam<VisionPrescription, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "VisionPrescription.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /** All search parameters for the VisionPrescription resource type. */
  public val ALL: List<SearchParam<VisionPrescription, *>> =
    listOf(Datewritten, Encounter, Identifier, Patient, Prescriber, Status)
}
