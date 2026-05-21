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
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.SupplyRequest
import dev.ohs.fhir.model.r5.Task
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VisionPrescription
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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

  public data object ActivityReference : SearchParam<CarePlan, Reference> {
    public override val name: String = "activity-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.activity.plannedActivityReference"

    public override val target: List<KClass<out Resource>> =
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
      )

    public override fun extract(resource: CarePlan): List<Reference> =
      resource.activity.mapNotNull { it.plannedActivityReference }
  }

  public data object BasedOn : SearchParam<CarePlan, Reference> {
    public override val name: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.basedOn"

    public override val target: List<KClass<out Resource>> =
      listOf(
        RequestOrchestration::class,
        ServiceRequest::class,
        CarePlan::class,
        NutritionOrder::class,
      )

    public override fun extract(resource: CarePlan): List<Reference> = resource.basedOn
  }

  public data object CareTeam : SearchParam<CarePlan, Reference> {
    public override val name: String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.careTeam"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.CareTeam::class)

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

    public override val expression: String = "CarePlan.addresses.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Condition::class)

    public override fun extract(resource: CarePlan): List<Reference> =
      resource.addresses.mapNotNull { it.reference }
  }

  public data object Custodian : SearchParam<CarePlan, Reference> {
    public override val name: String = "custodian"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.custodian"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Device::class,
        Organization::class,
        dev.ohs.fhir.model.r5.CareTeam::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: CarePlan): List<Reference> =
      listOfNotNull(resource.custodian)
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
      listOf(dev.ohs.fhir.model.r5.Encounter::class)

    public override fun extract(resource: CarePlan): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Goal : SearchParam<CarePlan, Reference> {
    public override val name: String = "goal"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.goal"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Goal::class)

    public override fun extract(resource: CarePlan): List<Reference> = resource.goal
  }

  public data object Identifier : SearchParam<CarePlan, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: CarePlan): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<CarePlan, Canonical> {
    public override val name: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.instantiatesCanonical"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Measure::class,
        OperationDefinition::class,
        ActivityDefinition::class,
        PlanDefinition::class,
        Questionnaire::class,
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
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: CarePlan): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
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
      listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: CarePlan): List<Reference> = listOf(resource.subject)
  }
}
