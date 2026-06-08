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
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationAdministration] resource type. */
public object MedicationAdministrationSearchParams {
  public val code: SearchParam<MedicationAdministration, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.medication.concept",
      extractor = { resource -> listOfNotNull(resource.medication.concept) },
    )

  public val date: SearchParam<MedicationAdministration, Any> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "MedicationAdministration.occurence.ofType(dateTime)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'date' has expression 'MedicationAdministration.occurence.ofType(dateTime)' which is not yet supported."
        )
      },
    )

  public val device: SearchParam<MedicationAdministration, Reference> =
    SearchParam(
      name = "device",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.device.reference",
      target = listOf(Device::class),
      extractor = { resource -> resource.device.mapNotNull { it.reference } },
    )

  public val encounter: SearchParam<MedicationAdministration, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<MedicationAdministration, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val medication: SearchParam<MedicationAdministration, Reference> =
    SearchParam(
      name = "medication",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.medication.reference",
      target = listOf(Medication::class),
      extractor = { resource -> listOfNotNull(resource.medication.reference) },
    )

  public val patient: SearchParam<MedicationAdministration, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<MedicationAdministration, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.performer.actor.reference",
      target =
        listOf(
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor }.mapNotNull { it.reference } },
    )

  public val performerDeviceCode: SearchParam<MedicationAdministration, CodeableConcept> =
    SearchParam(
      name = "performer-device-code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.performer.actor.concept",
      extractor = { resource -> resource.performer.map { it.actor }.mapNotNull { it.concept } },
    )

  public val reasonGiven: SearchParam<MedicationAdministration, Reference> =
    SearchParam(
      name = "reason-given",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.reason.reference",
      target = listOf(Observation::class, DiagnosticReport::class, Condition::class),
      extractor = { resource -> resource.reason.mapNotNull { it.reference } },
    )

  public val reasonGivenCode: SearchParam<MedicationAdministration, CodeableConcept> =
    SearchParam(
      name = "reason-given-code",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.reason.concept",
      extractor = { resource -> resource.reason.mapNotNull { it.concept } },
    )

  public val reasonNotGiven: SearchParam<MedicationAdministration, CodeableConcept> =
    SearchParam(
      name = "reason-not-given",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.statusReason",
      extractor = { resource -> resource.statusReason },
    )

  public val request: SearchParam<MedicationAdministration, Reference> =
    SearchParam(
      name = "request",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.request",
      target = listOf(MedicationRequest::class),
      extractor = { resource -> listOfNotNull(resource.request) },
    )

  public val status: SearchParam<MedicationAdministration, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicationAdministration.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<MedicationAdministration, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicationAdministration.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<MedicationAdministration, *>> = listOf(date)

  /**
   * Supported search parameters for the MedicationAdministration resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<MedicationAdministration, *>> =
    listOf(
      code,
      device,
      encounter,
      identifier,
      medication,
      patient,
      performer,
      performerDeviceCode,
      reasonGiven,
      reasonGivenCode,
      reasonNotGiven,
      request,
      status,
      subject,
    )
}
