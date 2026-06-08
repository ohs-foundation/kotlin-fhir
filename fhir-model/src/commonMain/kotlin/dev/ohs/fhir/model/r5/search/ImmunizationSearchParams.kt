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
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Immunization] resource type. */
public object ImmunizationSearchParams {
  public val date: SearchParam<Immunization, Any> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "(Immunization.occurrence.ofType(dateTime))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'date' has expression '(Immunization.occurrence.ofType(dateTime))' which is not yet supported."
        )
      },
    )

  public val identifier: SearchParam<Immunization, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Immunization.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val location: SearchParam<Immunization, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.Reference,
      expression = "Immunization.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val lotNumber: SearchParam<Immunization, String> =
    SearchParam(
      name = "lot-number",
      type = SearchParamType.String,
      expression = "Immunization.lotNumber",
      extractor = { resource -> listOfNotNull(resource.lotNumber) },
    )

  public val manufacturer: SearchParam<Immunization, Reference> =
    SearchParam(
      name = "manufacturer",
      type = SearchParamType.Reference,
      expression = "Immunization.manufacturer.reference",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.manufacturer?.reference) },
    )

  public val patient: SearchParam<Immunization, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Immunization.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val performer: SearchParam<Immunization, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.Reference,
      expression = "Immunization.performer.actor",
      target =
        listOf(
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val reaction: SearchParam<Immunization, Reference> =
    SearchParam(
      name = "reaction",
      type = SearchParamType.Reference,
      expression = "Immunization.reaction.manifestation.reference",
      target = listOf(Observation::class),
      extractor = { resource ->
        resource.reaction.mapNotNull { it.manifestation }.mapNotNull { it.reference }
      },
    )

  public val reactionDate: SearchParam<Immunization, DateTime> =
    SearchParam(
      name = "reaction-date",
      type = SearchParamType.Date,
      expression = "Immunization.reaction.date",
      extractor = { resource -> resource.reaction.mapNotNull { it.date } },
    )

  public val reasonCode: SearchParam<Immunization, CodeableConcept> =
    SearchParam(
      name = "reason-code",
      type = SearchParamType.Token,
      expression = "Immunization.reason.concept",
      extractor = { resource -> resource.reason.mapNotNull { it.concept } },
    )

  public val reasonReference: SearchParam<Immunization, Reference> =
    SearchParam(
      name = "reason-reference",
      type = SearchParamType.Reference,
      expression = "Immunization.reason.reference",
      target = listOf(Observation::class, DiagnosticReport::class, Condition::class),
      extractor = { resource -> resource.reason.mapNotNull { it.reference } },
    )

  public val series: SearchParam<Immunization, String> =
    SearchParam(
      name = "series",
      type = SearchParamType.String,
      expression = "Immunization.protocolApplied.series",
      extractor = { resource -> resource.protocolApplied.mapNotNull { it.series } },
    )

  public val status: SearchParam<Immunization, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Immunization.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val statusReason: SearchParam<Immunization, CodeableConcept> =
    SearchParam(
      name = "status-reason",
      type = SearchParamType.Token,
      expression = "Immunization.statusReason",
      extractor = { resource -> listOfNotNull(resource.statusReason) },
    )

  public val targetDisease: SearchParam<Immunization, CodeableConcept> =
    SearchParam(
      name = "target-disease",
      type = SearchParamType.Token,
      expression = "Immunization.protocolApplied.targetDisease",
      extractor = { resource -> resource.protocolApplied.flatMap { it.targetDisease } },
    )

  public val vaccineCode: SearchParam<Immunization, CodeableConcept> =
    SearchParam(
      name = "vaccine-code",
      type = SearchParamType.Token,
      expression = "Immunization.vaccineCode",
      extractor = { resource -> listOf(resource.vaccineCode) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Immunization, *>> = listOf(date)

  /**
   * Supported search parameters for the Immunization resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Immunization, *>> =
    listOf(
      identifier,
      location,
      lotNumber,
      manufacturer,
      patient,
      performer,
      reaction,
      reactionDate,
      reasonCode,
      reasonReference,
      series,
      status,
      statusReason,
      targetDisease,
      vaccineCode,
    )
}
