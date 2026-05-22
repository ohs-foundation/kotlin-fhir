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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.MedicationDispense
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

/** Search parameters for the [MedicationDispense] resource type. */
public object MedicationDispenseSearchParam {
  public val Code: SearchParam<MedicationDispense, CodeableConcept> =
    SimpleSearchParam<MedicationDispense, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "(MedicationDispense.medication as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull(
          (resource.medication as? MedicationDispense.Medication.CodeableConcept)?.value
        )
      },
    )

  public val Context: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "context",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.context",
      target = listOf(EpisodeOfCare::class, Encounter::class),
      extractor = { resource -> listOfNotNull(resource.context) },
    )

  public val Destination: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "destination",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.destination",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.destination) },
    )

  public val Identifier: SearchParam<MedicationDispense, Identifier> =
    SimpleSearchParam<MedicationDispense, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationDispense.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Medication: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "(MedicationDispense.medication as Reference)",
      target = listOf(dev.ohs.fhir.model.r4.Medication::class),
      extractor = { resource ->
        listOfNotNull((resource.medication as? MedicationDispense.Medication.Reference)?.value)
      },
    )

  public val Patient: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.performer.actor",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          dev.ohs.fhir.model.r4.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val Prescription: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "prescription",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.authorizingPrescription",
      target = listOf(MedicationRequest::class),
      extractor = { resource -> resource.authorizingPrescription },
    )

  public val Receiver: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "receiver",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.receiver",
      target = listOf(Practitioner::class, dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> resource.receiver },
    )

  public val Responsibleparty: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "responsibleparty",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.substitution.responsibleParty",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> resource.substitution?.responsibleParty ?: emptyList() },
    )

  public val Status: SearchParam<MedicationDispense, Any> =
    SimpleSearchParam<MedicationDispense, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationDispense.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<MedicationDispense, Reference> =
    SimpleSearchParam<MedicationDispense, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val Type: SearchParam<MedicationDispense, CodeableConcept> =
    SimpleSearchParam<MedicationDispense, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationDispense.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val Whenhandedover: SearchParam<MedicationDispense, DateTime> =
    SimpleSearchParam<MedicationDispense, DateTime>(
      name = "whenhandedover",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationDispense.whenHandedOver",
      extractor = { resource -> listOfNotNull(resource.whenHandedOver) },
    )

  public val Whenprepared: SearchParam<MedicationDispense, DateTime> =
    SimpleSearchParam<MedicationDispense, DateTime>(
      name = "whenprepared",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationDispense.whenPrepared",
      extractor = { resource -> listOfNotNull(resource.whenPrepared) },
    )

  /** All search parameters for the MedicationDispense resource type. */
  public val ALL: List<SearchParam<MedicationDispense, *>> =
    listOf(
      Code,
      Context,
      Destination,
      Identifier,
      Medication,
      Patient,
      Performer,
      Prescription,
      Receiver,
      Responsibleparty,
      Status,
      Subject,
      Type,
      Whenhandedover,
      Whenprepared,
    )
}
