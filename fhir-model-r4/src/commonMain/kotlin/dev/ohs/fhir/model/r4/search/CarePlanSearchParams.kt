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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.ActivityDefinition
import dev.ohs.fhir.model.r4.Appointment
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CarePlan
import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.CommunicationRequest
import dev.ohs.fhir.model.r4.Condition
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.DeviceRequest
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.Goal
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Measure
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.NutritionOrder
import dev.ohs.fhir.model.r4.OperationDefinition
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Questionnaire
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.RequestGroup
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.Task
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CarePlan] resource type. */
public object CarePlanSearchParams {
  public val activityCode: SearchParam<CarePlan, CodeableConcept> =
    SearchParam(
      name = "activity-code",
      type = SearchParamType.Token,
      expression = "CarePlan.activity.detail.code",
      extractor = { resource -> resource.activity.mapNotNull { it.detail }.mapNotNull { it.code } },
    )

  public val activityDate: SearchParam<CarePlan, CarePlan.Activity.Detail.Scheduled> =
    SearchParam(
      name = "activity-date",
      type = SearchParamType.Date,
      expression = "CarePlan.activity.detail.scheduled",
      extractor = { resource ->
        resource.activity.mapNotNull { it.detail }.mapNotNull { it.scheduled }
      },
    )

  public val activityReference: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "activity-reference",
      type = SearchParamType.Reference,
      expression = "CarePlan.activity.reference",
      target =
        listOf(
          Appointment::class,
          MedicationRequest::class,
          Task::class,
          NutritionOrder::class,
          RequestGroup::class,
          VisionPrescription::class,
          DeviceRequest::class,
          ServiceRequest::class,
          CommunicationRequest::class,
        ),
      extractor = { resource -> resource.activity.mapNotNull { it.reference } },
    )

  public val basedOn: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "based-on",
      type = SearchParamType.Reference,
      expression = "CarePlan.basedOn",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.basedOn },
    )

  public val careTeam: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "care-team",
      type = SearchParamType.Reference,
      expression = "CarePlan.careTeam",
      target = listOf(CareTeam::class),
      extractor = { resource -> resource.careTeam },
    )

  public val category: SearchParam<CarePlan, CodeableConcept> =
    SearchParam(
      name = "category",
      type = SearchParamType.Token,
      expression = "CarePlan.category",
      extractor = { resource -> resource.category },
    )

  public val condition: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "condition",
      type = SearchParamType.Reference,
      expression = "CarePlan.addresses",
      target = listOf(Condition::class),
      extractor = { resource -> resource.addresses },
    )

  public val date: SearchParam<CarePlan, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "CarePlan.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val encounter: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "CarePlan.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val goal: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "goal",
      type = SearchParamType.Reference,
      expression = "CarePlan.goal",
      target = listOf(Goal::class),
      extractor = { resource -> resource.goal },
    )

  public val identifier: SearchParam<CarePlan, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "CarePlan.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<CarePlan, Canonical> =
    SearchParam(
      name = "instantiates-canonical",
      type = SearchParamType.Reference,
      expression = "CarePlan.instantiatesCanonical",
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

  public val instantiatesUri: SearchParam<CarePlan, Uri> =
    SearchParam(
      name = "instantiates-uri",
      type = SearchParamType.Uri,
      expression = "CarePlan.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val intent: SearchParam<CarePlan, Any> =
    SearchParam(
      name = "intent",
      type = SearchParamType.Token,
      expression = "CarePlan.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val partOf: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "part-of",
      type = SearchParamType.Reference,
      expression = "CarePlan.partOf",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.partOf },
    )

  public val patient: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "CarePlan.subject.where(resolve() is Patient)",
      target = listOf(Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.Reference,
      expression = "CarePlan.activity.detail.performer",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource ->
        resource.activity.mapNotNull { it.detail }.flatMap { it.performer }
      },
    )

  public val replaces: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "replaces",
      type = SearchParamType.Reference,
      expression = "CarePlan.replaces",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.replaces },
    )

  public val status: SearchParam<CarePlan, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "CarePlan.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<CarePlan, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "CarePlan.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<CarePlan, *>> = listOf()

  /**
   * Supported search parameters for the CarePlan resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<CarePlan, *>> =
    listOf(
      activityCode,
      activityDate,
      activityReference,
      basedOn,
      careTeam,
      category,
      condition,
      date,
      encounter,
      goal,
      identifier,
      instantiatesCanonical,
      instantiatesUri,
      intent,
      partOf,
      patient,
      performer,
      replaces,
      status,
      subject,
    )
}
