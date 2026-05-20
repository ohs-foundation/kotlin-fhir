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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CarePlan
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CarePlan] resource type. */
public sealed class CarePlanSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CarePlan): List<T>

  public data object ActivityCode : CarePlanSearchParam<CodeableConcept>() {
    public override val paramName: String = "activity-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.activity.detail.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<CodeableConcept> =
      resource.activity.mapNotNull { it.detail }.mapNotNull { it.code }
  }

  public data object ActivityDate : CarePlanSearchParam<CarePlan.Activity.Detail.Scheduled>() {
    public override val paramName: String = "activity-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CarePlan.activity.detail.scheduled"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<CarePlan.Activity.Detail.Scheduled> =
      resource.activity.mapNotNull { it.detail }.mapNotNull { it.scheduled }
  }

  public data object ActivityReference : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "activity-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.activity.reference"

    public override val target: List<String> =
      listOf(
        "Appointment",
        "MedicationRequest",
        "Task",
        "NutritionOrder",
        "RequestGroup",
        "VisionPrescription",
        "DeviceRequest",
        "ServiceRequest",
        "CommunicationRequest",
      )

    public override fun extract(resource: CarePlan): List<Reference> =
      resource.activity.mapNotNull { it.reference }
  }

  public data object BasedOn : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.basedOn"

    public override val target: List<String> = listOf("CarePlan")

    public override fun extract(resource: CarePlan): List<Reference> = resource.basedOn
  }

  public data object CareTeam : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.careTeam"

    public override val target: List<String> = listOf("CareTeam")

    public override fun extract(resource: CarePlan): List<Reference> = resource.careTeam
  }

  public data object Category : CarePlanSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<CodeableConcept> = resource.category
  }

  public data object Condition : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "condition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.addresses"

    public override val target: List<String> = listOf("Condition")

    public override fun extract(resource: CarePlan): List<Reference> = resource.addresses
  }

  public data object Date : CarePlanSearchParam<Period>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CarePlan.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Period> = listOfNotNull(resource.period)
  }

  public data object Encounter : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: CarePlan): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Goal : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "goal"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.goal"

    public override val target: List<String> = listOf("Goal")

    public override fun extract(resource: CarePlan): List<Reference> = resource.goal
  }

  public data object Identifier : CarePlanSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : CarePlanSearchParam<Canonical>() {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.instantiatesCanonical"

    public override val target: List<String> =
      listOf(
        "Questionnaire",
        "Measure",
        "PlanDefinition",
        "OperationDefinition",
        "ActivityDefinition",
      )

    public override fun extract(resource: CarePlan): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : CarePlanSearchParam<Uri>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "CarePlan.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Uri> = resource.instantiatesUri
  }

  public data object Intent : CarePlanSearchParam<Any>() {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = listOf(resource.intent)
  }

  public data object PartOf : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.partOf"

    public override val target: List<String> = listOf("CarePlan")

    public override fun extract(resource: CarePlan): List<Reference> = resource.partOf
  }

  public data object Patient : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: CarePlan): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.activity.detail.performer"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Device",
        "Patient",
        "HealthcareService",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: CarePlan): List<Reference> =
      resource.activity.mapNotNull { it.detail }.flatMap { it.performer }
  }

  public data object Replaces : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "replaces"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.replaces"

    public override val target: List<String> = listOf("CarePlan")

    public override fun extract(resource: CarePlan): List<Reference> = resource.replaces
  }

  public data object Status : CarePlanSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = listOf(resource.status)
  }

  public data object Subject : CarePlanSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: CarePlan): List<Reference> = listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the CarePlan resource type. */
    public val ALL: List<CarePlanSearchParam<*>> =
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
}
