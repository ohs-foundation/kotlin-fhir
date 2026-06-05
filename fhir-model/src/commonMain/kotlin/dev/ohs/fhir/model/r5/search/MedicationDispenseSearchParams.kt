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

import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicationDispense
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationDispense] resource type. */
public object MedicationDispenseSearchParams {
  public val code: SearchParam<MedicationDispense, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationDispense.medication.concept",
      extractor = { resource -> listOfNotNull(resource.medication.concept) },
    )

  public val destination: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "destination",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.destination",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.destination) },
    )

  public val encounter: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<MedicationDispense, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationDispense.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val medication: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.medication.reference",
      target = listOf(Medication::class),
      extractor = { resource -> listOfNotNull(resource.medication.reference) },
    )

  public val patient: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
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
          Organization::class,
          Device::class,
          CareTeam::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
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
      target =
        listOf(
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Location::class,
          Patient::class,
        ),
      extractor = { resource -> resource.`receiver` },
    )

  public val recorded: SearchParam<MedicationDispense, DateTime> =
    SearchParam(
      name = "recorded",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationDispense.recorded",
      extractor = { resource -> listOfNotNull(resource.recorded) },
    )

  public val responsibleparty: SearchParam<MedicationDispense, Reference> =
    SearchParam(
      name = "responsibleparty",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationDispense.substitution.responsibleParty",
      target = listOf(Organization::class, PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.substitution?.responsibleParty) },
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
      extractor = { resource -> listOf(resource.subject) },
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

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<MedicationDispense, *>> = listOf()

  /**
   * Supported search parameters for the MedicationDispense resource type. Entries in [unsupported]
   * are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<MedicationDispense, *>> =
    listOf(
      code,
      destination,
      encounter,
      identifier,
      location,
      medication,
      patient,
      performer,
      prescription,
      `receiver`,
      recorded,
      responsibleparty,
      status,
      subject,
      type,
      whenhandedover,
      whenprepared,
    ) - unsupported.toSet()
}
