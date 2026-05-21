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
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.CommunicationRequest
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.DeviceRequest
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Measure
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.NutritionOrder
import dev.ohs.fhir.model.r4.OperationDefinition
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Questionnaire
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.RequestGroup
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ServiceRequest
import dev.ohs.fhir.model.r4.Task
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.VisionPrescription
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [CarePlan] resource type. */
public object CarePlanSearchParam {
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

  public data object ActivityCode : SearchParam<CarePlan, CodeableConcept> {
    public override val name: String = "activity-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.activity.detail.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<CodeableConcept> =
      resource.activity.mapNotNull { it.detail }.mapNotNull { it.code }
  }

  public data object ActivityDate : SearchParam<CarePlan, CarePlan.Activity.Detail.Scheduled> {
    public override val name: String = "activity-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CarePlan.activity.detail.scheduled"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<CarePlan.Activity.Detail.Scheduled> =
      resource.activity.mapNotNull { it.detail }.mapNotNull { it.scheduled }
  }

  public data object ActivityReference : SearchParam<CarePlan, Reference> {
    public override val name: String = "activity-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.activity.reference"

    public override val target: List<KClass<out Resource>> =
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
      )

    public override fun extract(resource: CarePlan): List<Reference> =
      resource.activity.mapNotNull { it.reference }
  }

  public data object BasedOn : SearchParam<CarePlan, Reference> {
    public override val name: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.basedOn"

    public override val target: List<KClass<out Resource>> = listOf(CarePlan::class)

    public override fun extract(resource: CarePlan): List<Reference> = resource.basedOn
  }

  public data object CareTeam : SearchParam<CarePlan, Reference> {
    public override val name: String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.careTeam"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.CareTeam::class)

    public override fun extract(resource: CarePlan): List<Reference> = resource.careTeam
  }

  public data object Category : SearchParam<CarePlan, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<CodeableConcept> = resource.category
  }

  public data object Condition : SearchParam<CarePlan, Reference> {
    public override val name: String = "condition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.addresses"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Condition::class)

    public override fun extract(resource: CarePlan): List<Reference> = resource.addresses
  }

  public data object Date : SearchParam<CarePlan, Period> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CarePlan.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<Period> = listOfNotNull(resource.period)
  }

  public data object Encounter : SearchParam<CarePlan, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Encounter::class)

    public override fun extract(resource: CarePlan): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Goal : SearchParam<CarePlan, Reference> {
    public override val name: String = "goal"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.goal"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Goal::class)

    public override fun extract(resource: CarePlan): List<Reference> = resource.goal
  }

  public data object Identifier : SearchParam<CarePlan, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<CarePlan, Canonical> {
    public override val name: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.instantiatesCanonical"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Questionnaire::class,
        Measure::class,
        PlanDefinition::class,
        OperationDefinition::class,
        ActivityDefinition::class,
      )

    public override fun extract(resource: CarePlan): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : SearchParam<CarePlan, Uri> {
    public override val name: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "CarePlan.instantiatesUri"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<Uri> = resource.instantiatesUri
  }

  public data object Intent : SearchParam<CarePlan, Any> {
    public override val name: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.intent"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = listOf(resource.intent)
  }

  public data object PartOf : SearchParam<CarePlan, Reference> {
    public override val name: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.partOf"

    public override val target: List<KClass<out Resource>> = listOf(CarePlan::class)

    public override fun extract(resource: CarePlan): List<Reference> = resource.partOf
  }

  public data object Patient : SearchParam<CarePlan, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: CarePlan): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<CarePlan, Reference> {
    public override val name: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.activity.detail.performer"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        dev.ohs.fhir.model.r4.CareTeam::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        HealthcareService::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: CarePlan): List<Reference> =
      resource.activity.mapNotNull { it.detail }.flatMap { it.performer }
  }

  public data object Replaces : SearchParam<CarePlan, Reference> {
    public override val name: String = "replaces"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.replaces"

    public override val target: List<KClass<out Resource>> = listOf(CarePlan::class)

    public override fun extract(resource: CarePlan): List<Reference> = resource.replaces
  }

  public data object Status : SearchParam<CarePlan, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<CarePlan, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: CarePlan): List<Reference> = listOf(resource.subject)
  }
}
