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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.PaymentReconciliation
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.NoteType
import dev.ohs.fhir.model.r4b.terminologies.RemittanceOutcome
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object PaymentReconciliationDetailSerializer : KSerializer<PaymentReconciliation.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("predecessor", IdentifierSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("request", ReferenceSerializer.descriptor)
      optionalElement("submitter", ReferenceSerializer.descriptor)
      optionalElement("response", ReferenceSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("responsible", ReferenceSerializer.descriptor)
      optionalElement("payee", ReferenceSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PaymentReconciliation.Detail>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Detail =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: Identifier? = null
      var predecessor: Identifier? = null
      var type: CodeableConcept? = null
      var request: Reference? = null
      var submitter: Reference? = null
      var response: Reference? = null
      var date: KotlinString? = null
      var _date: Element? = null
      var responsible: Reference? = null
      var payee: Reference? = null
      var amount: Money? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 ->
            predecessor =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> request = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 ->
            submitter = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            response = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 -> date = decodeStringElement(descriptor, i)
          10 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            responsible =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          12 -> payee = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          13 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Detail: " + i)
        }
      }
      PaymentReconciliation.Detail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier,
        predecessor = predecessor,
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on PaymentReconciliation.Detail"
            ),
        request = request,
        submitter = submitter,
        response = response,
        date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
        responsible = responsible,
        payee = payee,
        amount = amount,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Detail) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, IdentifierSerializer, value.identifier)
      encodeSerializableIfNotNull(descriptor, 4, IdentifierSerializer, value.predecessor)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.request)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.submitter)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.response)
      encodeStringIfNotNull(descriptor, 9, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 10, value.date)
      encodeSerializableIfNotNull(descriptor, 11, ReferenceSerializer, value.responsible)
      encodeSerializableIfNotNull(descriptor, 12, ReferenceSerializer, value.payee)
      encodeSerializableIfNotNull(descriptor, 13, MoneySerializer, value.amount)
    }
  }
}

internal object PaymentReconciliationProcessNoteSerializer :
  KSerializer<PaymentReconciliation.ProcessNote> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProcessNote") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PaymentReconciliation.ProcessNote>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PaymentReconciliation.ProcessNote =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var text: KotlinString? = null
      var _text: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> text = decodeStringElement(descriptor, i)
          6 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ProcessNote: " + i)
        }
      }
      PaymentReconciliation.ProcessNote(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = Enumeration.of(if (type != null) NoteType.fromCode(type) else null, _type),
        text = R4bString.of(text, _text),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.ProcessNote) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.text?.value)
      encodeElementIfNotNull(descriptor, 6, value.text)
    }
  }
}

internal object PaymentReconciliationSerializer : FhirResourceSerializer<PaymentReconciliation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("PaymentReconciliation")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("created", KotlinString.serializer().descriptor)
    b.optionalElement("_created", ElementSerializer.descriptor)
    b.optionalElement("paymentIssuer", ReferenceSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.descriptor)
    b.optionalElement("requestor", ReferenceSerializer.descriptor)
    b.optionalElement("outcome", KotlinString.serializer().descriptor)
    b.optionalElement("_outcome", ElementSerializer.descriptor)
    b.optionalElement("disposition", KotlinString.serializer().descriptor)
    b.optionalElement("_disposition", ElementSerializer.descriptor)
    b.optionalElement("paymentDate", KotlinString.serializer().descriptor)
    b.optionalElement("_paymentDate", ElementSerializer.descriptor)
    b.optionalElement("paymentAmount", MoneySerializer.descriptor)
    b.optionalElement("paymentIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("detail", PaymentReconciliationDetailSerializer.listSerializer.descriptor)
    b.optionalElement("formCode", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "processNote",
      PaymentReconciliationProcessNoteSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): PaymentReconciliation {
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var period: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var paymentIssuer: Reference? = null
    var request: Reference? = null
    var requestor: Reference? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var paymentDate: KotlinString? = null
    var _paymentDate: Element? = null
    var paymentAmount: Money? = null
    var paymentIdentifier: Identifier? = null
    var detail: List<PaymentReconciliation.Detail>? = null
    var formCode: CodeableConcept? = null
    var processNote: List<PaymentReconciliation.ProcessNote>? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        14 -> created = decoder.decodeStringElement(descriptor, i)
        15 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          paymentIssuer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 -> outcome = decoder.decodeStringElement(descriptor, i)
        20 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> disposition = decoder.decodeStringElement(descriptor, i)
        22 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> paymentDate = decoder.decodeStringElement(descriptor, i)
        24 ->
          _paymentDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          paymentAmount =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        26 ->
          paymentIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        27 ->
          detail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PaymentReconciliationDetailSerializer.listSerializer,
              null,
            )
        28 ->
          formCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        29 ->
          processNote =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PaymentReconciliationProcessNoteSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding PaymentReconciliation: " + i)
      }
    }
    return PaymentReconciliation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) PaymentReconciliation.FinancialResourceStatusCodes.fromCode(status)
          else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on PaymentReconciliation"
          ),
      period = period,
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created)
          ?: throw SerializationException(
            "Missing required property 'created' on PaymentReconciliation"
          ),
      paymentIssuer = paymentIssuer,
      request = request,
      requestor = requestor,
      outcome =
        Enumeration.of(
          if (outcome != null) RemittanceOutcome.fromCode(outcome) else null,
          _outcome,
        ),
      disposition = R4bString.of(disposition, _disposition),
      paymentDate =
        Date.of(if (paymentDate != null) FhirDate.fromString(paymentDate) else null, _paymentDate)
          ?: throw SerializationException(
            "Missing required property 'paymentDate' on PaymentReconciliation"
          ),
      paymentAmount =
        paymentAmount
          ?: throw SerializationException(
            "Missing required property 'paymentAmount' on PaymentReconciliation"
          ),
      paymentIdentifier = paymentIdentifier,
      detail = detail ?: listOf(),
      formCode = formCode,
      processNote = processNote ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PaymentReconciliation,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.created.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.created)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.paymentIssuer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.request,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.requestor,
    )
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.outcome?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.outcome)
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.disposition?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.disposition)
    encoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.paymentDate.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.paymentDate)
    encoder.encodeSerializableElement(
      descriptor,
      25 + descriptorOffset,
      MoneySerializer,
      value.paymentAmount,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      IdentifierSerializer,
      value.paymentIdentifier,
    )
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        PaymentReconciliationDetailSerializer.listSerializer,
        value.detail,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      CodeableConceptSerializer,
      value.formCode,
    )
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        PaymentReconciliationProcessNoteSerializer.listSerializer,
        value.processNote,
      )
  }
}
