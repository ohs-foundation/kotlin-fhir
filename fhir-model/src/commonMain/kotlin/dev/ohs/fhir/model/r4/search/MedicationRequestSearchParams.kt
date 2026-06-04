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

import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationRequest] resource type. */
public object MedicationRequestSearchParams {
  public val Authoredon: SearchParam<MedicationRequest, DateTime> =
    SimpleSearchParam<MedicationRequest, DateTime>(
      name = "authoredon",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationRequest.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val Category: SearchParam<MedicationRequest, CodeableConcept> =
    SimpleSearchParam<MedicationRequest, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationRequest.category",
      extractor = { resource -> resource.category },
    )

  public val Code: SearchParam<MedicationRequest, CodeableConcept> =
    SimpleSearchParam<MedicationRequest, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "(MedicationRequest.medication as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull((resource.medication as? MedicationRequest.Medication.CodeableConcept)?.value)
      },
    )

  public val Date: SearchParam<MedicationRequest, DateTime> =
    SimpleSearchParam<MedicationRequest, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationRequest.dosageInstruction.timing.event",
      extractor = { resource ->
        resource.dosageInstruction.mapNotNull { it.timing }.flatMap { it.event }
      },
    )

  public val Encounter: SearchParam<MedicationRequest, Reference> =
    SimpleSearchParam<MedicationRequest, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationRequest.encounter",
      target = listOf(dev.ohs.fhir.model.r4.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<MedicationRequest, Identifier> =
    SimpleSearchParam<MedicationRequest, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val IntendedDispenser: SearchParam<MedicationRequest, Reference> =
    SimpleSearchParam<MedicationRequest, Reference>(
      name = "intended-dispenser",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationRequest.dispenseRequest.performer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.dispenseRequest?.performer) },
    )

  public val IntendedPerformer: SearchParam<MedicationRequest, Reference> =
    SimpleSearchParam<MedicationRequest, Reference>(
      name = "intended-performer",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationRequest.performer",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.performer) },
    )

  public val IntendedPerformertype: SearchParam<MedicationRequest, CodeableConcept> =
    SimpleSearchParam<MedicationRequest, CodeableConcept>(
      name = "intended-performertype",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationRequest.performerType",
      extractor = { resource -> listOfNotNull(resource.performerType) },
    )

  public val Intent: SearchParam<MedicationRequest, Any> =
    SimpleSearchParam<MedicationRequest, Any>(
      name = "intent",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationRequest.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val Medication: SearchParam<MedicationRequest, Reference> =
    SimpleSearchParam<MedicationRequest, Reference>(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "(MedicationRequest.medication as Reference)",
      target = listOf(dev.ohs.fhir.model.r4.Medication::class),
      extractor = { resource ->
        listOfNotNull((resource.medication as? MedicationRequest.Medication.Reference)?.value)
      },
    )

  public val Patient: SearchParam<MedicationRequest, Reference> =
    SimpleSearchParam<MedicationRequest, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationRequest.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Priority: SearchParam<MedicationRequest, Any> =
    SimpleSearchParam<MedicationRequest, Any>(
      name = "priority",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationRequest.priority",
      extractor = { resource -> listOfNotNull(resource.priority) },
    )

  public val Requester: SearchParam<MedicationRequest, Reference> =
    SimpleSearchParam<MedicationRequest, Reference>(
      name = "requester",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationRequest.requester",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.requester) },
    )

  public val Status: SearchParam<MedicationRequest, Any> =
    SimpleSearchParam<MedicationRequest, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationRequest.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<MedicationRequest, Reference> =
    SimpleSearchParam<MedicationRequest, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationRequest.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the MedicationRequest resource type. */
  public val ALL: List<SearchParam<MedicationRequest, *>> =
    listOf(
      Authoredon,
      Category,
      Code,
      Date,
      Encounter,
      Identifier,
      IntendedDispenser,
      IntendedPerformer,
      IntendedPerformertype,
      Intent,
      Medication,
      Patient,
      Priority,
      Requester,
      Status,
      Subject,
    )
}
