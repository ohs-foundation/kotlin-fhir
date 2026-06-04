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
import dev.ohs.fhir.model.r4b.Appointment
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CommunicationRequest
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DeviceRequest
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.HealthcareService
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Measure
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.NutritionOrder
import dev.ohs.fhir.model.r4b.OperationDefinition
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PlanDefinition
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Questionnaire
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.RequestGroup
import dev.ohs.fhir.model.r4b.ServiceRequest
import dev.ohs.fhir.model.r4b.Task
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.VisionPrescription
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CarePlan] resource type. */
public object CarePlanSearchParams {
  public val ActivityCode: SearchParam<CarePlan, CodeableConcept> =
    SimpleSearchParam<CarePlan, CodeableConcept>(
      name = "activity-code",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.activity.detail.code",
      extractor = { resource -> resource.activity.mapNotNull { it.detail }.mapNotNull { it.code } },
    )

  public val ActivityDate: SearchParam<CarePlan, CarePlan.Activity.Detail.Scheduled> =
    SimpleSearchParam<CarePlan, CarePlan.Activity.Detail.Scheduled>(
      name = "activity-date",
      type = SearchParamType.fromCode("date"),
      expression = "CarePlan.activity.detail.scheduled",
      extractor = { resource ->
        resource.activity.mapNotNull { it.detail }.mapNotNull { it.scheduled }
      },
    )

  public val ActivityReference: SearchParam<CarePlan, Reference> =
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

  public val BasedOn: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.basedOn",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.basedOn },
    )

  public val CareTeam: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "care-team",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.careTeam",
      target = listOf(dev.ohs.fhir.model.r4b.CareTeam::class),
      extractor = { resource -> resource.careTeam },
    )

  public val Category: SearchParam<CarePlan, CodeableConcept> =
    SimpleSearchParam<CarePlan, CodeableConcept>(
      name = "category",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.category",
      extractor = { resource -> resource.category },
    )

  public val Condition: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "condition",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.addresses",
      target = listOf(dev.ohs.fhir.model.r4b.Condition::class),
      extractor = { resource -> resource.addresses },
    )

  public val Date: SearchParam<CarePlan, Period> =
    SimpleSearchParam<CarePlan, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "CarePlan.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val Encounter: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.encounter",
      target = listOf(dev.ohs.fhir.model.r4b.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Goal: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "goal",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.goal",
      target = listOf(dev.ohs.fhir.model.r4b.Goal::class),
      extractor = { resource -> resource.goal },
    )

  public val Identifier: SearchParam<CarePlan, Identifier> =
    SimpleSearchParam<CarePlan, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val InstantiatesCanonical: SearchParam<CarePlan, Canonical> =
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

  public val InstantiatesUri: SearchParam<CarePlan, Uri> =
    SimpleSearchParam<CarePlan, Uri>(
      name = "instantiates-uri",
      type = SearchParamType.fromCode("uri"),
      expression = "CarePlan.instantiatesUri",
      extractor = { resource -> resource.instantiatesUri },
    )

  public val Intent: SearchParam<CarePlan, Any> =
    SimpleSearchParam<CarePlan, Any>(
      name = "intent",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.intent",
      extractor = { resource -> listOf(resource.intent) },
    )

  public val PartOf: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.partOf",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.partOf },
    )

  public val Patient: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Performer: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.activity.detail.performer",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          dev.ohs.fhir.model.r4b.CareTeam::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          HealthcareService::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource ->
        resource.activity.mapNotNull { it.detail }.flatMap { it.performer }
      },
    )

  public val Replaces: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "replaces",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.replaces",
      target = listOf(CarePlan::class),
      extractor = { resource -> resource.replaces },
    )

  public val Status: SearchParam<CarePlan, Any> =
    SimpleSearchParam<CarePlan, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "CarePlan.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the CarePlan resource type. */
  public val ALL: List<SearchParam<CarePlan, *>> =
    listOf(
      ActivityCode,
      ActivityDate,
      ActivityReference,
      BasedOn,
      CareTeam,
      Category,
      Condition,
      Date,
      Encounter,
      Goal,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Intent,
      PartOf,
      Patient,
      Performer,
      Replaces,
      Status,
      Subject,
    )
}
