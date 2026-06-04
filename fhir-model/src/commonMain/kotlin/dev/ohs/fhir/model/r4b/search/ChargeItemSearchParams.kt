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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.CareTeam
import dev.ohs.fhir.model.r4b.ChargeItem
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.DiagnosticReport
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.EpisodeOfCare
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ImagingStudy
import dev.ohs.fhir.model.r4b.Immunization
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.MedicationDispense
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Observation
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Procedure
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.SupplyDelivery
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ChargeItem] resource type. */
public object ChargeItemSearchParams {
  public val Account: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "account",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.account",
      target = listOf(dev.ohs.fhir.model.r4b.Account::class),
      extractor = { resource -> resource.account },
    )

  public val Code: SearchParam<ChargeItem, CodeableConcept> =
    SimpleSearchParam<ChargeItem, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItem.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val Context: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "context",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.context",
      target = listOf(EpisodeOfCare::class, Encounter::class),
      extractor = { resource -> listOfNotNull(resource.context) },
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
          Practitioner::class,
          Organization::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val FactorOverride: SearchParam<ChargeItem, Decimal> =
    SimpleSearchParam<ChargeItem, Decimal>(
      name = "factor-override",
      type = SearchParamType.fromCode("number"),
      expression = "ChargeItem.factorOverride",
      extractor = { resource -> listOfNotNull(resource.factorOverride) },
    )

  public val Identifier: SearchParam<ChargeItem, Identifier> =
    SimpleSearchParam<ChargeItem, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ChargeItem.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Occurrence: SearchParam<ChargeItem, ChargeItem.Occurrence> =
    SimpleSearchParam<ChargeItem, ChargeItem.Occurrence>(
      name = "occurrence",
      type = SearchParamType.fromCode("date"),
      expression = "ChargeItem.occurrence",
      extractor = { resource -> listOfNotNull(resource.occurrence) },
    )

  public val Patient: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r4b.Patient::class),
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
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          dev.ohs.fhir.model.r4b.Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
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
      expression = "ChargeItem.priceOverride",
      extractor = { resource -> listOfNotNull(resource.priceOverride) },
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
      expression = "ChargeItem.service",
      target =
        listOf(
          Immunization::class,
          MedicationDispense::class,
          SupplyDelivery::class,
          Observation::class,
          DiagnosticReport::class,
          ImagingStudy::class,
          MedicationAdministration::class,
          Procedure::class,
        ),
      extractor = { resource -> resource.service },
    )

  public val Subject: SearchParam<ChargeItem, Reference> =
    SimpleSearchParam<ChargeItem, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "ChargeItem.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r4b.Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the ChargeItem resource type. */
  public val ALL: List<SearchParam<ChargeItem, *>> =
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
