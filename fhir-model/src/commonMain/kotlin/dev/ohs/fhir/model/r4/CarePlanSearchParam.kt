/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [CarePlan] resource type. */
public sealed class CarePlanSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: CarePlan): List<T>

  public data object ActivityCode : CarePlanSearchParam<Any>() {
    public override val paramName: String = "activity-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.activity.detail.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object ActivityDate : CarePlanSearchParam<Any>() {
    public override val paramName: String = "activity-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CarePlan.activity.detail.scheduled"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object ActivityReference : CarePlanSearchParam<Any>() {
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

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object BasedOn : CarePlanSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.basedOn"

    public override val target: List<String> = listOf("CarePlan")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object CareTeam : CarePlanSearchParam<Any>() {
    public override val paramName: String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.careTeam"

    public override val target: List<String> = listOf("CareTeam")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Category : CarePlanSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Condition : CarePlanSearchParam<Any>() {
    public override val paramName: String = "condition"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.addresses"

    public override val target: List<String> = listOf("Condition")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Date : CarePlanSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "CarePlan.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Encounter : CarePlanSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Goal : CarePlanSearchParam<Any>() {
    public override val paramName: String = "goal"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.goal"

    public override val target: List<String> = listOf("Goal")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Identifier : CarePlanSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object InstantiatesCanonical : CarePlanSearchParam<Any>() {
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

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object InstantiatesUri : CarePlanSearchParam<Any>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "CarePlan.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Intent : CarePlanSearchParam<Any>() {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object PartOf : CarePlanSearchParam<Any>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.partOf"

    public override val target: List<String> = listOf("CarePlan")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Patient : CarePlanSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Performer : CarePlanSearchParam<Any>() {
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

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Replaces : CarePlanSearchParam<Any>() {
    public override val paramName: String = "replaces"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.replaces"

    public override val target: List<String> = listOf("CarePlan")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Status : CarePlanSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "CarePlan.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
  }

  public data object Subject : CarePlanSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "CarePlan.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: CarePlan): List<Any> = emptyList()
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
