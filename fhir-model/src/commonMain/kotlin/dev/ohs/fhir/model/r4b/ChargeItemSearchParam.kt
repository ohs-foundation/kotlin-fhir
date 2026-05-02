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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ChargeItem] resource type. */
public sealed class ChargeItemSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ChargeItem): List<T>

  public data object Account : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.account"

    public override val target: List<String> = listOf("Account")

    public override fun extract(resource: ChargeItem): List<Reference> = resource.account
  }

  public data object Code : ChargeItemSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<CodeableConcept> = listOf(resource.code)
  }

  public data object Context : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.context"

    public override val target: List<String> = listOf("EpisodeOfCare", "Encounter")

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOfNotNull(resource.context)
  }

  public data object EnteredDate : ChargeItemSearchParam<DateTime>() {
    public override val paramName: String = "entered-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ChargeItem.enteredDate"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<DateTime> =
      listOfNotNull(resource.enteredDate)
  }

  public data object Enterer : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.enterer"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOfNotNull(resource.enterer)
  }

  public data object FactorOverride : ChargeItemSearchParam<Decimal>() {
    public override val paramName: String = "factor-override"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "ChargeItem.factorOverride"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Decimal> =
      listOfNotNull(resource.factorOverride)
  }

  public data object Identifier : ChargeItemSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Occurrence : ChargeItemSearchParam<ChargeItem.Occurrence>() {
    public override val paramName: String = "occurrence"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ChargeItem.occurrence"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<ChargeItem.Occurrence> =
      listOfNotNull(resource.occurrence)
  }

  public data object Patient : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object PerformerActor : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "performer-actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.performer.actor"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: ChargeItem): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object PerformerFunction : ChargeItemSearchParam<CodeableConcept>() {
    public override val paramName: String = "performer-function"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.performer.function"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<CodeableConcept> =
      resource.performer.mapNotNull { it.function }
  }

  public data object PerformingOrganization : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "performing-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.performingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOfNotNull(resource.performingOrganization)
  }

  public data object PriceOverride : ChargeItemSearchParam<Money>() {
    public override val paramName: String = "price-override"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "ChargeItem.priceOverride"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<Money> =
      listOfNotNull(resource.priceOverride)
  }

  public data object Quantity : ChargeItemSearchParam<dev.ohs.fhir.model.r4b.Quantity>() {
    public override val paramName: String = "quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "ChargeItem.quantity"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ChargeItem): List<dev.ohs.fhir.model.r4b.Quantity> =
      listOfNotNull(resource.quantity)
  }

  public data object RequestingOrganization : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "requesting-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.requestingOrganization"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOfNotNull(resource.requestingOrganization)
  }

  public data object Service : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "service"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.service"

    public override val target: List<String> =
      listOf(
        "Immunization",
        "MedicationDispense",
        "SupplyDelivery",
        "Observation",
        "DiagnosticReport",
        "ImagingStudy",
        "MedicationAdministration",
        "Procedure",
      )

    public override fun extract(resource: ChargeItem): List<Reference> = resource.service
  }

  public data object Subject : ChargeItemSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: ChargeItem): List<Reference> = listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the ChargeItem resource type. */
    public val ALL: List<ChargeItemSearchParam<*>> =
      listOf(
        Account,
        Code,
        Context,
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
        Subject,
      )
  }
}
