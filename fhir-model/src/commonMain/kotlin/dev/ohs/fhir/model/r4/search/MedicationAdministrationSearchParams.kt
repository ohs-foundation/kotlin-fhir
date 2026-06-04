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
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.MedicationAdministration
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationAdministration] resource type. */
public object MedicationAdministrationSearchParams {
  public val code: SearchParam<MedicationAdministration, CodeableConcept> =
    SimpleSearchParam<MedicationAdministration, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "(MedicationAdministration.medication as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull(
          (resource.medication as? MedicationAdministration.Medication.CodeableConcept)?.value
        )
      },
    )

  public val context: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "context",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.context",
      target = listOf(EpisodeOfCare::class, Encounter::class),
      extractor = { resource -> listOfNotNull(resource.context) },
    )

  public val device: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.device",
      target = listOf(Device::class),
      extractor = { resource -> resource.device },
    )

  public val effectiveTime:
    SearchParam<MedicationAdministration, MedicationAdministration.Effective> =
    SimpleSearchParam<MedicationAdministration, MedicationAdministration.Effective>(
      name = "effective-time",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationAdministration.effective",
      extractor = { resource -> listOf(resource.effective) },
    )

  public val identifier: SearchParam<MedicationAdministration, Identifier> =
    SimpleSearchParam<MedicationAdministration, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val medication: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "(MedicationAdministration.medication as Reference)",
      target = listOf(Medication::class),
      extractor = { resource ->
        listOfNotNull(
          (resource.medication as? MedicationAdministration.Medication.Reference)?.value
        )
      },
    )

  public val patient: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.subject.where(resolve() is Patient)",
      target = listOf(Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.performer.actor",
      target =
        listOf(
          Practitioner::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val reasonGiven: SearchParam<MedicationAdministration, CodeableConcept> =
    SimpleSearchParam<MedicationAdministration, CodeableConcept>(
      name = "reason-given",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.reasonCode",
      extractor = { resource -> resource.reasonCode },
    )

  public val reasonNotGiven: SearchParam<MedicationAdministration, CodeableConcept> =
    SimpleSearchParam<MedicationAdministration, CodeableConcept>(
      name = "reason-not-given",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.statusReason",
      extractor = { resource -> resource.statusReason },
    )

  public val request: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.request",
      target = listOf(MedicationRequest::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val status: SearchParam<MedicationAdministration, Any> =
    SimpleSearchParam<MedicationAdministration, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the MedicationAdministration resource type. */
  public val all: List<SearchParam<MedicationAdministration, *>> =
    listOf(
      code,
      context,
      device,
      effectiveTime,
      identifier,
      medication,
      patient,
      performer,
      reasonGiven,
      reasonNotGiven,
      request,
      status,
      subject,
    )
}
