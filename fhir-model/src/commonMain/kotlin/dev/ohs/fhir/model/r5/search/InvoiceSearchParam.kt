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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Invoice
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Invoice] resource type. */
public object InvoiceSearchParam {
  public val Account: SearchParam<Invoice, Reference> =
    SimpleSearchParam<Invoice, Reference>(
      name = "account",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.account",
      target = listOf(dev.ohs.fhir.model.r5.Account::class),
      extractor = { resource -> listOfNotNull(resource.account) },
    )

  public val Date: SearchParam<Invoice, DateTime> =
    SimpleSearchParam<Invoice, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "Invoice.date",
      extractor = { resource -> listOfNotNull(resource.date) },
    )

  public val Identifier: SearchParam<Invoice, Identifier> =
    SimpleSearchParam<Invoice, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Invoice.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Issuer: SearchParam<Invoice, Reference> =
    SimpleSearchParam<Invoice, Reference>(
      name = "issuer",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.issuer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.issuer) },
    )

  public val Participant: SearchParam<Invoice, Reference> =
    SimpleSearchParam<Invoice, Reference>(
      name = "participant",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.participant.actor",
      target =
        listOf(
          Organization::class,
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> resource.participant.map { it.actor } },
    )

  public val ParticipantRole: SearchParam<Invoice, CodeableConcept> =
    SimpleSearchParam<Invoice, CodeableConcept>(
      name = "participant-role",
      type = SearchParamType.fromCode("token"),
      expression = "Invoice.participant.role",
      extractor = { resource -> resource.participant.mapNotNull { it.role } },
    )

  public val Patient: SearchParam<Invoice, Reference> =
    SimpleSearchParam<Invoice, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.subject.where(resolve() is Patient)",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource ->
        listOfNotNull(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val Recipient: SearchParam<Invoice, Reference> =
    SimpleSearchParam<Invoice, Reference>(
      name = "recipient",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.recipient",
      target =
        listOf(Organization::class, RelatedPerson::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOfNotNull(resource.recipient) },
    )

  public val Status: SearchParam<Invoice, Any> =
    SimpleSearchParam<Invoice, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Invoice.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Subject: SearchParam<Invoice, Reference> =
    SimpleSearchParam<Invoice, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "Invoice.subject",
      target = listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOfNotNull(resource.subject) },
    )

  public val Totalgross: SearchParam<Invoice, Money> =
    SimpleSearchParam<Invoice, Money>(
      name = "totalgross",
      type = SearchParamType.fromCode("quantity"),
      expression = "Invoice.totalGross",
      extractor = { resource -> listOfNotNull(resource.totalGross) },
    )

  public val Totalnet: SearchParam<Invoice, Money> =
    SimpleSearchParam<Invoice, Money>(
      name = "totalnet",
      type = SearchParamType.fromCode("quantity"),
      expression = "Invoice.totalNet",
      extractor = { resource -> listOfNotNull(resource.totalNet) },
    )

  public val Type: SearchParam<Invoice, CodeableConcept> =
    SimpleSearchParam<Invoice, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Invoice.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the Invoice resource type. */
  public val ALL: List<SearchParam<Invoice, *>> =
    listOf(
      Account,
      Date,
      Identifier,
      Issuer,
      Participant,
      ParticipantRole,
      Patient,
      Recipient,
      Status,
      Subject,
      Totalgross,
      Totalnet,
      Type,
    )
}
