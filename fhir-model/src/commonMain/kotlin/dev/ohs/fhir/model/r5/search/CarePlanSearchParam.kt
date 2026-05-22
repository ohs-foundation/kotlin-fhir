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
import dev.ohs.fhir.model.r5.Appointment
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CommunicationRequest
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceRequest
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImmunizationRecommendation
import dev.ohs.fhir.model.r5.Measure
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.NutritionOrder
import dev.ohs.fhir.model.r5.OperationDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Questionnaire
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.RequestOrchestration
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.SupplyRequest
import dev.ohs.fhir.model.r5.Task
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VisionPrescription
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CarePlan] resource type. */
public object CarePlanSearchParam {
  public val ActivityReference: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "activity-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.activity.plannedActivityReference",
      target =
        listOf(
          Appointment::class,
          RequestOrchestration::class,
          DeviceRequest::class,
          ServiceRequest::class,
          CommunicationRequest::class,
          Task::class,
          MedicationRequest::class,
          SupplyRequest::class,
          ImmunizationRecommendation::class,
          NutritionOrder::class,
          VisionPrescription::class,
        ),
      extractor = { resource -> resource.activity.mapNotNull { it.plannedActivityReference } },
    )

  public val BasedOn: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "based-on",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.basedOn",
      target =
        listOf(
          RequestOrchestration::class,
          ServiceRequest::class,
          CarePlan::class,
          NutritionOrder::class,
        ),
      extractor = { resource -> resource.basedOn },
    )

  public val CareTeam: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "care-team",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.careTeam",
      target = listOf(dev.ohs.fhir.model.r5.CareTeam::class),
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
      expression = "CarePlan.addresses.reference",
      target = listOf(dev.ohs.fhir.model.r5.Condition::class),
      extractor = { resource -> resource.addresses.mapNotNull { it.reference } },
    )

  public val Custodian: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "custodian",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.custodian",
      target =
        listOf(
          Device::class,
          Organization::class,
          dev.ohs.fhir.model.r5.CareTeam::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.custodian) },
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
      target = listOf(dev.ohs.fhir.model.r5.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val Goal: SearchParam<CarePlan, Reference> =
    SimpleSearchParam<CarePlan, Reference>(
      name = "goal",
      type = SearchParamType.fromCode("reference"),
      expression = "CarePlan.goal",
      target = listOf(dev.ohs.fhir.model.r5.Goal::class),
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
          Measure::class,
          OperationDefinition::class,
          ActivityDefinition::class,
          PlanDefinition::class,
          Questionnaire::class,
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
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
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
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the CarePlan resource type. */
  public val ALL: List<SearchParam<CarePlan, *>> =
    listOf(
      ActivityReference,
      BasedOn,
      CareTeam,
      Category,
      Condition,
      Custodian,
      Date,
      Encounter,
      Goal,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Intent,
      PartOf,
      Patient,
      Replaces,
      Status,
      Subject,
    )
}
