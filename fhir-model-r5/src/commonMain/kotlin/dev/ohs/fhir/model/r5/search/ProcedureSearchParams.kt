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
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Procedure] resource type. */
public object ProcedureSearchParams {
  public val basedOn: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.Reference,
      expression = "Procedure.basedOn",
      target = listOf(ServiceRequest::class, CarePlan::class),
      extractor = { resource -> resource.basedOn },
    )

  public val category: SearchParam<Procedure, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "Procedure.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<Procedure, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "Procedure.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val date: SearchParam<Procedure, Any> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "Procedure.occurrence.ofType(dateTime)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'date' has expression 'Procedure.occurrence.ofType(dateTime)' which is not yet supported."
        )
      },
    )

  public val encounter: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "Procedure.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<Procedure, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Procedure.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<Procedure, Canonical> =
    SearchParam(
      name = "instantiates-canonical",
      type = SearchParamType.Reference,
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
    SearchParam(
      name = "instantiates-uri",
      type = SearchParamType.Uri,
      expression = "Procedure.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val location: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "location",
      type = SearchParamType.Reference,
      expression = "Procedure.location",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val partOf: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "part-of",
      type = SearchParamType.Reference,
      expression = "Procedure.partOf",
      target = listOf(Procedure::class, Observation::class, MedicationAdministration::class),
      extractor = { resource -> resource.partOf },
    )

  public val patient: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Procedure.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.Reference,
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
    SearchParam(
      name = "reason-code",
      type = SearchParamType.Token,
      expression = "Procedure.reason.concept",
      extractor = { resource -> resource.reason.mapNotNull { it.concept } },
    )

  public val reasonReference: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "reason-reference",
      type = SearchParamType.Reference,
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
    SearchParam(
      name = "report",
      type = SearchParamType.Reference,
      expression = "Procedure.report",
      target = listOf(Composition::class, DocumentReference::class, DiagnosticReport::class),
      extractor = { resource -> resource.report },
    )

  public val status: SearchParam<Procedure, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Procedure.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
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

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Procedure, *>> = listOf(date)

  /**
   * Supported search parameters for the Procedure resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Procedure, *>> =
    listOf(
      basedOn,
      category,
      code,
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
