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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.PaymentReconciliation
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("predecessor", Identifier.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("request", Reference.serializer().descriptor, isOptional = true)
      element("submitter", Reference.serializer().descriptor, isOptional = true)
      element("response", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("responsible", Reference.serializer().descriptor, isOptional = true)
      element("payee", Reference.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Detail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Detail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PaymentReconciliation.Detail {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 ->
          predecessor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        7 ->
          submitter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        8 ->
          response =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        9 -> date = decoder.decodeStringElement(descriptor, i)
        10 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateSer, null)
        11 ->
          responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        12 ->
          payee = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        13 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    return PaymentReconciliation.Detail(
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
      date = Date.of(date?.let { FhirDate.fromString(it) }, _date),
      responsible = responsible,
      payee = payee,
      amount = amount,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PaymentReconciliation.Detail) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, it)
    }
    (value.predecessor)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.identifierSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, value.type)
    (value.request)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.requestSer, it)
    }
    (value.submitter)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.requestSer, it)
    }
    (value.response)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.requestSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.dateSer, it)
    }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.requestSer, it)
    }
    (value.payee)?.let { encoder.encodeSerializableElement(descriptor, 12, Hoisted.requestSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 13, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val requestSer: KSerializer<Reference> = Reference.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()
  }
}

internal object PaymentReconciliationProcessNoteSerializer :
  KSerializer<PaymentReconciliation.ProcessNote> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProcessNote") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.ProcessNote =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.ProcessNote) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PaymentReconciliation.ProcessNote {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> text = decoder.decodeStringElement(descriptor, i)
        6 -> _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + i)
      }
    }
    return PaymentReconciliation.ProcessNote(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type?.let { Enumeration.of(NoteType.fromCode(it), _type) },
      text = R4bString.of(text, _text),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PaymentReconciliation.ProcessNote,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object PaymentReconciliationSerializer : KSerializer<PaymentReconciliation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentReconciliation") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("paymentIssuer", Reference.serializer().descriptor, isOptional = true)
    b.element("request", Reference.serializer().descriptor, isOptional = true)
    b.element("requestor", Reference.serializer().descriptor, isOptional = true)
    b.element("outcome", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outcome", Element.serializer().descriptor, isOptional = true)
    b.element("disposition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_disposition", Element.serializer().descriptor, isOptional = true)
    b.element("paymentDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_paymentDate", Element.serializer().descriptor, isOptional = true)
    b.element("paymentAmount", Money.serializer().descriptor, isOptional = true)
    b.element("paymentIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element(
      "detail",
      listSerialDescriptor(lazyDescriptor { PaymentReconciliation.Detail.serializer().descriptor }),
      isOptional = true,
    )
    b.element("formCode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "processNote",
      listSerialDescriptor(
        lazyDescriptor { PaymentReconciliation.ProcessNote.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PaymentReconciliation")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        14 -> created = decoder.decodeStringElement(descriptor, i)
        15 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          paymentIssuer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.paymentIssuerSer, null)
        17 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.paymentIssuerSer, null)
        18 ->
          requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.paymentIssuerSer, null)
        19 -> outcome = decoder.decodeStringElement(descriptor, i)
        20 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> disposition = decoder.decodeStringElement(descriptor, i)
        22 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> paymentDate = decoder.decodeStringElement(descriptor, i)
        24 ->
          _paymentDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          paymentAmount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.paymentAmountSer, null)
        26 ->
          paymentIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        27 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        28 ->
          formCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.formCodeSer, null)
        29 ->
          processNote =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processNoteSer, null)
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
          PaymentReconciliation.FinancialResourceStatusCodes.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on PaymentReconciliation"
              )
          ),
          _status,
        ),
      period = period,
      created =
        DateTime.of(created?.let { FhirDateTime.fromString(it) }, _created)
          ?: throw SerializationException(
            "Missing required property 'created' on PaymentReconciliation"
          ),
      paymentIssuer = paymentIssuer,
      request = request,
      requestor = requestor,
      outcome = outcome?.let { Enumeration.of(RemittanceOutcome.fromCode(it), _outcome) },
      disposition = R4bString.of(disposition, _disposition),
      paymentDate =
        Date.of(paymentDate?.let { FhirDate.fromString(it) }, _paymentDate)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PaymentReconciliation,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.periodSer, it)
    }
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.paymentIssuer)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.paymentIssuerSer,
        it,
      )
    }
    (value.request)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.paymentIssuerSer,
        it,
      )
    }
    (value.requestor)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.paymentIssuerSer,
        it,
      )
    }
    ((value.outcome?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.outcome?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.disposition?.value))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.paymentDate.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.paymentDate.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      25 + descriptorOffset,
      Hoisted.paymentAmountSer,
      value.paymentAmount,
    )
    (value.paymentIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.detailSer,
        value.detail,
      )
    (value.formCode)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.formCodeSer, it)
    }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.processNoteSer,
        value.processNote,
      )
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val paymentIssuerSer: KSerializer<Reference> = Reference.serializer()

    public val paymentAmountSer: KSerializer<Money> = Money.serializer()

    public val detailSerInner: KSerializer<PaymentReconciliation.Detail> =
      PaymentReconciliation.Detail.serializer()

    public val detailSer: KSerializer<List<PaymentReconciliation.Detail>> =
      ListSerializer(Hoisted.detailSerInner)

    public val formCodeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val processNoteSerInner: KSerializer<PaymentReconciliation.ProcessNote> =
      PaymentReconciliation.ProcessNote.serializer()

    public val processNoteSer: KSerializer<List<PaymentReconciliation.ProcessNote>> =
      ListSerializer(Hoisted.processNoteSerInner)
  }
}

internal object PaymentReconciliationPolymorphicSerializer : KSerializer<PaymentReconciliation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentReconciliation") {
      PaymentReconciliationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation) {
    encoder.encodeStructure(descriptor) {
      PaymentReconciliationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation =
    decoder.decodeStructure(descriptor) {
      PaymentReconciliationSerializer.deserializeInternal(this, descriptor, 0)
    }
}
