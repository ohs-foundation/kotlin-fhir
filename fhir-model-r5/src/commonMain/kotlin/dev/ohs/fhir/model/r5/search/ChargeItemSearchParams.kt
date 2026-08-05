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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Account
import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.ChargeItem
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Encounter
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
import dev.ohs.fhir.model.r5.Patient
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
import kotlin.NotImplementedError
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

  public val encounter: SearchParam<ChargeItem, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "ChargeItem.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
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
          Organization::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val factorOverride: SearchParam<ChargeItem, Decimal> =
    SearchParam(
      name = "factor-override",
      type = SearchParamType.Number,
      expression = "ChargeItem.totalPriceComponent.factor",
      extractor = { resource -> listOfNotNull(resource.totalPriceComponent?.factor) },
    )

  public val identifier: SearchParam<ChargeItem, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ChargeItem.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val occurrence: SearchParam<ChargeItem, Any> =
    SearchParam(
      name = "occurrence",
      type = SearchParamType.Date,
      expression = "ChargeItem.occurrence.ofType(dateTime)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'occurrence' has expression 'ChargeItem.occurrence.ofType(dateTime)' which is not yet supported."
        )
      },
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
          HealthcareService::class,
          Organization::class,
          CareTeam::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
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
      expression = "ChargeItem.totalPriceComponent.amount",
      extractor = { resource -> listOfNotNull(resource.totalPriceComponent?.amount) },
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

  public val status: SearchParam<ChargeItem, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ChargeItem.status",
      extractor = { resource -> listOf(resource.status) },
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
  public val unsupported: List<SearchParam<ChargeItem, *>> = listOf(occurrence)

  /**
   * Supported search parameters for the ChargeItem resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<ChargeItem, *>> =
    listOf(
      account,
      code,
      encounter,
      enteredDate,
      enterer,
      factorOverride,
      identifier,
      patient,
      performerActor,
      performerFunction,
      performingOrganization,
      priceOverride,
      quantity,
      requestingOrganization,
      service,
      status,
      subject,
    )
}
