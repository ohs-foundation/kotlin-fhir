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

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DiagnosticReport
import dev.ohs.fhir.model.r4b.DocumentReference
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Measure
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.OperationDefinition
import dev.ohs.fhir.model.r4b.Organization
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
  public val BasedOn: SearchParam<Procedure, Reference> =
    SimpleSearchParam<Procedure, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.basedOn",
      target = listOf(CarePlan::class, ServiceRequest::class),
      extractor = { resource -> resource.basedOn },
    )

  public val Category: SearchParam<Procedure, CodeableConcept> =
    SimpleSearchParam<Procedure, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.category",
      extractor = { resource -> listOfNotNull(resource.category) },
    )

  public val Code: SearchParam<Procedure, CodeableConcept> =
    SimpleSearchParam<Procedure, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Date: SearchParam<Procedure, Procedure.Performed> =
    SimpleSearchParam<Procedure, Procedure.Performed>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Procedure.performed",
      extractor = { resource -> listOfNotNull(resource.performed) },
    )

  public val Encounter: SearchParam<Procedure, Reference> =
    SimpleSearchParam<Procedure, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.encounter",
      target = listOf(dev.ohs.fhir.model.r4b.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Identifier: SearchParam<Procedure, Identifier> =
    SimpleSearchParam<Procedure, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val InstantiatesCanonical: SearchParam<Procedure, Canonical> =
    SimpleSearchParam<Procedure, Canonical>(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
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

  public val InstantiatesUri: SearchParam<Procedure, Uri> =
    SimpleSearchParam<Procedure, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "Procedure.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val Location: SearchParam<Procedure, Reference> =
    SimpleSearchParam<Procedure, Reference>(
      name = "location",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.location",
      target = listOf(dev.ohs.fhir.model.r4b.Location::class),
      extractor = { resource -> listOfNotNull(resource.location) },
    )

  public val PartOf: SearchParam<Procedure, Reference> =
    SimpleSearchParam<Procedure, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.partOf",
      target = listOf(Observation::class, Procedure::class, MedicationAdministration::class),
      extractor = { resource -> resource.partOf },
    )

  public val Patient: SearchParam<Procedure, Reference> =
    SimpleSearchParam<Procedure, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<Procedure, Reference> =
    SimpleSearchParam<Procedure, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.performer.actor",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val ReasonCode: SearchParam<Procedure, CodeableConcept> =
    SimpleSearchParam<Procedure, CodeableConcept>(
      name = "reason-code",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.reasonCode",
      extractor = { resource -> resource.reasonCode },
    )

  public val ReasonReference: SearchParam<Procedure, Reference> =
    SimpleSearchParam<Procedure, Reference>(
      name = "reason-reference",
      type = SearchParamType.fromCode("reference"),
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

  public val Status: SearchParam<Procedure, Any> =
    SimpleSearchParam<Procedure, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Procedure.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<Procedure, Reference> =
    SimpleSearchParam<Procedure, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Procedure.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the Procedure resource type. */
  public val ALL: List<SearchParam<Procedure, *>> =
    listOf(
      BasedOn,
      Category,
      Code,
      Date,
      Encounter,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Location,
      PartOf,
      Patient,
      Performer,
      ReasonCode,
      ReasonReference,
      Status,
      Subject,
    )
}
