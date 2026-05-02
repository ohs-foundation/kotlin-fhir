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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Invoice
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.MonetaryComponent
import com.google.fhir.model.r5.Money
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class InvoiceParticipantSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var role: CodeableConcept? = null,
  public var actor: Reference,
) {
  public fun toModel(): Invoice.Participant =
    Invoice.Participant(
      id = this@InvoiceParticipantSurrogate.id,
      extension = this@InvoiceParticipantSurrogate.extension ?: listOf(),
      modifierExtension = this@InvoiceParticipantSurrogate.modifierExtension ?: listOf(),
      role = this@InvoiceParticipantSurrogate.role,
      actor = this@InvoiceParticipantSurrogate.actor,
    )

  public companion object {
    public fun fromModel(model: Invoice.Participant): InvoiceParticipantSurrogate =
      with(model) {
        InvoiceParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          role = this@with.role,
          actor = this@with.actor,
        )
      }
  }
}

@Serializable
internal data class InvoiceLineItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var serviced: Invoice.LineItem.Serviced? = null,
  public var chargeItem: Invoice.LineItem.ChargeItem,
  public var priceComponent: List<MonetaryComponent>? = null,
) {
  public fun toModel(): Invoice.LineItem =
    Invoice.LineItem(
      id = this@InvoiceLineItemSurrogate.id,
      extension = this@InvoiceLineItemSurrogate.extension ?: listOf(),
      modifierExtension = this@InvoiceLineItemSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@InvoiceLineItemSurrogate.sequence,
          this@InvoiceLineItemSurrogate._sequence,
        ),
      serviced = this@InvoiceLineItemSurrogate.serviced,
      chargeItem = this@InvoiceLineItemSurrogate.chargeItem,
      priceComponent = this@InvoiceLineItemSurrogate.priceComponent ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Invoice.LineItem): InvoiceLineItemSurrogate =
      with(model) {
        InvoiceLineItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence?.value,
          _sequence = this@with.sequence?.toElement(),
          serviced = this@with.serviced,
          chargeItem = this@with.chargeItem,
          priceComponent = this@with.priceComponent.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class InvoicePeriodSurrogate(
  public var periodDate: KotlinString? = null,
  public var _periodDate: Element? = null,
  public var periodPeriod: Period? = null,
) {
  public fun toModel(): Invoice.Period =
    Invoice.Period.from(
      Date.of(
        FhirDate.fromString(this@InvoicePeriodSurrogate.periodDate),
        this@InvoicePeriodSurrogate._periodDate,
      ),
      this@InvoicePeriodSurrogate.periodPeriod,
    )!!

  public companion object {
    public fun fromModel(model: Invoice.Period): InvoicePeriodSurrogate =
      with(model) {
        InvoicePeriodSurrogate(
          periodDate = this@with.asDate()?.value?.value?.toString(),
          _periodDate = this@with.asDate()?.value?.toElement(),
          periodPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class InvoiceLineItemServicedSurrogate(
  public var servicedDate: KotlinString? = null,
  public var _servicedDate: Element? = null,
  public var servicedPeriod: Period? = null,
) {
  public fun toModel(): Invoice.LineItem.Serviced =
    Invoice.LineItem.Serviced.from(
      Date.of(
        FhirDate.fromString(this@InvoiceLineItemServicedSurrogate.servicedDate),
        this@InvoiceLineItemServicedSurrogate._servicedDate,
      ),
      this@InvoiceLineItemServicedSurrogate.servicedPeriod,
    )!!

  public companion object {
    public fun fromModel(model: Invoice.LineItem.Serviced): InvoiceLineItemServicedSurrogate =
      with(model) {
        InvoiceLineItemServicedSurrogate(
          servicedDate = this@with.asDate()?.value?.value?.toString(),
          _servicedDate = this@with.asDate()?.value?.toElement(),
          servicedPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class InvoiceLineItemChargeItemSurrogate(
  public var chargeItemReference: Reference? = null,
  public var chargeItemCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): Invoice.LineItem.ChargeItem =
    Invoice.LineItem.ChargeItem.from(
      this@InvoiceLineItemChargeItemSurrogate.chargeItemReference,
      this@InvoiceLineItemChargeItemSurrogate.chargeItemCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(model: Invoice.LineItem.ChargeItem): InvoiceLineItemChargeItemSurrogate =
      with(model) {
        InvoiceLineItemChargeItemSurrogate(
          chargeItemReference = this@with.asReference()?.value,
          chargeItemCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class InvoiceSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var cancelledReason: KotlinString? = null,
  public var _cancelledReason: Element? = null,
  public var type: CodeableConcept? = null,
  public var subject: Reference? = null,
  public var recipient: Reference? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var creation: KotlinString? = null,
  public var _creation: Element? = null,
  public var period: Invoice.Period? = null,
  public var participant: List<Invoice.Participant>? = null,
  public var issuer: Reference? = null,
  public var account: Reference? = null,
  public var lineItem: List<Invoice.LineItem>? = null,
  public var totalPriceComponent: List<MonetaryComponent>? = null,
  public var totalNet: Money? = null,
  public var totalGross: Money? = null,
  public var paymentTerms: KotlinString? = null,
  public var _paymentTerms: Element? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): Invoice =
    Invoice(
      id = this@InvoiceSurrogate.id,
      meta = this@InvoiceSurrogate.meta,
      implicitRules =
        Uri.of(this@InvoiceSurrogate.implicitRules, this@InvoiceSurrogate._implicitRules),
      language = Code.of(this@InvoiceSurrogate.language, this@InvoiceSurrogate._language),
      text = this@InvoiceSurrogate.text,
      contained = this@InvoiceSurrogate.contained ?: listOf(),
      extension = this@InvoiceSurrogate.extension ?: listOf(),
      modifierExtension = this@InvoiceSurrogate.modifierExtension ?: listOf(),
      identifier = this@InvoiceSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          Invoice.InvoiceStatus.fromCode(this@InvoiceSurrogate.status!!),
          this@InvoiceSurrogate._status,
        ),
      cancelledReason =
        R5String.of(this@InvoiceSurrogate.cancelledReason, this@InvoiceSurrogate._cancelledReason),
      type = this@InvoiceSurrogate.type,
      subject = this@InvoiceSurrogate.subject,
      recipient = this@InvoiceSurrogate.recipient,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@InvoiceSurrogate.date),
          this@InvoiceSurrogate._date,
        ),
      creation =
        DateTime.of(
          FhirDateTime.fromString(this@InvoiceSurrogate.creation),
          this@InvoiceSurrogate._creation,
        ),
      period = this@InvoiceSurrogate.period,
      participant = this@InvoiceSurrogate.participant ?: listOf(),
      issuer = this@InvoiceSurrogate.issuer,
      account = this@InvoiceSurrogate.account,
      lineItem = this@InvoiceSurrogate.lineItem ?: listOf(),
      totalPriceComponent = this@InvoiceSurrogate.totalPriceComponent ?: listOf(),
      totalNet = this@InvoiceSurrogate.totalNet,
      totalGross = this@InvoiceSurrogate.totalGross,
      paymentTerms =
        Markdown.of(this@InvoiceSurrogate.paymentTerms, this@InvoiceSurrogate._paymentTerms),
      note = this@InvoiceSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Invoice): InvoiceSurrogate =
      with(model) {
        InvoiceSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          cancelledReason = this@with.cancelledReason?.value,
          _cancelledReason = this@with.cancelledReason?.toElement(),
          type = this@with.type,
          subject = this@with.subject,
          recipient = this@with.recipient,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          creation = this@with.creation?.value?.toString(),
          _creation = this@with.creation?.toElement(),
          period = this@with.period,
          participant = this@with.participant.takeIf { it.isNotEmpty() },
          issuer = this@with.issuer,
          account = this@with.account,
          lineItem = this@with.lineItem.takeIf { it.isNotEmpty() },
          totalPriceComponent = this@with.totalPriceComponent.takeIf { it.isNotEmpty() },
          totalNet = this@with.totalNet,
          totalGross = this@with.totalGross,
          paymentTerms = this@with.paymentTerms?.value,
          _paymentTerms = this@with.paymentTerms?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
