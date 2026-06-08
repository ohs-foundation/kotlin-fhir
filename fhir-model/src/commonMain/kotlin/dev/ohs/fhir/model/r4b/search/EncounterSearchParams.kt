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

import dev.ohs.fhir.model.r4b.Account
import dev.ohs.fhir.model.r4b.Appointment
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.EpisodeOfCare
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ImmunizationRecommendation
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Encounter] resource type. */
public object EncounterSearchParams {
  public val account: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "account",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.account",
      target = listOf(Account::class),
      extractor = { resource -> resource.account },
    )

  public val appointment: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "appointment",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.appointment",
      target = listOf(Appointment::class),
      extractor = { resource -> resource.appointment },
    )

  public val basedOn: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.basedOn",
      target = listOf(ServiceRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val `class`: SearchParam<Encounter, Coding> =
    SearchParam(
      name = "class",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.class",
      extractor = { resource -> listOf(resource.`class`) },
    )

  public val date: SearchParam<Encounter, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val diagnosis: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "diagnosis",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.diagnosis.condition",
      target = listOf(Condition::class, Procedure::class),
      extractor = { resource -> resource.diagnosis.map { it.condition } },
    )

  public val episodeOfCare: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "episode-of-care",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.episodeOfCare",
      target = listOf(EpisodeOfCare::class),
      extractor = { resource -> resource.episodeOfCare },
    )

  public val identifier: SearchParam<Encounter, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val length: SearchParam<Encounter, Duration> =
    SearchParam(
      name = "length",
      type = SearchParamType.fromCode("quantity"),
      expression = "Encounter.length",
      extractor = { resource -> listOfNotNull(resource.length) },
    )

  public val location: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.location.location",
      target = listOf(Location::class),
      extractor = { resource -> resource.location.map { it.location } },
    )

  public val locationPeriod: SearchParam<Encounter, Period> =
    SearchParam(
      name = "location-period",
      type = SearchParamType.fromCode("date"),
      expression = "Encounter.location.period",
      extractor = { resource -> resource.location.mapNotNull { it.period } },
    )

  public val partOf: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.partOf",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.partOf) },
    )

  public val participant: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "participant",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.participant.individual",
      target = listOf(Practitioner::class, PractitionerRole::class, RelatedPerson::class),
      extractor = { resource -> resource.participant.mapNotNull { it.individual } },
    )

  public val participantType: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "participant-type",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.participant.type",
      extractor = { resource -> resource.participant.flatMap { it.type } },
    )

  public val patient: SearchParam<Encounter, Reference> =
    SearchParam(
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
    SearchParam(
      name = "practitioner",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.participant.individual.where(resolve() is Practitioner)",
      target = listOf(Practitioner::class),
      extractor = { resource ->
        resource.participant
          .mapNotNull { it.individual }
          .filter { it.reference?.value?.toString()?.contains("Practitioner/") == true }
      },
    )

  public val reasonCode: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.reasonCode",
      extractor = { resource -> resource.reasonCode },
    )

  public val reasonReference: SearchParam<Encounter, Reference> =
    SearchParam(
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

  public val serviceProvider: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "service-provider",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.serviceProvider",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.serviceProvider) },
    )

  public val specialArrangement: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "special-arrangement",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.hospitalization.specialArrangement",
      extractor = { resource -> resource.hospitalization?.specialArrangement ?: emptyList() },
    )

  public val status: SearchParam<Encounter, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Encounter, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Encounter.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val type: SearchParam<Encounter, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Encounter.type",
      extractor = { resource -> resource.type },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
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
      `class`,
      date,
      diagnosis,
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
      type,
    )
}
