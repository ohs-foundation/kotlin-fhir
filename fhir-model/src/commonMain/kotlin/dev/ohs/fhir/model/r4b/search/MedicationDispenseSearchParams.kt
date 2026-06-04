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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.EpisodeOfCare
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Medication
import dev.ohs.fhir.model.r4b.MedicationDispense
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationDispense] resource type. */
public object MedicationDispenseSearchParams {
  public val code: SearchParam<MedicationDispense, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "(MedicationDispense.medication as CodeableConcept)",
      extractor = { resource ->
        listOfNotNull(
          (resource.medication as? MedicationDispense.Medication.CodeableConcept)?.value
        )
      },
    )

  public val context: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "context",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.context",
      target = listOf(EpisodeOfCare::class, Encounter::class),
      extractor = { resource -> listOfNotNull(resource.context) },
    )

  public val destination: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "destination",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.destination",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.destination) },
    )

  public val identifier: SearchParam<MedicationDispense, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationDispense.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val medication: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "(MedicationDispense.medication as Reference)",
      target = listOf(Medication::class),
      extractor = { resource ->
        listOfNotNull((resource.medication as? MedicationDispense.Medication.Reference)?.value)
      },
    )

  public val patient: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.performer.actor",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val prescription: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "prescription",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.authorizingPrescription",
      target = listOf(MedicationRequest::class),
      extractor = { resource -> resource.authorizingPrescription },
    )

  public val `receiver`: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "receiver",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.receiver",
      target = listOf(Practitioner::class, Patient::class),
      extractor = { resource -> resource.`receiver` },
    )

  public val responsibleparty: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "responsibleparty",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.substitution.responsibleParty",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> resource.substitution?.responsibleParty ?: emptyList() },
    )

  public val status: SearchParam<MedicationDispense, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationDispense.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val type: SearchParam<MedicationDispense, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationDispense.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  public val whenhandedover: SearchParam<MedicationDispense, DateTime> =
    SearchParam(
      name = "whenhandedover",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationDispense.whenHandedOver",
      extractor = { resource -> listOfNotNull(resource.whenHandedOver) },
    )

  public val whenprepared: SearchParam<MedicationDispense, DateTime> =
    SearchParam(
      name = "whenprepared",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationDispense.whenPrepared",
      extractor = { resource -> listOfNotNull(resource.whenPrepared) },
    )

  /** All search parameters for the MedicationDispense resource type. */
  public val all: List<SearchParam<MedicationDispense, *>> =
    listOf(
      code,
      context,
      destination,
      identifier,
      medication,
      patient,
      performer,
      prescription,
      `receiver`,
      responsibleparty,
      status,
      subject,
      type,
      whenhandedover,
      whenprepared,
    )
}
