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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.Account
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
import dev.ohs.fhir.model.r4b.Patient
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
  public val account: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "account",
      type = SearchParamType.Reference,
      expression = "ChargeItem.account",
      target = listOf(Account::class),
      extractor = { resource -> resource.account },
    )

  public val code: SearchParam<ChargeItem, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "ChargeItem.code",
      extractor = { resource -> listOf(resource.code) },
    )

  public val context: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "context",
      type = SearchParamType.Reference,
      expression = "ChargeItem.context",
      target = listOf(EpisodeOfCare::class, Encounter::class),
      extractor = { resource -> listOfNotNull(resource.context) },
    )

  public val enteredDate: SearchParam<ChargeItem, DateTime> =
    SearchParam(
      name = "entered-date",
      type = SearchParamType.Date,
      expression = "ChargeItem.enteredDate",
      extractor = { resource -> listOfNotNull(resource.enteredDate) },
    )

  public val enterer: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "enterer",
      type = SearchParamType.Reference,
      expression = "ChargeItem.enterer",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val factorOverride: SearchParam<ChargeItem, Decimal> =
    SearchParam(
      name = "factor-override",
      type = SearchParamType.Number,
      expression = "ChargeItem.factorOverride",
      extractor = { resource -> listOfNotNull(resource.factorOverride) },
    )

  public val identifier: SearchParam<ChargeItem, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ChargeItem.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val occurrence: SearchParam<ChargeItem, ChargeItem.Occurrence> =
    SearchParam(
      name = "occurrence",
      type = SearchParamType.Date,
      expression = "ChargeItem.occurrence",
      extractor = { resource -> listOfNotNull(resource.occurrence) },
    )

  public val patient: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "ChargeItem.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter { it.reference?.value?.contains("Patient/") == true }
      },
    )

  public val performerActor: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "performer-actor",
      type = SearchParamType.Reference,
      expression = "ChargeItem.performer.actor",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.performer.map { it.actor } },
    )

  public val performerFunction: SearchParam<ChargeItem, CodeableConcept> =
    SearchParam(
      name = "performer-function",
      type = SearchParamType.Token,
      expression = "ChargeItem.performer.function",
      extractor = { resource -> resource.performer.mapNotNull { it.function } },
    )

  public val performingOrganization: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "performing-organization",
      type = SearchParamType.Reference,
      expression = "ChargeItem.performingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.performingOrganization) },
    )

  public val priceOverride: SearchParam<ChargeItem, Money> =
    SearchParam(
      name = "price-override",
      type = SearchParamType.Quantity,
      expression = "ChargeItem.priceOverride",
      extractor = { resource -> listOfNotNull(resource.priceOverride) },
    )

  public val quantity: SearchParam<ChargeItem, Quantity> =
    SearchParam(
      name = "quantity",
      type = SearchParamType.Quantity,
      expression = "ChargeItem.quantity",
      extractor = { resource -> listOfNotNull(resource.quantity) },
    )

  public val requestingOrganization: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "requesting-organization",
      type = SearchParamType.Reference,
      expression = "ChargeItem.requestingOrganization",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.requestingOrganization) },
    )

  public val service: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "service",
      type = SearchParamType.Reference,
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

  public val subject: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "ChargeItem.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ChargeItem, *>> = listOf()

  /**
   * Supported search parameters for the ChargeItem resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ChargeItem, *>> =
    listOf(
      account,
      code,
      context,
      enteredDate,
      enterer,
      factorOverride,
      identifier,
      occurrence,
      patient,
      performerActor,
      performerFunction,
      performingOrganization,
      priceOverride,
      quantity,
      requestingOrganization,
      service,
      subject,
    )
}
