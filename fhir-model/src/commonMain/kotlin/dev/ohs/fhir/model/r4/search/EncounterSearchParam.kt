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
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Condition
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.ImmunizationRecommendation
import dev.ohs.fhir.model.r4.Observation
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Procedure
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
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
      target = listOf(dev.ohs.fhir.model.r4.Account::class),
      extractor = { resource -> resource.account },
    )

  public val Appointment: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "appointment",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.appointment",
      target = listOf(dev.ohs.fhir.model.r4.Appointment::class),
      extractor = { resource -> resource.appointment },
    )

  public val BasedOn: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.basedOn",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val Class: SearchParam<Encounter, Coding> =
    SimpleSearchParam<Encounter, Coding>(
      name = "class",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.class",
      extractor = { resource -> listOf(resource.`class`) },
    )

  public val Date: SearchParam<Encounter, Period> =
    SimpleSearchParam<Encounter, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val Diagnosis: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "diagnosis",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.diagnosis.condition",
      target = listOf(Condition::class, Procedure::class),
      extractor = { resource -> resource.diagnosis.map { it.condition } },
    )

  public val EpisodeOfCare: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "episode-of-care",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.episodeOfCare",
      target = listOf(dev.ohs.fhir.model.r4.EpisodeOfCare::class),
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
      target = listOf(dev.ohs.fhir.model.r4.Location::class),
      extractor = { resource -> resource.location.map { it.location } },
    )

  public val LocationPeriod: SearchParam<Encounter, Period> =
    SimpleSearchParam<Encounter, Period>(
      name = "location-period",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.location.period",
      extractor = { resource -> resource.location.mapNotNull { it.period } },
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
      expression = "Encounter.participant.individual",
      target =
        listOf(
          dev.ohs.fhir.model.r4.Practitioner::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.participant.mapNotNull { it.individual } },
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
      target = listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class),
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
      expression = "Encounter.participant.individual.where(resolve() is Practitioner)",
      target = listOf(dev.ohs.fhir.model.r4.Practitioner::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.individual }
          .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
      },
    )

  public val ReasonCode: SearchParam<Encounter, CodeableConcept> =
    SimpleSearchParam<Encounter, CodeableConcept>(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.reasonCode",
      extractor = { resource -> resource.reasonCode },
    )

  public val ReasonReference: SearchParam<Encounter, Reference> =
    SimpleSearchParam<Encounter, Reference>(
      name = "reason-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.reasonReference",
      target =
        listOf(
          Condition::class,
          Observation::class,
          Procedure::class,
          ImmunizationRecommendation::class,
        ),
      extractor = { resource -> resource.reasonReference },
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
      expression = "Encounter.hospitalization.specialArrangement",
      extractor = { resource -> resource.hospitalization?.specialArrangement ?: emptyList() },
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
      target = listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
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
      Class,
      Date,
      Diagnosis,
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
      Type,
    )
}
