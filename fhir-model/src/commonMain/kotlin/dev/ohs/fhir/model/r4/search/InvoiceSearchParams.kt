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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Account
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Invoice
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Invoice] resource type. */
public object InvoiceSearchParams {
  public val account: SearchParam<Invoice, Reference> =
    SearchParam(
      name = "account",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.account",
      target = listOf(Account::class),
      extractor = { resource -> listOfNotNull(resource.account) },
    )

  public val date: SearchParam<Invoice, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Invoice.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val identifier: SearchParam<Invoice, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Invoice.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val issuer: SearchParam<Invoice, Reference> =
    SearchParam(
      name = "issuer",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.issuer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.issuer) },
    )

  public val participant: SearchParam<Invoice, Reference> =
    SearchParam(
      name = "participant",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.participant.actor",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Device::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> resource.participant.map { it.actor } },
    )

  public val participantRole: SearchParam<Invoice, CodeableConcept> =
    SearchParam(
      name = "participant-role",
      type = SearchParamType.fromCode("token"),
      expression = "Invoice.participant.role",
      extractor = { resource -> resource.participant.mapNotNull { it.role } },
    )

  public val patient: SearchParam<Invoice, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val recipient: SearchParam<Invoice, Reference> =
    SearchParam(
      name = "recipient",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.recipient",
      target = listOf(Organization::class, Patient::class, RelatedPerson::class),
      extractor = { resource -> listOfNotNull(resource.recipient) },
    )

  public val status: SearchParam<Invoice, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Invoice.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subject: SearchParam<Invoice, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val totalgross: SearchParam<Invoice, Money> =
    SearchParam(
      name = "totalgross",
      type = SearchParamType.fromCode("quantity"),
      expression = "Invoice.totalGross",
      extractor = { resource -> listOfNotNull(resource.totalGross) },
    )

  public val totalnet: SearchParam<Invoice, Money> =
    SearchParam(
      name = "totalnet",
      type = SearchParamType.fromCode("quantity"),
      expression = "Invoice.totalNet",
      extractor = { resource -> listOfNotNull(resource.totalNet) },
    )

  public val type: SearchParam<Invoice, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Invoice.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the Invoice resource type. */
  public val all: List<SearchParam<Invoice, *>> =
    listOf(
      account,
      date,
      identifier,
      issuer,
      participant,
      participantRole,
      patient,
      recipient,
      status,
      subject,
      totalgross,
      totalnet,
      type,
    )
}
