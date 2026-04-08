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

/** Search parameters for the [Procedure] resource type. */
public sealed class ProcedureSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Procedure): List<T>

  public data object BasedOn : ProcedureSearchParam<Any>() {
    public override val paramName: String = "based-on"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.basedOn"

    public override val target: List<String> = listOf("CarePlan", "ServiceRequest")

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Category : ProcedureSearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Code : ProcedureSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Date : ProcedureSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Procedure.performed"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Encounter : ProcedureSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.encounter"

    public override val target: List<String> = listOf("Encounter", "EpisodeOfCare")

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Identifier : ProcedureSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object InstantiatesCanonical : ProcedureSearchParam<Any>() {
    public override val paramName: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.instantiatesCanonical"

    public override val target: List<String> =
      listOf(
        "Questionnaire",
        "Measure",
        "PlanDefinition",
        "OperationDefinition",
        "ActivityDefinition",
      )

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object InstantiatesUri : ProcedureSearchParam<Any>() {
    public override val paramName: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "Procedure.instantiatesUri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Location : ProcedureSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object PartOf : ProcedureSearchParam<Any>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.partOf"

    public override val target: List<String> =
      listOf("Observation", "Procedure", "MedicationAdministration")

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Patient : ProcedureSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Performer : ProcedureSearchParam<Any>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.performer.actor"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object ReasonCode : ProcedureSearchParam<Any>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.reasonCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object ReasonReference : ProcedureSearchParam<Any>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.reasonReference"

    public override val target: List<String> =
      listOf("Condition", "Observation", "Procedure", "DiagnosticReport", "DocumentReference")

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Status : ProcedureSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Procedure.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public data object Subject : ProcedureSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Procedure.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: Procedure): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Procedure resource type. */
    public val ALL: List<ProcedureSearchParam<*>> =
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
}
