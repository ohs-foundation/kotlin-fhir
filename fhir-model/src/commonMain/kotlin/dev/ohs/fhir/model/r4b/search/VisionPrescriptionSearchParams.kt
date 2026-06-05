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

import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.VisionPrescription
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [VisionPrescription] resource type. */
public object VisionPrescriptionSearchParams {
  public val datewritten: SearchParam<VisionPrescription, DateTime> =
    SearchParam(
      name = "datewritten",
      type = SearchParamType.fromCode("date"),
      expression = "VisionPrescription.dateWritten",
      extractor = { resource -> listOf(resource.dateWritten) },
    )

  public val encounter: SearchParam<VisionPrescription, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "VisionPrescription.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<VisionPrescription, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "VisionPrescription.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val patient: SearchParam<VisionPrescription, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "VisionPrescription.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val prescriber: SearchParam<VisionPrescription, Reference> =
    SearchParam(
      name = "prescriber",
      type = SearchParamType.fromCode("reference"),
      expression = "VisionPrescription.prescriber",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOf(resource.prescriber) },
    )

  public val status: SearchParam<VisionPrescription, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "VisionPrescription.status",
      extractor = { resource -> listOf(resource.status) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<VisionPrescription, *>> = listOf()

  /**
   * Supported search parameters for the VisionPrescription resource type. Entries in [unsupported]
   * are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<VisionPrescription, *>> =
    listOf(datewritten, encounter, identifier, patient, prescriber, status) - unsupported.toSet()
}
