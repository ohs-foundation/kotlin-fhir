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
import dev.ohs.fhir.model.r5.Identifier
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
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.ServiceRequest
import dev.ohs.fhir.model.r5.SupplyDelivery
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ChargeItem] resource type. */
public object ChargeItemSearchParams {
  public val Account: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "account",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.account",
      target = listOf(dev.ohs.fhir.model.r5.Account::class),
      extractor = { resource -> resource.account },
    )

  public val Code: SearchParam<ChargeItem, CodeableConcept> =
    SimpleSearchParam<ChargeItem, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItem.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val Encounter: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.encounter",
      target = listOf(dev.ohs.fhir.model.r5.Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val EnteredDate: SearchParam<ChargeItem, DateTime> =
    SimpleSearchParam<ChargeItem, DateTime>(
      name = "entered-date",
      type = SearchParamType.fromCode("date"),
      expression = "ChargeItem.enteredDate",
      extractor = { resource -> listOfNotNull(resource.enteredDate) },
    )

  public val Enterer: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "enterer",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.enterer",
      target =
        listOf(
          Organization::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val FactorOverride: SearchParam<ChargeItem, Decimal> =
    SimpleSearchParam<ChargeItem, Decimal>(
      name = "factor-override",
      type = SearchParamType.fromCode("number"),
      expression = "ChargeItem.totalPriceComponent.factor",
      extractor = { resource -> listOfNotNull(resource.totalPriceComponent?.factor) },
    )

  public val Identifier: SearchParam<ChargeItem, Identifier> =
    SimpleSearchParam<ChargeItem, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItem.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Occurrence: SearchParam<ChargeItem, Any> =
    SimpleSearchParam<ChargeItem, Any>(
      name = "occurrence",
      type = SearchParamType.fromCode("date"),
      expression = "ChargeItem.occurrence.ofType(dateTime)",
      extractor = { emptyList() },
    )

  public val Patient: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val PerformerActor: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "performer-actor",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.performer.actor",
      target =
        listOf(
          HealthcareService::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val PerformerFunction: SearchParam<ChargeItem, CodeableConcept> =
    SimpleSearchParam<ChargeItem, CodeableConcept>(
      name = "performer-function",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItem.performer.function",
      extractor = { resource -> resource.performer.mapNotNull { it.function } },
    )

  public val PerformingOrganization: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "performing-organization",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.performingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.performingOrganization) },
    )

  public val PriceOverride: SearchParam<ChargeItem, Money> =
    SimpleSearchParam<ChargeItem, Money>(
      name = "price-override",
      type = SearchParamType.fromCode("quantity"),
      expression = "ChargeItem.totalPriceComponent.amount",
      extractor = { resource -> listOfNotNull(resource.totalPriceComponent?.amount) },
    )

  public val Quantity: SearchParam<ChargeItem, Quantity> =
    SimpleSearchParam<ChargeItem, Quantity>(
      name = "quantity",
      type = SearchParamType.fromCode("quantity"),
      expression = "ChargeItem.quantity",
      extractor = { resource -> listOfNotNull(resource.quantity) },
    )

  public val RequestingOrganization: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "requesting-organization",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.requestingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.requestingOrganization) },
    )

  public val Service: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "service",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.service.reference",
      target =
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
        ),
      extractor = { resource -> resource.service.mapNotNull { it.reference } },
    )

  public val Status: SearchParam<ChargeItem, Any> =
    SimpleSearchParam<ChargeItem, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItem.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

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
}
