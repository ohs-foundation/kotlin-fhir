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

import dev.ohs.fhir.model.r5.ActivityDefinition
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Composition
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Measure
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.OperationDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Questionnaire
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Procedure] resource type. */
public object ProcedureSearchParams {
  public val basedOn: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.basedOn",
      target = listOf(ServiceRequest::class, CarePlan::class),
      extractor = { resource -> resource.basedOn },
    )

  public val category: SearchParam<Procedure, CodeableConcept> =
    SearchParam<Procedure, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<Procedure, CodeableConcept> =
    SearchParam<Procedure, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val date: SearchParam<Procedure, Any> =
    SearchParam<Procedure, Any>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Procedure.occurrence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val encounter: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<Procedure, Identifier> =
    SearchParam<Procedure, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<Procedure, Canonical> =
    SearchParam<Procedure, Canonical>(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.instantiatesCanonical",
      target =
        listOf(
          Measure::class,
          OperationDefinition::class,
          ActivityDefinition::class,
          PlanDefinition::class,
          Questionnaire::class,
        ),
      extractor = { resource -> resource.instantiatesCanonical },
    )

  public val instantiatesUri: SearchParam<Procedure, Uri> =
    SearchParam<Procedure, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "Procedure.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val location: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val partOf: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.partOf",
      target = listOf(Procedure::class, Observation::class, MedicationAdministration::class),
      extractor = { resource -> resource.partOf },
    )

  public val patient: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.performer.actor",
      target =
        listOf(
          HealthcareService::class,
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

  public val reasonCode: SearchParam<Procedure, CodeableConcept> =
    SearchParam<Procedure, CodeableConcept>(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.reason.concept",
      extractor = { resource -> resource.reason.mapNotNull { it.concept } },
    )

  public val reasonReference: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "reason-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.reason.reference",
      target =
        listOf(
          Procedure::class,
          DocumentReference::class,
          Observation::class,
          DiagnosticReport::class,
          Condition::class,
        ),
      extractor = { resource -> resource.reason.mapNotNull { it.reference } },
    )

  public val report: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "report",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.report",
      target = listOf(Composition::class, DocumentReference::class, DiagnosticReport::class),
      extractor = { resource -> resource.report },
    )

  public val status: SearchParam<Procedure, Any> =
    SearchParam<Procedure, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Procedure, Reference> =
    SearchParam<Procedure, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.subject",
      target =
        listOf(
          Device::class,
          Organization::class,
          Group::class,
          Practitioner::class,
          Location::class,
          Patient::class,
        ),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the Procedure resource type. */
  public val all: List<SearchParam<Procedure, *>> =
    listOf(
      basedOn,
      category,
      code,
      date,
      encounter,
      identifier,
      instantiatesCanonical,
      instantiatesUri,
      location,
      partOf,
      patient,
      performer,
      reasonCode,
      reasonReference,
      report,
      status,
      subject,
    )
}
