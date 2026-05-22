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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Immunization] resource type. */
public object ImmunizationSearchParam {
  public val Date: SearchParam<Immunization, Any> =
    SimpleSearchParam<Immunization, Any>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "(Immunization.occurrence.ofType(dateTime))",
      extractor = { emptyList() },
    )

  public val Identifier: SearchParam<Immunization, Identifier> =
    SimpleSearchParam<Immunization, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Immunization.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Location: SearchParam<Immunization, Reference> =
    SimpleSearchParam<Immunization, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Immunization.location",
      target = listOf(dev.ohs.fhir.model.r5.Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val LotNumber: SearchParam<Immunization, String> =
    SimpleSearchParam<Immunization, String>(
      name = "lot-number",
      type = SearchParamType.fromCode("string"),
      expression = "Immunization.lotNumber",
      extractor = { resource -> listOfNotNull(resource.lotNumber) },
    )

  public val Manufacturer: SearchParam<Immunization, Reference> =
    SimpleSearchParam<Immunization, Reference>(
      name = "manufacturer",
      type = SearchParamType.fromCode("reference"),
      expression = "Immunization.manufacturer.reference",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.manufacturer?.reference) },
    )

  public val Patient: SearchParam<Immunization, Reference> =
    SimpleSearchParam<Immunization, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Immunization.patient",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Performer: SearchParam<Immunization, Reference> =
    SimpleSearchParam<Immunization, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "Immunization.performer.actor",
      target =
        listOf(
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val Reaction: SearchParam<Immunization, Reference> =
    SimpleSearchParam<Immunization, Reference>(
      name = "reaction",
      type = SearchParamType.fromCode("reference"),
      expression = "Immunization.reaction.manifestation.reference",
      target = listOf(Observation::class),
      extractor = { resource ->
        resource.reaction.mapNotNull { it.manifestation }.mapNotNull { it.reference }
      },
    )

  public val ReactionDate: SearchParam<Immunization, DateTime> =
    SimpleSearchParam<Immunization, DateTime>(
      name = "reaction-date",
      type = SearchParamType.fromCode("date"),
      expression = "Immunization.reaction.date",
      extractor = { resource -> resource.reaction.mapNotNull { it.date } },
    )

  public val ReasonCode: SearchParam<Immunization, CodeableConcept> =
    SimpleSearchParam<Immunization, CodeableConcept>(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "Immunization.reason.concept",
      extractor = { resource -> resource.reason.mapNotNull { it.concept } },
    )

  public val ReasonReference: SearchParam<Immunization, Reference> =
    SimpleSearchParam<Immunization, Reference>(
      name = "reason-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Immunization.reason.reference",
      target = listOf(Observation::class, DiagnosticReport::class, Condition::class),
      extractor = { resource -> resource.reason.mapNotNull { it.reference } },
    )

  public val Series: SearchParam<Immunization, String> =
    SimpleSearchParam<Immunization, String>(
      name = "series",
      type = SearchParamType.fromCode("string"),
      expression = "Immunization.protocolApplied.series",
      extractor = { resource -> resource.protocolApplied.mapNotNull { it.series } },
    )

  public val Status: SearchParam<Immunization, Any> =
    SimpleSearchParam<Immunization, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Immunization.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val StatusReason: SearchParam<Immunization, CodeableConcept> =
    SimpleSearchParam<Immunization, CodeableConcept>(
      name = "status-reason",
      type = SearchParamType.fromCode("token"),
      expression = "Immunization.statusReason",
      extractor = { resource -> listOfNotNull(resource.statusReason) },
    )

  public val TargetDisease: SearchParam<Immunization, CodeableConcept> =
    SimpleSearchParam<Immunization, CodeableConcept>(
      name = "target-disease",
      type = SearchParamType.fromCode("token"),
      expression = "Immunization.protocolApplied.targetDisease",
      extractor = { resource -> resource.protocolApplied.flatMap { it.targetDisease } },
    )

  public val VaccineCode: SearchParam<Immunization, CodeableConcept> =
    SimpleSearchParam<Immunization, CodeableConcept>(
      name = "vaccine-code",
      type = SearchParamType.fromCode("token"),
      expression = "Immunization.vaccineCode",
      extractor = { resource -> listOf(resource.vaccineCode) },
    )

  /** All search parameters for the Immunization resource type. */
  public val ALL: List<SearchParam<Immunization, *>> =
    listOf(
      Date,
      Identifier,
      Location,
      LotNumber,
      Manufacturer,
      Patient,
      Performer,
      Reaction,
      ReactionDate,
      ReasonCode,
      ReasonReference,
      Series,
      Status,
      StatusReason,
      TargetDisease,
      VaccineCode,
    )
}
