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

/** Search parameters for the [Immunization] resource type. */
public sealed class ImmunizationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Immunization): List<T>

  public data object Date : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Immunization.occurrence"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Identifier : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Immunization.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Location : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Immunization.location"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object LotNumber : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "lot-number"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Immunization.lotNumber"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Manufacturer : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "manufacturer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Immunization.manufacturer"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Patient : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Immunization.patient"

    public override val target: List<String> = listOf("Patient", "Group")

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Performer : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Immunization.performer.actor"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Reaction : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "reaction"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Immunization.reaction.detail"

    public override val target: List<String> = listOf("Observation")

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object ReactionDate : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "reaction-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Immunization.reaction.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object ReasonCode : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "reason-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Immunization.reasonCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object ReasonReference : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "reason-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Immunization.reasonReference"

    public override val target: List<String> =
      listOf("Condition", "Observation", "DiagnosticReport")

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Series : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "series"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "Immunization.protocolApplied.series"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object Status : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Immunization.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object StatusReason : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "status-reason"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Immunization.statusReason"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object TargetDisease : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "target-disease"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Immunization.protocolApplied.targetDisease"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public data object VaccineCode : ImmunizationSearchParam<Any>() {
    public override val paramName: String = "vaccine-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Immunization.vaccineCode"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Immunization): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Immunization resource type. */
    public val ALL: List<ImmunizationSearchParam<*>> =
      listOf(
        Date,
        Identifier,
        Location,
        LotNumber,
        Manufacturer,
        Patient,
        Performer,
        Reaction,
        ReactionDate,
        ReasonCode,
        ReasonReference,
        Series,
        Status,
        StatusReason,
        TargetDisease,
        VaccineCode,
      )
  }
}
