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
    SimpleSearchParam<Encounter, Reference>(
      name = "account",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.account",
      target = listOf(Account::class),
      extractor = { resource -> resource.account },
    )

  public val appointment: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "appointment",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.appointment",
      target = listOf(Appointment::class),
      extractor = { resource -> resource.appointment },
    )

  public val basedOn: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
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
    SimpleSearchParam<Encounter, Reference>(
      name = "careteam",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.careTeam",
      target = listOf(CareTeam::class),
      extractor = { resource -> resource.careTeam },
    )

  public val `class`: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "class",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.class",
      extractor = { resource -> resource.`class` },
    )

  public val date: SearchParam<Encounter, Period> =
    SimpleSearchParam<Encounter, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.actualPeriod",
      extractor = { resource -> listOfNotNull(resource.actualPeriod) },
    )

  public val dateStart: SearchParam<Encounter, DateTime> =
    SimpleSearchParam<Encounter, DateTime>(
      name = "date-start",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.actualPeriod.start",
      extractor = { resource -> listOfNotNull(resource.actualPeriod?.start) },
    )

  public val diagnosisCode: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "diagnosis-code",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.diagnosis.condition.concept",
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
      },
    )

  public val diagnosisReference: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "diagnosis-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.diagnosis.condition.reference",
      target = listOf(Condition::class),
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
      },
    )

  public val endDate: SearchParam<Encounter, DateTime> =
    SimpleSearchParam<Encounter, DateTime>(
      name = "end-date",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.actualPeriod.end",
      extractor = { resource -> listOfNotNull(resource.actualPeriod?.end) },
    )

  public val episodeOfCare: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "episode-of-care",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.episodeOfCare",
      target = listOf(EpisodeOfCare::class),
      extractor = { resource -> resource.episodeOfCare },
    )

  public val identifier: SearchParam<Encounter, Identifier> =
    SimpleSearchParam<Encounter, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val length: SearchParam<Encounter, Duration> =
    SimpleSearchParam<Encounter, Duration>(
      name = "length",
      type = SearchParamType.fromCode("quantity"),
      expression = "Encounter.length",
      extractor = { resource -> listOfNotNull(resource.length) },
    )

  public val location: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.location.location",
      target = listOf(Location::class),
      extractor = { resource -> resource.location.map { it.location } },
    )

  public val locationPeriod: SearchParam<Encounter, Encounter.Location> =
    SimpleSearchParam<Encounter, Encounter.Location>(
      name = "location-period",
      type = SearchParamType.fromCode("composite"),
      expression = "Encounter.location",
      extractor = { resource -> resource.location },
    )

  public val partOf: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.partOf",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val participant: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "participant",
      type = SearchParamType.fromCode("reference"),
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
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "participant-type",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.participant.type",
      extractor = { resource -> resource.participant.flatMap { it.type } },
    )

  public val patient: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val practitioner: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.participant.actor.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.actor }
          .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
      },
    )

  public val reasonCode: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.reason.value.concept",
      extractor = { resource -> resource.reason.flatMap { it.`value` }.mapNotNull { it.concept } },
    )

  public val reasonReference: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "reason-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.reason.value.reference",
      target =
        listOf(
          Procedure::class,
          Observation::class,
          DiagnosticReport::class,
          ImmunizationRecommendation::class,
          Condition::class,
        ),
      extractor = { resource -> resource.reason.flatMap { it.`value` }.mapNotNull { it.reference } },
    )

  public val serviceProvider: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "service-provider",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.serviceProvider",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.serviceProvider) },
    )

  public val specialArrangement: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "special-arrangement",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.specialArrangement",
      extractor = { resource -> resource.specialArrangement },
    )

  public val status: SearchParam<Encounter, Any> =
    SimpleSearchParam<Encounter, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val subjectStatus: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "subject-status",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.subjectStatus",
      extractor = { resource -> listOfNotNull(resource.subjectStatus) },
    )

  public val type: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.type",
      extractor = { resource -> resource.type },
    )

  /** All search parameters for the Encounter resource type. */
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
