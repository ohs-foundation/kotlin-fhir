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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ChargeItem] resource type. */
public sealed class ChargeItemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ChargeItem): List<T>

  public data object Account : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.account"

    public override val target: List<String> = listOf("Account")

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Code : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Encounter : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object EnteredDate : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "entered-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ChargeItem.enteredDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Enterer : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.enterer"

    public override val target: List<String> =
      listOf(
        "Organization",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object FactorOverride : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "factor-override"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "ChargeItem.totalPriceComponent.factor"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Identifier : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Occurrence : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "occurrence"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ChargeItem.occurrence.ofType(dateTime)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Patient : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object PerformerActor : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "performer-actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.performer.actor"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Organization",
        "CareTeam",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object PerformerFunction : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "performer-function"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.performer.function"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object PerformingOrganization : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "performing-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.performingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object PriceOverride : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "price-override"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "ChargeItem.totalPriceComponent.amount"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Quantity : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "ChargeItem.quantity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object RequestingOrganization : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "requesting-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.requestingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Service : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "service"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.service.reference"

    public override val target: List<String> =
      listOf(
        "SupplyDelivery",
        "ImagingStudy",
        "Procedure",
        "Observation",
        "ServiceRequest",
        "MedicationAdministration",
        "DiagnosticReport",
        "Immunization",
        "MedicationRequest",
        "MedicationDispense",
      )

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Status : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Subject : ChargeItemSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the ChargeItem resource type. */
    public val ALL: List<ChargeItemSearchParam<*>> =
      listOf(
        Account,
        Code,
        Encounter,
        EnteredDate,
        Enterer,
        FactorOverride,
        Identifier,
        Occurrence,
        Patient,
        PerformerActor,
        PerformerFunction,
        PerformingOrganization,
        PriceOverride,
        Quantity,
        RequestingOrganization,
        Service,
        Status,
        Subject,
      )
  }
}
