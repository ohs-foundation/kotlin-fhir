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
    SimpleSearchParam<CarePlan, CodeableConcept>(
      name = "activity-code",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.activity.detail.code",
      extractor = { resource -> resource.activity.mapNotNull { it.detail }.mapNotNull { it.code } },
    )

  public val activityDate: SearchParam<CarePlan, CarePlan.Activity.Detail.Scheduled> =
    SimpleSearchParam<CarePlan, CarePlan.Activity.Detail.Scheduled>(
      name = "activity-date",
      type = SearchParamType.fromCode("date"),
      expression = "CarePlan.activity.detail.scheduled",
      extractor = { resource ->
        resource.activity.mapNotNull { it.detail }.mapNotNull { it.scheduled }
      },
    )

  public val activityReference: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "activity-reference",
      type = SearchParamType.fromCode("reference"),
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
    SimpleSearchParam<CarePlan, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.basedOn",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.basedOn },
    )

  public val careTeam: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "care-team",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.careTeam",
      target = listOf(CareTeam::class),
      extractor = { resource -> resource.careTeam },
    )

  public val category: SearchParam<CarePlan, CodeableConcept> =
    SimpleSearchParam<CarePlan, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.category",
      extractor = { resource -> resource.category },
    )

  public val condition: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "condition",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.addresses",
      target = listOf(Condition::class),
      extractor = { resource -> resource.addresses },
    )

  public val date: SearchParam<CarePlan, Period> =
    SimpleSearchParam<CarePlan, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CarePlan.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val encounter: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val goal: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "goal",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.goal",
      target = listOf(Goal::class),
      extractor = { resource -> resource.goal },
    )

  public val identifier: SearchParam<CarePlan, Identifier> =
    SimpleSearchParam<CarePlan, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val instantiatesCanonical: SearchParam<CarePlan, Canonical> =
    SimpleSearchParam<CarePlan, Canonical>(
      name = "instantiates-canonical",
      type = SearchParamType.fromCode("reference"),
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
    SimpleSearchParam<CarePlan, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "CarePlan.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val intent: SearchParam<CarePlan, Any> =
    SimpleSearchParam<CarePlan, Any>(
      name = "intent",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val partOf: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.partOf",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.partOf },
    )

  public val patient: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.subject.where(resolve() is Patient)",
      target = listOf(Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
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
    SimpleSearchParam<CarePlan, Reference>(
      name = "replaces",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.replaces",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.replaces },
    )

  public val status: SearchParam<CarePlan, Any> =
    SimpleSearchParam<CarePlan, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the CarePlan resource type. */
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
