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
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationAdministration] resource type. */
public object MedicationAdministrationSearchParam {
  public val Code: SearchParam<MedicationAdministration, CodeableConcept> =
    SimpleSearchParam<MedicationAdministration, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.medication.concept",
      extractor = { resource -> listOfNotNull(resource.medication.concept) },
    )

  public val Date: SearchParam<MedicationAdministration, Any> =
    SimpleSearchParam<MedicationAdministration, Any>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationAdministration.occurence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val Device: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.device.reference",
      target = listOf(dev.ohs.fhir.model.r5.Device::class),
      extractor = { resource -> resource.device.mapNotNull { it.reference } },
    )

  public val Encounter: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.encounter",
      target = listOf(dev.ohs.fhir.model.r5.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<MedicationAdministration, Identifier> =
    SimpleSearchParam<MedicationAdministration, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Medication: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.medication.reference",
      target = listOf(dev.ohs.fhir.model.r5.Medication::class),
      extractor = { resource -> listOfNotNull(resource.medication.reference) },
    )

  public val Patient: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.performer.actor.reference",
      target =
        listOf(
          dev.ohs.fhir.model.r5.Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor }.mapNotNull { it.reference } },
    )

  public val PerformerDeviceCode: SearchParam<MedicationAdministration, CodeableConcept> =
    SimpleSearchParam<MedicationAdministration, CodeableConcept>(
      name = "performer-device-code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.performer.actor.concept",
      extractor = { resource -> resource.performer.map { it.actor }.mapNotNull { it.concept } },
    )

  public val ReasonGiven: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "reason-given",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.reason.reference",
      target = listOf(Observation::class, DiagnosticReport::class, Condition::class),
      extractor = { resource -> resource.reason.mapNotNull { it.reference } },
    )

  public val ReasonGivenCode: SearchParam<MedicationAdministration, CodeableConcept> =
    SimpleSearchParam<MedicationAdministration, CodeableConcept>(
      name = "reason-given-code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.reason.concept",
      extractor = { resource -> resource.reason.mapNotNull { it.concept } },
    )

  public val ReasonNotGiven: SearchParam<MedicationAdministration, CodeableConcept> =
    SimpleSearchParam<MedicationAdministration, CodeableConcept>(
      name = "reason-not-given",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.statusReason",
      extractor = { resource -> resource.statusReason },
    )

  public val Request: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.request",
      target = listOf(MedicationRequest::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val Status: SearchParam<MedicationAdministration, Any> =
    SimpleSearchParam<MedicationAdministration, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<MedicationAdministration, Reference> =
    SimpleSearchParam<MedicationAdministration, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the MedicationAdministration resource type. */
  public val ALL: List<SearchParam<MedicationAdministration, *>> =
    listOf(
      Code,
      Date,
      Device,
      Encounter,
      Identifier,
      Medication,
      Patient,
      Performer,
      PerformerDeviceCode,
      ReasonGiven,
      ReasonGivenCode,
      ReasonNotGiven,
      Request,
      Status,
      Subject,
    )
}
