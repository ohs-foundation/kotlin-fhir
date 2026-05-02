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

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Money
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.PaymentReconciliation
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.NoteType
import com.google.fhir.model.r4b.terminologies.RemittanceOutcome
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class PaymentReconciliationDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var predecessor: Identifier? = null,
  public var type: CodeableConcept,
  public var request: Reference? = null,
  public var submitter: Reference? = null,
  public var response: Reference? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var responsible: Reference? = null,
  public var payee: Reference? = null,
  public var amount: Money? = null,
) {
  public fun toModel(): PaymentReconciliation.Detail =
    PaymentReconciliation.Detail(
      id = this@PaymentReconciliationDetailSurrogate.id,
      extension = this@PaymentReconciliationDetailSurrogate.extension ?: listOf(),
      modifierExtension = this@PaymentReconciliationDetailSurrogate.modifierExtension ?: listOf(),
      identifier = this@PaymentReconciliationDetailSurrogate.identifier,
      predecessor = this@PaymentReconciliationDetailSurrogate.predecessor,
      type = this@PaymentReconciliationDetailSurrogate.type,
      request = this@PaymentReconciliationDetailSurrogate.request,
      submitter = this@PaymentReconciliationDetailSurrogate.submitter,
      response = this@PaymentReconciliationDetailSurrogate.response,
      date =
        Date.of(
          FhirDate.fromString(this@PaymentReconciliationDetailSurrogate.date),
          this@PaymentReconciliationDetailSurrogate._date,
        ),
      responsible = this@PaymentReconciliationDetailSurrogate.responsible,
      payee = this@PaymentReconciliationDetailSurrogate.payee,
      amount = this@PaymentReconciliationDetailSurrogate.amount,
    )

  public companion object {
    public fun fromModel(
      model: PaymentReconciliation.Detail
    ): PaymentReconciliationDetailSurrogate =
      with(model) {
        PaymentReconciliationDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier,
          predecessor = this@with.predecessor,
          type = this@with.type,
          request = this@with.request,
          submitter = this@with.submitter,
          response = this@with.response,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          responsible = this@with.responsible,
          payee = this@with.payee,
          amount = this@with.amount,
        )
      }
  }
}

@Serializable
internal data class PaymentReconciliationProcessNoteSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
) {
  public fun toModel(): PaymentReconciliation.ProcessNote =
    PaymentReconciliation.ProcessNote(
      id = this@PaymentReconciliationProcessNoteSurrogate.id,
      extension = this@PaymentReconciliationProcessNoteSurrogate.extension ?: listOf(),
      modifierExtension =
        this@PaymentReconciliationProcessNoteSurrogate.modifierExtension ?: listOf(),
      type =
        this@PaymentReconciliationProcessNoteSurrogate.type?.let {
          Enumeration.of(
            NoteType.fromCode(it),
            this@PaymentReconciliationProcessNoteSurrogate._type,
          )
        },
      text =
        R4bString.of(
          this@PaymentReconciliationProcessNoteSurrogate.text,
          this@PaymentReconciliationProcessNoteSurrogate._text,
        ),
    )

  public companion object {
    public fun fromModel(
      model: PaymentReconciliation.ProcessNote
    ): PaymentReconciliationProcessNoteSurrogate =
      with(model) {
        PaymentReconciliationProcessNoteSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type?.value?.getCode(),
          _type = this@with.type?.toElement(),
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
        )
      }
  }
}

@Serializable
internal data class PaymentReconciliationSurrogate(
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
  public var period: Period? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var paymentIssuer: Reference? = null,
  public var request: Reference? = null,
  public var requestor: Reference? = null,
  public var outcome: KotlinString? = null,
  public var _outcome: Element? = null,
  public var disposition: KotlinString? = null,
  public var _disposition: Element? = null,
  public var paymentDate: KotlinString? = null,
  public var _paymentDate: Element? = null,
  public var paymentAmount: Money,
  public var paymentIdentifier: Identifier? = null,
  public var detail: List<PaymentReconciliation.Detail>? = null,
  public var formCode: CodeableConcept? = null,
  public var processNote: List<PaymentReconciliation.ProcessNote>? = null,
) {
  public fun toModel(): PaymentReconciliation =
    PaymentReconciliation(
      id = this@PaymentReconciliationSurrogate.id,
      meta = this@PaymentReconciliationSurrogate.meta,
      implicitRules =
        Uri.of(
          this@PaymentReconciliationSurrogate.implicitRules,
          this@PaymentReconciliationSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@PaymentReconciliationSurrogate.language,
          this@PaymentReconciliationSurrogate._language,
        ),
      text = this@PaymentReconciliationSurrogate.text,
      contained = this@PaymentReconciliationSurrogate.contained ?: listOf(),
      extension = this@PaymentReconciliationSurrogate.extension ?: listOf(),
      modifierExtension = this@PaymentReconciliationSurrogate.modifierExtension ?: listOf(),
      identifier = this@PaymentReconciliationSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          PaymentReconciliation.FinancialResourceStatusCodes.fromCode(
            this@PaymentReconciliationSurrogate.status!!
          ),
          this@PaymentReconciliationSurrogate._status,
        ),
      period = this@PaymentReconciliationSurrogate.period,
      created =
        DateTime.of(
          FhirDateTime.fromString(this@PaymentReconciliationSurrogate.created),
          this@PaymentReconciliationSurrogate._created,
        )!!,
      paymentIssuer = this@PaymentReconciliationSurrogate.paymentIssuer,
      request = this@PaymentReconciliationSurrogate.request,
      requestor = this@PaymentReconciliationSurrogate.requestor,
      outcome =
        this@PaymentReconciliationSurrogate.outcome?.let {
          Enumeration.of(
            RemittanceOutcome.fromCode(it),
            this@PaymentReconciliationSurrogate._outcome,
          )
        },
      disposition =
        R4bString.of(
          this@PaymentReconciliationSurrogate.disposition,
          this@PaymentReconciliationSurrogate._disposition,
        ),
      paymentDate =
        Date.of(
          FhirDate.fromString(this@PaymentReconciliationSurrogate.paymentDate),
          this@PaymentReconciliationSurrogate._paymentDate,
        )!!,
      paymentAmount = this@PaymentReconciliationSurrogate.paymentAmount,
      paymentIdentifier = this@PaymentReconciliationSurrogate.paymentIdentifier,
      detail = this@PaymentReconciliationSurrogate.detail ?: listOf(),
      formCode = this@PaymentReconciliationSurrogate.formCode,
      processNote = this@PaymentReconciliationSurrogate.processNote ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: PaymentReconciliation): PaymentReconciliationSurrogate =
      with(model) {
        PaymentReconciliationSurrogate(
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
          period = this@with.period,
          created = this@with.created.value?.toString(),
          _created = this@with.created.toElement(),
          paymentIssuer = this@with.paymentIssuer,
          request = this@with.request,
          requestor = this@with.requestor,
          outcome = this@with.outcome?.value?.getCode(),
          _outcome = this@with.outcome?.toElement(),
          disposition = this@with.disposition?.value,
          _disposition = this@with.disposition?.toElement(),
          paymentDate = this@with.paymentDate.value?.toString(),
          _paymentDate = this@with.paymentDate.toElement(),
          paymentAmount = this@with.paymentAmount,
          paymentIdentifier = this@with.paymentIdentifier,
          detail = this@with.detail.takeIf { it.isNotEmpty() },
          formCode = this@with.formCode,
          processNote = this@with.processNote.takeIf { it.isNotEmpty() },
        )
      }
  }
}
