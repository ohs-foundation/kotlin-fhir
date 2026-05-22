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
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImmunizationRecommendation
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Period
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
public object EncounterSearchParam {
  public val Account: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "account",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.account",
      target = listOf(dev.ohs.fhir.model.r5.Account::class),
      extractor = { resource -> resource.account },
    )

  public val Appointment: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "appointment",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.appointment",
      target = listOf(dev.ohs.fhir.model.r5.Appointment::class),
      extractor = { resource -> resource.appointment },
    )

  public val BasedOn: SearchParam<Encounter, Reference> =
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

  public val Careteam: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "careteam",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.careTeam",
      target = listOf(CareTeam::class),
      extractor = { resource -> resource.careTeam },
    )

  public val Class: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "class",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.class",
      extractor = { resource -> resource.`class` },
    )

  public val Date: SearchParam<Encounter, Period> =
    SimpleSearchParam<Encounter, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.actualPeriod",
      extractor = { resource -> listOfNotNull(resource.actualPeriod) },
    )

  public val DateStart: SearchParam<Encounter, DateTime> =
    SimpleSearchParam<Encounter, DateTime>(
      name = "date-start",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.actualPeriod.start",
      extractor = { resource -> listOfNotNull(resource.actualPeriod?.start) },
    )

  public val DiagnosisCode: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "diagnosis-code",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.diagnosis.condition.concept",
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.concept }
      },
    )

  public val DiagnosisReference: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "diagnosis-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.diagnosis.condition.reference",
      target = listOf(Condition::class),
      extractor = { resource ->
        resource.diagnosis.flatMap { it.condition }.mapNotNull { it.reference }
      },
    )

  public val EndDate: SearchParam<Encounter, DateTime> =
    SimpleSearchParam<Encounter, DateTime>(
      name = "end-date",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.actualPeriod.end",
      extractor = { resource -> listOfNotNull(resource.actualPeriod?.end) },
    )

  public val EpisodeOfCare: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "episode-of-care",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.episodeOfCare",
      target = listOf(dev.ohs.fhir.model.r5.EpisodeOfCare::class),
      extractor = { resource -> resource.episodeOfCare },
    )

  public val Identifier: SearchParam<Encounter, Identifier> =
    SimpleSearchParam<Encounter, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Length: SearchParam<Encounter, Duration> =
    SimpleSearchParam<Encounter, Duration>(
      name = "length",
      type = SearchParamType.fromCode("quantity"),
      expression = "Encounter.length",
      extractor = { resource -> listOfNotNull(resource.length) },
    )

  public val Location: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.location.location",
      target = listOf(dev.ohs.fhir.model.r5.Location::class),
      extractor = { resource -> resource.location.map { it.location } },
    )

  public val LocationPeriod: SearchParam<Encounter, Encounter.Location> =
    SimpleSearchParam<Encounter, Encounter.Location>(
      name = "location-period",
      type = SearchParamType.fromCode("composite"),
      expression = "Encounter.location",
      extractor = { resource -> resource.location },
    )

  public val PartOf: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.partOf",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val Participant: SearchParam<Encounter, Reference> =
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
          dev.ohs.fhir.model.r5.Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.participant.mapNotNull { it.actor } },
    )

  public val ParticipantType: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "participant-type",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.participant.type",
      extractor = { resource -> resource.participant.flatMap { it.type } },
    )

  public val Patient: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Practitioner: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.participant.actor.where(resolve() is Practitioner)",
      target = listOf(dev.ohs.fhir.model.r5.Practitioner::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.actor }
          .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
      },
    )

  public val ReasonCode: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.reason.value.concept",
      extractor = { resource -> resource.reason.flatMap { it.value }.mapNotNull { it.concept } },
    )

  public val ReasonReference: SearchParam<Encounter, Reference> =
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
      extractor = { resource -> resource.reason.flatMap { it.value }.mapNotNull { it.reference } },
    )

  public val ServiceProvider: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "service-provider",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.serviceProvider",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.serviceProvider) },
    )

  public val SpecialArrangement: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "special-arrangement",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.specialArrangement",
      extractor = { resource -> resource.specialArrangement },
    )

  public val Status: SearchParam<Encounter, Any> =
    SimpleSearchParam<Encounter, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val SubjectStatus: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "subject-status",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.subjectStatus",
      extractor = { resource -> listOfNotNull(resource.subjectStatus) },
    )

  public val Type: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.type",
      extractor = { resource -> resource.type },
    )

  /** All search parameters for the Encounter resource type. */
  public val ALL: List<SearchParam<Encounter, *>> =
    listOf(
      Account,
      Appointment,
      BasedOn,
      Careteam,
      Class,
      Date,
      DateStart,
      DiagnosisCode,
      DiagnosisReference,
      EndDate,
      EpisodeOfCare,
      Identifier,
      Length,
      Location,
      LocationPeriod,
      PartOf,
      Participant,
      ParticipantType,
      Patient,
      Practitioner,
      ReasonCode,
      ReasonReference,
      ServiceProvider,
      SpecialArrangement,
      Status,
      Subject,
      SubjectStatus,
      Type,
    )
}
