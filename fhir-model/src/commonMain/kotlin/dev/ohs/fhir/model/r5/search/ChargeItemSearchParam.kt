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

import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.ChargeItem
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.ImagingStudy
import dev.ohs.fhir.model.r5.Immunization
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.MedicationDispense
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.SupplyDelivery
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [ChargeItem] resource type. */
public object ChargeItemSearchParam {
  /** All search parameters for the ChargeItem resource type. */
  public val ALL: List<SearchParam<ChargeItem, *>> =
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

  public data object Account : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.account"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Account::class)

    public override fun extract(resource: ChargeItem): List<Reference> = resource.account
  }

  public data object Code : SearchParam<ChargeItem, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<CodeableConcept> = listOf(resource.code)
  }

  public data object Encounter : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Encounter::class)

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object EnteredDate : SearchParam<ChargeItem, DateTime> {
    public override val paramName: String = "entered-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ChargeItem.enteredDate"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<DateTime> =
      listOfNotNull(resource.enteredDate)
  }

  public data object Enterer : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.enterer"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Organization::class,
        Device::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOfNotNull(resource.enterer)
  }

  public data object FactorOverride : SearchParam<ChargeItem, Decimal> {
    public override val paramName: String = "factor-override"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "ChargeItem.totalPriceComponent.factor"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<Decimal> =
      listOfNotNull(resource.totalPriceComponent?.factor)
  }

  public data object Identifier : SearchParam<ChargeItem, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Occurrence : SearchParam<ChargeItem, Any> {
    public override val paramName: String = "occurrence"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ChargeItem.occurrence.ofType(dateTime)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = emptyList()
  }

  public data object Patient : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object PerformerActor : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "performer-actor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.performer.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        HealthcareService::class,
        Organization::class,
        CareTeam::class,
        Device::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: ChargeItem): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object PerformerFunction : SearchParam<ChargeItem, CodeableConcept> {
    public override val paramName: String = "performer-function"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.performer.function"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<CodeableConcept> =
      resource.performer.mapNotNull { it.function }
  }

  public data object PerformingOrganization : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "performing-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.performingOrganization"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOfNotNull(resource.performingOrganization)
  }

  public data object PriceOverride : SearchParam<ChargeItem, Money> {
    public override val paramName: String = "price-override"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "ChargeItem.totalPriceComponent.amount"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<Money> =
      listOfNotNull(resource.totalPriceComponent?.amount)
  }

  public data object Quantity : SearchParam<ChargeItem, dev.ohs.fhir.model.r5.Quantity> {
    public override val paramName: String = "quantity"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "ChargeItem.quantity"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<dev.ohs.fhir.model.r5.Quantity> =
      listOfNotNull(resource.quantity)
  }

  public data object RequestingOrganization : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "requesting-organization"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.requestingOrganization"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: ChargeItem): List<Reference> =
      listOfNotNull(resource.requestingOrganization)
  }

  public data object Service : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "service"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.service.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(
        SupplyDelivery::class,
        ImagingStudy::class,
        Procedure::class,
        Observation::class,
        ServiceRequest::class,
        MedicationAdministration::class,
        DiagnosticReport::class,
        Immunization::class,
        MedicationRequest::class,
        MedicationDispense::class,
      )

    public override fun extract(resource: ChargeItem): List<Reference> =
      resource.service.mapNotNull { it.reference }
  }

  public data object Status : SearchParam<ChargeItem, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ChargeItem.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ChargeItem): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<ChargeItem, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ChargeItem.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: ChargeItem): List<Reference> = listOf(resource.subject)
  }
}
