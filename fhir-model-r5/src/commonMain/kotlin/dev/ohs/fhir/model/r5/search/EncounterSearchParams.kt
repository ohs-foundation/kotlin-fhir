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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Account
import dev.ohs.fhir.model.r5.Appointment
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceRequest
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.EpisodeOfCare
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImmunizationRecommendation
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Encounter] resource type. */
public object EncounterSearchParams {
  public val account: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "account",
      type = SearchParamType.Reference,
      expression = "Encounter.account",
      target = listOf(Account::class),
      extractor = { resource -> resource.account },
    )

  public val appointment: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "appointment",
      type = SearchParamType.Reference,
      expression = "Encounter.appointment",
      target = listOf(Appointment::class),
      extractor = { resource -> resource.appointment },
    )

  public val basedOn: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.Reference,
      expression = "Encounter.basedOn",
      target =
        listOf(
          DeviceRequest::class,
          ServiceRequest::class,
          CarePlan::class,
          MedicationRequest::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val careteam: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "careteam",
      type = SearchParamType.Reference,
      expression = "Encounter.careTeam",
      target = listOf(CareTeam::class),
      extractor = { resource -> resource.careTeam },
    )

  public val `class`: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "class",
      type = SearchParamType.Token,
      expression = "Encounter.class",
      extractor = { resource -> resource.`class` },
    )

  public val date: SearchParam<Encounter, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "Encounter.actualPeriod",
      extractor = { resource -> listOfNotNull(resource.actualPeriod) },
    )

  public val dateStart: SearchParam<Encounter, DateTime> =
    SearchParam(
      name = "date-start",
      type = SearchParamType.Date,
      expression = "Encounter.actualPeriod.start",
      extractor = { resource -> listOfNotNull(resource.actualPeriod?.start) },
    )

  public val diagnosisCode: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "diagnosis-code",
      type = SearchParamType.Token,
      expression = "Encounter.diagnosis.condition.concept",
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
      },
    )

  public val diagnosisReference: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "diagnosis-reference",
      type = SearchParamType.Reference,
      expression = "Encounter.diagnosis.condition.reference",
      target = listOf(Condition::class),
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
      },
    )

  public val endDate: SearchParam<Encounter, DateTime> =
    SearchParam(
      name = "end-date",
      type = SearchParamType.Date,
      expression = "Encounter.actualPeriod.end",
      extractor = { resource -> listOfNotNull(resource.actualPeriod?.end) },
    )

  public val episodeOfCare: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "episode-of-care",
      type = SearchParamType.Reference,
      expression = "Encounter.episodeOfCare",
      target = listOf(EpisodeOfCare::class),
      extractor = { resource -> resource.episodeOfCare },
    )

  public val identifier: SearchParam<Encounter, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Encounter.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val length: SearchParam<Encounter, Duration> =
    SearchParam(
      name = "length",
      type = SearchParamType.Quantity,
      expression = "Encounter.length",
      extractor = { resource -> listOfNotNull(resource.length) },
    )

  public val location: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.Reference,
      expression = "Encounter.location.location",
      target = listOf(Location::class),
      extractor = { resource -> resource.location.map { it.location } },
    )

  public val locationPeriod: SearchParam<Encounter, Encounter.Location> =
    SearchParam(
      name = "location-period",
      type = SearchParamType.Composite,
      expression = "Encounter.location",
      extractor = { resource -> resource.location },
    )

  public val partOf: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "part-of",
      type = SearchParamType.Reference,
      expression = "Encounter.partOf",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val participant: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "participant",
      type = SearchParamType.Reference,
      expression = "Encounter.participant.actor",
      target =
        listOf(
          HealthcareService::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Group::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.participant.mapNotNull { it.actor } },
    )

  public val participantType: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "participant-type",
      type = SearchParamType.Token,
      expression = "Encounter.participant.type",
      extractor = { resource -> resource.participant.flatMap { it.type } },
    )

  public val patient: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Encounter.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val practitioner: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "practitioner",
      type = SearchParamType.Reference,
      expression = "Encounter.participant.actor.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.actor }
          .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
      },
    )

  public val reasonCode: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "reason-code",
      type = SearchParamType.Token,
      expression = "Encounter.reason.value.concept",
      extractor = { resource -> resource.reason.flatMap { it.`value` }.mapNotNull { it.concept } },
    )

  public val reasonReference: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "reason-reference",
      type = SearchParamType.Reference,
      expression = "Encounter.reason.value.reference",
      target =
        listOf(
          Procedure::class,
          Observation::class,
          DiagnosticReport::class,
          ImmunizationRecommendation::class,
          Condition::class,
        ),
      extractor = { resource ->
        resource.reason.flatMap { it.`value` }.mapNotNull { it.reference }
      },
    )

  public val serviceProvider: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "service-provider",
      type = SearchParamType.Reference,
      expression = "Encounter.serviceProvider",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.serviceProvider) },
    )

  public val specialArrangement: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "special-arrangement",
      type = SearchParamType.Token,
      expression = "Encounter.specialArrangement",
      extractor = { resource -> resource.specialArrangement },
    )

  public val status: SearchParam<Encounter, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Encounter.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "Encounter.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val subjectStatus: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "subject-status",
      type = SearchParamType.Token,
      expression = "Encounter.subjectStatus",
      extractor = { resource -> listOfNotNull(resource.subjectStatus) },
    )

  public val type: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "Encounter.type",
      extractor = { resource -> resource.type },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Encounter, *>> = listOf()

  /**
   * Supported search parameters for the Encounter resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Encounter, *>> =
    listOf(
      account,
      appointment,
      basedOn,
      careteam,
      `class`,
      date,
      dateStart,
      diagnosisCode,
      diagnosisReference,
      endDate,
      episodeOfCare,
      identifier,
      length,
      location,
      locationPeriod,
      partOf,
      participant,
      participantType,
      patient,
      practitioner,
      reasonCode,
      reasonReference,
      serviceProvider,
      specialArrangement,
      status,
      subject,
      subjectStatus,
      type,
    )
}
