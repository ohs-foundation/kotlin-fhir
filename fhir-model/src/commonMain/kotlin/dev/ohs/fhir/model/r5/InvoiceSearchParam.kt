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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Invoice] resource type. */
public sealed class InvoiceSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Invoice): List<T>

  public data object Account : InvoiceSearchParam<Reference>() {
    public override val paramName: String = "account"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Invoice.account"

    public override val target: List<String> = listOf("Account")

    public override fun extract(resource: Invoice): List<Reference> =
      listOfNotNull(resource.account)
  }

  public data object Date : InvoiceSearchParam<DateTime>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Invoice.date"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Invoice): List<DateTime> = listOfNotNull(resource.date)
  }

  public data object Identifier : InvoiceSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Invoice.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Invoice): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Issuer : InvoiceSearchParam<Reference>() {
    public override val paramName: String = "issuer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Invoice.issuer"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Invoice): List<Reference> = listOfNotNull(resource.issuer)
  }

  public data object Participant : InvoiceSearchParam<Reference>() {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Invoice.participant.actor"

    public override val target: List<String> =
      listOf(
        "Organization",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: Invoice): List<Reference> =
      resource.participant.map { it.actor }
  }

  public data object ParticipantRole : InvoiceSearchParam<CodeableConcept>() {
    public override val paramName: String = "participant-role"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Invoice.participant.role"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Invoice): List<CodeableConcept> =
      resource.participant.mapNotNull { it.role }
  }

  public data object Patient : InvoiceSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Invoice.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Invoice): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Recipient : InvoiceSearchParam<Reference>() {
    public override val paramName: String = "recipient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Invoice.recipient"

    public override val target: List<String> = listOf("Organization", "RelatedPerson", "Patient")

    public override fun extract(resource: Invoice): List<Reference> =
      listOfNotNull(resource.recipient)
  }

  public data object Status : InvoiceSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Invoice.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Invoice): List<Any> = listOf(resource.status)
  }

  public data object Subject : InvoiceSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Invoice.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: Invoice): List<Reference> =
      listOfNotNull(resource.subject)
  }

  public data object Totalgross : InvoiceSearchParam<Money>() {
    public override val paramName: String = "totalgross"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Invoice.totalGross"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Invoice): List<Money> = listOfNotNull(resource.totalGross)
  }

  public data object Totalnet : InvoiceSearchParam<Money>() {
    public override val paramName: String = "totalnet"

    public override val type: SearchParamType = SearchParamType.fromCode("quantity")

    public override val expression: String = "Invoice.totalNet"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Invoice): List<Money> = listOfNotNull(resource.totalNet)
  }

  public data object Type : InvoiceSearchParam<CodeableConcept>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Invoice.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Invoice): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public companion object {
    /** All search parameters for the Invoice resource type. */
    public val ALL: List<InvoiceSearchParam<*>> =
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
}
