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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DiagnosticReport
import dev.ohs.fhir.model.r4b.DocumentReference
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Measure
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.OperationDefinition
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Questionnaire
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Procedure] resource type. */
public object ProcedureSearchParams {
  public val basedOn: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.Reference,
      expression = "Procedure.basedOn",
      target = listOf(CarePlan::class, ServiceRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val category: SearchParam<Procedure, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "Procedure.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val code: SearchParam<Procedure, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "Procedure.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val date: SearchParam<Procedure, Procedure.Performed> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "Procedure.performed",
      extractor = { resource -> listOfNotNull(resource.performed) },
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
          Questionnaire::class,
          Measure::class,
          PlanDefinition::class,
          OperationDefinition::class,
          ActivityDefinition::class,
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
      target = listOf(Observation::class, Procedure::class, MedicationAdministration::class),
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
          Practitioner::class,
          Organization::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val reasonCode: SearchParam<Procedure, CodeableConcept> =
    SearchParam(
      name = "reason-code",
      type = SearchParamType.Token,
      expression = "Procedure.reasonCode",
      extractor = { resource -> resource.reasonCode },
    )

  public val reasonReference: SearchParam<Procedure, Reference> =
    SearchParam(
      name = "reason-reference",
      type = SearchParamType.Reference,
      expression = "Procedure.reasonReference",
      target =
        listOf(
          Condition::class,
          Observation::class,
          Procedure::class,
          DiagnosticReport::class,
          DocumentReference::class,
        ),
      extractor = { resource -> resource.reasonReference },
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
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Procedure, *>> = listOf()

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
      status,
      subject,
    )
}
