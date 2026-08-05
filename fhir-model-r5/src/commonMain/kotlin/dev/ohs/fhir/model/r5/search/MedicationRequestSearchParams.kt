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

import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationRequest] resource type. */
public object MedicationRequestSearchParams {
  public val authoredon: SearchParam<MedicationRequest, DateTime> =
    SearchParam(
      name = "authoredon",
      type = SearchParamType.Date,
      expression = "MedicationRequest.authoredOn",
      extractor = { resource -> listOfNotNull(resource.authoredOn) },
    )

  public val category: SearchParam<MedicationRequest, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "MedicationRequest.category",
      extractor = { resource -> resource.category },
    )

  public val code: SearchParam<MedicationRequest, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "MedicationRequest.medication.concept",
      extractor = { resource -> listOfNotNull(resource.medication.concept) },
    )

  public val comboDate: SearchParam<MedicationRequest, DateTime> =
    SearchParam(
      name = "combo-date",
      type = SearchParamType.Date,
      expression = "MedicationRequest.dosageInstruction.timing.event",
      extractor = { resource ->
        resource.dosageInstruction.mapNotNull { it.timing }.flatMap { it.event }
      },
    )

  public val encounter: SearchParam<MedicationRequest, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "MedicationRequest.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val groupIdentifier: SearchParam<MedicationRequest, Identifier> =
    SearchParam(
      name = "group-identifier",
      type = SearchParamType.Token,
      expression = "MedicationRequest.groupIdentifier",
      extractor = { resource -> listOfNotNull(resource.groupIdentifier) },
    )

  public val identifier: SearchParam<MedicationRequest, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "MedicationRequest.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val intendedDispenser: SearchParam<MedicationRequest, Reference> =
    SearchParam(
      name = "intended-dispenser",
      type = SearchParamType.Reference,
      expression = "MedicationRequest.dispenseRequest.dispenser",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.dispenseRequest?.dispenser) },
    )

  public val intendedPerformer: SearchParam<MedicationRequest, Reference> =
    SearchParam(
      name = "intended-performer",
      type = SearchParamType.Reference,
      expression = "MedicationRequest.performer",
      target =
        listOf(
          HealthcareService::class,
          Organization::class,
          CareTeam::class,
          RelatedPerson::class,
          PractitionerRole::class,
          DeviceDefinition::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> resource.performer },
    )

  public val intendedPerformertype: SearchParam<MedicationRequest, CodeableConcept> =
    SearchParam(
      name = "intended-performertype",
      type = SearchParamType.Token,
      expression = "MedicationRequest.performerType",
      extractor = { resource -> listOfNotNull(resource.performerType) },
    )

  public val intent: SearchParam<MedicationRequest, Any> =
    SearchParam(
      name = "intent",
      type = SearchParamType.Token,
      expression = "MedicationRequest.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val medication: SearchParam<MedicationRequest, Reference> =
    SearchParam(
      name = "medication",
      type = SearchParamType.Reference,
      expression = "MedicationRequest.medication.reference",
      target = listOf(Medication::class),
      extractor = { resource -> listOfNotNull(resource.medication.reference) },
    )

  public val patient: SearchParam<MedicationRequest, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "MedicationRequest.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter { it.reference?.value?.contains("Patient/") == true }
      },
    )

  public val priority: SearchParam<MedicationRequest, Any> =
    SearchParam(
      name = "priority",
      type = SearchParamType.Token,
      expression = "MedicationRequest.priority",
      extractor = { resource -> listOfNotNull(resource.priority) },
    )

  public val requester: SearchParam<MedicationRequest, Reference> =
    SearchParam(
      name = "requester",
      type = SearchParamType.Reference,
      expression = "MedicationRequest.requester",
      target =
        listOf(
          Organization::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.requester) },
    )

  public val status: SearchParam<MedicationRequest, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "MedicationRequest.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<MedicationRequest, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "MedicationRequest.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<MedicationRequest, *>> = listOf()

  /**
   * Supported search parameters for the MedicationRequest resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<MedicationRequest, *>> =
    listOf(
      authoredon,
      category,
      code,
      comboDate,
      encounter,
      groupIdentifier,
      identifier,
      intendedDispenser,
      intendedPerformer,
      intendedPerformertype,
      intent,
      medication,
      patient,
      priority,
      requester,
      status,
      subject,
    )
}
